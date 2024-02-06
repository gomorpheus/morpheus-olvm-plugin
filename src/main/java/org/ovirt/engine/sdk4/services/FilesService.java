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
import org.ovirt.engine.sdk4.types.File;

/**
 * Provides a way for clients to list available files.
 * 
 * This service is specifically targeted to ISO storage domains, which contain ISO images and virtual floppy disks
 * (VFDs) that an administrator uploads.
 * 
 * The addition of a CD-ROM device to a virtual machine requires an ISO image from the files of an ISO storage domain.
 */
public interface FilesService extends Service {
    /**
     * Returns the list of ISO images and virtual floppy disks available in the storage domain. The order of
     * the returned list is not guaranteed.
     * 
     * If the `refresh` parameter is `false`, the returned list may not reflect recent changes to the storage domain;
     * for example, it may not contain a new ISO file that was recently added. This is because the
     * server caches the list of files to improve performance. To get the very latest results, set the `refresh`
     * parameter to `true`.
     * 
     * The default value of the `refresh` parameter is `true`, but it can be changed using the configuration value
     * `ForceRefreshDomainFilesByDefault`:
     * 
     * [source]
     * ----
     * # engine-config -s ForceRefreshDomainFilesByDefault=false
     * ----
     * 
     * IMPORTANT: Setting the value of the `refresh` parameter to `true` has an impact on the performance of the
     * server. Use it only if necessary.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search performed using the `search` parameter should take case into
         * account. The default value is `true`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of files to return. If not specified, all the files are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of files to return. If not specified, all the files are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of files to return. If not specified, all the files are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * Indicates whether the list of files should be refreshed from the storage domain, rather than showing cached
         * results that are updated at certain intervals.
         */
        ListRequest refresh(Boolean refresh);
        /**
         * A query string used to restrict the returned files.
         */
        ListRequest search(String search);
    }
    
    /**
     * Returns the list of ISO images and virtual floppy disks available in the storage domain. The order of
     * the returned list is not guaranteed.
     * 
     * If the `refresh` parameter is `false`, the returned list may not reflect recent changes to the storage domain;
     * for example, it may not contain a new ISO file that was recently added. This is because the
     * server caches the list of files to improve performance. To get the very latest results, set the `refresh`
     * parameter to `true`.
     * 
     * The default value of the `refresh` parameter is `true`, but it can be changed using the configuration value
     * `ForceRefreshDomainFilesByDefault`:
     * 
     * [source]
     * ----
     * # engine-config -s ForceRefreshDomainFilesByDefault=false
     * ----
     * 
     * IMPORTANT: Setting the value of the `refresh` parameter to `true` has an impact on the performance of the
     * server. Use it only if necessary.
     */
    public interface ListResponse extends Response {
        List<File> file();
    }
    
    /**
     * Returns the list of ISO images and virtual floppy disks available in the storage domain. The order of
     * the returned list is not guaranteed.
     * 
     * If the `refresh` parameter is `false`, the returned list may not reflect recent changes to the storage domain;
     * for example, it may not contain a new ISO file that was recently added. This is because the
     * server caches the list of files to improve performance. To get the very latest results, set the `refresh`
     * parameter to `true`.
     * 
     * The default value of the `refresh` parameter is `true`, but it can be changed using the configuration value
     * `ForceRefreshDomainFilesByDefault`:
     * 
     * [source]
     * ----
     * # engine-config -s ForceRefreshDomainFilesByDefault=false
     * ----
     * 
     * IMPORTANT: Setting the value of the `refresh` parameter to `true` has an impact on the performance of the
     * server. Use it only if necessary.
     */
    ListRequest list();
    
    FileService fileService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

