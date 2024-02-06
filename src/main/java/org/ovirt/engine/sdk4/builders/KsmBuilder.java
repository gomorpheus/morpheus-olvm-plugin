/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.internal.containers.KsmContainer;
import org.ovirt.engine.sdk4.types.Ksm;

public class KsmBuilder {
    private Boolean enabled;
    private Boolean mergeAcrossNodes;
    
    public KsmBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public KsmBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public KsmBuilder mergeAcrossNodes(boolean newMergeAcrossNodes) {
        mergeAcrossNodes = Boolean.valueOf(newMergeAcrossNodes);
        return this;
    }
    
    public KsmBuilder mergeAcrossNodes(Boolean newMergeAcrossNodes) {
        mergeAcrossNodes = newMergeAcrossNodes;
        return this;
    }
    
    
    public Ksm build() {
        KsmContainer container = new KsmContainer();
        container.enabled(enabled);
        container.mergeAcrossNodes(mergeAcrossNodes);
        return container;
    }
}
