/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ProductContainer;
import org.ovirt.engine.sdk4.types.Product;

public class ProductBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    
    public ProductBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ProductBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ProductBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ProductBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ProductBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public Product build() {
        ProductContainer container = new ProductContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        return container;
    }
}
