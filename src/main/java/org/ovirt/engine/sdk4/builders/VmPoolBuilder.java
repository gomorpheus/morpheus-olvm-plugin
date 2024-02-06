/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.VmPoolContainer;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Display;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.RngDevice;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.VmPool;
import org.ovirt.engine.sdk4.types.VmPoolType;

public class VmPoolBuilder {
    private Boolean autoStorageSelect;
    private Cluster cluster;
    private String comment;
    private String description;
    private Display display;
    private String href;
    private String id;
    private InstanceType instanceType;
    private BigInteger maxUserVms;
    private String name;
    private List<Permission> permissions;
    private BigInteger prestartedVms;
    private RngDevice rngDevice;
    private BigInteger size;
    private Boolean soundcardEnabled;
    private Boolean stateful;
    private Template template;
    private Boolean tpmEnabled;
    private VmPoolType type;
    private Boolean useLatestTemplateVersion;
    private Vm vm;
    
    public VmPoolBuilder autoStorageSelect(boolean newAutoStorageSelect) {
        autoStorageSelect = Boolean.valueOf(newAutoStorageSelect);
        return this;
    }
    
    public VmPoolBuilder autoStorageSelect(Boolean newAutoStorageSelect) {
        autoStorageSelect = newAutoStorageSelect;
        return this;
    }
    
    
    public VmPoolBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public VmPoolBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public VmPoolBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public VmPoolBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public VmPoolBuilder display(Display newDisplay) {
        display = newDisplay;
        return this;
    }
    
