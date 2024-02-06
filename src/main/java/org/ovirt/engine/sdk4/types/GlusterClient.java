/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

public interface GlusterClient {
    BigInteger bytesRead();
    Byte bytesReadAsByte();
    Short bytesReadAsShort();
    Integer bytesReadAsInteger();
    Long bytesReadAsLong();
    
    boolean bytesReadPresent();
    
    BigInteger bytesWritten();
    Byte bytesWrittenAsByte();
    Short bytesWrittenAsShort();
    Integer bytesWrittenAsInteger();
    Long bytesWrittenAsLong();
    
    boolean bytesWrittenPresent();
    
    BigInteger clientPort();
    Byte clientPortAsByte();
    Short clientPortAsShort();
    Integer clientPortAsInteger();
    Long clientPortAsLong();
    
    boolean clientPortPresent();
    
    String hostName();
    
    boolean hostNamePresent();
    
}
