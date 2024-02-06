/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.SshPublicKeyContainer;
import org.ovirt.engine.sdk4.types.SshPublicKey;
import org.ovirt.engine.sdk4.types.User;

public class SshPublicKeyBuilder {
    private String comment;
    private String content;
    private String description;
    private String href;
    private String id;
    private String name;
    private User user;
    
    public SshPublicKeyBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public SshPublicKeyBuilder content(String newContent) {
        content = newContent;
        return this;
    }
    
    
    public SshPublicKeyBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public SshPublicKeyBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public SshPublicKeyBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public SshPublicKeyBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public SshPublicKeyBuilder user(User newUser) {
        user = newUser;
        return this;
    }
    
    public SshPublicKeyBuilder user(UserBuilder newUser) {
        if (newUser == null) {
            user = null;
        }
        else {
            user = newUser.build();
        }
        return this;
    }
    
    
    public SshPublicKey build() {
        SshPublicKeyContainer container = new SshPublicKeyContainer();
        container.comment(comment);
        container.content(content);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.user(user);
        return container;
    }
}
