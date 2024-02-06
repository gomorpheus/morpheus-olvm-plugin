/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.BootProtocol;
import org.ovirt.engine.sdk4.types.Ip;
import org.ovirt.engine.sdk4.types.IpAddressAssignment;

public class IpAddressAssignmentContainer extends Container implements IpAddressAssignment {
    private BootProtocol assignmentMethod;
    private Ip ip;
    
    public BootProtocol assignmentMethod() {
        return assignmentMethod;
    }
    
    public void assignmentMethod(BootProtocol newAssignmentMethod) {
        assignmentMethod = newAssignmentMethod;
    }
    
    public boolean assignmentMethodPresent() {
        return assignmentMethod != null;
    }
    
    public Ip ip() {
        return ip;
    }
    
    public void ip(Ip newIp) {
        ip = newIp;
    }
    
    public boolean ipPresent() {
        return ip != null;
    }
    
}
