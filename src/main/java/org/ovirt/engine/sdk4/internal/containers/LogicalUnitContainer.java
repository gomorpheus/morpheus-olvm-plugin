/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.LogicalUnit;
import org.ovirt.engine.sdk4.types.LunStatus;

public class LogicalUnitContainer extends Container implements LogicalUnit {
    private String address;
    private BigInteger discardMaxSize;
    private Boolean discardZeroesData;
    private String diskId;
    private String id;
    private BigInteger lunMapping;
    private String password;
    private BigInteger paths;
    private BigInteger port;
    private String portal;
    private String productId;
    private String serial;
    private BigInteger size;
    private LunStatus status;
    private String storageDomainId;
    private String target;
    private String username;
    private String vendorId;
    private String volumeGroupId;
    
    public String address() {
        return address;
    }
    
    public void address(String newAddress) {
        address = newAddress;
    }
    
    public boolean addressPresent() {
        return address != null;
    }
    
    public BigInteger discardMaxSize() {
        return discardMaxSize;
    }
    
    public Byte discardMaxSizeAsByte() {
        return asByte("LogicalUnit", "discardMaxSize", discardMaxSize);
    }
    
    public Short discardMaxSizeAsShort() {
        return asShort("LogicalUnit", "discardMaxSize", discardMaxSize);
    }
    
    public Integer discardMaxSizeAsInteger() {
        return asInteger("LogicalUnit", "discardMaxSize", discardMaxSize);
    }
    
    public Long discardMaxSizeAsLong() {
        return asLong("LogicalUnit", "discardMaxSize", discardMaxSize);
    }
    
    public void discardMaxSize(BigInteger newDiscardMaxSize) {
        discardMaxSize = newDiscardMaxSize;
    }
    
    public boolean discardMaxSizePresent() {
        return discardMaxSize != null;
    }
    
    public boolean discardZeroesData() {
        return discardZeroesData;
    }
    
    public void discardZeroesData(boolean newDiscardZeroesData) {
        discardZeroesData = Boolean.valueOf(newDiscardZeroesData);
    }
    
    public void discardZeroesData(Boolean newDiscardZeroesData) {
        discardZeroesData = newDiscardZeroesData;
    }
    
    public boolean discardZeroesDataPresent() {
        return discardZeroesData != null;
    }
    
    public String diskId() {
        return diskId;
    }
    
    public void diskId(String newDiskId) {
        diskId = newDiskId;
    }
    
    public boolean diskIdPresent() {
        return diskId != null;
    }
    
    public String id() {
        return id;
    }
    
    public void id(String newId) {
        id = newId;
    }
    
    public boolean idPresent() {
        return id != null;
    }
    
    public BigInteger lunMapping() {
        return lunMapping;
    }
    
    public Byte lunMappingAsByte() {
        return asByte("LogicalUnit", "lunMapping", lunMapping);
    }
    
    public Short lunMappingAsShort() {
        return asShort("LogicalUnit", "lunMapping", lunMapping);
    }
    
    public Integer lunMappingAsInteger() {
        return asInteger("LogicalUnit", "lunMapping", lunMapping);
    }
    
    public Long lunMappingAsLong() {
        return asLong("LogicalUnit", "lunMapping", lunMapping);
    }
    
    public void lunMapping(BigInteger newLunMapping) {
        lunMapping = newLunMapping;
    }
    
    public boolean lunMappingPresent() {
        return lunMapping != null;
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
    
    public BigInteger paths() {
        return paths;
    }
    
    public Byte pathsAsByte() {
        return asByte("LogicalUnit", "paths", paths);
    }
    
    public Short pathsAsShort() {
        return asShort("LogicalUnit", "paths", paths);
    }
    
    public Integer pathsAsInteger() {
        return asInteger("LogicalUnit", "paths", paths);
    }
    
    public Long pathsAsLong() {
        return asLong("LogicalUnit", "paths", paths);
    }
    
    public void paths(BigInteger newPaths) {
        paths = newPaths;
    }
    
    public boolean pathsPresent() {
        return paths != null;
    }
    
    public BigInteger port() {
        return port;
    }
    
    public Byte portAsByte() {
        return asByte("LogicalUnit", "port", port);
    }
    
    public Short portAsShort() {
        return asShort("LogicalUnit", "port", port);
    }
    
    public Integer portAsInteger() {
        return asInteger("LogicalUnit", "port", port);
    }
    
    public Long portAsLong() {
        return asLong("LogicalUnit", "port", port);
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
    
    public String productId() {
        return productId;
    }
    
    public void productId(String newProductId) {
        productId = newProductId;
    }
    
    public boolean productIdPresent() {
        return productId != null;
    }
    
    public String serial() {
        return serial;
    }
    
    public void serial(String newSerial) {
        serial = newSerial;
    }
    
    public boolean serialPresent() {
        return serial != null;
    }
    
    public BigInteger size() {
        return size;
    }
    
    public Byte sizeAsByte() {
        return asByte("LogicalUnit", "size", size);
    }
    
    public Short sizeAsShort() {
        return asShort("LogicalUnit", "size", size);
    }
    
    public Integer sizeAsInteger() {
        return asInteger("LogicalUnit", "size", size);
    }
    
    public Long sizeAsLong() {
        return asLong("LogicalUnit", "size", size);
    }
    
    public void size(BigInteger newSize) {
        size = newSize;
    }
    
    public boolean sizePresent() {
        return size != null;
    }
    
    public LunStatus status() {
        return status;
    }
    
    public void status(LunStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public String storageDomainId() {
        return storageDomainId;
    }
    
    public void storageDomainId(String newStorageDomainId) {
        storageDomainId = newStorageDomainId;
    }
    
    public boolean storageDomainIdPresent() {
        return storageDomainId != null;
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
    
    public String username() {
        return username;
    }
    
    public void username(String newUsername) {
        username = newUsername;
    }
    
    public boolean usernamePresent() {
        return username != null;
    }
    
    public String vendorId() {
        return vendorId;
    }
    
    public void vendorId(String newVendorId) {
        vendorId = newVendorId;
    }
    
    public boolean vendorIdPresent() {
        return vendorId != null;
    }
    
    public String volumeGroupId() {
        return volumeGroupId;
    }
    
    public void volumeGroupId(String newVolumeGroupId) {
        volumeGroupId = newVolumeGroupId;
    }
    
    public boolean volumeGroupIdPresent() {
        return volumeGroupId != null;
    }
    
}
