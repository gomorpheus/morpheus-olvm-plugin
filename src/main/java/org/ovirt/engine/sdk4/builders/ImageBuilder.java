/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.ImageContainer;
import org.ovirt.engine.sdk4.types.Image;
import org.ovirt.engine.sdk4.types.ImageFileType;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class ImageBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private BigInteger size;
    private StorageDomain storageDomain;
    private ImageFileType type;
    
    public ImageBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ImageBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ImageBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ImageBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ImageBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ImageBuilder size(int newSize) {
        size = BigInteger.valueOf((long) newSize);
        return this;
    }
    
    public ImageBuilder size(Integer newSize) {
        if (newSize == null) {
            size = null;
        }
        else {
            size = BigInteger.valueOf(newSize.longValue());
        }
        return this;
    }
    
    public ImageBuilder size(long newSize) {
        size = BigInteger.valueOf(newSize);
        return this;
    }
    
    public ImageBuilder size(Long newSize) {
        if (newSize == null) {
            size = null;
        }
        else {
            size = BigInteger.valueOf(newSize.longValue());
        }
        return this;
    }
    
    public ImageBuilder size(BigInteger newSize) {
        size = newSize;
        return this;
    }
    
    
    public ImageBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public ImageBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public ImageBuilder type(ImageFileType newType) {
        type = newType;
        return this;
    }
    
    
    public Image build() {
        ImageContainer container = new ImageContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.size(size);
        container.storageDomain(storageDomain);
        container.type(type);
        return container;
    }
}
