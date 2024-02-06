/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.AuthorizedKeyContainer;
import org.ovirt.engine.sdk4.types.AuthorizedKey;
import org.ovirt.engine.sdk4.types.User;

public class AuthorizedKeyBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String key;
    private String name;
    private User user;
    
    public AuthorizedKeyBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public AuthorizedKeyBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public AuthorizedKeyBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public AuthorizedKeyBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public AuthorizedKeyBuilder key(String newKey) {
        key = newKey;
        return this;
    }
    
    
    public AuthorizedKeyBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public AuthorizedKeyBuilder user(User newUser) {
        user = newUser;
        return this;
    }
    
    public AuthorizedKeyBuilder user(UserBuilder newUser) {
        if (newUser == null) {
            user = null;
        }
        else {
            user = newUser.build();
        }
        return this;
    }
    
    
    public AuthorizedKey build() {
        AuthorizedKeyContainer container = new AuthorizedKeyContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.key(key);
        container.name(name);
        container.user(user);
        return container;
    }
}
