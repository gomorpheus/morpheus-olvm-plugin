/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.IscsiDetailsContainer;
import org.ovirt.engine.sdk4.types.IscsiDetails;

public class IscsiDetailsBuilder {
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
    
    public IscsiDetailsBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public IscsiDetailsBuilder diskId(String newDiskId) {
        diskId = newDiskId;
        return this;
    }
    
    
    public IscsiDetailsBuilder initiator(String newInitiator) {
        initiator = newInitiator;
        return this;
    }
    
    
    public IscsiDetailsBuilder lunMapping(int newLunMapping) {
        lunMapping = BigInteger.valueOf((long) newLunMapping);
        return this;
    }
    
    public IscsiDetailsBuilder lunMapping(Integer newLunMapping) {
        if (newLunMapping == null) {
            lunMapping = null;
        }
        else {
            lunMapping = BigInteger.valueOf(newLunMapping.longValue());
        }
        return this;
    }
    
    public IscsiDetailsBuilder lunMapping(long newLunMapping) {
        lunMapping = BigInteger.valueOf(newLunMapping);
        return this;
    }
    
    public IscsiDetailsBuilder lunMapping(Long newLunMapping) {
        if (newLunMapping == null) {
            lunMapping = null;
        }
        else {
            lunMapping = BigInteger.valueOf(newLunMapping.longValue());
        }
        return this;
    }
    
    public IscsiDetailsBuilder lunMapping(BigInteger newLunMapping) {
        lunMapping = newLunMapping;
        return this;
    }
    
    
    public IscsiDetailsBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public IscsiDetailsBuilder paths(int newPaths) {
        paths = BigInteger.valueOf((long) newPaths);
        return this;
    }
    
    public IscsiDetailsBuilder paths(Integer newPaths) {
        if (newPaths == null) {
            paths = null;
        }
        else {
            paths = BigInteger.valueOf(newPaths.longValue());
        }
        return this;
    }
    
    public IscsiDetailsBuilder paths(long newPaths) {
        paths = BigInteger.valueOf(newPaths);
        return this;
    }
    
    public IscsiDetailsBuilder paths(Long newPaths) {
        if (newPaths == null) {
            paths = null;
        }
        else {
            paths = BigInteger.valueOf(newPaths.longValue());
        }
        return this;
    }
    
    public IscsiDetailsBuilder paths(BigInteger newPaths) {
        paths = newPaths;
        return this;
    }
    
    
    public IscsiDetailsBuilder port(int newPort) {
        port = BigInteger.valueOf((long) newPort);
        return this;
    }
    
    public IscsiDetailsBuilder port(Integer newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public IscsiDetailsBuilder port(long newPort) {
        port = BigInteger.valueOf(newPort);
        return this;
    }
    
    public IscsiDetailsBuilder port(Long newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public IscsiDetailsBuilder port(BigInteger newPort) {
        port = newPort;
        return this;
    }
    
    
    public IscsiDetailsBuilder portal(String newPortal) {
        portal = newPortal;
        return this;
    }
    
    
    public IscsiDetailsBuilder productId(String newProductId) {
        productId = newProductId;
        return this;
    }
    
    
    public IscsiDetailsBuilder serial(String newSerial) {
        serial = newSerial;
        return this;
    }
    
    
    public IscsiDetailsBuilder size(int newSize) {
        size = BigInteger.valueOf((long) newSize);
        return this;
    }
    
    public IscsiDetailsBuilder size(Integer newSize) {
        if (newSize == null) {
            size = null;
        }
        else {
            size = BigInteger.valueOf(newSize.longValue());
        }
        return this;
    }
    
    public IscsiDetailsBuilder size(long newSize) {
        size = BigInteger.valueOf(newSize);
        return this;
    }
    
    public IscsiDetailsBuilder size(Long newSize) {
        if (newSize == null) {
            size = null;
        }
        else {
            size = BigInteger.valueOf(newSize.longValue());
        }
        return this;
    }
    
    public IscsiDetailsBuilder size(BigInteger newSize) {
        size = newSize;
        return this;
    }
    
    
    public IscsiDetailsBuilder status(String newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public IscsiDetailsBuilder storageDomainId(String newStorageDomainId) {
        storageDomainId = newStorageDomainId;
        return this;
    }
    
    
    public IscsiDetailsBuilder target(String newTarget) {
        target = newTarget;
        return this;
    }
    
    
    public IscsiDetailsBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public IscsiDetailsBuilder vendorId(String newVendorId) {
        vendorId = newVendorId;
        return this;
    }
    
    
    public IscsiDetailsBuilder volumeGroupId(String newVolumeGroupId) {
        volumeGroupId = newVolumeGroupId;
        return this;
    }
    
    
    public IscsiDetails build() {
        IscsiDetailsContainer container = new IscsiDetailsContainer();
        container.address(address);
        container.diskId(diskId);
        container.initiator(initiator);
        container.lunMapping(lunMapping);
        container.password(password);
        container.paths(paths);
        container.port(port);
        container.portal(portal);
        container.productId(productId);
        container.serial(serial);
        container.size(size);
        container.status(status);
        container.storageDomainId(storageDomainId);
        container.target(target);
        container.username(username);
        container.vendorId(vendorId);
        container.volumeGroupId(volumeGroupId);
        return container;
    }
}
