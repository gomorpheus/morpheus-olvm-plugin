/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.internal.containers.FencingPolicyContainer;
import org.ovirt.engine.sdk4.types.FencingPolicy;
import org.ovirt.engine.sdk4.types.SkipIfConnectivityBroken;
import org.ovirt.engine.sdk4.types.SkipIfSdActive;

public class FencingPolicyBuilder {
    private Boolean enabled;
    private SkipIfConnectivityBroken skipIfConnectivityBroken;
    private Boolean skipIfGlusterBricksUp;
    private Boolean skipIfGlusterQuorumNotMet;
    private SkipIfSdActive skipIfSdActive;
    
    public FencingPolicyBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public FencingPolicyBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public FencingPolicyBuilder skipIfConnectivityBroken(SkipIfConnectivityBroken newSkipIfConnectivityBroken) {
        skipIfConnectivityBroken = newSkipIfConnectivityBroken;
        return this;
    }
    
    public FencingPolicyBuilder skipIfConnectivityBroken(SkipIfConnectivityBrokenBuilder newSkipIfConnectivityBroken) {
        if (newSkipIfConnectivityBroken == null) {
            skipIfConnectivityBroken = null;
        }
        else {
            skipIfConnectivityBroken = newSkipIfConnectivityBroken.build();
        }
        return this;
    }
    
    
    public FencingPolicyBuilder skipIfGlusterBricksUp(boolean newSkipIfGlusterBricksUp) {
        skipIfGlusterBricksUp = Boolean.valueOf(newSkipIfGlusterBricksUp);
        return this;
    }
    
    public FencingPolicyBuilder skipIfGlusterBricksUp(Boolean newSkipIfGlusterBricksUp) {
        skipIfGlusterBricksUp = newSkipIfGlusterBricksUp;
        return this;
    }
    
    
    public FencingPolicyBuilder skipIfGlusterQuorumNotMet(boolean newSkipIfGlusterQuorumNotMet) {
        skipIfGlusterQuorumNotMet = Boolean.valueOf(newSkipIfGlusterQuorumNotMet);
        return this;
    }
    
    public FencingPolicyBuilder skipIfGlusterQuorumNotMet(Boolean newSkipIfGlusterQuorumNotMet) {
        skipIfGlusterQuorumNotMet = newSkipIfGlusterQuorumNotMet;
        return this;
    }
    
    
    public FencingPolicyBuilder skipIfSdActive(SkipIfSdActive newSkipIfSdActive) {
        skipIfSdActive = newSkipIfSdActive;
        return this;
    }
    
    public FencingPolicyBuilder skipIfSdActive(SkipIfSdActiveBuilder newSkipIfSdActive) {
        if (newSkipIfSdActive == null) {
            skipIfSdActive = null;
        }
        else {
            skipIfSdActive = newSkipIfSdActive.build();
        }
        return this;
    }
    
    
    public FencingPolicy build() {
        FencingPolicyContainer container = new FencingPolicyContainer();
        container.enabled(enabled);
        container.skipIfConnectivityBroken(skipIfConnectivityBroken);
        container.skipIfGlusterBricksUp(skipIfGlusterBricksUp);
        container.skipIfGlusterQuorumNotMet(skipIfGlusterQuorumNotMet);
        container.skipIfSdActive(skipIfSdActive);
        return container;
    }
}
