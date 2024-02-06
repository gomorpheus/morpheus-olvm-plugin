/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

/**
 * Represents an external provider.
 */
public interface ExternalProvider extends Identified {
    String authenticationUrl();
    
    boolean authenticationUrlPresent();
    
    String password();
    
    boolean passwordPresent();
    
    List<Property> properties();
    
    boolean propertiesPresent();
    
    boolean requiresAuthentication();
    
    boolean requiresAuthenticationPresent();
    
    String url();
    
    boolean urlPresent();
    
    String username();
    
    boolean usernamePresent();
    
}
