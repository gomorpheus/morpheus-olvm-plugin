/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.SpecialObjects;
import org.ovirt.engine.sdk4.types.Tag;
import org.ovirt.engine.sdk4.types.Template;

public class SpecialObjectsContainer extends Container implements SpecialObjects {
    private Template blankTemplate;
    private Tag rootTag;
    
    public Template blankTemplate() {
        return blankTemplate;
    }
    
    public void blankTemplate(Template newBlankTemplate) {
        blankTemplate = newBlankTemplate;
    }
    
    public boolean blankTemplatePresent() {
        return blankTemplate != null;
    }
    
    public Tag rootTag() {
        return rootTag;
    }
    
    public void rootTag(Tag newRootTag) {
        rootTag = newRootTag;
    }
    
    public boolean rootTagPresent() {
        return rootTag != null;
    }
    
}
