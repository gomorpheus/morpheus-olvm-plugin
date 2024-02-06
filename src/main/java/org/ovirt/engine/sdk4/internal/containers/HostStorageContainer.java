/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostStorage;
import org.ovirt.engine.sdk4.types.LogicalUnit;
import org.ovirt.engine.sdk4.types.NfsVersion;
import org.ovirt.engine.sdk4.types.Property;
import org.ovirt.engine.sdk4.types.StorageType;
import org.ovirt.engine.sdk4.types.VolumeGroup;

public class HostStorageContainer extends IdentifiedContainer implements HostStorage {
    private String address;
    private List<Property> driverOptions;
    private List<Property> driverSensitiveOptions;
    private List<LogicalUnit> logicalUnits;
    private String mountOptions;
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
    
    public List<Property> driverOptions() {
        return makeUnmodifiableList(driverOptions);
    }
    
    public void driverOptions(List<Property> newDriverOptions) {
        driverOptions = makeArrayList(newDriverOptions);
    }
    
    public boolean driverOptionsPresent() {
        return driverOptions != null && !driverOptions.isEmpty();
    }
    
    public List<Property> driverSensitiveOptions() {
        return makeUnmodifiableList(driverSensitiveOptions);
    }
    
    public void driverSensitiveOptions(List<Property> newDriverSensitiveOptions) {
        driverSensitiveOptions = makeArrayList(newDriverSensitiveOptions);
    }
    
    public boolean driverSensitiveOptionsPresent() {
        return driverSensitiveOptions != null && !driverSensitiveOptions.isEmpty();
    }
    
    public List<LogicalUnit> logicalUnits() {
        return makeUnmodifiableList(logicalUnits);
    }
    
    public void logicalUnits(List<LogicalUnit> newLogicalUnits) {
        logicalUnits = makeArrayList(newLogicalUnits);
    }
    
    public boolean logicalUnitsPresent() {
        return logicalUnits != null && !logicalUnits.isEmpty();
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
        return asByte("HostStorage", "nfsRetrans", nfsRetrans);
    }
    
    public Short nfsRetransAsShort() {
        return asShort("HostStorage", "nfsRetrans", nfsRetrans);
    }
    
    public Integer nfsRetransAsInteger() {
        return asInteger("HostStorage", "nfsRetrans", nfsRetrans);
    }
    
    public Long nfsRetransAsLong() {
        return asLong("HostStorage", "nfsRetrans", nfsRetrans);
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
        return asByte("HostStorage", "nfsTimeo", nfsTimeo);
    }
    
    public Short nfsTimeoAsShort() {
        return asShort("HostStorage", "nfsTimeo", nfsTimeo);
    }
    
    public Integer nfsTimeoAsInteger() {
        return asInteger("HostStorage", "nfsTimeo", nfsTimeo);
    }
    
    public Long nfsTimeoAsLong() {
        return asLong("HostStorage", "nfsTimeo", nfsTimeo);
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
    
    public boolean overrideLuns() {
        return overrideLuns;
    }
    
    public void overrideLuns(boolean newOverrideLuns) {
        overrideLuns = Boolean.valueOf(newOverrideLuns);
    }
    
    public void overrideLuns(Boolean newOverrideLuns) {
        overrideLuns = newOverrideLuns;
    }
    
    public boolean overrideLunsPresent() {
        return overrideLuns != null;
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
        return asByte("HostStorage", "port", port);
    }
    
    public Short portAsShort() {
        return asShort("HostStorage", "port", port);
    }
    
    public Integer portAsInteger() {
        return asInteger("HostStorage", "port", port);
    }
    
    public Long portAsLong() {
        return asLong("HostStorage", "port", port);
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
    
    public VolumeGroup volumeGroup() {
        return volumeGroup;
    }
    
    public void volumeGroup(VolumeGroup newVolumeGroup) {
        volumeGroup = newVolumeGroup;
    }
    
    public boolean volumeGroupPresent() {
        return volumeGroup != null;
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
