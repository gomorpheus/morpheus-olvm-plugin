/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.GlusterBrick;
import org.ovirt.engine.sdk4.types.GlusterVolume;
import org.ovirt.engine.sdk4.types.GlusterVolumeStatus;
import org.ovirt.engine.sdk4.types.GlusterVolumeType;
import org.ovirt.engine.sdk4.types.Option;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.TransportType;

public class GlusterVolumeContainer extends IdentifiedContainer implements GlusterVolume {
    private BigInteger disperseCount;
    private List<Option> options;
    private BigInteger redundancyCount;
    private BigInteger replicaCount;
    private GlusterVolumeStatus status;
    private BigInteger stripeCount;
    private List<TransportType> transportTypes;
    private GlusterVolumeType volumeType;
    private List<GlusterBrick> bricks;
    private Cluster cluster;
    private List<Statistic> statistics;
    
    public BigInteger disperseCount() {
        return disperseCount;
    }
    
    public Byte disperseCountAsByte() {
        return asByte("GlusterVolume", "disperseCount", disperseCount);
    }
    
    public Short disperseCountAsShort() {
        return asShort("GlusterVolume", "disperseCount", disperseCount);
    }
    
    public Integer disperseCountAsInteger() {
        return asInteger("GlusterVolume", "disperseCount", disperseCount);
    }
    
    public Long disperseCountAsLong() {
        return asLong("GlusterVolume", "disperseCount", disperseCount);
    }
    
    public void disperseCount(BigInteger newDisperseCount) {
        disperseCount = newDisperseCount;
    }
    
    public boolean disperseCountPresent() {
        return disperseCount != null;
    }
    
    public List<Option> options() {
        return makeUnmodifiableList(options);
    }
    
    public void options(List<Option> newOptions) {
        options = makeArrayList(newOptions);
    }
    
    public boolean optionsPresent() {
        return options != null && !options.isEmpty();
    }
    
    public BigInteger redundancyCount() {
        return redundancyCount;
    }
    
    public Byte redundancyCountAsByte() {
        return asByte("GlusterVolume", "redundancyCount", redundancyCount);
    }
    
    public Short redundancyCountAsShort() {
        return asShort("GlusterVolume", "redundancyCount", redundancyCount);
    }
    
    public Integer redundancyCountAsInteger() {
        return asInteger("GlusterVolume", "redundancyCount", redundancyCount);
    }
    
    public Long redundancyCountAsLong() {
        return asLong("GlusterVolume", "redundancyCount", redundancyCount);
    }
    
    public void redundancyCount(BigInteger newRedundancyCount) {
        redundancyCount = newRedundancyCount;
    }
    
    public boolean redundancyCountPresent() {
        return redundancyCount != null;
    }
    
    public BigInteger replicaCount() {
        return replicaCount;
    }
    
    public Byte replicaCountAsByte() {
        return asByte("GlusterVolume", "replicaCount", replicaCount);
    }
    
    public Short replicaCountAsShort() {
        return asShort("GlusterVolume", "replicaCount", replicaCount);
    }
    
    public Integer replicaCountAsInteger() {
        return asInteger("GlusterVolume", "replicaCount", replicaCount);
    }
    
    public Long replicaCountAsLong() {
        return asLong("GlusterVolume", "replicaCount", replicaCount);
    }
    
    public void replicaCount(BigInteger newReplicaCount) {
        replicaCount = newReplicaCount;
    }
    
    public boolean replicaCountPresent() {
        return replicaCount != null;
    }
    
    public GlusterVolumeStatus status() {
        return status;
    }
    
    public void status(GlusterVolumeStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public BigInteger stripeCount() {
        return stripeCount;
    }
    
    public Byte stripeCountAsByte() {
        return asByte("GlusterVolume", "stripeCount", stripeCount);
    }
    
    public Short stripeCountAsShort() {
        return asShort("GlusterVolume", "stripeCount", stripeCount);
    }
    
    public Integer stripeCountAsInteger() {
        return asInteger("GlusterVolume", "stripeCount", stripeCount);
    }
    
    public Long stripeCountAsLong() {
        return asLong("GlusterVolume", "stripeCount", stripeCount);
    }
    
    public void stripeCount(BigInteger newStripeCount) {
        stripeCount = newStripeCount;
    }
    
    public boolean stripeCountPresent() {
        return stripeCount != null;
    }
    
    public List<TransportType> transportTypes() {
        return makeUnmodifiableList(transportTypes);
    }
    
    public void transportTypes(List<TransportType> newTransportTypes) {
        transportTypes = makeArrayList(newTransportTypes);
    }
    
    public boolean transportTypesPresent() {
        return transportTypes != null && !transportTypes.isEmpty();
    }
    
    public GlusterVolumeType volumeType() {
        return volumeType;
    }
    
    public void volumeType(GlusterVolumeType newVolumeType) {
        volumeType = newVolumeType;
    }
    
    public boolean volumeTypePresent() {
        return volumeType != null;
    }
    
    public List<GlusterBrick> bricks() {
        return makeUnmodifiableList(bricks);
    }
    
    public void bricks(List<GlusterBrick> newBricks) {
        bricks = makeArrayList(newBricks);
    }
    
    public boolean bricksPresent() {
        return bricks != null && !bricks.isEmpty();
    }
    
    public Cluster cluster() {
        return cluster;
    }
    
    public void cluster(Cluster newCluster) {
        cluster = newCluster;
    }
    
    public boolean clusterPresent() {
        return cluster != null;
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
