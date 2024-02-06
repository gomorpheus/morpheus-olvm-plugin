/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

/**
 * Type representing a version of a virtual machine template.
 */
public interface TemplateVersion {
    String versionName();
    
    boolean versionNamePresent();
    
    BigInteger versionNumber();
    Byte versionNumberAsByte();
    Short versionNumberAsShort();
    Integer versionNumberAsInteger();
    Long versionNumberAsLong();
    
    boolean versionNumberPresent();
    
    Template baseTemplate();
    
    boolean baseTemplatePresent();
    
}
