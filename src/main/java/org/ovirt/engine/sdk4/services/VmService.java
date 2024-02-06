/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.AuthorizedKeyBuilder;
import org.ovirt.engine.sdk4.builders.ClusterBuilder;
import org.ovirt.engine.sdk4.builders.DiskBuilder;
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.builders.SnapshotBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainLeaseBuilder;
import org.ovirt.engine.sdk4.builders.TicketBuilder;
import org.ovirt.engine.sdk4.builders.VmBuilder;
import org.ovirt.engine.sdk4.types.AuthorizedKey;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Snapshot;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.StorageDomainLease;
import org.ovirt.engine.sdk4.types.Ticket;
import org.ovirt.engine.sdk4.types.Vm;

public interface VmService extends MeasurableService {
    /**
     * Apply an automatic CPU and NUMA configuration on the VM.
     * 
     * An example for a request:
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/autopincpuandnumanodes
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <optimize_cpu_settings>true</optimize_cpu_settings>
     * </action>
     * ----
     */
    public interface AutoPinCpuAndNumaNodesRequest extends Request<AutoPinCpuAndNumaNodesRequest, AutoPinCpuAndNumaNodesResponse> {
        /**
         * Indicates if the detach action should be performed asynchronously.
         */
        AutoPinCpuAndNumaNodesRequest async(Boolean async);
        /**
         * Specifies how the auto CPU and NUMA configuration is applied.
         * If set to true, will adjust the CPU topology to fit the VM pinned host hardware.
         * Otherwise, it will use the VM CPU topology.
         */
        AutoPinCpuAndNumaNodesRequest optimizeCpuSettings(Boolean optimizeCpuSettings);
    }
    
    /**
     * Apply an automatic CPU and NUMA configuration on the VM.
     * 
     * An example for a request:
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/autopincpuandnumanodes
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <optimize_cpu_settings>true</optimize_cpu_settings>
     * </action>
     * ----
     */
    public interface AutoPinCpuAndNumaNodesResponse extends Response {
    }
    
    /**
     * Apply an automatic CPU and NUMA configuration on the VM.
     * 
     * An example for a request:
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/autopincpuandnumanodes
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <optimize_cpu_settings>true</optimize_cpu_settings>
     * </action>
     * ----
     */
    AutoPinCpuAndNumaNodesRequest autoPinCpuAndNumaNodes();
    
