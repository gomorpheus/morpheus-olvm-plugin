/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Type representing a cluster fencing policy.
 */
public interface FencingPolicy {
    boolean enabled();
    
    boolean enabledPresent();
    
    SkipIfConnectivityBroken skipIfConnectivityBroken();
    
    boolean skipIfConnectivityBrokenPresent();
    
    boolean skipIfGlusterBricksUp();
    
    boolean skipIfGlusterBricksUpPresent();
    
    boolean skipIfGlusterQuorumNotMet();
    
    boolean skipIfGlusterQuorumNotMetPresent();
    
    SkipIfSdActive skipIfSdActive();
    
    boolean skipIfSdActivePresent();
    
}
