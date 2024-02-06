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
import org.ovirt.engine.sdk4.internal.containers.ProfileDetailContainer;
import org.ovirt.engine.sdk4.types.BlockStatistic;
import org.ovirt.engine.sdk4.types.FopStatistic;
import org.ovirt.engine.sdk4.types.ProfileDetail;
import org.ovirt.engine.sdk4.types.Statistic;

public class ProfileDetailBuilder {
    private List<BlockStatistic> blockStatistics;
    private BigInteger duration;
    private List<FopStatistic> fopStatistics;
    private String profileType;
    private List<Statistic> statistics;
    
    public ProfileDetailBuilder blockStatistics(List<BlockStatistic> newBlockStatistics) {
        if (newBlockStatistics != null) {
            if (blockStatistics == null) {
                blockStatistics = new ArrayList<>(newBlockStatistics);
            }
            else {
                blockStatistics.addAll(newBlockStatistics);
            }
        }
        return this;
    }
    
    public ProfileDetailBuilder blockStatistics(BlockStatistic... newBlockStatistics) {
        if (newBlockStatistics != null) {
            if (blockStatistics == null) {
                blockStatistics = new ArrayList<>(newBlockStatistics.length);
            }
            Collections.addAll(blockStatistics, newBlockStatistics);
        }
        return this;
    }
    
    public ProfileDetailBuilder blockStatistics(BlockStatisticBuilder... newBlockStatistics) {
        if (newBlockStatistics != null) {
            if (blockStatistics == null) {
                blockStatistics = new ArrayList<>(newBlockStatistics.length);
            }
            for (BlockStatisticBuilder builder : newBlockStatistics) {
                blockStatistics.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ProfileDetailBuilder duration(int newDuration) {
        duration = BigInteger.valueOf((long) newDuration);
        return this;
    }
    
    public ProfileDetailBuilder duration(Integer newDuration) {
        if (newDuration == null) {
            duration = null;
        }
        else {
            duration = BigInteger.valueOf(newDuration.longValue());
        }
        return this;
    }
    
    public ProfileDetailBuilder duration(long newDuration) {
        duration = BigInteger.valueOf(newDuration);
        return this;
    }
    
    public ProfileDetailBuilder duration(Long newDuration) {
        if (newDuration == null) {
            duration = null;
        }
        else {
            duration = BigInteger.valueOf(newDuration.longValue());
        }
        return this;
    }
    
    public ProfileDetailBuilder duration(BigInteger newDuration) {
        duration = newDuration;
        return this;
    }
    
    
    public ProfileDetailBuilder fopStatistics(List<FopStatistic> newFopStatistics) {
        if (newFopStatistics != null) {
            if (fopStatistics == null) {
                fopStatistics = new ArrayList<>(newFopStatistics);
            }
            else {
                fopStatistics.addAll(newFopStatistics);
            }
        }
        return this;
    }
    
    public ProfileDetailBuilder fopStatistics(FopStatistic... newFopStatistics) {
        if (newFopStatistics != null) {
            if (fopStatistics == null) {
                fopStatistics = new ArrayList<>(newFopStatistics.length);
            }
            Collections.addAll(fopStatistics, newFopStatistics);
        }
        return this;
    }
    
    public ProfileDetailBuilder fopStatistics(FopStatisticBuilder... newFopStatistics) {
        if (newFopStatistics != null) {
            if (fopStatistics == null) {
                fopStatistics = new ArrayList<>(newFopStatistics.length);
            }
            for (FopStatisticBuilder builder : newFopStatistics) {
                fopStatistics.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ProfileDetailBuilder profileType(String newProfileType) {
        profileType = newProfileType;
        return this;
    }
    
    
    public ProfileDetailBuilder statistics(List<Statistic> newStatistics) {
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
    
    public ProfileDetailBuilder statistics(Statistic... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            Collections.addAll(statistics, newStatistics);
        }
        return this;
    }
    
    public ProfileDetailBuilder statistics(StatisticBuilder... newStatistics) {
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
    
    
    public ProfileDetail build() {
        ProfileDetailContainer container = new ProfileDetailContainer();
        container.blockStatistics(blockStatistics);
        container.duration(duration);
        container.fopStatistics(fopStatistics);
        container.profileType(profileType);
        container.statistics(statistics);
        return container;
    }
}
