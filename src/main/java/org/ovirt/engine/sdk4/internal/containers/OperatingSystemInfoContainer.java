/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.Architecture;
import org.ovirt.engine.sdk4.types.Icon;
import org.ovirt.engine.sdk4.types.OperatingSystemInfo;

public class OperatingSystemInfoContainer extends IdentifiedContainer implements OperatingSystemInfo {
    private Architecture architecture;
    private Icon largeIcon;
    private Icon smallIcon;
    
    public Architecture architecture() {
        return architecture;
    }
    
    public void architecture(Architecture newArchitecture) {
        architecture = newArchitecture;
    }
    
    public boolean architecturePresent() {
        return architecture != null;
    }
    
    public Icon largeIcon() {
        return largeIcon;
    }
    
    public void largeIcon(Icon newLargeIcon) {
        largeIcon = newLargeIcon;
    }
    
    public boolean largeIconPresent() {
        return largeIcon != null;
    }
    
    public Icon smallIcon() {
        return smallIcon;
    }
    
    public void smallIcon(Icon newSmallIcon) {
        smallIcon = newSmallIcon;
    }
    
    public boolean smallIconPresent() {
        return smallIcon != null;
    }
    
}
