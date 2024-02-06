/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Ssh;
import org.ovirt.engine.sdk4.types.SshAuthenticationMethod;
import org.ovirt.engine.sdk4.types.User;

public class SshContainer extends IdentifiedContainer implements Ssh {
    private SshAuthenticationMethod authenticationMethod;
    private String fingerprint;
    private BigInteger port;
    private String publicKey;
    private User user;
    
    public SshAuthenticationMethod authenticationMethod() {
        return authenticationMethod;
    }
    
    public void authenticationMethod(SshAuthenticationMethod newAuthenticationMethod) {
        authenticationMethod = newAuthenticationMethod;
    }
    
    public boolean authenticationMethodPresent() {
        return authenticationMethod != null;
    }
    
    public String fingerprint() {
        return fingerprint;
    }
    
    public void fingerprint(String newFingerprint) {
        fingerprint = newFingerprint;
    }
    
    public boolean fingerprintPresent() {
        return fingerprint != null;
    }
    
    public BigInteger port() {
        return port;
    }
    
    public Byte portAsByte() {
        return asByte("Ssh", "port", port);
    }
    
    public Short portAsShort() {
        return asShort("Ssh", "port", port);
    }
    
    public Integer portAsInteger() {
        return asInteger("Ssh", "port", port);
    }
    
    public Long portAsLong() {
        return asLong("Ssh", "port", port);
    }
    
    public void port(BigInteger newPort) {
        port = newPort;
    }
    
    public boolean portPresent() {
        return port != null;
    }
    
    public String publicKey() {
        return publicKey;
    }
    
    public void publicKey(String newPublicKey) {
        publicKey = newPublicKey;
    }
    
    public boolean publicKeyPresent() {
        return publicKey != null;
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
