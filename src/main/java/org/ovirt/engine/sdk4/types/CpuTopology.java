/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;

public interface CpuTopology {
    BigInteger cores();
    Byte coresAsByte();
    Short coresAsShort();
    Integer coresAsInteger();
    Long coresAsLong();
    
    boolean coresPresent();
    
    BigInteger sockets();
    Byte socketsAsByte();
    Short socketsAsShort();
    Integer socketsAsInteger();
    Long socketsAsLong();
    
    boolean socketsPresent();
    
    BigInteger threads();
    Byte threadsAsByte();
    Short threadsAsShort();
    Integer threadsAsInteger();
    Long threadsAsLong();
    
    boolean threadsPresent();
    
}
