/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Backup;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.DiskFormat;
import org.ovirt.engine.sdk4.types.DiskSnapshot;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Image;
import org.ovirt.engine.sdk4.types.ImageTransfer;
import org.ovirt.engine.sdk4.types.ImageTransferDirection;
import org.ovirt.engine.sdk4.types.ImageTransferPhase;
import org.ovirt.engine.sdk4.types.ImageTransferTimeoutPolicy;

public class ImageTransferContainer extends IdentifiedContainer implements ImageTransfer {
    private Boolean active;
    private ImageTransferDirection direction;
    private DiskFormat format;
    private BigInteger inactivityTimeout;
    private ImageTransferPhase phase;
    private String proxyUrl;
    private Boolean shallow;
    private ImageTransferTimeoutPolicy timeoutPolicy;
    private String transferUrl;
    private BigInteger transferred;
    private Backup backup;
    private Disk disk;
    private Host host;
    private Image image;
    private DiskSnapshot snapshot;
    
    public boolean active() {
        return active;
    }
    
    public void active(boolean newActive) {
        active = Boolean.valueOf(newActive);
    }
    
    public void active(Boolean newActive) {
        active = newActive;
    }
    
    public boolean activePresent() {
        return active != null;
    }
    
    public ImageTransferDirection direction() {
        return direction;
    }
    
    public void direction(ImageTransferDirection newDirection) {
        direction = newDirection;
    }
    
    public boolean directionPresent() {
        return direction != null;
    }
    
    public DiskFormat format() {
        return format;
    }
    
    public void format(DiskFormat newFormat) {
        format = newFormat;
    }
    
    public boolean formatPresent() {
        return format != null;
    }
    
    public BigInteger inactivityTimeout() {
        return inactivityTimeout;
    }
    
    public Byte inactivityTimeoutAsByte() {
        return asByte("ImageTransfer", "inactivityTimeout", inactivityTimeout);
    }
    
    public Short inactivityTimeoutAsShort() {
        return asShort("ImageTransfer", "inactivityTimeout", inactivityTimeout);
    }
    
    public Integer inactivityTimeoutAsInteger() {
        return asInteger("ImageTransfer", "inactivityTimeout", inactivityTimeout);
    }
    
    public Long inactivityTimeoutAsLong() {
        return asLong("ImageTransfer", "inactivityTimeout", inactivityTimeout);
    }
    
    public void inactivityTimeout(BigInteger newInactivityTimeout) {
        inactivityTimeout = newInactivityTimeout;
    }
    
    public boolean inactivityTimeoutPresent() {
        return inactivityTimeout != null;
    }
    
    public ImageTransferPhase phase() {
        return phase;
    }
    
    public void phase(ImageTransferPhase newPhase) {
        phase = newPhase;
    }
    
    public boolean phasePresent() {
        return phase != null;
    }
    
    public String proxyUrl() {
        return proxyUrl;
    }
    
    public void proxyUrl(String newProxyUrl) {
        proxyUrl = newProxyUrl;
    }
    
    public boolean proxyUrlPresent() {
        return proxyUrl != null;
    }
    
    public boolean shallow() {
        return shallow;
    }
    
    public void shallow(boolean newShallow) {
        shallow = Boolean.valueOf(newShallow);
    }
    
    public void shallow(Boolean newShallow) {
        shallow = newShallow;
    }
    
    public boolean shallowPresent() {
        return shallow != null;
    }
    
    public ImageTransferTimeoutPolicy timeoutPolicy() {
        return timeoutPolicy;
    }
    
    public void timeoutPolicy(ImageTransferTimeoutPolicy newTimeoutPolicy) {
        timeoutPolicy = newTimeoutPolicy;
    }
    
    public boolean timeoutPolicyPresent() {
        return timeoutPolicy != null;
    }
    
    public String transferUrl() {
        return transferUrl;
    }
    
    public void transferUrl(String newTransferUrl) {
        transferUrl = newTransferUrl;
    }
    
    public boolean transferUrlPresent() {
        return transferUrl != null;
    }
    
    public BigInteger transferred() {
        return transferred;
    }
    
    public Byte transferredAsByte() {
        return asByte("ImageTransfer", "transferred", transferred);
    }
    
    public Short transferredAsShort() {
        return asShort("ImageTransfer", "transferred", transferred);
    }
    
    public Integer transferredAsInteger() {
        return asInteger("ImageTransfer", "transferred", transferred);
    }
    
    public Long transferredAsLong() {
        return asLong("ImageTransfer", "transferred", transferred);
    }
    
    public void transferred(BigInteger newTransferred) {
        transferred = newTransferred;
    }
    
    public boolean transferredPresent() {
        return transferred != null;
    }
    
    public Backup backup() {
        return backup;
    }
    
    public void backup(Backup newBackup) {
        backup = newBackup;
    }
    
    public boolean backupPresent() {
        return backup != null;
    }
    
    public Disk disk() {
        return disk;
    }
    
    public void disk(Disk newDisk) {
        disk = newDisk;
    }
    
    public boolean diskPresent() {
        return disk != null;
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
    public Image image() {
        return image;
    }
    
    public void image(Image newImage) {
        image = newImage;
    }
    
    public boolean imagePresent() {
        return image != null;
    }
    
    public DiskSnapshot snapshot() {
        return snapshot;
    }
    
    public void snapshot(DiskSnapshot newSnapshot) {
        snapshot = newSnapshot;
    }
    
    public boolean snapshotPresent() {
        return snapshot != null;
    }
    
}
