/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.BiosContainer;
import org.ovirt.engine.sdk4.types.Bios;
import org.ovirt.engine.sdk4.types.BiosType;
import org.ovirt.engine.sdk4.types.BootMenu;

public class BiosBuilder {
    private BootMenu bootMenu;
    private BiosType type;
    
    public BiosBuilder bootMenu(BootMenu newBootMenu) {
        bootMenu = newBootMenu;
        return this;
    }
    
    public BiosBuilder bootMenu(BootMenuBuilder newBootMenu) {
        if (newBootMenu == null) {
            bootMenu = null;
        }
        else {
            bootMenu = newBootMenu.build();
        }
        return this;
    }
    
    
    public BiosBuilder type(BiosType newType) {
        type = newType;
        return this;
    }
    
    
    public Bios build() {
        BiosContainer container = new BiosContainer();
        container.bootMenu(bootMenu);
        container.type(type);
        return container;
    }
}
