/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum CheckpointState {
    /**
     * The initial state of the checkpoint. It is set on entity creation.
     */
    CREATED("created"),
    /**
     * The INVALID state set when a checkpoint cannot be used anymore for incremental backup
     * and should be removed (For example, after committing to an older VM snapshot).
     */
    INVALID("invalid"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(CheckpointState.class);
    
    private String image;
    
    CheckpointState(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static CheckpointState fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'CheckpointState' enumerated type. " +
            "Valid values are 'created' and 'invalid'.",
            exception
            );
            return null;
        }
    }
    
}

