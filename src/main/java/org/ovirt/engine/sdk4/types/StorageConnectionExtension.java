/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface StorageConnectionExtension extends Identified {
    String password();
    
    boolean passwordPresent();
    
    String target();
    
    boolean targetPresent();
    
    String username();
    
    boolean usernamePresent();
    
    Host host();
    
    boolean hostPresent();
    
}
