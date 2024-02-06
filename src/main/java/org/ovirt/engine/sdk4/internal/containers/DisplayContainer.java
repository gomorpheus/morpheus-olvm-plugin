/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Certificate;
import org.ovirt.engine.sdk4.types.Display;
import org.ovirt.engine.sdk4.types.DisplayType;

public class DisplayContainer extends Container implements Display {
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
    
    public String address() {
        return address;
    }
    
    public void address(String newAddress) {
        address = newAddress;
    }
    
    public boolean addressPresent() {
        return address != null;
    }
    
    public boolean allowOverride() {
        return allowOverride;
    }
    
    public void allowOverride(boolean newAllowOverride) {
        allowOverride = Boolean.valueOf(newAllowOverride);
    }
    
    public void allowOverride(Boolean newAllowOverride) {
        allowOverride = newAllowOverride;
    }
    
    public boolean allowOverridePresent() {
        return allowOverride != null;
    }
    
    public Certificate certificate() {
        return certificate;
    }
    
    public void certificate(Certificate newCertificate) {
        certificate = newCertificate;
    }
    
    public boolean certificatePresent() {
        return certificate != null;
    }
    
    public boolean copyPasteEnabled() {
        return copyPasteEnabled;
    }
    
    public void copyPasteEnabled(boolean newCopyPasteEnabled) {
        copyPasteEnabled = Boolean.valueOf(newCopyPasteEnabled);
    }
    
    public void copyPasteEnabled(Boolean newCopyPasteEnabled) {
        copyPasteEnabled = newCopyPasteEnabled;
    }
    
    public boolean copyPasteEnabledPresent() {
        return copyPasteEnabled != null;
    }
    
    public String disconnectAction() {
        return disconnectAction;
    }
    
    public void disconnectAction(String newDisconnectAction) {
        disconnectAction = newDisconnectAction;
    }
    
    public boolean disconnectActionPresent() {
        return disconnectAction != null;
    }
    
    public boolean fileTransferEnabled() {
        return fileTransferEnabled;
    }
    
    public void fileTransferEnabled(boolean newFileTransferEnabled) {
        fileTransferEnabled = Boolean.valueOf(newFileTransferEnabled);
    }
    
    public void fileTransferEnabled(Boolean newFileTransferEnabled) {
        fileTransferEnabled = newFileTransferEnabled;
    }
    
    public boolean fileTransferEnabledPresent() {
        return fileTransferEnabled != null;
    }
    
    public String keyboardLayout() {
        return keyboardLayout;
    }
    
    public void keyboardLayout(String newKeyboardLayout) {
        keyboardLayout = newKeyboardLayout;
    }
    
    public boolean keyboardLayoutPresent() {
        return keyboardLayout != null;
    }
    
    public BigInteger monitors() {
        return monitors;
    }
    
    public Byte monitorsAsByte() {
        return asByte("Display", "monitors", monitors);
    }
    
    public Short monitorsAsShort() {
        return asShort("Display", "monitors", monitors);
    }
    
    public Integer monitorsAsInteger() {
        return asInteger("Display", "monitors", monitors);
    }
    
    public Long monitorsAsLong() {
        return asLong("Display", "monitors", monitors);
    }
    
    public void monitors(BigInteger newMonitors) {
        monitors = newMonitors;
    }
    
    public boolean monitorsPresent() {
        return monitors != null;
    }
    
    public BigInteger port() {
        return port;
    }
    
    public Byte portAsByte() {
        return asByte("Display", "port", port);
    }
    
    public Short portAsShort() {
        return asShort("Display", "port", port);
    }
    
    public Integer portAsInteger() {
        return asInteger("Display", "port", port);
    }
    
    public Long portAsLong() {
        return asLong("Display", "port", port);
    }
    
    public void port(BigInteger newPort) {
        port = newPort;
    }
    
    public boolean portPresent() {
        return port != null;
    }
    
    public String proxy() {
        return proxy;
    }
    
    public void proxy(String newProxy) {
        proxy = newProxy;
    }
    
    public boolean proxyPresent() {
        return proxy != null;
    }
    
    public BigInteger securePort() {
        return securePort;
    }
    
    public Byte securePortAsByte() {
        return asByte("Display", "securePort", securePort);
    }
    
    public Short securePortAsShort() {
        return asShort("Display", "securePort", securePort);
    }
    
    public Integer securePortAsInteger() {
        return asInteger("Display", "securePort", securePort);
    }
    
    public Long securePortAsLong() {
        return asLong("Display", "securePort", securePort);
    }
    
    public void securePort(BigInteger newSecurePort) {
        securePort = newSecurePort;
    }
    
    public boolean securePortPresent() {
        return securePort != null;
    }
    
    public boolean singleQxlPci() {
        return singleQxlPci;
    }
    
    public void singleQxlPci(boolean newSingleQxlPci) {
        singleQxlPci = Boolean.valueOf(newSingleQxlPci);
    }
    
    public void singleQxlPci(Boolean newSingleQxlPci) {
        singleQxlPci = newSingleQxlPci;
    }
    
    public boolean singleQxlPciPresent() {
        return singleQxlPci != null;
    }
    
    public boolean smartcardEnabled() {
        return smartcardEnabled;
    }
    
    public void smartcardEnabled(boolean newSmartcardEnabled) {
        smartcardEnabled = Boolean.valueOf(newSmartcardEnabled);
    }
    
    public void smartcardEnabled(Boolean newSmartcardEnabled) {
        smartcardEnabled = newSmartcardEnabled;
    }
    
    public boolean smartcardEnabledPresent() {
        return smartcardEnabled != null;
    }
    
    public DisplayType type() {
        return type;
    }
    
    public void type(DisplayType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
}
