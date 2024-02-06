/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

/**
 * Describes the virtual functions configuration of an SR-IOV-enabled physical function NIC.
 */
public interface HostNicVirtualFunctionsConfiguration {
    boolean allNetworksAllowed();
    
    boolean allNetworksAllowedPresent();
    
    BigInteger maxNumberOfVirtualFunctions();
    Byte maxNumberOfVirtualFunctionsAsByte();
    Short maxNumberOfVirtualFunctionsAsShort();
    Integer maxNumberOfVirtualFunctionsAsInteger();
    Long maxNumberOfVirtualFunctionsAsLong();
    
    boolean maxNumberOfVirtualFunctionsPresent();
    
    BigInteger numberOfVirtualFunctions();
    Byte numberOfVirtualFunctionsAsByte();
    Short numberOfVirtualFunctionsAsShort();
    Integer numberOfVirtualFunctionsAsInteger();
    Long numberOfVirtualFunctionsAsLong();
    
    boolean numberOfVirtualFunctionsPresent();
    
}
