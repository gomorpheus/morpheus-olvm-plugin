/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.ErrorHandling;
import org.ovirt.engine.sdk4.types.MigrateOnError;

public class ErrorHandlingContainer extends Container implements ErrorHandling {
    private MigrateOnError onError;
    
    public MigrateOnError onError() {
        return onError;
    }
    
    public void onError(MigrateOnError newOnError) {
        onError = newOnError;
    }
    
    public boolean onErrorPresent() {
        return onError != null;
    }
    
}
