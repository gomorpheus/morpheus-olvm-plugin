/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.UserOptionContainer;
import org.ovirt.engine.sdk4.types.User;
import org.ovirt.engine.sdk4.types.UserOption;

public class UserOptionBuilder {
    private String comment;
    private String content;
    private String description;
    private String href;
    private String id;
    private String name;
    private User user;
    
    public UserOptionBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public UserOptionBuilder content(String newContent) {
        content = newContent;
        return this;
    }
    
    
    public UserOptionBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public UserOptionBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public UserOptionBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public UserOptionBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public UserOptionBuilder user(User newUser) {
        user = newUser;
        return this;
    }
    
    public UserOptionBuilder user(UserBuilder newUser) {
        if (newUser == null) {
            user = null;
        }
        else {
            user = newUser.build();
        }
        return this;
    }
    
    
    public UserOption build() {
        UserOptionContainer container = new UserOptionContainer();
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
