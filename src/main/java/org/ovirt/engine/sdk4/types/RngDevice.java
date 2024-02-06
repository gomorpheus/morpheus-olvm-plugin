/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Random number generator (RNG) device model.
 */
public interface RngDevice {
    Rate rate();
    
    boolean ratePresent();
    
    RngSource source();
    
    boolean sourcePresent();
    
}