    /**
     * This operation stops any migration of a virtual machine to another physical host.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/cancelmigration
     * ----
     * 
     * The cancel migration action does not take any action specific parameters;
     * therefore, the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface CancelMigrationRequest extends Request<CancelMigrationRequest, CancelMigrationResponse> {
        /**
         * Indicates if the migration should cancelled asynchronously.
         */
        CancelMigrationRequest async(Boolean async);
    }
    
    /**
     * This operation stops any migration of a virtual machine to another physical host.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/cancelmigration
     * ----
     * 
     * The cancel migration action does not take any action specific parameters;
     * therefore, the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface CancelMigrationResponse extends Response {
    }
    
    /**
     * This operation stops any migration of a virtual machine to another physical host.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/cancelmigration
     * ----
     * 
     * The cancel migration action does not take any action specific parameters;
     * therefore, the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    CancelMigrationRequest cancelMigration();
    
    public interface CloneRequest extends Request<CloneRequest, CloneResponse> {
        /**
         * Indicates if the clone should be performed asynchronously.
         */
        CloneRequest async(Boolean async);
        /**
         * Use the `discard_snapshots` parameter when the virtual machine should be clone with its
         * snapshots collapsed. Default is true.
         */
        CloneRequest discardSnapshots(Boolean discardSnapshots);
        CloneRequest storageDomain(StorageDomain storageDomain);
        /**
         * The storage domain on which the virtual machines disks will be copied to.
         */
        CloneRequest storageDomain(StorageDomainBuilder storageDomain);
        CloneRequest vm(Vm vm);
        CloneRequest vm(VmBuilder vm);
    }
    
    public interface CloneResponse extends Response {
    }
    
    CloneRequest clone_();
    
    /**
     * Permanently restores the virtual machine to the state of the previewed snapshot.
     * 
     * See the <<services/vm/methods/preview_snapshot, preview_snapshot>> operation for details.
     */
    public interface CommitSnapshotRequest extends Request<CommitSnapshotRequest, CommitSnapshotResponse> {
        /**
         * Indicates if the snapshots should be committed asynchronously.
         */
        CommitSnapshotRequest async(Boolean async);
    }
    
    /**
     * Permanently restores the virtual machine to the state of the previewed snapshot.
     * 
     * See the <<services/vm/methods/preview_snapshot, preview_snapshot>> operation for details.
     */
    public interface CommitSnapshotResponse extends Response {
    }
    
    /**
     * Permanently restores the virtual machine to the state of the previewed snapshot.
     * 
     * See the <<services/vm/methods/preview_snapshot, preview_snapshot>> operation for details.
     */
    CommitSnapshotRequest commitSnapshot();
    
    /**
     * Detaches a virtual machine from a pool.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/detach
     * ----
     * 
     * The detach action does not take any action specific parameters; therefore, the request body should contain an
     * empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface DetachRequest extends Request<DetachRequest, DetachResponse> {
        /**
         * Indicates if the detach action should be performed asynchronously.
         */
        DetachRequest async(Boolean async);
    }
    
    /**
     * Detaches a virtual machine from a pool.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/detach
     * ----
     * 
     * The detach action does not take any action specific parameters; therefore, the request body should contain an
     * empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface DetachResponse extends Response {
    }
    
    /**
     * Detaches a virtual machine from a pool.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/detach
     * ----
     * 
     * The detach action does not take any action specific parameters; therefore, the request body should contain an
     * empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    DetachRequest detach();
    
    /**
     * Exports the virtual machine.
     * 
     * A virtual machine can be exported to an export domain.
     * For example, to export virtual machine `123` to the export domain `myexport`:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/export
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>myexport</name>
     *   </storage_domain>
     *   <exclusive>true</exclusive>
     *   <discard_snapshots>true</discard_snapshots>
     * </action>
     * ----
     * 
     * Since version 4.2 of the engine it is also possible to export a virtual machine as a virtual appliance (OVA).
     * For example, to export virtual machine `123` as an OVA file named `myvm.ova` that is placed in the directory `/home/ovirt/` on host `myhost`:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/export
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     *   <directory>/home/ovirt</directory>
     *   <filename>myvm.ova</filename>
     * </action>
     * ----
     * 
     * NOTE: Confirm that the export operation has completed before attempting any actions on the export domain.
     */
    public interface ExportRequest extends Request<ExportRequest, ExportResponse> {
        /**
         * Indicates if the export should be performed asynchronously.
         */
        ExportRequest async(Boolean async);
        /**
         * Use the `discard_snapshots` parameter when the virtual machine should be exported with all of its
         * snapshots collapsed.
         */
        ExportRequest discardSnapshots(Boolean discardSnapshots);
        /**
         * Use the `exclusive` parameter when the virtual machine should be exported even if another copy of
         * it already exists in the export domain (override).
         */
        ExportRequest exclusive(Boolean exclusive);
        ExportRequest storageDomain(StorageDomain storageDomain);
        /**
         * The (export) storage domain to export the virtual machine to.
         */
        ExportRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Exports the virtual machine.
     * 
     * A virtual machine can be exported to an export domain.
     * For example, to export virtual machine `123` to the export domain `myexport`:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/export
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>myexport</name>
     *   </storage_domain>
     *   <exclusive>true</exclusive>
     *   <discard_snapshots>true</discard_snapshots>
     * </action>
     * ----
     * 
     * Since version 4.2 of the engine it is also possible to export a virtual machine as a virtual appliance (OVA).
     * For example, to export virtual machine `123` as an OVA file named `myvm.ova` that is placed in the directory `/home/ovirt/` on host `myhost`:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/export
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     *   <directory>/home/ovirt</directory>
     *   <filename>myvm.ova</filename>
     * </action>
     * ----
     * 
     * NOTE: Confirm that the export operation has completed before attempting any actions on the export domain.
     */
    public interface ExportResponse extends Response {
    }
    
    /**
     * Exports the virtual machine.
     * 
     * A virtual machine can be exported to an export domain.
     * For example, to export virtual machine `123` to the export domain `myexport`:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/export
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <storage_domain>
     *     <name>myexport</name>
     *   </storage_domain>
     *   <exclusive>true</exclusive>
     *   <discard_snapshots>true</discard_snapshots>
     * </action>
     * ----
     * 
     * Since version 4.2 of the engine it is also possible to export a virtual machine as a virtual appliance (OVA).
     * For example, to export virtual machine `123` as an OVA file named `myvm.ova` that is placed in the directory `/home/ovirt/` on host `myhost`:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/export
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     *   <directory>/home/ovirt</directory>
     *   <filename>myvm.ova</filename>
     * </action>
     * ----
     * 
     * NOTE: Confirm that the export operation has completed before attempting any actions on the export domain.
     */
    ExportRequest export();
    
    /**
     * Freezes virtual machine file systems.
     * 
     * This operation freezes a virtual machine's file systems using the QEMU guest agent when taking a live snapshot of
     * a running virtual machine. Normally, this is done automatically by the manager, but this must be executed
     * manually with the API for virtual machines using OpenStack Volume (Cinder) disks.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/freezefilesystems
     * ----
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface FreezeFilesystemsRequest extends Request<FreezeFilesystemsRequest, FreezeFilesystemsResponse> {
        /**
         * Indicates if the freeze should be performed asynchronously.
         */
        FreezeFilesystemsRequest async(Boolean async);
    }
    
    /**
     * Freezes virtual machine file systems.
     * 
     * This operation freezes a virtual machine's file systems using the QEMU guest agent when taking a live snapshot of
     * a running virtual machine. Normally, this is done automatically by the manager, but this must be executed
     * manually with the API for virtual machines using OpenStack Volume (Cinder) disks.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/freezefilesystems
     * ----
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface FreezeFilesystemsResponse extends Response {
    }
    
    /**
     * Freezes virtual machine file systems.
     * 
     * This operation freezes a virtual machine's file systems using the QEMU guest agent when taking a live snapshot of
     * a running virtual machine. Normally, this is done automatically by the manager, but this must be executed
     * manually with the API for virtual machines using OpenStack Volume (Cinder) disks.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/freezefilesystems
     * ----
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    FreezeFilesystemsRequest freezeFilesystems();
    
    /**
     * Retrieves the description of the virtual machine.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates if all of the attributes of the virtual machine should be included in the response.
         * 
         * By default the following attributes are excluded:
         * 
         * - `console`
         * - `initialization.configuration.data` - The OVF document describing the virtual machine.
         * - `rng_source`
         * - `soundcard`
         * - `virtio_scsi`
         * 
         * For example, to retrieve the complete representation of the virtual machine '123':
         * 
         * ....
         * GET /ovirt-engine/api/vms/123?all_content=true
         * ....
         * 
         * NOTE: These attributes are not included by default as they reduce performance. These attributes are seldom used
         * and require additional queries to the database. Only use this parameter when required as it will reduce performance.
         */
        GetRequest allContent(Boolean allContent);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        GetRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
        /**
         * Indicates if the returned result describes the virtual machine as it is currently running or if describes
         * the virtual machine with the modifications that have already been performed but that will only come into
         * effect when the virtual machine is restarted. By default the value is `false`.
         * 
         * If the parameter is included in the request, but without a value, it is assumed that the value is `true`. The
         * the following request:
         * 
         * [source]
         * ----
         * GET /vms/{vm:id};next_run
         * ----
         * 
         * Is equivalent to using the value `true`:
         * 
         * [source]
         * ----
         * GET /vms/{vm:id};next_run=true
         * ----
         */
        GetRequest nextRun(Boolean nextRun);
        /**
         * Indicates if the results should expose the OVF as it appears in OVA files of that VM. The OVF document
         * describing the virtual machine. This parameter will work only when all_content=True is set.
         * The OVF will be presented in `initialization.configuration.data`.
         * 
         * For example:
         * [source]
         * ----
         * GET /vms/{vm:id}?all_content=true&ovf_as_ova=true
         * ----
         */
        GetRequest ovfAsOva(Boolean ovfAsOva);
    }
    
    /**
     * Retrieves the description of the virtual machine.
     */
    public interface GetResponse extends Response {
        /**
         * Description of the virtual machine.
         */
        Vm vm();
    }
    
    /**
     * Retrieves the description of the virtual machine.
     */
    GetRequest get();
    
    /**
     * Initiates the automatic user logon to access a virtual machine from an external console.
     * 
     * This action requires the `ovirt-guest-agent-gdm-plugin` and the `ovirt-guest-agent-pam-module` packages to be
     * installed and the `ovirt-guest-agent` service to be running on the virtual machine.
     * 
     * Users require the appropriate user permissions for the virtual machine in order to access the virtual machine
     * from an external console.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/logon
     * ----
     * 
     * Request body:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface LogonRequest extends Request<LogonRequest, LogonResponse> {
        /**
         * Indicates if the logon should be performed asynchronously.
         */
        LogonRequest async(Boolean async);
    }
    
    /**
     * Initiates the automatic user logon to access a virtual machine from an external console.
     * 
     * This action requires the `ovirt-guest-agent-gdm-plugin` and the `ovirt-guest-agent-pam-module` packages to be
     * installed and the `ovirt-guest-agent` service to be running on the virtual machine.
     * 
     * Users require the appropriate user permissions for the virtual machine in order to access the virtual machine
     * from an external console.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/logon
     * ----
     * 
     * Request body:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface LogonResponse extends Response {
    }
    
    /**
     * Initiates the automatic user logon to access a virtual machine from an external console.
     * 
     * This action requires the `ovirt-guest-agent-gdm-plugin` and the `ovirt-guest-agent-pam-module` packages to be
     * installed and the `ovirt-guest-agent` service to be running on the virtual machine.
     * 
     * Users require the appropriate user permissions for the virtual machine in order to access the virtual machine
     * from an external console.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/logon
     * ----
     * 
     * Request body:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    LogonRequest logon();
    
    /**
     * Sets the global maintenance mode on the hosted engine virtual machine.
     * 
     * This action has no effect on other virtual machines.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/maintenance
     * ----
     * 
     * [source,xml]
     * ----
     * <action>
     *   <maintenance_enabled>true<maintenance_enabled/>
     * </action>
     * ----
     */
    public interface MaintenanceRequest extends Request<MaintenanceRequest, MaintenanceResponse> {
        /**
         * Indicates if the global maintenance action should be performed asynchronously.
         */
        MaintenanceRequest async(Boolean async);
        /**
         * Indicates if global maintenance should be enabled or disabled.
         */
        MaintenanceRequest maintenanceEnabled(Boolean maintenanceEnabled);
    }
    
    /**
     * Sets the global maintenance mode on the hosted engine virtual machine.
     * 
     * This action has no effect on other virtual machines.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/maintenance
     * ----
     * 
     * [source,xml]
     * ----
     * <action>
     *   <maintenance_enabled>true<maintenance_enabled/>
     * </action>
     * ----
     */
    public interface MaintenanceResponse extends Response {
    }
    
    /**
     * Sets the global maintenance mode on the hosted engine virtual machine.
     * 
     * This action has no effect on other virtual machines.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/maintenance
     * ----
     * 
     * [source,xml]
     * ----
     * <action>
     *   <maintenance_enabled>true<maintenance_enabled/>
     * </action>
     * ----
     */
    MaintenanceRequest maintenance();
    
    /**
     * Migrates a virtual machine to another physical host.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/migrate
     * ----
     * 
     * To specify a specific host to migrate the virtual machine to:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <host id="2ab5e1da-b726-4274-bbf7-0a42b16a0fc3"/>
     * </action>
     * ----
     */
    public interface MigrateRequest extends Request<MigrateRequest, MigrateResponse> {
        /**
         * Indicates if the migration should be performed asynchronously.
         */
        MigrateRequest async(Boolean async);
        MigrateRequest cluster(Cluster cluster);
        /**
         * Specifies the cluster the virtual machine should migrate to. This is an optional parameter. By default, the
         * virtual machine is migrated to another host within the same cluster.
         * 
         * WARNING: Live migration to another cluster is not supported. Strongly consider the target cluster's hardware
         * architecture and network architecture before attempting a migration.
         */
        MigrateRequest cluster(ClusterBuilder cluster);
        /**
         * Specifies that the virtual machine should migrate even if the virtual machine is defined as non-migratable.
         * This is an optional parameter. By default, it is set to `false`.
         */
        MigrateRequest force(Boolean force);
        MigrateRequest host(Host host);
        /**
         * Specifies a specific host that the virtual machine should migrate to. This is an optional parameter. By default,
         * the {engine-name} automatically selects a default host for migration within the same cluster. If an API user
         * requires a specific host, the user can specify the host with either an `id` or `name` parameter.
         */
        MigrateRequest host(HostBuilder host);
        /**
         * Migrate also all other virtual machines in positive enforcing affinity groups with this virtual machine,
         * that are running on the same host.
         * 
         * The default value is `false`.
         */
        MigrateRequest migrateVmsInAffinityClosure(Boolean migrateVmsInAffinityClosure);
    }
    
    /**
     * Migrates a virtual machine to another physical host.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/migrate
     * ----
     * 
     * To specify a specific host to migrate the virtual machine to:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <host id="2ab5e1da-b726-4274-bbf7-0a42b16a0fc3"/>
     * </action>
     * ----
     */
    public interface MigrateResponse extends Response {
    }
    
    /**
     * Migrates a virtual machine to another physical host.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/migrate
     * ----
     * 
     * To specify a specific host to migrate the virtual machine to:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <host id="2ab5e1da-b726-4274-bbf7-0a42b16a0fc3"/>
     * </action>
     * ----
     */
    MigrateRequest migrate();
    
    /**
     * Temporarily restores the virtual machine to the state of a snapshot.
     * 
     * The snapshot is indicated with the `snapshot.id` parameter. It is restored temporarily, so that the content can
     * be inspected. Once that inspection is finished, the state of the virtual machine can be made permanent, using the
     * <<services/vm/methods/commit_snapshot, commit_snapshot>> method, or discarded using the
     * <<services/vm/methods/undo_snapshot, undo_snapshot>> method.
     */
    public interface PreviewSnapshotRequest extends Request<PreviewSnapshotRequest, PreviewSnapshotResponse> {
        /**
         * Indicates if the preview should be performed asynchronously.
         */
        PreviewSnapshotRequest async(Boolean async);
        PreviewSnapshotRequest disks(List<Disk> disks);
        /**
         * Specify the disks included in the snapshot's preview.
         * 
         * For each disk parameter, it is also required to specify its `image_id`.
         * 
         * For example, to preview a snapshot with identifier `456` which includes a disk with identifier `111` and its
         * `image_id` as `222`, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/api/vms/123/previewsnapshot
         * ----
         * 
         * Request body:
         * 
         * [source,xml]
         * ----
         * <action>
         *   <disks>
         *     <disk id="111">
         *       <image_id>222</image_id>
         *     </disk>
         *   </disks>
         *   <snapshot id="456"/>
         * </action>
         * ----
         */
        PreviewSnapshotRequest disks(Disk... disks);
        /**
         * Specify the disks included in the snapshot's preview.
         * 
         * For each disk parameter, it is also required to specify its `image_id`.
         * 
         * For example, to preview a snapshot with identifier `456` which includes a disk with identifier `111` and its
         * `image_id` as `222`, send a request like this:
         * 
         * [source]
         * ----
         * POST /ovirt-engine/api/vms/123/previewsnapshot
         * ----
         * 
         * Request body:
         * 
         * [source,xml]
         * ----
         * <action>
         *   <disks>
         *     <disk id="111">
         *       <image_id>222</image_id>
         *     </disk>
         *   </disks>
         *   <snapshot id="456"/>
         * </action>
         * ----
         */
        PreviewSnapshotRequest disks(DiskBuilder... disks);
        PreviewSnapshotRequest lease(StorageDomainLease lease);
        /**
         * Specify the lease storage domain ID to use in the preview of the snapshot.
         * If lease parameter is not passed, then the previewed snapshot lease storage domain will be used.
         * If lease parameter is passed with empty storage domain parameter, then no lease will be used
         * for the snapshot preview.
         * If lease parameter is passed with storage domain parameter then the storage domain ID can be
         * only one of the leases domain IDs that belongs to one of the virtual machine snapshots.
         * This is an optional parameter, set by default to `null`
         */
        PreviewSnapshotRequest lease(StorageDomainLeaseBuilder lease);
        PreviewSnapshotRequest restoreMemory(Boolean restoreMemory);
        PreviewSnapshotRequest snapshot(Snapshot snapshot);
        PreviewSnapshotRequest snapshot(SnapshotBuilder snapshot);
        PreviewSnapshotRequest vm(Vm vm);
        PreviewSnapshotRequest vm(VmBuilder vm);
    }
    
    /**
     * Temporarily restores the virtual machine to the state of a snapshot.
     * 
     * The snapshot is indicated with the `snapshot.id` parameter. It is restored temporarily, so that the content can
     * be inspected. Once that inspection is finished, the state of the virtual machine can be made permanent, using the
     * <<services/vm/methods/commit_snapshot, commit_snapshot>> method, or discarded using the
     * <<services/vm/methods/undo_snapshot, undo_snapshot>> method.
     */
    public interface PreviewSnapshotResponse extends Response {
    }
    
    /**
     * Temporarily restores the virtual machine to the state of a snapshot.
     * 
     * The snapshot is indicated with the `snapshot.id` parameter. It is restored temporarily, so that the content can
     * be inspected. Once that inspection is finished, the state of the virtual machine can be made permanent, using the
     * <<services/vm/methods/commit_snapshot, commit_snapshot>> method, or discarded using the
     * <<services/vm/methods/undo_snapshot, undo_snapshot>> method.
     */
    PreviewSnapshotRequest previewSnapshot();
    
    /**
     * Sends a reboot request to a virtual machine.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/reboot
     * ----
     * 
     * The reboot action does not take any action specific parameters; therefore, the request body should contain an
     * empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * To reboot the VM even if a backup is running for it,
     * the action should include the 'force' element.
     * 
     * For example, to force reboot virtual machine `123`:
     * 
     * ----
     * POST /ovirt-engine/api/vms/123/reboot
     * ----
     * 
     * [source,xml]
     * ----
     * <action>
     *     <force>true</force>
     * </action>
     * ----
     */
    public interface RebootRequest extends Request<RebootRequest, RebootResponse> {
        /**
         * Indicates if the reboot should be performed asynchronously.
         */
        RebootRequest async(Boolean async);
        /**
         * Indicates if the VM should be forcibly rebooted even
         * if a backup is running for it.
         */
        RebootRequest force(Boolean force);
    }
    
    /**
     * Sends a reboot request to a virtual machine.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/reboot
     * ----
     * 
     * The reboot action does not take any action specific parameters; therefore, the request body should contain an
     * empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * To reboot the VM even if a backup is running for it,
     * the action should include the 'force' element.
     * 
     * For example, to force reboot virtual machine `123`:
     * 
     * ----
     * POST /ovirt-engine/api/vms/123/reboot
     * ----
     * 
     * [source,xml]
     * ----
     * <action>
     *     <force>true</force>
     * </action>
     * ----
     */
    public interface RebootResponse extends Response {
    }
    
    /**
     * Sends a reboot request to a virtual machine.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/reboot
     * ----
     * 
     * The reboot action does not take any action specific parameters; therefore, the request body should contain an
     * empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * To reboot the VM even if a backup is running for it,
     * the action should include the 'force' element.
     * 
     * For example, to force reboot virtual machine `123`:
     * 
     * ----
     * POST /ovirt-engine/api/vms/123/reboot
     * ----
     * 
     * [source,xml]
     * ----
     * <action>
     *     <force>true</force>
     * </action>
     * ----
     */
    RebootRequest reboot();
    
    /**
     * Removes the virtual machine, including the virtual disks attached to it.
     * 
     * For example, to remove the virtual machine with identifier `123`:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
        /**
         * Indicates if the attached virtual disks should be detached first and preserved instead of being removed.
         */
        RemoveRequest detachOnly(Boolean detachOnly);
        /**
         * Indicates if the virtual machine should be forcibly removed.
         * 
         * Locked virtual machines and virtual machines with locked disk images
         * cannot be removed without this flag set to true.
         */
        RemoveRequest force(Boolean force);
    }
    
    /**
     * Removes the virtual machine, including the virtual disks attached to it.
     * 
     * For example, to remove the virtual machine with identifier `123`:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the virtual machine, including the virtual disks attached to it.
     * 
     * For example, to remove the virtual machine with identifier `123`:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123
     * ----
     */
    RemoveRequest remove();
    
    public interface ReorderMacAddressesRequest extends Request<ReorderMacAddressesRequest, ReorderMacAddressesResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        ReorderMacAddressesRequest async(Boolean async);
    }
    
    public interface ReorderMacAddressesResponse extends Response {
    }
    
    ReorderMacAddressesRequest reorderMacAddresses();
    
    /**
     * Sends a reset request to a virtual machine.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/reset
     * ----
     * 
     * The reset action does not take any action specific parameters; therefore, the request body should contain an
     * empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface ResetRequest extends Request<ResetRequest, ResetResponse> {
        /**
         * Indicates if the reset should be performed asynchronously.
         */
        ResetRequest async(Boolean async);
    }
    
    /**
     * Sends a reset request to a virtual machine.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/reset
     * ----
     * 
     * The reset action does not take any action specific parameters; therefore, the request body should contain an
     * empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface ResetResponse extends Response {
    }
    
    /**
     * Sends a reset request to a virtual machine.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/reset
     * ----
     * 
     * The reset action does not take any action specific parameters; therefore, the request body should contain an
     * empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    ResetRequest reset();
    
    /**
     * This operation sends a shutdown request to a virtual machine.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/shutdown
     * ----
     * 
     * The shutdown action does not take any action specific parameters;
     * therefore, the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * To shutdown the VM even if a backup is running for it,
     * the action should include the 'force' element.
     * 
     * For example, to force shutdown virtual machine `123`:
     * 
     * ----
     * POST /ovirt-engine/api/vms/123/shutdown
     * ----
     * 
     * [source,xml]
     * ----
     * <action>
     *     <force>true</force>
     * </action>
     * ----
     */
    public interface ShutdownRequest extends Request<ShutdownRequest, ShutdownResponse> {
        /**
         * Indicates if the shutdown should be performed asynchronously.
         */
        ShutdownRequest async(Boolean async);
        /**
         * Indicates if the VM should be forcibly shutdown even
         * if a backup is running for it.
         */
        ShutdownRequest force(Boolean force);
        /**
         * The reason the virtual machine was stopped.
         * Optionally set by user when shutting down the virtual machine.
         */
        ShutdownRequest reason(String reason);
    }
    
    /**
     * This operation sends a shutdown request to a virtual machine.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/shutdown
     * ----
     * 
     * The shutdown action does not take any action specific parameters;
     * therefore, the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * To shutdown the VM even if a backup is running for it,
     * the action should include the 'force' element.
     * 
     * For example, to force shutdown virtual machine `123`:
     * 
     * ----
     * POST /ovirt-engine/api/vms/123/shutdown
     * ----
     * 
     * [source,xml]
     * ----
     * <action>
     *     <force>true</force>
     * </action>
     * ----
     */
    public interface ShutdownResponse extends Response {
    }
    
    /**
     * This operation sends a shutdown request to a virtual machine.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/shutdown
     * ----
     * 
     * The shutdown action does not take any action specific parameters;
     * therefore, the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * To shutdown the VM even if a backup is running for it,
     * the action should include the 'force' element.
     * 
     * For example, to force shutdown virtual machine `123`:
     * 
     * ----
     * POST /ovirt-engine/api/vms/123/shutdown
     * ----
     * 
     * [source,xml]
     * ----
     * <action>
     *     <force>true</force>
     * </action>
     * ----
     */
    ShutdownRequest shutdown();
    
    /**
     * Starts the virtual machine.
     * 
     * If the virtual environment is complete and the virtual machine contains all necessary components to function,
     * it can be started.
     * 
     * This example starts the virtual machine:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/start
     * ----
     * 
     * With a request body:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface StartRequest extends Request<StartRequest, StartResponse> {
        /**
         * Indicates if the start action should be performed asynchronously.
         */
        StartRequest async(Boolean async);
        StartRequest authorizedKey(AuthorizedKey authorizedKey);
        StartRequest authorizedKey(AuthorizedKeyBuilder authorizedKey);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        StartRequest filter(Boolean filter);
        /**
         * If set to `true`, start the virtual machine in paused mode. The default is `false`.
         */
        StartRequest pause(Boolean pause);
        /**
         * If set to `true`, the initialization type is set to _cloud-init_. The default value is `false`.
         * See https://cloudinit.readthedocs.io/en/latest[this] for details.
         */
        StartRequest useCloudInit(Boolean useCloudInit);
        /**
         * If set to `true`, the initialization type is set to _Ignition_. The default value is `false`.
         * See https://coreos.com/ignition/docs/latest/[this] for details.
         */
        StartRequest useIgnition(Boolean useIgnition);
        /**
         * If set to `true`, the initialization type is set by the VM's OS.
         * Windows will set to _Sysprep_, Linux to _cloud-init_ and RedHat CoreOS to _Ignition_.
         * If any of the initialization-types are explicitly set (useCloudInit, useSysprep or useIgnition),
         * they will be prioritized and this flag will be ignored.
         * The default value is `false`.
         */
        StartRequest useInitialization(Boolean useInitialization);
        /**
         * If set to `true`, the initialization type is set to _Sysprep_. The default value is `false`.
         * See https://en.wikipedia.org/wiki/Sysprep[this] for details.
         */
        StartRequest useSysprep(Boolean useSysprep);
        StartRequest vm(Vm vm);
        /**
         * The definition of the virtual machine for this specific run.
         * 
         * For example:
         * 
         * [source,xml]
         * ----
         * <action>
         *   <vm>
         *     <os>
         *       <boot>
         *         <devices>
         *           <device>cdrom</device>
         *         </devices>
         *       </boot>
         *     </os>
         *   </vm>
         * </action>
         * ----
         * 
         * This will set the boot device to the CDROM only for this specific start. After the virtual machine is
         * powered off, this definition will be reverted.
         */
        StartRequest vm(VmBuilder vm);
        /**
         * Indicates that this run configuration will be discarded even in the case of guest-initiated reboot.
         * The default value is `false`.
         */
        StartRequest volatile_(Boolean volatile_);
    }
    
    /**
     * Starts the virtual machine.
     * 
     * If the virtual environment is complete and the virtual machine contains all necessary components to function,
     * it can be started.
     * 
     * This example starts the virtual machine:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/start
     * ----
     * 
     * With a request body:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface StartResponse extends Response {
    }
    
    /**
     * Starts the virtual machine.
     * 
     * If the virtual environment is complete and the virtual machine contains all necessary components to function,
     * it can be started.
     * 
     * This example starts the virtual machine:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/start
     * ----
     * 
     * With a request body:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    StartRequest start();
    
    /**
     * This operation forces a virtual machine to power-off.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/stop
     * ----
     * 
     * The stop action does not take any action specific parameters;
     * therefore, the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * To stop the VM even if a backup is running for it,
     * the action should include the 'force' element.
     * 
     * For example, to force stop virtual machine `123`:
     * 
     * ----
     * POST /ovirt-engine/api/vms/123/stop
     * ----
     * 
     * [source,xml]
     * ----
     * <action>
     *     <force>true</force>
     * </action>
     * ----
     */
    public interface StopRequest extends Request<StopRequest, StopResponse> {
        /**
         * Indicates if the stop action should be performed asynchronously.
         */
        StopRequest async(Boolean async);
        /**
         * Indicates if the VM should be forcibly stop even
         * if a backup is running for it.
         */
        StopRequest force(Boolean force);
        /**
         * The reason the virtual machine was stopped.
         * Optionally set by user when shutting down the virtual machine.
         */
        StopRequest reason(String reason);
    }
    
    /**
     * This operation forces a virtual machine to power-off.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/stop
     * ----
     * 
     * The stop action does not take any action specific parameters;
     * therefore, the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * To stop the VM even if a backup is running for it,
     * the action should include the 'force' element.
     * 
     * For example, to force stop virtual machine `123`:
     * 
     * ----
     * POST /ovirt-engine/api/vms/123/stop
     * ----
     * 
     * [source,xml]
     * ----
     * <action>
     *     <force>true</force>
     * </action>
     * ----
     */
    public interface StopResponse extends Response {
    }
    
    /**
     * This operation forces a virtual machine to power-off.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/stop
     * ----
     * 
     * The stop action does not take any action specific parameters;
     * therefore, the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * To stop the VM even if a backup is running for it,
     * the action should include the 'force' element.
     * 
     * For example, to force stop virtual machine `123`:
     * 
     * ----
     * POST /ovirt-engine/api/vms/123/stop
     * ----
     * 
     * [source,xml]
     * ----
     * <action>
     *     <force>true</force>
     * </action>
     * ----
     */
    StopRequest stop();
    
    /**
     * This operation saves the virtual machine state to disk and stops it.
     * Start a suspended virtual machine and restore the virtual machine state with the start action.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/suspend
     * ----
     * 
     * The suspend action does not take any action specific parameters;
     * therefore, the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface SuspendRequest extends Request<SuspendRequest, SuspendResponse> {
        /**
         * Indicates if the suspend action should be performed asynchronously.
         */
        SuspendRequest async(Boolean async);
    }
    
    /**
     * This operation saves the virtual machine state to disk and stops it.
     * Start a suspended virtual machine and restore the virtual machine state with the start action.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/suspend
     * ----
     * 
     * The suspend action does not take any action specific parameters;
     * therefore, the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface SuspendResponse extends Response {
    }
    
    /**
     * This operation saves the virtual machine state to disk and stops it.
     * Start a suspended virtual machine and restore the virtual machine state with the start action.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/suspend
     * ----
     * 
     * The suspend action does not take any action specific parameters;
     * therefore, the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    SuspendRequest suspend();
    
    /**
     * Thaws virtual machine file systems.
     * 
     * This operation thaws a virtual machine's file systems using the QEMU guest agent when taking a live snapshot of a
     * running virtual machine. Normally, this is done automatically by the manager, but this must be executed manually
     * with the API for virtual machines using OpenStack Volume (Cinder) disks.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /api/vms/123/thawfilesystems
     * ----
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface ThawFilesystemsRequest extends Request<ThawFilesystemsRequest, ThawFilesystemsResponse> {
        /**
         * Indicates if the thaw file systems action should be performed asynchronously.
         */
        ThawFilesystemsRequest async(Boolean async);
    }
    
    /**
     * Thaws virtual machine file systems.
     * 
     * This operation thaws a virtual machine's file systems using the QEMU guest agent when taking a live snapshot of a
     * running virtual machine. Normally, this is done automatically by the manager, but this must be executed manually
     * with the API for virtual machines using OpenStack Volume (Cinder) disks.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /api/vms/123/thawfilesystems
     * ----
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface ThawFilesystemsResponse extends Response {
    }
    
    /**
     * Thaws virtual machine file systems.
     * 
     * This operation thaws a virtual machine's file systems using the QEMU guest agent when taking a live snapshot of a
     * running virtual machine. Normally, this is done automatically by the manager, but this must be executed manually
     * with the API for virtual machines using OpenStack Volume (Cinder) disks.
     * 
     * Example:
     * 
     * [source]
     * ----
     * POST /api/vms/123/thawfilesystems
     * ----
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    ThawFilesystemsRequest thawFilesystems();
    
    /**
     * Generates a time-sensitive authentication token for accessing a virtual machine's display.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/ticket
     * ----
     * 
     * The client-provided action optionally includes a desired ticket value and/or an expiry time in seconds.
     * 
     * The response specifies the actual ticket value and expiry used.
     * 
     * [source,xml]
     * ----
     * <action>
     *   <ticket>
     *     <value>abcd12345</value>
     *     <expiry>120</expiry>
     *   </ticket>
     * </action>
     * ----
     * 
     * [IMPORTANT]
     * ====
     * If the virtual machine is configured to support only one graphics protocol
     * then the generated authentication token will be valid for that protocol.
     * But if the virtual machine is configured to support multiple protocols,
     * VNC and SPICE, then the authentication token will only be valid for
     * the SPICE protocol.
     * 
     * In order to obtain an authentication token for a specific protocol, for
     * example for VNC, use the `ticket` method of the <<services/vm_graphics_console,
     * service>>, which manages the graphics consoles of the virtual machine, by sending
     * a request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/graphicsconsoles/456/ticket
     * ----
     * ====
     */
    public interface TicketRequest extends Request<TicketRequest, TicketResponse> {
        /**
         * Indicates if the generation of the ticket should be performed asynchronously.
         */
        TicketRequest async(Boolean async);
        TicketRequest ticket(Ticket ticket);
        TicketRequest ticket(TicketBuilder ticket);
    }
    
    /**
     * Generates a time-sensitive authentication token for accessing a virtual machine's display.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/ticket
     * ----
     * 
     * The client-provided action optionally includes a desired ticket value and/or an expiry time in seconds.
     * 
     * The response specifies the actual ticket value and expiry used.
     * 
     * [source,xml]
     * ----
     * <action>
     *   <ticket>
     *     <value>abcd12345</value>
     *     <expiry>120</expiry>
     *   </ticket>
     * </action>
     * ----
     * 
     * [IMPORTANT]
     * ====
     * If the virtual machine is configured to support only one graphics protocol
     * then the generated authentication token will be valid for that protocol.
     * But if the virtual machine is configured to support multiple protocols,
     * VNC and SPICE, then the authentication token will only be valid for
     * the SPICE protocol.
     * 
     * In order to obtain an authentication token for a specific protocol, for
     * example for VNC, use the `ticket` method of the <<services/vm_graphics_console,
     * service>>, which manages the graphics consoles of the virtual machine, by sending
     * a request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/graphicsconsoles/456/ticket
     * ----
     * ====
     */
    public interface TicketResponse extends Response {
        Ticket ticket();
    }
    
    /**
     * Generates a time-sensitive authentication token for accessing a virtual machine's display.
     * 
     * For example:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/ticket
     * ----
     * 
     * The client-provided action optionally includes a desired ticket value and/or an expiry time in seconds.
     * 
     * The response specifies the actual ticket value and expiry used.
     * 
     * [source,xml]
     * ----
     * <action>
     *   <ticket>
     *     <value>abcd12345</value>
     *     <expiry>120</expiry>
     *   </ticket>
     * </action>
     * ----
     * 
     * [IMPORTANT]
     * ====
     * If the virtual machine is configured to support only one graphics protocol
     * then the generated authentication token will be valid for that protocol.
     * But if the virtual machine is configured to support multiple protocols,
     * VNC and SPICE, then the authentication token will only be valid for
     * the SPICE protocol.
     * 
     * In order to obtain an authentication token for a specific protocol, for
     * example for VNC, use the `ticket` method of the <<services/vm_graphics_console,
     * service>>, which manages the graphics consoles of the virtual machine, by sending
     * a request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/graphicsconsoles/456/ticket
     * ----
     * ====
     */
    TicketRequest ticket();
    
    /**
     * Exports a virtual machine to an export domain.
     */
    public interface ExportToExportDomainRequest extends Request<ExportToExportDomainRequest, ExportToExportDomainResponse> {
        /**
         * Indicates if the export should be performed asynchronously.
         */
        ExportToExportDomainRequest async(Boolean async);
        /**
         * Use the `discard_snapshots` parameter when the virtual machine should be exported with all of its
         * snapshots collapsed.
         */
        ExportToExportDomainRequest discardSnapshots(Boolean discardSnapshots);
        /**
         * Use the `exclusive` parameter when the virtual machine should be exported even if another copy of
         * it already exists in the export domain (override).
         */
        ExportToExportDomainRequest exclusive(Boolean exclusive);
        ExportToExportDomainRequest storageDomain(StorageDomain storageDomain);
        /**
         * The (export) storage domain to export the virtual machine to.
         */
        ExportToExportDomainRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Exports a virtual machine to an export domain.
     */
    public interface ExportToExportDomainResponse extends Response {
    }
    
    /**
     * Exports a virtual machine to an export domain.
     */
    ExportToExportDomainRequest exportToExportDomain();
    
    /**
     * Exports a virtual machine as an OVA file to a given path on a specified host.
     */
    public interface ExportToPathOnHostRequest extends Request<ExportToPathOnHostRequest, ExportToPathOnHostResponse> {
        /**
         * Indicates if the export should be performed asynchronously.
         */
        ExportToPathOnHostRequest async(Boolean async);
        /**
         * An absolute path of a directory on the host to generate the OVA file in.
         */
        ExportToPathOnHostRequest directory(String directory);
        /**
         * Use the `discard_snapshots` parameter when the virtual machine should be exported with all of its
         * snapshots collapsed.
         */
        ExportToPathOnHostRequest discardSnapshots(Boolean discardSnapshots);
        /**
         * Use the `exclusive` parameter when the virtual machine should be exported even if another copy of
         * it already exists in the export domain (override).
         */
        ExportToPathOnHostRequest exclusive(Boolean exclusive);
        /**
         * The name of the OVA file.
         * 
         * This is an optional parameter, if it is not specified then the name of OVA file is determined according
         * to the name of the virtual machine. It will conform the following pattern: "<virtual machine name>.ova".
         */
        ExportToPathOnHostRequest filename(String filename);
        ExportToPathOnHostRequest host(Host host);
        /**
         * The host to generate the OVA file on.
         */
        ExportToPathOnHostRequest host(HostBuilder host);
        ExportToPathOnHostRequest storageDomain(StorageDomain storageDomain);
        /**
         * The (export) storage domain to export the virtual machine to.
         */
        ExportToPathOnHostRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Exports a virtual machine as an OVA file to a given path on a specified host.
     */
    public interface ExportToPathOnHostResponse extends Response {
    }
    
    /**
     * Exports a virtual machine as an OVA file to a given path on a specified host.
     */
    ExportToPathOnHostRequest exportToPathOnHost();
    
    /**
     * Restores the virtual machine to the state it had before previewing the snapshot.
     * 
     * See the <<services/vm/methods/preview_snapshot, preview_snapshot>> operation for details.
     */
    public interface UndoSnapshotRequest extends Request<UndoSnapshotRequest, UndoSnapshotResponse> {
        /**
         * Indicates if the undo snapshot action should be performed asynchronously.
         */
        UndoSnapshotRequest async(Boolean async);
    }
    
    /**
     * Restores the virtual machine to the state it had before previewing the snapshot.
     * 
     * See the <<services/vm/methods/preview_snapshot, preview_snapshot>> operation for details.
     */
    public interface UndoSnapshotResponse extends Response {
    }
    
    /**
     * Restores the virtual machine to the state it had before previewing the snapshot.
     * 
     * See the <<services/vm/methods/preview_snapshot, preview_snapshot>> operation for details.
     */
    UndoSnapshotRequest undoSnapshot();
    
    /**
     * Update the virtual machine in the system for the given virtual machine id.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        /**
         * Indicates if the update should be applied to the virtual machine immediately or if it should be applied only
         * when the virtual machine is restarted. The default value is `false`, so by default changes are applied
         * immediately.
         */
        UpdateRequest nextRun(Boolean nextRun);
        UpdateRequest vm(Vm vm);
        UpdateRequest vm(VmBuilder vm);
    }
    
    /**
     * Update the virtual machine in the system for the given virtual machine id.
     */
    public interface UpdateResponse extends Response {
        Vm vm();
    }
    
    /**
     * Update the virtual machine in the system for the given virtual machine id.
     */
    UpdateRequest update();
    
    /**
     * List of scheduling labels assigned to this virtual machine.
     */
    AssignedAffinityLabelsService affinityLabelsService();
    VmApplicationsService applicationsService();
    /**
     * List of backups of this virtual machine.
     */
    VmBackupsService backupsService();
    VmCdromsService cdromsService();
    /**
     * List of checkpoints of this virtual machine.
     */
    VmCheckpointsService checkpointsService();
    /**
     * List of disks attached to this virtual machine.
     */
    DiskAttachmentsService diskAttachmentsService();
    VmGraphicsConsolesService graphicsConsolesService();
    VmHostDevicesService hostDevicesService();
    /**
     * Reference to the service that can show the applicable errata available on the virtual machine.
     * This information is taken from Katello.
     */
    KatelloErrataService katelloErrataService();
    VmNicsService nicsService();
    VmNumaNodesService numaNodesService();
    AssignedPermissionsService permissionsService();
    VmReportedDevicesService reportedDevicesService();
    /**
     * Reference to the service that provides information about virtual machine user sessions.
     */
    VmSessionsService sessionsService();
    SnapshotsService snapshotsService();
    AssignedTagsService tagsService();
    VmWatchdogsService watchdogsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

