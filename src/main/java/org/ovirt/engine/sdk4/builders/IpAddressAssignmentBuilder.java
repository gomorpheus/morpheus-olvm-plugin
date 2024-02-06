/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.IpAddressAssignmentContainer;
import org.ovirt.engine.sdk4.types.BootProtocol;
import org.ovirt.engine.sdk4.types.Ip;
import org.ovirt.engine.sdk4.types.IpAddressAssignment;

public class IpAddressAssignmentBuilder {
    private BootProtocol assignmentMethod;
    private Ip ip;
    
    public IpAddressAssignmentBuilder assignmentMethod(BootProtocol newAssignmentMethod) {
        assignmentMethod = newAssignmentMethod;
        return this;
    }
    
    
    public IpAddressAssignmentBuilder ip(Ip newIp) {
        ip = newIp;
        return this;
    }
    
    public IpAddressAssignmentBuilder ip(IpBuilder newIp) {
        if (newIp == null) {
            ip = null;
        }
        else {
            ip = newIp.build();
        }
        return this;
    }
    
    
    public IpAddressAssignment build() {
        IpAddressAssignmentContainer container = new IpAddressAssignmentContainer();
        container.assignmentMethod(assignmentMethod);
        container.ip(ip);
        return container;
    }
}
