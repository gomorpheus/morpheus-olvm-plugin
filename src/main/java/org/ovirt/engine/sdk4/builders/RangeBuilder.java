/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.RangeContainer;
import org.ovirt.engine.sdk4.types.Range;

public class RangeBuilder {
    private String from;
    private String to;
    
    public RangeBuilder from(String newFrom) {
        from = newFrom;
        return this;
    }
    
    
    public RangeBuilder to(String newTo) {
        to = newTo;
        return this;
    }
    
    
    public Range build() {
        RangeContainer container = new RangeContainer();
        container.from(from);
        container.to(to);
        return container;
    }
}
