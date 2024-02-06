/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Domain;
import org.ovirt.engine.sdk4.types.Group;
import org.ovirt.engine.sdk4.types.User;

public class DomainContainer extends IdentifiedContainer implements Domain {
    private User user;
    private List<Group> groups;
    private List<User> users;
    
    public User user() {
        return user;
    }
    
    public void user(User newUser) {
        user = newUser;
    }
    
    public boolean userPresent() {
        return user != null;
    }
    
    public List<Group> groups() {
        return makeUnmodifiableList(groups);
    }
    
    public void groups(List<Group> newGroups) {
        groups = makeArrayList(newGroups);
    }
    
    public boolean groupsPresent() {
        return groups != null && !groups.isEmpty();
    }
    
    public List<User> users() {
        return makeUnmodifiableList(users);
    }
    
    public void users(List<User> newUsers) {
        users = makeArrayList(newUsers);
    }
    
    public boolean usersPresent() {
        return users != null && !users.isEmpty();
    }
    
}
