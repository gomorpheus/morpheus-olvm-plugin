/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;
import java.util.List;

public interface GlusterVolume extends Identified {
    BigInteger disperseCount();
    Byte disperseCountAsByte();
    Short disperseCountAsShort();
    Integer disperseCountAsInteger();
    Long disperseCountAsLong();
    
    boolean disperseCountPresent();
    
    List<Option> options();
    
    boolean optionsPresent();
    
    BigInteger redundancyCount();
    Byte redundancyCountAsByte();
    Short redundancyCountAsShort();
    Integer redundancyCountAsInteger();
    Long redundancyCountAsLong();
    
    boolean redundancyCountPresent();
    
    BigInteger replicaCount();
    Byte replicaCountAsByte();
    Short replicaCountAsShort();
    Integer replicaCountAsInteger();
    Long replicaCountAsLong();
    
    boolean replicaCountPresent();
    
    GlusterVolumeStatus status();
    
    boolean statusPresent();
    
    BigInteger stripeCount();
    Byte stripeCountAsByte();
    Short stripeCountAsShort();
    Integer stripeCountAsInteger();
    Long stripeCountAsLong();
    
    boolean stripeCountPresent();
    
    List<TransportType> transportTypes();
    
    boolean transportTypesPresent();
    
    GlusterVolumeType volumeType();
    
    boolean volumeTypePresent();
    
    List<GlusterBrick> bricks();
    
    boolean bricksPresent();
    
    Cluster cluster();
    
    boolean clusterPresent();
    
    List<Statistic> statistics();
    
    boolean statisticsPresent();
    
}
