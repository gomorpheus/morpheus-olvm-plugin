/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.DataCenterBuilder;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.OpenStackNetwork;

public interface OpenstackNetworkService extends Service {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    public interface GetResponse extends Response {
        OpenStackNetwork network();
    }
    
    GetRequest get();
    
    /**
     * This operation imports an external network into {product-name}.
     * The network will be added to the specified data center.
     */
    public interface ImportRequest extends Request<ImportRequest, ImportResponse> {
        /**
         * Indicates if the import should be performed asynchronously.
         */
        ImportRequest async(Boolean async);
        ImportRequest dataCenter(DataCenter dataCenter);
        /**
         * The data center into which the network is to be imported.
         * Data center is mandatory, and can be specified
         * using the `id` or `name` attributes. The rest of
         * the attributes will be ignored.
         * 
         * NOTE: If <<types/open_stack_network_provider/attributes/auto_sync,`auto_sync`>> is
         * enabled for the provider, the network might be imported automatically. To
         * prevent this, automatic import can be disabled by setting the `auto_sync` to false,
         * and enabling it again after importing the network.
         */
        ImportRequest dataCenter(DataCenterBuilder dataCenter);
    }
    
    /**
     * This operation imports an external network into {product-name}.
     * The network will be added to the specified data center.
     */
    public interface ImportResponse extends Response {
    }
    
    /**
     * This operation imports an external network into {product-name}.
     * The network will be added to the specified data center.
     */
    ImportRequest import_();
    
    OpenstackSubnetsService subnetsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

