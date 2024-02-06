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
import org.ovirt.engine.sdk4.types.LinkLayerDiscoveryProtocolElement;

/**
 * A service to fetch information elements received by Link Layer Discovery Protocol (LLDP).
 */
public interface LinkLayerDiscoveryProtocolService extends Service {
    /**
     * Fetches information elements received by LLDP.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
    }
    
    /**
     * Fetches information elements received by LLDP.
     */
    public interface ListResponse extends Response {
        /**
         * Retrieves a list of information elements received by LLDP.
         * 
         * For example, to retrieve the information elements received on the NIC `321` on host `123`,
         * send a request like this:
         * 
         * ....
         * GET ovirt-engine/api/hosts/123/nics/321/linklayerdiscoveryprotocolelements
         * ....
         * 
         * It will return a response like this:
         * 
         * [source,xml]
         * ----
         * <link_layer_discovery_protocol_elements>
         *     ...
         *   <link_layer_discovery_protocol_element>
         *     <name>Port Description</name>
         *     <properties>
         *       <property>
         *         <name>port description</name>
         *         <value>Summit300-48-Port 1001</value>
         *       </property>
         *     </properties>
         *     <type>4</type>
         *   </link_layer_discovery_protocol_element>
         *   ...
         * <link_layer_discovery_protocol_elements>
         * ----
         */
        List<LinkLayerDiscoveryProtocolElement> elements();
    }
    
    /**
     * Fetches information elements received by LLDP.
     */
    ListRequest list();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

