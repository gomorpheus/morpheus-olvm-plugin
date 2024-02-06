/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.TemplateVersion;

public class TemplateVersionContainer extends Container implements TemplateVersion {
    private String versionName;
    private BigInteger versionNumber;
    private Template baseTemplate;
    
    public String versionName() {
        return versionName;
    }
    
    public void versionName(String newVersionName) {
        versionName = newVersionName;
    }
    
    public boolean versionNamePresent() {
        return versionName != null;
    }
    
    public BigInteger versionNumber() {
        return versionNumber;
    }
    
    public Byte versionNumberAsByte() {
        return asByte("TemplateVersion", "versionNumber", versionNumber);
    }
    
    public Short versionNumberAsShort() {
        return asShort("TemplateVersion", "versionNumber", versionNumber);
    }
    
    public Integer versionNumberAsInteger() {
        return asInteger("TemplateVersion", "versionNumber", versionNumber);
    }
    
    public Long versionNumberAsLong() {
        return asLong("TemplateVersion", "versionNumber", versionNumber);
    }
    
    public void versionNumber(BigInteger newVersionNumber) {
        versionNumber = newVersionNumber;
    }
    
    public boolean versionNumberPresent() {
        return versionNumber != null;
    }
    
    public Template baseTemplate() {
        return baseTemplate;
    }
    
    public void baseTemplate(Template newBaseTemplate) {
        baseTemplate = newBaseTemplate;
    }
    
    public boolean baseTemplatePresent() {
        return baseTemplate != null;
    }
    
}
