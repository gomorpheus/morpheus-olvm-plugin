/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.IscsiBondBuilder;
import org.ovirt.engine.sdk4.types.IscsiBond;

public interface IscsiBondService extends Service {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        /**
         * The iSCSI bond.
         */
        IscsiBond bond();
    }
    
    GetRequest get();
    
    /**
     * Removes of an existing iSCSI bond.
     * 
     * For example, to remove the iSCSI bond `456` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123/iscsibonds/456
     * ----
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Removes of an existing iSCSI bond.
     * 
     * For example, to remove the iSCSI bond `456` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123/iscsibonds/456
     * ----
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Removes of an existing iSCSI bond.
     * 
     * For example, to remove the iSCSI bond `456` send a request like this:
     * 
     * [source]
     * ----
     * DELETE /ovirt-engine/api/datacenters/123/iscsibonds/456
     * ----
     */
    RemoveRequest remove();
    
    /**
     * Updates an iSCSI bond.
     * 
     * Updating of an iSCSI bond can be done on the `name` and the `description` attributes only. For example, to
     * update the iSCSI bond `456` of data center `123`, send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123/iscsibonds/1234
     * ----
     * 
     * The request body should look like this:
     * 
     * [source,xml]
     * ----
     * <iscsi_bond>
     *    <name>mybond</name>
     *    <description>My iSCSI bond</description>
     * </iscsi_bond>
     * ----
     */
    public interface UpdateRequest extends Request<UpdateRequest, UpdateResponse> {
        /**
         * Indicates if the update should be performed asynchronously.
         */
        UpdateRequest async(Boolean async);
        UpdateRequest bond(IscsiBond bond);
        /**
         * The iSCSI bond to update.
         */
        UpdateRequest bond(IscsiBondBuilder bond);
    }
    
    /**
     * Updates an iSCSI bond.
     * 
     * Updating of an iSCSI bond can be done on the `name` and the `description` attributes only. For example, to
     * update the iSCSI bond `456` of data center `123`, send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123/iscsibonds/1234
     * ----
     * 
     * The request body should look like this:
     * 
     * [source,xml]
     * ----
     * <iscsi_bond>
     *    <name>mybond</name>
     *    <description>My iSCSI bond</description>
     * </iscsi_bond>
     * ----
     */
    public interface UpdateResponse extends Response {
        /**
         * The iSCSI bond to update.
         */
        IscsiBond bond();
    }
    
    /**
     * Updates an iSCSI bond.
     * 
     * Updating of an iSCSI bond can be done on the `name` and the `description` attributes only. For example, to
     * update the iSCSI bond `456` of data center `123`, send a request like this:
     * 
     * [source]
     * ----
     * PUT /ovirt-engine/api/datacenters/123/iscsibonds/1234
     * ----
     * 
     * The request body should look like this:
     * 
     * [source,xml]
     * ----
     * <iscsi_bond>
     *    <name>mybond</name>
     *    <description>My iSCSI bond</description>
     * </iscsi_bond>
     * ----
     */
    UpdateRequest update();
    
    NetworksService networksService();
    StorageServerConnectionsService storageServerConnectionsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

