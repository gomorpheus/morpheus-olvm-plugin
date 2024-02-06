/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.HostStorageContainer;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostStorage;
import org.ovirt.engine.sdk4.types.LogicalUnit;
import org.ovirt.engine.sdk4.types.NfsVersion;
import org.ovirt.engine.sdk4.types.Property;
import org.ovirt.engine.sdk4.types.StorageType;
import org.ovirt.engine.sdk4.types.VolumeGroup;

public class HostStorageBuilder {
    private String address;
    private String comment;
    private String description;
    private List<Property> driverOptions;
    private List<Property> driverSensitiveOptions;
    private Host host;
    private String href;
    private String id;
    private List<LogicalUnit> logicalUnits;
    private String mountOptions;
    private String name;
    private BigInteger nfsRetrans;
    private BigInteger nfsTimeo;
    private NfsVersion nfsVersion;
    private Boolean overrideLuns;
    private String password;
    private String path;
    private BigInteger port;
    private String portal;
    private String target;
    private StorageType type;
    private String username;
    private String vfsType;
    private VolumeGroup volumeGroup;
    
    public HostStorageBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public HostStorageBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public HostStorageBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public HostStorageBuilder driverOptions(List<Property> newDriverOptions) {
        if (newDriverOptions != null) {
            if (driverOptions == null) {
                driverOptions = new ArrayList<>(newDriverOptions);
            }
            else {
                driverOptions.addAll(newDriverOptions);
            }
        }
        return this;
    }
    
    public HostStorageBuilder driverOptions(Property... newDriverOptions) {
        if (newDriverOptions != null) {
            if (driverOptions == null) {
                driverOptions = new ArrayList<>(newDriverOptions.length);
            }
            Collections.addAll(driverOptions, newDriverOptions);
        }
        return this;
    }
    
