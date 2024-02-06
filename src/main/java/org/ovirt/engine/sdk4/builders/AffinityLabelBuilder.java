/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.AffinityLabelContainer;
import org.ovirt.engine.sdk4.types.AffinityLabel;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Vm;

public class AffinityLabelBuilder {
    private String comment;
    private String description;
    private Boolean hasImplicitAffinityGroup;
    private List<Host> hosts;
    private String href;
    private String id;
    private String name;
    private Boolean readOnly;
    private List<Vm> vms;
    
    public AffinityLabelBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public AffinityLabelBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public AffinityLabelBuilder hasImplicitAffinityGroup(boolean newHasImplicitAffinityGroup) {
        hasImplicitAffinityGroup = Boolean.valueOf(newHasImplicitAffinityGroup);
        return this;
    }
    
    public AffinityLabelBuilder hasImplicitAffinityGroup(Boolean newHasImplicitAffinityGroup) {
        hasImplicitAffinityGroup = newHasImplicitAffinityGroup;
        return this;
    }
    
    
    public AffinityLabelBuilder hosts(List<Host> newHosts) {
        if (newHosts != null) {
            if (hosts == null) {
                hosts = new ArrayList<>(newHosts);
            }
            else {
                hosts.addAll(newHosts);
            }
        }
        return this;
    }
    
    public AffinityLabelBuilder hosts(Host... newHosts) {
        if (newHosts != null) {
            if (hosts == null) {
                hosts = new ArrayList<>(newHosts.length);
            }
            Collections.addAll(hosts, newHosts);
        }
        return this;
    }
    
    public AffinityLabelBuilder hosts(HostBuilder... newHosts) {
        if (newHosts != null) {
            if (hosts == null) {
                hosts = new ArrayList<>(newHosts.length);
            }
            for (HostBuilder builder : newHosts) {
                hosts.add(builder.build());
            }
        }
        return this;
    }
    
    
    public AffinityLabelBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public AffinityLabelBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public AffinityLabelBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public AffinityLabelBuilder readOnly(boolean newReadOnly) {
        readOnly = Boolean.valueOf(newReadOnly);
        return this;
    }
    
    public AffinityLabelBuilder readOnly(Boolean newReadOnly) {
        readOnly = newReadOnly;
        return this;
    }
    
    
    public AffinityLabelBuilder vms(List<Vm> newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms);
            }
            else {
                vms.addAll(newVms);
            }
        }
        return this;
    }
    
    public AffinityLabelBuilder vms(Vm... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            Collections.addAll(vms, newVms);
        }
        return this;
    }
    
    public AffinityLabelBuilder vms(VmBuilder... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            for (VmBuilder builder : newVms) {
                vms.add(builder.build());
            }
        }
        return this;
    }
    
    
    public AffinityLabel build() {
        AffinityLabelContainer container = new AffinityLabelContainer();
        container.comment(comment);
        container.description(description);
        container.hasImplicitAffinityGroup(hasImplicitAffinityGroup);
        container.hosts(hosts);
        container.href(href);
        container.id(id);
        container.name(name);
        container.readOnly(readOnly);
        container.vms(vms);
        return container;
    }
}
