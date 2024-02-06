/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing a step type.
 */
public enum StepEnum {
    /**
     * The executing step type.
     * Used to track the main execution block of the job.
     * Usually it will be a parent step of several sub-steps which describe portions of the execution step.
     */
    EXECUTING("executing"),
    /**
     * The finalizing step type.
     * Describes the post-execution steps requires to complete the `job`.
     */
    FINALIZING("finalizing"),
    /**
     * The `rebalancing volume` step type.
     * Describes a step type which is part of `Gluster` flow.
     */
    REBALANCING_VOLUME("rebalancing_volume"),
    /**
     * The `removing bricks` step type.
     * Describes a step type which is part of `Gluster` flow.
     */
    REMOVING_BRICKS("removing_bricks"),
    /**
     * The unknown step type.
     * Describes a step type which its origin is unknown.
     */
    UNKNOWN("unknown"),
    /**
     * The validation step type.
     * Used to verify the correctness of parameters and the validity of the parameters prior to the execution.
     */
    VALIDATING("validating"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(StepEnum.class);
    
    private String image;
    
    StepEnum(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static StepEnum fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'StepEnum' enumerated type. " +
            "Valid values are 'executing', 'finalizing', 'rebalancing_volume', 'removing_bricks', 'unknown' and 'validating'.",
            exception
            );
            return null;
        }
    }
    
}

