/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

public interface GlusterVolumeProfileDetails extends Identified {
    List<BrickProfileDetail> brickProfileDetails();
    
    boolean brickProfileDetailsPresent();
    
    List<NfsProfileDetail> nfsProfileDetails();
    
    boolean nfsProfileDetailsPresent();
    
}
