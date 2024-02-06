/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Type representing a package.
 * 
 * This is an example of the package element:
 * 
 * [source,xml]
 * ----
 * <package>
 *   <name>libipa_hbac-1.9.2-82.11.el6_4.i686</name>
 * </package>
 * ----
 */
public interface Package {
    String name();
    
    boolean namePresent();
    
}
