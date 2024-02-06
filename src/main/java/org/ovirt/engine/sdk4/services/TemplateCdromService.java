/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Cdrom;

/**
 * A service managing a CD-ROM device on templates.
 */
public interface TemplateCdromService extends Service {
    /**
     * Returns the information about this CD-ROM device.
     * 
     * For example, to get information about the CD-ROM device of template `123` send a request like:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/templates/123/cdroms/
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
     * Returns the information about this CD-ROM device.
     * 
     * For example, to get information about the CD-ROM device of template `123` send a request like:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/templates/123/cdroms/
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * The information about the CD-ROM device.
         * 
         * The information consists of `cdrom` attribute containing reference to the CD-ROM device, the template,
         * and optionally the inserted disk.
         * 
         * If there is a disk inserted then the `file` attribute will contain a reference to the ISO image:
         * 
         * [source,xml]
         * ----
         * <cdrom href="..." id="00000000-0000-0000-0000-000000000000">
         *   <template href="/ovirt-engine/api/templates/123" id="123"/>
         *   <file id="mycd.iso"/>
         * </cdrom>
         * ----
         * 
         * If there is no disk inserted then the `file` attribute won't be reported:
         * 
         * [source,xml]
         * ----
         * <cdrom href="..." id="00000000-0000-0000-0000-000000000000">
         *   <template href="/ovirt-engine/api/templates/123" id="123"/>
         * </cdrom>
         * ----
         */
        Cdrom cdrom();
    }
    
    /**
     * Returns the information about this CD-ROM device.
     * 
     * For example, to get information about the CD-ROM device of template `123` send a request like:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/templates/123/cdroms/
     * ----
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

