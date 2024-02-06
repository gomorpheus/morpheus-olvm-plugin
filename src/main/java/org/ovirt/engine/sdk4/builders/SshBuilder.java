/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.SshContainer;
import org.ovirt.engine.sdk4.types.Ssh;
import org.ovirt.engine.sdk4.types.SshAuthenticationMethod;
import org.ovirt.engine.sdk4.types.User;

public class SshBuilder {
    private SshAuthenticationMethod authenticationMethod;
    private String comment;
    private String description;
    private String fingerprint;
    private String href;
    private String id;
    private String name;
    private BigInteger port;
    private String publicKey;
    private User user;
    
    public SshBuilder authenticationMethod(SshAuthenticationMethod newAuthenticationMethod) {
        authenticationMethod = newAuthenticationMethod;
        return this;
    }
    
    
    public SshBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public SshBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public SshBuilder fingerprint(String newFingerprint) {
        fingerprint = newFingerprint;
        return this;
    }
    
    
    public SshBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public SshBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public SshBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public SshBuilder port(int newPort) {
        port = BigInteger.valueOf((long) newPort);
        return this;
    }
    
    public SshBuilder port(Integer newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public SshBuilder port(long newPort) {
        port = BigInteger.valueOf(newPort);
        return this;
    }
    
    public SshBuilder port(Long newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public SshBuilder port(BigInteger newPort) {
        port = newPort;
        return this;
    }
    
    
    public SshBuilder publicKey(String newPublicKey) {
        publicKey = newPublicKey;
        return this;
    }
    
    
    public SshBuilder user(User newUser) {
        user = newUser;
        return this;
    }
    
    public SshBuilder user(UserBuilder newUser) {
        if (newUser == null) {
            user = null;
        }
        else {
            user = newUser.build();
        }
        return this;
    }
    
    
    public Ssh build() {
        SshContainer container = new SshContainer();
        container.authenticationMethod(authenticationMethod);
        container.comment(comment);
        container.description(description);
        container.fingerprint(fingerprint);
        container.href(href);
        container.id(id);
        container.name(name);
        container.port(port);
        container.publicKey(publicKey);
        container.user(user);
        return container;
    }
}
