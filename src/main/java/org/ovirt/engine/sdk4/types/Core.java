/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

public interface Core {
    BigInteger index();
    Byte indexAsByte();
    Short indexAsShort();
    Integer indexAsInteger();
    Long indexAsLong();
    
    boolean indexPresent();
    
    BigInteger socket();
    Byte socketAsByte();
    Short socketAsShort();
    Integer socketAsInteger();
    Long socketAsLong();
    
    boolean socketPresent();
    
}
