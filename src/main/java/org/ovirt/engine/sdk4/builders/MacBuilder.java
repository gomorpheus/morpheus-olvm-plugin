/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.MacContainer;
import org.ovirt.engine.sdk4.types.Mac;

public class MacBuilder {
    private String address;
    
    public MacBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public Mac build() {
        MacContainer container = new MacContainer();
        container.address(address);
        return container;
    }
}
