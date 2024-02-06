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
import org.ovirt.engine.sdk4.internal.containers.NicContainer;
import org.ovirt.engine.sdk4.types.BootProtocol;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.Mac;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.NetworkAttachment;
import org.ovirt.engine.sdk4.types.NetworkFilterParameter;
import org.ovirt.engine.sdk4.types.NetworkLabel;
import org.ovirt.engine.sdk4.types.Nic;
import org.ovirt.engine.sdk4.types.NicInterface;
import org.ovirt.engine.sdk4.types.ReportedDevice;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.VnicProfile;

public class NicBuilder {
    private BootProtocol bootProtocol;
    private String comment;
    private String description;
    private String href;
    private String id;
    private InstanceType instanceType;
    private NicInterface interface_;
    private Boolean linked;
    private Mac mac;
    private String name;
    private Network network;
    private List<NetworkAttachment> networkAttachments;
    private List<NetworkFilterParameter> networkFilterParameters;
    private List<NetworkLabel> networkLabels;
    private Boolean onBoot;
    private Boolean plugged;
    private List<ReportedDevice> reportedDevices;
    private List<Statistic> statistics;
    private Boolean synced;
    private Template template;
    private List<NetworkLabel> virtualFunctionAllowedLabels;
    private List<Network> virtualFunctionAllowedNetworks;
    private Vm vm;
    private List<Vm> vms;
    private VnicProfile vnicProfile;
    
