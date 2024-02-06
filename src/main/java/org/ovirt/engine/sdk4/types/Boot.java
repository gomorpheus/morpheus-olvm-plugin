/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * Configuration of the boot sequence of a virtual machine.
 */
public interface Boot {
    List<BootDevice> devices();
    
    boolean devicesPresent();
    
}
