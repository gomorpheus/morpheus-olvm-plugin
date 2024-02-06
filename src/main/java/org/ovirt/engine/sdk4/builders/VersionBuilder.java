/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.VersionContainer;
import org.ovirt.engine.sdk4.types.Version;

public class VersionBuilder {
    private BigInteger build;
    private String comment;
    private String description;
    private String fullVersion;
    private String href;
    private String id;
    private BigInteger major;
    private BigInteger minor;
    private String name;
    private BigInteger revision;
    
    public VersionBuilder build(int newBuild) {
        build = BigInteger.valueOf((long) newBuild);
        return this;
    }
    
    public VersionBuilder build(Integer newBuild) {
        if (newBuild == null) {
            build = null;
        }
        else {
            build = BigInteger.valueOf(newBuild.longValue());
        }
        return this;
    }
    
    public VersionBuilder build(long newBuild) {
        build = BigInteger.valueOf(newBuild);
        return this;
    }
    
    public VersionBuilder build(Long newBuild) {
        if (newBuild == null) {
            build = null;
        }
        else {
            build = BigInteger.valueOf(newBuild.longValue());
        }
        return this;
    }
    
    public VersionBuilder build(BigInteger newBuild) {
        build = newBuild;
        return this;
    }
    
    
    public VersionBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public VersionBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public VersionBuilder fullVersion(String newFullVersion) {
        fullVersion = newFullVersion;
        return this;
    }
    
    
    public VersionBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public VersionBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public VersionBuilder major(int newMajor) {
        major = BigInteger.valueOf((long) newMajor);
        return this;
    }
    
    public VersionBuilder major(Integer newMajor) {
        if (newMajor == null) {
            major = null;
        }
        else {
            major = BigInteger.valueOf(newMajor.longValue());
        }
        return this;
    }
    
    public VersionBuilder major(long newMajor) {
        major = BigInteger.valueOf(newMajor);
        return this;
    }
    
    public VersionBuilder major(Long newMajor) {
        if (newMajor == null) {
            major = null;
        }
        else {
            major = BigInteger.valueOf(newMajor.longValue());
        }
        return this;
    }
    
    public VersionBuilder major(BigInteger newMajor) {
        major = newMajor;
        return this;
    }
    
    
    public VersionBuilder minor(int newMinor) {
        minor = BigInteger.valueOf((long) newMinor);
        return this;
    }
    
    public VersionBuilder minor(Integer newMinor) {
        if (newMinor == null) {
            minor = null;
        }
        else {
            minor = BigInteger.valueOf(newMinor.longValue());
        }
        return this;
    }
    
    public VersionBuilder minor(long newMinor) {
        minor = BigInteger.valueOf(newMinor);
        return this;
    }
    
    public VersionBuilder minor(Long newMinor) {
        if (newMinor == null) {
            minor = null;
        }
        else {
            minor = BigInteger.valueOf(newMinor.longValue());
        }
        return this;
    }
    
    public VersionBuilder minor(BigInteger newMinor) {
        minor = newMinor;
        return this;
    }
    
    
    public VersionBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public VersionBuilder revision(int newRevision) {
        revision = BigInteger.valueOf((long) newRevision);
        return this;
    }
    
    public VersionBuilder revision(Integer newRevision) {
        if (newRevision == null) {
            revision = null;
        }
        else {
            revision = BigInteger.valueOf(newRevision.longValue());
        }
        return this;
    }
    
    public VersionBuilder revision(long newRevision) {
        revision = BigInteger.valueOf(newRevision);
        return this;
    }
    
    public VersionBuilder revision(Long newRevision) {
        if (newRevision == null) {
            revision = null;
        }
        else {
            revision = BigInteger.valueOf(newRevision.longValue());
        }
        return this;
    }
    
    public VersionBuilder revision(BigInteger newRevision) {
        revision = newRevision;
        return this;
    }
    
    
    public Version build() {
        VersionContainer container = new VersionContainer();
        container.build(build);
        container.comment(comment);
        container.description(description);
        container.fullVersion(fullVersion);
        container.href(href);
        container.id(id);
        container.major(major);
        container.minor(minor);
        container.name(name);
        container.revision(revision);
        return container;
    }
}
