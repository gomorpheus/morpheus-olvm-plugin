/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

public interface PowerManagement {
    String address();
    
    boolean addressPresent();
    
    List<Agent> agents();
    
    boolean agentsPresent();
    
    boolean automaticPmEnabled();
    
    boolean automaticPmEnabledPresent();
    
    boolean enabled();
    
    boolean enabledPresent();
    
    boolean kdumpDetection();
    
    boolean kdumpDetectionPresent();
    
    List<Option> options();
    
    boolean optionsPresent();
    
    String password();
    
    boolean passwordPresent();
    
    List<PmProxy> pmProxies();
    
    boolean pmProxiesPresent();
    
    PowerManagementStatus status();
    
    boolean statusPresent();
    
    String type();
    
    boolean typePresent();
    
    String username();
    
    boolean usernamePresent();
    
}
