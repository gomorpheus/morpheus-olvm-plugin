/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.PayloadContainer;
import org.ovirt.engine.sdk4.types.File;
import org.ovirt.engine.sdk4.types.Payload;
import org.ovirt.engine.sdk4.types.VmDeviceType;

public class PayloadBuilder {
    private List<File> files;
    private VmDeviceType type;
    private String volumeId;
    
    public PayloadBuilder files(List<File> newFiles) {
        if (newFiles != null) {
            if (files == null) {
                files = new ArrayList<>(newFiles);
            }
            else {
                files.addAll(newFiles);
            }
        }
        return this;
    }
    
    public PayloadBuilder files(File... newFiles) {
        if (newFiles != null) {
            if (files == null) {
                files = new ArrayList<>(newFiles.length);
            }
            Collections.addAll(files, newFiles);
        }
        return this;
    }
    
    public PayloadBuilder files(FileBuilder... newFiles) {
        if (newFiles != null) {
            if (files == null) {
                files = new ArrayList<>(newFiles.length);
            }
            for (FileBuilder builder : newFiles) {
                files.add(builder.build());
            }
        }
        return this;
    }
    
    
    public PayloadBuilder type(VmDeviceType newType) {
        type = newType;
        return this;
    }
    
    
    public PayloadBuilder volumeId(String newVolumeId) {
        volumeId = newVolumeId;
        return this;
    }
    
    
    public Payload build() {
        PayloadContainer container = new PayloadContainer();
        container.files(files);
        container.type(type);
        container.volumeId(volumeId);
        return container;
    }
}
