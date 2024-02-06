/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.Boot;
import org.ovirt.engine.sdk4.types.OperatingSystem;
import org.ovirt.engine.sdk4.types.Version;

public class OperatingSystemContainer extends Container implements OperatingSystem {
    private Boot boot;
    private String cmdline;
    private String customKernelCmdline;
    private String initrd;
    private String kernel;
    private String reportedKernelCmdline;
    private String type;
    private Version version;
    
    public Boot boot() {
        return boot;
    }
    
    public void boot(Boot newBoot) {
        boot = newBoot;
    }
    
    public boolean bootPresent() {
        return boot != null;
    }
    
    public String cmdline() {
        return cmdline;
    }
    
    public void cmdline(String newCmdline) {
        cmdline = newCmdline;
    }
    
    public boolean cmdlinePresent() {
        return cmdline != null;
    }
    
    public String customKernelCmdline() {
        return customKernelCmdline;
    }
    
    public void customKernelCmdline(String newCustomKernelCmdline) {
        customKernelCmdline = newCustomKernelCmdline;
    }
    
    public boolean customKernelCmdlinePresent() {
        return customKernelCmdline != null;
    }
    
    public String initrd() {
        return initrd;
    }
    
    public void initrd(String newInitrd) {
        initrd = newInitrd;
    }
    
    public boolean initrdPresent() {
        return initrd != null;
    }
    
    public String kernel() {
        return kernel;
    }
    
    public void kernel(String newKernel) {
        kernel = newKernel;
    }
    
    public boolean kernelPresent() {
        return kernel != null;
    }
    
    public String reportedKernelCmdline() {
        return reportedKernelCmdline;
    }
    
    public void reportedKernelCmdline(String newReportedKernelCmdline) {
        reportedKernelCmdline = newReportedKernelCmdline;
    }
    
    public boolean reportedKernelCmdlinePresent() {
        return reportedKernelCmdline != null;
    }
    
    public String type() {
        return type;
    }
    
    public void type(String newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public Version version() {
        return version;
    }
    
    public void version(Version newVersion) {
        version = newVersion;
    }
    
    public boolean versionPresent() {
        return version != null;
    }
    
}