    public NicBuilder bootProtocol(BootProtocol newBootProtocol) {
        bootProtocol = newBootProtocol;
        return this;
    }
    
    
    public NicBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public NicBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public NicBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public NicBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public NicBuilder instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
        return this;
    }
    
    public NicBuilder instanceType(InstanceTypeBuilder newInstanceType) {
        if (newInstanceType == null) {
            instanceType = null;
        }
        else {
            instanceType = newInstanceType.build();
        }
        return this;
    }
    
    
    public NicBuilder interface_(NicInterface newInterface) {
        interface_ = newInterface;
        return this;
    }
    
    
    public NicBuilder linked(boolean newLinked) {
        linked = Boolean.valueOf(newLinked);
        return this;
    }
    
    public NicBuilder linked(Boolean newLinked) {
        linked = newLinked;
        return this;
    }
    
    
    public NicBuilder mac(Mac newMac) {
        mac = newMac;
        return this;
    }
    
    public NicBuilder mac(MacBuilder newMac) {
        if (newMac == null) {
            mac = null;
        }
        else {
            mac = newMac.build();
        }
        return this;
    }
    
    
    public NicBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public NicBuilder network(Network newNetwork) {
        network = newNetwork;
        return this;
    }
    
    public NicBuilder network(NetworkBuilder newNetwork) {
        if (newNetwork == null) {
            network = null;
        }
        else {
            network = newNetwork.build();
        }
        return this;
    }
    
    
    public NicBuilder networkAttachments(List<NetworkAttachment> newNetworkAttachments) {
        if (newNetworkAttachments != null) {
            if (networkAttachments == null) {
                networkAttachments = new ArrayList<>(newNetworkAttachments);
            }
            else {
                networkAttachments.addAll(newNetworkAttachments);
            }
        }
        return this;
    }
    
    public NicBuilder networkAttachments(NetworkAttachment... newNetworkAttachments) {
        if (newNetworkAttachments != null) {
            if (networkAttachments == null) {
                networkAttachments = new ArrayList<>(newNetworkAttachments.length);
            }
            Collections.addAll(networkAttachments, newNetworkAttachments);
        }
        return this;
    }
    
    public NicBuilder networkAttachments(NetworkAttachmentBuilder... newNetworkAttachments) {
        if (newNetworkAttachments != null) {
            if (networkAttachments == null) {
                networkAttachments = new ArrayList<>(newNetworkAttachments.length);
            }
            for (NetworkAttachmentBuilder builder : newNetworkAttachments) {
                networkAttachments.add(builder.build());
            }
        }
        return this;
    }
    
    
    public NicBuilder networkFilterParameters(List<NetworkFilterParameter> newNetworkFilterParameters) {
        if (newNetworkFilterParameters != null) {
            if (networkFilterParameters == null) {
                networkFilterParameters = new ArrayList<>(newNetworkFilterParameters);
            }
            else {
                networkFilterParameters.addAll(newNetworkFilterParameters);
            }
        }
        return this;
    }
    
    public NicBuilder networkFilterParameters(NetworkFilterParameter... newNetworkFilterParameters) {
        if (newNetworkFilterParameters != null) {
            if (networkFilterParameters == null) {
                networkFilterParameters = new ArrayList<>(newNetworkFilterParameters.length);
            }
            Collections.addAll(networkFilterParameters, newNetworkFilterParameters);
        }
        return this;
    }
    
    public NicBuilder networkFilterParameters(NetworkFilterParameterBuilder... newNetworkFilterParameters) {
        if (newNetworkFilterParameters != null) {
            if (networkFilterParameters == null) {
                networkFilterParameters = new ArrayList<>(newNetworkFilterParameters.length);
            }
            for (NetworkFilterParameterBuilder builder : newNetworkFilterParameters) {
                networkFilterParameters.add(builder.build());
            }
        }
        return this;
    }
    
    
    public NicBuilder networkLabels(List<NetworkLabel> newNetworkLabels) {
        if (newNetworkLabels != null) {
            if (networkLabels == null) {
                networkLabels = new ArrayList<>(newNetworkLabels);
            }
            else {
                networkLabels.addAll(newNetworkLabels);
            }
        }
        return this;
    }
    
    public NicBuilder networkLabels(NetworkLabel... newNetworkLabels) {
        if (newNetworkLabels != null) {
            if (networkLabels == null) {
                networkLabels = new ArrayList<>(newNetworkLabels.length);
            }
            Collections.addAll(networkLabels, newNetworkLabels);
        }
        return this;
    }
    
    public NicBuilder networkLabels(NetworkLabelBuilder... newNetworkLabels) {
        if (newNetworkLabels != null) {
            if (networkLabels == null) {
                networkLabels = new ArrayList<>(newNetworkLabels.length);
            }
            for (NetworkLabelBuilder builder : newNetworkLabels) {
                networkLabels.add(builder.build());
            }
        }
        return this;
    }
    
    
    public NicBuilder onBoot(boolean newOnBoot) {
        onBoot = Boolean.valueOf(newOnBoot);
        return this;
    }
    
    public NicBuilder onBoot(Boolean newOnBoot) {
        onBoot = newOnBoot;
        return this;
    }
    
    
    public NicBuilder plugged(boolean newPlugged) {
        plugged = Boolean.valueOf(newPlugged);
        return this;
    }
    
    public NicBuilder plugged(Boolean newPlugged) {
        plugged = newPlugged;
        return this;
    }
    
    
    public NicBuilder reportedDevices(List<ReportedDevice> newReportedDevices) {
        if (newReportedDevices != null) {
            if (reportedDevices == null) {
                reportedDevices = new ArrayList<>(newReportedDevices);
            }
            else {
                reportedDevices.addAll(newReportedDevices);
            }
        }
        return this;
    }
    
    public NicBuilder reportedDevices(ReportedDevice... newReportedDevices) {
        if (newReportedDevices != null) {
            if (reportedDevices == null) {
                reportedDevices = new ArrayList<>(newReportedDevices.length);
            }
            Collections.addAll(reportedDevices, newReportedDevices);
        }
        return this;
    }
    
    public NicBuilder reportedDevices(ReportedDeviceBuilder... newReportedDevices) {
        if (newReportedDevices != null) {
            if (reportedDevices == null) {
                reportedDevices = new ArrayList<>(newReportedDevices.length);
            }
            for (ReportedDeviceBuilder builder : newReportedDevices) {
                reportedDevices.add(builder.build());
            }
        }
        return this;
    }
    
    
    public NicBuilder statistics(List<Statistic> newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics);
            }
            else {
                statistics.addAll(newStatistics);
            }
        }
        return this;
    }
    
    public NicBuilder statistics(Statistic... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            Collections.addAll(statistics, newStatistics);
        }
        return this;
    }
    
    public NicBuilder statistics(StatisticBuilder... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            for (StatisticBuilder builder : newStatistics) {
                statistics.add(builder.build());
            }
        }
        return this;
    }
    
    
    public NicBuilder synced(boolean newSynced) {
        synced = Boolean.valueOf(newSynced);
        return this;
    }
    
    public NicBuilder synced(Boolean newSynced) {
        synced = newSynced;
        return this;
    }
    
    
    public NicBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public NicBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public NicBuilder virtualFunctionAllowedLabels(List<NetworkLabel> newVirtualFunctionAllowedLabels) {
        if (newVirtualFunctionAllowedLabels != null) {
            if (virtualFunctionAllowedLabels == null) {
                virtualFunctionAllowedLabels = new ArrayList<>(newVirtualFunctionAllowedLabels);
            }
            else {
                virtualFunctionAllowedLabels.addAll(newVirtualFunctionAllowedLabels);
            }
        }
        return this;
    }
    
    public NicBuilder virtualFunctionAllowedLabels(NetworkLabel... newVirtualFunctionAllowedLabels) {
        if (newVirtualFunctionAllowedLabels != null) {
            if (virtualFunctionAllowedLabels == null) {
                virtualFunctionAllowedLabels = new ArrayList<>(newVirtualFunctionAllowedLabels.length);
            }
            Collections.addAll(virtualFunctionAllowedLabels, newVirtualFunctionAllowedLabels);
        }
        return this;
    }
    
    public NicBuilder virtualFunctionAllowedLabels(NetworkLabelBuilder... newVirtualFunctionAllowedLabels) {
        if (newVirtualFunctionAllowedLabels != null) {
            if (virtualFunctionAllowedLabels == null) {
                virtualFunctionAllowedLabels = new ArrayList<>(newVirtualFunctionAllowedLabels.length);
            }
            for (NetworkLabelBuilder builder : newVirtualFunctionAllowedLabels) {
                virtualFunctionAllowedLabels.add(builder.build());
            }
        }
        return this;
    }
    
    
    public NicBuilder virtualFunctionAllowedNetworks(List<Network> newVirtualFunctionAllowedNetworks) {
        if (newVirtualFunctionAllowedNetworks != null) {
            if (virtualFunctionAllowedNetworks == null) {
                virtualFunctionAllowedNetworks = new ArrayList<>(newVirtualFunctionAllowedNetworks);
            }
            else {
                virtualFunctionAllowedNetworks.addAll(newVirtualFunctionAllowedNetworks);
            }
        }
        return this;
    }
    
    public NicBuilder virtualFunctionAllowedNetworks(Network... newVirtualFunctionAllowedNetworks) {
        if (newVirtualFunctionAllowedNetworks != null) {
            if (virtualFunctionAllowedNetworks == null) {
                virtualFunctionAllowedNetworks = new ArrayList<>(newVirtualFunctionAllowedNetworks.length);
            }
            Collections.addAll(virtualFunctionAllowedNetworks, newVirtualFunctionAllowedNetworks);
        }
        return this;
    }
    
    public NicBuilder virtualFunctionAllowedNetworks(NetworkBuilder... newVirtualFunctionAllowedNetworks) {
        if (newVirtualFunctionAllowedNetworks != null) {
            if (virtualFunctionAllowedNetworks == null) {
                virtualFunctionAllowedNetworks = new ArrayList<>(newVirtualFunctionAllowedNetworks.length);
            }
            for (NetworkBuilder builder : newVirtualFunctionAllowedNetworks) {
                virtualFunctionAllowedNetworks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public NicBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public NicBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public NicBuilder vms(List<Vm> newVms) {
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
    
    public NicBuilder vms(Vm... newVms) {
        if (newVms != null) {
            if (vms == null) {
                vms = new ArrayList<>(newVms.length);
            }
            Collections.addAll(vms, newVms);
        }
        return this;
    }
    
    public NicBuilder vms(VmBuilder... newVms) {
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
    
    
    public NicBuilder vnicProfile(VnicProfile newVnicProfile) {
        vnicProfile = newVnicProfile;
        return this;
    }
    
    public NicBuilder vnicProfile(VnicProfileBuilder newVnicProfile) {
        if (newVnicProfile == null) {
            vnicProfile = null;
        }
        else {
            vnicProfile = newVnicProfile.build();
        }
        return this;
    }
    
    
    public Nic build() {
        NicContainer container = new NicContainer();
        container.bootProtocol(bootProtocol);
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.instanceType(instanceType);
        container.interface_(interface_);
        container.linked(linked);
        container.mac(mac);
        container.name(name);
        container.network(network);
        container.networkAttachments(networkAttachments);
        container.networkFilterParameters(networkFilterParameters);
        container.networkLabels(networkLabels);
        container.onBoot(onBoot);
        container.plugged(plugged);
        container.reportedDevices(reportedDevices);
        container.statistics(statistics);
        container.synced(synced);
        container.template(template);
        container.virtualFunctionAllowedLabels(virtualFunctionAllowedLabels);
        container.virtualFunctionAllowedNetworks(virtualFunctionAllowedNetworks);
        container.vm(vm);
        container.vms(vms);
        container.vnicProfile(vnicProfile);
        return container;
    }
}
