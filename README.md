# Morpheus OLVM Cloud Plugin

The Morpheus OLVM Cloud Plugin integrates Morpheus with Oracle Linux Virtualization Manager (OLVM), which is based on oVirt/Red Hat Virtualization Manager. It provides virtual machine provisioning, snapshot-based backup, and cloud synchronisation via the oVirt REST API (`/ovirt-engine/api`).

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Repository structure](#repository-structure)
- [Building the plugin](#building-the-plugin)
- [License](#license)
- [Installing](#installing)
- [Detailed Usage Steps](#detailed-usage-steps)
- [API Endpoints](#api-endpoints)

---

## Features

### Virtual Machine Provisioning

Provision and decommission virtual machines on an OLVM cluster from Morpheus. Supports cluster, network, storage domain, and template selection.

### Backup via Snapshots

Back up and restore VMs using OLVM/oVirt snapshots managed through the Morpheus backup framework.

### Cloud Sync

Morpheus synchronises the following OLVM resources for inventory:

- Virtual machines
- Clusters
- Datacenters
- Hosts
- Networks
- Storage domains
- VM templates

---

## Requirements

| Requirement | Version |
|-------------|---------|
| Morpheus | 8.0.9 or later |
| Java | 11 or later |
| Gradle | Use the included Gradle wrapper (`./gradlew`) |

Additional prerequisites:

- A running OLVM/oVirt Manager instance with the REST API accessible from the Morpheus appliance
- A user account with appropriate permissions to manage VMs, clusters, and storage
- Network access from the Morpheus appliance to the OLVM Manager API (default: port 443 over HTTPS)

---

## Repository structure

```
src/main/groovy/com/morpheus/olvm/
├── OlvmCloudPlugin.groovy           - Plugin entry point; registers all providers
├── OlvmCloudProvider.groovy         - CloudProvider implementation; cloud lifecycle and sync
├── OlvmProvisionProvider.groovy     - ProvisionProvider implementation; VM lifecycle
├── OlvmOptionSourceProvider.groovy  - UI option source data
├── backup/
│   ├── OlvmBackupProvider.groovy          - BackupProvider implementation
│   ├── OlvmSnapshotBackupProvider.groovy  - Snapshot-based backup type
│   ├── OlvmSnapshotExecutionProvider.groovy - Backup execution
│   └── OlvmSnapshotRestoreProvider.groovy   - Restore from snapshot
├── sync/
│   ├── ClusterSync.groovy           - Syncs clusters
│   ├── DatacenterSync.groovy        - Syncs datacenters
│   ├── HostSync.groovy              - Syncs hosts
│   ├── NetworkSync.groovy           - Syncs networks
│   ├── StorageDomainSync.groovy     - Syncs storage domains
│   ├── TemplateSync.groovy          - Syncs VM templates
│   └── VirtualMachineSync.groovy    - Syncs VMs
└── util/
    └── OlvmComputeUtility.groovy    - oVirt API client and shared helpers
src/main/resources/scribe/            - Seed/migration scripts
src/test/groovy/                       - Tests
build.gradle, gradle.properties        - Build configuration and plugin metadata
```

---

## Building the plugin

Run the following command to compile and package the plugin jar:

```bash
./gradlew clean build
```

The packaged jar will be written to `build/libs/`.

To execute tests, use the following command:

```bash
./gradlew test
```

---

## License

This project is licensed under the Apache License 2.0.

See the [LICENSE](LICENSE) file for details.

---

## Installing

1. Build the plugin (see [Building the plugin](#building-the-plugin)) or download a released jar.
2. In Morpheus, navigate to **Administration > Integrations > Plugins**.
3. Click **Add** and upload the `morpheus-olvm-plugin-<version>.jar` from `build/libs/`.
4. Navigate to **Infrastructure > Clouds > Add** and select **OLVM** to configure the integration.

---

## Detailed Usage Steps

### Adding an OLVM Cloud

1. Go to **Infrastructure > Clouds > Add**.
2. Select **OLVM** as the cloud type.
3. Enter a **Name**, the OLVM Manager **API URL**, and provide credentials.
4. Save. Morpheus connects to the OLVM API and begins syncing datacenters, clusters, hosts, networks, storage domains, templates, and VMs.

### Provisioning a Virtual Machine

1. Go to **Provisioning > Instances > Add**.
2. Select an OLVM-backed instance type.
3. Choose the target **Group**, **Cloud**, cluster, network, storage domain, and template.
4. Provision. Morpheus creates the VM on the OLVM cluster.

### Taking a Backup

1. From an instance detail page, navigate to the **Backups** tab.
2. Click **Backup Now** to create an OLVM snapshot.

### Restoring from a Snapshot

1. From the instance **Backups** tab, select a completed snapshot entry.
2. Click **Restore** and confirm.

---

## API Endpoints

This plugin communicates with the **oVirt/OLVM REST API** at `https://<olvm-host>/ovirt-engine/api`. Authentication uses HTTP Basic credentials or a session token.

| Endpoint | Method | Purpose |
|----------|--------|---------|
| `/ovirt-engine/api/clusters` | GET | List clusters |
| `/ovirt-engine/api/datacenters` | GET | List datacenters |
| `/ovirt-engine/api/hosts` | GET | List hosts |
| `/ovirt-engine/api/networks` | GET | List networks |
| `/ovirt-engine/api/storagedomains` | GET | List storage domains |
| `/ovirt-engine/api/templates` | GET | List VM templates |
| `/ovirt-engine/api/vms` | GET | List VMs |
| `/ovirt-engine/api/vms` | POST | Create a VM |
| `/ovirt-engine/api/vms/{id}` | GET | Get VM details |
| `/ovirt-engine/api/vms/{id}` | PUT | Update a VM |
| `/ovirt-engine/api/vms/{id}` | DELETE | Delete a VM |
| `/ovirt-engine/api/vms/{id}/snapshots` | GET | List VM snapshots |
| `/ovirt-engine/api/vms/{id}/snapshots` | POST | Create a snapshot |
| `/ovirt-engine/api/vms/{id}/snapshots/{snapshotId}` | DELETE | Delete a snapshot |
