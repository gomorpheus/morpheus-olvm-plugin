/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.SystemOption;

/**
 * A service that provides values of specific configuration option of the system.
 */
public interface SystemOptionService extends Service {
    /**
     * Get the values of specific configuration option.
     * 
     * For example to retrieve the values of configuration option `MigrationPoliciesSupported` send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/options/MigrationPoliciesSupported
     * ----
     * 
     * The response to that request will be the following:
     * 
     * [source,xml]
     * ----
     * <system_option href="/ovirt-engine/api/options/MigrationPoliciesSupported" id="MigrationPoliciesSupported">
     *   <name>MigrationPoliciesSupported</name>
     *   <values>
     *     <system_option_value>
     *       <value>true</value>
     *       <version>4.0</version>
     *     </system_option_value>
     *     <system_option_value>
     *       <value>true</value>
     *       <version>4.1</version>
     *     </system_option_value>
     *     <system_option_value>
     *       <value>true</value>
     *       <version>4.2</version>
     *     </system_option_value>
     *     <system_option_value>
     *       <value>false</value>
     *       <version>3.6</version>
     *     </system_option_value>
     *   </values>
     * </system_option>
     * ----
     * 
     * NOTE: The appropriate permissions are required to query configuration options. Some options can be queried
     * only by users with administrator permissions.
     * 
     * [IMPORTANT]
     * ====
     * There is NO backward compatibility and no guarantee about the names or values of the options. Options may be
     * removed and their meaning can be changed at any point.
     * 
     * We strongly discourage the use of this service for applications other than the ones that are released
     * simultaneously with the engine. Usage by other applications is not supported. Therefore there will be no
     * documentation listing accessible configuration options.
     * ====
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Optional version parameter that specifies that only particular version of the configuration option
         * should be returned.
         * If this parameter isn't used then all the versions will be returned.
         * 
         * For example, to get the value of the `MigrationPoliciesSupported` option but only for version `4.2` send
         * a request like this:
         * 
         * [source]
         * ----
         * GET /ovirt-engine/api/options/MigrationPoliciesSupported?version=4.2
         * ----
         * 
         * The response to that request will be like this:
         * 
         * [source,xml]
         * ----
         * <system_option href="/ovirt-engine/api/options/MigrationPoliciesSupported" id="MigrationPoliciesSupported">
         *   <name>MigrationPoliciesSupported</name>
         *   <values>
         *     <system_option_value>
         *       <value>true</value>
         *       <version>4.2</version>
         *     </system_option_value>
         *   </values>
         * </system_option>
         * ----
         */
        GetRequest version(String version);
    }
    
    /**
     * Get the values of specific configuration option.
     * 
     * For example to retrieve the values of configuration option `MigrationPoliciesSupported` send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/options/MigrationPoliciesSupported
     * ----
     * 
     * The response to that request will be the following:
     * 
     * [source,xml]
     * ----
     * <system_option href="/ovirt-engine/api/options/MigrationPoliciesSupported" id="MigrationPoliciesSupported">
     *   <name>MigrationPoliciesSupported</name>
     *   <values>
     *     <system_option_value>
     *       <value>true</value>
     *       <version>4.0</version>
     *     </system_option_value>
     *     <system_option_value>
     *       <value>true</value>
     *       <version>4.1</version>
     *     </system_option_value>
     *     <system_option_value>
     *       <value>true</value>
     *       <version>4.2</version>
     *     </system_option_value>
     *     <system_option_value>
     *       <value>false</value>
     *       <version>3.6</version>
     *     </system_option_value>
     *   </values>
     * </system_option>
     * ----
     * 
     * NOTE: The appropriate permissions are required to query configuration options. Some options can be queried
     * only by users with administrator permissions.
     * 
     * [IMPORTANT]
     * ====
     * There is NO backward compatibility and no guarantee about the names or values of the options. Options may be
     * removed and their meaning can be changed at any point.
     * 
     * We strongly discourage the use of this service for applications other than the ones that are released
     * simultaneously with the engine. Usage by other applications is not supported. Therefore there will be no
     * documentation listing accessible configuration options.
     * ====
     */
    public interface GetResponse extends Response {
        /**
         * The returned configuration option of the system.
         */
        SystemOption option();
    }
    
    /**
     * Get the values of specific configuration option.
     * 
     * For example to retrieve the values of configuration option `MigrationPoliciesSupported` send a request like this:
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/options/MigrationPoliciesSupported
     * ----
     * 
     * The response to that request will be the following:
     * 
     * [source,xml]
     * ----
     * <system_option href="/ovirt-engine/api/options/MigrationPoliciesSupported" id="MigrationPoliciesSupported">
     *   <name>MigrationPoliciesSupported</name>
     *   <values>
     *     <system_option_value>
     *       <value>true</value>
     *       <version>4.0</version>
     *     </system_option_value>
     *     <system_option_value>
     *       <value>true</value>
     *       <version>4.1</version>
     *     </system_option_value>
     *     <system_option_value>
     *       <value>true</value>
     *       <version>4.2</version>
     *     </system_option_value>
     *     <system_option_value>
     *       <value>false</value>
     *       <version>3.6</version>
     *     </system_option_value>
     *   </values>
     * </system_option>
     * ----
     * 
     * NOTE: The appropriate permissions are required to query configuration options. Some options can be queried
     * only by users with administrator permissions.
     * 
     * [IMPORTANT]
     * ====
     * There is NO backward compatibility and no guarantee about the names or values of the options. Options may be
     * removed and their meaning can be changed at any point.
     * 
     * We strongly discourage the use of this service for applications other than the ones that are released
     * simultaneously with the engine. Usage by other applications is not supported. Therefore there will be no
     * documentation listing accessible configuration options.
     * ====
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

