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
import org.ovirt.engine.sdk4.builders.JobBuilder;
import org.ovirt.engine.sdk4.types.Job;

/**
 * A service to manage jobs.
 */
public interface JobsService extends Service {
    /**
     * Add an external job.
     * 
     * For example, to add a job with the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <job>
     *   <description>Doing some work</description>
     *   <auto_cleared>true</auto_cleared>
     * </job>
     * ----
     * 
     * The response should look like:
     * 
     * [source,xml]
     * ----
     * <job href="/ovirt-engine/api/jobs/123" id="123">
     *   <actions>
     *     <link href="/ovirt-engine/api/jobs/123/clear" rel="clear"/>
     *     <link href="/ovirt-engine/api/jobs/123/end" rel="end"/>
     *   </actions>
     *   <description>Doing some work</description>
     *   <link href="/ovirt-engine/api/jobs/123/steps" rel="steps"/>
     *   <auto_cleared>true</auto_cleared>
     *   <external>true</external>
     *   <last_updated>2016-12-13T02:15:42.130+02:00</last_updated>
     *   <start_time>2016-12-13T02:15:42.130+02:00</start_time>
     *   <status>started</status>
     *   <owner href="/ovirt-engine/api/users/456" id="456"/>
     * </job>
     * ----
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest job(Job job);
        /**
         * Job that will be added.
         */
        AddRequest job(JobBuilder job);
    }
    
    /**
     * Add an external job.
     * 
     * For example, to add a job with the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <job>
     *   <description>Doing some work</description>
     *   <auto_cleared>true</auto_cleared>
     * </job>
     * ----
     * 
     * The response should look like:
     * 
     * [source,xml]
     * ----
     * <job href="/ovirt-engine/api/jobs/123" id="123">
     *   <actions>
     *     <link href="/ovirt-engine/api/jobs/123/clear" rel="clear"/>
     *     <link href="/ovirt-engine/api/jobs/123/end" rel="end"/>
     *   </actions>
     *   <description>Doing some work</description>
     *   <link href="/ovirt-engine/api/jobs/123/steps" rel="steps"/>
     *   <auto_cleared>true</auto_cleared>
     *   <external>true</external>
     *   <last_updated>2016-12-13T02:15:42.130+02:00</last_updated>
     *   <start_time>2016-12-13T02:15:42.130+02:00</start_time>
     *   <status>started</status>
     *   <owner href="/ovirt-engine/api/users/456" id="456"/>
     * </job>
     * ----
     */
    public interface AddResponse extends Response {
        /**
         * Job that will be added.
         */
        Job job();
    }
    
    /**
     * Add an external job.
     * 
     * For example, to add a job with the following request:
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/jobs
     * ----
     * 
     * With the following request body:
     * 
     * [source,xml]
     * ----
     * <job>
     *   <description>Doing some work</description>
     *   <auto_cleared>true</auto_cleared>
     * </job>
     * ----
     * 
     * The response should look like:
     * 
     * [source,xml]
     * ----
     * <job href="/ovirt-engine/api/jobs/123" id="123">
     *   <actions>
     *     <link href="/ovirt-engine/api/jobs/123/clear" rel="clear"/>
     *     <link href="/ovirt-engine/api/jobs/123/end" rel="end"/>
     *   </actions>
     *   <description>Doing some work</description>
     *   <link href="/ovirt-engine/api/jobs/123/steps" rel="steps"/>
     *   <auto_cleared>true</auto_cleared>
     *   <external>true</external>
     *   <last_updated>2016-12-13T02:15:42.130+02:00</last_updated>
     *   <start_time>2016-12-13T02:15:42.130+02:00</start_time>
     *   <status>started</status>
     *   <owner href="/ovirt-engine/api/users/456" id="456"/>
     * </job>
     * ----
     */
    AddRequest add();
    
    /**
     * Retrieves the representation of the jobs.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/jobs
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <jobs>
     *   <job href="/ovirt-engine/api/jobs/123" id="123">
     *     <actions>
     *       <link href="/ovirt-engine/api/jobs/123/clear" rel="clear"/>
     *       <link href="/ovirt-engine/api/jobs/123/end" rel="end"/>
     *     </actions>
     *     <description>Adding Disk</description>
     *     <link href="/ovirt-engine/api/jobs/123/steps" rel="steps"/>
     *     <auto_cleared>true</auto_cleared>
     *     <end_time>2016-12-12T23:07:29.758+02:00</end_time>
     *     <external>false</external>
     *     <last_updated>2016-12-12T23:07:29.758+02:00</last_updated>
     *     <start_time>2016-12-12T23:07:26.593+02:00</start_time>
     *     <status>failed</status>
     *     <owner href="/ovirt-engine/api/users/456" id="456"/>
     *   </job>
     *   ...
     * </jobs>
     * ----
     * 
     * The order of the returned list of jobs isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the search performed using the `search` parameter should be performed taking case into
         * account. The default value is `true`, which means that case is taken into account. If you want to search
         * ignoring case set it to `false`.
         */
        ListRequest caseSensitive(Boolean caseSensitive);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of jobs to return. If not specified all the jobs are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of jobs to return. If not specified all the jobs are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of jobs to return. If not specified all the jobs are returned.
         */
        ListRequest max(BigInteger max);
        /**
         * A query string used to restrict the returned jobs.
         */
        ListRequest search(String search);
    }
    
    /**
     * Retrieves the representation of the jobs.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/jobs
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <jobs>
     *   <job href="/ovirt-engine/api/jobs/123" id="123">
     *     <actions>
     *       <link href="/ovirt-engine/api/jobs/123/clear" rel="clear"/>
     *       <link href="/ovirt-engine/api/jobs/123/end" rel="end"/>
     *     </actions>
     *     <description>Adding Disk</description>
     *     <link href="/ovirt-engine/api/jobs/123/steps" rel="steps"/>
     *     <auto_cleared>true</auto_cleared>
     *     <end_time>2016-12-12T23:07:29.758+02:00</end_time>
     *     <external>false</external>
     *     <last_updated>2016-12-12T23:07:29.758+02:00</last_updated>
     *     <start_time>2016-12-12T23:07:26.593+02:00</start_time>
     *     <status>failed</status>
     *     <owner href="/ovirt-engine/api/users/456" id="456"/>
     *   </job>
     *   ...
     * </jobs>
     * ----
     * 
     * The order of the returned list of jobs isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * A representation of jobs.
         */
        List<Job> jobs();
    }
    
    /**
     * Retrieves the representation of the jobs.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/jobs
     * ----
     * 
     * You will receive response in XML like this one:
     * 
     * [source,xml]
     * ----
     * <jobs>
     *   <job href="/ovirt-engine/api/jobs/123" id="123">
     *     <actions>
     *       <link href="/ovirt-engine/api/jobs/123/clear" rel="clear"/>
     *       <link href="/ovirt-engine/api/jobs/123/end" rel="end"/>
     *     </actions>
     *     <description>Adding Disk</description>
     *     <link href="/ovirt-engine/api/jobs/123/steps" rel="steps"/>
     *     <auto_cleared>true</auto_cleared>
     *     <end_time>2016-12-12T23:07:29.758+02:00</end_time>
     *     <external>false</external>
     *     <last_updated>2016-12-12T23:07:29.758+02:00</last_updated>
     *     <start_time>2016-12-12T23:07:26.593+02:00</start_time>
     *     <status>failed</status>
     *     <owner href="/ovirt-engine/api/users/456" id="456"/>
     *   </job>
     *   ...
     * </jobs>
     * ----
     * 
     * The order of the returned list of jobs isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to the job service.
     */
    JobService jobService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

