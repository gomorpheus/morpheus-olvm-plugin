/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Display;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.RngDevice;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.VmPool;
import org.ovirt.engine.sdk4.types.VmPoolType;

public class VmPoolContainer extends IdentifiedContainer implements VmPool {
    private Boolean autoStorageSelect;
    private Display display;
    private BigInteger maxUserVms;
    private BigInteger prestartedVms;
    private RngDevice rngDevice;
    private BigInteger size;
    private Boolean soundcardEnabled;
    private Boolean stateful;
    private Boolean tpmEnabled;
    private VmPoolType type;
    private Boolean useLatestTemplateVersion;
    private Cluster cluster;
    private InstanceType instanceType;
    private List<Permission> permissions;
    private Template template;
    private Vm vm;
    
    public boolean autoStorageSelect() {
        return autoStorageSelect;
    }
    
    public void autoStorageSelect(boolean newAutoStorageSelect) {
        autoStorageSelect = Boolean.valueOf(newAutoStorageSelect);
    }
    
    public void autoStorageSelect(Boolean newAutoStorageSelect) {
        autoStorageSelect = newAutoStorageSelect;
    }
    
    public boolean autoStorageSelectPresent() {
        return autoStorageSelect != null;
    }
    
    public Display display() {
        return display;
    }
    
    public void display(Display newDisplay) {
        display = newDisplay;
    }
    
    public boolean displayPresent() {
        return display != null;
    }
    
    public BigInteger maxUserVms() {
        return maxUserVms;
    }
    
    public Byte maxUserVmsAsByte() {
        return asByte("VmPool", "maxUserVms", maxUserVms);
    }
    
    public Short maxUserVmsAsShort() {
        return asShort("VmPool", "maxUserVms", maxUserVms);
    }
    
    public Integer maxUserVmsAsInteger() {
        return asInteger("VmPool", "maxUserVms", maxUserVms);
    }
    
    public Long maxUserVmsAsLong() {
        return asLong("VmPool", "maxUserVms", maxUserVms);
    }
    
    public void maxUserVms(BigInteger newMaxUserVms) {
        maxUserVms = newMaxUserVms;
    }
    
    public boolean maxUserVmsPresent() {
        return maxUserVms != null;
    }
    
    public BigInteger prestartedVms() {
        return prestartedVms;
    }
    
    public Byte prestartedVmsAsByte() {
        return asByte("VmPool", "prestartedVms", prestartedVms);
    }
    
    public Short prestartedVmsAsShort() {
        return asShort("VmPool", "prestartedVms", prestartedVms);
    }
    
    public Integer prestartedVmsAsInteger() {
        return asInteger("VmPool", "prestartedVms", prestartedVms);
    }
    
    public Long prestartedVmsAsLong() {
        return asLong("VmPool", "prestartedVms", prestartedVms);
    }
    
    public void prestartedVms(BigInteger newPrestartedVms) {
        prestartedVms = newPrestartedVms;
    }
    
    public boolean prestartedVmsPresent() {
        return prestartedVms != null;
    }
    
    public RngDevice rngDevice() {
        return rngDevice;
    }
    
    public void rngDevice(RngDevice newRngDevice) {
        rngDevice = newRngDevice;
    }
    
    public boolean rngDevicePresent() {
        return rngDevice != null;
    }
    
    public BigInteger size() {
        return size;
    }
    
    public Byte sizeAsByte() {
        return asByte("VmPool", "size", size);
    }
    
    public Short sizeAsShort() {
        return asShort("VmPool", "size", size);
    }
    
    public Integer sizeAsInteger() {
        return asInteger("VmPool", "size", size);
    }
    
    public Long sizeAsLong() {
        return asLong("VmPool", "size", size);
    }
    
    public void size(BigInteger newSize) {
        size = newSize;
    }
    
    public boolean sizePresent() {
        return size != null;
    }
    
    public boolean soundcardEnabled() {
        return soundcardEnabled;
    }
    
    public void soundcardEnabled(boolean newSoundcardEnabled) {
        soundcardEnabled = Boolean.valueOf(newSoundcardEnabled);
    }
    
    public void soundcardEnabled(Boolean newSoundcardEnabled) {
        soundcardEnabled = newSoundcardEnabled;
    }
    
    public boolean soundcardEnabledPresent() {
        return soundcardEnabled != null;
    }
    
    public boolean stateful() {
        return stateful;
    }
    
    public void stateful(boolean newStateful) {
        stateful = Boolean.valueOf(newStateful);
    }
    
    public void stateful(Boolean newStateful) {
        stateful = newStateful;
    }
    
    public boolean statefulPresent() {
        return stateful != null;
    }
    
    public boolean tpmEnabled() {
        return tpmEnabled;
    }
    
    public void tpmEnabled(boolean newTpmEnabled) {
        tpmEnabled = Boolean.valueOf(newTpmEnabled);
    }
    
    public void tpmEnabled(Boolean newTpmEnabled) {
        tpmEnabled = newTpmEnabled;
    }
    
    public boolean tpmEnabledPresent() {
        return tpmEnabled != null;
    }
    
    public VmPoolType type() {
        return type;
    }
    
    public void type(VmPoolType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public boolean useLatestTemplateVersion() {
        return useLatestTemplateVersion;
    }
    
    public void useLatestTemplateVersion(boolean newUseLatestTemplateVersion) {
        useLatestTemplateVersion = Boolean.valueOf(newUseLatestTemplateVersion);
    }
    
    public void useLatestTemplateVersion(Boolean newUseLatestTemplateVersion) {
        useLatestTemplateVersion = newUseLatestTemplateVersion;
    }
    
    public boolean useLatestTemplateVersionPresent() {
        return useLatestTemplateVersion != null;
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
    
    public InstanceType instanceType() {
        return instanceType;
    }
    
    public void instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
    }
    
    public boolean instanceTypePresent() {
        return instanceType != null;
    }
    
    public List<Permission> permissions() {
        return makeUnmodifiableList(permissions);
    }
    
    public void permissions(List<Permission> newPermissions) {
        permissions = makeArrayList(newPermissions);
    }
    
    public boolean permissionsPresent() {
        return permissions != null && !permissions.isEmpty();
    }
    
    public Template template() {
        return template;
    }
    
    public void template(Template newTemplate) {
        template = newTemplate;
    }
    
    public boolean templatePresent() {
        return template != null;
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
