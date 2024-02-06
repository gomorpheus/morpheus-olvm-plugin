/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;

public interface ProfileDetail {
    List<BlockStatistic> blockStatistics();
    
    boolean blockStatisticsPresent();
    
    BigInteger duration();
    Byte durationAsByte();
    Short durationAsShort();
    Integer durationAsInteger();
    Long durationAsLong();
    
    boolean durationPresent();
    
    List<FopStatistic> fopStatistics();
    
    boolean fopStatisticsPresent();
    
    String profileType();
    
    boolean profileTypePresent();
    
    List<Statistic> statistics();
    
    boolean statisticsPresent();
    
}
