/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Icon of virtual machine or template.
 */
public interface Icon extends Identified {
    String data();
    
    boolean dataPresent();
    
    String mediaType();
    
    boolean mediaTypePresent();
    
}
