/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.ImageTransferContainer;
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

public class ImageTransferBuilder {
    private Boolean active;
    private Backup backup;
    private String comment;
    private String description;
    private ImageTransferDirection direction;
    private Disk disk;
    private DiskFormat format;
    private Host host;
    private String href;
    private String id;
    private Image image;
    private BigInteger inactivityTimeout;
    private String name;
    private ImageTransferPhase phase;
    private String proxyUrl;
    private Boolean shallow;
    private DiskSnapshot snapshot;
    private ImageTransferTimeoutPolicy timeoutPolicy;
    private String transferUrl;
    private BigInteger transferred;
    
    public ImageTransferBuilder active(boolean newActive) {
        active = Boolean.valueOf(newActive);
        return this;
    }
    
    public ImageTransferBuilder active(Boolean newActive) {
        active = newActive;
        return this;
    }
    
    
    public ImageTransferBuilder backup(Backup newBackup) {
        backup = newBackup;
        return this;
    }
    
    public ImageTransferBuilder backup(BackupBuilder newBackup) {
        if (newBackup == null) {
            backup = null;
        }
        else {
            backup = newBackup.build();
        }
        return this;
    }
    
    
    public ImageTransferBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ImageTransferBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ImageTransferBuilder direction(ImageTransferDirection newDirection) {
        direction = newDirection;
        return this;
    }
    
    
    public ImageTransferBuilder disk(Disk newDisk) {
        disk = newDisk;
        return this;
    }
    
    public ImageTransferBuilder disk(DiskBuilder newDisk) {
        if (newDisk == null) {
            disk = null;
        }
        else {
            disk = newDisk.build();
        }
        return this;
    }
    
    
    public ImageTransferBuilder format(DiskFormat newFormat) {
        format = newFormat;
        return this;
    }
    
    
    public ImageTransferBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public ImageTransferBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public ImageTransferBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ImageTransferBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ImageTransferBuilder image(Image newImage) {
        image = newImage;
        return this;
    }
    
    public ImageTransferBuilder image(ImageBuilder newImage) {
        if (newImage == null) {
            image = null;
        }
        else {
            image = newImage.build();
        }
        return this;
    }
    
    
    public ImageTransferBuilder inactivityTimeout(int newInactivityTimeout) {
        inactivityTimeout = BigInteger.valueOf((long) newInactivityTimeout);
        return this;
    }
    
    public ImageTransferBuilder inactivityTimeout(Integer newInactivityTimeout) {
        if (newInactivityTimeout == null) {
            inactivityTimeout = null;
        }
        else {
            inactivityTimeout = BigInteger.valueOf(newInactivityTimeout.longValue());
        }
        return this;
    }
    
    public ImageTransferBuilder inactivityTimeout(long newInactivityTimeout) {
        inactivityTimeout = BigInteger.valueOf(newInactivityTimeout);
        return this;
    }
    
    public ImageTransferBuilder inactivityTimeout(Long newInactivityTimeout) {
        if (newInactivityTimeout == null) {
            inactivityTimeout = null;
        }
        else {
            inactivityTimeout = BigInteger.valueOf(newInactivityTimeout.longValue());
        }
        return this;
    }
    
    public ImageTransferBuilder inactivityTimeout(BigInteger newInactivityTimeout) {
        inactivityTimeout = newInactivityTimeout;
        return this;
    }
    
    
    public ImageTransferBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ImageTransferBuilder phase(ImageTransferPhase newPhase) {
        phase = newPhase;
        return this;
    }
    
    
    public ImageTransferBuilder proxyUrl(String newProxyUrl) {
        proxyUrl = newProxyUrl;
        return this;
    }
    
    
    public ImageTransferBuilder shallow(boolean newShallow) {
        shallow = Boolean.valueOf(newShallow);
        return this;
    }
    
    public ImageTransferBuilder shallow(Boolean newShallow) {
        shallow = newShallow;
        return this;
    }
    
    
    public ImageTransferBuilder snapshot(DiskSnapshot newSnapshot) {
        snapshot = newSnapshot;
        return this;
    }
    
    public ImageTransferBuilder snapshot(DiskSnapshotBuilder newSnapshot) {
        if (newSnapshot == null) {
            snapshot = null;
        }
        else {
            snapshot = newSnapshot.build();
        }
        return this;
    }
    
    
    public ImageTransferBuilder timeoutPolicy(ImageTransferTimeoutPolicy newTimeoutPolicy) {
        timeoutPolicy = newTimeoutPolicy;
        return this;
    }
    
    
    public ImageTransferBuilder transferUrl(String newTransferUrl) {
        transferUrl = newTransferUrl;
        return this;
    }
    
    
    public ImageTransferBuilder transferred(int newTransferred) {
        transferred = BigInteger.valueOf((long) newTransferred);
        return this;
    }
    
    public ImageTransferBuilder transferred(Integer newTransferred) {
        if (newTransferred == null) {
            transferred = null;
        }
        else {
            transferred = BigInteger.valueOf(newTransferred.longValue());
        }
        return this;
    }
    
    public ImageTransferBuilder transferred(long newTransferred) {
        transferred = BigInteger.valueOf(newTransferred);
        return this;
    }
    
    public ImageTransferBuilder transferred(Long newTransferred) {
        if (newTransferred == null) {
            transferred = null;
        }
        else {
            transferred = BigInteger.valueOf(newTransferred.longValue());
        }
        return this;
    }
    
    public ImageTransferBuilder transferred(BigInteger newTransferred) {
        transferred = newTransferred;
        return this;
    }
    
    
    public ImageTransfer build() {
        ImageTransferContainer container = new ImageTransferContainer();
        container.active(active);
        container.backup(backup);
        container.comment(comment);
        container.description(description);
        container.direction(direction);
        container.disk(disk);
        container.format(format);
        container.host(host);
        container.href(href);
        container.id(id);
        container.image(image);
        container.inactivityTimeout(inactivityTimeout);
        container.name(name);
        container.phase(phase);
        container.proxyUrl(proxyUrl);
        container.shallow(shallow);
        container.snapshot(snapshot);
        container.timeoutPolicy(timeoutPolicy);
        container.transferUrl(transferUrl);
        container.transferred(transferred);
        return container;
    }
}
