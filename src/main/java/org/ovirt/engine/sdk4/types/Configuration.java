/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface Configuration {
    String data();
    
    boolean dataPresent();
    
    ConfigurationType type();
    
    boolean typePresent();
    
}
