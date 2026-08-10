---
title: Copilot Instructions for morpheus-olvm-plugin
type: context
status: active
created: 2026-07-14
tags: [imported, module]
---

## Copilot Instructions for morpheus-olvm-plugin

## Provider Registration

`OlvmCloudPlugin` (extends `Plugin`) is the entry point — its `initialize()` registers all providers:
- `OlvmCloudProvider` — cloud lifecycle, validation, periodic refresh/sync
- `OlvmProvisionProvider` — VM provisioning/deprovisioning, resize
- `OlvmOptionSourceProvider` — dynamic dropdown options (datacenters, clusters, etc.)
- `OlvmBackupProvider` → `OlvmSnapshotBackupProvider` — snapshot-based backup

## Sync Pattern

`OlvmCloudProvider.refresh()` drives periodic synchronization. It calls each sync class sequentially, passing a shared `connection` map:
```
DatacenterSync → ClusterSync → StorageDomainSync → NetworkSync → HostSync → TemplateSync → VirtualMachineSync
```

Each sync class in `sync/` follows the same pattern using `SyncTask<IdentityProjection, Map, DomainObject>`:
1. Fetch existing Morpheus records via `listIdentityProjections()`
2. Fetch live OLVM data via `OlvmComputeUtility`
3. `SyncTask` reconciles: `.onDelete()`, `.onUpdate()`, `.onAdd()`

## API Communication

All OLVM REST API calls go through `OlvmComputeUtility` (static utility class):
- **Authentication:** OAuth2 password grant against `/ovirt-engine/sso/oauth/token` → returns bearer token
- **Connection map:** `{apiUrl, token}` — passed around instead of re-authenticating each call
- **Client:** `HttpApiClient` (from morpheus-plugin-api) with `ignoreSSL: true`
- **Headers:** `getAuthenticatedBaseHeaders(connection)` → `Authorization: Bearer <token>`
- **Base path:** `/ovirt-engine/api/...`

## Scribe Resources

`src/main/resources/scribe/*.scribe` files declare Morpheus UI metadata (option types, layouts, compute types) using a Terraform-like HCL syntax. These are loaded by the Morpheus appliance at plugin install time — they are **not** Groovy code.

## Plugin Manifest

Plugin metadata (name, code `cloud.olvm`, min appliance version) is declared in `build.gradle` under `jar { manifest { attributes(...) } }`. The `Plugin-Class` must match `OlvmCloudPlugin`'s fully-qualified name.

<!-- Imported from: .github/copilot-instructions.md -->
