/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.MigrationBandwidthContainer;
import org.ovirt.engine.sdk4.types.MigrationBandwidth;
import org.ovirt.engine.sdk4.types.MigrationBandwidthAssignmentMethod;

public class MigrationBandwidthBuilder {
    private MigrationBandwidthAssignmentMethod assignmentMethod;
    private BigInteger customValue;
    
    public MigrationBandwidthBuilder assignmentMethod(MigrationBandwidthAssignmentMethod newAssignmentMethod) {
        assignmentMethod = newAssignmentMethod;
        return this;
    }
    
    
    public MigrationBandwidthBuilder customValue(int newCustomValue) {
        customValue = BigInteger.valueOf((long) newCustomValue);
        return this;
    }
    
    public MigrationBandwidthBuilder customValue(Integer newCustomValue) {
        if (newCustomValue == null) {
            customValue = null;
        }
        else {
            customValue = BigInteger.valueOf(newCustomValue.longValue());
        }
        return this;
    }
    
    public MigrationBandwidthBuilder customValue(long newCustomValue) {
        customValue = BigInteger.valueOf(newCustomValue);
        return this;
    }
    
    public MigrationBandwidthBuilder customValue(Long newCustomValue) {
        if (newCustomValue == null) {
            customValue = null;
        }
        else {
            customValue = BigInteger.valueOf(newCustomValue.longValue());
        }
        return this;
    }
    
    public MigrationBandwidthBuilder customValue(BigInteger newCustomValue) {
        customValue = newCustomValue;
        return this;
    }
    
    
    public MigrationBandwidth build() {
        MigrationBandwidthContainer container = new MigrationBandwidthContainer();
        container.assignmentMethod(assignmentMethod);
        container.customValue(customValue);
        return container;
    }
}
