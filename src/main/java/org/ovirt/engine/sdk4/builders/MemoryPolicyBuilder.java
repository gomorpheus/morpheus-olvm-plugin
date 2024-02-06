/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.MemoryPolicyContainer;
import org.ovirt.engine.sdk4.types.MemoryOverCommit;
import org.ovirt.engine.sdk4.types.MemoryPolicy;
import org.ovirt.engine.sdk4.types.TransparentHugePages;

public class MemoryPolicyBuilder {
    private Boolean ballooning;
    private BigInteger guaranteed;
    private BigInteger max;
    private MemoryOverCommit overCommit;
    private TransparentHugePages transparentHugePages;
    
    public MemoryPolicyBuilder ballooning(boolean newBallooning) {
        ballooning = Boolean.valueOf(newBallooning);
        return this;
    }
    
    public MemoryPolicyBuilder ballooning(Boolean newBallooning) {
        ballooning = newBallooning;
        return this;
    }
    
    
    public MemoryPolicyBuilder guaranteed(int newGuaranteed) {
        guaranteed = BigInteger.valueOf((long) newGuaranteed);
        return this;
    }
    
    public MemoryPolicyBuilder guaranteed(Integer newGuaranteed) {
        if (newGuaranteed == null) {
            guaranteed = null;
        }
        else {
            guaranteed = BigInteger.valueOf(newGuaranteed.longValue());
        }
        return this;
    }
    
    public MemoryPolicyBuilder guaranteed(long newGuaranteed) {
        guaranteed = BigInteger.valueOf(newGuaranteed);
        return this;
    }
    
    public MemoryPolicyBuilder guaranteed(Long newGuaranteed) {
        if (newGuaranteed == null) {
            guaranteed = null;
        }
        else {
            guaranteed = BigInteger.valueOf(newGuaranteed.longValue());
        }
        return this;
    }
    
    public MemoryPolicyBuilder guaranteed(BigInteger newGuaranteed) {
        guaranteed = newGuaranteed;
        return this;
    }
    
    
    public MemoryPolicyBuilder max(int newMax) {
        max = BigInteger.valueOf((long) newMax);
        return this;
    }
    
    public MemoryPolicyBuilder max(Integer newMax) {
        if (newMax == null) {
            max = null;
        }
        else {
            max = BigInteger.valueOf(newMax.longValue());
        }
        return this;
    }
    
    public MemoryPolicyBuilder max(long newMax) {
        max = BigInteger.valueOf(newMax);
        return this;
    }
    
    public MemoryPolicyBuilder max(Long newMax) {
        if (newMax == null) {
            max = null;
        }
        else {
            max = BigInteger.valueOf(newMax.longValue());
        }
        return this;
    }
    
    public MemoryPolicyBuilder max(BigInteger newMax) {
        max = newMax;
        return this;
    }
    
    
    public MemoryPolicyBuilder overCommit(MemoryOverCommit newOverCommit) {
        overCommit = newOverCommit;
        return this;
    }
    
    public MemoryPolicyBuilder overCommit(MemoryOverCommitBuilder newOverCommit) {
        if (newOverCommit == null) {
            overCommit = null;
        }
        else {
            overCommit = newOverCommit.build();
        }
        return this;
    }
    
    
    public MemoryPolicyBuilder transparentHugePages(TransparentHugePages newTransparentHugePages) {
        transparentHugePages = newTransparentHugePages;
        return this;
    }
    
    public MemoryPolicyBuilder transparentHugePages(TransparentHugePagesBuilder newTransparentHugePages) {
        if (newTransparentHugePages == null) {
            transparentHugePages = null;
        }
        else {
            transparentHugePages = newTransparentHugePages.build();
        }
        return this;
    }
    
    
    public MemoryPolicy build() {
        MemoryPolicyContainer container = new MemoryPolicyContainer();
        container.ballooning(ballooning);
        container.guaranteed(guaranteed);
        container.max(max);
        container.overCommit(overCommit);
        container.transparentHugePages(transparentHugePages);
        return container;
    }
}
