/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Generic rule definition for affinity group. Each supported resource type (virtual machine, host) is controlled
 * by a separate rule. This allows expressing of rules like: no affinity between defined virtual machines, but hard
 * affinity between defined virtual machines and virtual hosts.
 */
public interface AffinityRule {
    boolean enabled();
    
    boolean enabledPresent();
    
    boolean enforcing();
    
    boolean enforcingPresent();
    
    boolean positive();
    
    boolean positivePresent();
    
}
