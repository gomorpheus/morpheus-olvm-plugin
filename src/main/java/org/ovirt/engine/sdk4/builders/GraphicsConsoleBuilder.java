/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.GraphicsConsoleContainer;
import org.ovirt.engine.sdk4.types.GraphicsConsole;
import org.ovirt.engine.sdk4.types.GraphicsType;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;

public class GraphicsConsoleBuilder {
    private String address;
    private String comment;
    private String description;
    private String href;
    private String id;
    private InstanceType instanceType;
    private String name;
    private BigInteger port;
    private GraphicsType protocol;
    private Template template;
    private BigInteger tlsPort;
    private Vm vm;
    
    public GraphicsConsoleBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public GraphicsConsoleBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public GraphicsConsoleBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public GraphicsConsoleBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public GraphicsConsoleBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public GraphicsConsoleBuilder instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
        return this;
    }
    
    public GraphicsConsoleBuilder instanceType(InstanceTypeBuilder newInstanceType) {
        if (newInstanceType == null) {
            instanceType = null;
        }
        else {
            instanceType = newInstanceType.build();
        }
        return this;
    }
    
    
    public GraphicsConsoleBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public GraphicsConsoleBuilder port(int newPort) {
        port = BigInteger.valueOf((long) newPort);
        return this;
    }
    
    public GraphicsConsoleBuilder port(Integer newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public GraphicsConsoleBuilder port(long newPort) {
        port = BigInteger.valueOf(newPort);
        return this;
    }
    
    public GraphicsConsoleBuilder port(Long newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public GraphicsConsoleBuilder port(BigInteger newPort) {
        port = newPort;
        return this;
    }
    
    
    public GraphicsConsoleBuilder protocol(GraphicsType newProtocol) {
        protocol = newProtocol;
        return this;
    }
    
    
    public GraphicsConsoleBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public GraphicsConsoleBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public GraphicsConsoleBuilder tlsPort(int newTlsPort) {
        tlsPort = BigInteger.valueOf((long) newTlsPort);
        return this;
    }
    
    public GraphicsConsoleBuilder tlsPort(Integer newTlsPort) {
        if (newTlsPort == null) {
            tlsPort = null;
        }
        else {
            tlsPort = BigInteger.valueOf(newTlsPort.longValue());
        }
        return this;
    }
    
    public GraphicsConsoleBuilder tlsPort(long newTlsPort) {
        tlsPort = BigInteger.valueOf(newTlsPort);
        return this;
    }
    
    public GraphicsConsoleBuilder tlsPort(Long newTlsPort) {
        if (newTlsPort == null) {
            tlsPort = null;
        }
        else {
            tlsPort = BigInteger.valueOf(newTlsPort.longValue());
        }
        return this;
    }
    
    public GraphicsConsoleBuilder tlsPort(BigInteger newTlsPort) {
        tlsPort = newTlsPort;
        return this;
    }
    
    
    public GraphicsConsoleBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public GraphicsConsoleBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public GraphicsConsole build() {
        GraphicsConsoleContainer container = new GraphicsConsoleContainer();
        container.address(address);
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.instanceType(instanceType);
        container.name(name);
        container.port(port);
        container.protocol(protocol);
        container.template(template);
        container.tlsPort(tlsPort);
        container.vm(vm);
        return container;
    }
}
