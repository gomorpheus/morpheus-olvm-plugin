/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.GuestOperatingSystem;
import org.ovirt.engine.sdk4.types.Kernel;
import org.ovirt.engine.sdk4.types.Version;

public class GuestOperatingSystemContainer extends Container implements GuestOperatingSystem {
    private String architecture;
    private String codename;
    private String distribution;
    private String family;
    private Kernel kernel;
    private Version version;
    
    public String architecture() {
        return architecture;
    }
    
    public void architecture(String newArchitecture) {
        architecture = newArchitecture;
    }
    
    public boolean architecturePresent() {
        return architecture != null;
    }
    
    public String codename() {
        return codename;
    }
    
    public void codename(String newCodename) {
        codename = newCodename;
    }
    
    public boolean codenamePresent() {
        return codename != null;
    }
    
    public String distribution() {
        return distribution;
    }
    
    public void distribution(String newDistribution) {
        distribution = newDistribution;
    }
    
    public boolean distributionPresent() {
        return distribution != null;
    }
    
    public String family() {
        return family;
    }
    
    public void family(String newFamily) {
        family = newFamily;
    }
    
    public boolean familyPresent() {
        return family != null;
    }
    
    public Kernel kernel() {
        return kernel;
    }
    
    public void kernel(Kernel newKernel) {
        kernel = newKernel;
    }
    
    public boolean kernelPresent() {
        return kernel != null;
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
