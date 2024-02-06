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
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.types.StorageDomain;

/**
 * Manages the set of storage domains in the system.
 */
public interface StorageDomainsService extends Service {
    /**
     * Adds a new storage domain.
     * 
     * Creation of a new <<types/storage_domain,StorageDomain>> requires the `name`, `type`, `host`, and `storage`
     * attributes. Identify the `host` attribute with the `id` or `name` attributes. In {product-name} 3.6 and
     * later you can enable the wipe after delete option by default on the storage domain. To configure this, specify
     * `wipe_after_delete` in the POST request. This option can be edited after the domain is created, but doing so will
     * not change the wipe after delete property of disks that already exist.
     * 
     * To add a new storage domain with specified `name`, `type`, `storage.type`, `storage.address`, and `storage.path`,
     * and using a host with an id `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storageDomains
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_domain>
     *   <name>mydata</name>
     *   <type>data</type>
     *   <storage>
     *     <type>nfs</type>
     *     <address>mynfs.example.com</address>
     *     <path>/exports/mydata</path>
     *   </storage>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     * </storage_domain>
     * ----
     * 
     * To create a new NFS ISO storage domain send a request like this:
     * 
     * [source,xml]
     * ----
     * <storage_domain>
     *   <name>myisos</name>
     *   <type>iso</type>
     *   <storage>
     *     <type>nfs</type>
     *     <address>mynfs.example.com</address>
     *     <path>/export/myisos</path>
     *   </storage>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     * </storage_domain>
     * ----
     * 
     * To create a new iSCSI storage domain send a request like this:
     * 
     * [source,xml]
     * ----
     * <storage_domain>
     *   <name>myiscsi</name>
     *   <type>data</type>
     *   <storage>
     *     <type>iscsi</type>
     *     <logical_units>
     *       <logical_unit id="3600144f09dbd050000004eedbd340001"/>
     *       <logical_unit id="3600144f09dbd050000004eedbd340002"/>
     *     </logical_units>
     *   </storage>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     * </storage_domain>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest storageDomain(StorageDomain storageDomain);
        /**
         * The storage domain to add.
         */
        AddRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Adds a new storage domain.
     * 
     * Creation of a new <<types/storage_domain,StorageDomain>> requires the `name`, `type`, `host`, and `storage`
     * attributes. Identify the `host` attribute with the `id` or `name` attributes. In {product-name} 3.6 and
     * later you can enable the wipe after delete option by default on the storage domain. To configure this, specify
     * `wipe_after_delete` in the POST request. This option can be edited after the domain is created, but doing so will
     * not change the wipe after delete property of disks that already exist.
     * 
     * To add a new storage domain with specified `name`, `type`, `storage.type`, `storage.address`, and `storage.path`,
     * and using a host with an id `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storageDomains
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_domain>
     *   <name>mydata</name>
     *   <type>data</type>
     *   <storage>
     *     <type>nfs</type>
     *     <address>mynfs.example.com</address>
     *     <path>/exports/mydata</path>
     *   </storage>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     * </storage_domain>
     * ----
     * 
     * To create a new NFS ISO storage domain send a request like this:
     * 
     * [source,xml]
     * ----
     * <storage_domain>
     *   <name>myisos</name>
     *   <type>iso</type>
     *   <storage>
     *     <type>nfs</type>
     *     <address>mynfs.example.com</address>
     *     <path>/export/myisos</path>
     *   </storage>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     * </storage_domain>
     * ----
     * 
     * To create a new iSCSI storage domain send a request like this:
     * 
     * [source,xml]
     * ----
     * <storage_domain>
     *   <name>myiscsi</name>
     *   <type>data</type>
     *   <storage>
     *     <type>iscsi</type>
     *     <logical_units>
     *       <logical_unit id="3600144f09dbd050000004eedbd340001"/>
     *       <logical_unit id="3600144f09dbd050000004eedbd340002"/>
     *     </logical_units>
     *   </storage>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     * </storage_domain>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The storage domain to add.
         */
        StorageDomain storageDomain();
    }
    
    /**
     * Adds a new storage domain.
     * 
     * Creation of a new <<types/storage_domain,StorageDomain>> requires the `name`, `type`, `host`, and `storage`
     * attributes. Identify the `host` attribute with the `id` or `name` attributes. In {product-name} 3.6 and
     * later you can enable the wipe after delete option by default on the storage domain. To configure this, specify
     * `wipe_after_delete` in the POST request. This option can be edited after the domain is created, but doing so will
     * not change the wipe after delete property of disks that already exist.
     * 
     * To add a new storage domain with specified `name`, `type`, `storage.type`, `storage.address`, and `storage.path`,
     * and using a host with an id `123`, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/storageDomains
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <storage_domain>
     *   <name>mydata</name>
     *   <type>data</type>
     *   <storage>
     *     <type>nfs</type>
     *     <address>mynfs.example.com</address>
     *     <path>/exports/mydata</path>
     *   </storage>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     * </storage_domain>
     * ----
     * 
     * To create a new NFS ISO storage domain send a request like this:
     * 
     * [source,xml]
     * ----
     * <storage_domain>
     *   <name>myisos</name>
     *   <type>iso</type>
     *   <storage>
     *     <type>nfs</type>
     *     <address>mynfs.example.com</address>
     *     <path>/export/myisos</path>
     *   </storage>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     * </storage_domain>
     * ----
     * 
     * To create a new iSCSI storage domain send a request like this:
     * 
     * [source,xml]
     * ----
     * <storage_domain>
     *   <name>myiscsi</name>
     *   <type>data</type>
     *   <storage>
     *     <type>iscsi</type>
     *     <logical_units>
     *       <logical_unit id="3600144f09dbd050000004eedbd340001"/>
     *       <logical_unit id="3600144f09dbd050000004eedbd340002"/>
     *     </logical_units>
     *   </storage>
     *   <host>
     *     <name>myhost</name>
     *   </host>
     * </storage_domain>
     * ----
     */
    AddRequest add();
    
    /**
     * Import an existing block storage domain to the system using the targets already connected to the host.
     */
    public interface AddBlockDomainRequest extends Request<AddBlockDomainRequest, AddBlockDomainResponse> {
        AddBlockDomainRequest storageDomain(StorageDomain storageDomain);
        /**
         * The storage domain to add.
         */
        AddBlockDomainRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Import an existing block storage domain to the system using the targets already connected to the host.
     */
    public interface AddBlockDomainResponse extends Response {
        /**
         * The storage domain to add.
         */
        StorageDomain storageDomain();
    }
    
    /**
     * Import an existing block storage domain to the system using the targets already connected to the host.
     */
    AddBlockDomainRequest addBlockDomain();
    
    /**
     * Add a new storage domain to the system using the storage on the given host and path.
     */
    public interface AddByPathRequest extends Request<AddByPathRequest, AddByPathResponse> {
        AddByPathRequest storageDomain(StorageDomain storageDomain);
        /**
         * The storage domain to add.
         */
        AddByPathRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Add a new storage domain to the system using the storage on the given host and path.
     */
    public interface AddByPathResponse extends Response {
        /**
         * The storage domain to add.
         */
        StorageDomain storageDomain();
    }
    
    /**
     * Add a new storage domain to the system using the storage on the given host and path.
     */
    AddByPathRequest addByPath();
    
    /**
     * Add a new storage domain to the system using a direct LUN.
     */
    public interface AddDirectLunRequest extends Request<AddDirectLunRequest, AddDirectLunResponse> {
        AddDirectLunRequest storageDomain(StorageDomain storageDomain);
        /**
         * The storage domain to add.
         */
        AddDirectLunRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Add a new storage domain to the system using a direct LUN.
     */
    public interface AddDirectLunResponse extends Response {
        /**
         * The storage domain to add.
         */
        StorageDomain storageDomain();
    }
    
    /**
     * Add a new storage domain to the system using a direct LUN.
     */
    AddDirectLunRequest addDirectLun();
    
    /**
     * Add a new storage domain to the system using Gluster or POSIX FS storage.
     */
    public interface AddGlusterOrPostfsRequest extends Request<AddGlusterOrPostfsRequest, AddGlusterOrPostfsResponse> {
        AddGlusterOrPostfsRequest storageDomain(StorageDomain storageDomain);
        /**
         * The storage domain to add.
         */
        AddGlusterOrPostfsRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Add a new storage domain to the system using Gluster or POSIX FS storage.
     */
    public interface AddGlusterOrPostfsResponse extends Response {
        /**
         * The storage domain to add.
         */
        StorageDomain storageDomain();
    }
    
    /**
     * Add a new storage domain to the system using Gluster or POSIX FS storage.
     */
    AddGlusterOrPostfsRequest addGlusterOrPostfs();
    
    /**
     * Returns the list of storage domains in the system.
     * 
     * The order of the returned list of storage domains is guaranteed only if the `sortby` clause is included
     * in the `search` parameter.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search should be performed taking case into account.
         * The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case, set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        ListRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of storage domains to return. If not specified, all the storage domains are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of storage domains to return. If not specified, all the storage domains are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of storage domains to return. If not specified, all the storage domains are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned storage domains.
         */
        ListRequest search(String search);
    }
    
    /**
     * Returns the list of storage domains in the system.
     * 
     * The order of the returned list of storage domains is guaranteed only if the `sortby` clause is included
     * in the `search` parameter.
     */
    public interface ListResponse extends Response {
        /**
         * A list of the storage domains in the system.
         */
        List<StorageDomain> storageDomains();
    }
    
    /**
     * Returns the list of storage domains in the system.
     * 
     * The order of the returned list of storage domains is guaranteed only if the `sortby` clause is included
     * in the `search` parameter.
     */
    ListRequest list();
    
    /**
     * Add a new storage domain to the system using the storage on the local host at the given path.
     */
    public interface AddLocalRequest extends Request<AddLocalRequest, AddLocalResponse> {
        AddLocalRequest storageDomain(StorageDomain storageDomain);
        /**
         * The storage domain to add.
         */
        AddLocalRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Add a new storage domain to the system using the storage on the local host at the given path.
     */
    public interface AddLocalResponse extends Response {
        /**
         * The storage domain to add.
         */
        StorageDomain storageDomain();
    }
    
    /**
     * Add a new storage domain to the system using the storage on the local host at the given path.
     */
    AddLocalRequest addLocal();
    
    StorageDomainService storageDomainService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

