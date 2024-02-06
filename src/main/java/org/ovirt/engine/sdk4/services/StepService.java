/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Step;

/**
 * A service to manage a step.
 */
public interface StepService extends MeasurableService {
    /**
     * Marks an external step execution as ended.
     * 
     * For example, to terminate a step with identifier `456` which belongs to a `job` with identifier `123` send the
     * following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs/123/steps/456/end
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <force>true</force>
     *   <succeeded>true</succeeded>
     * </action>
     * ----
     */
    public interface EndRequest extends Request<EndRequest, EndResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        EndRequest async(Boolean async);
        /**
         * Indicates if the step should be forcibly terminated.
         */
        EndRequest force(Boolean force);
        /**
         * Indicates if the step should be marked as successfully finished or as failed.
         * 
         * This parameter is optional, and the default value is `true`.
         */
        EndRequest succeeded(Boolean succeeded);
    }
    
    /**
     * Marks an external step execution as ended.
     * 
     * For example, to terminate a step with identifier `456` which belongs to a `job` with identifier `123` send the
     * following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs/123/steps/456/end
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <force>true</force>
     *   <succeeded>true</succeeded>
     * </action>
     * ----
     */
    public interface EndResponse extends Response {
    }
    
    /**
     * Marks an external step execution as ended.
     * 
     * For example, to terminate a step with identifier `456` which belongs to a `job` with identifier `123` send the
     * following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs/123/steps/456/end
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <force>true</force>
     *   <succeeded>true</succeeded>
     * </action>
     * ----
     */
    EndRequest end();
    
    /**
     * Retrieves a step.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/jobs/123/steps/456
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <step href="/ovirt-engine/api/jobs/123/steps/456" id="456">
     *   <actions>
     *     <link href="/ovirt-engine/api/jobs/123/steps/456/end" rel="end"/>
     *   </actions>
     *   <description>Validating</description>
     *   <end_time>2016-12-12T23:07:26.627+02:00</end_time>
     *   <external>false</external>
     *   <number>0</number>
     *   <start_time>2016-12-12T23:07:26.605+02:00</start_time>
     *   <status>finished</status>
     *   <type>validating</type>
     *   <job href="/ovirt-engine/api/jobs/123" id="123"/>
     * </step>
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
     * Retrieves a step.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/jobs/123/steps/456
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <step href="/ovirt-engine/api/jobs/123/steps/456" id="456">
     *   <actions>
     *     <link href="/ovirt-engine/api/jobs/123/steps/456/end" rel="end"/>
     *   </actions>
     *   <description>Validating</description>
     *   <end_time>2016-12-12T23:07:26.627+02:00</end_time>
     *   <external>false</external>
     *   <number>0</number>
     *   <start_time>2016-12-12T23:07:26.605+02:00</start_time>
     *   <status>finished</status>
     *   <type>validating</type>
     *   <job href="/ovirt-engine/api/jobs/123" id="123"/>
     * </step>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Retrieves the representation of the step.
         */
        Step step();
    }
    
    /**
     * Retrieves a step.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/jobs/123/steps/456
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <step href="/ovirt-engine/api/jobs/123/steps/456" id="456">
     *   <actions>
     *     <link href="/ovirt-engine/api/jobs/123/steps/456/end" rel="end"/>
     *   </actions>
     *   <description>Validating</description>
     *   <end_time>2016-12-12T23:07:26.627+02:00</end_time>
     *   <external>false</external>
     *   <number>0</number>
     *   <start_time>2016-12-12T23:07:26.605+02:00</start_time>
     *   <status>finished</status>
     *   <type>validating</type>
     *   <job href="/ovirt-engine/api/jobs/123" id="123"/>
     * </step>
     * ----
     */
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

