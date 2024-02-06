/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.HostedEngine;

public class HostedEngineContainer extends Container implements HostedEngine {
    private Boolean active;
    private Boolean configured;
    private Boolean globalMaintenance;
    private Boolean localMaintenance;
    private BigInteger score;
    
    public boolean active() {
        return active;
    }
    
    public void active(boolean newActive) {
        active = Boolean.valueOf(newActive);
    }
    
    public void active(Boolean newActive) {
        active = newActive;
    }
    
    public boolean activePresent() {
        return active != null;
    }
    
    public boolean configured() {
        return configured;
    }
    
    public void configured(boolean newConfigured) {
        configured = Boolean.valueOf(newConfigured);
    }
    
    public void configured(Boolean newConfigured) {
        configured = newConfigured;
    }
    
    public boolean configuredPresent() {
        return configured != null;
    }
    
    public boolean globalMaintenance() {
        return globalMaintenance;
    }
    
    public void globalMaintenance(boolean newGlobalMaintenance) {
        globalMaintenance = Boolean.valueOf(newGlobalMaintenance);
    }
    
    public void globalMaintenance(Boolean newGlobalMaintenance) {
        globalMaintenance = newGlobalMaintenance;
    }
    
    public boolean globalMaintenancePresent() {
        return globalMaintenance != null;
    }
    
    public boolean localMaintenance() {
        return localMaintenance;
    }
    
    public void localMaintenance(boolean newLocalMaintenance) {
        localMaintenance = Boolean.valueOf(newLocalMaintenance);
    }
    
    public void localMaintenance(Boolean newLocalMaintenance) {
        localMaintenance = newLocalMaintenance;
    }
    
    public boolean localMaintenancePresent() {
        return localMaintenance != null;
    }
    
    public BigInteger score() {
        return score;
    }
    
    public Byte scoreAsByte() {
        return asByte("HostedEngine", "score", score);
    }
    
    public Short scoreAsShort() {
        return asShort("HostedEngine", "score", score);
    }
    
    public Integer scoreAsInteger() {
        return asInteger("HostedEngine", "score", score);
    }
    
    public Long scoreAsLong() {
        return asLong("HostedEngine", "score", score);
    }
    
    public void score(BigInteger newScore) {
        score = newScore;
    }
    
    public boolean scorePresent() {
        return score != null;
    }
    
}
