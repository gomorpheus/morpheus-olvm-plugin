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
import org.ovirt.engine.sdk4.builders.SshPublicKeyBuilder;
import org.ovirt.engine.sdk4.types.SshPublicKey;

public interface SshPublicKeysService extends Service {
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest key(SshPublicKey key);
        AddRequest key(SshPublicKeyBuilder key);
    }
    
    public interface AddResponse extends Response {
        SshPublicKey key();
    }
    
    AddRequest add();
    
    /**
     * Returns a list of SSH public keys of the user.
     * 
     * For example, to retrieve the list of SSH keys of user with identifier `123`,
     * send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/users/123/sshpublickeys
     * ----
     * 
     * The result will be the following XML document:
     * 
     * [source,xml]
     * ----
     * <ssh_public_keys>
     *   <ssh_public_key href="/ovirt-engine/api/users/123/sshpublickeys/456" id="456">
     *     <content>ssh-rsa ...</content>
     *     <user href="/ovirt-engine/api/users/123" id="123"/>
     *   </ssh_public_key>
     * </ssh_public_keys>
     * ----
     * 
     * Or the following JSON object
     * 
     * [source,json]
     * ----
     * {
         *   "ssh_public_key": [
         *     {
             *       "content": "ssh-rsa ...",
             *       "user": {
                 *         "href": "/ovirt-engine/api/users/123",
                 *         "id": "123"
                 *       },
                 *       "href": "/ovirt-engine/api/users/123/sshpublickeys/456",
                 *       "id": "456"
             *     }
             *   ]
         * }
         * ----
         * 
         * The order of the returned list of keys is not guaranteed.
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
         * Returns a list of SSH public keys of the user.
         * 
         * For example, to retrieve the list of SSH keys of user with identifier `123`,
         * send a request like this:
         * 
         * [source]
         * ----
         * GET /ovirt-engine/api/users/123/sshpublickeys
         * ----
         * 
         * The result will be the following XML document:
         * 
         * [source,xml]
         * ----
         * <ssh_public_keys>
         *   <ssh_public_key href="/ovirt-engine/api/users/123/sshpublickeys/456" id="456">
         *     <content>ssh-rsa ...</content>
         *     <user href="/ovirt-engine/api/users/123" id="123"/>
         *   </ssh_public_key>
         * </ssh_public_keys>
         * ----
         * 
         * Or the following JSON object
         * 
         * [source,json]
         * ----
         * {
             *   "ssh_public_key": [
             *     {
                 *       "content": "ssh-rsa ...",
                 *       "user": {
                     *         "href": "/ovirt-engine/api/users/123",
                     *         "id": "123"
                     *       },
                     *       "href": "/ovirt-engine/api/users/123/sshpublickeys/456",
                     *       "id": "456"
                 *     }
                 *   ]
             * }
             * ----
             * 
             * The order of the returned list of keys is not guaranteed.
             */
            public interface ListResponse extends Response {
                List<SshPublicKey> keys();
            }
            
            /**
             * Returns a list of SSH public keys of the user.
             * 
             * For example, to retrieve the list of SSH keys of user with identifier `123`,
             * send a request like this:
             * 
             * [source]
             * ----
             * GET /ovirt-engine/api/users/123/sshpublickeys
             * ----
             * 
             * The result will be the following XML document:
             * 
             * [source,xml]
             * ----
             * <ssh_public_keys>
             *   <ssh_public_key href="/ovirt-engine/api/users/123/sshpublickeys/456" id="456">
             *     <content>ssh-rsa ...</content>
             *     <user href="/ovirt-engine/api/users/123" id="123"/>
             *   </ssh_public_key>
             * </ssh_public_keys>
             * ----
             * 
             * Or the following JSON object
             * 
             * [source,json]
             * ----
             * {
                 *   "ssh_public_key": [
                 *     {
                     *       "content": "ssh-rsa ...",
                     *       "user": {
                         *         "href": "/ovirt-engine/api/users/123",
                         *         "id": "123"
                         *       },
                         *       "href": "/ovirt-engine/api/users/123/sshpublickeys/456",
                         *       "id": "456"
                     *     }
                     *   ]
                 * }
                 * ----
                 * 
                 * The order of the returned list of keys is not guaranteed.
                 */
                ListRequest list();
                
                SshPublicKeyService keyService(String id);
                /**
                 * Service locator method, returns individual service on which the URI is dispatched.
                 */
                Service service(String path);
            }
            
