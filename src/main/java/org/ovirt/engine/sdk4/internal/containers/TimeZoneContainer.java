/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.TimeZone;

public class TimeZoneContainer extends Container implements TimeZone {
    private String name;
    private String utcOffset;
    
    public String name() {
        return name;
    }
    
    public void name(String newName) {
        name = newName;
    }
    
    public boolean namePresent() {
        return name != null;
    }
    
    public String utcOffset() {
        return utcOffset;
    }
    
    public void utcOffset(String newUtcOffset) {
        utcOffset = newUtcOffset;
    }
    
    public boolean utcOffsetPresent() {
        return utcOffset != null;
    }
    
}
