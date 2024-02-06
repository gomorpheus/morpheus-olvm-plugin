/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.DomainContainer;
import org.ovirt.engine.sdk4.types.Domain;
import org.ovirt.engine.sdk4.types.Group;
import org.ovirt.engine.sdk4.types.User;

public class DomainBuilder {
    private String comment;
    private String description;
    private List<Group> groups;
    private String href;
    private String id;
    private String name;
    private User user;
    private List<User> users;
    
    public DomainBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public DomainBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public DomainBuilder groups(List<Group> newGroups) {
        if (newGroups != null) {
            if (groups == null) {
                groups = new ArrayList<>(newGroups);
            }
            else {
                groups.addAll(newGroups);
            }
        }
        return this;
    }
    
    public DomainBuilder groups(Group... newGroups) {
        if (newGroups != null) {
            if (groups == null) {
                groups = new ArrayList<>(newGroups.length);
            }
            Collections.addAll(groups, newGroups);
        }
        return this;
    }
    
    public DomainBuilder groups(GroupBuilder... newGroups) {
        if (newGroups != null) {
            if (groups == null) {
                groups = new ArrayList<>(newGroups.length);
            }
            for (GroupBuilder builder : newGroups) {
                groups.add(builder.build());
            }
        }
        return this;
    }
    
    
    public DomainBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public DomainBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public DomainBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public DomainBuilder user(User newUser) {
        user = newUser;
        return this;
    }
    
    public DomainBuilder user(UserBuilder newUser) {
        if (newUser == null) {
            user = null;
        }
        else {
            user = newUser.build();
        }
        return this;
    }
    
    
    public DomainBuilder users(List<User> newUsers) {
        if (newUsers != null) {
            if (users == null) {
                users = new ArrayList<>(newUsers);
            }
            else {
                users.addAll(newUsers);
            }
        }
        return this;
    }
    
    public DomainBuilder users(User... newUsers) {
        if (newUsers != null) {
            if (users == null) {
                users = new ArrayList<>(newUsers.length);
            }
            Collections.addAll(users, newUsers);
        }
        return this;
    }
    
    public DomainBuilder users(UserBuilder... newUsers) {
        if (newUsers != null) {
            if (users == null) {
                users = new ArrayList<>(newUsers.length);
            }
            for (UserBuilder builder : newUsers) {
                users.add(builder.build());
            }
        }
        return this;
    }
    
    
    public Domain build() {
        DomainContainer container = new DomainContainer();
        container.comment(comment);
        container.description(description);
        container.groups(groups);
        container.href(href);
        container.id(id);
        container.name(name);
        container.user(user);
        container.users(users);
        return container;
    }
}
