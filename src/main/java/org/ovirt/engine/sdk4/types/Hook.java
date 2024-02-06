/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Represents a hook.
 */
public interface Hook extends Identified {
    String eventName();
    
    boolean eventNamePresent();
    
    String md5();
    
    boolean md5Present();
    
    Host host();
    
    boolean hostPresent();
    
}
