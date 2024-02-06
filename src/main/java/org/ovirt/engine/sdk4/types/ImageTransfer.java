/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

/**
 * This type contains information regarding an image transfer being performed.
 */
public interface ImageTransfer extends Identified {
    boolean active();
    
    boolean activePresent();
    
    ImageTransferDirection direction();
    
    boolean directionPresent();
    
    DiskFormat format();
    
    boolean formatPresent();
    
    BigInteger inactivityTimeout();
    Byte inactivityTimeoutAsByte();
    Short inactivityTimeoutAsShort();
    Integer inactivityTimeoutAsInteger();
    Long inactivityTimeoutAsLong();
    
    boolean inactivityTimeoutPresent();
    
    ImageTransferPhase phase();
    
    boolean phasePresent();
    
    String proxyUrl();
    
    boolean proxyUrlPresent();
    
    boolean shallow();
    
    boolean shallowPresent();
    
    ImageTransferTimeoutPolicy timeoutPolicy();
    
    boolean timeoutPolicyPresent();
    
    String transferUrl();
    
    boolean transferUrlPresent();
    
    BigInteger transferred();
    Byte transferredAsByte();
    Short transferredAsShort();
    Integer transferredAsInteger();
    Long transferredAsLong();
    
    boolean transferredPresent();
    
    Backup backup();
    
    boolean backupPresent();
    
    Disk disk();
    
    boolean diskPresent();
    
    Host host();
    
    boolean hostPresent();
    
    Image image();
    
    boolean imagePresent();
    
    DiskSnapshot snapshot();
    
    boolean snapshotPresent();
    
}
