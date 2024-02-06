/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


public interface Cdrom extends Device {
    File file();
    
    boolean filePresent();
    
}
