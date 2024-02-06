/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Information describing the operating system. This is used for both virtual machines and hosts.
 */
public interface OperatingSystem {
    Boot boot();
    
    boolean bootPresent();
    
    String cmdline();
    
    boolean cmdlinePresent();
    
    String customKernelCmdline();
    
    boolean customKernelCmdlinePresent();
    
    String initrd();
    
    boolean initrdPresent();
    
    String kernel();
    
    boolean kernelPresent();
    
    String reportedKernelCmdline();
    
    boolean reportedKernelCmdlinePresent();
    
    String type();
    
    boolean typePresent();
    
    Version version();
    
    boolean versionPresent();
    
}
