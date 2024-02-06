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
import org.ovirt.engine.sdk4.builders.StepBuilder;
import org.ovirt.engine.sdk4.types.Step;

/**
 * A service to manage steps.
 */
public interface StepsService extends Service {
    /**
     * Add an external step to an existing job or to an existing step.
     * 
     * For example, to add a step to `job` with identifier `123` send the
     * following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs/123/steps
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <step>
     *   <description>Validating</description>
     *   <start_time>2016-12-12T23:07:26.605+02:00</start_time>
     *   <status>started</status>
     *   <type>validating</type>
     * </step>
     * ----
     * 
     * The response should look like:
     * 
     * [source,xml]
     * ----
     * <step href="/ovirt-engine/api/jobs/123/steps/456" id="456">
     *   <actions>
     *     <link href="/ovirt-engine/api/jobs/123/steps/456/end" rel="end"/>
     *   </actions>
     *   <description>Validating</description>
     *   <link href="/ovirt-engine/api/jobs/123/steps/456/statistics" rel="statistics"/>
     *   <external>true</external>
     *   <number>2</number>
     *   <start_time>2016-12-13T01:06:15.380+02:00</start_time>
     *   <status>started</status>
     *   <type>validating</type>
     *   <job href="/ovirt-engine/api/jobs/123" id="123"/>
     * </step>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest step(Step step);
        /**
         * Step that will be added.
         */
        AddRequest step(StepBuilder step);
    }
    
    /**
     * Add an external step to an existing job or to an existing step.
     * 
     * For example, to add a step to `job` with identifier `123` send the
     * following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs/123/steps
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <step>
     *   <description>Validating</description>
     *   <start_time>2016-12-12T23:07:26.605+02:00</start_time>
     *   <status>started</status>
     *   <type>validating</type>
     * </step>
     * ----
     * 
     * The response should look like:
     * 
     * [source,xml]
     * ----
     * <step href="/ovirt-engine/api/jobs/123/steps/456" id="456">
     *   <actions>
     *     <link href="/ovirt-engine/api/jobs/123/steps/456/end" rel="end"/>
     *   </actions>
     *   <description>Validating</description>
     *   <link href="/ovirt-engine/api/jobs/123/steps/456/statistics" rel="statistics"/>
     *   <external>true</external>
     *   <number>2</number>
     *   <start_time>2016-12-13T01:06:15.380+02:00</start_time>
     *   <status>started</status>
     *   <type>validating</type>
     *   <job href="/ovirt-engine/api/jobs/123" id="123"/>
     * </step>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * Step that will be added.
         */
        Step step();
    }
    
    /**
     * Add an external step to an existing job or to an existing step.
     * 
     * For example, to add a step to `job` with identifier `123` send the
     * following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs/123/steps
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <step>
     *   <description>Validating</description>
     *   <start_time>2016-12-12T23:07:26.605+02:00</start_time>
     *   <status>started</status>
     *   <type>validating</type>
     * </step>
     * ----
     * 
     * The response should look like:
     * 
     * [source,xml]
     * ----
     * <step href="/ovirt-engine/api/jobs/123/steps/456" id="456">
     *   <actions>
     *     <link href="/ovirt-engine/api/jobs/123/steps/456/end" rel="end"/>
     *   </actions>
     *   <description>Validating</description>
     *   <link href="/ovirt-engine/api/jobs/123/steps/456/statistics" rel="statistics"/>
     *   <external>true</external>
     *   <number>2</number>
     *   <start_time>2016-12-13T01:06:15.380+02:00</start_time>
     *   <status>started</status>
     *   <type>validating</type>
     *   <job href="/ovirt-engine/api/jobs/123" id="123"/>
     * </step>
     * ----
     */
    AddRequest add();
    
    /**
     * Retrieves the representation of the steps.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/job/123/steps
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <steps>
     *   <step href="/ovirt-engine/api/jobs/123/steps/456" id="456">
     *     <actions>
     *       <link href="/ovirt-engine/api/jobs/123/steps/456/end" rel="end"/>
     *     </actions>
     *     <description>Validating</description>
     *     <link href="/ovirt-engine/api/jobs/123/steps/456/statistics" rel="statistics"/>
     *     <external>true</external>
     *     <number>2</number>
     *     <start_time>2016-12-13T01:06:15.380+02:00</start_time>
     *     <status>started</status>
     *     <type>validating</type>
     *     <job href="/ovirt-engine/api/jobs/123" id="123"/>
     *   </step>
     *   ...
     * </steps>
     * ----
     * 
     * The order of the returned list of steps isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of steps to return. If not specified all the steps are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of steps to return. If not specified all the steps are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of steps to return. If not specified all the steps are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Retrieves the representation of the steps.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/job/123/steps
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <steps>
     *   <step href="/ovirt-engine/api/jobs/123/steps/456" id="456">
     *     <actions>
     *       <link href="/ovirt-engine/api/jobs/123/steps/456/end" rel="end"/>
     *     </actions>
     *     <description>Validating</description>
     *     <link href="/ovirt-engine/api/jobs/123/steps/456/statistics" rel="statistics"/>
     *     <external>true</external>
     *     <number>2</number>
     *     <start_time>2016-12-13T01:06:15.380+02:00</start_time>
     *     <status>started</status>
     *     <type>validating</type>
     *     <job href="/ovirt-engine/api/jobs/123" id="123"/>
     *   </step>
     *   ...
     * </steps>
     * ----
     * 
     * The order of the returned list of steps isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * A representation of steps.
         */
        List<Step> steps();
    }
    
    /**
     * Retrieves the representation of the steps.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/job/123/steps
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <steps>
     *   <step href="/ovirt-engine/api/jobs/123/steps/456" id="456">
     *     <actions>
     *       <link href="/ovirt-engine/api/jobs/123/steps/456/end" rel="end"/>
     *     </actions>
     *     <description>Validating</description>
     *     <link href="/ovirt-engine/api/jobs/123/steps/456/statistics" rel="statistics"/>
     *     <external>true</external>
     *     <number>2</number>
     *     <start_time>2016-12-13T01:06:15.380+02:00</start_time>
     *     <status>started</status>
     *     <type>validating</type>
     *     <job href="/ovirt-engine/api/jobs/123" id="123"/>
     *   </step>
     *   ...
     * </steps>
     * ----
     * 
     * The order of the returned list of steps isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to the step service.
     */
    StepService stepService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

