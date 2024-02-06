/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.FopStatisticContainer;
import org.ovirt.engine.sdk4.types.FopStatistic;
import org.ovirt.engine.sdk4.types.Statistic;

public class FopStatisticBuilder {
    private String name;
    private List<Statistic> statistics;
    
    public FopStatisticBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public FopStatisticBuilder statistics(List<Statistic> newStatistics) {
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
    
    public FopStatisticBuilder statistics(Statistic... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            Collections.addAll(statistics, newStatistics);
        }
        return this;
    }
    
    public FopStatisticBuilder statistics(StatisticBuilder... newStatistics) {
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
    
    
    public FopStatistic build() {
        FopStatisticContainer container = new FopStatisticContainer();
        container.name(name);
        container.statistics(statistics);
        return container;
    }
}
