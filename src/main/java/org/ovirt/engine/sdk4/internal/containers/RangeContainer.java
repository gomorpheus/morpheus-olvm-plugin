/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.Range;

public class RangeContainer extends Container implements Range {
    private String from;
    private String to;
    
    public String from() {
        return from;
    }
    
    public void from(String newFrom) {
        from = newFrom;
    }
    
    public boolean fromPresent() {
        return from != null;
    }
    
    public String to() {
        return to;
    }
    
    public void to(String newTo) {
        to = newTo;
    }
    
    public boolean toPresent() {
        return to != null;
    }
    
}
