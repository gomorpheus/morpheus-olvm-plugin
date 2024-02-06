/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Represents an operating system installed on the virtual machine.
 * 
 * To get that information send a request like this:
 * 
 * ....
 * GET /ovirt-engine/api/vms/123
 * ....
 * 
 * The result will be like this:
 * 
 * [source,xml]
 * ----
 * <vm href="/ovirt-engine/api/vms/123" id="123">
 * ...
 *   <guest_operating_system>
 *     <architecture>x86_64</architecture>
 *     <codename>Maipo</codename>
 *     <distribution>Red Hat Enterprise Linux Server</distribution>
 *     <family>Linux</family>
 *     <kernel>
 *       <version>
 *         <build>0</build>
 *         <full_version>3.10.0-514.10.2.el7.x86_64</full_version>
 *         <major>3</major>
 *         <minor>10</minor>
 *         <revision>514</revision>
 *       </version>
 *     </kernel>
 *     <version>
 *       <full_version>7.3</full_version>
 *       <major>7</major>
 *       <minor>3</minor>
 *     </version>
 *   </guest_operating_system>
 * </vm>
 * ----
 */
public interface GuestOperatingSystem {
    String architecture();
    
    boolean architecturePresent();
    
    String codename();
    
    boolean codenamePresent();
    
    String distribution();
    
    boolean distributionPresent();
    
    String family();
    
    boolean familyPresent();
    
    Kernel kernel();
    
    boolean kernelPresent();
    
    Version version();
    
    boolean versionPresent();
    
}
