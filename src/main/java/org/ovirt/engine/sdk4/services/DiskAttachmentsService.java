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
import org.ovirt.engine.sdk4.builders.DiskAttachmentBuilder;
import org.ovirt.engine.sdk4.types.DiskAttachment;

/**
 * This service manages the set of disks attached to a virtual machine. Each attached disk is represented by a
 * <<types/disk_attachment,DiskAttachment>>, containing the bootable flag, the disk interface and the reference to
 * the disk.
 */
public interface DiskAttachmentsService extends Service {
    /**
     * Adds a new disk attachment to the virtual machine. The `attachment` parameter can contain just a reference, if
     * the disk already exists:
     * 
     * [source,xml]
     * ----
     * <disk_attachment>
     *   <bootable>true</bootable>
     *   <pass_discard>true</pass_discard>
     *   <interface>ide</interface>
     *   <active>true</active>
     *   <disk id="123"/>
     * </disk_attachment>
     * ----
     * 
     * Or it can contain the complete representation of the disk, if the disk doesn't exist yet:
     * 
     * [source,xml]
     * ----
     * <disk_attachment>
     *   <bootable>true</bootable>
     *   <pass_discard>true</pass_discard>
     *   <interface>ide</interface>
     *   <active>true</active>
     *   <disk>
     *     <name>mydisk</name>
     *     <provisioned_size>1024</provisioned_size>
     *     ...
     *   </disk>
     * </disk_attachment>
     * ----
     * 
     * In this case the disk will be created and then attached to the virtual machine.
     * 
     * In both cases, use the following URL for a virtual machine with an id `345`:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/345/diskattachments
     * ----
     * 
     * IMPORTANT: The server accepts requests that don't contain the `active` attribute, but the effect is
     * undefined. In some cases the disk will be automatically activated and in other cases it won't. To
     * avoid issues it is strongly recommended to always include the `active` attribute with the desired
     * value.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest attachment(DiskAttachment attachment);
        /**
         * The disk attachment to add to the virtual machine.
         */
        AddRequest attachment(DiskAttachmentBuilder attachment);
    }
    
    /**
     * Adds a new disk attachment to the virtual machine. The `attachment` parameter can contain just a reference, if
     * the disk already exists:
     * 
     * [source,xml]
     * ----
     * <disk_attachment>
     *   <bootable>true</bootable>
     *   <pass_discard>true</pass_discard>
     *   <interface>ide</interface>
     *   <active>true</active>
     *   <disk id="123"/>
     * </disk_attachment>
     * ----
     * 
     * Or it can contain the complete representation of the disk, if the disk doesn't exist yet:
     * 
     * [source,xml]
     * ----
     * <disk_attachment>
     *   <bootable>true</bootable>
     *   <pass_discard>true</pass_discard>
     *   <interface>ide</interface>
     *   <active>true</active>
     *   <disk>
     *     <name>mydisk</name>
     *     <provisioned_size>1024</provisioned_size>
     *     ...
     *   </disk>
     * </disk_attachment>
     * ----
     * 
     * In this case the disk will be created and then attached to the virtual machine.
     * 
     * In both cases, use the following URL for a virtual machine with an id `345`:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/345/diskattachments
     * ----
     * 
     * IMPORTANT: The server accepts requests that don't contain the `active` attribute, but the effect is
     * undefined. In some cases the disk will be automatically activated and in other cases it won't. To
     * avoid issues it is strongly recommended to always include the `active` attribute with the desired
     * value.
     */
    public interface AddResponse extends Response {
        /**
         * The disk attachment to add to the virtual machine.
         */
        DiskAttachment attachment();
    }
    
    /**
     * Adds a new disk attachment to the virtual machine. The `attachment` parameter can contain just a reference, if
     * the disk already exists:
     * 
     * [source,xml]
     * ----
     * <disk_attachment>
     *   <bootable>true</bootable>
     *   <pass_discard>true</pass_discard>
     *   <interface>ide</interface>
     *   <active>true</active>
     *   <disk id="123"/>
     * </disk_attachment>
     * ----
     * 
     * Or it can contain the complete representation of the disk, if the disk doesn't exist yet:
     * 
     * [source,xml]
     * ----
     * <disk_attachment>
     *   <bootable>true</bootable>
     *   <pass_discard>true</pass_discard>
     *   <interface>ide</interface>
     *   <active>true</active>
     *   <disk>
     *     <name>mydisk</name>
     *     <provisioned_size>1024</provisioned_size>
     *     ...
     *   </disk>
     * </disk_attachment>
     * ----
     * 
     * In this case the disk will be created and then attached to the virtual machine.
     * 
     * In both cases, use the following URL for a virtual machine with an id `345`:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/345/diskattachments
     * ----
     * 
     * IMPORTANT: The server accepts requests that don't contain the `active` attribute, but the effect is
     * undefined. In some cases the disk will be automatically activated and in other cases it won't. To
     * avoid issues it is strongly recommended to always include the `active` attribute with the desired
     * value.
     */
    AddRequest add();
    
    /**
     * List the disk that are attached to the virtual machine.
     * 
     * The order of the returned list of disks attachments isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
    }
    
    /**
     * List the disk that are attached to the virtual machine.
     * 
     * The order of the returned list of disks attachments isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * A list of disk attachments that are attached to the virtual machine.
         */
        List<DiskAttachment> attachments();
    }
    
    /**
     * List the disk that are attached to the virtual machine.
     * 
     * The order of the returned list of disks attachments isn't guaranteed.
     */
    ListRequest list();
    
    public interface AddProvidingDiskIdRequest extends Request<AddProvidingDiskIdRequest, AddProvidingDiskIdResponse> {
        AddProvidingDiskIdRequest attachment(DiskAttachment attachment);
        /**
         * The disk attachment to add to the virtual machine.
         */
        AddProvidingDiskIdRequest attachment(DiskAttachmentBuilder attachment);
    }
    
    public interface AddProvidingDiskIdResponse extends Response {
        /**
         * The disk attachment to add to the virtual machine.
         */
        DiskAttachment attachment();
    }
    
    AddProvidingDiskIdRequest addProvidingDiskId();
    
    public interface AddSignature1Request extends Request<AddSignature1Request, AddSignature1Response> {
        AddSignature1Request attachment(DiskAttachment attachment);
        /**
         * The disk attachment to add to the virtual machine.
         */
        AddSignature1Request attachment(DiskAttachmentBuilder attachment);
    }
    
    public interface AddSignature1Response extends Response {
        /**
         * The disk attachment to add to the virtual machine.
         */
        DiskAttachment attachment();
    }
    
    AddSignature1Request addSignature1();
    
    /**
     * Reference to the service that manages a specific attachment.
     */
    DiskAttachmentService attachmentService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

