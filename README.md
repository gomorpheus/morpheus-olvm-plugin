# Morpheus OLVM Cloud Plugin

This plugin provides a full integration between Oracle Linux Virtualization Manager (OLVM) and [Morpheus](https://morpheusdata.com). It enables cloud inventory sync, VM provisioning, VM power and resize actions, and snapshot-based backups from within the Morpheus platform.

## Requirements

| Component | Minimum Version |
|-----------|----------------|
| Morpheus | 8.0.9 |

## Installation

1. Download the latest `.jar` from the [Releases](https://github.com/HewlettPackard/morpheus-olvm-plugin/releases) page, or [build it yourself](#building).
2. In Morpheus, navigate to **Administration → Integrations → Plugins**.
3. Click **Browse** and upload the `.jar` file.
4. The **OLVM** cloud type will appear after the plugin loads.

## Configuration

When adding an OLVM cloud in Morpheus (**Infrastructure → Clouds → Add Cloud**), provide the following:

| Field | Description |
|-------|-------------|
| **API URL** | OLVM API endpoint |
| **Credentials** | Select local credentials or a stored username/password credential |
| **Username** | OLVM username |
| **Password** | OLVM password |
| **Datacenter** | OLVM datacenter to inventory, or all datacenters |
| **Inventory Existing Instances** | Inventory existing OLVM virtual machines |

Credentials can also be stored as a Morpheus [Credential](https://docs.morpheusdata.com/en/latest/administration/credentials/credentials.html) and selected at cloud setup time.

## Features

### Cloud Sync

The following resources are discovered and kept in sync from OLVM:

- **Datacenters** — OLVM datacenters available to the configured account
- **Clusters** — compute clusters within each datacenter
- **Storage Domains** — OLVM storage domains exposed as Morpheus datastores
- **Networks** — logical networks and VNIC profiles
- **Hosts** — KVM hypervisor hosts
- **Templates** — OLVM VM templates
- **Virtual Machines** — managed and unmanaged VMs, including power state and resource metadata

Any additions, updates, and removals in OLVM are automatically reflected in Morpheus on the next sync cycle.

### Provisioning

Virtual machines can be provisioned into OLVM directly from Morpheus using standard instance types and layouts. Supported operations include:

- Create, start, stop, and delete VMs
- Resize CPU, memory, storage, and network configuration
- Select OLVM datacenters, clusters, templates, networks, and storage domains during provisioning
- Provision Linux, Windows, Docker host, and Kubernetes node server types
- Use QCOW2 virtual images and cloud-init customization

### Backups

OLVM VM snapshots are supported via the Morpheus backup framework. Supported operations include:

- Create snapshot backups for VM disks
- Delete backup snapshots from OLVM
- Restore snapshots through the Morpheus restore workflow

## Building

```bash
./gradlew shadowJar
```

The plugin JAR will be written to `build/libs/`.

## License

Copyright 2022 Morpheus Data, LLC. Licensed under the [Apache License, Version 2.0](LICENSE).
