/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.math.BigDecimal;
import java.util.List;
import org.ovirt.engine.sdk4.types.AffinityGroup;
import org.ovirt.engine.sdk4.types.AffinityLabel;
import org.ovirt.engine.sdk4.types.AffinityRule;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Vm;

public class AffinityGroupContainer extends IdentifiedContainer implements AffinityGroup {
    private Boolean broken;
    private Boolean enforcing;
    private AffinityRule hostsRule;
    private Boolean positive;
    private BigDecimal priority;
    private AffinityRule vmsRule;
    private Cluster cluster;
    private List<AffinityLabel> hostLabels;
    private List<Host> hosts;
    private List<AffinityLabel> vmLabels;
    private List<Vm> vms;
    
    public boolean broken() {
        return broken;
    }
    
    public void broken(boolean newBroken) {
        broken = Boolean.valueOf(newBroken);
    }
    
    public void broken(Boolean newBroken) {
        broken = newBroken;
    }
    
    public boolean brokenPresent() {
        return broken != null;
    }
    
    public boolean enforcing() {
        return enforcing;
    }
    
    public void enforcing(boolean newEnforcing) {
        enforcing = Boolean.valueOf(newEnforcing);
    }
    
    public void enforcing(Boolean newEnforcing) {
        enforcing = newEnforcing;
    }
    
    public boolean enforcingPresent() {
        return enforcing != null;
    }
    
    public AffinityRule hostsRule() {
        return hostsRule;
    }
    
    public void hostsRule(AffinityRule newHostsRule) {
        hostsRule = newHostsRule;
    }
    
    public boolean hostsRulePresent() {
        return hostsRule != null;
    }
    
    public boolean positive() {
        return positive;
    }
    
    public void positive(boolean newPositive) {
        positive = Boolean.valueOf(newPositive);
    }
    
    public void positive(Boolean newPositive) {
        positive = newPositive;
    }
    
    public boolean positivePresent() {
        return positive != null;
    }
    
    public BigDecimal priority() {
        return priority;
    }
    
    public void priority(BigDecimal newPriority) {
        priority = newPriority;
    }
    
    public boolean priorityPresent() {
        return priority != null;
    }
    
    public AffinityRule vmsRule() {
        return vmsRule;
    }
    
    public void vmsRule(AffinityRule newVmsRule) {
        vmsRule = newVmsRule;
    }
    
    public boolean vmsRulePresent() {
        return vmsRule != null;
    }
    
    public Cluster cluster() {
        return cluster;
    }
    
    public void cluster(Cluster newCluster) {
        cluster = newCluster;
    }
    
    public boolean clusterPresent() {
        return cluster != null;
    }
    
    public List<AffinityLabel> hostLabels() {
        return makeUnmodifiableList(hostLabels);
    }
    
    public void hostLabels(List<AffinityLabel> newHostLabels) {
        hostLabels = makeArrayList(newHostLabels);
    }
    
    public boolean hostLabelsPresent() {
        return hostLabels != null && !hostLabels.isEmpty();
    }
    
    public List<Host> hosts() {
        return makeUnmodifiableList(hosts);
    }
    
    public void hosts(List<Host> newHosts) {
        hosts = makeArrayList(newHosts);
    }
    
    public boolean hostsPresent() {
        return hosts != null && !hosts.isEmpty();
    }
    
    public List<AffinityLabel> vmLabels() {
        return makeUnmodifiableList(vmLabels);
    }
    
    public void vmLabels(List<AffinityLabel> newVmLabels) {
        vmLabels = makeArrayList(newVmLabels);
    }
    
    public boolean vmLabelsPresent() {
        return vmLabels != null && !vmLabels.isEmpty();
    }
    
    public List<Vm> vms() {
        return makeUnmodifiableList(vms);
    }
    
    public void vms(List<Vm> newVms) {
        vms = makeArrayList(newVms);
    }
    
    public boolean vmsPresent() {
        return vms != null && !vms.isEmpty();
    }
    
}
