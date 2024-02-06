/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.GlusterMemoryPool;

public class GlusterMemoryPoolContainer extends IdentifiedContainer implements GlusterMemoryPool {
    private BigInteger allocCount;
    private BigInteger coldCount;
    private BigInteger hotCount;
    private BigInteger maxAlloc;
    private BigInteger maxStdalloc;
    private BigInteger paddedSize;
    private BigInteger poolMisses;
    private String type;
    
    public BigInteger allocCount() {
        return allocCount;
    }
    
    public Byte allocCountAsByte() {
        return asByte("GlusterMemoryPool", "allocCount", allocCount);
    }
    
    public Short allocCountAsShort() {
        return asShort("GlusterMemoryPool", "allocCount", allocCount);
    }
    
    public Integer allocCountAsInteger() {
        return asInteger("GlusterMemoryPool", "allocCount", allocCount);
    }
    
    public Long allocCountAsLong() {
        return asLong("GlusterMemoryPool", "allocCount", allocCount);
    }
    
    public void allocCount(BigInteger newAllocCount) {
        allocCount = newAllocCount;
    }
    
    public boolean allocCountPresent() {
        return allocCount != null;
    }
    
    public BigInteger coldCount() {
        return coldCount;
    }
    
    public Byte coldCountAsByte() {
        return asByte("GlusterMemoryPool", "coldCount", coldCount);
    }
    
    public Short coldCountAsShort() {
        return asShort("GlusterMemoryPool", "coldCount", coldCount);
    }
    
    public Integer coldCountAsInteger() {
        return asInteger("GlusterMemoryPool", "coldCount", coldCount);
    }
    
    public Long coldCountAsLong() {
        return asLong("GlusterMemoryPool", "coldCount", coldCount);
    }
    
    public void coldCount(BigInteger newColdCount) {
        coldCount = newColdCount;
    }
    
    public boolean coldCountPresent() {
        return coldCount != null;
    }
    
    public BigInteger hotCount() {
        return hotCount;
    }
    
    public Byte hotCountAsByte() {
        return asByte("GlusterMemoryPool", "hotCount", hotCount);
    }
    
    public Short hotCountAsShort() {
        return asShort("GlusterMemoryPool", "hotCount", hotCount);
    }
    
    public Integer hotCountAsInteger() {
        return asInteger("GlusterMemoryPool", "hotCount", hotCount);
    }
    
    public Long hotCountAsLong() {
        return asLong("GlusterMemoryPool", "hotCount", hotCount);
    }
    
    public void hotCount(BigInteger newHotCount) {
        hotCount = newHotCount;
    }
    
    public boolean hotCountPresent() {
        return hotCount != null;
    }
    
    public BigInteger maxAlloc() {
        return maxAlloc;
    }
    
    public Byte maxAllocAsByte() {
        return asByte("GlusterMemoryPool", "maxAlloc", maxAlloc);
    }
    
    public Short maxAllocAsShort() {
        return asShort("GlusterMemoryPool", "maxAlloc", maxAlloc);
    }
    
    public Integer maxAllocAsInteger() {
        return asInteger("GlusterMemoryPool", "maxAlloc", maxAlloc);
    }
    
    public Long maxAllocAsLong() {
        return asLong("GlusterMemoryPool", "maxAlloc", maxAlloc);
    }
    
    public void maxAlloc(BigInteger newMaxAlloc) {
        maxAlloc = newMaxAlloc;
    }
    
    public boolean maxAllocPresent() {
        return maxAlloc != null;
    }
    
    public BigInteger maxStdalloc() {
        return maxStdalloc;
    }
    
    public Byte maxStdallocAsByte() {
        return asByte("GlusterMemoryPool", "maxStdalloc", maxStdalloc);
    }
    
    public Short maxStdallocAsShort() {
        return asShort("GlusterMemoryPool", "maxStdalloc", maxStdalloc);
    }
    
    public Integer maxStdallocAsInteger() {
        return asInteger("GlusterMemoryPool", "maxStdalloc", maxStdalloc);
    }
    
    public Long maxStdallocAsLong() {
        return asLong("GlusterMemoryPool", "maxStdalloc", maxStdalloc);
    }
    
    public void maxStdalloc(BigInteger newMaxStdalloc) {
        maxStdalloc = newMaxStdalloc;
    }
    
    public boolean maxStdallocPresent() {
        return maxStdalloc != null;
    }
    
    public BigInteger paddedSize() {
        return paddedSize;
    }
    
    public Byte paddedSizeAsByte() {
        return asByte("GlusterMemoryPool", "paddedSize", paddedSize);
    }
    
    public Short paddedSizeAsShort() {
        return asShort("GlusterMemoryPool", "paddedSize", paddedSize);
    }
    
    public Integer paddedSizeAsInteger() {
        return asInteger("GlusterMemoryPool", "paddedSize", paddedSize);
    }
    
    public Long paddedSizeAsLong() {
        return asLong("GlusterMemoryPool", "paddedSize", paddedSize);
    }
    
    public void paddedSize(BigInteger newPaddedSize) {
        paddedSize = newPaddedSize;
    }
    
    public boolean paddedSizePresent() {
        return paddedSize != null;
    }
    
    public BigInteger poolMisses() {
        return poolMisses;
    }
    
    public Byte poolMissesAsByte() {
        return asByte("GlusterMemoryPool", "poolMisses", poolMisses);
    }
    
    public Short poolMissesAsShort() {
        return asShort("GlusterMemoryPool", "poolMisses", poolMisses);
    }
    
    public Integer poolMissesAsInteger() {
        return asInteger("GlusterMemoryPool", "poolMisses", poolMisses);
    }
    
    public Long poolMissesAsLong() {
        return asLong("GlusterMemoryPool", "poolMisses", poolMisses);
    }
    
    public void poolMisses(BigInteger newPoolMisses) {
        poolMisses = newPoolMisses;
    }
    
    public boolean poolMissesPresent() {
        return poolMisses != null;
    }
    
    public String type() {
        return type;
    }
    
    public void type(String newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
}
