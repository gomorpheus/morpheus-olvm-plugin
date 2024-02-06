/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.CdromBuilder;
import org.ovirt.engine.sdk4.types.Cdrom;

/**
 * Manages a CDROM device of a virtual machine.
 * 
 * Changing and ejecting the disk is done using always the `update` method, to change the value of the `file`
 * attribute.
 */
public interface VmCdromService extends Service {
    /**
     * Returns the information about this CDROM device.
     * 
     * The information consists of `cdrom` attribute containing reference to the CDROM device, the virtual machine,
     * and optionally the inserted disk.
     * 
     * If there is a disk inserted then the `file` attribute will contain a reference to the ISO image:
     * 
     * [source,xml]
     * ----
     * <cdrom href="..." id="00000000-0000-0000-0000-000000000000">
     *   <file id="mycd.iso"/>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </cdrom>
     * ----
     * 
     * If there is no disk inserted then the `file` attribute won't be reported:
     * 
     * [source,xml]
     * ----
     * <cdrom href="..." id="00000000-0000-0000-0000-000000000000">
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </cdrom>
     * ----
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates if the operation should return the information for the currently running virtual machine. This
         * parameter is optional, and the default value is `false`.
         */
        GetRequest current(Boolean current);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Returns the information about this CDROM device.
     * 
     * The information consists of `cdrom` attribute containing reference to the CDROM device, the virtual machine,
     * and optionally the inserted disk.
     * 
     * If there is a disk inserted then the `file` attribute will contain a reference to the ISO image:
     * 
     * [source,xml]
     * ----
     * <cdrom href="..." id="00000000-0000-0000-0000-000000000000">
     *   <file id="mycd.iso"/>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </cdrom>
     * ----
     * 
     * If there is no disk inserted then the `file` attribute won't be reported:
     * 
     * [source,xml]
     * ----
     * <cdrom href="..." id="00000000-0000-0000-0000-000000000000">
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </cdrom>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The information about the CDROM device.
         */
        Cdrom cdrom();
    }
    
    /**
     * Returns the information about this CDROM device.
     * 
     * The information consists of `cdrom` attribute containing reference to the CDROM device, the virtual machine,
     * and optionally the inserted disk.
     * 
     * If there is a disk inserted then the `file` attribute will contain a reference to the ISO image:
     * 
     * [source,xml]
     * ----
     * <cdrom href="..." id="00000000-0000-0000-0000-000000000000">
     *   <file id="mycd.iso"/>
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </cdrom>
     * ----
     * 
     * If there is no disk inserted then the `file` attribute won't be reported:
     * 
     * [source,xml]
     * ----
     * <cdrom href="..." id="00000000-0000-0000-0000-000000000000">
     *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
     * </cdrom>
     * ----
     */
    GetRequest get();
    
    /**
     * Updates the information about this CDROM device.
     * 
     * It allows to change or eject the disk by changing the value of the `file` attribute.
     * For example, to insert or change the disk send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/cdroms/00000000-0000-0000-0000-000000000000
     * ----
     * 
     * The body should contain the new value for the `file` attribute:
     * 
     * [source,xml]
     * ----
     * <cdrom>
     *   <file id="mycd.iso"/>
     * </cdrom>
     * ----
     * 
     * The value of the `id` attribute, `mycd.iso` in this example, should correspond to a file available in an
     * attached ISO storage domain.
     * 
     * To eject the disk use a `file` with an empty `id`:
     * 
     * [source,xml]
     * ----
     * <cdrom>
     *   <file id=""/>
     * </cdrom>
     * ----
     * 
     * By default the above operations change permanently the disk that will be visible to the virtual machine
     * after the next boot, but they don't have any effect on the currently running virtual machine. If you want
     * to change the disk that is visible to the current running virtual machine, add the `current=true` parameter.
     * For example, to eject the current disk send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/cdroms/00000000-0000-0000-0000-000000000000?current=true
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <cdrom>
     *   <file id=""/>
     * </cdrom>
     * ----
     * 
     * IMPORTANT: The changes made with the `current=true` parameter are never persisted, so they won't have any
     * effect after the virtual machine is rebooted.
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        UpdateRequest cdrom(Cdrom cdrom);
        /**
         * The information about the CDROM device.
         */
        UpdateRequest cdrom(CdromBuilder cdrom);
        /**
         * Indicates if the update should apply to the currently running virtual machine, or to the virtual machine
         * after the next boot. This parameter is optional, and the default value is `false`, which means that by
         * default the update will have effect only after the next boot.
         */
        UpdateRequest current(Boolean current);
    }
    
    /**
     * Updates the information about this CDROM device.
     * 
     * It allows to change or eject the disk by changing the value of the `file` attribute.
     * For example, to insert or change the disk send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/cdroms/00000000-0000-0000-0000-000000000000
     * ----
     * 
     * The body should contain the new value for the `file` attribute:
     * 
     * [source,xml]
     * ----
     * <cdrom>
     *   <file id="mycd.iso"/>
     * </cdrom>
     * ----
     * 
     * The value of the `id` attribute, `mycd.iso` in this example, should correspond to a file available in an
     * attached ISO storage domain.
     * 
     * To eject the disk use a `file` with an empty `id`:
     * 
     * [source,xml]
     * ----
     * <cdrom>
     *   <file id=""/>
     * </cdrom>
     * ----
     * 
     * By default the above operations change permanently the disk that will be visible to the virtual machine
     * after the next boot, but they don't have any effect on the currently running virtual machine. If you want
     * to change the disk that is visible to the current running virtual machine, add the `current=true` parameter.
     * For example, to eject the current disk send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/cdroms/00000000-0000-0000-0000-000000000000?current=true
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <cdrom>
     *   <file id=""/>
     * </cdrom>
     * ----
     * 
     * IMPORTANT: The changes made with the `current=true` parameter are never persisted, so they won't have any
     * effect after the virtual machine is rebooted.
     */
    public interface UpdateResponse extends Response {
        /**
         * The information about the CDROM device.
         */
        Cdrom cdrom();
    }
    
    /**
     * Updates the information about this CDROM device.
     * 
     * It allows to change or eject the disk by changing the value of the `file` attribute.
     * For example, to insert or change the disk send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/cdroms/00000000-0000-0000-0000-000000000000
     * ----
     * 
     * The body should contain the new value for the `file` attribute:
     * 
     * [source,xml]
     * ----
     * <cdrom>
     *   <file id="mycd.iso"/>
     * </cdrom>
     * ----
     * 
     * The value of the `id` attribute, `mycd.iso` in this example, should correspond to a file available in an
     * attached ISO storage domain.
     * 
     * To eject the disk use a `file` with an empty `id`:
     * 
     * [source,xml]
     * ----
     * <cdrom>
     *   <file id=""/>
     * </cdrom>
     * ----
     * 
     * By default the above operations change permanently the disk that will be visible to the virtual machine
     * after the next boot, but they don't have any effect on the currently running virtual machine. If you want
     * to change the disk that is visible to the current running virtual machine, add the `current=true` parameter.
     * For example, to eject the current disk send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/vms/123/cdroms/00000000-0000-0000-0000-000000000000?current=true
     * ----
     * 
     * With a request body like this:
     * 
     * [source,xml]
     * ----
     * <cdrom>
     *   <file id=""/>
     * </cdrom>
     * ----
     * 
     * IMPORTANT: The changes made with the `current=true` parameter are never persisted, so they won't have any
     * effect after the virtual machine is rebooted.
     */
    UpdateRequest update();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

