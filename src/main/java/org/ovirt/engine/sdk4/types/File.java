/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface File extends Identified {
    String content();
    
    boolean contentPresent();
    
    String type();
    
    boolean typePresent();
    
    StorageDomain storageDomain();
    
    boolean storageDomainPresent();
    
}
