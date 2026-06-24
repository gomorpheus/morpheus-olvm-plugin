## Verified Knowledge

### IP sync when no OLVM guest agent is installed

When the OLVM guest agent is absent (or `noAgent=true`), `vmDetails.ipV4` is empty.
In this case sync must **not** overwrite Morpheus-registered IPs. The correct behavior:

- If guest agent reports an IP: update `externalIp`, `internalIp`, and (conditionally)
  `sshHost`.
- If guest agent reports nothing: preserve existing `externalIp`/`internalIp`.
  If `sshHost` is unset but `internalIp` is populated (the Morpheus agent registered
  an IP via call-home on a DHCP VM), promote `internalIp` to `sshHost`.

This was broken before MORPH-11852 — the old code overwrote `internalIp` with an empty
string every sync cycle when no guest agent was present, clearing the IP the Morpheus
agent had registered.

### Use `ipV4?.find { it }` not `ipV4.first()` for nullable lists

`vmDetails.ipV4` may be null, empty, or contain empty strings. Using `.first()` throws
on an empty list. The safe idiom is `vmDetails.ipV4?.find { it } ?: ''`.

---

## Engineering Guidance

- When writing sync logic that updates network fields, always guard against the
  no-guest-agent case. Treat an empty `ipV4` as "no information" rather than
  "IP was cleared."
- The IP field priority during sync is: OLVM guest agent → preserve existing →
  propagate internalIp to sshHost.

---

## Open Questions

- Whether `externalIp` and `internalIp` should diverge for multi-NIC VMs, or whether
  OLVM always returns a single primary IP via the guest agent.
- Whether sync correctly handles the case where a VM transitions from having a guest
  agent to not having one (e.g. after agent uninstall).