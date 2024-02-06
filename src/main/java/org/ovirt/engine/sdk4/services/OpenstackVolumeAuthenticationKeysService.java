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
import org.ovirt.engine.sdk4.builders.OpenstackVolumeAuthenticationKeyBuilder;
import org.ovirt.engine.sdk4.types.OpenstackVolumeAuthenticationKey;

/**
 * Openstack Volume (Cinder) integration has been replaced by Managed Block Storage.
 */
public interface OpenstackVolumeAuthenticationKeysService extends Service {
    /**
     * Add a new authentication key to the OpenStack volume provider.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest key(OpenstackVolumeAuthenticationKey key);
        AddRequest key(OpenstackVolumeAuthenticationKeyBuilder key);
    }
    
    /**
     * Add a new authentication key to the OpenStack volume provider.
     */
    public interface AddResponse extends Response {
        OpenstackVolumeAuthenticationKey key();
    }
    
    /**
     * Add a new authentication key to the OpenStack volume provider.
     */
    AddRequest add();
    
    /**
     * Returns the list of authentication keys.
     * 
     * The order of the returned list of authentication keys isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of keys to return. If not specified all the keys are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of keys to return. If not specified all the keys are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of keys to return. If not specified all the keys are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of authentication keys.
     * 
     * The order of the returned list of authentication keys isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<OpenstackVolumeAuthenticationKey> keys();
    }
    
    /**
     * Returns the list of authentication keys.
     * 
     * The order of the returned list of authentication keys isn't guaranteed.
     */
    ListRequest list();
    
    OpenstackVolumeAuthenticationKeyService keyService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