    public HostStorageBuilder driverOptions(PropertyBuilder... newDriverOptions) {
        if (newDriverOptions != null) {
            if (driverOptions == null) {
                driverOptions = new ArrayList<>(newDriverOptions.length);
            }
            for (PropertyBuilder builder : newDriverOptions) {
                driverOptions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostStorageBuilder driverSensitiveOptions(List<Property> newDriverSensitiveOptions) {
        if (newDriverSensitiveOptions != null) {
            if (driverSensitiveOptions == null) {
                driverSensitiveOptions = new ArrayList<>(newDriverSensitiveOptions);
            }
            else {
                driverSensitiveOptions.addAll(newDriverSensitiveOptions);
            }
        }
        return this;
    }
    
    public HostStorageBuilder driverSensitiveOptions(Property... newDriverSensitiveOptions) {
        if (newDriverSensitiveOptions != null) {
            if (driverSensitiveOptions == null) {
                driverSensitiveOptions = new ArrayList<>(newDriverSensitiveOptions.length);
            }
            Collections.addAll(driverSensitiveOptions, newDriverSensitiveOptions);
        }
        return this;
    }
    
    public HostStorageBuilder driverSensitiveOptions(PropertyBuilder... newDriverSensitiveOptions) {
        if (newDriverSensitiveOptions != null) {
            if (driverSensitiveOptions == null) {
                driverSensitiveOptions = new ArrayList<>(newDriverSensitiveOptions.length);
            }
            for (PropertyBuilder builder : newDriverSensitiveOptions) {
                driverSensitiveOptions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostStorageBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public HostStorageBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public HostStorageBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public HostStorageBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public HostStorageBuilder logicalUnits(List<LogicalUnit> newLogicalUnits) {
        if (newLogicalUnits != null) {
            if (logicalUnits == null) {
                logicalUnits = new ArrayList<>(newLogicalUnits);
            }
            else {
                logicalUnits.addAll(newLogicalUnits);
            }
        }
        return this;
    }
    
    public HostStorageBuilder logicalUnits(LogicalUnit... newLogicalUnits) {
        if (newLogicalUnits != null) {
            if (logicalUnits == null) {
                logicalUnits = new ArrayList<>(newLogicalUnits.length);
            }
            Collections.addAll(logicalUnits, newLogicalUnits);
        }
        return this;
    }
    
    public HostStorageBuilder logicalUnits(LogicalUnitBuilder... newLogicalUnits) {
        if (newLogicalUnits != null) {
            if (logicalUnits == null) {
                logicalUnits = new ArrayList<>(newLogicalUnits.length);
            }
            for (LogicalUnitBuilder builder : newLogicalUnits) {
                logicalUnits.add(builder.build());
            }
        }
        return this;
    }
    
    
    public HostStorageBuilder mountOptions(String newMountOptions) {
        mountOptions = newMountOptions;
        return this;
    }
    
    
    public HostStorageBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public HostStorageBuilder nfsRetrans(int newNfsRetrans) {
        nfsRetrans = BigInteger.valueOf((long) newNfsRetrans);
        return this;
    }
    
    public HostStorageBuilder nfsRetrans(Integer newNfsRetrans) {
        if (newNfsRetrans == null) {
            nfsRetrans = null;
        }
        else {
            nfsRetrans = BigInteger.valueOf(newNfsRetrans.longValue());
        }
        return this;
    }
    
    public HostStorageBuilder nfsRetrans(long newNfsRetrans) {
        nfsRetrans = BigInteger.valueOf(newNfsRetrans);
        return this;
    }
    
    public HostStorageBuilder nfsRetrans(Long newNfsRetrans) {
        if (newNfsRetrans == null) {
            nfsRetrans = null;
        }
        else {
            nfsRetrans = BigInteger.valueOf(newNfsRetrans.longValue());
        }
        return this;
    }
    
    public HostStorageBuilder nfsRetrans(BigInteger newNfsRetrans) {
        nfsRetrans = newNfsRetrans;
        return this;
    }
    
    
    public HostStorageBuilder nfsTimeo(int newNfsTimeo) {
        nfsTimeo = BigInteger.valueOf((long) newNfsTimeo);
        return this;
    }
    
    public HostStorageBuilder nfsTimeo(Integer newNfsTimeo) {
        if (newNfsTimeo == null) {
            nfsTimeo = null;
        }
        else {
            nfsTimeo = BigInteger.valueOf(newNfsTimeo.longValue());
        }
        return this;
    }
    
    public HostStorageBuilder nfsTimeo(long newNfsTimeo) {
        nfsTimeo = BigInteger.valueOf(newNfsTimeo);
        return this;
    }
    
    public HostStorageBuilder nfsTimeo(Long newNfsTimeo) {
        if (newNfsTimeo == null) {
            nfsTimeo = null;
        }
        else {
            nfsTimeo = BigInteger.valueOf(newNfsTimeo.longValue());
        }
        return this;
    }
    
    public HostStorageBuilder nfsTimeo(BigInteger newNfsTimeo) {
        nfsTimeo = newNfsTimeo;
        return this;
    }
    
    
    public HostStorageBuilder nfsVersion(NfsVersion newNfsVersion) {
        nfsVersion = newNfsVersion;
        return this;
    }
    
    
    public HostStorageBuilder overrideLuns(boolean newOverrideLuns) {
        overrideLuns = Boolean.valueOf(newOverrideLuns);
        return this;
    }
    
    public HostStorageBuilder overrideLuns(Boolean newOverrideLuns) {
        overrideLuns = newOverrideLuns;
        return this;
    }
    
    
    public HostStorageBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public HostStorageBuilder path(String newPath) {
        path = newPath;
        return this;
    }
    
    
    public HostStorageBuilder port(int newPort) {
        port = BigInteger.valueOf((long) newPort);
        return this;
    }
    
    public HostStorageBuilder port(Integer newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public HostStorageBuilder port(long newPort) {
        port = BigInteger.valueOf(newPort);
        return this;
    }
    
    public HostStorageBuilder port(Long newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public HostStorageBuilder port(BigInteger newPort) {
        port = newPort;
        return this;
    }
    
    
    public HostStorageBuilder portal(String newPortal) {
        portal = newPortal;
        return this;
    }
    
    
    public HostStorageBuilder target(String newTarget) {
        target = newTarget;
        return this;
    }
    
    
    public HostStorageBuilder type(StorageType newType) {
        type = newType;
        return this;
    }
    
    
    public HostStorageBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public HostStorageBuilder vfsType(String newVfsType) {
        vfsType = newVfsType;
        return this;
    }
    
    
    public HostStorageBuilder volumeGroup(VolumeGroup newVolumeGroup) {
        volumeGroup = newVolumeGroup;
        return this;
    }
    
    public HostStorageBuilder volumeGroup(VolumeGroupBuilder newVolumeGroup) {
        if (newVolumeGroup == null) {
            volumeGroup = null;
        }
        else {
            volumeGroup = newVolumeGroup.build();
        }
        return this;
    }
    
    
    public HostStorage build() {
        HostStorageContainer container = new HostStorageContainer();
        container.address(address);
        container.comment(comment);
        container.description(description);
        container.driverOptions(driverOptions);
        container.driverSensitiveOptions(driverSensitiveOptions);
        container.host(host);
        container.href(href);
        container.id(id);
        container.logicalUnits(logicalUnits);
        container.mountOptions(mountOptions);
        container.name(name);
        container.nfsRetrans(nfsRetrans);
        container.nfsTimeo(nfsTimeo);
        container.nfsVersion(nfsVersion);
        container.overrideLuns(overrideLuns);
        container.password(password);
        container.path(path);
        container.port(port);
        container.portal(portal);
        container.target(target);
        container.type(type);
        container.username(username);
        container.vfsType(vfsType);
        container.volumeGroup(volumeGroup);
        return container;
    }
}
