/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

public interface GraphicsConsole extends Identified {
    String address();
    
    boolean addressPresent();
    
    BigInteger port();
    Byte portAsByte();
    Short portAsShort();
    Integer portAsInteger();
    Long portAsLong();
    
    boolean portPresent();
    
    GraphicsType protocol();
    
    boolean protocolPresent();
    
    BigInteger tlsPort();
    Byte tlsPortAsByte();
    Short tlsPortAsShort();
    Integer tlsPortAsInteger();
    Long tlsPortAsLong();
    
    boolean tlsPortPresent();
    
    InstanceType instanceType();
    
    boolean instanceTypePresent();
    
    Template template();
    
    boolean templatePresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
