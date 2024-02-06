/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * User options allow you to save key/value properties
 * which are used to customize the settings per individual
 * user.
 */
public interface UserOption extends Identified {
    String content();
    
    boolean contentPresent();
    
    User user();
    
    boolean userPresent();
    
}
