/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.MigrationOptionsContainer;
import org.ovirt.engine.sdk4.types.InheritableBoolean;
import org.ovirt.engine.sdk4.types.MigrationBandwidth;
import org.ovirt.engine.sdk4.types.MigrationOptions;
import org.ovirt.engine.sdk4.types.MigrationPolicy;

public class MigrationOptionsBuilder {
    private InheritableBoolean autoConverge;
    private MigrationBandwidth bandwidth;
    private InheritableBoolean compressed;
    private InheritableBoolean encrypted;
    private MigrationPolicy policy;
    
    public MigrationOptionsBuilder autoConverge(InheritableBoolean newAutoConverge) {
        autoConverge = newAutoConverge;
        return this;
    }
    
    
    public MigrationOptionsBuilder bandwidth(MigrationBandwidth newBandwidth) {
        bandwidth = newBandwidth;
        return this;
    }
    
    public MigrationOptionsBuilder bandwidth(MigrationBandwidthBuilder newBandwidth) {
        if (newBandwidth == null) {
            bandwidth = null;
        }
        else {
            bandwidth = newBandwidth.build();
        }
        return this;
    }
    
    
    public MigrationOptionsBuilder compressed(InheritableBoolean newCompressed) {
        compressed = newCompressed;
        return this;
    }
    
    
    public MigrationOptionsBuilder encrypted(InheritableBoolean newEncrypted) {
        encrypted = newEncrypted;
        return this;
    }
    
    
    public MigrationOptionsBuilder policy(MigrationPolicy newPolicy) {
        policy = newPolicy;
        return this;
    }
    
    public MigrationOptionsBuilder policy(MigrationPolicyBuilder newPolicy) {
        if (newPolicy == null) {
            policy = null;
        }
        else {
            policy = newPolicy.build();
        }
        return this;
    }
    
    
    public MigrationOptions build() {
        MigrationOptionsContainer container = new MigrationOptionsContainer();
        container.autoConverge(autoConverge);
        container.bandwidth(bandwidth);
        container.compressed(compressed);
        container.encrypted(encrypted);
        container.policy(policy);
        return container;
    }
}
