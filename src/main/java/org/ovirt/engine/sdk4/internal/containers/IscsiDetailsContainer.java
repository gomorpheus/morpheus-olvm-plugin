/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.IscsiDetails;

public class IscsiDetailsContainer extends Container implements IscsiDetails {
    private String address;
    private String diskId;
    private String initiator;
    private BigInteger lunMapping;
    private String password;
    private BigInteger paths;
    private BigInteger port;
    private String portal;
    private String productId;
    private String serial;
    private BigInteger size;
    private String status;
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
    
    public String diskId() {
        return diskId;
    }
    
    public void diskId(String newDiskId) {
        diskId = newDiskId;
    }
    
    public boolean diskIdPresent() {
        return diskId != null;
    }
    
    public String initiator() {
        return initiator;
    }
    
    public void initiator(String newInitiator) {
        initiator = newInitiator;
    }
    
    public boolean initiatorPresent() {
        return initiator != null;
    }
    
    public BigInteger lunMapping() {
        return lunMapping;
    }
    
    public Byte lunMappingAsByte() {
        return asByte("IscsiDetails", "lunMapping", lunMapping);
    }
    
    public Short lunMappingAsShort() {
        return asShort("IscsiDetails", "lunMapping", lunMapping);
    }
    
    public Integer lunMappingAsInteger() {
        return asInteger("IscsiDetails", "lunMapping", lunMapping);
    }
    
    public Long lunMappingAsLong() {
        return asLong("IscsiDetails", "lunMapping", lunMapping);
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
        return asByte("IscsiDetails", "paths", paths);
    }
    
    public Short pathsAsShort() {
        return asShort("IscsiDetails", "paths", paths);
    }
    
    public Integer pathsAsInteger() {
        return asInteger("IscsiDetails", "paths", paths);
    }
    
    public Long pathsAsLong() {
        return asLong("IscsiDetails", "paths", paths);
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
        return asByte("IscsiDetails", "port", port);
    }
    
    public Short portAsShort() {
        return asShort("IscsiDetails", "port", port);
    }
    
    public Integer portAsInteger() {
        return asInteger("IscsiDetails", "port", port);
    }
    
    public Long portAsLong() {
        return asLong("IscsiDetails", "port", port);
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
        return asByte("IscsiDetails", "size", size);
    }
    
    public Short sizeAsShort() {
        return asShort("IscsiDetails", "size", size);
    }
    
    public Integer sizeAsInteger() {
        return asInteger("IscsiDetails", "size", size);
    }
    
    public Long sizeAsLong() {
        return asLong("IscsiDetails", "size", size);
    }
    
    public void size(BigInteger newSize) {
        size = newSize;
    }
    
    public boolean sizePresent() {
        return size != null;
    }
    
    public String status() {
        return status;
    }
    
    public void status(String newStatus) {
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
