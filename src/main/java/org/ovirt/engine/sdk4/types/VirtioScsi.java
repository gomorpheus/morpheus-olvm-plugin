/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Type representing the support of virtio-SCSI.
 * If it supported we use virtio driver for SCSI guest device.
 */
public interface VirtioScsi {
    boolean enabled();
    
    boolean enabledPresent();
    
}
