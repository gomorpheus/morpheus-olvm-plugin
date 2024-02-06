/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * A device wraps links to potential parents of a device.
 */
public interface Device extends Identified {
    InstanceType instanceType();
    
    boolean instanceTypePresent();
    
    Template template();
    
    boolean templatePresent();
    
    Vm vm();
    
    boolean vmPresent();
    
    List<Vm> vms();
    
    boolean vmsPresent();
    
}
