/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.types.FencingPolicy;
import org.ovirt.engine.sdk4.types.SkipIfConnectivityBroken;
import org.ovirt.engine.sdk4.types.SkipIfSdActive;

public class FencingPolicyContainer extends Container implements FencingPolicy {
    private Boolean enabled;
    private SkipIfConnectivityBroken skipIfConnectivityBroken;
    private Boolean skipIfGlusterBricksUp;
    private Boolean skipIfGlusterQuorumNotMet;
    private SkipIfSdActive skipIfSdActive;
    
    public boolean enabled() {
        return enabled;
    }
    
    public void enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
    }
    
    public void enabled(Boolean newEnabled) {
        enabled = newEnabled;
    }
    
    public boolean enabledPresent() {
        return enabled != null;
    }
    
    public SkipIfConnectivityBroken skipIfConnectivityBroken() {
        return skipIfConnectivityBroken;
    }
    
    public void skipIfConnectivityBroken(SkipIfConnectivityBroken newSkipIfConnectivityBroken) {
        skipIfConnectivityBroken = newSkipIfConnectivityBroken;
    }
    
    public boolean skipIfConnectivityBrokenPresent() {
        return skipIfConnectivityBroken != null;
    }
    
    public boolean skipIfGlusterBricksUp() {
        return skipIfGlusterBricksUp;
    }
    
    public void skipIfGlusterBricksUp(boolean newSkipIfGlusterBricksUp) {
        skipIfGlusterBricksUp = Boolean.valueOf(newSkipIfGlusterBricksUp);
    }
    
    public void skipIfGlusterBricksUp(Boolean newSkipIfGlusterBricksUp) {
        skipIfGlusterBricksUp = newSkipIfGlusterBricksUp;
    }
    
    public boolean skipIfGlusterBricksUpPresent() {
        return skipIfGlusterBricksUp != null;
    }
    
    public boolean skipIfGlusterQuorumNotMet() {
        return skipIfGlusterQuorumNotMet;
    }
    
    public void skipIfGlusterQuorumNotMet(boolean newSkipIfGlusterQuorumNotMet) {
        skipIfGlusterQuorumNotMet = Boolean.valueOf(newSkipIfGlusterQuorumNotMet);
    }
    
    public void skipIfGlusterQuorumNotMet(Boolean newSkipIfGlusterQuorumNotMet) {
        skipIfGlusterQuorumNotMet = newSkipIfGlusterQuorumNotMet;
    }
    
    public boolean skipIfGlusterQuorumNotMetPresent() {
        return skipIfGlusterQuorumNotMet != null;
    }
    
    public SkipIfSdActive skipIfSdActive() {
        return skipIfSdActive;
    }
    
    public void skipIfSdActive(SkipIfSdActive newSkipIfSdActive) {
        skipIfSdActive = newSkipIfSdActive;
    }
    
    public boolean skipIfSdActivePresent() {
        return skipIfSdActive != null;
    }
    
}
