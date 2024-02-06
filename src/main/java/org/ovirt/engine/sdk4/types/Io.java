/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

public interface Io {
    BigInteger threads();
    Byte threadsAsByte();
    Short threadsAsShort();
    Integer threadsAsInteger();
    Long threadsAsLong();
    
    boolean threadsPresent();
    
}
