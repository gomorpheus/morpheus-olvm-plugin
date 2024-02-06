/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

/**
 * Represents a graphic console configuration.
 */
public interface Display {
    String address();
    
    boolean addressPresent();
    
    boolean allowOverride();
    
    boolean allowOverridePresent();
    
    Certificate certificate();
    
    boolean certificatePresent();
    
    boolean copyPasteEnabled();
    
    boolean copyPasteEnabledPresent();
    
    String disconnectAction();
    
    boolean disconnectActionPresent();
    
    boolean fileTransferEnabled();
    
    boolean fileTransferEnabledPresent();
    
    String keyboardLayout();
    
    boolean keyboardLayoutPresent();
    
    BigInteger monitors();
    Byte monitorsAsByte();
    Short monitorsAsShort();
    Integer monitorsAsInteger();
    Long monitorsAsLong();
    
    boolean monitorsPresent();
    
    BigInteger port();
    Byte portAsByte();
    Short portAsShort();
    Integer portAsInteger();
    Long portAsLong();
    
    boolean portPresent();
    
    String proxy();
    
    boolean proxyPresent();
    
    BigInteger securePort();
    Byte securePortAsByte();
    Short securePortAsShort();
    Integer securePortAsInteger();
    Long securePortAsLong();
    
    boolean securePortPresent();
    
    boolean singleQxlPci();
    
    boolean singleQxlPciPresent();
    
    boolean smartcardEnabled();
    
    boolean smartcardEnabledPresent();
    
    DisplayType type();
    
    boolean typePresent();
    
}
