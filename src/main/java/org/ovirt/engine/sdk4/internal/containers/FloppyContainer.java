/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.File;
import org.ovirt.engine.sdk4.types.Floppy;

public class FloppyContainer extends DeviceContainer implements Floppy {
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
