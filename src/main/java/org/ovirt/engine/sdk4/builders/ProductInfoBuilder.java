/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ProductInfoContainer;
import org.ovirt.engine.sdk4.types.ProductInfo;
import org.ovirt.engine.sdk4.types.Version;

public class ProductInfoBuilder {
    private String instanceId;
    private String name;
    private String vendor;
    private Version version;
    
    public ProductInfoBuilder instanceId(String newInstanceId) {
        instanceId = newInstanceId;
        return this;
    }
    
    
    public ProductInfoBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ProductInfoBuilder vendor(String newVendor) {
        vendor = newVendor;
        return this;
    }
    
    
    public ProductInfoBuilder version(Version newVersion) {
        version = newVersion;
        return this;
    }
    
    public ProductInfoBuilder version(VersionBuilder newVersion) {
        if (newVersion == null) {
            version = null;
        }
        else {
            version = newVersion.build();
        }
        return this;
    }
    
    
    public ProductInfo build() {
        ProductInfoContainer container = new ProductInfoContainer();
        container.instanceId(instanceId);
        container.name(name);
        container.vendor(vendor);
        container.version(version);
        return container;
    }
}
