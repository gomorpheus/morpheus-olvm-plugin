/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ApplicationContainer;
import org.ovirt.engine.sdk4.types.Application;
import org.ovirt.engine.sdk4.types.Vm;

public class ApplicationBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    private Vm vm;
    
    public ApplicationBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ApplicationBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ApplicationBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ApplicationBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ApplicationBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ApplicationBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public ApplicationBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public Application build() {
        ApplicationContainer container = new ApplicationContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.vm(vm);
        return container;
    }
}
