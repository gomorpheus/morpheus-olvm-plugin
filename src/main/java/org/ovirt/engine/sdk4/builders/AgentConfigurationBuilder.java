/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.AgentConfigurationContainer;
import org.ovirt.engine.sdk4.types.AgentConfiguration;
import org.ovirt.engine.sdk4.types.MessageBrokerType;

public class AgentConfigurationBuilder {
    private String address;
    private MessageBrokerType brokerType;
    private String networkMappings;
    private String password;
    private BigInteger port;
    private String username;
    
    public AgentConfigurationBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public AgentConfigurationBuilder brokerType(MessageBrokerType newBrokerType) {
        brokerType = newBrokerType;
        return this;
    }
    
    
    public AgentConfigurationBuilder networkMappings(String newNetworkMappings) {
        networkMappings = newNetworkMappings;
        return this;
    }
    
    
    public AgentConfigurationBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public AgentConfigurationBuilder port(int newPort) {
        port = BigInteger.valueOf((long) newPort);
        return this;
    }
    
    public AgentConfigurationBuilder port(Integer newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public AgentConfigurationBuilder port(long newPort) {
        port = BigInteger.valueOf(newPort);
        return this;
    }
    
    public AgentConfigurationBuilder port(Long newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public AgentConfigurationBuilder port(BigInteger newPort) {
        port = newPort;
        return this;
    }
    
    
    public AgentConfigurationBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public AgentConfiguration build() {
        AgentConfigurationContainer container = new AgentConfigurationContainer();
        container.address(address);
        container.brokerType(brokerType);
        container.networkMappings(networkMappings);
        container.password(password);
        container.port(port);
        container.username(username);
        return container;
    }
}
