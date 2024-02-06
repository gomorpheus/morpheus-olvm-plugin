/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.InheritableBoolean;
import org.ovirt.engine.sdk4.types.MigrationBandwidth;
import org.ovirt.engine.sdk4.types.MigrationOptions;
import org.ovirt.engine.sdk4.types.MigrationPolicy;

public class MigrationOptionsContainer extends Container implements MigrationOptions {
    private InheritableBoolean autoConverge;
    private MigrationBandwidth bandwidth;
    private InheritableBoolean compressed;
    private InheritableBoolean encrypted;
    private MigrationPolicy policy;
    
    public InheritableBoolean autoConverge() {
        return autoConverge;
    }
    
    public void autoConverge(InheritableBoolean newAutoConverge) {
        autoConverge = newAutoConverge;
    }
    
    public boolean autoConvergePresent() {
        return autoConverge != null;
    }
    
    public MigrationBandwidth bandwidth() {
        return bandwidth;
    }
    
    public void bandwidth(MigrationBandwidth newBandwidth) {
        bandwidth = newBandwidth;
    }
    
    public boolean bandwidthPresent() {
        return bandwidth != null;
    }
    
    public InheritableBoolean compressed() {
        return compressed;
    }
    
    public void compressed(InheritableBoolean newCompressed) {
        compressed = newCompressed;
    }
    
    public boolean compressedPresent() {
        return compressed != null;
    }
    
    public InheritableBoolean encrypted() {
        return encrypted;
    }
    
    public void encrypted(InheritableBoolean newEncrypted) {
        encrypted = newEncrypted;
    }
    
    public boolean encryptedPresent() {
        return encrypted != null;
    }
    
    public MigrationPolicy policy() {
        return policy;
    }
    
    public void policy(MigrationPolicy newPolicy) {
        policy = newPolicy;
    }
    
    public boolean policyPresent() {
        return policy != null;
    }
    
}
