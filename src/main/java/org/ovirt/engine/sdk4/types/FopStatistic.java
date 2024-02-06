/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

public interface FopStatistic {
    String name();
    
    boolean namePresent();
    
    List<Statistic> statistics();
    
    boolean statisticsPresent();
    
}
