/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The <<types/image_transfer, image transfer>> timeout policy.
 * 
 * Define how the system handles a transfer when the client is inactive
 * for inactivityTimeout seconds.
 * 
 * Please refer to <<services/image_transfer, image transfer>> for further
 * documentation.
 */
public enum ImageTransferTimeoutPolicy {
    /**
     * Cancel the transfer and unlock the disk. For image transfer using upload
     * direction, the disk is deleted.
     */
    CANCEL("cancel"),
    /**
     * LEGACY policy will preserve the legacy functionality which is the default.
     * The default behaviour will cancel the transfer if the direction is download,
     * and pause it if its upload.
     */
    LEGACY("legacy"),
    /**
     * Pause the transfer. The transfer can be resumed or canceled by the user.
     * The disk will remain locked while the transfer is paused.
     */
    PAUSE("pause"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(ImageTransferTimeoutPolicy.class);
    
    private String image;
    
    ImageTransferTimeoutPolicy(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static ImageTransferTimeoutPolicy fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'ImageTransferTimeoutPolicy' enumerated type. " +
            "Valid values are 'cancel', 'legacy' and 'pause'.",
            exception
            );
            return null;
        }
    }
    
}

