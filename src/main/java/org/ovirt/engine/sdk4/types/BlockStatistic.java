/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

public interface BlockStatistic {
    List<Statistic> statistics();
    
    boolean statisticsPresent();
    
}
