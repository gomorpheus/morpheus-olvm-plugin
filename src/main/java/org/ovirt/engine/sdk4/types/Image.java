/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

/**
 * Represents an image entity.
 */
public interface Image extends Identified {
    BigInteger size();
    Byte sizeAsByte();
    Short sizeAsShort();
    Integer sizeAsInteger();
    Long sizeAsLong();
    
    boolean sizePresent();
    
    ImageFileType type();
    
    boolean typePresent();
    
    StorageDomain storageDomain();
    
    boolean storageDomainPresent();
    
}
