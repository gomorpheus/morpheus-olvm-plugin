/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Disk;
import org.ovirt.engine.sdk4.types.GlusterBrick;
import org.ovirt.engine.sdk4.types.GlusterVolume;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.Nic;
import org.ovirt.engine.sdk4.types.NumaNode;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.StatisticKind;
import org.ovirt.engine.sdk4.types.StatisticUnit;
import org.ovirt.engine.sdk4.types.Step;
import org.ovirt.engine.sdk4.types.Value;
import org.ovirt.engine.sdk4.types.ValueType;
import org.ovirt.engine.sdk4.types.Vm;

public class StatisticContainer extends IdentifiedContainer implements Statistic {
    private StatisticKind kind;
    private ValueType type;
    private StatisticUnit unit;
    private List<Value> values;
    private GlusterBrick brick;
    private Disk disk;
    private GlusterVolume glusterVolume;
    private Host host;
    private HostNic hostNic;
    private NumaNode hostNumaNode;
    private Nic nic;
    private Step step;
    private Vm vm;
    
    public StatisticKind kind() {
        return kind;
    }
    
    public void kind(StatisticKind newKind) {
        kind = newKind;
    }
    
    public boolean kindPresent() {
        return kind != null;
    }
    
    public ValueType type() {
        return type;
    }
    
    public void type(ValueType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public StatisticUnit unit() {
        return unit;
    }
    
    public void unit(StatisticUnit newUnit) {
        unit = newUnit;
    }
    
    public boolean unitPresent() {
        return unit != null;
    }
    
    public List<Value> values() {
        return makeUnmodifiableList(values);
    }
    
    public void values(List<Value> newValues) {
        values = makeArrayList(newValues);
    }
    
    public boolean valuesPresent() {
        return values != null && !values.isEmpty();
    }
    
    public GlusterBrick brick() {
        return brick;
    }
    
    public void brick(GlusterBrick newBrick) {
        brick = newBrick;
    }
    
    public boolean brickPresent() {
        return brick != null;
    }
    
    public Disk disk() {
        return disk;
    }
    
    public void disk(Disk newDisk) {
        disk = newDisk;
    }
    
    public boolean diskPresent() {
        return disk != null;
    }
    
    public GlusterVolume glusterVolume() {
        return glusterVolume;
    }
    
    public void glusterVolume(GlusterVolume newGlusterVolume) {
        glusterVolume = newGlusterVolume;
    }
    
    public boolean glusterVolumePresent() {
        return glusterVolume != null;
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
    public HostNic hostNic() {
        return hostNic;
    }
    
    public void hostNic(HostNic newHostNic) {
        hostNic = newHostNic;
    }
    
    public boolean hostNicPresent() {
        return hostNic != null;
    }
    
    public NumaNode hostNumaNode() {
        return hostNumaNode;
    }
    
    public void hostNumaNode(NumaNode newHostNumaNode) {
        hostNumaNode = newHostNumaNode;
    }
    
    public boolean hostNumaNodePresent() {
        return hostNumaNode != null;
    }
    
    public Nic nic() {
        return nic;
    }
    
    public void nic(Nic newNic) {
        nic = newNic;
    }
    
    public boolean nicPresent() {
        return nic != null;
    }
    
    public Step step() {
        return step;
    }
    
    public void step(Step newStep) {
        step = newStep;
    }
    
    public boolean stepPresent() {
        return step != null;
    }
    
    public Vm vm() {
        return vm;
    }
    
    public void vm(Vm newVm) {
        vm = newVm;
    }
    
    public boolean vmPresent() {
        return vm != null;
    }
    
}
