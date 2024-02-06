/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the status of the step.
 */
public enum StepStatus {
    /**
     * The aborted step status.
     * This status is applicable for an external step that was forcibly aborted.
     */
    ABORTED("aborted"),
    /**
     * The failed step status.
     */
    FAILED("failed"),
    /**
     * The finished step status.
     * This status describes a completed step execution.
     */
    FINISHED("finished"),
    /**
     * The started step status.
     * This status represents a step which is currently being executed.
     */
    STARTED("started"),
    /**
     * The unknown step status.
     * This status represents steps which their resolution is not known, i.e. steps that were executed before
     * the system was unexpectedly restarted.
     */
    UNKNOWN("unknown"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(StepStatus.class);
    
    private String image;
    
    StepStatus(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static StepStatus fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'StepStatus' enumerated type. " +
            "Valid values are 'aborted', 'failed', 'finished', 'started' and 'unknown'.",
            exception
            );
            return null;
        }
    }
    
}

