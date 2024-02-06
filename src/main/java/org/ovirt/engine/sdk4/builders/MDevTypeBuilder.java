/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.MDevTypeContainer;
import org.ovirt.engine.sdk4.types.MDevType;

public class MDevTypeBuilder {
    private BigInteger availableInstances;
    private String description;
    private String humanReadableName;
    private String name;
    
    public MDevTypeBuilder availableInstances(int newAvailableInstances) {
        availableInstances = BigInteger.valueOf((long) newAvailableInstances);
        return this;
    }
    
    public MDevTypeBuilder availableInstances(Integer newAvailableInstances) {
        if (newAvailableInstances == null) {
            availableInstances = null;
        }
        else {
            availableInstances = BigInteger.valueOf(newAvailableInstances.longValue());
        }
        return this;
    }
    
    public MDevTypeBuilder availableInstances(long newAvailableInstances) {
        availableInstances = BigInteger.valueOf(newAvailableInstances);
        return this;
    }
    
    public MDevTypeBuilder availableInstances(Long newAvailableInstances) {
        if (newAvailableInstances == null) {
            availableInstances = null;
        }
        else {
            availableInstances = BigInteger.valueOf(newAvailableInstances.longValue());
        }
        return this;
    }
    
    public MDevTypeBuilder availableInstances(BigInteger newAvailableInstances) {
        availableInstances = newAvailableInstances;
        return this;
    }
    
    
    public MDevTypeBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public MDevTypeBuilder humanReadableName(String newHumanReadableName) {
        humanReadableName = newHumanReadableName;
        return this;
    }
    
    
    public MDevTypeBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public MDevType build() {
        MDevTypeContainer container = new MDevTypeContainer();
        container.availableInstances(availableInstances);
        container.description(description);
        container.humanReadableName(humanReadableName);
        container.name(name);
        return container;
    }
}
