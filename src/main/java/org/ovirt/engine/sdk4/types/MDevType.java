/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

/**
 * Mediated device is a software device that allows to divide physical device's resources.
 * 
 * See https://libvirt.org/drvnodedev.html#MDEV[Libvirt-MDEV] for further details.
 */
public interface MDevType {
    BigInteger availableInstances();
    Byte availableInstancesAsByte();
    Short availableInstancesAsShort();
    Integer availableInstancesAsInteger();
    Long availableInstancesAsLong();
    
    boolean availableInstancesPresent();
    
    String description();
    
    boolean descriptionPresent();
    
    String humanReadableName();
    
    boolean humanReadableNamePresent();
    
    String name();
    
    boolean namePresent();
    
}
