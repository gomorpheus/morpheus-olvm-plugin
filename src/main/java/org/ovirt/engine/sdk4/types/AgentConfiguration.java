/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

/**
 * Deprecated Agent configuration settings.
 * 
 * Ignored, because the deployment of OpenStack Neutron agent is dropped since {product-name} 4.4.0.
 * The deployment of OpenStack hosts can be done by Red Hat OpenStack Platform Director or TripleO.
 */
public interface AgentConfiguration {
    String address();
    
    boolean addressPresent();
    
    MessageBrokerType brokerType();
    
    boolean brokerTypePresent();
    
    String networkMappings();
    
    boolean networkMappingsPresent();
    
    String password();
    
    boolean passwordPresent();
    
    BigInteger port();
    Byte portAsByte();
    Short portAsShort();
    Integer portAsInteger();
    Long portAsLong();
    
    boolean portPresent();
    
    String username();
    
    boolean usernamePresent();
    
}
