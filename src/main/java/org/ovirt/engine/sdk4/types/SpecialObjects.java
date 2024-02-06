/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * This type contains references to special objects, such as blank templates and the root of a hierarchy of tags.
 */
public interface SpecialObjects {
    Template blankTemplate();
    
    boolean blankTemplatePresent();
    
    Tag rootTag();
    
    boolean rootTagPresent();
    
}
