/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.LogicalUnitContainer;
import org.ovirt.engine.sdk4.types.LogicalUnit;
import org.ovirt.engine.sdk4.types.LunStatus;

public class LogicalUnitBuilder {
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
    
    public LogicalUnitBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public LogicalUnitBuilder discardMaxSize(int newDiscardMaxSize) {
        discardMaxSize = BigInteger.valueOf((long) newDiscardMaxSize);
        return this;
    }
    
    public LogicalUnitBuilder discardMaxSize(Integer newDiscardMaxSize) {
        if (newDiscardMaxSize == null) {
            discardMaxSize = null;
        }
        else {
            discardMaxSize = BigInteger.valueOf(newDiscardMaxSize.longValue());
        }
        return this;
    }
    
    public LogicalUnitBuilder discardMaxSize(long newDiscardMaxSize) {
        discardMaxSize = BigInteger.valueOf(newDiscardMaxSize);
        return this;
    }
    
    public LogicalUnitBuilder discardMaxSize(Long newDiscardMaxSize) {
        if (newDiscardMaxSize == null) {
            discardMaxSize = null;
        }
        else {
            discardMaxSize = BigInteger.valueOf(newDiscardMaxSize.longValue());
        }
        return this;
    }
    
    public LogicalUnitBuilder discardMaxSize(BigInteger newDiscardMaxSize) {
        discardMaxSize = newDiscardMaxSize;
        return this;
    }
    
    
    public LogicalUnitBuilder discardZeroesData(boolean newDiscardZeroesData) {
        discardZeroesData = Boolean.valueOf(newDiscardZeroesData);
        return this;
    }
    
    public LogicalUnitBuilder discardZeroesData(Boolean newDiscardZeroesData) {
        discardZeroesData = newDiscardZeroesData;
        return this;
    }
    
    
    public LogicalUnitBuilder diskId(String newDiskId) {
        diskId = newDiskId;
        return this;
    }
    
    
    public LogicalUnitBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public LogicalUnitBuilder lunMapping(int newLunMapping) {
        lunMapping = BigInteger.valueOf((long) newLunMapping);
        return this;
    }
    
    public LogicalUnitBuilder lunMapping(Integer newLunMapping) {
        if (newLunMapping == null) {
            lunMapping = null;
        }
        else {
            lunMapping = BigInteger.valueOf(newLunMapping.longValue());
        }
        return this;
    }
    
    public LogicalUnitBuilder lunMapping(long newLunMapping) {
        lunMapping = BigInteger.valueOf(newLunMapping);
        return this;
    }
    
    public LogicalUnitBuilder lunMapping(Long newLunMapping) {
        if (newLunMapping == null) {
            lunMapping = null;
        }
        else {
            lunMapping = BigInteger.valueOf(newLunMapping.longValue());
        }
        return this;
    }
    
    public LogicalUnitBuilder lunMapping(BigInteger newLunMapping) {
        lunMapping = newLunMapping;
        return this;
    }
    
    
    public LogicalUnitBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public LogicalUnitBuilder paths(int newPaths) {
        paths = BigInteger.valueOf((long) newPaths);
        return this;
    }
    
    public LogicalUnitBuilder paths(Integer newPaths) {
        if (newPaths == null) {
            paths = null;
        }
        else {
            paths = BigInteger.valueOf(newPaths.longValue());
        }
        return this;
    }
    
    public LogicalUnitBuilder paths(long newPaths) {
        paths = BigInteger.valueOf(newPaths);
        return this;
    }
    
    public LogicalUnitBuilder paths(Long newPaths) {
        if (newPaths == null) {
            paths = null;
        }
        else {
            paths = BigInteger.valueOf(newPaths.longValue());
        }
        return this;
    }
    
    public LogicalUnitBuilder paths(BigInteger newPaths) {
        paths = newPaths;
        return this;
    }
    
    
    public LogicalUnitBuilder port(int newPort) {
        port = BigInteger.valueOf((long) newPort);
        return this;
    }
    
    public LogicalUnitBuilder port(Integer newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public LogicalUnitBuilder port(long newPort) {
        port = BigInteger.valueOf(newPort);
        return this;
    }
    
    public LogicalUnitBuilder port(Long newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public LogicalUnitBuilder port(BigInteger newPort) {
        port = newPort;
        return this;
    }
    
    
    public LogicalUnitBuilder portal(String newPortal) {
        portal = newPortal;
        return this;
    }
    
    
    public LogicalUnitBuilder productId(String newProductId) {
        productId = newProductId;
        return this;
    }
    
    
    public LogicalUnitBuilder serial(String newSerial) {
        serial = newSerial;
        return this;
    }
    
    
    public LogicalUnitBuilder size(int newSize) {
        size = BigInteger.valueOf((long) newSize);
        return this;
    }
    
    public LogicalUnitBuilder size(Integer newSize) {
        if (newSize == null) {
            size = null;
        }
        else {
            size = BigInteger.valueOf(newSize.longValue());
        }
        return this;
    }
    
    public LogicalUnitBuilder size(long newSize) {
        size = BigInteger.valueOf(newSize);
        return this;
    }
    
    public LogicalUnitBuilder size(Long newSize) {
        if (newSize == null) {
            size = null;
        }
        else {
            size = BigInteger.valueOf(newSize.longValue());
        }
        return this;
    }
    
    public LogicalUnitBuilder size(BigInteger newSize) {
        size = newSize;
        return this;
    }
    
    
    public LogicalUnitBuilder status(LunStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public LogicalUnitBuilder storageDomainId(String newStorageDomainId) {
        storageDomainId = newStorageDomainId;
        return this;
    }
    
    
    public LogicalUnitBuilder target(String newTarget) {
        target = newTarget;
        return this;
    }
    
    
    public LogicalUnitBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public LogicalUnitBuilder vendorId(String newVendorId) {
        vendorId = newVendorId;
        return this;
    }
    
    
    public LogicalUnitBuilder volumeGroupId(String newVolumeGroupId) {
        volumeGroupId = newVolumeGroupId;
        return this;
    }
    
    
    public LogicalUnit build() {
        LogicalUnitContainer container = new LogicalUnitContainer();
        container.address(address);
        container.discardMaxSize(discardMaxSize);
        container.discardZeroesData(discardZeroesData);
        container.diskId(diskId);
        container.id(id);
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
