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
import org.ovirt.engine.sdk4.types.KatelloErratum;

/**
 * A service to manage Katello errata.
 * The information is retrieved from Katello.
 */
public interface KatelloErrataService extends Service {
    /**
     * Retrieves the representation of the Katello errata.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/katelloerrata
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <katello_errata>
     *   <katello_erratum href="/ovirt-engine/api/katelloerrata/123" id="123">
     *     <name>RHBA-2013:XYZ</name>
     *     <description>The description of the erratum</description>
     *     <title>some bug fix update</title>
     *     <type>bugfix</type>
     *     <issued>2013-11-20T02:00:00.000+02:00</issued>
     *     <solution>Few guidelines regarding the solution</solution>
     *     <summary>Updated packages that fix one bug are now available for XYZ</summary>
     *     <packages>
     *       <package>
     *         <name>libipa_hbac-1.9.2-82.11.el6_4.i686</name>
     *       </package>
     *       ...
     *     </packages>
     *   </katello_erratum>
     *   ...
     * </katello_errata>
     * ----
     * 
     * The order of the returned list of erratum isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of errata to return. If not specified all the errata are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of errata to return. If not specified all the errata are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of errata to return. If not specified all the errata are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Retrieves the representation of the Katello errata.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/katelloerrata
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <katello_errata>
     *   <katello_erratum href="/ovirt-engine/api/katelloerrata/123" id="123">
     *     <name>RHBA-2013:XYZ</name>
     *     <description>The description of the erratum</description>
     *     <title>some bug fix update</title>
     *     <type>bugfix</type>
     *     <issued>2013-11-20T02:00:00.000+02:00</issued>
     *     <solution>Few guidelines regarding the solution</solution>
     *     <summary>Updated packages that fix one bug are now available for XYZ</summary>
     *     <packages>
     *       <package>
     *         <name>libipa_hbac-1.9.2-82.11.el6_4.i686</name>
     *       </package>
     *       ...
     *     </packages>
     *   </katello_erratum>
     *   ...
     * </katello_errata>
     * ----
     * 
     * The order of the returned list of erratum isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * A representation of Katello errata.
         */
        List<KatelloErratum> errata();
    }
    
    /**
     * Retrieves the representation of the Katello errata.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/katelloerrata
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <katello_errata>
     *   <katello_erratum href="/ovirt-engine/api/katelloerrata/123" id="123">
     *     <name>RHBA-2013:XYZ</name>
     *     <description>The description of the erratum</description>
     *     <title>some bug fix update</title>
     *     <type>bugfix</type>
     *     <issued>2013-11-20T02:00:00.000+02:00</issued>
     *     <solution>Few guidelines regarding the solution</solution>
     *     <summary>Updated packages that fix one bug are now available for XYZ</summary>
     *     <packages>
     *       <package>
     *         <name>libipa_hbac-1.9.2-82.11.el6_4.i686</name>
     *       </package>
     *       ...
     *     </packages>
     *   </katello_erratum>
     *   ...
     * </katello_errata>
     * ----
     * 
     * The order of the returned list of erratum isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to the Katello erratum service.
     * Use this service to view the erratum by its id.
     */
    KatelloErratumService katelloErratumService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

