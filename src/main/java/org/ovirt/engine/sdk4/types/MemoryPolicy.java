/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

/**
 * Logical grouping of memory-related properties of virtual machine-like entities.
 */
public interface MemoryPolicy {
    boolean ballooning();
    
    boolean ballooningPresent();
    
    BigInteger guaranteed();
    Byte guaranteedAsByte();
    Short guaranteedAsShort();
    Integer guaranteedAsInteger();
    Long guaranteedAsLong();
    
    boolean guaranteedPresent();
    
    BigInteger max();
    Byte maxAsByte();
    Short maxAsShort();
    Integer maxAsInteger();
    Long maxAsLong();
    
    boolean maxPresent();
    
    MemoryOverCommit overCommit();
    
    boolean overCommitPresent();
    
    TransparentHugePages transparentHugePages();
    
    boolean transparentHugePagesPresent();
    
}
