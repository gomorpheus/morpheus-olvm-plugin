/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigDecimal;
import java.util.List;

/**
 * An affinity group represents a group of virtual machines with a defined relationship.
 */
public interface AffinityGroup extends Identified {
    boolean broken();
    
    boolean brokenPresent();
    
    boolean enforcing();
    
    boolean enforcingPresent();
    
    AffinityRule hostsRule();
    
    boolean hostsRulePresent();
    
    boolean positive();
    
    boolean positivePresent();
    
    BigDecimal priority();
    
    boolean priorityPresent();
    
    AffinityRule vmsRule();
    
    boolean vmsRulePresent();
    
    Cluster cluster();
    
    boolean clusterPresent();
    
    List<AffinityLabel> hostLabels();
    
    boolean hostLabelsPresent();
    
    List<Host> hosts();
    
    boolean hostsPresent();
    
    List<AffinityLabel> vmLabels();
    
    boolean vmLabelsPresent();
    
    List<Vm> vms();
    
    boolean vmsPresent();
    
}
