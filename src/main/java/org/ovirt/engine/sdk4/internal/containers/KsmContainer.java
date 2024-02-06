/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.types.Ksm;

public class KsmContainer extends Container implements Ksm {
    private Boolean enabled;
    private Boolean mergeAcrossNodes;
    
    public boolean enabled() {
        return enabled;
    }
    
    public void enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
    }
    
    public void enabled(Boolean newEnabled) {
        enabled = newEnabled;
    }
    
    public boolean enabledPresent() {
        return enabled != null;
    }
    
    public boolean mergeAcrossNodes() {
        return mergeAcrossNodes;
    }
    
    public void mergeAcrossNodes(boolean newMergeAcrossNodes) {
        mergeAcrossNodes = Boolean.valueOf(newMergeAcrossNodes);
    }
    
    public void mergeAcrossNodes(Boolean newMergeAcrossNodes) {
        mergeAcrossNodes = newMergeAcrossNodes;
    }
    
    public boolean mergeAcrossNodesPresent() {
        return mergeAcrossNodes != null;
    }
    
}
