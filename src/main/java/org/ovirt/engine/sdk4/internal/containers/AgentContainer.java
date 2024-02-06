/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.Agent;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Option;

public class AgentContainer extends IdentifiedContainer implements Agent {
    private String address;
    private Boolean concurrent;
    private Boolean encryptOptions;
    private List<Option> options;
    private BigInteger order;
    private String password;
    private BigInteger port;
    private String type;
    private String username;
    private Host host;
    
    public String address() {
        return address;
    }
    
    public void address(String newAddress) {
        address = newAddress;
    }
    
    public boolean addressPresent() {
        return address != null;
    }
    
    public boolean concurrent() {
        return concurrent;
    }
    
    public void concurrent(boolean newConcurrent) {
        concurrent = Boolean.valueOf(newConcurrent);
    }
    
    public void concurrent(Boolean newConcurrent) {
        concurrent = newConcurrent;
    }
    
    public boolean concurrentPresent() {
        return concurrent != null;
    }
    
    public boolean encryptOptions() {
        return encryptOptions;
    }
    
    public void encryptOptions(boolean newEncryptOptions) {
        encryptOptions = Boolean.valueOf(newEncryptOptions);
    }
    
    public void encryptOptions(Boolean newEncryptOptions) {
        encryptOptions = newEncryptOptions;
    }
    
    public boolean encryptOptionsPresent() {
        return encryptOptions != null;
    }
    
    public List<Option> options() {
        return makeUnmodifiableList(options);
    }
    
    public void options(List<Option> newOptions) {
        options = makeArrayList(newOptions);
    }
    
    public boolean optionsPresent() {
        return options != null && !options.isEmpty();
    }
    
    public BigInteger order() {
        return order;
    }
    
    public Byte orderAsByte() {
        return asByte("Agent", "order", order);
    }
    
    public Short orderAsShort() {
        return asShort("Agent", "order", order);
    }
    
    public Integer orderAsInteger() {
        return asInteger("Agent", "order", order);
    }
    
    public Long orderAsLong() {
        return asLong("Agent", "order", order);
    }
    
    public void order(BigInteger newOrder) {
        order = newOrder;
    }
    
    public boolean orderPresent() {
        return order != null;
    }
    
    public String password() {
        return password;
    }
    
    public void password(String newPassword) {
        password = newPassword;
    }
    
    public boolean passwordPresent() {
        return password != null;
    }
    
    public BigInteger port() {
        return port;
    }
    
    public Byte portAsByte() {
        return asByte("Agent", "port", port);
    }
    
    public Short portAsShort() {
        return asShort("Agent", "port", port);
    }
    
    public Integer portAsInteger() {
        return asInteger("Agent", "port", port);
    }
    
    public Long portAsLong() {
        return asLong("Agent", "port", port);
    }
    
    public void port(BigInteger newPort) {
        port = newPort;
    }
    
    public boolean portPresent() {
        return port != null;
    }
    
    public String type() {
        return type;
    }
    
    public void type(String newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public String username() {
        return username;
    }
    
    public void username(String newUsername) {
        username = newUsername;
    }
    
    public boolean usernamePresent() {
        return username != null;
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
}
