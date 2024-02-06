/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the status of the job.
 */
public enum JobStatus {
    /**
     * The aborted job status.
     * This status is applicable for an external job that was forcibly aborted.
     */
    ABORTED("aborted"),
    /**
     * The failed job status.
     */
    FAILED("failed"),
    /**
     * The finished job status.
     * This status describes a completed job execution.
     */
    FINISHED("finished"),
    /**
     * The started job status.
     * This status represents a job which is currently being executed.
     */
    STARTED("started"),
    /**
     * The unknown job status.
     * This status represents jobs which their resolution is not known, i.e. jobs that were executed before
     * the system was unexpectedly restarted.
     */
    UNKNOWN("unknown"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(JobStatus.class);
    
    private String image;
    
    JobStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static JobStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'JobStatus' enumerated type. " +
            "Valid values are 'aborted', 'failed', 'finished', 'started' and 'unknown'.",
            exception
            );
            return null;
        }
    }
    
}

