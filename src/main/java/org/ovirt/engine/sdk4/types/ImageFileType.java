/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the file type of an image.
 */
public enum ImageFileType {
    /**
     * The image is a disk format that can be used as a virtual machine's disk.
     */
    DISK("disk"),
    /**
     * The image is a floppy disk that can be attached to a virtual machine,
     * for example to install the VirtIO drivers in Windows.
     */
    FLOPPY("floppy"),
    /**
     * The image is a `.iso` file that can be used as a CD-ROM
     * to boot and install a virtual machine.
     */
    ISO("iso"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(ImageFileType.class);
    
    private String image;
    
    ImageFileType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static ImageFileType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'ImageFileType' enumerated type. " +
            "Valid values are 'disk', 'floppy' and 'iso'.",
            exception
            );
            return null;
        }
    }
    
}

