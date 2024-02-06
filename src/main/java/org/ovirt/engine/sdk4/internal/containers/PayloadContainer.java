/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.util.List;
import org.ovirt.engine.sdk4.types.File;
import org.ovirt.engine.sdk4.types.Payload;
import org.ovirt.engine.sdk4.types.VmDeviceType;

public class PayloadContainer extends Container implements Payload {
    private List<File> files;
    private VmDeviceType type;
    private String volumeId;
    
    public List<File> files() {
        return makeUnmodifiableList(files);
    }
    
    public void files(List<File> newFiles) {
        files = makeArrayList(newFiles);
    }
    
    public boolean filesPresent() {
        return files != null && !files.isEmpty();
    }
    
    public VmDeviceType type() {
        return type;
    }
    
    public void type(VmDeviceType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public String volumeId() {
        return volumeId;
    }
    
    public void volumeId(String newVolumeId) {
        volumeId = newVolumeId;
    }
    
    public boolean volumeIdPresent() {
        return volumeId != null;
    }
    
}
