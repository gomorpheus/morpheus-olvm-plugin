/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Bios;
import org.ovirt.engine.sdk4.types.BiosType;
import org.ovirt.engine.sdk4.types.BootMenu;

public class BiosContainer extends Container implements Bios {
    private BootMenu bootMenu;
    private BiosType type;
    
    public BootMenu bootMenu() {
        return bootMenu;
    }
    
    public void bootMenu(BootMenu newBootMenu) {
        bootMenu = newBootMenu;
    }
    
    public boolean bootMenuPresent() {
        return bootMenu != null;
    }
    
    public BiosType type() {
        return type;
    }
    
    public void type(BiosType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
}
