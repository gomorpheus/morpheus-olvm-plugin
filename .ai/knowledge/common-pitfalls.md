## Verified Knowledge

### Double checkServerReady call causes false provisioning failures

`checkServerReady` is a spin-wait (up to ~150 seconds). If called from `getServerDetails`
after `insertVm` has already called it, and the VM is mid-reboot due to cloud-init
(common for Ubuntu and OEL first-boot), the second call will time out and return failure.
Morpheus then marks the instance as failed even though the VM is running normally.

**Fix**: `getServerDetails` must use `getServerDetail` (single direct lookup), not
`checkServerReady`.

### Silent network config drop when write_files or runcmd already exists

If the base cloud-config already contains a `write_files:` or `runcmd:` section and
the plugin appends a second one, YAML parsing produces duplicate keys — only the last
occurrence is used, silently discarding the first. On Morpheus, the core template
typically includes `runcmd:` already, so this affects nearly every provision.

**Fix**: Always merge into existing sections using `replaceFirst` on the existing
section header. Never append a duplicate top-level key.

### Static IP silently not applied on OEL/RHEL 9 when using ifcfg format

Writing files to `/etc/sysconfig/network-scripts/` succeeds but the IP is never
applied. The `ifcfg-rh` plugin is disabled by default in OEL/RHEL 9. No error is
logged by cloud-init or NetworkManager — the configuration simply has no effect.

**Fix**: Use NetworkManager keyfile format at
`/etc/NetworkManager/system-connections/*.nmconnection` (permissions `0600`).

### DHCP fails silently on oVirt when using NM's internal DHCP client

The VM starts, NM is running, DHCP discover is sent — but no lease is obtained and
no error is surfaced. The root cause is that NM's internal DHCP client does not set
the BROADCAST flag; oVirt port security drops unicast DHCP OFFERs.

**Fix**: Write `/etc/NetworkManager/conf.d/90-morpheus-dhcp.conf` with `dhcp=dhclient`.

### Hard-coded NIC names in keyfiles fail silently when NIC name differs

If the NM keyfile specifies `interface-name=enp0s2` but the VM's actual NIC is
`enp1s0`, NM finds no matching profile and leaves the interface unconfigured.
No error is raised. This is especially likely when provisioning from a template where
the original VM had a different PCI slot assignment.

**Fix**: Use `interface-name=e*;` in the `[match]` section.

### Morpheus core emits invalid YAML types in cloud-config

The Morpheus core template emits `disable_root: 0` and `ssh_deletekeys: 'false'`.
Cloud-init expects boolean values. These can trigger schema errors that cascade into
unexpected behavior on strict cloud-init implementations. Always patch these values
in `enhanceCloudInitConfig`.

### Package operations in cloud-init can OOM-kill provisioning on OLVM

`package_update`, `package_upgrade`, `packages:`, and `package_reboot_if_required`
all trigger large downloads or reboots that kill cloud-init or the agent install on
low-memory VMs. These are safe to suppress since required packages are present on
standard OLVM images.

### CIDR defaults to /24 when netmask is the only source and the pool is a /22

Morpheus may not populate `subnet.prefixLength` for all IPAM pool configurations.
If only `netmask` is available and the pool spans a larger network (e.g. /22), the
resulting CIDR will be wrong, silently breaking routing.

**Fix**: Always use `resolveCidr()`, which checks `subnet.prefixLength`, `subnet.cidr`,
`network.cidr`, then `netmask` in order.

---

## Engineering Guidance

- When a provisioning step appears to succeed but the network is unconfigured,
  check: (1) whether the correct keyfile format is used for the OS version,
  (2) whether write_files/runcmd were silently duplicated, (3) whether DHCP
  broadcast behavior is involved.
- When adding support for a new OS type, verify the network stack before writing
  network config injection code.
- Any new cloud-init manipulation should run through `enhanceCloudInitConfig`
  to inherit schema fixes, OOM protection, and merge logic.

---

## Open Questions

- Whether Ubuntu DHCP provisioning is affected by oVirt's broadcast DHCP requirement
  (netplan uses `systemd-networkd` or `networkd` which may handle broadcast differently
  from NM).
- Whether OEL 7 and 8 templates in production have pre-existing NM profiles that
  could conflict with the glob-matched keyfile.