    public VmPoolBuilder display(DisplayBuilder newDisplay) {
        if (newDisplay == null) {
            display = null;
        }
        else {
            display = newDisplay.build();
        }
        return this;
    }
    
    
    public VmPoolBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public VmPoolBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public VmPoolBuilder instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
        return this;
    }
    
    public VmPoolBuilder instanceType(InstanceTypeBuilder newInstanceType) {
        if (newInstanceType == null) {
            instanceType = null;
        }
        else {
            instanceType = newInstanceType.build();
        }
        return this;
    }
    
    
    public VmPoolBuilder maxUserVms(int newMaxUserVms) {
        maxUserVms = BigInteger.valueOf((long) newMaxUserVms);
        return this;
    }
    
    public VmPoolBuilder maxUserVms(Integer newMaxUserVms) {
        if (newMaxUserVms == null) {
            maxUserVms = null;
        }
        else {
            maxUserVms = BigInteger.valueOf(newMaxUserVms.longValue());
        }
        return this;
    }
    
    public VmPoolBuilder maxUserVms(long newMaxUserVms) {
        maxUserVms = BigInteger.valueOf(newMaxUserVms);
        return this;
    }
    
    public VmPoolBuilder maxUserVms(Long newMaxUserVms) {
        if (newMaxUserVms == null) {
            maxUserVms = null;
        }
        else {
            maxUserVms = BigInteger.valueOf(newMaxUserVms.longValue());
        }
        return this;
    }
    
    public VmPoolBuilder maxUserVms(BigInteger newMaxUserVms) {
        maxUserVms = newMaxUserVms;
        return this;
    }
    
    
    public VmPoolBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public VmPoolBuilder permissions(List<Permission> newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions);
            }
            else {
                permissions.addAll(newPermissions);
            }
        }
        return this;
    }
    
    public VmPoolBuilder permissions(Permission... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            Collections.addAll(permissions, newPermissions);
        }
        return this;
    }
    
    public VmPoolBuilder permissions(PermissionBuilder... newPermissions) {
        if (newPermissions != null) {
            if (permissions == null) {
                permissions = new ArrayList<>(newPermissions.length);
            }
            for (PermissionBuilder builder : newPermissions) {
                permissions.add(builder.build());
            }
        }
        return this;
    }
    
    
    public VmPoolBuilder prestartedVms(int newPrestartedVms) {
        prestartedVms = BigInteger.valueOf((long) newPrestartedVms);
        return this;
    }
    
    public VmPoolBuilder prestartedVms(Integer newPrestartedVms) {
        if (newPrestartedVms == null) {
            prestartedVms = null;
        }
        else {
            prestartedVms = BigInteger.valueOf(newPrestartedVms.longValue());
        }
        return this;
    }
    
    public VmPoolBuilder prestartedVms(long newPrestartedVms) {
        prestartedVms = BigInteger.valueOf(newPrestartedVms);
        return this;
    }
    
    public VmPoolBuilder prestartedVms(Long newPrestartedVms) {
        if (newPrestartedVms == null) {
            prestartedVms = null;
        }
        else {
            prestartedVms = BigInteger.valueOf(newPrestartedVms.longValue());
        }
        return this;
    }
    
    public VmPoolBuilder prestartedVms(BigInteger newPrestartedVms) {
        prestartedVms = newPrestartedVms;
        return this;
    }
    
    
    public VmPoolBuilder rngDevice(RngDevice newRngDevice) {
        rngDevice = newRngDevice;
        return this;
    }
    
    public VmPoolBuilder rngDevice(RngDeviceBuilder newRngDevice) {
        if (newRngDevice == null) {
            rngDevice = null;
        }
        else {
            rngDevice = newRngDevice.build();
        }
        return this;
    }
    
    
    public VmPoolBuilder size(int newSize) {
        size = BigInteger.valueOf((long) newSize);
        return this;
    }
    
    public VmPoolBuilder size(Integer newSize) {
        if (newSize == null) {
            size = null;
        }
        else {
            size = BigInteger.valueOf(newSize.longValue());
        }
        return this;
    }
    
    public VmPoolBuilder size(long newSize) {
        size = BigInteger.valueOf(newSize);
        return this;
    }
    
    public VmPoolBuilder size(Long newSize) {
        if (newSize == null) {
            size = null;
        }
        else {
            size = BigInteger.valueOf(newSize.longValue());
        }
        return this;
    }
    
    public VmPoolBuilder size(BigInteger newSize) {
        size = newSize;
        return this;
    }
    
    
    public VmPoolBuilder soundcardEnabled(boolean newSoundcardEnabled) {
        soundcardEnabled = Boolean.valueOf(newSoundcardEnabled);
        return this;
    }
    
    public VmPoolBuilder soundcardEnabled(Boolean newSoundcardEnabled) {
        soundcardEnabled = newSoundcardEnabled;
        return this;
    }
    
    
    public VmPoolBuilder stateful(boolean newStateful) {
        stateful = Boolean.valueOf(newStateful);
        return this;
    }
    
    public VmPoolBuilder stateful(Boolean newStateful) {
        stateful = newStateful;
        return this;
    }
    
    
    public VmPoolBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public VmPoolBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public VmPoolBuilder tpmEnabled(boolean newTpmEnabled) {
        tpmEnabled = Boolean.valueOf(newTpmEnabled);
        return this;
    }
    
    public VmPoolBuilder tpmEnabled(Boolean newTpmEnabled) {
        tpmEnabled = newTpmEnabled;
        return this;
    }
    
    
    public VmPoolBuilder type(VmPoolType newType) {
        type = newType;
        return this;
    }
    
    
    public VmPoolBuilder useLatestTemplateVersion(boolean newUseLatestTemplateVersion) {
        useLatestTemplateVersion = Boolean.valueOf(newUseLatestTemplateVersion);
        return this;
    }
    
    public VmPoolBuilder useLatestTemplateVersion(Boolean newUseLatestTemplateVersion) {
        useLatestTemplateVersion = newUseLatestTemplateVersion;
        return this;
    }
    
    
    public VmPoolBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public VmPoolBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public VmPool build() {
        VmPoolContainer container = new VmPoolContainer();
        container.autoStorageSelect(autoStorageSelect);
        container.cluster(cluster);
        container.comment(comment);
        container.description(description);
        container.display(display);
        container.href(href);
        container.id(id);
        container.instanceType(instanceType);
        container.maxUserVms(maxUserVms);
        container.name(name);
        container.permissions(permissions);
        container.prestartedVms(prestartedVms);
        container.rngDevice(rngDevice);
        container.size(size);
        container.soundcardEnabled(soundcardEnabled);
        container.stateful(stateful);
        container.template(template);
        container.tpmEnabled(tpmEnabled);
        container.type(type);
        container.useLatestTemplateVersion(useLatestTemplateVersion);
        container.vm(vm);
        return container;
    }
}
