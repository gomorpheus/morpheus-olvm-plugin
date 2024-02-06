/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

public interface Payload {
    List<File> files();
    
    boolean filesPresent();
    
    VmDeviceType type();
    
    boolean typePresent();
    
    String volumeId();
    
    boolean volumeIdPresent();
    
}
