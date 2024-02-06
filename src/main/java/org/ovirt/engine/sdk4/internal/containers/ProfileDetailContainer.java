/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.BlockStatistic;
import org.ovirt.engine.sdk4.types.FopStatistic;
import org.ovirt.engine.sdk4.types.ProfileDetail;
import org.ovirt.engine.sdk4.types.Statistic;

public class ProfileDetailContainer extends Container implements ProfileDetail {
    private List<BlockStatistic> blockStatistics;
    private BigInteger duration;
    private List<FopStatistic> fopStatistics;
    private String profileType;
    private List<Statistic> statistics;
    
    public List<BlockStatistic> blockStatistics() {
        return makeUnmodifiableList(blockStatistics);
    }
    
    public void blockStatistics(List<BlockStatistic> newBlockStatistics) {
        blockStatistics = makeArrayList(newBlockStatistics);
    }
    
    public boolean blockStatisticsPresent() {
        return blockStatistics != null && !blockStatistics.isEmpty();
    }
    
    public BigInteger duration() {
        return duration;
    }
    
    public Byte durationAsByte() {
        return asByte("ProfileDetail", "duration", duration);
    }
    
    public Short durationAsShort() {
        return asShort("ProfileDetail", "duration", duration);
    }
    
    public Integer durationAsInteger() {
        return asInteger("ProfileDetail", "duration", duration);
    }
    
    public Long durationAsLong() {
        return asLong("ProfileDetail", "duration", duration);
    }
    
    public void duration(BigInteger newDuration) {
        duration = newDuration;
    }
    
    public boolean durationPresent() {
        return duration != null;
    }
    
    public List<FopStatistic> fopStatistics() {
        return makeUnmodifiableList(fopStatistics);
    }
    
    public void fopStatistics(List<FopStatistic> newFopStatistics) {
        fopStatistics = makeArrayList(newFopStatistics);
    }
    
    public boolean fopStatisticsPresent() {
        return fopStatistics != null && !fopStatistics.isEmpty();
    }
    
    public String profileType() {
        return profileType;
    }
    
    public void profileType(String newProfileType) {
        profileType = newProfileType;
    }
    
    public boolean profileTypePresent() {
        return profileType != null;
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
