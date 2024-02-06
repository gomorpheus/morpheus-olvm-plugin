/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.AgentConfiguration;
import org.ovirt.engine.sdk4.types.MessageBrokerType;

public class AgentConfigurationContainer extends Container implements AgentConfiguration {
    private String address;
    private MessageBrokerType brokerType;
    private String networkMappings;
    private String password;
    private BigInteger port;
    private String username;
    
    public String address() {
        return address;
    }
    
    public void address(String newAddress) {
        address = newAddress;
    }
    
    public boolean addressPresent() {
        return address != null;
    }
    
    public MessageBrokerType brokerType() {
        return brokerType;
    }
    
    public void brokerType(MessageBrokerType newBrokerType) {
        brokerType = newBrokerType;
    }
    
    public boolean brokerTypePresent() {
        return brokerType != null;
    }
    
    public String networkMappings() {
        return networkMappings;
    }
    
    public void networkMappings(String newNetworkMappings) {
        networkMappings = newNetworkMappings;
    }
    
    public boolean networkMappingsPresent() {
        return networkMappings != null;
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
        return asByte("AgentConfiguration", "port", port);
    }
    
    public Short portAsShort() {
        return asShort("AgentConfiguration", "port", port);
    }
    
    public Integer portAsInteger() {
        return asInteger("AgentConfiguration", "port", port);
    }
    
    public Long portAsLong() {
        return asLong("AgentConfiguration", "port", port);
    }
    
    public void port(BigInteger newPort) {
        port = newPort;
    }
    
    public boolean portPresent() {
        return port != null;
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
    
}
