/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.GlusterMemoryPoolContainer;
import org.ovirt.engine.sdk4.types.GlusterMemoryPool;

public class GlusterMemoryPoolBuilder {
    private BigInteger allocCount;
    private BigInteger coldCount;
    private String comment;
    private String description;
    private BigInteger hotCount;
    private String href;
    private String id;
    private BigInteger maxAlloc;
    private BigInteger maxStdalloc;
    private String name;
    private BigInteger paddedSize;
    private BigInteger poolMisses;
    private String type;
    
    public GlusterMemoryPoolBuilder allocCount(int newAllocCount) {
        allocCount = BigInteger.valueOf((long) newAllocCount);
        return this;
    }
    
    public GlusterMemoryPoolBuilder allocCount(Integer newAllocCount) {
        if (newAllocCount == null) {
            allocCount = null;
        }
        else {
            allocCount = BigInteger.valueOf(newAllocCount.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder allocCount(long newAllocCount) {
        allocCount = BigInteger.valueOf(newAllocCount);
        return this;
    }
    
    public GlusterMemoryPoolBuilder allocCount(Long newAllocCount) {
        if (newAllocCount == null) {
            allocCount = null;
        }
        else {
            allocCount = BigInteger.valueOf(newAllocCount.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder allocCount(BigInteger newAllocCount) {
        allocCount = newAllocCount;
        return this;
    }
    
    
    public GlusterMemoryPoolBuilder coldCount(int newColdCount) {
        coldCount = BigInteger.valueOf((long) newColdCount);
        return this;
    }
    
    public GlusterMemoryPoolBuilder coldCount(Integer newColdCount) {
        if (newColdCount == null) {
            coldCount = null;
        }
        else {
            coldCount = BigInteger.valueOf(newColdCount.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder coldCount(long newColdCount) {
        coldCount = BigInteger.valueOf(newColdCount);
        return this;
    }
    
    public GlusterMemoryPoolBuilder coldCount(Long newColdCount) {
        if (newColdCount == null) {
            coldCount = null;
        }
        else {
            coldCount = BigInteger.valueOf(newColdCount.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder coldCount(BigInteger newColdCount) {
        coldCount = newColdCount;
        return this;
    }
    
    
    public GlusterMemoryPoolBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public GlusterMemoryPoolBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public GlusterMemoryPoolBuilder hotCount(int newHotCount) {
        hotCount = BigInteger.valueOf((long) newHotCount);
        return this;
    }
    
    public GlusterMemoryPoolBuilder hotCount(Integer newHotCount) {
        if (newHotCount == null) {
            hotCount = null;
        }
        else {
            hotCount = BigInteger.valueOf(newHotCount.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder hotCount(long newHotCount) {
        hotCount = BigInteger.valueOf(newHotCount);
        return this;
    }
    
    public GlusterMemoryPoolBuilder hotCount(Long newHotCount) {
        if (newHotCount == null) {
            hotCount = null;
        }
        else {
            hotCount = BigInteger.valueOf(newHotCount.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder hotCount(BigInteger newHotCount) {
        hotCount = newHotCount;
        return this;
    }
    
    
    public GlusterMemoryPoolBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public GlusterMemoryPoolBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public GlusterMemoryPoolBuilder maxAlloc(int newMaxAlloc) {
        maxAlloc = BigInteger.valueOf((long) newMaxAlloc);
        return this;
    }
    
    public GlusterMemoryPoolBuilder maxAlloc(Integer newMaxAlloc) {
        if (newMaxAlloc == null) {
            maxAlloc = null;
        }
        else {
            maxAlloc = BigInteger.valueOf(newMaxAlloc.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder maxAlloc(long newMaxAlloc) {
        maxAlloc = BigInteger.valueOf(newMaxAlloc);
        return this;
    }
    
    public GlusterMemoryPoolBuilder maxAlloc(Long newMaxAlloc) {
        if (newMaxAlloc == null) {
            maxAlloc = null;
        }
        else {
            maxAlloc = BigInteger.valueOf(newMaxAlloc.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder maxAlloc(BigInteger newMaxAlloc) {
        maxAlloc = newMaxAlloc;
        return this;
    }
    
    
    public GlusterMemoryPoolBuilder maxStdalloc(int newMaxStdalloc) {
        maxStdalloc = BigInteger.valueOf((long) newMaxStdalloc);
        return this;
    }
    
    public GlusterMemoryPoolBuilder maxStdalloc(Integer newMaxStdalloc) {
        if (newMaxStdalloc == null) {
            maxStdalloc = null;
        }
        else {
            maxStdalloc = BigInteger.valueOf(newMaxStdalloc.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder maxStdalloc(long newMaxStdalloc) {
        maxStdalloc = BigInteger.valueOf(newMaxStdalloc);
        return this;
    }
    
    public GlusterMemoryPoolBuilder maxStdalloc(Long newMaxStdalloc) {
        if (newMaxStdalloc == null) {
            maxStdalloc = null;
        }
        else {
            maxStdalloc = BigInteger.valueOf(newMaxStdalloc.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder maxStdalloc(BigInteger newMaxStdalloc) {
        maxStdalloc = newMaxStdalloc;
        return this;
    }
    
    
    public GlusterMemoryPoolBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public GlusterMemoryPoolBuilder paddedSize(int newPaddedSize) {
        paddedSize = BigInteger.valueOf((long) newPaddedSize);
        return this;
    }
    
    public GlusterMemoryPoolBuilder paddedSize(Integer newPaddedSize) {
        if (newPaddedSize == null) {
            paddedSize = null;
        }
        else {
            paddedSize = BigInteger.valueOf(newPaddedSize.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder paddedSize(long newPaddedSize) {
        paddedSize = BigInteger.valueOf(newPaddedSize);
        return this;
    }
    
    public GlusterMemoryPoolBuilder paddedSize(Long newPaddedSize) {
        if (newPaddedSize == null) {
            paddedSize = null;
        }
        else {
            paddedSize = BigInteger.valueOf(newPaddedSize.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder paddedSize(BigInteger newPaddedSize) {
        paddedSize = newPaddedSize;
        return this;
    }
    
    
    public GlusterMemoryPoolBuilder poolMisses(int newPoolMisses) {
        poolMisses = BigInteger.valueOf((long) newPoolMisses);
        return this;
    }
    
    public GlusterMemoryPoolBuilder poolMisses(Integer newPoolMisses) {
        if (newPoolMisses == null) {
            poolMisses = null;
        }
        else {
            poolMisses = BigInteger.valueOf(newPoolMisses.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder poolMisses(long newPoolMisses) {
        poolMisses = BigInteger.valueOf(newPoolMisses);
        return this;
    }
    
    public GlusterMemoryPoolBuilder poolMisses(Long newPoolMisses) {
        if (newPoolMisses == null) {
            poolMisses = null;
        }
        else {
            poolMisses = BigInteger.valueOf(newPoolMisses.longValue());
        }
        return this;
    }
    
    public GlusterMemoryPoolBuilder poolMisses(BigInteger newPoolMisses) {
        poolMisses = newPoolMisses;
        return this;
    }
    
    
    public GlusterMemoryPoolBuilder type(String newType) {
        type = newType;
        return this;
    }
    
    
    public GlusterMemoryPool build() {
        GlusterMemoryPoolContainer container = new GlusterMemoryPoolContainer();
        container.allocCount(allocCount);
        container.coldCount(coldCount);
        container.comment(comment);
        container.description(description);
        container.hotCount(hotCount);
        container.href(href);
        container.id(id);
        container.maxAlloc(maxAlloc);
        container.maxStdalloc(maxStdalloc);
        container.name(name);
        container.paddedSize(paddedSize);
        container.poolMisses(poolMisses);
        container.type(type);
        return container;
    }
}
