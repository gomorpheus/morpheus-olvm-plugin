/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.BookmarkContainer;
import org.ovirt.engine.sdk4.types.Bookmark;

public class BookmarkBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private String value;
    
    public BookmarkBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public BookmarkBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public BookmarkBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public BookmarkBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public BookmarkBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public BookmarkBuilder value(String newValue) {
        value = newValue;
        return this;
    }
    
    
    public Bookmark build() {
        BookmarkContainer container = new BookmarkContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.value(value);
        return container;
    }
}
