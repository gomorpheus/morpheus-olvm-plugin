/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import org.ovirt.engine.sdk4.internal.containers.SpecialObjectsContainer;
import org.ovirt.engine.sdk4.types.SpecialObjects;
import org.ovirt.engine.sdk4.types.Tag;
import org.ovirt.engine.sdk4.types.Template;

public class SpecialObjectsBuilder {
    private Template blankTemplate;
    private Tag rootTag;
    
    public SpecialObjectsBuilder blankTemplate(Template newBlankTemplate) {
        blankTemplate = newBlankTemplate;
        return this;
    }
    
    public SpecialObjectsBuilder blankTemplate(TemplateBuilder newBlankTemplate) {
        if (newBlankTemplate == null) {
            blankTemplate = null;
        }
        else {
            blankTemplate = newBlankTemplate.build();
        }
        return this;
    }
    
    
    public SpecialObjectsBuilder rootTag(Tag newRootTag) {
        rootTag = newRootTag;
        return this;
    }
    
    public SpecialObjectsBuilder rootTag(TagBuilder newRootTag) {
        if (newRootTag == null) {
            rootTag = null;
        }
        else {
            rootTag = newRootTag.build();
        }
        return this;
    }
    
    
    public SpecialObjects build() {
        SpecialObjectsContainer container = new SpecialObjectsContainer();
        container.blankTemplate(blankTemplate);
        container.rootTag(rootTag);
        return container;
    }
}
