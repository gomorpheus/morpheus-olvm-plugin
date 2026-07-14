---
title: Project Conventions
type: convention
status: active
created: 2026-07-14
scope: ["*"]
tags: [imported, conventions]
---

## Key Conventions

- All API methods in `OlvmComputeUtility` are `static` and return `ServiceResponse`
- `ServiceResponse.prepare()` initializes a response; set `rtn.success = true` and `rtn.data = [...]` on success
- Always call `client.shutdownClient()` in a `finally` block after `HttpApiClient` use
- Credentials are loaded via `cloud.accountCredentialData` (Morpheus credential store); fall back to `cloud.serviceUsername`/`cloud.servicePassword`
- Datacenter scoping: when `cloud.configMap.datacenter` is set (not `'all'`), filter by `clusterIds` derived from that datacenter
- VM inventory sync only runs when `cloud.configMap.importExisting == 'on'`
- `OlvmVersion.setMDC()` is called at the start of cloud refresh and plugin init for log correlation

<!-- Imported from: .github/copilot-instructions.md -->
