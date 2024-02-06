/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.VendorContainer;
import org.ovirt.engine.sdk4.types.Vendor;

public class VendorBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    
    public VendorBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public VendorBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public VendorBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public VendorBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public VendorBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public Vendor build() {
        VendorContainer container = new VendorContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        return container;
    }
}
