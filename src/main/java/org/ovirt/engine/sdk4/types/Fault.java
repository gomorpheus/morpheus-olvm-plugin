/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface Fault {
    String detail();
    
    boolean detailPresent();
    
    String reason();
    
    boolean reasonPresent();
    
}
