/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The action type for cluster upgrade action.
 */
public enum ClusterUpgradeAction {
    /**
     * The upgrade action to be passed to finish the cluster upgrade process by marking the cluster's
     * upgrade_running flag to false. This should be used at the end of the cluster upgrade process.
     */
    FINISH("finish"),
    /**
     * The upgrade action to be passed to start the cluster upgrade process by marking the cluster's
     * upgrade_running flag to true. This should used at the beginning of the cluster upgrade process.
     */
    START("start"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(ClusterUpgradeAction.class);
    
    private String image;
    
    ClusterUpgradeAction(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static ClusterUpgradeAction fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'ClusterUpgradeAction' enumerated type. " +
            "Valid values are 'finish' and 'start'.",
            exception
            );
            return null;
        }
    }
    
}

