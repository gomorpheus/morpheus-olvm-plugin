/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface ReportedConfiguration {
    String actualValue();
    
    boolean actualValuePresent();
    
    String expectedValue();
    
    boolean expectedValuePresent();
    
    boolean inSync();
    
    boolean inSyncPresent();
    
    String name();
    
    boolean namePresent();
    
}
