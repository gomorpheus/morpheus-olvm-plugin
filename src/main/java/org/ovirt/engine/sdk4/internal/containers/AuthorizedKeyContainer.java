/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.AuthorizedKey;
import org.ovirt.engine.sdk4.types.User;

public class AuthorizedKeyContainer extends IdentifiedContainer implements AuthorizedKey {
    private String key;
    private User user;
    
    public String key() {
        return key;
    }
    
    public void key(String newKey) {
        key = newKey;
    }
    
    public boolean keyPresent() {
        return key != null;
    }
    
    public User user() {
        return user;
    }
    
    public void user(User newUser) {
        user = newUser;
    }
    
    public boolean userPresent() {
        return user != null;
    }
    
}
