
## Verified Knowledge

### oVirt cloud-init API only accepts user-data (custom_script)

oVirt's VM initialization API exposes only a `custom_script` field (mapped to cloud-init
user-data). There is no supported path for passing `network_data` through the oVirt
initialization API. All network configuration — static IPs, DHCP tuning, routing,
DNS — must be embedded as `write_files` entries and `runcmd` scripts inside user-data.
This is different from providers like AWS and vSphere that support a separate network_data
document.

### OEL/RHEL 9: ifcfg format is disabled by default

The `ifcfg-rh` NetworkManager plugin is disabled by default on OEL/RHEL 9. Files written
to `/etc/sysconfig/network-scripts/` are silently ignored. Static IP configuration
written in ifcfg format during cloud-init will appear to succeed but the IP will never
be applied.

**Correct format**: NetworkManager keyfile at
`/etc/NetworkManager/system-connections/<name>.nmconnection` with permissions `0600`.
This format is supported on OEL/RHEL 7, 8, and 9.

### NIC names are unpredictable at provisioning time

The guest OS NIC name (e.g. `eth0`, `enp1s0`, `ens3`) depends on the PCI slot assigned
by oVirt/KVM, which is not known when cloud-init is being constructed. Using a hard-coded
NIC name in a NetworkManager keyfile will cause the profile to silently fail if the
actual NIC has a different name.

**Solution**: Use a glob in the `[match]` section of the NM keyfile:
```ini
[match]
interface-name=e*;
```
The `[match]` section (unlike `[connection] interface-name`) supports shell globs.
This catches `eth0`, `enp1s0`, `ens3`, etc.

### oVirt port security drops unicast DHCP OFFERs

oVirt's port security (anti-spoofing) enforces that DHCP responses must be broadcast.
NetworkManager's internal DHCP client does not set the BROADCAST flag in DHCPDISCOVER
packets by default, so DHCP OFFERs are sent unicast and silently dropped by oVirt.

**Solution**: Force NM to use `dhclient` as its DHCP backend by writing:
```ini
# /etc/NetworkManager/conf.d/90-morpheus-dhcp.conf
[main]
dhcp=dhclient
```
`dhclient` sets the BROADCAST flag by default and receives OFFERs correctly.

### Some minimal OEL 9 images use systemd-networkd, not NetworkManager

Minimal OEL 9 cloud images may not have NetworkManager installed. Writing NM keyfiles
has no effect on these images.

**Solution**: Write config for both NM and systemd-networkd, then detect at runtime
which stack is present and activate the appropriate one. Use
`RequestBroadcast=yes` in systemd-networkd `.network` files to handle the
oVirt broadcast requirement.

### Package operations in cloud-init cause OOM on OLVM

On OLVM VMs with limited RAM, package operations in cloud-init trigger large downloads
that exhaust memory and kill the cloud-init process before `runcmd` runs:

| Directive | Risk |
|-----------|------|
| `package_update: true` | yum/apt downloads 122–212 MB of metadata |
| `package_upgrade: true` | can upgrade the kernel and trigger an automatic reboot, killing agent install |
| `package_reboot_if_required: true` | explicitly reboots after kernel upgrades; same result |
| `packages:` list | even a single package causes dnf to load full repo metadata (~200 MB on OEL 9) |

All four are safe to suppress. Required packages (e.g. `curl`) are already present on
standard OLVM base images. Packages can be updated post-provisioning.

These suppressions are applied automatically in `enhanceCloudInitConfig`.

### write_files and runcmd must be merged, not replaced

Morpheus core may already include `write_files:` or `runcmd:` sections in the base
cloud-config. If the plugin simply appends a new `write_files:` or `runcmd:` section,
cloud-init will only process the last one (YAML does not allow duplicate keys).

**Solution**: Use regex replace to inject additional entries into existing sections.
If a section does not exist, append it. See `enhanceCloudInitConfig` for the pattern.

### CIDR resolution requires checking multiple sources

