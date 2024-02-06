/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.MDevType;

public class MDevTypeContainer extends Container implements MDevType {
    private BigInteger availableInstances;
    private String description;
    private String humanReadableName;
    private String name;
    
    public BigInteger availableInstances() {
        return availableInstances;
    }
    
    public Byte availableInstancesAsByte() {
        return asByte("MDevType", "availableInstances", availableInstances);
    }
    
    public Short availableInstancesAsShort() {
        return asShort("MDevType", "availableInstances", availableInstances);
    }
    
    public Integer availableInstancesAsInteger() {
        return asInteger("MDevType", "availableInstances", availableInstances);
    }
    
    public Long availableInstancesAsLong() {
        return asLong("MDevType", "availableInstances", availableInstances);
    }
    
    public void availableInstances(BigInteger newAvailableInstances) {
        availableInstances = newAvailableInstances;
    }
    
    public boolean availableInstancesPresent() {
        return availableInstances != null;
    }
    
    public String description() {
        return description;
    }
    
    public void description(String newDescription) {
        description = newDescription;
    }
    
    public boolean descriptionPresent() {
        return description != null;
    }
    
    public String humanReadableName() {
        return humanReadableName;
    }
    
    public void humanReadableName(String newHumanReadableName) {
        humanReadableName = newHumanReadableName;
    }
    
    public boolean humanReadableNamePresent() {
        return humanReadableName != null;
    }
    
    public String name() {
        return name;
    }
    
    public void name(String newName) {
        name = newName;
    }
    
    public boolean namePresent() {
        return name != null;
    }
    
}
