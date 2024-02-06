/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

public interface GlusterBrick extends GlusterBrickAdvancedDetails {
    String brickDir();
    
    boolean brickDirPresent();
    
    String serverId();
    
    boolean serverIdPresent();
    
    GlusterBrickStatus status();
    
    boolean statusPresent();
    
    GlusterVolume glusterVolume();
    
    boolean glusterVolumePresent();
    
    List<Statistic> statistics();
    
    boolean statisticsPresent();
    
}