`primaryInterface.netmask` alone is unreliable. For IPAM pool allocations, the
assigned IP's subnet mask may reflect only the immediate subnet, not the wider
network prefix (e.g. a /22 pool assigns a /24-appearing netmask, breaking routing).

**Resolution priority in `resolveCidr()`**:
1. `primaryInterface.subnet?.prefixLength`
2. `primaryInterface.subnet?.cidr` (parse the `/N` suffix)
3. `primaryInterface.network?.cidr` (parse the `/N` suffix)
4. `netmaskToCidr(primaryInterface.netmask)` (fallback)
5. `/24` default (last resort, logs a warning)

Always configure the network CIDR in Morpheus when using IPAM pools.

### Provisioning lifecycle: checkServerReady is called once, in insertVm

`insertVm` calls `checkServerReady` (a spin-wait for `status=up`, up to ~150 seconds).
The Morpheus framework subsequently calls `getServerDetails`. Do **not** call
`checkServerReady` again there — the VM may be mid-reboot after cloud-init first boot,
which causes `checkServerReady` to time out and return failure even though provisioning
succeeded.

Use `getServerDetail` (a single direct API lookup) inside `getServerDetails` instead.

### IP resolution after provisioning

After `checkServerReady` returns `status=up`, resolve the VM's IP in this order:

1. OLVM guest agent reported IP (`serverDetails.ipV4`)
2. Static interface IP from `runConfig.networkConfig.primaryInterface.ipAddress`
3. Server interface IP from `server.interfaces`
4. `server.internalIp`

This order is implemented in `insertVm` and `getServerDetails`.

### noAgent=true: skip guest-agent IP wait

When `noAgent=true` is configured on the workload, no guest agent will ever report IPs.
`checkServerReady` should proceed immediately when `status=up`, without the 2-minute
spin-wait. The `noAgent` flag is carried in `runConfig` and is available as `opts.noAgent`
inside `checkServerReady`.

### Ubuntu after netplan apply: DNS is not immediately available

After `netplan apply` brings up the static interface, `systemd-resolved` may not yet
be responsive. The Morpheus agent install will fail if it fires before DNS is usable.

**Solution**: After `netplan apply`, poll with:
```bash
for i in $(seq 1 30); do getent hosts google.com 2>/dev/null && break; sleep 1; done
```

### Morpheus core cloud-config contains YAML type errors

The Morpheus core cloud-config template emits two values with incorrect YAML types:
- `disable_root: 0` — should be `disable_root: false`
- `ssh_deletekeys: 'false'` — should be `ssh_deletekeys: false`

These cause cloud-init schema validation warnings and may affect behavior on strict
cloud-init implementations. `enhanceCloudInitConfig` patches them automatically.

---

## Engineering Guidance

- Always use `enhanceCloudInitConfig` to inject network config — it handles OS detection,
  merging, package suppression, and schema fixes.
- When extending network config injection, preserve the merge logic for `write_files`
  and `runcmd` — do not replace existing sections.
- Prefer `resolveCidr()` over direct `netmask` access whenever a CIDR prefix is needed.
- Do not call `checkServerReady` from `getServerDetails`. Use `getServerDetail` instead.
- When adding a new OS type, determine whether it uses netplan, NetworkManager keyfile,
  or systemd-networkd, and update the `isNetplan` / `isOel` detection in
  `enhanceCloudInitConfig`.

---

## Open Questions

- **Ubuntu DHCP**: Ubuntu provisioning via DHCP has not been validated on the current
  oVirt test environment (no DHCP server was available). The code path is believed
  unchanged from prior working state, but has not been confirmed with the netplan
  and oVirt broadcast constraints in mind.
- **OEL/RHEL 7 and 8 keyfile compatibility**: NetworkManager keyfile format is
  documented as compatible with RHEL 7+, but this has not been tested in the OLVM
  test environment specifically.
- **Static IP for DHCP templates**: If a template has a pre-existing NM connection
  profile (tied to the original NIC name), the glob-matched keyfile may conflict with
  the existing profile. The behavior in this scenario is unverified.