## Verified Knowledge

### Structured log messages make provisioning failures diagnosable

The provisioning path (`insertVm`, `checkServerReady`, `getServerDetails`,
`enhanceCloudInitConfig`) emits structured `log.info` messages at each decision point.
The pattern used is:

```groovy
log.info("methodName: label1=${value1}, label2=${value2}")
```

This makes it possible to reconstruct the full provisioning state from logs without
needing to attach a debugger or reproduce the issue.

Key log points to look for when diagnosing provisioning failures:

| Message | What it tells you |
|---------|-------------------|
| `enhanceCloudInitConfig: isNetplan=..., osType=..., nic=..., doStatic=..., doDhcp=..., ip=...` | What network config path was chosen |
| `enhanceCloudInitConfig: suppressed package_update` | OOM protection was applied |
| `insertVm: startVmWithCloudInit success=...` | Whether the VM actually started |
| `checkServerReady: attempt N/15 - status=..., ipV4=...` | VM status poll history |
| `checkServerReady: VM is up, skipping IP wait (noAgent=true)` | noAgent path was taken |
| `insertVm: resolved IP - privateIp=... (olvmGuestAgent=..., staticInterfaceIp=...)` | Which IP source was used |
| `getServerDetails: ip=... (olvm=..., interfaceIp=..., internalIp=..., sshHost=...)` | IP resolution at getServerDetails time |

### Cloud-init content is logged at debug level

`enhanceCloudInitConfig` logs the full resulting cloud-config at `log.debug`. When
diagnosing cloud-init failures, enable debug logging and look for this output to verify
the injected config.

The full cloud-config is also logged in `insertVm` before the VM is started:
```
insertVm - full cloud-config:\n<first 3000 chars>
```

### checkServerReady logs are the primary tool for diagnosing stuck provisions

If a provision hangs during "waiting for VM to start", the `checkServerReady` attempt
logs will show whether the VM is reaching `status=up` and whether the guest agent is
reporting IPs. Look for:
- `status=up, ipV4=[]` repeated — VM is up but no guest agent
- `status=down` repeated — VM is not starting (check oVirt events)
- No log after attempt 1 — the `getServerDetail` call itself is failing

---

## Engineering Guidance

- Always include enough structured context in log messages to diagnose failures without
  a debugger: method name, relevant field values, what decision was made.
- Use `log.info` for provisioning decision points (what path was taken, what IP was
  resolved). Use `log.debug` for intermediate values and full payloads.
- `log.warn` should indicate unexpected but non-fatal conditions (e.g. timed out,
  proceeding without IP).
- `log.error` is for exceptions and unrecoverable failures only.

---

## Open Questions

- Whether oVirt provides any event-level API that could be queried during provisioning
  to surface scheduling or resource errors faster than the status poll loop.