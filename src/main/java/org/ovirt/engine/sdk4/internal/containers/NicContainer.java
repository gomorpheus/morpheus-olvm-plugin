/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.util.List;
import org.ovirt.engine.sdk4.types.BootProtocol;
import org.ovirt.engine.sdk4.types.Mac;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.NetworkAttachment;
import org.ovirt.engine.sdk4.types.NetworkFilterParameter;
import org.ovirt.engine.sdk4.types.NetworkLabel;
import org.ovirt.engine.sdk4.types.Nic;
import org.ovirt.engine.sdk4.types.NicInterface;
import org.ovirt.engine.sdk4.types.ReportedDevice;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.VnicProfile;

public class NicContainer extends DeviceContainer implements Nic {
    private BootProtocol bootProtocol;
    private NicInterface interface_;
    private Boolean linked;
    private Mac mac;
    private Boolean onBoot;
    private Boolean plugged;
    private Boolean synced;
    private Network network;
    private List<NetworkAttachment> networkAttachments;
    private List<NetworkFilterParameter> networkFilterParameters;
    private List<NetworkLabel> networkLabels;
    private List<ReportedDevice> reportedDevices;
    private List<Statistic> statistics;
    private List<NetworkLabel> virtualFunctionAllowedLabels;
    private List<Network> virtualFunctionAllowedNetworks;
    private VnicProfile vnicProfile;
    
    public BootProtocol bootProtocol() {
        return bootProtocol;
    }
    
    public void bootProtocol(BootProtocol newBootProtocol) {
        bootProtocol = newBootProtocol;
    }
    
    public boolean bootProtocolPresent() {
        return bootProtocol != null;
    }
    
    public NicInterface interface_() {
        return interface_;
    }
    
    public void interface_(NicInterface newInterface) {
        interface_ = newInterface;
    }
    
    public boolean interface_Present() {
        return interface_ != null;
    }
    
    public boolean linked() {
        return linked;
    }
    
    public void linked(boolean newLinked) {
        linked = Boolean.valueOf(newLinked);
    }
    
    public void linked(Boolean newLinked) {
        linked = newLinked;
    }
    
    public boolean linkedPresent() {
        return linked != null;
    }
    
    public Mac mac() {
        return mac;
    }
    
    public void mac(Mac newMac) {
        mac = newMac;
    }
    
    public boolean macPresent() {
        return mac != null;
    }
    
    public boolean onBoot() {
        return onBoot;
    }
    
    public void onBoot(boolean newOnBoot) {
        onBoot = Boolean.valueOf(newOnBoot);
    }
    
    public void onBoot(Boolean newOnBoot) {
        onBoot = newOnBoot;
    }
    
    public boolean onBootPresent() {
        return onBoot != null;
    }
    
    public boolean plugged() {
        return plugged;
    }
    
    public void plugged(boolean newPlugged) {
        plugged = Boolean.valueOf(newPlugged);
    }
    
    public void plugged(Boolean newPlugged) {
        plugged = newPlugged;
    }
    
    public boolean pluggedPresent() {
        return plugged != null;
    }
    
    public boolean synced() {
        return synced;
    }
    
    public void synced(boolean newSynced) {
        synced = Boolean.valueOf(newSynced);
    }
    
    public void synced(Boolean newSynced) {
        synced = newSynced;
    }
    
    public boolean syncedPresent() {
        return synced != null;
    }
    
    public Network network() {
        return network;
    }
    
    public void network(Network newNetwork) {
        network = newNetwork;
    }
    
    public boolean networkPresent() {
        return network != null;
    }
    
    public List<NetworkAttachment> networkAttachments() {
        return makeUnmodifiableList(networkAttachments);
    }
    
    public void networkAttachments(List<NetworkAttachment> newNetworkAttachments) {
        networkAttachments = makeArrayList(newNetworkAttachments);
    }
    
    public boolean networkAttachmentsPresent() {
        return networkAttachments != null && !networkAttachments.isEmpty();
    }
    
    public List<NetworkFilterParameter> networkFilterParameters() {
        return makeUnmodifiableList(networkFilterParameters);
    }
    
    public void networkFilterParameters(List<NetworkFilterParameter> newNetworkFilterParameters) {
        networkFilterParameters = makeArrayList(newNetworkFilterParameters);
    }
    
    public boolean networkFilterParametersPresent() {
        return networkFilterParameters != null && !networkFilterParameters.isEmpty();
    }
    
    public List<NetworkLabel> networkLabels() {
        return makeUnmodifiableList(networkLabels);
    }
    
    public void networkLabels(List<NetworkLabel> newNetworkLabels) {
        networkLabels = makeArrayList(newNetworkLabels);
    }
    
    public boolean networkLabelsPresent() {
        return networkLabels != null && !networkLabels.isEmpty();
    }
    
    public List<ReportedDevice> reportedDevices() {
        return makeUnmodifiableList(reportedDevices);
    }
    
    public void reportedDevices(List<ReportedDevice> newReportedDevices) {
        reportedDevices = makeArrayList(newReportedDevices);
    }
    
    public boolean reportedDevicesPresent() {
        return reportedDevices != null && !reportedDevices.isEmpty();
    }
    
    public List<Statistic> statistics() {
        return makeUnmodifiableList(statistics);
    }
    
    public void statistics(List<Statistic> newStatistics) {
        statistics = makeArrayList(newStatistics);
    }
    
    public boolean statisticsPresent() {
        return statistics != null && !statistics.isEmpty();
    }
    
    public List<NetworkLabel> virtualFunctionAllowedLabels() {
        return makeUnmodifiableList(virtualFunctionAllowedLabels);
    }
    
    public void virtualFunctionAllowedLabels(List<NetworkLabel> newVirtualFunctionAllowedLabels) {
        virtualFunctionAllowedLabels = makeArrayList(newVirtualFunctionAllowedLabels);
    }
    
    public boolean virtualFunctionAllowedLabelsPresent() {
        return virtualFunctionAllowedLabels != null && !virtualFunctionAllowedLabels.isEmpty();
    }
    
    public List<Network> virtualFunctionAllowedNetworks() {
        return makeUnmodifiableList(virtualFunctionAllowedNetworks);
    }
    
    public void virtualFunctionAllowedNetworks(List<Network> newVirtualFunctionAllowedNetworks) {
        virtualFunctionAllowedNetworks = makeArrayList(newVirtualFunctionAllowedNetworks);
    }
    
    public boolean virtualFunctionAllowedNetworksPresent() {
        return virtualFunctionAllowedNetworks != null && !virtualFunctionAllowedNetworks.isEmpty();
    }
    
    public VnicProfile vnicProfile() {
        return vnicProfile;
    }
    
    public void vnicProfile(VnicProfile newVnicProfile) {
        vnicProfile = newVnicProfile;
    }
    
    public boolean vnicProfilePresent() {
        return vnicProfile != null;
    }
    
}
