/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import org.ovirt.engine.sdk4.internal.containers.ConsoleContainer;
import org.ovirt.engine.sdk4.types.Console;

public class ConsoleBuilder {
    private Boolean enabled;
    
    public ConsoleBuilder enabled(boolean newEnabled) {
        enabled = Boolean.valueOf(newEnabled);
        return this;
    }
    
    public ConsoleBuilder enabled(Boolean newEnabled) {
        enabled = newEnabled;
        return this;
    }
    
    
    public Console build() {
        ConsoleContainer container = new ConsoleContainer();
        container.enabled(enabled);
        return container;
    }
}
