/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.ProductInfo;
import org.ovirt.engine.sdk4.types.Version;

public class ProductInfoContainer extends Container implements ProductInfo {
    private String instanceId;
    private String name;
    private String vendor;
    private Version version;
    
    public String instanceId() {
        return instanceId;
    }
    
    public void instanceId(String newInstanceId) {
        instanceId = newInstanceId;
    }
    
    public boolean instanceIdPresent() {
        return instanceId != null;
    }
    
    public String name() {
        return name;
    }
    
    public void name(String newName) {
        name = newName;
    }
    
    public boolean namePresent() {
        return name != null;
    }
    
    public String vendor() {
        return vendor;
    }
    
    public void vendor(String newVendor) {
        vendor = newVendor;
    }
    
    public boolean vendorPresent() {
        return vendor != null;
    }
    
    public Version version() {
        return version;
    }
    
    public void version(Version newVersion) {
        version = newVersion;
    }
    
    public boolean versionPresent() {
        return version != null;
    }
    
}
