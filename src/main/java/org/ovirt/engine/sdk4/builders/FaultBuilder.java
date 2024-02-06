/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.FaultContainer;
import org.ovirt.engine.sdk4.types.Fault;

public class FaultBuilder {
    private String detail;
    private String reason;
    
    public FaultBuilder detail(String newDetail) {
        detail = newDetail;
        return this;
    }
    
    
    public FaultBuilder reason(String newReason) {
        reason = newReason;
        return this;
    }
    
    
    public Fault build() {
        FaultContainer container = new FaultContainer();
        container.detail(detail);
        container.reason(reason);
        return container;
    }
}
