/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * The underlying representation of a floppy file.
 */
public interface Floppy extends Device {
    File file();
    
    boolean filePresent();
    
}
