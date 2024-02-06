/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.TimeZoneContainer;
import org.ovirt.engine.sdk4.types.TimeZone;

public class TimeZoneBuilder {
    private String name;
    private String utcOffset;
    
    public TimeZoneBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public TimeZoneBuilder utcOffset(String newUtcOffset) {
        utcOffset = newUtcOffset;
        return this;
    }
    
    
    public TimeZone build() {
        TimeZoneContainer container = new TimeZoneContainer();
        container.name(name);
        container.utcOffset(utcOffset);
        return container;
    }
}
