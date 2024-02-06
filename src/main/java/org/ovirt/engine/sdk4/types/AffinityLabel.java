/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * The affinity label can influence virtual machine scheduling.
 * It is most frequently used to create a sub-cluster from the available hosts.
 */
public interface AffinityLabel extends Identified {
    boolean hasImplicitAffinityGroup();
    
    boolean hasImplicitAffinityGroupPresent();
    
    boolean readOnly();
    
    boolean readOnlyPresent();
    
    List<Host> hosts();
    
    boolean hostsPresent();
    
    List<Vm> vms();
    
    boolean vmsPresent();
    
}
