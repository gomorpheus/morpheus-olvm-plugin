/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.MigrationPolicyContainer;
import org.ovirt.engine.sdk4.types.MigrationPolicy;

public class MigrationPolicyBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    
    public MigrationPolicyBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public MigrationPolicyBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public MigrationPolicyBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public MigrationPolicyBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public MigrationPolicyBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public MigrationPolicy build() {
        MigrationPolicyContainer container = new MigrationPolicyContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        return container;
    }
}
