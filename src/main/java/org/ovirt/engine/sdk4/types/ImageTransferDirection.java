/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The <<types/image_transfer, image transfer>> direction for a transfer.
 * 
 * When adding a new transfer, the user can choose whether the transfer will be to an image, choosing `upload`,
 * or to transfer from an image- choosing `download` as an ImageTransferDirection.
 * 
 * Please refer to <<services/image_transfer, image transfer>> for further
 * documentation.
 */
public enum ImageTransferDirection {
    /**
     * The user must choose `download` when he/she wants to stream data from an image.
     */
    DOWNLOAD("download"),
    /**
     * The user can choose `upload` when he/she wants to stream data to an image.
     */
    UPLOAD("upload"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(ImageTransferDirection.class);
    
    private String image;
    
    ImageTransferDirection(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static ImageTransferDirection fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'ImageTransferDirection' enumerated type. " +
            "Valid values are 'download' and 'upload'.",
            exception
            );
            return null;
        }
    }
    
}

