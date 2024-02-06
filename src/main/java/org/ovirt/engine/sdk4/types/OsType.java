/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing kind of operating system.
 * 
 * WARNING: This type has been deprecated with the introduction of the <<types/operating_system_info, OperatingSystemInfo>> type.
 * Operating systems are available as a top-level collection in the API: <<services/operating_systems, operating_systems>>
 * 
 * The end-user declares the type of the operating system installed in the virtual machine (guest operating system) by
 * selecting one of these values. This declaration enables the system to tune the virtual machine configuration for
 * better user experience. For example, the system chooses devices that are most suitable for the operating system. Note
 * that the system rely on user's selection and does not verify it by inspecting the actual guest operating system
 * installed.
 */
public enum OsType {
    /**
     * Other type of operating system, not specified by the other values.
     */
    OTHER("other"),
    /**
     * Distribution of Linux other than those specified by the other values.
     */
    OTHER_LINUX("other_linux"),
    /**
     * Red Hat Enterprise Linux 3 32-bit.
     */
    RHEL_3("rhel_3"),
    /**
     * Red Hat Enterprise Linux 3 64-bit.
     */
    RHEL_3X64("rhel_3x64"),
    /**
     * Red Hat Enterprise Linux 4 32-bit.
     */
    RHEL_4("rhel_4"),
    /**
     * Red Hat Enterprise Linux 4 64-bit.
     */
    RHEL_4X64("rhel_4x64"),
    /**
     * Red Hat Enterprise Linux 5 32-bit.
     */
    RHEL_5("rhel_5"),
    /**
     * Red Hat Enterprise Linux 5 64-bit.
     */
    RHEL_5X64("rhel_5x64"),
    /**
     * Red Hat Enterprise Linux 6 32-bit.
     */
    RHEL_6("rhel_6"),
    /**
     * Red Hat Enterprise Linux 6 64-bit.
     */
    RHEL_6X64("rhel_6x64"),
    /**
     * This value is mapped to `other`.
     */
    UNASSIGNED("unassigned"),
    /**
     * Windows 2003 32-bit.
     */
    WINDOWS_2003("windows_2003"),
    /**
     * Windows 2003 64-bit.
     */
    WINDOWS_2003X64("windows_2003x64"),
    /**
     * Windows 2008 32-bit.
     */
    WINDOWS_2008("windows_2008"),
    /**
     * Windows 2008 R2 64-bit.
     */
    WINDOWS_2008R2X64("windows_2008r2x64"),
    /**
     * Windows 2008 64-bit.
     */
    WINDOWS_2008X64("windows_2008x64"),
    /**
     * Windows 2012 64-bit.
     */
    WINDOWS_2012X64("windows_2012x64"),
    /**
     * Windows 7 32-bit.
     */
    WINDOWS_7("windows_7"),
    /**
     * Windows 7 64-bit.
     */
    WINDOWS_7X64("windows_7x64"),
    /**
     * Windows 8 32-bit.
     */
    WINDOWS_8("windows_8"),
    /**
     * Windows 8 64-bit.
     */
    WINDOWS_8X64("windows_8x64"),
    /**
     * Windows XP.
     */
    WINDOWS_XP("windows_xp"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(OsType.class);
    
    private String image;
    
    OsType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static OsType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'OsType' enumerated type. " +
            "Valid values are 'other', 'other_linux', 'rhel_3', 'rhel_3x64', 'rhel_4', 'rhel_4x64', 'rhel_5', 'rhel_5x64', 'rhel_6', 'rhel_6x64', 'unassigned', 'windows_2003', 'windows_2003x64', 'windows_2008', 'windows_2008r2x64', 'windows_2008x64', 'windows_2012x64', 'windows_7', 'windows_7x64', 'windows_8', 'windows_8x64' and 'windows_xp'.",
            exception
            );
            return null;
        }
    }
    
}

