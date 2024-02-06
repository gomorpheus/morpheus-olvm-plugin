/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.HostNicVirtualFunctionsConfigurationContainer;
import org.ovirt.engine.sdk4.types.HostNicVirtualFunctionsConfiguration;

public class HostNicVirtualFunctionsConfigurationBuilder {
    private Boolean allNetworksAllowed;
    private BigInteger maxNumberOfVirtualFunctions;
    private BigInteger numberOfVirtualFunctions;
    
    public HostNicVirtualFunctionsConfigurationBuilder allNetworksAllowed(boolean newAllNetworksAllowed) {
        allNetworksAllowed = Boolean.valueOf(newAllNetworksAllowed);
        return this;
    }
    
    public HostNicVirtualFunctionsConfigurationBuilder allNetworksAllowed(Boolean newAllNetworksAllowed) {
        allNetworksAllowed = newAllNetworksAllowed;
        return this;
    }
    
    
    public HostNicVirtualFunctionsConfigurationBuilder maxNumberOfVirtualFunctions(int newMaxNumberOfVirtualFunctions) {
        maxNumberOfVirtualFunctions = BigInteger.valueOf((long) newMaxNumberOfVirtualFunctions);
        return this;
    }
    
    public HostNicVirtualFunctionsConfigurationBuilder maxNumberOfVirtualFunctions(Integer newMaxNumberOfVirtualFunctions) {
        if (newMaxNumberOfVirtualFunctions == null) {
            maxNumberOfVirtualFunctions = null;
        }
        else {
            maxNumberOfVirtualFunctions = BigInteger.valueOf(newMaxNumberOfVirtualFunctions.longValue());
        }
        return this;
    }
    
    public HostNicVirtualFunctionsConfigurationBuilder maxNumberOfVirtualFunctions(long newMaxNumberOfVirtualFunctions) {
        maxNumberOfVirtualFunctions = BigInteger.valueOf(newMaxNumberOfVirtualFunctions);
        return this;
    }
    
    public HostNicVirtualFunctionsConfigurationBuilder maxNumberOfVirtualFunctions(Long newMaxNumberOfVirtualFunctions) {
        if (newMaxNumberOfVirtualFunctions == null) {
            maxNumberOfVirtualFunctions = null;
        }
        else {
            maxNumberOfVirtualFunctions = BigInteger.valueOf(newMaxNumberOfVirtualFunctions.longValue());
        }
        return this;
    }
    
    public HostNicVirtualFunctionsConfigurationBuilder maxNumberOfVirtualFunctions(BigInteger newMaxNumberOfVirtualFunctions) {
        maxNumberOfVirtualFunctions = newMaxNumberOfVirtualFunctions;
        return this;
    }
    
    
    public HostNicVirtualFunctionsConfigurationBuilder numberOfVirtualFunctions(int newNumberOfVirtualFunctions) {
        numberOfVirtualFunctions = BigInteger.valueOf((long) newNumberOfVirtualFunctions);
        return this;
    }
    
    public HostNicVirtualFunctionsConfigurationBuilder numberOfVirtualFunctions(Integer newNumberOfVirtualFunctions) {
        if (newNumberOfVirtualFunctions == null) {
            numberOfVirtualFunctions = null;
        }
        else {
            numberOfVirtualFunctions = BigInteger.valueOf(newNumberOfVirtualFunctions.longValue());
        }
        return this;
    }
    
    public HostNicVirtualFunctionsConfigurationBuilder numberOfVirtualFunctions(long newNumberOfVirtualFunctions) {
        numberOfVirtualFunctions = BigInteger.valueOf(newNumberOfVirtualFunctions);
        return this;
    }
    
    public HostNicVirtualFunctionsConfigurationBuilder numberOfVirtualFunctions(Long newNumberOfVirtualFunctions) {
        if (newNumberOfVirtualFunctions == null) {
            numberOfVirtualFunctions = null;
        }
        else {
            numberOfVirtualFunctions = BigInteger.valueOf(newNumberOfVirtualFunctions.longValue());
        }
        return this;
    }
    
    public HostNicVirtualFunctionsConfigurationBuilder numberOfVirtualFunctions(BigInteger newNumberOfVirtualFunctions) {
        numberOfVirtualFunctions = newNumberOfVirtualFunctions;
        return this;
    }
    
    
    public HostNicVirtualFunctionsConfiguration build() {
        HostNicVirtualFunctionsConfigurationContainer container = new HostNicVirtualFunctionsConfigurationContainer();
        container.allNetworksAllowed(allNetworksAllowed);
        container.maxNumberOfVirtualFunctions(maxNumberOfVirtualFunctions);
        container.numberOfVirtualFunctions(numberOfVirtualFunctions);
        return container;
    }
}
