/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Watchdog;
import org.ovirt.engine.sdk4.types.WatchdogAction;
import org.ovirt.engine.sdk4.types.WatchdogModel;

public class WatchdogContainer extends DeviceContainer implements Watchdog {
    private WatchdogAction action;
    private WatchdogModel model;
    
    public WatchdogAction action() {
        return action;
    }
    
    public void action(WatchdogAction newAction) {
        action = newAction;
    }
    
    public boolean actionPresent() {
        return action != null;
    }
    
    public WatchdogModel model() {
        return model;
    }
    
    public void model(WatchdogModel newModel) {
        model = newModel;
    }
    
    public boolean modelPresent() {
        return model != null;
    }
    
}
