/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.GlusterVolume;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.NfsVersion;
import org.ovirt.engine.sdk4.types.StorageConnection;
import org.ovirt.engine.sdk4.types.StorageType;

public class StorageConnectionContainer extends IdentifiedContainer implements StorageConnection {
    private String address;
    private String mountOptions;
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
    private GlusterVolume glusterVolume;
    private Host host;
    
    public String address() {
        return address;
    }
    
    public void address(String newAddress) {
        address = newAddress;
    }
    
    public boolean addressPresent() {
        return address != null;
    }
    
    public String mountOptions() {
        return mountOptions;
    }
    
    public void mountOptions(String newMountOptions) {
        mountOptions = newMountOptions;
    }
    
    public boolean mountOptionsPresent() {
        return mountOptions != null;
    }
    
    public BigInteger nfsRetrans() {
        return nfsRetrans;
    }
    
    public Byte nfsRetransAsByte() {
        return asByte("StorageConnection", "nfsRetrans", nfsRetrans);
    }
    
    public Short nfsRetransAsShort() {
        return asShort("StorageConnection", "nfsRetrans", nfsRetrans);
    }
    
    public Integer nfsRetransAsInteger() {
        return asInteger("StorageConnection", "nfsRetrans", nfsRetrans);
    }
    
    public Long nfsRetransAsLong() {
        return asLong("StorageConnection", "nfsRetrans", nfsRetrans);
    }
    
    public void nfsRetrans(BigInteger newNfsRetrans) {
        nfsRetrans = newNfsRetrans;
    }
    
    public boolean nfsRetransPresent() {
        return nfsRetrans != null;
    }
    
    public BigInteger nfsTimeo() {
        return nfsTimeo;
    }
    
    public Byte nfsTimeoAsByte() {
        return asByte("StorageConnection", "nfsTimeo", nfsTimeo);
    }
    
    public Short nfsTimeoAsShort() {
        return asShort("StorageConnection", "nfsTimeo", nfsTimeo);
    }
    
    public Integer nfsTimeoAsInteger() {
        return asInteger("StorageConnection", "nfsTimeo", nfsTimeo);
    }
    
    public Long nfsTimeoAsLong() {
        return asLong("StorageConnection", "nfsTimeo", nfsTimeo);
    }
    
    public void nfsTimeo(BigInteger newNfsTimeo) {
        nfsTimeo = newNfsTimeo;
    }
    
    public boolean nfsTimeoPresent() {
        return nfsTimeo != null;
    }
    
    public NfsVersion nfsVersion() {
        return nfsVersion;
    }
    
    public void nfsVersion(NfsVersion newNfsVersion) {
        nfsVersion = newNfsVersion;
    }
    
    public boolean nfsVersionPresent() {
        return nfsVersion != null;
    }
    
    public String password() {
        return password;
    }
    
    public void password(String newPassword) {
        password = newPassword;
    }
    
    public boolean passwordPresent() {
        return password != null;
    }
    
    public String path() {
        return path;
    }
    
    public void path(String newPath) {
        path = newPath;
    }
    
    public boolean pathPresent() {
        return path != null;
    }
    
    public BigInteger port() {
        return port;
    }
    
    public Byte portAsByte() {
        return asByte("StorageConnection", "port", port);
    }
    
    public Short portAsShort() {
        return asShort("StorageConnection", "port", port);
    }
    
    public Integer portAsInteger() {
        return asInteger("StorageConnection", "port", port);
    }
    
    public Long portAsLong() {
        return asLong("StorageConnection", "port", port);
    }
    
    public void port(BigInteger newPort) {
        port = newPort;
    }
    
    public boolean portPresent() {
        return port != null;
    }
    
    public String portal() {
        return portal;
    }
    
    public void portal(String newPortal) {
        portal = newPortal;
    }
    
    public boolean portalPresent() {
        return portal != null;
    }
    
    public String target() {
        return target;
    }
    
    public void target(String newTarget) {
        target = newTarget;
    }
    
    public boolean targetPresent() {
        return target != null;
    }
    
    public StorageType type() {
        return type;
    }
    
    public void type(StorageType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public String username() {
        return username;
    }
    
    public void username(String newUsername) {
        username = newUsername;
    }
    
    public boolean usernamePresent() {
        return username != null;
    }
    
    public String vfsType() {
        return vfsType;
    }
    
    public void vfsType(String newVfsType) {
        vfsType = newVfsType;
    }
    
    public boolean vfsTypePresent() {
        return vfsType != null;
    }
    
    public GlusterVolume glusterVolume() {
        return glusterVolume;
    }
    
    public void glusterVolume(GlusterVolume newGlusterVolume) {
        glusterVolume = newGlusterVolume;
    }
    
    public boolean glusterVolumePresent() {
        return glusterVolume != null;
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
}
