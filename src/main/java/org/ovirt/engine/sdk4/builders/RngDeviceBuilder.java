/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.RngDeviceContainer;
import org.ovirt.engine.sdk4.types.Rate;
import org.ovirt.engine.sdk4.types.RngDevice;
import org.ovirt.engine.sdk4.types.RngSource;

public class RngDeviceBuilder {
    private Rate rate;
    private RngSource source;
    
    public RngDeviceBuilder rate(Rate newRate) {
        rate = newRate;
        return this;
    }
    
    public RngDeviceBuilder rate(RateBuilder newRate) {
        if (newRate == null) {
            rate = null;
        }
        else {
            rate = newRate.build();
        }
        return this;
    }
    
    
    public RngDeviceBuilder source(RngSource newSource) {
        source = newSource;
        return this;
    }
    
    
    public RngDevice build() {
        RngDeviceContainer container = new RngDeviceContainer();
        container.rate(rate);
        container.source(source);
        return container;
    }
}
