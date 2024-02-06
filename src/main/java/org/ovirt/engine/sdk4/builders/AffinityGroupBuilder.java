/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.AffinityGroupContainer;
import org.ovirt.engine.sdk4.types.AffinityGroup;
import org.ovirt.engine.sdk4.types.AffinityLabel;
import org.ovirt.engine.sdk4.types.AffinityRule;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Vm;

public class AffinityGroupBuilder {
    private Boolean broken;
    private Cluster cluster;
    private String comment;
    private String description;
    private Boolean enforcing;
    private List<AffinityLabel> hostLabels;
    private List<Host> hosts;
    private AffinityRule hostsRule;
    private String href;
    private String id;
    private String name;
    private Boolean positive;
    private BigDecimal priority;
    private List<AffinityLabel> vmLabels;
    private List<Vm> vms;
    private AffinityRule vmsRule;
    
    public AffinityGroupBuilder broken(boolean newBroken) {
        broken = Boolean.valueOf(newBroken);
        return this;
    }
    
    public AffinityGroupBuilder broken(Boolean newBroken) {
        broken = newBroken;
        return this;
    }
    
    
    public AffinityGroupBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public AffinityGroupBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public AffinityGroupBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public AffinityGroupBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public AffinityGroupBuilder enforcing(boolean newEnforcing) {
        enforcing = Boolean.valueOf(newEnforcing);
        return this;
    }
    
    public AffinityGroupBuilder enforcing(Boolean newEnforcing) {
        enforcing = newEnforcing;
        return this;
    }
    
    
    public AffinityGroupBuilder hostLabels(List<AffinityLabel> newHostLabels) {
        if (newHostLabels != null) {
            if (hostLabels == null) {
                hostLabels = new ArrayList<>(newHostLabels);
            }
            else {
                hostLabels.addAll(newHostLabels);
            }
        }
        return this;
    }
    
    public AffinityGroupBuilder hostLabels(AffinityLabel... newHostLabels) {
        if (newHostLabels != null) {
            if (hostLabels == null) {
                hostLabels = new ArrayList<>(newHostLabels.length);
            }
            Collections.addAll(hostLabels, newHostLabels);
        }
        return this;
    }
    
    public AffinityGroupBuilder hostLabels(AffinityLabelBuilder... newHostLabels) {
        if (newHostLabels != null) {
            if (hostLabels == null) {
                hostLabels = new ArrayList<>(newHostLabels.length);
            }
            for (AffinityLabelBuilder builder : newHostLabels) {
                hostLabels.add(builder.build());
            }
        }
        return this;
    }
    
    
    public AffinityGroupBuilder hosts(List<Host> newHosts) {
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
    
    public AffinityGroupBuilder hosts(Host... newHosts) {
        if (newHosts != null) {
            if (hosts == null) {
                hosts = new ArrayList<>(newHosts.length);
            }
            Collections.addAll(hosts, newHosts);
        }
        return this;
    }
    
    public AffinityGroupBuilder hosts(HostBuilder... newHosts) {
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
    
    
    public AffinityGroupBuilder hostsRule(AffinityRule newHostsRule) {
        hostsRule = newHostsRule;
        return this;
    }
    
    public AffinityGroupBuilder hostsRule(AffinityRuleBuilder newHostsRule) {
        if (newHostsRule == null) {
            hostsRule = null;
        }
        else {
            hostsRule = newHostsRule.build();
        }
        return this;
    }
    
    
    public AffinityGroupBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public AffinityGroupBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public AffinityGroupBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public AffinityGroupBuilder positive(boolean newPositive) {
        positive = Boolean.valueOf(newPositive);
        return this;
    }
    
    public AffinityGroupBuilder positive(Boolean newPositive) {
        positive = newPositive;
        return this;
    }
    
    
    public AffinityGroupBuilder priority(float newPriority) {
        priority = BigDecimal.valueOf((double) newPriority);
        return this;
    }
    
    public AffinityGroupBuilder priority(Float newPriority) {
        if (newPriority == null) {
            priority = null;
        }
        else {
            priority = BigDecimal.valueOf(newPriority.doubleValue());
        }
        return this;
    }
    
    public AffinityGroupBuilder priority(double newPriority) {
        priority = BigDecimal.valueOf(newPriority);
        return this;
    }
    
    public AffinityGroupBuilder priority(Double newPriority) {
        if (newPriority == null) {
            priority = null;
        }
        else {
            priority = BigDecimal.valueOf(newPriority.doubleValue());
        }
        return this;
    }
    
    public AffinityGroupBuilder priority(BigDecimal newPriority) {
        priority = newPriority;
        return this;
    }
    
    
    public AffinityGroupBuilder vmLabels(List<AffinityLabel> newVmLabels) {
        if (newVmLabels != null) {
            if (vmLabels == null) {
                vmLabels = new ArrayList<>(newVmLabels);
            }
            else {
                vmLabels.addAll(newVmLabels);
            }
        }
        return this;
    }
    
    public AffinityGroupBuilder vmLabels(AffinityLabel... newVmLabels) {
        if (newVmLabels != null) {
            if (vmLabels == null) {
                vmLabels = new ArrayList<>(newVmLabels.length);
            }
            Collections.addAll(vmLabels, newVmLabels);
        }
        return this;
    }
    
    public AffinityGroupBuilder vmLabels(AffinityLabelBuilder... newVmLabels) {
        if (newVmLabels != null) {
            if (vmLabels == null) {
                vmLabels = new ArrayList<>(newVmLabels.length);
            }
            for (AffinityLabelBuilder builder : newVmLabels) {
                vmLabels.add(builder.build());
            }
        }
        return this;
    }
    
    
    public AffinityGroupBuilder vms(List<Vm> newVms) {
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
    
    public AffinityGroupBuilder vms(Vm... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            Collections.addAll(vms, newVms);
        }
        return this;
    }
    
    public AffinityGroupBuilder vms(VmBuilder... newVms) {
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
    
    
    public AffinityGroupBuilder vmsRule(AffinityRule newVmsRule) {
        vmsRule = newVmsRule;
        return this;
    }
    
    public AffinityGroupBuilder vmsRule(AffinityRuleBuilder newVmsRule) {
        if (newVmsRule == null) {
            vmsRule = null;
        }
        else {
            vmsRule = newVmsRule.build();
        }
        return this;
    }
    
    
    public AffinityGroup build() {
        AffinityGroupContainer container = new AffinityGroupContainer();
        container.broken(broken);
        container.cluster(cluster);
        container.comment(comment);
        container.description(description);
        container.enforcing(enforcing);
        container.hostLabels(hostLabels);
        container.hosts(hosts);
        container.hostsRule(hostsRule);
        container.href(href);
        container.id(id);
        container.name(name);
        container.positive(positive);
        container.priority(priority);
        container.vmLabels(vmLabels);
        container.vms(vms);
        container.vmsRule(vmsRule);
        return container;
    }
}
