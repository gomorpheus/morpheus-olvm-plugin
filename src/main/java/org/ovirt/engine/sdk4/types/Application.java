/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Represents an application installed on a virtual machine. Applications are reported by the guest agent, if you
 * deploy one on the virtual machine operating system.
 * 
 * To get that information send a request like this:
 * 
 * ....
 * GET /ovirt-engine/api/vms/123/applications/456
 * ....
 * 
 * The result will be like this:
 * 
 * [source,xml]
 * ----
 * <application href="/ovirt-engine/api/vms/123/applications/456" id="456">
 *   <name>application-test-1.0.0-0.el7</name>
 *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
 * </application>
 * ----
 */
public interface Application extends Identified {
    Vm vm();
    
    boolean vmPresent();
    
}
