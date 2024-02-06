/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.StorageConnectionContainer;
import org.ovirt.engine.sdk4.types.GlusterVolume;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.NfsVersion;
import org.ovirt.engine.sdk4.types.StorageConnection;
import org.ovirt.engine.sdk4.types.StorageType;

public class StorageConnectionBuilder {
    private String address;
    private String comment;
    private String description;
    private GlusterVolume glusterVolume;
    private Host host;
    private String href;
    private String id;
    private String mountOptions;
    private String name;
    private BigInteger nfsRetrans;
    private BigInteger nfsTimeo;
    private NfsVersion nfsVersion;
    private String password;
    private String path;
    private BigInteger port;
    private String portal;
    private String target;
    private StorageType type;
    private String username;
    private String vfsType;
    
    public StorageConnectionBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public StorageConnectionBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public StorageConnectionBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public StorageConnectionBuilder glusterVolume(GlusterVolume newGlusterVolume) {
        glusterVolume = newGlusterVolume;
        return this;
    }
    
    public StorageConnectionBuilder glusterVolume(GlusterVolumeBuilder newGlusterVolume) {
        if (newGlusterVolume == null) {
            glusterVolume = null;
        }
        else {
            glusterVolume = newGlusterVolume.build();
        }
        return this;
    }
    
    
    public StorageConnectionBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public StorageConnectionBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public StorageConnectionBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public StorageConnectionBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public StorageConnectionBuilder mountOptions(String newMountOptions) {
        mountOptions = newMountOptions;
        return this;
    }
    
    
    public StorageConnectionBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public StorageConnectionBuilder nfsRetrans(int newNfsRetrans) {
        nfsRetrans = BigInteger.valueOf((long) newNfsRetrans);
        return this;
    }
    
    public StorageConnectionBuilder nfsRetrans(Integer newNfsRetrans) {
        if (newNfsRetrans == null) {
            nfsRetrans = null;
        }
        else {
            nfsRetrans = BigInteger.valueOf(newNfsRetrans.longValue());
        }
        return this;
    }
    
    public StorageConnectionBuilder nfsRetrans(long newNfsRetrans) {
        nfsRetrans = BigInteger.valueOf(newNfsRetrans);
        return this;
    }
    
    public StorageConnectionBuilder nfsRetrans(Long newNfsRetrans) {
        if (newNfsRetrans == null) {
            nfsRetrans = null;
        }
        else {
            nfsRetrans = BigInteger.valueOf(newNfsRetrans.longValue());
        }
        return this;
    }
    
    public StorageConnectionBuilder nfsRetrans(BigInteger newNfsRetrans) {
        nfsRetrans = newNfsRetrans;
        return this;
    }
    
    
    public StorageConnectionBuilder nfsTimeo(int newNfsTimeo) {
        nfsTimeo = BigInteger.valueOf((long) newNfsTimeo);
        return this;
    }
    
    public StorageConnectionBuilder nfsTimeo(Integer newNfsTimeo) {
        if (newNfsTimeo == null) {
            nfsTimeo = null;
        }
        else {
            nfsTimeo = BigInteger.valueOf(newNfsTimeo.longValue());
        }
        return this;
    }
    
    public StorageConnectionBuilder nfsTimeo(long newNfsTimeo) {
        nfsTimeo = BigInteger.valueOf(newNfsTimeo);
        return this;
    }
    
    public StorageConnectionBuilder nfsTimeo(Long newNfsTimeo) {
        if (newNfsTimeo == null) {
            nfsTimeo = null;
        }
        else {
            nfsTimeo = BigInteger.valueOf(newNfsTimeo.longValue());
        }
        return this;
    }
    
    public StorageConnectionBuilder nfsTimeo(BigInteger newNfsTimeo) {
        nfsTimeo = newNfsTimeo;
        return this;
    }
    
    
    public StorageConnectionBuilder nfsVersion(NfsVersion newNfsVersion) {
        nfsVersion = newNfsVersion;
        return this;
    }
    
    
    public StorageConnectionBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public StorageConnectionBuilder path(String newPath) {
        path = newPath;
        return this;
    }
    
    
    public StorageConnectionBuilder port(int newPort) {
        port = BigInteger.valueOf((long) newPort);
        return this;
    }
    
    public StorageConnectionBuilder port(Integer newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public StorageConnectionBuilder port(long newPort) {
        port = BigInteger.valueOf(newPort);
        return this;
    }
    
    public StorageConnectionBuilder port(Long newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public StorageConnectionBuilder port(BigInteger newPort) {
        port = newPort;
        return this;
    }
    
    
    public StorageConnectionBuilder portal(String newPortal) {
        portal = newPortal;
        return this;
    }
    
    
    public StorageConnectionBuilder target(String newTarget) {
        target = newTarget;
        return this;
    }
    
    
    public StorageConnectionBuilder type(StorageType newType) {
        type = newType;
        return this;
    }
    
    
    public StorageConnectionBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public StorageConnectionBuilder vfsType(String newVfsType) {
        vfsType = newVfsType;
        return this;
    }
    
    
    public StorageConnection build() {
        StorageConnectionContainer container = new StorageConnectionContainer();
        container.address(address);
        container.comment(comment);
        container.description(description);
        container.glusterVolume(glusterVolume);
        container.host(host);
        container.href(href);
        container.id(id);
        container.mountOptions(mountOptions);
        container.name(name);
        container.nfsRetrans(nfsRetrans);
        container.nfsTimeo(nfsTimeo);
        container.nfsVersion(nfsVersion);
        container.password(password);
        container.path(path);
        container.port(port);
        container.portal(portal);
        container.target(target);
        container.type(type);
        container.username(username);
        container.vfsType(vfsType);
        return container;
    }
}
