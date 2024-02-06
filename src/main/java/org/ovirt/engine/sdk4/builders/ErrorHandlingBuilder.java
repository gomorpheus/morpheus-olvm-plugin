/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.ErrorHandlingContainer;
import org.ovirt.engine.sdk4.types.ErrorHandling;
import org.ovirt.engine.sdk4.types.MigrateOnError;

public class ErrorHandlingBuilder {
    private MigrateOnError onError;
    
    public ErrorHandlingBuilder onError(MigrateOnError newOnError) {
        onError = newOnError;
        return this;
    }
    
    
    public ErrorHandling build() {
        ErrorHandlingContainer container = new ErrorHandlingContainer();
        container.onError(onError);
        return container;
    }
}
