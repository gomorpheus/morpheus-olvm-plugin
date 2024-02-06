/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.HostNicVirtualFunctionsConfiguration;

public class HostNicVirtualFunctionsConfigurationContainer extends Container implements HostNicVirtualFunctionsConfiguration {
    private Boolean allNetworksAllowed;
    private BigInteger maxNumberOfVirtualFunctions;
    private BigInteger numberOfVirtualFunctions;
    
    public boolean allNetworksAllowed() {
        return allNetworksAllowed;
    }
    
    public void allNetworksAllowed(boolean newAllNetworksAllowed) {
        allNetworksAllowed = Boolean.valueOf(newAllNetworksAllowed);
    }
    
    public void allNetworksAllowed(Boolean newAllNetworksAllowed) {
        allNetworksAllowed = newAllNetworksAllowed;
    }
    
    public boolean allNetworksAllowedPresent() {
        return allNetworksAllowed != null;
    }
    
    public BigInteger maxNumberOfVirtualFunctions() {
        return maxNumberOfVirtualFunctions;
    }
    
    public Byte maxNumberOfVirtualFunctionsAsByte() {
        return asByte("HostNicVirtualFunctionsConfiguration", "maxNumberOfVirtualFunctions", maxNumberOfVirtualFunctions);
    }
    
    public Short maxNumberOfVirtualFunctionsAsShort() {
        return asShort("HostNicVirtualFunctionsConfiguration", "maxNumberOfVirtualFunctions", maxNumberOfVirtualFunctions);
    }
    
    public Integer maxNumberOfVirtualFunctionsAsInteger() {
        return asInteger("HostNicVirtualFunctionsConfiguration", "maxNumberOfVirtualFunctions", maxNumberOfVirtualFunctions);
    }
    
    public Long maxNumberOfVirtualFunctionsAsLong() {
        return asLong("HostNicVirtualFunctionsConfiguration", "maxNumberOfVirtualFunctions", maxNumberOfVirtualFunctions);
    }
    
    public void maxNumberOfVirtualFunctions(BigInteger newMaxNumberOfVirtualFunctions) {
        maxNumberOfVirtualFunctions = newMaxNumberOfVirtualFunctions;
    }
    
    public boolean maxNumberOfVirtualFunctionsPresent() {
        return maxNumberOfVirtualFunctions != null;
    }
    
    public BigInteger numberOfVirtualFunctions() {
        return numberOfVirtualFunctions;
    }
    
    public Byte numberOfVirtualFunctionsAsByte() {
        return asByte("HostNicVirtualFunctionsConfiguration", "numberOfVirtualFunctions", numberOfVirtualFunctions);
    }
    
    public Short numberOfVirtualFunctionsAsShort() {
        return asShort("HostNicVirtualFunctionsConfiguration", "numberOfVirtualFunctions", numberOfVirtualFunctions);
    }
    
    public Integer numberOfVirtualFunctionsAsInteger() {
        return asInteger("HostNicVirtualFunctionsConfiguration", "numberOfVirtualFunctions", numberOfVirtualFunctions);
    }
    
    public Long numberOfVirtualFunctionsAsLong() {
        return asLong("HostNicVirtualFunctionsConfiguration", "numberOfVirtualFunctions", numberOfVirtualFunctions);
    }
    
    public void numberOfVirtualFunctions(BigInteger newNumberOfVirtualFunctions) {
        numberOfVirtualFunctions = newNumberOfVirtualFunctions;
    }
    
    public boolean numberOfVirtualFunctionsPresent() {
        return numberOfVirtualFunctions != null;
    }
    
}
