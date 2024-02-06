/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.StorageDomainBuilder;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.StorageDomain;

public interface TemplateDiskService extends Service {
    /**
     * Copy the specified disk attached to the template to a specific storage domain.
     */
    public interface CopyRequest extends Request<CopyRequest, CopyResponse> {
        /**
         * Indicates if the copy should be performed asynchronously.
         */
        CopyRequest async(Boolean async);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        CopyRequest filter(Boolean filter);
        CopyRequest storageDomain(StorageDomain storageDomain);
        CopyRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    /**
     * Copy the specified disk attached to the template to a specific storage domain.
     */
    public interface CopyResponse extends Response {
    }
    
    /**
     * Copy the specified disk attached to the template to a specific storage domain.
     */
    CopyRequest copy();
    
    public interface ExportRequest extends Request<ExportRequest, ExportResponse> {
        /**
         * Indicates if the export should be performed asynchronously.
         */
        ExportRequest async(Boolean async);
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        ExportRequest filter(Boolean filter);
        ExportRequest storageDomain(StorageDomain storageDomain);
        ExportRequest storageDomain(StorageDomainBuilder storageDomain);
    }
    
    public interface ExportResponse extends Response {
    }
    
    ExportRequest export();
    
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        Disk disk();
    }
    
    GetRequest get();
    
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    public interface RemoveResponse extends Response {
    }
    
    RemoveRequest remove();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

