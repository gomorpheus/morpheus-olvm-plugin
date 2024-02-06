/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * This interface is the base model for all types that represent objects with an identifier.
 */
public interface Identified {
    String comment();
    
    boolean commentPresent();
    
    String description();
    
    boolean descriptionPresent();
    
    String href();
    
    boolean hrefPresent();
    
    String id();
    
    boolean idPresent();
    
    String name();
    
    boolean namePresent();
    
}
