/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.DiskBuilder;
import org.ovirt.engine.sdk4.types.Disk;

/**
 * Manages the collection of disks available inside an storage domain that is attached to a data center.
 */
public interface AttachedStorageDomainDisksService extends Service {
    /**
     * Adds or registers a disk.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To add a new disk use the <<services/disks/methods/add, add>>
     * operation of the service that manages the disks of the system. To register an unregistered disk use the
     * <<services/attached_storage_domain_disk/methods/register, register>> operation of the service that manages
     * that disk.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest disk(Disk disk);
        /**
         * The disk to add or register.
         */
        AddRequest disk(DiskBuilder disk);
        /**
         * Indicates if a new disk should be added or if an existing unregistered disk should be registered. If the
         * value is `true` then the identifier of the disk to register needs to be provided. For example, to register
         * the disk with id `456` send a request like this:
         * 
         * ....
         * POST /ovirt-engine/api/storagedomains/123/disks?unregistered=true
         * ....
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <disk id="456"/>
         * ----
         * 
         * If the value is `false` then a new disk will be created in the storage domain. In that case the
         * `provisioned_size`, `format` and `name` attributes are mandatory. For example, to create a new
         * _copy on write_ disk of 1 GiB, send a request like this:
         * 
         * ....
         * POST /ovirt-engine/api/storagedomains/123/disks
         * ....
         * 
         * With a request body like this:
         * 
         * [source,xml]
         * ----
         * <disk>
         *   <name>mydisk</name>
         *   <format>cow</format>
         *   <provisioned_size>1073741824</provisioned_size>
         * </disk>
         * ----
         * 
         * The default value is `false`.
         */
        AddRequest unregistered(Boolean unregistered);
    }
    
    /**
     * Adds or registers a disk.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To add a new disk use the <<services/disks/methods/add, add>>
     * operation of the service that manages the disks of the system. To register an unregistered disk use the
     * <<services/attached_storage_domain_disk/methods/register, register>> operation of the service that manages
     * that disk.
     */
    public interface AddResponse extends Response {
        /**
         * The disk to add or register.
         */
        Disk disk();
    }
    
    /**
     * Adds or registers a disk.
     * 
     * IMPORTANT: Since version 4.2 of the engine this operation is deprecated, and preserved only for backwards
     * compatibility. It will be removed in the future. To add a new disk use the <<services/disks/methods/add, add>>
     * operation of the service that manages the disks of the system. To register an unregistered disk use the
     * <<services/attached_storage_domain_disk/methods/register, register>> operation of the service that manages
     * that disk.
     */
    AddRequest add();
    
    /**
     * Retrieve the list of disks that are available in the storage domain.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of disks to return. If not specified all the disks are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of disks to return. If not specified all the disks are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of disks to return. If not specified all the disks are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Retrieve the list of disks that are available in the storage domain.
     */
    public interface ListResponse extends Response {
        /**
         * List of retrieved disks.
         * 
         * The order of the returned disks isn't guaranteed.
         */
        List<Disk> disks();
    }
    
    /**
     * Retrieve the list of disks that are available in the storage domain.
     */
    ListRequest list();
    
    /**
     * Reference to the service that manages a specific disk.
     */
    AttachedStorageDomainDiskService diskService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

