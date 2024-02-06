/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.Fault;

public class FaultContainer extends Container implements Fault {
    private String detail;
    private String reason;
    
    public String detail() {
        return detail;
    }
    
    public void detail(String newDetail) {
        detail = newDetail;
    }
    
    public boolean detailPresent() {
        return detail != null;
    }
    
    public String reason() {
        return reason;
    }
    
    public void reason(String newReason) {
        reason = newReason;
    }
    
    public boolean reasonPresent() {
        return reason != null;
    }
    
}
