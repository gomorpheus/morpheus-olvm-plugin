/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

/**
 * Type representing a Virtual LAN (VLAN) type.
 */
public interface Vlan {
    BigInteger id();
    Byte idAsByte();
    Short idAsShort();
    Integer idAsInteger();
    Long idAsLong();
    
    boolean idPresent();
    
}
