/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Rate;
import org.ovirt.engine.sdk4.types.RngDevice;
import org.ovirt.engine.sdk4.types.RngSource;

public class RngDeviceContainer extends Container implements RngDevice {
    private Rate rate;
    private RngSource source;
    
    public Rate rate() {
        return rate;
    }
    
    public void rate(Rate newRate) {
        rate = newRate;
    }
    
    public boolean ratePresent() {
        return rate != null;
    }
    
    public RngSource source() {
        return source;
    }
    
    public void source(RngSource newSource) {
        source = newSource;
    }
    
    public boolean sourcePresent() {
        return source != null;
    }
    
}
