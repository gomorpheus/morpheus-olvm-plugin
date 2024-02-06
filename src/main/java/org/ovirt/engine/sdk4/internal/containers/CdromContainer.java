/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Cdrom;
import org.ovirt.engine.sdk4.types.File;

public class CdromContainer extends DeviceContainer implements Cdrom {
    private File file;
    
    public File file() {
        return file;
    }
    
    public void file(File newFile) {
        file = newFile;
    }
    
    public boolean filePresent() {
        return file != null;
    }
    
}
