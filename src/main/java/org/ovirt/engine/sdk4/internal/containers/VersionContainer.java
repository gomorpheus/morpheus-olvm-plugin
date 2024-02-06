/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Version;

public class VersionContainer extends IdentifiedContainer implements Version {
    private BigInteger build;
    private String fullVersion;
    private BigInteger major;
    private BigInteger minor;
    private BigInteger revision;
    
    public BigInteger build() {
        return build;
    }
    
    public Byte buildAsByte() {
        return asByte("Version", "build", build);
    }
    
    public Short buildAsShort() {
        return asShort("Version", "build", build);
    }
    
    public Integer buildAsInteger() {
        return asInteger("Version", "build", build);
    }
    
    public Long buildAsLong() {
        return asLong("Version", "build", build);
    }
    
    public void build(BigInteger newBuild) {
        build = newBuild;
    }
    
    public boolean buildPresent() {
        return build != null;
    }
    
    public String fullVersion() {
        return fullVersion;
    }
    
    public void fullVersion(String newFullVersion) {
        fullVersion = newFullVersion;
    }
    
    public boolean fullVersionPresent() {
        return fullVersion != null;
    }
    
    public BigInteger major() {
        return major;
    }
    
    public Byte majorAsByte() {
        return asByte("Version", "major", major);
    }
    
    public Short majorAsShort() {
        return asShort("Version", "major", major);
    }
    
    public Integer majorAsInteger() {
        return asInteger("Version", "major", major);
    }
    
    public Long majorAsLong() {
        return asLong("Version", "major", major);
    }
    
    public void major(BigInteger newMajor) {
        major = newMajor;
    }
    
    public boolean majorPresent() {
        return major != null;
    }
    
    public BigInteger minor() {
        return minor;
    }
    
    public Byte minorAsByte() {
        return asByte("Version", "minor", minor);
    }
    
    public Short minorAsShort() {
        return asShort("Version", "minor", minor);
    }
    
    public Integer minorAsInteger() {
        return asInteger("Version", "minor", minor);
    }
    
    public Long minorAsLong() {
        return asLong("Version", "minor", minor);
    }
    
    public void minor(BigInteger newMinor) {
        minor = newMinor;
    }
    
    public boolean minorPresent() {
        return minor != null;
    }
    
    public BigInteger revision() {
        return revision;
    }
    
    public Byte revisionAsByte() {
        return asByte("Version", "revision", revision);
    }
    
    public Short revisionAsShort() {
        return asShort("Version", "revision", revision);
    }
    
    public Integer revisionAsInteger() {
        return asInteger("Version", "revision", revision);
    }
    
    public Long revisionAsLong() {
        return asLong("Version", "revision", revision);
    }
    
    public void revision(BigInteger newRevision) {
        revision = newRevision;
    }
    
    public boolean revisionPresent() {
        return revision != null;
    }
    
}
