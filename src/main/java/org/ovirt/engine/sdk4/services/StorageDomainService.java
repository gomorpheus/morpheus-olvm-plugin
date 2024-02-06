/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.lang.Boolean;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.HostBuilder;
import org.ovirt.engine.sdk4.builders.LogicalUnitBuilder;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.LogicalUnit;
import org.ovirt.engine.sdk4.types.StorageDomain;

public interface StorageDomainService extends Service {
    /**
     * Retrieves the description of the storage domain.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        GetRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieves the description of the storage domain.
     */
    public interface GetResponse extends Response {
        /**
         * The description of the storage domain.
         */
        StorageDomain storageDomain();
    }
    
    /**
     * Retrieves the description of the storage domain.
     */
    GetRequest get();
    
    /**
     * Used for querying if the storage domain is already attached to a data center using
     * the is_attached boolean field, which is part of the storage server. IMPORTANT:
     * Executing this API will cause the host to disconnect from the storage domain.
     */
    public interface IsAttachedRequest extends Request<IsAttachedRequest, IsAttachedResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        IsAttachedRequest async(Boolean async);
        IsAttachedRequest host(Host host);
        /**
         * Indicates the data center's host.
         */
        IsAttachedRequest host(HostBuilder host);
    }
    
    /**
     * Used for querying if the storage domain is already attached to a data center using
     * the is_attached boolean field, which is part of the storage server. IMPORTANT:
     * Executing this API will cause the host to disconnect from the storage domain.
     */
    public interface IsAttachedResponse extends Response {
        /**
         * Indicates whether the storage domain is attached to the data center.
         */
        Boolean isAttached();
    }
    
    /**
     * Used for querying if the storage domain is already attached to a data center using
     * the is_attached boolean field, which is part of the storage server. IMPORTANT:
     * Executing this API will cause the host to disconnect from the storage domain.
     */
    IsAttachedRequest isAttached();
    
    /**
     * This operation reduces logical units from the storage domain.
     * 
     * In order to do so the data stored on the provided logical units will be moved to other logical units of the
     * storage domain and only then they will be reduced from the storage domain.
     * 
     * For example, in order to reduce two logical units from a storage domain send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storageDomains/123/reduceluns
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     *  <action>
     *    <logical_units>
     *      <logical_unit id="1IET_00010001"/>
     *      <logical_unit id="1IET_00010002"/>
     *    </logical_units>
     *  </action>
     * ----
     * 
     *  Note that this operation is only applicable to block storage domains (i.e., storage domains with the
     *  <<types/storage_type, storage type> of iSCSI or FCP).
     */
    public interface ReduceLunsRequest extends Request<ReduceLunsRequest, ReduceLunsResponse> {
        ReduceLunsRequest logicalUnits(List<LogicalUnit> logicalUnits);
        /**
         * The logical units that need to be reduced from the storage domain.
         */
        ReduceLunsRequest logicalUnits(LogicalUnit... logicalUnits);
        /**
         * The logical units that need to be reduced from the storage domain.
         */
        ReduceLunsRequest logicalUnits(LogicalUnitBuilder... logicalUnits);
    }
    
    /**
     * This operation reduces logical units from the storage domain.
     * 
     * In order to do so the data stored on the provided logical units will be moved to other logical units of the
     * storage domain and only then they will be reduced from the storage domain.
     * 
     * For example, in order to reduce two logical units from a storage domain send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storageDomains/123/reduceluns
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     *  <action>
     *    <logical_units>
     *      <logical_unit id="1IET_00010001"/>
     *      <logical_unit id="1IET_00010002"/>
     *    </logical_units>
     *  </action>
     * ----
     * 
     *  Note that this operation is only applicable to block storage domains (i.e., storage domains with the
     *  <<types/storage_type, storage type> of iSCSI or FCP).
     */
    public interface ReduceLunsResponse extends Response {
    }
    
    /**
     * This operation reduces logical units from the storage domain.
     * 
     * In order to do so the data stored on the provided logical units will be moved to other logical units of the
     * storage domain and only then they will be reduced from the storage domain.
     * 
     * For example, in order to reduce two logical units from a storage domain send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storageDomains/123/reduceluns
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     *  <action>
     *    <logical_units>
     *      <logical_unit id="1IET_00010001"/>
     *      <logical_unit id="1IET_00010002"/>
     *    </logical_units>
     *  </action>
     * ----
     * 
     *  Note that this operation is only applicable to block storage domains (i.e., storage domains with the
     *  <<types/storage_type, storage type> of iSCSI or FCP).
     */
    ReduceLunsRequest reduceLuns();
    
    /**
     * This operation refreshes the LUN size.
     * 
     * After increasing the size of the underlying LUN on the storage server,
     * the user can refresh the LUN size.
     * This action forces a rescan of the provided LUNs and
     * updates the database with the new size, if required.
     * 
     * For example, in order to refresh the size of two LUNs send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storageDomains/262b056b-aede-40f1-9666-b883eff59d40/refreshluns
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     *  <action>
     *    <logical_units>
     *      <logical_unit id="1IET_00010001"/>
     *      <logical_unit id="1IET_00010002"/>
     *    </logical_units>
     *  </action>
     * ----
     */
    public interface RefreshLunsRequest extends Request<RefreshLunsRequest, RefreshLunsResponse> {
        /**
         * Indicates if the refresh should be performed asynchronously.
         */
        RefreshLunsRequest async(Boolean async);
        RefreshLunsRequest logicalUnits(List<LogicalUnit> logicalUnits);
        /**
         * The LUNs that need to be refreshed.
         */
        RefreshLunsRequest logicalUnits(LogicalUnit... logicalUnits);
        /**
         * The LUNs that need to be refreshed.
         */
        RefreshLunsRequest logicalUnits(LogicalUnitBuilder... logicalUnits);
    }
    
    /**
     * This operation refreshes the LUN size.
     * 
     * After increasing the size of the underlying LUN on the storage server,
     * the user can refresh the LUN size.
     * This action forces a rescan of the provided LUNs and
     * updates the database with the new size, if required.
     * 
     * For example, in order to refresh the size of two LUNs send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storageDomains/262b056b-aede-40f1-9666-b883eff59d40/refreshluns
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     *  <action>
     *    <logical_units>
     *      <logical_unit id="1IET_00010001"/>
     *      <logical_unit id="1IET_00010002"/>
     *    </logical_units>
     *  </action>
     * ----
     */
    public interface RefreshLunsResponse extends Response {
    }
    
    /**
     * This operation refreshes the LUN size.
     * 
     * After increasing the size of the underlying LUN on the storage server,
     * the user can refresh the LUN size.
     * This action forces a rescan of the provided LUNs and
     * updates the database with the new size, if required.
     * 
     * For example, in order to refresh the size of two LUNs send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storageDomains/262b056b-aede-40f1-9666-b883eff59d40/refreshluns
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     *  <action>
     *    <logical_units>
     *      <logical_unit id="1IET_00010001"/>
     *      <logical_unit id="1IET_00010002"/>
     *    </logical_units>
     *  </action>
     * ----
     */
    RefreshLunsRequest refreshLuns();
    
    /**
     * Removes the storage domain.
     * 
     * Without any special parameters, the storage domain is detached from the system and removed from the database. The
     * storage domain can then be imported to the same or to a different setup, with all the data on it. If the storage is
     * not accessible the operation will fail.
     * 
     * If the `destroy` parameter is `true` then the operation will always succeed, even if the storage is not
     * accessible, the failure is just ignored and the storage domain is removed from the database anyway.
     * 
     * If the `format` parameter is `true` then the actual storage is formatted, and the metadata is removed from the
     * LUN or directory, so it can no longer be imported to the same or to a different setup.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
        /**
         * Indicates if the operation should succeed, and the storage domain removed from the database, even if the
         * storage is not accessible.
         * 
         * [source]
         * ----
         * DELETE /ovirt-engine/api/storageDomains/123?destroy=true
         * ----
         * 
         * This parameter is optional, and the default value is `false`.
         * When the value of `destroy` is `true` the `host` parameter will be ignored.
         */
        RemoveRequest destroy(Boolean destroy);
        /**
         * Indicates if the actual storage should be formatted, removing all the metadata from the underlying LUN or
         * directory:
         * 
         * [source]
         * ----
         * DELETE /ovirt-engine/api/storageDomains/123?format=true
         * ----
         * 
         * This parameter is optional, and the default value is `false`.
         */
        RemoveRequest format(Boolean format);
        /**
         * Indicates which host should be used to remove the storage domain.
         * 
         * This parameter is mandatory, except if the `destroy` parameter is included and its value is `true`, in that
         * case the `host` parameter will be ignored.
         * 
         * The value should contain the name or the identifier of the host. For example, to use the host named `myhost`
         * to remove the storage domain with identifier `123` send a request like this:
         * 
         * [source]
         * ----
         * DELETE /ovirt-engine/api/storageDomains/123?host=myhost
         * ----
         */
        RemoveRequest host(String host);
    }
    
    /**
     * Removes the storage domain.
     * 
     * Without any special parameters, the storage domain is detached from the system and removed from the database. The
     * storage domain can then be imported to the same or to a different setup, with all the data on it. If the storage is
     * not accessible the operation will fail.
     * 
     * If the `destroy` parameter is `true` then the operation will always succeed, even if the storage is not
     * accessible, the failure is just ignored and the storage domain is removed from the database anyway.
     * 
     * If the `format` parameter is `true` then the actual storage is formatted, and the metadata is removed from the
     * LUN or directory, so it can no longer be imported to the same or to a different setup.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the storage domain.
     * 
     * Without any special parameters, the storage domain is detached from the system and removed from the database. The
     * storage domain can then be imported to the same or to a different setup, with all the data on it. If the storage is
     * not accessible the operation will fail.
     * 
     * If the `destroy` parameter is `true` then the operation will always succeed, even if the storage is not
     * accessible, the failure is just ignored and the storage domain is removed from the database anyway.
     * 
     * If the `format` parameter is `true` then the actual storage is formatted, and the metadata is removed from the
     * LUN or directory, so it can no longer be imported to the same or to a different setup.
     */
    RemoveRequest remove();
    
    /**
     * Updates a storage domain.
     * 
     * Not all of the <<types/storage_domain,StorageDomain>>'s attributes are updatable after creation. Those that can be
     * updated are: `name`, `description`, `comment`, `warning_low_space_indicator`, `critical_space_action_blocker` and
     * `wipe_after_delete.` (Note that changing the `wipe_after_delete` attribute will not change the wipe after delete
     * property of disks that already exist).
     * 
     * To update the `name` and `wipe_after_delete` attributes of a storage domain with an identifier `123`, send a
     * request as follows:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/storageDomains/123
     * ----
     * 
     * With a request body as follows:
     * 
     * [source,xml]
     * ----
     * <storage_domain>
     *   <name>data2</name>
     *   <wipe_after_delete>true</wipe_after_delete>
     * </storage_domain>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest storageDomain(StorageDomain storageDomain);
        /**
         * The updated storage domain.
         */
        UpdateRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Updates a storage domain.
     * 
     * Not all of the <<types/storage_domain,StorageDomain>>'s attributes are updatable after creation. Those that can be
     * updated are: `name`, `description`, `comment`, `warning_low_space_indicator`, `critical_space_action_blocker` and
     * `wipe_after_delete.` (Note that changing the `wipe_after_delete` attribute will not change the wipe after delete
     * property of disks that already exist).
     * 
     * To update the `name` and `wipe_after_delete` attributes of a storage domain with an identifier `123`, send a
     * request as follows:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/storageDomains/123
     * ----
     * 
     * With a request body as follows:
     * 
     * [source,xml]
     * ----
     * <storage_domain>
     *   <name>data2</name>
     *   <wipe_after_delete>true</wipe_after_delete>
     * </storage_domain>
     * ----
     */
    public interface UpdateResponse extends Response {
        /**
         * The updated storage domain.
         */
        StorageDomain storageDomain();
    }
    
    /**
     * Updates a storage domain.
     * 
     * Not all of the <<types/storage_domain,StorageDomain>>'s attributes are updatable after creation. Those that can be
     * updated are: `name`, `description`, `comment`, `warning_low_space_indicator`, `critical_space_action_blocker` and
     * `wipe_after_delete.` (Note that changing the `wipe_after_delete` attribute will not change the wipe after delete
     * property of disks that already exist).
     * 
     * To update the `name` and `wipe_after_delete` attributes of a storage domain with an identifier `123`, send a
     * request as follows:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/storageDomains/123
     * ----
     * 
     * With a request body as follows:
     * 
     * [source,xml]
     * ----
     * <storage_domain>
     *   <name>data2</name>
     *   <wipe_after_delete>true</wipe_after_delete>
     * </storage_domain>
     * ----
     */
    UpdateRequest update();
    
    /**
     * This operation forces the update of the `OVF_STORE`
     * of this storage domain.
     * 
     * The `OVF_STORE` is a disk image that contains the metadata
     * of virtual machines and disks that reside in the
     * storage domain. This metadata is used in case the
     * domain is imported or exported to or from a different
     * data center or a different installation.
     * 
     * By default the `OVF_STORE` is updated periodically
     * (set by default to 60 minutes) but users might want to force an
     * update after an important change, or when the they believe the
     * `OVF_STORE` is corrupt.
     * 
     * When initiated by the user, `OVF_STORE` update will be performed whether
     * an update is needed or not.
     */
    public interface UpdateOvfStoreRequest extends Request<UpdateOvfStoreRequest, UpdateOvfStoreResponse> {
        /**
         * Indicates if the `OVF_STORE` update should be performed asynchronously.
         */
        UpdateOvfStoreRequest async(Boolean async);
    }
    
    /**
     * This operation forces the update of the `OVF_STORE`
     * of this storage domain.
     * 
     * The `OVF_STORE` is a disk image that contains the metadata
     * of virtual machines and disks that reside in the
     * storage domain. This metadata is used in case the
     * domain is imported or exported to or from a different
     * data center or a different installation.
     * 
     * By default the `OVF_STORE` is updated periodically
     * (set by default to 60 minutes) but users might want to force an
     * update after an important change, or when the they believe the
     * `OVF_STORE` is corrupt.
     * 
     * When initiated by the user, `OVF_STORE` update will be performed whether
     * an update is needed or not.
     */
    public interface UpdateOvfStoreResponse extends Response {
    }
    
    /**
     * This operation forces the update of the `OVF_STORE`
     * of this storage domain.
     * 
     * The `OVF_STORE` is a disk image that contains the metadata
     * of virtual machines and disks that reside in the
     * storage domain. This metadata is used in case the
     * domain is imported or exported to or from a different
     * data center or a different installation.
     * 
     * By default the `OVF_STORE` is updated periodically
     * (set by default to 60 minutes) but users might want to force an
     * update after an important change, or when the they believe the
     * `OVF_STORE` is corrupt.
     * 
     * When initiated by the user, `OVF_STORE` update will be performed whether
     * an update is needed or not.
     */
    UpdateOvfStoreRequest updateOvfStore();
    
    AssignedDiskProfilesService diskProfilesService();
    DiskSnapshotsService diskSnapshotsService();
    /**
     * Reference to the service that manages the disks available in the storage domain.
     */
    StorageDomainDisksService disksService();
    /**
     * Returns a reference to the service that manages the files available in the storage domain.
     */
    FilesService filesService();
    ImagesService imagesService();
    AssignedPermissionsService permissionsService();
    /**
     * Returns a reference to the service that manages the storage connections.
     */
    StorageDomainServerConnectionsService storageConnectionsService();
    StorageDomainTemplatesService templatesService();
    StorageDomainVmsService vmsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

