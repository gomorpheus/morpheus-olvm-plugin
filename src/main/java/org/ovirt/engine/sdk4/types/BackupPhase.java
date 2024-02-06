/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum BackupPhase {
    /**
     * The final phase, indicates that the backup has failed.
     */
    FAILED("failed"),
    /**
     * In this phase, the backup is invoking 'stop_backup' operation in order to complete
     * the backup and unlock the relevant disk.
     */
    FINALIZING("finalizing"),
    /**
     * The initial phase of the backup. It is set on entity creation.
     */
    INITIALIZING("initializing"),
    /**
     * The phase means that the relevant disks' backup URLs are ready to be used and downloaded
     * using image transfer.
     */
    READY("ready"),
    /**
     * The phase is set before invoking 'start_backup' operation in vdsm/libvirt
     * (which means that 'stop_backup' should be invoked to complete the flow).
     */
    STARTING("starting"),
    /**
     * The final phase, indicates that the backup has finished successfully.
     */
    SUCCEEDED("succeeded"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(BackupPhase.class);
    
    private String image;
    
    BackupPhase(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static BackupPhase fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'BackupPhase' enumerated type. " +
            "Valid values are 'failed', 'finalizing', 'initializing', 'ready', 'starting' and 'succeeded'.",
            exception
            );
            return null;
        }
    }
    
}

