/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Image;
import org.ovirt.engine.sdk4.types.ImageFileType;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class ImageContainer extends IdentifiedContainer implements Image {
    private BigInteger size;
    private ImageFileType type;
    private StorageDomain storageDomain;
    
    public BigInteger size() {
        return size;
    }
    
    public Byte sizeAsByte() {
        return asByte("Image", "size", size);
    }
    
    public Short sizeAsShort() {
        return asShort("Image", "size", size);
    }
    
    public Integer sizeAsInteger() {
        return asInteger("Image", "size", size);
    }
    
    public Long sizeAsLong() {
        return asLong("Image", "size", size);
    }
    
    public void size(BigInteger newSize) {
        size = newSize;
    }
    
    public boolean sizePresent() {
        return size != null;
    }
    
    public ImageFileType type() {
        return type;
    }
    
    public void type(ImageFileType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public StorageDomain storageDomain() {
        return storageDomain;
    }
    
    public void storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
    }
    
    public boolean storageDomainPresent() {
        return storageDomain != null;
    }
    
}
