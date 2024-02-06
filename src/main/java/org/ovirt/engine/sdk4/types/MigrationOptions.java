/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * The type for migration options.
 */
public interface MigrationOptions {
    InheritableBoolean autoConverge();
    
    boolean autoConvergePresent();
    
    MigrationBandwidth bandwidth();
    
    boolean bandwidthPresent();
    
    InheritableBoolean compressed();
    
    boolean compressedPresent();
    
    InheritableBoolean encrypted();
    
    boolean encryptedPresent();
    
    MigrationPolicy policy();
    
    boolean policyPresent();
    
}
