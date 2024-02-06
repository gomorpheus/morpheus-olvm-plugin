/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

public interface Ssh extends Identified {
    SshAuthenticationMethod authenticationMethod();
    
    boolean authenticationMethodPresent();
    
    String fingerprint();
    
    boolean fingerprintPresent();
    
    BigInteger port();
    Byte portAsByte();
    Short portAsShort();
    Integer portAsInteger();
    Long portAsLong();
    
    boolean portPresent();
    
    String publicKey();
    
    boolean publicKeyPresent();
    
    User user();
    
    boolean userPresent();
    
}
