/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.GlusterClientContainer;
import org.ovirt.engine.sdk4.types.GlusterClient;

public class GlusterClientBuilder {
    private BigInteger bytesRead;
    private BigInteger bytesWritten;
    private BigInteger clientPort;
    private String hostName;
    
    public GlusterClientBuilder bytesRead(int newBytesRead) {
        bytesRead = BigInteger.valueOf((long) newBytesRead);
        return this;
    }
    
    public GlusterClientBuilder bytesRead(Integer newBytesRead) {
        if (newBytesRead == null) {
            bytesRead = null;
        }
        else {
            bytesRead = BigInteger.valueOf(newBytesRead.longValue());
        }
        return this;
    }
    
    public GlusterClientBuilder bytesRead(long newBytesRead) {
        bytesRead = BigInteger.valueOf(newBytesRead);
        return this;
    }
    
    public GlusterClientBuilder bytesRead(Long newBytesRead) {
        if (newBytesRead == null) {
            bytesRead = null;
        }
        else {
            bytesRead = BigInteger.valueOf(newBytesRead.longValue());
        }
        return this;
    }
    
    public GlusterClientBuilder bytesRead(BigInteger newBytesRead) {
        bytesRead = newBytesRead;
        return this;
    }
    
    
    public GlusterClientBuilder bytesWritten(int newBytesWritten) {
        bytesWritten = BigInteger.valueOf((long) newBytesWritten);
        return this;
    }
    
    public GlusterClientBuilder bytesWritten(Integer newBytesWritten) {
        if (newBytesWritten == null) {
            bytesWritten = null;
        }
        else {
            bytesWritten = BigInteger.valueOf(newBytesWritten.longValue());
        }
        return this;
    }
    
    public GlusterClientBuilder bytesWritten(long newBytesWritten) {
        bytesWritten = BigInteger.valueOf(newBytesWritten);
        return this;
    }
    
    public GlusterClientBuilder bytesWritten(Long newBytesWritten) {
        if (newBytesWritten == null) {
            bytesWritten = null;
        }
        else {
            bytesWritten = BigInteger.valueOf(newBytesWritten.longValue());
        }
        return this;
    }
    
    public GlusterClientBuilder bytesWritten(BigInteger newBytesWritten) {
        bytesWritten = newBytesWritten;
        return this;
    }
    
    
    public GlusterClientBuilder clientPort(int newClientPort) {
        clientPort = BigInteger.valueOf((long) newClientPort);
        return this;
    }
    
    public GlusterClientBuilder clientPort(Integer newClientPort) {
        if (newClientPort == null) {
            clientPort = null;
        }
        else {
            clientPort = BigInteger.valueOf(newClientPort.longValue());
        }
        return this;
    }
    
    public GlusterClientBuilder clientPort(long newClientPort) {
        clientPort = BigInteger.valueOf(newClientPort);
        return this;
    }
    
    public GlusterClientBuilder clientPort(Long newClientPort) {
        if (newClientPort == null) {
            clientPort = null;
        }
        else {
            clientPort = BigInteger.valueOf(newClientPort.longValue());
        }
        return this;
    }
    
    public GlusterClientBuilder clientPort(BigInteger newClientPort) {
        clientPort = newClientPort;
        return this;
    }
    
    
    public GlusterClientBuilder hostName(String newHostName) {
        hostName = newHostName;
        return this;
    }
    
    
    public GlusterClient build() {
        GlusterClientContainer container = new GlusterClientContainer();
        container.bytesRead(bytesRead);
        container.bytesWritten(bytesWritten);
        container.clientPort(clientPort);
        container.hostName(hostName);
        return container;
    }
}
