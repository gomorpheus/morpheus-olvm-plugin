/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface AuthorizedKey extends Identified {
    String key();
    
    boolean keyPresent();
    
    User user();
    
    boolean userPresent();
    
}
