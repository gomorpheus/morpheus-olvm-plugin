/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.services.MeasurableService;
import org.ovirt.engine.sdk4.services.StatisticsService;

public class MeasurableServiceImpl extends ServiceImpl implements MeasurableService {
    
    public MeasurableServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    public StatisticsService statisticsService() {
        return new StatisticsServiceImpl(getConnection(), getPath() + "/statistics");
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        if (path.equals("statistics")) {
            return statisticsService();
        }
        if (path.startsWith("statistics/")) {
            return statisticsService().service(path.substring(11));
        }
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "MeasurableService:" + getPath();
    }
    
}

