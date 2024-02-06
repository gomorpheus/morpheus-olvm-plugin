/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.HostedEngineContainer;
import org.ovirt.engine.sdk4.types.HostedEngine;

public class HostedEngineBuilder {
    private Boolean active;
    private Boolean configured;
    private Boolean globalMaintenance;
    private Boolean localMaintenance;
    private BigInteger score;
    
    public HostedEngineBuilder active(boolean newActive) {
        active = Boolean.valueOf(newActive);
        return this;
    }
    
    public HostedEngineBuilder active(Boolean newActive) {
        active = newActive;
        return this;
    }
    
    
    public HostedEngineBuilder configured(boolean newConfigured) {
        configured = Boolean.valueOf(newConfigured);
        return this;
    }
    
    public HostedEngineBuilder configured(Boolean newConfigured) {
        configured = newConfigured;
        return this;
    }
    
    
    public HostedEngineBuilder globalMaintenance(boolean newGlobalMaintenance) {
        globalMaintenance = Boolean.valueOf(newGlobalMaintenance);
        return this;
    }
    
    public HostedEngineBuilder globalMaintenance(Boolean newGlobalMaintenance) {
        globalMaintenance = newGlobalMaintenance;
        return this;
    }
    
    
    public HostedEngineBuilder localMaintenance(boolean newLocalMaintenance) {
        localMaintenance = Boolean.valueOf(newLocalMaintenance);
        return this;
    }
    
    public HostedEngineBuilder localMaintenance(Boolean newLocalMaintenance) {
        localMaintenance = newLocalMaintenance;
        return this;
    }
    
    
    public HostedEngineBuilder score(int newScore) {
        score = BigInteger.valueOf((long) newScore);
        return this;
    }
    
    public HostedEngineBuilder score(Integer newScore) {
        if (newScore == null) {
            score = null;
        }
        else {
            score = BigInteger.valueOf(newScore.longValue());
        }
        return this;
    }
    
    public HostedEngineBuilder score(long newScore) {
        score = BigInteger.valueOf(newScore);
        return this;
    }
    
    public HostedEngineBuilder score(Long newScore) {
        if (newScore == null) {
            score = null;
        }
        else {
            score = BigInteger.valueOf(newScore.longValue());
        }
        return this;
    }
    
    public HostedEngineBuilder score(BigInteger newScore) {
        score = newScore;
        return this;
    }
    
    
    public HostedEngine build() {
        HostedEngineContainer container = new HostedEngineContainer();
        container.active(active);
        container.configured(configured);
        container.globalMaintenance(globalMaintenance);
        container.localMaintenance(localMaintenance);
        container.score(score);
        return container;
    }
}
