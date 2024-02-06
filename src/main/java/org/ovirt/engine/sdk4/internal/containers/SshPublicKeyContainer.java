/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.SshPublicKey;
import org.ovirt.engine.sdk4.types.User;

public class SshPublicKeyContainer extends IdentifiedContainer implements SshPublicKey {
    private String content;
    private User user;
    
    public String content() {
        return content;
    }
    
    public void content(String newContent) {
        content = newContent;
    }
    
    public boolean contentPresent() {
        return content != null;
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
