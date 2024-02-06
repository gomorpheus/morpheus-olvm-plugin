/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.GlusterClient;

public class GlusterClientContainer extends Container implements GlusterClient {
    private BigInteger bytesRead;
    private BigInteger bytesWritten;
    private BigInteger clientPort;
    private String hostName;
    
    public BigInteger bytesRead() {
        return bytesRead;
    }
    
    public Byte bytesReadAsByte() {
        return asByte("GlusterClient", "bytesRead", bytesRead);
    }
    
    public Short bytesReadAsShort() {
        return asShort("GlusterClient", "bytesRead", bytesRead);
    }
    
    public Integer bytesReadAsInteger() {
        return asInteger("GlusterClient", "bytesRead", bytesRead);
    }
    
    public Long bytesReadAsLong() {
        return asLong("GlusterClient", "bytesRead", bytesRead);
    }
    
    public void bytesRead(BigInteger newBytesRead) {
        bytesRead = newBytesRead;
    }
    
    public boolean bytesReadPresent() {
        return bytesRead != null;
    }
    
    public BigInteger bytesWritten() {
        return bytesWritten;
    }
    
    public Byte bytesWrittenAsByte() {
        return asByte("GlusterClient", "bytesWritten", bytesWritten);
    }
    
    public Short bytesWrittenAsShort() {
        return asShort("GlusterClient", "bytesWritten", bytesWritten);
    }
    
    public Integer bytesWrittenAsInteger() {
        return asInteger("GlusterClient", "bytesWritten", bytesWritten);
    }
    
    public Long bytesWrittenAsLong() {
        return asLong("GlusterClient", "bytesWritten", bytesWritten);
    }
    
    public void bytesWritten(BigInteger newBytesWritten) {
        bytesWritten = newBytesWritten;
    }
    
    public boolean bytesWrittenPresent() {
        return bytesWritten != null;
    }
    
    public BigInteger clientPort() {
        return clientPort;
    }
    
    public Byte clientPortAsByte() {
        return asByte("GlusterClient", "clientPort", clientPort);
    }
    
    public Short clientPortAsShort() {
        return asShort("GlusterClient", "clientPort", clientPort);
    }
    
    public Integer clientPortAsInteger() {
        return asInteger("GlusterClient", "clientPort", clientPort);
    }
    
    public Long clientPortAsLong() {
        return asLong("GlusterClient", "clientPort", clientPort);
    }
    
    public void clientPort(BigInteger newClientPort) {
        clientPort = newClientPort;
    }
    
    public boolean clientPortPresent() {
        return clientPort != null;
    }
    
    public String hostName() {
        return hostName;
    }
    
    public void hostName(String newHostName) {
        hostName = newHostName;
    }
    
    public boolean hostNamePresent() {
        return hostName != null;
    }
    
}
