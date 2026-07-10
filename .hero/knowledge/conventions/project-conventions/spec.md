---
title: Project Conventions
type: convention
status: active
created: 2026-07-10
scope: ["*"]
tags: [imported, conventions]
---

## Coding conventions

- **Don't assume.** Surface tradeoffs and ask questions if anything is unclear. Present multiple interpretations instead of picking one silently.
- **Honest over agreeable.** Push back when you disagree — say what's wrong, propose the better path, then proceed. Don't reverse your position because the user pushed; reverse it when new evidence warrants it.
- **Label what you know vs. think.** State facts as facts and opinions as opinions. "I'm not sure" beats a confident guess.
- **Say the hard thing.** If the user's approach has a flaw, point it out before implementing. If a request conflicts with these rules, name the conflict rather than silently following.
- **Simplicity first.** Write the minimum code that solves the problem. No speculative features, no unnecessary abstractions, and no error handling for impossible scenarios.
- **Surgical changes.** Touch only what is strictly required. Do not "improve" nearby code or refactor unrelated sections. Match the existing style perfectly.
- **Verify before reporting done.** Define clear success criteria for every task. Run tests or validation scripts and iterate until the criteria are met before reporting completion.
- Read a file before editing it
- Run tests after making changes
- Search the codebase before creating new files
- Make one logical change at a time and verify it before moving on
- Do not suppress errors or warnings to make tests pass
- If a fix attempt fails twice, stop and reassess the approach

<!-- Add project-specific conventions here -->

## Key Conventions

- All API methods in `OlvmComputeUtility` are `static` and return `ServiceResponse`
- `ServiceResponse.prepare()` initializes a response; set `rtn.success = true` and `rtn.data = [...]` on success
- Always call `client.shutdownClient()` in a `finally` block after `HttpApiClient` use
- Credentials are loaded via `cloud.accountCredentialData` (Morpheus credential store); fall back to `cloud.serviceUsername`/`cloud.servicePassword`
- Datacenter scoping: when `cloud.configMap.datacenter` is set (not `'all'`), filter by `clusterIds` derived from that datacenter
- VM inventory sync only runs when `cloud.configMap.importExisting == 'on'`
- `OlvmVersion.setMDC()` is called at the start of cloud refresh and plugin init for log correlation

<!-- Imported from: AGENTS.md, .github/copilot-instructions.md -->
