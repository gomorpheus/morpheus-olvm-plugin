/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

/**
 * Defines the bandwidth used by migration.
 */
public interface MigrationBandwidth {
    MigrationBandwidthAssignmentMethod assignmentMethod();
    
    boolean assignmentMethodPresent();
    
    BigInteger customValue();
    Byte customValueAsByte();
    Short customValueAsShort();
    Integer customValueAsInteger();
    Long customValueAsLong();
    
    boolean customValuePresent();
    
}
