---
title: Architecture Overview
type: context
status: active
created: 2026-07-10
tags: [architecture]
---

## Plugin Entry Point

`OlvmCloudPlugin` (`src/main/groovy/com/morpheus/olvm/OlvmCloudPlugin.groovy`) extends Morpheus's
`Plugin` base class, code `cloud.olvm`. Its `initialize()` registers the provider set with the
Morpheus plugin framework:

- `OlvmCloudProvider` — cloud integration (inventory sync orchestration)
- `OlvmProvisionProvider` — VM provisioning, power actions, resize
- `OlvmOptionSourceProvider` — dynamic option lists for Morpheus UI forms
- `OlvmBackupProvider` — snapshot-based backup integration

## Sync Layer

`src/main/groovy/com/morpheus/olvm/sync/` contains one class per OLVM resource type that Morpheus
mirrors into its own inventory: `ClusterSync`, `DatacenterSync`, `HostSync`, `NetworkSync`,
`StorageDomainSync`, `TemplateSync`, `VirtualMachineSync`. Each sync class is invoked by
`OlvmCloudProvider` to reconcile OLVM API state with Morpheus's cloud model objects.

## Backup Layer

`src/main/groovy/com/morpheus/olvm/backup/` implements snapshot-based backup/restore:
`OlvmSnapshotBackupProvider`, `OlvmSnapshotExecutionProvider`, `OlvmSnapshotRestoreProvider`.

## OLVM API Access

`OlvmComputeUtility` (`src/main/groovy/com/morpheus/olvm/util/`) wraps calls to the OLVM/oVirt REST
API used by the sync and provisioning layers.

## Build Artifact

The plugin is packaged as a shadow JAR (`com.github.johnrengelman.shadow`) and deployed by copying
the built jar into a running Morpheus core's `plugins/` directory (see dev-workflow entry).
