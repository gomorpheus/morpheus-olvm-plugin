# Copilot Instructions for morpheus-olvm-plugin

## Build & Deploy

**Prerequisites:** Switch to Java 17 before building (Groovy 3 is incompatible with Java 25+):
```bash
sdk use java 17.0.11-jbr
```

**Build the shadow JAR:**
```bash
./gradlew shadowJar
```
Output: `build/libs/*-all.jar`

**Deploy to local Morpheus plugin core for testing:**
```bash
mv build/libs/*-all.jar ~/code/morpheus-plugin-core/plugins/
```

**Run tests:**
```bash
./gradlew test
```
Tests use Spock framework (Groovy). No test files currently exist.

## Architecture

This is a **Morpheus cloud plugin** for Oracle Linux Virtualization Manager (OLVM). It integrates with the [morpheus-plugin-api](https://developer.morpheusdata.com) and is loaded into a Morpheus appliance at `Administration → Integrations → Plugins`.

### Provider Registration

`OlvmCloudPlugin` (extends `Plugin`) is the entry point — its `initialize()` registers all providers:
- `OlvmCloudProvider` — cloud lifecycle, validation, periodic refresh/sync
- `OlvmProvisionProvider` — VM provisioning/deprovisioning, resize
- `OlvmOptionSourceProvider` — dynamic dropdown options (datacenters, clusters, etc.)
- `OlvmBackupProvider` → `OlvmSnapshotBackupProvider` — snapshot-based backup

### Sync Pattern

`OlvmCloudProvider.refresh()` drives periodic synchronization. It calls each sync class sequentially, passing a shared `connection` map:
```
DatacenterSync → ClusterSync → StorageDomainSync → NetworkSync → HostSync → TemplateSync → VirtualMachineSync
```

Each sync class in `sync/` follows the same pattern using `SyncTask<IdentityProjection, Map, DomainObject>`:
1. Fetch existing Morpheus records via `listIdentityProjections()`
2. Fetch live OLVM data via `OlvmComputeUtility`
3. `SyncTask` reconciles: `.onDelete()`, `.onUpdate()`, `.onAdd()`

### API Communication

All OLVM REST API calls go through `OlvmComputeUtility` (static utility class):
- **Authentication:** OAuth2 password grant against `/ovirt-engine/sso/oauth/token` → returns bearer token
- **Connection map:** `{apiUrl, token}` — passed around instead of re-authenticating each call
- **Client:** `HttpApiClient` (from morpheus-plugin-api) with `ignoreSSL: true`
- **Headers:** `getAuthenticatedBaseHeaders(connection)` → `Authorization: Bearer <token>`
- **Base path:** `/ovirt-engine/api/...`

### Key Conventions

- All API methods in `OlvmComputeUtility` are `static` and return `ServiceResponse`
- `ServiceResponse.prepare()` initializes a response; set `rtn.success = true` and `rtn.data = [...]` on success
- Always call `client.shutdownClient()` in a `finally` block after `HttpApiClient` use
- Credentials are loaded via `cloud.accountCredentialData` (Morpheus credential store); fall back to `cloud.serviceUsername`/`cloud.servicePassword`
- Datacenter scoping: when `cloud.configMap.datacenter` is set (not `'all'`), filter by `clusterIds` derived from that datacenter
- VM inventory sync only runs when `cloud.configMap.importExisting == 'on'`
- `OlvmVersion.setMDC()` is called at the start of cloud refresh and plugin init for log correlation

### Scribe Resources

`src/main/resources/scribe/*.scribe` files declare Morpheus UI metadata (option types, layouts, compute types) using a Terraform-like HCL syntax. These are loaded by the Morpheus appliance at plugin install time — they are **not** Groovy code.

### Plugin Manifest

Plugin metadata (name, code `cloud.olvm`, min appliance version) is declared in `build.gradle` under `jar { manifest { attributes(...) } }`. The `Plugin-Class` must match `OlvmCloudPlugin`'s fully-qualified name.
