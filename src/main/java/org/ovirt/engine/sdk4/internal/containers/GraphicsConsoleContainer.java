/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.GraphicsConsole;
import org.ovirt.engine.sdk4.types.GraphicsType;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;

public class GraphicsConsoleContainer extends IdentifiedContainer implements GraphicsConsole {
    private String address;
    private BigInteger port;
    private GraphicsType protocol;
    private BigInteger tlsPort;
    private InstanceType instanceType;
    private Template template;
    private Vm vm;
    
    public String address() {
        return address;
    }
    
    public void address(String newAddress) {
        address = newAddress;
    }
    
    public boolean addressPresent() {
        return address != null;
    }
    
    public BigInteger port() {
        return port;
    }
    
    public Byte portAsByte() {
        return asByte("GraphicsConsole", "port", port);
    }
    
    public Short portAsShort() {
        return asShort("GraphicsConsole", "port", port);
    }
    
    public Integer portAsInteger() {
        return asInteger("GraphicsConsole", "port", port);
    }
    
    public Long portAsLong() {
        return asLong("GraphicsConsole", "port", port);
    }
    
    public void port(BigInteger newPort) {
        port = newPort;
    }
    
    public boolean portPresent() {
        return port != null;
    }
    
    public GraphicsType protocol() {
        return protocol;
    }
    
    public void protocol(GraphicsType newProtocol) {
        protocol = newProtocol;
    }
    
    public boolean protocolPresent() {
        return protocol != null;
    }
    
    public BigInteger tlsPort() {
        return tlsPort;
    }
    
    public Byte tlsPortAsByte() {
        return asByte("GraphicsConsole", "tlsPort", tlsPort);
    }
    
    public Short tlsPortAsShort() {
        return asShort("GraphicsConsole", "tlsPort", tlsPort);
    }
    
    public Integer tlsPortAsInteger() {
        return asInteger("GraphicsConsole", "tlsPort", tlsPort);
    }
    
    public Long tlsPortAsLong() {
        return asLong("GraphicsConsole", "tlsPort", tlsPort);
    }
    
    public void tlsPort(BigInteger newTlsPort) {
        tlsPort = newTlsPort;
    }
    
    public boolean tlsPortPresent() {
        return tlsPort != null;
    }
    
    public InstanceType instanceType() {
        return instanceType;
    }
    
    public void instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
    }
    
    public boolean instanceTypePresent() {
        return instanceType != null;
    }
    
    public Template template() {
        return template;
    }
    
    public void template(Template newTemplate) {
        template = newTemplate;
    }
    
    public boolean templatePresent() {
        return template != null;
    }
    
    public Vm vm() {
        return vm;
    }
    
    public void vm(Vm newVm) {
        vm = newVm;
    }
    
    public boolean vmPresent() {
        return vm != null;
    }
    
}
