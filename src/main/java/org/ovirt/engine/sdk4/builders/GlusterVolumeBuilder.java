/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.GlusterVolumeContainer;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.GlusterBrick;
import org.ovirt.engine.sdk4.types.GlusterVolume;
import org.ovirt.engine.sdk4.types.GlusterVolumeStatus;
import org.ovirt.engine.sdk4.types.GlusterVolumeType;
import org.ovirt.engine.sdk4.types.Option;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.TransportType;

public class GlusterVolumeBuilder {
    private List<GlusterBrick> bricks;
    private Cluster cluster;
    private String comment;
    private String description;
    private BigInteger disperseCount;
    private String href;
    private String id;
    private String name;
    private List<Option> options;
    private BigInteger redundancyCount;
    private BigInteger replicaCount;
    private List<Statistic> statistics;
    private GlusterVolumeStatus status;
    private BigInteger stripeCount;
    private List<TransportType> transportTypes;
    private GlusterVolumeType volumeType;
    
    public GlusterVolumeBuilder bricks(List<GlusterBrick> newBricks) {
        if (newBricks != null) {
            if (bricks == null) {
                bricks = new ArrayList<>(newBricks);
            }
            else {
                bricks.addAll(newBricks);
            }
        }
        return this;
    }
    
    public GlusterVolumeBuilder bricks(GlusterBrick... newBricks) {
        if (newBricks != null) {
            if (bricks == null) {
                bricks = new ArrayList<>(newBricks.length);
            }
            Collections.addAll(bricks, newBricks);
        }
        return this;
    }
    
    public GlusterVolumeBuilder bricks(GlusterBrickBuilder... newBricks) {
        if (newBricks != null) {
            if (bricks == null) {
                bricks = new ArrayList<>(newBricks.length);
            }
            for (GlusterBrickBuilder builder : newBricks) {
                bricks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public GlusterVolumeBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public GlusterVolumeBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public GlusterVolumeBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public GlusterVolumeBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public GlusterVolumeBuilder disperseCount(int newDisperseCount) {
        disperseCount = BigInteger.valueOf((long) newDisperseCount);
        return this;
    }
    
    public GlusterVolumeBuilder disperseCount(Integer newDisperseCount) {
        if (newDisperseCount == null) {
            disperseCount = null;
        }
        else {
            disperseCount = BigInteger.valueOf(newDisperseCount.longValue());
        }
        return this;
    }
    
    public GlusterVolumeBuilder disperseCount(long newDisperseCount) {
        disperseCount = BigInteger.valueOf(newDisperseCount);
        return this;
    }
    
    public GlusterVolumeBuilder disperseCount(Long newDisperseCount) {
        if (newDisperseCount == null) {
            disperseCount = null;
        }
        else {
            disperseCount = BigInteger.valueOf(newDisperseCount.longValue());
        }
        return this;
    }
    
    public GlusterVolumeBuilder disperseCount(BigInteger newDisperseCount) {
        disperseCount = newDisperseCount;
        return this;
    }
    
    
    public GlusterVolumeBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public GlusterVolumeBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public GlusterVolumeBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public GlusterVolumeBuilder options(List<Option> newOptions) {
        if (newOptions != null) {
            if (options == null) {
                options = new ArrayList<>(newOptions);
            }
            else {
                options.addAll(newOptions);
            }
        }
        return this;
    }
    
    public GlusterVolumeBuilder options(Option... newOptions) {
        if (newOptions != null) {
            if (options == null) {
                options = new ArrayList<>(newOptions.length);
            }
            Collections.addAll(options, newOptions);
        }
        return this;
    }
    
    public GlusterVolumeBuilder options(OptionBuilder... newOptions) {
        if (newOptions != null) {
            if (options == null) {
                options = new ArrayList<>(newOptions.length);
            }
            for (OptionBuilder builder : newOptions) {
                options.add(builder.build());
            }
        }
        return this;
    }
    
    
    public GlusterVolumeBuilder redundancyCount(int newRedundancyCount) {
        redundancyCount = BigInteger.valueOf((long) newRedundancyCount);
        return this;
    }
    
    public GlusterVolumeBuilder redundancyCount(Integer newRedundancyCount) {
        if (newRedundancyCount == null) {
            redundancyCount = null;
        }
        else {
            redundancyCount = BigInteger.valueOf(newRedundancyCount.longValue());
        }
        return this;
    }
    
    public GlusterVolumeBuilder redundancyCount(long newRedundancyCount) {
        redundancyCount = BigInteger.valueOf(newRedundancyCount);
        return this;
    }
    
    public GlusterVolumeBuilder redundancyCount(Long newRedundancyCount) {
        if (newRedundancyCount == null) {
            redundancyCount = null;
        }
        else {
            redundancyCount = BigInteger.valueOf(newRedundancyCount.longValue());
        }
        return this;
    }
    
    public GlusterVolumeBuilder redundancyCount(BigInteger newRedundancyCount) {
        redundancyCount = newRedundancyCount;
        return this;
    }
    
    
    public GlusterVolumeBuilder replicaCount(int newReplicaCount) {
        replicaCount = BigInteger.valueOf((long) newReplicaCount);
        return this;
    }
    
    public GlusterVolumeBuilder replicaCount(Integer newReplicaCount) {
        if (newReplicaCount == null) {
            replicaCount = null;
        }
        else {
            replicaCount = BigInteger.valueOf(newReplicaCount.longValue());
        }
        return this;
    }
    
    public GlusterVolumeBuilder replicaCount(long newReplicaCount) {
        replicaCount = BigInteger.valueOf(newReplicaCount);
        return this;
    }
    
    public GlusterVolumeBuilder replicaCount(Long newReplicaCount) {
        if (newReplicaCount == null) {
            replicaCount = null;
        }
        else {
            replicaCount = BigInteger.valueOf(newReplicaCount.longValue());
        }
        return this;
    }
    
    public GlusterVolumeBuilder replicaCount(BigInteger newReplicaCount) {
        replicaCount = newReplicaCount;
        return this;
    }
    
    
    public GlusterVolumeBuilder statistics(List<Statistic> newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics);
            }
            else {
                statistics.addAll(newStatistics);
            }
        }
        return this;
    }
    
