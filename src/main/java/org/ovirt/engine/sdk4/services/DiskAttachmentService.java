/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.DiskAttachmentBuilder;
import org.ovirt.engine.sdk4.types.DiskAttachment;

/**
 * This service manages the attachment of a disk to a virtual machine.
 */
public interface DiskAttachmentService extends Service {
    /**
     * Returns the details of the attachment, including the bootable flag and link to the disk.
     * 
     * An example of getting a disk attachment:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/diskattachments/456
     * ----
     * 
     * [source,xml]
     * ----
     * <disk_attachment href="/ovirt-engine/api/vms/123/diskattachments/456" id="456">
     *   <active>true</active>
     *   <bootable>true</bootable>
     *   <interface>virtio</interface>
     *   <disk href="/ovirt-engine/api/disks/456" id="456"/>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </disk_attachment>
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Returns the details of the attachment, including the bootable flag and link to the disk.
     * 
     * An example of getting a disk attachment:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/diskattachments/456
     * ----
     * 
     * [source,xml]
     * ----
     * <disk_attachment href="/ovirt-engine/api/vms/123/diskattachments/456" id="456">
     *   <active>true</active>
     *   <bootable>true</bootable>
     *   <interface>virtio</interface>
     *   <disk href="/ovirt-engine/api/disks/456" id="456"/>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </disk_attachment>
     * ----
     */
    public interface GetResponse extends Response {
        DiskAttachment attachment();
    }
    
    /**
     * Returns the details of the attachment, including the bootable flag and link to the disk.
     * 
     * An example of getting a disk attachment:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/vms/123/diskattachments/456
     * ----
     * 
     * [source,xml]
     * ----
     * <disk_attachment href="/ovirt-engine/api/vms/123/diskattachments/456" id="456">
     *   <active>true</active>
     *   <bootable>true</bootable>
     *   <interface>virtio</interface>
     *   <disk href="/ovirt-engine/api/disks/456" id="456"/>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </disk_attachment>
     * ----
     */
    GetRequest get();
    
    /**
     * Removes the disk attachment.
     * 
     * This will only detach the disk from the virtual machine, but won't remove it from
     * the system, unless the `detach_only` parameter is `false`.
     * 
     * An example of removing a disk attachment:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/diskattachments/456?detach_only=true
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the disk should only be detached from the virtual machine, but not removed from the system.
         * The default value is `true`, which won't remove the disk from the system.
         */
        RemoveRequest detachOnly(Boolean detachOnly);
    }
    
    /**
     * Removes the disk attachment.
     * 
     * This will only detach the disk from the virtual machine, but won't remove it from
     * the system, unless the `detach_only` parameter is `false`.
     * 
     * An example of removing a disk attachment:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/diskattachments/456?detach_only=true
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes the disk attachment.
     * 
     * This will only detach the disk from the virtual machine, but won't remove it from
     * the system, unless the `detach_only` parameter is `false`.
     * 
     * An example of removing a disk attachment:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/vms/123/diskattachments/456?detach_only=true
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Update the disk attachment and the disk properties within it.
     * 
     * [source]
     * ----
 * PUT /vms/{vm:id}/disksattachments/{attachment:id}
 * <disk_attachment>
 *   <bootable>true</bootable>
 *   <interface>ide</interface>
 *   <active>true</active>
 *   <disk>
 *     <name>mydisk</name>
 *     <provisioned_size>1024</provisioned_size>
 *     ...
 *   </disk>
 * </disk_attachment>
 * ----
 */
public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
    UpdateRequest diskAttachment(DiskAttachment diskAttachment);
    UpdateRequest diskAttachment(DiskAttachmentBuilder diskAttachment);
}

/**
 * Update the disk attachment and the disk properties within it.
 * 
 * [source]
 * ----
 * PUT /vms/{vm:id}/disksattachments/{attachment:id}
 * <disk_attachment>
 *   <bootable>true</bootable>
 *   <interface>ide</interface>
 *   <active>true</active>
 *   <disk>
 *     <name>mydisk</name>
 *     <provisioned_size>1024</provisioned_size>
 *     ...
 *   </disk>
 * </disk_attachment>
 * ----
 */
public interface UpdateResponse extends Response {
    DiskAttachment diskAttachment();
}

/**
 * Update the disk attachment and the disk properties within it.
 * 
 * [source]
 * ----
 * PUT /vms/{vm:id}/disksattachments/{attachment:id}
 * <disk_attachment>
 *   <bootable>true</bootable>
 *   <interface>ide</interface>
 *   <active>true</active>
 *   <disk>
 *     <name>mydisk</name>
 *     <provisioned_size>1024</provisioned_size>
 *     ...
 *   </disk>
 * </disk_attachment>
 * ----
 */
UpdateRequest update();

/**
 * Service locator method, returns individual service on which the URI is dispatched.
 */
Service service(String path);
}

