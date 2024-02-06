/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.ReportedDeviceContainer;
import org.ovirt.engine.sdk4.types.Ip;
import org.ovirt.engine.sdk4.types.Mac;
import org.ovirt.engine.sdk4.types.ReportedDevice;
import org.ovirt.engine.sdk4.types.ReportedDeviceType;
import org.ovirt.engine.sdk4.types.Vm;

public class ReportedDeviceBuilder {
    private String comment;
    private String description;
    private String href;
    private String id;
    private List<Ip> ips;
    private Mac mac;
    private String name;
    private ReportedDeviceType type;
    private Vm vm;
    
    public ReportedDeviceBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public ReportedDeviceBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public ReportedDeviceBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public ReportedDeviceBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public ReportedDeviceBuilder ips(List<Ip> newIps) {
        if (newIps != null) {
            if (ips == null) {
                ips = new ArrayList<>(newIps);
            }
            else {
                ips.addAll(newIps);
            }
        }
        return this;
    }
    
    public ReportedDeviceBuilder ips(Ip... newIps) {
        if (newIps != null) {
            if (ips == null) {
                ips = new ArrayList<>(newIps.length);
            }
            Collections.addAll(ips, newIps);
        }
        return this;
    }
    
    public ReportedDeviceBuilder ips(IpBuilder... newIps) {
        if (newIps != null) {
            if (ips == null) {
                ips = new ArrayList<>(newIps.length);
            }
            for (IpBuilder builder : newIps) {
                ips.add(builder.build());
            }
        }
        return this;
    }
    
    
    public ReportedDeviceBuilder mac(Mac newMac) {
        mac = newMac;
        return this;
    }
    
    public ReportedDeviceBuilder mac(MacBuilder newMac) {
        if (newMac == null) {
            mac = null;
        }
        else {
            mac = newMac.build();
        }
        return this;
    }
    
    
    public ReportedDeviceBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public ReportedDeviceBuilder type(ReportedDeviceType newType) {
        type = newType;
        return this;
    }
    
    
    public ReportedDeviceBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public ReportedDeviceBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public ReportedDevice build() {
        ReportedDeviceContainer container = new ReportedDeviceContainer();
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.ips(ips);
        container.mac(mac);
        container.name(name);
        container.type(type);
        container.vm(vm);
        return container;
    }
}
