/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.TemplateVersionContainer;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.TemplateVersion;

public class TemplateVersionBuilder {
    private Template baseTemplate;
    private String versionName;
    private BigInteger versionNumber;
    
    public TemplateVersionBuilder baseTemplate(Template newBaseTemplate) {
        baseTemplate = newBaseTemplate;
        return this;
    }
    
    public TemplateVersionBuilder baseTemplate(TemplateBuilder newBaseTemplate) {
        if (newBaseTemplate == null) {
            baseTemplate = null;
        }
        else {
            baseTemplate = newBaseTemplate.build();
        }
        return this;
    }
    
    
    public TemplateVersionBuilder versionName(String newVersionName) {
        versionName = newVersionName;
        return this;
    }
    
    
    public TemplateVersionBuilder versionNumber(int newVersionNumber) {
        versionNumber = BigInteger.valueOf((long) newVersionNumber);
        return this;
    }
    
    public TemplateVersionBuilder versionNumber(Integer newVersionNumber) {
        if (newVersionNumber == null) {
            versionNumber = null;
        }
        else {
            versionNumber = BigInteger.valueOf(newVersionNumber.longValue());
        }
        return this;
    }
    
    public TemplateVersionBuilder versionNumber(long newVersionNumber) {
        versionNumber = BigInteger.valueOf(newVersionNumber);
        return this;
    }
    
    public TemplateVersionBuilder versionNumber(Long newVersionNumber) {
        if (newVersionNumber == null) {
            versionNumber = null;
        }
        else {
            versionNumber = BigInteger.valueOf(newVersionNumber.longValue());
        }
        return this;
    }
    
    public TemplateVersionBuilder versionNumber(BigInteger newVersionNumber) {
        versionNumber = newVersionNumber;
        return this;
    }
    
    
    public TemplateVersion build() {
        TemplateVersionContainer container = new TemplateVersionContainer();
        container.baseTemplate(baseTemplate);
        container.versionName(versionName);
        container.versionNumber(versionNumber);
        return container;
    }
}
