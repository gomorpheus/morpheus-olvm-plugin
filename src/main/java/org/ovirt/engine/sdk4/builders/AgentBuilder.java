/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.AgentContainer;
import org.ovirt.engine.sdk4.types.Agent;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Option;

public class AgentBuilder {
    private String address;
    private String comment;
    private Boolean concurrent;
    private String description;
    private Boolean encryptOptions;
    private Host host;
    private String href;
    private String id;
    private String name;
    private List<Option> options;
    private BigInteger order;
    private String password;
    private BigInteger port;
    private String type;
    private String username;
    
    public AgentBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public AgentBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public AgentBuilder concurrent(boolean newConcurrent) {
        concurrent = Boolean.valueOf(newConcurrent);
        return this;
    }
    
    public AgentBuilder concurrent(Boolean newConcurrent) {
        concurrent = newConcurrent;
        return this;
    }
    
    
    public AgentBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public AgentBuilder encryptOptions(boolean newEncryptOptions) {
        encryptOptions = Boolean.valueOf(newEncryptOptions);
        return this;
    }
    
    public AgentBuilder encryptOptions(Boolean newEncryptOptions) {
        encryptOptions = newEncryptOptions;
        return this;
    }
    
    
    public AgentBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public AgentBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public AgentBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public AgentBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public AgentBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public AgentBuilder options(List<Option> newOptions) {
        if (newOptions != null) {
            if (options == null) {
                options = new ArrayList<>(newOptions);
            }
            else {
                options.addAll(newOptions);
            }
        }
        return this;
    }
    
    public AgentBuilder options(Option... newOptions) {
        if (newOptions != null) {
            if (options == null) {
                options = new ArrayList<>(newOptions.length);
            }
            Collections.addAll(options, newOptions);
        }
        return this;
    }
    
    public AgentBuilder options(OptionBuilder... newOptions) {
        if (newOptions != null) {
            if (options == null) {
                options = new ArrayList<>(newOptions.length);
            }
            for (OptionBuilder builder : newOptions) {
                options.add(builder.build());
            }
        }
        return this;
    }
    
    
    public AgentBuilder order(int newOrder) {
        order = BigInteger.valueOf((long) newOrder);
        return this;
    }
    
    public AgentBuilder order(Integer newOrder) {
        if (newOrder == null) {
            order = null;
        }
        else {
            order = BigInteger.valueOf(newOrder.longValue());
        }
        return this;
    }
    
    public AgentBuilder order(long newOrder) {
        order = BigInteger.valueOf(newOrder);
        return this;
    }
    
    public AgentBuilder order(Long newOrder) {
        if (newOrder == null) {
            order = null;
        }
        else {
            order = BigInteger.valueOf(newOrder.longValue());
        }
        return this;
    }
    
    public AgentBuilder order(BigInteger newOrder) {
        order = newOrder;
        return this;
    }
    
    
    public AgentBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public AgentBuilder port(int newPort) {
        port = BigInteger.valueOf((long) newPort);
        return this;
    }
    
    public AgentBuilder port(Integer newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public AgentBuilder port(long newPort) {
        port = BigInteger.valueOf(newPort);
        return this;
    }
    
    public AgentBuilder port(Long newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public AgentBuilder port(BigInteger newPort) {
        port = newPort;
        return this;
    }
    
    
    public AgentBuilder type(String newType) {
        type = newType;
        return this;
    }
    
    
    public AgentBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public Agent build() {
        AgentContainer container = new AgentContainer();
        container.address(address);
        container.comment(comment);
        container.concurrent(concurrent);
        container.description(description);
        container.encryptOptions(encryptOptions);
        container.host(host);
        container.href(href);
        container.id(id);
        container.name(name);
        container.options(options);
        container.order(order);
        container.password(password);
        container.port(port);
        container.type(type);
        container.username(username);
        return container;
    }
}
