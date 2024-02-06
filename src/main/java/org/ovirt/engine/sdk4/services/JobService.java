/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.Job;

/**
 * A service to manage a job.
 */
public interface JobService extends Service {
    /**
     * Set an external job execution to be cleared by the system.
     * 
     * For example, to set a job with identifier `123` send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs/clear
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface ClearRequest extends Request<ClearRequest, ClearResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        ClearRequest async(Boolean async);
    }
    
    /**
     * Set an external job execution to be cleared by the system.
     * 
     * For example, to set a job with identifier `123` send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs/clear
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    public interface ClearResponse extends Response {
    }
    
    /**
     * Set an external job execution to be cleared by the system.
     * 
     * For example, to set a job with identifier `123` send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs/clear
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     */
    ClearRequest clear();
    
    /**
     * Marks an external job execution as ended.
     * 
     * For example, to terminate a job with identifier `123` send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs/end
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <force>true</force>
     *   <status>finished</status>
     * </action>
     * ----
     */
    public interface EndRequest extends Request<EndRequest, EndResponse> {
        /**
         * Indicates if the action should be performed asynchronously.
         */
        EndRequest async(Boolean async);
        /**
         * Indicates if the job should be forcibly terminated.
         */
        EndRequest force(Boolean force);
        /**
         * Indicates if the job should be marked as successfully finished or as failed.
         * 
         * This parameter is optional, and the default value is `true`.
         */
        EndRequest succeeded(Boolean succeeded);
    }
    
    /**
     * Marks an external job execution as ended.
     * 
     * For example, to terminate a job with identifier `123` send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs/end
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <force>true</force>
     *   <status>finished</status>
     * </action>
     * ----
     */
    public interface EndResponse extends Response {
    }
    
    /**
     * Marks an external job execution as ended.
     * 
     * For example, to terminate a job with identifier `123` send the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs/end
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <action>
     *   <force>true</force>
     *   <status>finished</status>
     * </action>
     * ----
     */
    EndRequest end();
    
    /**
     * Retrieves a job.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/jobs/123
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <job href="/ovirt-engine/api/jobs/123" id="123">
     *   <actions>
     *     <link href="/ovirt-engine/api/jobs/123/clear" rel="clear"/>
     *     <link href="/ovirt-engine/api/jobs/123/end" rel="end"/>
     *   </actions>
     *   <description>Adding Disk</description>
     *   <link href="/ovirt-engine/api/jobs/123/steps" rel="steps"/>
     *   <auto_cleared>true</auto_cleared>
     *   <end_time>2016-12-12T23:07:29.758+02:00</end_time>
     *   <external>false</external>
     *   <last_updated>2016-12-12T23:07:29.758+02:00</last_updated>
     *   <start_time>2016-12-12T23:07:26.593+02:00</start_time>
     *   <status>failed</status>
     *   <owner href="/ovirt-engine/api/users/456" id="456"/>
     * </job>
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
     * Retrieves a job.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/jobs/123
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <job href="/ovirt-engine/api/jobs/123" id="123">
     *   <actions>
     *     <link href="/ovirt-engine/api/jobs/123/clear" rel="clear"/>
     *     <link href="/ovirt-engine/api/jobs/123/end" rel="end"/>
     *   </actions>
     *   <description>Adding Disk</description>
     *   <link href="/ovirt-engine/api/jobs/123/steps" rel="steps"/>
     *   <auto_cleared>true</auto_cleared>
     *   <end_time>2016-12-12T23:07:29.758+02:00</end_time>
     *   <external>false</external>
     *   <last_updated>2016-12-12T23:07:29.758+02:00</last_updated>
     *   <start_time>2016-12-12T23:07:26.593+02:00</start_time>
     *   <status>failed</status>
     *   <owner href="/ovirt-engine/api/users/456" id="456"/>
     * </job>
     * ----
     */
    public interface GetResponse extends Response {
        /**
         * Retrieves the representation of the job.
         */
        Job job();
    }
    
    /**
     * Retrieves a job.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/jobs/123
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <job href="/ovirt-engine/api/jobs/123" id="123">
     *   <actions>
     *     <link href="/ovirt-engine/api/jobs/123/clear" rel="clear"/>
     *     <link href="/ovirt-engine/api/jobs/123/end" rel="end"/>
     *   </actions>
     *   <description>Adding Disk</description>
     *   <link href="/ovirt-engine/api/jobs/123/steps" rel="steps"/>
     *   <auto_cleared>true</auto_cleared>
     *   <end_time>2016-12-12T23:07:29.758+02:00</end_time>
     *   <external>false</external>
     *   <last_updated>2016-12-12T23:07:29.758+02:00</last_updated>
     *   <start_time>2016-12-12T23:07:26.593+02:00</start_time>
     *   <status>failed</status>
     *   <owner href="/ovirt-engine/api/users/456" id="456"/>
     * </job>
     * ----
     */
    GetRequest get();
    
    /**
     * List all the steps of the job.
     * 
     * The order of the returned list of steps isn't guaranteed.
     */
    StepsService stepsService();
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

