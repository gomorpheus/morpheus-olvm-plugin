/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.GuestOperatingSystemContainer;
import org.ovirt.engine.sdk4.types.GuestOperatingSystem;
import org.ovirt.engine.sdk4.types.Kernel;
import org.ovirt.engine.sdk4.types.Version;

public class GuestOperatingSystemBuilder {
    private String architecture;
    private String codename;
    private String distribution;
    private String family;
    private Kernel kernel;
    private Version version;
    
    public GuestOperatingSystemBuilder architecture(String newArchitecture) {
        architecture = newArchitecture;
        return this;
    }
    
    
    public GuestOperatingSystemBuilder codename(String newCodename) {
        codename = newCodename;
        return this;
    }
    
    
    public GuestOperatingSystemBuilder distribution(String newDistribution) {
        distribution = newDistribution;
        return this;
    }
    
    
    public GuestOperatingSystemBuilder family(String newFamily) {
        family = newFamily;
        return this;
    }
    
    
    public GuestOperatingSystemBuilder kernel(Kernel newKernel) {
        kernel = newKernel;
        return this;
    }
    
    public GuestOperatingSystemBuilder kernel(KernelBuilder newKernel) {
        if (newKernel == null) {
            kernel = null;
        }
        else {
            kernel = newKernel.build();
        }
        return this;
    }
    
    
    public GuestOperatingSystemBuilder version(Version newVersion) {
        version = newVersion;
        return this;
    }
    
    public GuestOperatingSystemBuilder version(VersionBuilder newVersion) {
        if (newVersion == null) {
            version = null;
        }
        else {
            version = newVersion.build();
        }
        return this;
    }
    
    
    public GuestOperatingSystem build() {
        GuestOperatingSystemContainer container = new GuestOperatingSystemContainer();
        container.architecture(architecture);
        container.codename(codename);
        container.distribution(distribution);
        container.family(family);
        container.kernel(kernel);
        container.version(version);
        return container;
    }
}
