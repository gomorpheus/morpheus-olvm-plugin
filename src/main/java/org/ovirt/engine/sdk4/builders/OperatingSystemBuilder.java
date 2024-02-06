/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.OperatingSystemContainer;
import org.ovirt.engine.sdk4.types.Boot;
import org.ovirt.engine.sdk4.types.OperatingSystem;
import org.ovirt.engine.sdk4.types.Version;

public class OperatingSystemBuilder {
    private Boot boot;
    private String cmdline;
    private String customKernelCmdline;
    private String initrd;
    private String kernel;
    private String reportedKernelCmdline;
    private String type;
    private Version version;
    
    public OperatingSystemBuilder boot(Boot newBoot) {
        boot = newBoot;
        return this;
    }
    
    public OperatingSystemBuilder boot(BootBuilder newBoot) {
        if (newBoot == null) {
            boot = null;
        }
        else {
            boot = newBoot.build();
        }
        return this;
    }
    
    
    public OperatingSystemBuilder cmdline(String newCmdline) {
        cmdline = newCmdline;
        return this;
    }
    
    
    public OperatingSystemBuilder customKernelCmdline(String newCustomKernelCmdline) {
        customKernelCmdline = newCustomKernelCmdline;
        return this;
    }
    
    
    public OperatingSystemBuilder initrd(String newInitrd) {
        initrd = newInitrd;
        return this;
    }
    
    
    public OperatingSystemBuilder kernel(String newKernel) {
        kernel = newKernel;
        return this;
    }
    
    
    public OperatingSystemBuilder reportedKernelCmdline(String newReportedKernelCmdline) {
        reportedKernelCmdline = newReportedKernelCmdline;
        return this;
    }
    
    
    public OperatingSystemBuilder type(String newType) {
        type = newType;
        return this;
    }
    
    
    public OperatingSystemBuilder version(Version newVersion) {
        version = newVersion;
        return this;
    }
    
    public OperatingSystemBuilder version(VersionBuilder newVersion) {
        if (newVersion == null) {
            version = null;
        }
        else {
            version = newVersion.build();
        }
        return this;
    }
    
    
    public OperatingSystem build() {
        OperatingSystemContainer container = new OperatingSystemContainer();
        container.boot(boot);
        container.cmdline(cmdline);
        container.customKernelCmdline(customKernelCmdline);
        container.initrd(initrd);
        container.kernel(kernel);
        container.reportedKernelCmdline(reportedKernelCmdline);
        container.type(type);
        container.version(version);
        return container;
    }
}
