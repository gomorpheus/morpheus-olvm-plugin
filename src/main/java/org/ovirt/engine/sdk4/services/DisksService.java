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
 * Manages the collection of disks available in the system.
 */
public interface DisksService extends Service {
    /**
     * Adds a new floating disk.
     * 
     * There are three types of disks that can be added - disk image, direct LUN and Managed Block disk.
     * https://wiki.openstack.org/wiki/Cinder[Cinder] integration has been replaced by Managed Block Storage.
     * 
     * *Adding a new image disk:*
     * 
     * When creating a new floating image <<types/disk,Disk>>, the API requires the `storage_domain`, `provisioned_size`
     * and `format` attributes.
     * 
     * Note that block storage domains (i.e., storage domains with the <<types/storage_type, storage type>> of iSCSI or
     * FCP) don't support the combination of the raw `format` with `sparse=true`, so `sparse=false` must be stated
     * explicitly.
     * 
     * To create a new floating image disk with specified `provisioned_size`, `format` and `name` on a storage domain
     * with an id `123`, send a request as follows:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks
     * ----
     * 
     * With a request body as follows:
     * 
     * [source,xml]
     * ----
     * <disk>
     *   <storage_domains>
     *     <storage_domain id="123"/>
     *   </storage_domains>
     *   <name>mydisk</name>
     *   <provisioned_size>1048576</provisioned_size>
     *   <format>cow</format>
     * </disk>
     * ----
     * 
     * 
     * *Adding a new direct LUN disk:*
     * 
     * When adding a new floating direct LUN via the API, there are two flavors that can be used:
     * 
     * . With a `host` element - in this case, the host is used for sanity checks (e.g., that the LUN is visible) and
     * to retrieve basic information about the LUN (e.g., size and serial).
     * . Without a `host` element - in this case, the operation is a database-only operation, and the storage is never
     * accessed.
     * 
     * To create a new floating direct LUN disk with a `host` element with an id `123`, specified `alias`, `type` and
     * `logical_unit` with an id `456` (that has the attributes `address`, `port` and `target`),
     * send a request as follows:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks
     * ----
     * 
     * With a request body as follows:
     * 
     * [source,xml]
     * ----
     * <disk>
     *   <alias>mylun</alias>
     *   <lun_storage>
     *     <host id="123"/>
     *     <type>iscsi</type>
     *     <logical_units>
     *       <logical_unit id="456">
     *         <address>10.35.10.20</address>
     *         <port>3260</port>
     *         <target>iqn.2017-01.com.myhost:444</target>
     *       </logical_unit>
     *     </logical_units>
     *   </lun_storage>
     * </disk>
     * ----
     * 
     * To create a new floating direct LUN disk without using a host, remove the `host` element.
     * 
     * 
     * *Adding a new Cinder disk:*
     * 
     * Cinder integration has been replaced by Managed Block Storage.
     * //TODO: Add an example for adding an MBS disk
     * 
     * *Adding a floating disks in order to upload disk snapshots:*
     * 
     * Since version 4.2 of the engine it is possible to upload disks with
     * snapshots. This request should be used to create the base image of the
     * images chain (The consecutive disk snapshots (images), should be created
     * using `disk-attachments` element when creating a snapshot).
     * 
     * The disk has to be created with the same disk identifier and image identifier
     * of the uploaded image. I.e. the identifiers should be saved as part of the
     * backup process. The image identifier can be also fetched using the
     * `qemu-img info` command. For example, if the disk image is stored into
     * a file named `b7a4c6c5-443b-47c5-967f-6abc79675e8b/myimage.img`:
     * 
     * [source,shell]
     * ----
     * $ qemu-img info b7a4c6c5-443b-47c5-967f-6abc79675e8b/myimage.img
     * image: b548366b-fb51-4b41-97be-733c887fe305
     * file format: qcow2
     * virtual size: 1.0G (1073741824 bytes)
     * disk size: 196K
     * cluster_size: 65536
     * backing file: ad58716a-1fe9-481f-815e-664de1df04eb
     * backing file format: raw
     * ----
     * 
     * To create a disk with with the disk identifier and image identifier obtained
     * with the `qemu-img info` command shown above, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks
     * ----
     * 
     * With a request body as follows:
     * 
     * [source,xml]
     * ----
     * <disk id="b7a4c6c5-443b-47c5-967f-6abc79675e8b">
     *   <image_id>b548366b-fb51-4b41-97be-733c887fe305</image_id>
     *   <storage_domains>
     *     <storage_domain id="123"/>
     *   </storage_domains>
     *   <name>mydisk</name>
     *   <provisioned_size>1048576</provisioned_size>
     *   <format>cow</format>
     * </disk>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest disk(Disk disk);
        /**
         * The disk.
         */
        AddRequest disk(DiskBuilder disk);
    }
    
    /**
     * Adds a new floating disk.
     * 
     * There are three types of disks that can be added - disk image, direct LUN and Managed Block disk.
     * https://wiki.openstack.org/wiki/Cinder[Cinder] integration has been replaced by Managed Block Storage.
     * 
     * *Adding a new image disk:*
     * 
     * When creating a new floating image <<types/disk,Disk>>, the API requires the `storage_domain`, `provisioned_size`
     * and `format` attributes.
     * 
     * Note that block storage domains (i.e., storage domains with the <<types/storage_type, storage type>> of iSCSI or
     * FCP) don't support the combination of the raw `format` with `sparse=true`, so `sparse=false` must be stated
     * explicitly.
     * 
     * To create a new floating image disk with specified `provisioned_size`, `format` and `name` on a storage domain
     * with an id `123`, send a request as follows:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks
     * ----
     * 
     * With a request body as follows:
     * 
     * [source,xml]
     * ----
     * <disk>
     *   <storage_domains>
     *     <storage_domain id="123"/>
     *   </storage_domains>
     *   <name>mydisk</name>
     *   <provisioned_size>1048576</provisioned_size>
     *   <format>cow</format>
     * </disk>
     * ----
     * 
     * 
     * *Adding a new direct LUN disk:*
     * 
     * When adding a new floating direct LUN via the API, there are two flavors that can be used:
     * 
     * . With a `host` element - in this case, the host is used for sanity checks (e.g., that the LUN is visible) and
     * to retrieve basic information about the LUN (e.g., size and serial).
     * . Without a `host` element - in this case, the operation is a database-only operation, and the storage is never
     * accessed.
     * 
     * To create a new floating direct LUN disk with a `host` element with an id `123`, specified `alias`, `type` and
     * `logical_unit` with an id `456` (that has the attributes `address`, `port` and `target`),
     * send a request as follows:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks
     * ----
     * 
     * With a request body as follows:
     * 
     * [source,xml]
     * ----
     * <disk>
     *   <alias>mylun</alias>
     *   <lun_storage>
     *     <host id="123"/>
     *     <type>iscsi</type>
     *     <logical_units>
     *       <logical_unit id="456">
     *         <address>10.35.10.20</address>
     *         <port>3260</port>
     *         <target>iqn.2017-01.com.myhost:444</target>
     *       </logical_unit>
     *     </logical_units>
     *   </lun_storage>
     * </disk>
     * ----
     * 
     * To create a new floating direct LUN disk without using a host, remove the `host` element.
     * 
     * 
     * *Adding a new Cinder disk:*
     * 
     * Cinder integration has been replaced by Managed Block Storage.
     * //TODO: Add an example for adding an MBS disk
     * 
     * *Adding a floating disks in order to upload disk snapshots:*
     * 
     * Since version 4.2 of the engine it is possible to upload disks with
     * snapshots. This request should be used to create the base image of the
     * images chain (The consecutive disk snapshots (images), should be created
     * using `disk-attachments` element when creating a snapshot).
     * 
     * The disk has to be created with the same disk identifier and image identifier
     * of the uploaded image. I.e. the identifiers should be saved as part of the
     * backup process. The image identifier can be also fetched using the
     * `qemu-img info` command. For example, if the disk image is stored into
     * a file named `b7a4c6c5-443b-47c5-967f-6abc79675e8b/myimage.img`:
     * 
     * [source,shell]
     * ----
     * $ qemu-img info b7a4c6c5-443b-47c5-967f-6abc79675e8b/myimage.img
     * image: b548366b-fb51-4b41-97be-733c887fe305
     * file format: qcow2
     * virtual size: 1.0G (1073741824 bytes)
     * disk size: 196K
     * cluster_size: 65536
     * backing file: ad58716a-1fe9-481f-815e-664de1df04eb
     * backing file format: raw
     * ----
     * 
     * To create a disk with with the disk identifier and image identifier obtained
     * with the `qemu-img info` command shown above, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks
     * ----
     * 
     * With a request body as follows:
     * 
     * [source,xml]
     * ----
     * <disk id="b7a4c6c5-443b-47c5-967f-6abc79675e8b">
     *   <image_id>b548366b-fb51-4b41-97be-733c887fe305</image_id>
     *   <storage_domains>
     *     <storage_domain id="123"/>
     *   </storage_domains>
     *   <name>mydisk</name>
     *   <provisioned_size>1048576</provisioned_size>
     *   <format>cow</format>
     * </disk>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * The disk.
         */
        Disk disk();
    }
    
    /**
     * Adds a new floating disk.
     * 
     * There are three types of disks that can be added - disk image, direct LUN and Managed Block disk.
     * https://wiki.openstack.org/wiki/Cinder[Cinder] integration has been replaced by Managed Block Storage.
     * 
     * *Adding a new image disk:*
     * 
     * When creating a new floating image <<types/disk,Disk>>, the API requires the `storage_domain`, `provisioned_size`
     * and `format` attributes.
     * 
     * Note that block storage domains (i.e., storage domains with the <<types/storage_type, storage type>> of iSCSI or
     * FCP) don't support the combination of the raw `format` with `sparse=true`, so `sparse=false` must be stated
     * explicitly.
     * 
     * To create a new floating image disk with specified `provisioned_size`, `format` and `name` on a storage domain
     * with an id `123`, send a request as follows:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks
     * ----
     * 
     * With a request body as follows:
     * 
     * [source,xml]
     * ----
     * <disk>
     *   <storage_domains>
     *     <storage_domain id="123"/>
     *   </storage_domains>
     *   <name>mydisk</name>
     *   <provisioned_size>1048576</provisioned_size>
     *   <format>cow</format>
     * </disk>
     * ----
     * 
     * 
     * *Adding a new direct LUN disk:*
     * 
     * When adding a new floating direct LUN via the API, there are two flavors that can be used:
     * 
     * . With a `host` element - in this case, the host is used for sanity checks (e.g., that the LUN is visible) and
     * to retrieve basic information about the LUN (e.g., size and serial).
     * . Without a `host` element - in this case, the operation is a database-only operation, and the storage is never
     * accessed.
     * 
     * To create a new floating direct LUN disk with a `host` element with an id `123`, specified `alias`, `type` and
     * `logical_unit` with an id `456` (that has the attributes `address`, `port` and `target`),
     * send a request as follows:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks
     * ----
     * 
     * With a request body as follows:
     * 
     * [source,xml]
     * ----
     * <disk>
     *   <alias>mylun</alias>
     *   <lun_storage>
     *     <host id="123"/>
     *     <type>iscsi</type>
     *     <logical_units>
     *       <logical_unit id="456">
     *         <address>10.35.10.20</address>
     *         <port>3260</port>
     *         <target>iqn.2017-01.com.myhost:444</target>
     *       </logical_unit>
     *     </logical_units>
     *   </lun_storage>
     * </disk>
     * ----
     * 
     * To create a new floating direct LUN disk without using a host, remove the `host` element.
     * 
     * 
     * *Adding a new Cinder disk:*
     * 
     * Cinder integration has been replaced by Managed Block Storage.
     * //TODO: Add an example for adding an MBS disk
     * 
     * *Adding a floating disks in order to upload disk snapshots:*
     * 
     * Since version 4.2 of the engine it is possible to upload disks with
     * snapshots. This request should be used to create the base image of the
     * images chain (The consecutive disk snapshots (images), should be created
     * using `disk-attachments` element when creating a snapshot).
     * 
     * The disk has to be created with the same disk identifier and image identifier
     * of the uploaded image. I.e. the identifiers should be saved as part of the
     * backup process. The image identifier can be also fetched using the
     * `qemu-img info` command. For example, if the disk image is stored into
     * a file named `b7a4c6c5-443b-47c5-967f-6abc79675e8b/myimage.img`:
     * 
     * [source,shell]
     * ----
     * $ qemu-img info b7a4c6c5-443b-47c5-967f-6abc79675e8b/myimage.img
     * image: b548366b-fb51-4b41-97be-733c887fe305
     * file format: qcow2
     * virtual size: 1.0G (1073741824 bytes)
     * disk size: 196K
     * cluster_size: 65536
     * backing file: ad58716a-1fe9-481f-815e-664de1df04eb
     * backing file format: raw
     * ----
     * 
     * To create a disk with with the disk identifier and image identifier obtained
     * with the `qemu-img info` command shown above, send a request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/disks
     * ----
     * 
     * With a request body as follows:
     * 
     * [source,xml]
     * ----
     * <disk id="b7a4c6c5-443b-47c5-967f-6abc79675e8b">
     *   <image_id>b548366b-fb51-4b41-97be-733c887fe305</image_id>
     *   <storage_domains>
     *     <storage_domain id="123"/>
     *   </storage_domains>
     *   <name>mydisk</name>
     *   <provisioned_size>1048576</provisioned_size>
     *   <format>cow</format>
     * </disk>
     * ----
     */
    AddRequest add();
    
    /**
     * Get list of disks.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/disks
     * ----
     * 
     * You will get a XML response which will look like this one:
     * 
     * [source,xml]
     * ----
     * <disks>
     *   <disk id="123">
     *     <actions>...</actions>
     *     <name>MyDisk</name>
     *     <description>MyDisk description</description>
     *     <link href="/ovirt-engine/api/disks/123/permissions" rel="permissions"/>
     *     <link href="/ovirt-engine/api/disks/123/statistics" rel="statistics"/>
     *     <actual_size>5345845248</actual_size>
     *     <alias>MyDisk alias</alias>
     *     ...
     *     <status>ok</status>
     *     <storage_type>image</storage_type>
     *     <wipe_after_delete>false</wipe_after_delete>
     *     <disk_profile id="123"/>
     *     <quota id="123"/>
     *     <storage_domains>...</storage_domains>
     *   </disk>
     *   ...
     * </disks>
     * ----
     * 
     * The order of the returned list of disks is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search performed using the `search` parameter should be performed taking case into
         * account. The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
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
        /**
         * A query string used to restrict the returned disks.
         */
        ListRequest search(String search);
    }
    
    /**
     * Get list of disks.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/disks
     * ----
     * 
     * You will get a XML response which will look like this one:
     * 
     * [source,xml]
     * ----
     * <disks>
     *   <disk id="123">
     *     <actions>...</actions>
     *     <name>MyDisk</name>
     *     <description>MyDisk description</description>
     *     <link href="/ovirt-engine/api/disks/123/permissions" rel="permissions"/>
     *     <link href="/ovirt-engine/api/disks/123/statistics" rel="statistics"/>
     *     <actual_size>5345845248</actual_size>
     *     <alias>MyDisk alias</alias>
     *     ...
     *     <status>ok</status>
     *     <storage_type>image</storage_type>
     *     <wipe_after_delete>false</wipe_after_delete>
     *     <disk_profile id="123"/>
     *     <quota id="123"/>
     *     <storage_domains>...</storage_domains>
     *   </disk>
     *   ...
     * </disks>
     * ----
     * 
     * The order of the returned list of disks is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    public interface ListResponse extends Response {
        /**
         * List of retrieved disks.
         */
        List<Disk> disks();
    }
    
    /**
     * Get list of disks.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/disks
     * ----
     * 
     * You will get a XML response which will look like this one:
     * 
     * [source,xml]
     * ----
     * <disks>
     *   <disk id="123">
     *     <actions>...</actions>
     *     <name>MyDisk</name>
     *     <description>MyDisk description</description>
     *     <link href="/ovirt-engine/api/disks/123/permissions" rel="permissions"/>
     *     <link href="/ovirt-engine/api/disks/123/statistics" rel="statistics"/>
     *     <actual_size>5345845248</actual_size>
     *     <alias>MyDisk alias</alias>
     *     ...
     *     <status>ok</status>
     *     <storage_type>image</storage_type>
     *     <wipe_after_delete>false</wipe_after_delete>
     *     <disk_profile id="123"/>
     *     <quota id="123"/>
     *     <storage_domains>...</storage_domains>
     *   </disk>
     *   ...
     * </disks>
     * ----
     * 
     * The order of the returned list of disks is guaranteed only if the `sortby` clause is included in the
     * `search` parameter.
     */
    ListRequest list();
    
    /**
     * Add a new lun disk to the storage domain.
     */
    public interface AddLunRequest extends Request<AddLunRequest, AddLunResponse> {
        AddLunRequest disk(Disk disk);
        /**
         * The disk.
         */
        AddLunRequest disk(DiskBuilder disk);
    }
    
    /**
     * Add a new lun disk to the storage domain.
     */
    public interface AddLunResponse extends Response {
        /**
         * The disk.
         */
        Disk disk();
    }
    
    /**
     * Add a new lun disk to the storage domain.
     */
    AddLunRequest addLun();
    
    /**
     * Add a new disk to the storage domain with the specified size allocating space from the storage domain.
     */
    public interface AddOnStorageDomainRequest extends Request<AddOnStorageDomainRequest, AddOnStorageDomainResponse> {
        AddOnStorageDomainRequest disk(Disk disk);
        /**
         * The disk.
         */
        AddOnStorageDomainRequest disk(DiskBuilder disk);
    }
    
    /**
     * Add a new disk to the storage domain with the specified size allocating space from the storage domain.
     */
    public interface AddOnStorageDomainResponse extends Response {
        /**
         * The disk.
         */
        Disk disk();
    }
    
    /**
     * Add a new disk to the storage domain with the specified size allocating space from the storage domain.
     */
    AddOnStorageDomainRequest addOnStorageDomain();
    
    /**
     * Reference to a service managing a specific disk.
     */
    DiskService diskService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

