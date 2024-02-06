/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.KatelloErratum;

/**
 * A service to manage a Katello erratum.
 */
public interface KatelloErratumService extends Service {
    /**
     * Retrieves a Katello erratum.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/katelloerrata/123
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <katello_erratum href="/ovirt-engine/api/katelloerrata/123" id="123">
     *   <name>RHBA-2013:XYZ</name>
     *   <description>The description of the erratum</description>
     *   <title>some bug fix update</title>
     *   <type>bugfix</type>
     *   <issued>2013-11-20T02:00:00.000+02:00</issued>
     *   <solution>Few guidelines regarding the solution</solution>
     *   <summary>Updated packages that fix one bug are now available for XYZ</summary>
     *   <packages>
     *     <package>
     *       <name>libipa_hbac-1.9.2-82.11.el6_4.i686</name>
     *     </package>
     *     ...
     *   </packages>
     * </katello_erratum>
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
     * Retrieves a Katello erratum.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/katelloerrata/123
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <katello_erratum href="/ovirt-engine/api/katelloerrata/123" id="123">
     *   <name>RHBA-2013:XYZ</name>
     *   <description>The description of the erratum</description>
     *   <title>some bug fix update</title>
     *   <type>bugfix</type>
     *   <issued>2013-11-20T02:00:00.000+02:00</issued>
     *   <solution>Few guidelines regarding the solution</solution>
     *   <summary>Updated packages that fix one bug are now available for XYZ</summary>
     *   <packages>
     *     <package>
     *       <name>libipa_hbac-1.9.2-82.11.el6_4.i686</name>
     *     </package>
     *     ...
     *   </packages>
     * </katello_erratum>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Retrieves the representation of the Katello erratum.
         */
        KatelloErratum erratum();
    }
    
    /**
     * Retrieves a Katello erratum.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/katelloerrata/123
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <katello_erratum href="/ovirt-engine/api/katelloerrata/123" id="123">
     *   <name>RHBA-2013:XYZ</name>
     *   <description>The description of the erratum</description>
     *   <title>some bug fix update</title>
     *   <type>bugfix</type>
     *   <issued>2013-11-20T02:00:00.000+02:00</issued>
     *   <solution>Few guidelines regarding the solution</solution>
     *   <summary>Updated packages that fix one bug are now available for XYZ</summary>
     *   <packages>
     *     <package>
     *       <name>libipa_hbac-1.9.2-82.11.el6_4.i686</name>
     *     </package>
     *     ...
     *   </packages>
     * </katello_erratum>
     * ----
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

