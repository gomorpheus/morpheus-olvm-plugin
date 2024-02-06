/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.IconContainer;
import org.ovirt.engine.sdk4.types.Icon;

public class IconBuilder {
    private String comment;
    private String data;
    private String description;
    private String href;
    private String id;
    private String mediaType;
    private String name;
    
    public IconBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public IconBuilder data(String newData) {
        data = newData;
        return this;
    }
    
    
    public IconBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public IconBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public IconBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public IconBuilder mediaType(String newMediaType) {
        mediaType = newMediaType;
        return this;
    }
    
    
    public IconBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public Icon build() {
        IconContainer container = new IconContainer();
        container.comment(comment);
        container.data(data);
        container.description(description);
        container.href(href);
        container.id(id);
        container.mediaType(mediaType);
        container.name(name);
        return container;
    }
}
