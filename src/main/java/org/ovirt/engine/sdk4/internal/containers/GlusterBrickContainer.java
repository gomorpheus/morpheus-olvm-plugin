/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.util.List;
import org.ovirt.engine.sdk4.types.GlusterBrick;
import org.ovirt.engine.sdk4.types.GlusterBrickStatus;
import org.ovirt.engine.sdk4.types.GlusterVolume;
import org.ovirt.engine.sdk4.types.Statistic;

public class GlusterBrickContainer extends GlusterBrickAdvancedDetailsContainer implements GlusterBrick {
    private String brickDir;
    private String serverId;
    private GlusterBrickStatus status;
    private GlusterVolume glusterVolume;
    private List<Statistic> statistics;
    
    public String brickDir() {
        return brickDir;
    }
    
    public void brickDir(String newBrickDir) {
        brickDir = newBrickDir;
    }
    
    public boolean brickDirPresent() {
        return brickDir != null;
    }
    
    public String serverId() {
        return serverId;
    }
    
    public void serverId(String newServerId) {
        serverId = newServerId;
    }
    
    public boolean serverIdPresent() {
        return serverId != null;
    }
    
    public GlusterBrickStatus status() {
        return status;
    }
    
    public void status(GlusterBrickStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public GlusterVolume glusterVolume() {
        return glusterVolume;
    }
    
    public void glusterVolume(GlusterVolume newGlusterVolume) {
        glusterVolume = newGlusterVolume;
    }
    
    public boolean glusterVolumePresent() {
        return glusterVolume != null;
    }
    
    public List<Statistic> statistics() {
        return makeUnmodifiableList(statistics);
    }
    
    public void statistics(List<Statistic> newStatistics) {
        statistics = makeArrayList(newStatistics);
    }
    
    public boolean statisticsPresent() {
        return statistics != null && !statistics.isEmpty();
    }
    
}
