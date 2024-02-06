/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.FileContainer;
import org.ovirt.engine.sdk4.types.File;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class FileBuilder {
    private String comment;
    private String content;
    private String description;
    private String href;
    private String id;
    private String name;
    private StorageDomain storageDomain;
    private String type;
    
    public FileBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public FileBuilder content(String newContent) {
        content = newContent;
        return this;
    }
    
    
    public FileBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public FileBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public FileBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public FileBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public FileBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public FileBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public FileBuilder type(String newType) {
        type = newType;
        return this;
    }
    
    
    public File build() {
        FileContainer container = new FileContainer();
        container.comment(comment);
        container.content(content);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.storageDomain(storageDomain);
        container.type(type);
        return container;
    }
}
