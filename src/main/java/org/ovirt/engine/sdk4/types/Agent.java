/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * Type representing a fence agent.
 */
public interface Agent extends Identified {
    String address();
    
    boolean addressPresent();
    
    boolean concurrent();
    
    boolean concurrentPresent();
    
    boolean encryptOptions();
    
    boolean encryptOptionsPresent();
    
    List<Option> options();
    
    boolean optionsPresent();
    
    BigInteger order();
    Byte orderAsByte();
    Short orderAsShort();
    Integer orderAsInteger();
    Long orderAsLong();
    
    boolean orderPresent();
    
    String password();
    
    boolean passwordPresent();
    
    BigInteger port();
    Byte portAsByte();
    Short portAsShort();
    Integer portAsInteger();
    Long portAsLong();
    
    boolean portPresent();
    
    String type();
    
    boolean typePresent();
    
    String username();
    
    boolean usernamePresent();
    
    Host host();
    
    boolean hostPresent();
    
}
