/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.MigrationBandwidth;
import org.ovirt.engine.sdk4.types.MigrationBandwidthAssignmentMethod;

public class MigrationBandwidthContainer extends Container implements MigrationBandwidth {
    private MigrationBandwidthAssignmentMethod assignmentMethod;
    private BigInteger customValue;
    
    public MigrationBandwidthAssignmentMethod assignmentMethod() {
        return assignmentMethod;
    }
    
    public void assignmentMethod(MigrationBandwidthAssignmentMethod newAssignmentMethod) {
        assignmentMethod = newAssignmentMethod;
    }
    
    public boolean assignmentMethodPresent() {
        return assignmentMethod != null;
    }
    
    public BigInteger customValue() {
        return customValue;
    }
    
    public Byte customValueAsByte() {
        return asByte("MigrationBandwidth", "customValue", customValue);
    }
    
    public Short customValueAsShort() {
        return asShort("MigrationBandwidth", "customValue", customValue);
    }
    
    public Integer customValueAsInteger() {
        return asInteger("MigrationBandwidth", "customValue", customValue);
    }
    
    public Long customValueAsLong() {
        return asLong("MigrationBandwidth", "customValue", customValue);
    }
    
    public void customValue(BigInteger newCustomValue) {
        customValue = newCustomValue;
    }
    
    public boolean customValuePresent() {
        return customValue != null;
    }
    
}
