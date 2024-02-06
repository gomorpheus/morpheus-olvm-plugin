/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.IdentifiedContainer;
import org.ovirt.engine.sdk4.types.Identified;

public class IdentifiedBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    
    public IdentifiedBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public IdentifiedBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public IdentifiedBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public IdentifiedBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public IdentifiedBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public Identified build() {
        IdentifiedContainer container = new IdentifiedContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        return container;
    }
}
