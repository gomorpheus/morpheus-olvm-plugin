/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.util.List;
import org.ovirt.engine.sdk4.types.HardwareInformation;
import org.ovirt.engine.sdk4.types.RngSource;

public class HardwareInformationContainer extends Container implements HardwareInformation {
    private String family;
    private String manufacturer;
    private String productName;
    private String serialNumber;
    private List<RngSource> supportedRngSources;
    private String uuid;
    private String version;
    
    public String family() {
        return family;
    }
    
    public void family(String newFamily) {
        family = newFamily;
    }
    
    public boolean familyPresent() {
        return family != null;
    }
    
    public String manufacturer() {
        return manufacturer;
    }
    
    public void manufacturer(String newManufacturer) {
        manufacturer = newManufacturer;
    }
    
    public boolean manufacturerPresent() {
        return manufacturer != null;
    }
    
    public String productName() {
        return productName;
    }
    
    public void productName(String newProductName) {
        productName = newProductName;
    }
    
    public boolean productNamePresent() {
        return productName != null;
    }
    
    public String serialNumber() {
        return serialNumber;
    }
    
    public void serialNumber(String newSerialNumber) {
        serialNumber = newSerialNumber;
    }
    
    public boolean serialNumberPresent() {
        return serialNumber != null;
    }
    
    public List<RngSource> supportedRngSources() {
        return makeUnmodifiableList(supportedRngSources);
    }
    
    public void supportedRngSources(List<RngSource> newSupportedRngSources) {
        supportedRngSources = makeArrayList(newSupportedRngSources);
    }
    
    public boolean supportedRngSourcesPresent() {
        return supportedRngSources != null && !supportedRngSources.isEmpty();
    }
    
    public String uuid() {
        return uuid;
    }
    
    public void uuid(String newUuid) {
        uuid = newUuid;
    }
    
    public boolean uuidPresent() {
        return uuid != null;
    }
    
    public String version() {
        return version;
    }
    
    public void version(String newVersion) {
        version = newVersion;
    }
    
    public boolean versionPresent() {
        return version != null;
    }
    
}
