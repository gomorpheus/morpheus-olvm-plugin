/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

public interface VmPlacementPolicy {
    VmAffinity affinity();
    
    boolean affinityPresent();
    
    List<Host> hosts();
    
    boolean hostsPresent();
    
}
