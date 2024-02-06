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
import org.ovirt.engine.sdk4.builders.IscsiBondBuilder;
import org.ovirt.engine.sdk4.types.IscsiBond;

public interface IscsiBondsService extends Service {
    /**
     * Create a new iSCSI bond on a data center.
     * 
     * For example, to create a new iSCSI bond on data center `123` using storage connections `456` and `789`, send a
     * request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/iscsibonds
     * ----
     * 
     * The request body should look like this:
     * 
     * [source,xml]
     * ----
     * <iscsi_bond>
     *   <name>mybond</name>
     *   <storage_connections>
     *     <storage_connection id="456"/>
     *     <storage_connection id="789"/>
     *   </storage_connections>
     *   <networks>
     *     <network id="abc"/>
     *   </networks>
     * </iscsi_bond>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest bond(IscsiBond bond);
        AddRequest bond(IscsiBondBuilder bond);
    }
    
    /**
     * Create a new iSCSI bond on a data center.
     * 
     * For example, to create a new iSCSI bond on data center `123` using storage connections `456` and `789`, send a
     * request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/iscsibonds
     * ----
     * 
     * The request body should look like this:
     * 
     * [source,xml]
     * ----
     * <iscsi_bond>
     *   <name>mybond</name>
     *   <storage_connections>
     *     <storage_connection id="456"/>
     *     <storage_connection id="789"/>
     *   </storage_connections>
     *   <networks>
     *     <network id="abc"/>
     *   </networks>
     * </iscsi_bond>
     * ----
     */
    public interface AddResponse extends Response {
        IscsiBond bond();
    }
    
    /**
     * Create a new iSCSI bond on a data center.
     * 
     * For example, to create a new iSCSI bond on data center `123` using storage connections `456` and `789`, send a
     * request like this:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/datacenters/123/iscsibonds
     * ----
     * 
     * The request body should look like this:
     * 
     * [source,xml]
     * ----
     * <iscsi_bond>
     *   <name>mybond</name>
     *   <storage_connections>
     *     <storage_connection id="456"/>
     *     <storage_connection id="789"/>
     *   </storage_connections>
     *   <networks>
     *     <network id="abc"/>
     *   </networks>
     * </iscsi_bond>
     * ----
     */
    AddRequest add();
    
    /**
     * Returns the list of iSCSI bonds configured in the data center.
     * 
     * The order of the returned list of iSCSI bonds isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of bonds to return. If not specified all the bonds are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of bonds to return. If not specified all the bonds are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of bonds to return. If not specified all the bonds are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of iSCSI bonds configured in the data center.
     * 
     * The order of the returned list of iSCSI bonds isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<IscsiBond> bonds();
    }
    
    /**
     * Returns the list of iSCSI bonds configured in the data center.
     * 
     * The order of the returned list of iSCSI bonds isn't guaranteed.
     */
    ListRequest list();
    
    IscsiBondService iscsiBondService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

