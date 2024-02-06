/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.HardwareInformationContainer;
import org.ovirt.engine.sdk4.types.HardwareInformation;
import org.ovirt.engine.sdk4.types.RngSource;

public class HardwareInformationBuilder {
    private String family;
    private String manufacturer;
    private String productName;
    private String serialNumber;
    private List<RngSource> supportedRngSources;
    private String uuid;
    private String version;
    
    public HardwareInformationBuilder family(String newFamily) {
        family = newFamily;
        return this;
    }
    
    
    public HardwareInformationBuilder manufacturer(String newManufacturer) {
        manufacturer = newManufacturer;
        return this;
    }
    
    
    public HardwareInformationBuilder productName(String newProductName) {
        productName = newProductName;
        return this;
    }
    
    
    public HardwareInformationBuilder serialNumber(String newSerialNumber) {
        serialNumber = newSerialNumber;
        return this;
    }
    
    
    public HardwareInformationBuilder supportedRngSources(List<RngSource> newSupportedRngSources) {
        if (newSupportedRngSources != null) {
            if (supportedRngSources == null) {
                supportedRngSources = new ArrayList<>(newSupportedRngSources);
            }
            else {
                supportedRngSources.addAll(newSupportedRngSources);
            }
        }
        return this;
    }
    
    public HardwareInformationBuilder supportedRngSources(RngSource... newSupportedRngSources) {
        if (newSupportedRngSources != null) {
            if (supportedRngSources == null) {
                supportedRngSources = new ArrayList<>(newSupportedRngSources.length);
            }
            Collections.addAll(supportedRngSources, newSupportedRngSources);
        }
        return this;
    }
    
    
    public HardwareInformationBuilder uuid(String newUuid) {
        uuid = newUuid;
        return this;
    }
    
    
    public HardwareInformationBuilder version(String newVersion) {
        version = newVersion;
        return this;
    }
    
    
    public HardwareInformation build() {
        HardwareInformationContainer container = new HardwareInformationContainer();
        container.family(family);
        container.manufacturer(manufacturer);
        container.productName(productName);
        container.serialNumber(serialNumber);
        container.supportedRngSources(supportedRngSources);
        container.uuid(uuid);
        container.version(version);
        return container;
    }
}
