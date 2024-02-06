/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.DisplayContainer;
import org.ovirt.engine.sdk4.types.Certificate;
import org.ovirt.engine.sdk4.types.Display;
import org.ovirt.engine.sdk4.types.DisplayType;

public class DisplayBuilder {
    private String address;
    private Boolean allowOverride;
    private Certificate certificate;
    private Boolean copyPasteEnabled;
    private String disconnectAction;
    private Boolean fileTransferEnabled;
    private String keyboardLayout;
    private BigInteger monitors;
    private BigInteger port;
    private String proxy;
    private BigInteger securePort;
    private Boolean singleQxlPci;
    private Boolean smartcardEnabled;
    private DisplayType type;
    
    public DisplayBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public DisplayBuilder allowOverride(boolean newAllowOverride) {
        allowOverride = Boolean.valueOf(newAllowOverride);
        return this;
    }
    
    public DisplayBuilder allowOverride(Boolean newAllowOverride) {
        allowOverride = newAllowOverride;
        return this;
    }
    
    
    public DisplayBuilder certificate(Certificate newCertificate) {
        certificate = newCertificate;
        return this;
    }
    
    public DisplayBuilder certificate(CertificateBuilder newCertificate) {
        if (newCertificate == null) {
            certificate = null;
        }
        else {
            certificate = newCertificate.build();
        }
        return this;
    }
    
    
    public DisplayBuilder copyPasteEnabled(boolean newCopyPasteEnabled) {
        copyPasteEnabled = Boolean.valueOf(newCopyPasteEnabled);
        return this;
    }
    
    public DisplayBuilder copyPasteEnabled(Boolean newCopyPasteEnabled) {
        copyPasteEnabled = newCopyPasteEnabled;
        return this;
    }
    
    
    public DisplayBuilder disconnectAction(String newDisconnectAction) {
        disconnectAction = newDisconnectAction;
        return this;
    }
    
    
    public DisplayBuilder fileTransferEnabled(boolean newFileTransferEnabled) {
        fileTransferEnabled = Boolean.valueOf(newFileTransferEnabled);
        return this;
    }
    
    public DisplayBuilder fileTransferEnabled(Boolean newFileTransferEnabled) {
        fileTransferEnabled = newFileTransferEnabled;
        return this;
    }
    
    
    public DisplayBuilder keyboardLayout(String newKeyboardLayout) {
        keyboardLayout = newKeyboardLayout;
        return this;
    }
    
    
    public DisplayBuilder monitors(int newMonitors) {
        monitors = BigInteger.valueOf((long) newMonitors);
        return this;
    }
    
    public DisplayBuilder monitors(Integer newMonitors) {
        if (newMonitors == null) {
            monitors = null;
        }
        else {
            monitors = BigInteger.valueOf(newMonitors.longValue());
        }
        return this;
    }
    
    public DisplayBuilder monitors(long newMonitors) {
        monitors = BigInteger.valueOf(newMonitors);
        return this;
    }
    
    public DisplayBuilder monitors(Long newMonitors) {
        if (newMonitors == null) {
            monitors = null;
        }
        else {
            monitors = BigInteger.valueOf(newMonitors.longValue());
        }
        return this;
    }
    
    public DisplayBuilder monitors(BigInteger newMonitors) {
        monitors = newMonitors;
        return this;
    }
    
    
    public DisplayBuilder port(int newPort) {
        port = BigInteger.valueOf((long) newPort);
        return this;
    }
    
    public DisplayBuilder port(Integer newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public DisplayBuilder port(long newPort) {
        port = BigInteger.valueOf(newPort);
        return this;
    }
    
    public DisplayBuilder port(Long newPort) {
        if (newPort == null) {
            port = null;
        }
        else {
            port = BigInteger.valueOf(newPort.longValue());
        }
        return this;
    }
    
    public DisplayBuilder port(BigInteger newPort) {
        port = newPort;
        return this;
    }
    
    
    public DisplayBuilder proxy(String newProxy) {
        proxy = newProxy;
        return this;
    }
    
    
    public DisplayBuilder securePort(int newSecurePort) {
        securePort = BigInteger.valueOf((long) newSecurePort);
        return this;
    }
    
    public DisplayBuilder securePort(Integer newSecurePort) {
        if (newSecurePort == null) {
            securePort = null;
        }
        else {
            securePort = BigInteger.valueOf(newSecurePort.longValue());
        }
        return this;
    }
    
    public DisplayBuilder securePort(long newSecurePort) {
        securePort = BigInteger.valueOf(newSecurePort);
        return this;
    }
    
    public DisplayBuilder securePort(Long newSecurePort) {
        if (newSecurePort == null) {
            securePort = null;
        }
        else {
            securePort = BigInteger.valueOf(newSecurePort.longValue());
        }
        return this;
    }
    
    public DisplayBuilder securePort(BigInteger newSecurePort) {
        securePort = newSecurePort;
        return this;
    }
    
    
    public DisplayBuilder singleQxlPci(boolean newSingleQxlPci) {
        singleQxlPci = Boolean.valueOf(newSingleQxlPci);
        return this;
    }
    
    public DisplayBuilder singleQxlPci(Boolean newSingleQxlPci) {
        singleQxlPci = newSingleQxlPci;
        return this;
    }
    
    
    public DisplayBuilder smartcardEnabled(boolean newSmartcardEnabled) {
        smartcardEnabled = Boolean.valueOf(newSmartcardEnabled);
        return this;
    }
    
    public DisplayBuilder smartcardEnabled(Boolean newSmartcardEnabled) {
        smartcardEnabled = newSmartcardEnabled;
        return this;
    }
    
    
    public DisplayBuilder type(DisplayType newType) {
        type = newType;
        return this;
    }
    
    
    public Display build() {
        DisplayContainer container = new DisplayContainer();
        container.address(address);
        container.allowOverride(allowOverride);
        container.certificate(certificate);
        container.copyPasteEnabled(copyPasteEnabled);
        container.disconnectAction(disconnectAction);
        container.fileTransferEnabled(fileTransferEnabled);
        container.keyboardLayout(keyboardLayout);
        container.monitors(monitors);
        container.port(port);
        container.proxy(proxy);
        container.securePort(securePort);
        container.singleQxlPci(singleQxlPci);
        container.smartcardEnabled(smartcardEnabled);
        container.type(type);
        return container;
    }
}