    public GlusterVolumeBuilder statistics(Statistic... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            Collections.addAll(statistics, newStatistics);
        }
        return this;
    }
    
    public GlusterVolumeBuilder statistics(StatisticBuilder... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            for (StatisticBuilder builder : newStatistics) {
                statistics.add(builder.build());
            }
        }
        return this;
    }
    
    
    public GlusterVolumeBuilder status(GlusterVolumeStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public GlusterVolumeBuilder stripeCount(int newStripeCount) {
        stripeCount = BigInteger.valueOf((long) newStripeCount);
        return this;
    }
    
    public GlusterVolumeBuilder stripeCount(Integer newStripeCount) {
        if (newStripeCount == null) {
            stripeCount = null;
        }
        else {
            stripeCount = BigInteger.valueOf(newStripeCount.longValue());
        }
        return this;
    }
    
    public GlusterVolumeBuilder stripeCount(long newStripeCount) {
        stripeCount = BigInteger.valueOf(newStripeCount);
        return this;
    }
    
    public GlusterVolumeBuilder stripeCount(Long newStripeCount) {
        if (newStripeCount == null) {
            stripeCount = null;
        }
        else {
            stripeCount = BigInteger.valueOf(newStripeCount.longValue());
        }
        return this;
    }
    
    public GlusterVolumeBuilder stripeCount(BigInteger newStripeCount) {
        stripeCount = newStripeCount;
        return this;
    }
    
    
    public GlusterVolumeBuilder transportTypes(List<TransportType> newTransportTypes) {
        if (newTransportTypes != null) {
            if (transportTypes == null) {
                transportTypes = new ArrayList<>(newTransportTypes);
            }
            else {
                transportTypes.addAll(newTransportTypes);
            }
        }
        return this;
    }
    
    public GlusterVolumeBuilder transportTypes(TransportType... newTransportTypes) {
        if (newTransportTypes != null) {
            if (transportTypes == null) {
                transportTypes = new ArrayList<>(newTransportTypes.length);
            }
            Collections.addAll(transportTypes, newTransportTypes);
        }
        return this;
    }
    
    
    public GlusterVolumeBuilder volumeType(GlusterVolumeType newVolumeType) {
        volumeType = newVolumeType;
        return this;
    }
    
    
    public GlusterVolume build() {
        GlusterVolumeContainer container = new GlusterVolumeContainer();
        container.bricks(bricks);
        container.cluster(cluster);
        container.comment(comment);
        container.description(description);
        container.disperseCount(disperseCount);
        container.href(href);
        container.id(id);
        container.name(name);
        container.options(options);
        container.redundancyCount(redundancyCount);
        container.replicaCount(replicaCount);
        container.statistics(statistics);
        container.status(status);
        container.stripeCount(stripeCount);
        container.transportTypes(transportTypes);
        container.volumeType(volumeType);
        return container;
    }
}
