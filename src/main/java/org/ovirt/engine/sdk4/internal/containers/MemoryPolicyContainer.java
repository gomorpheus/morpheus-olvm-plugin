/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.MemoryOverCommit;
import org.ovirt.engine.sdk4.types.MemoryPolicy;
import org.ovirt.engine.sdk4.types.TransparentHugePages;

public class MemoryPolicyContainer extends Container implements MemoryPolicy {
    private Boolean ballooning;
    private BigInteger guaranteed;
    private BigInteger max;
    private MemoryOverCommit overCommit;
    private TransparentHugePages transparentHugePages;
    
    public boolean ballooning() {
        return ballooning;
    }
    
    public void ballooning(boolean newBallooning) {
        ballooning = Boolean.valueOf(newBallooning);
    }
    
    public void ballooning(Boolean newBallooning) {
        ballooning = newBallooning;
    }
    
    public boolean ballooningPresent() {
        return ballooning != null;
    }
    
    public BigInteger guaranteed() {
        return guaranteed;
    }
    
    public Byte guaranteedAsByte() {
        return asByte("MemoryPolicy", "guaranteed", guaranteed);
    }
    
    public Short guaranteedAsShort() {
        return asShort("MemoryPolicy", "guaranteed", guaranteed);
    }
    
    public Integer guaranteedAsInteger() {
        return asInteger("MemoryPolicy", "guaranteed", guaranteed);
    }
    
    public Long guaranteedAsLong() {
        return asLong("MemoryPolicy", "guaranteed", guaranteed);
    }
    
    public void guaranteed(BigInteger newGuaranteed) {
        guaranteed = newGuaranteed;
    }
    
    public boolean guaranteedPresent() {
        return guaranteed != null;
    }
    
    public BigInteger max() {
        return max;
    }
    
    public Byte maxAsByte() {
        return asByte("MemoryPolicy", "max", max);
    }
    
    public Short maxAsShort() {
        return asShort("MemoryPolicy", "max", max);
    }
    
    public Integer maxAsInteger() {
        return asInteger("MemoryPolicy", "max", max);
    }
    
    public Long maxAsLong() {
        return asLong("MemoryPolicy", "max", max);
    }
    
    public void max(BigInteger newMax) {
        max = newMax;
    }
    
    public boolean maxPresent() {
        return max != null;
    }
    
    public MemoryOverCommit overCommit() {
        return overCommit;
    }
    
    public void overCommit(MemoryOverCommit newOverCommit) {
        overCommit = newOverCommit;
    }
    
    public boolean overCommitPresent() {
        return overCommit != null;
    }
    
    public TransparentHugePages transparentHugePages() {
        return transparentHugePages;
    }
    
    public void transparentHugePages(TransparentHugePages newTransparentHugePages) {
        transparentHugePages = newTransparentHugePages;
    }
    
    public boolean transparentHugePagesPresent() {
        return transparentHugePages != null;
    }
    
}
