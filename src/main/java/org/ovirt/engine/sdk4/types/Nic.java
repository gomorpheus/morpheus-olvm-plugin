/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * Represents a virtual machine NIC.
 * 
 * For example, the XML representation of a NIC will look like this:
 * 
 * [source,xml]
 * ----
 * <nic href="/ovirt-engine/api/vms/123/nics/456" id="456">
 *   <name>nic1</name>
 *   <vm href="/ovirt-engine/api/vms/123" id="123"/>
 *   <interface>virtio</interface>
 *   <linked>true</linked>
 *   <mac>
 *     <address>02:00:00:00:00:00</address>
 *   </mac>
 *   <plugged>true</plugged>
 *   <vnic_profile href="/ovirt-engine/api/vnicprofiles/789" id="789"/>
 * </nic>
 * ----
 */
public interface Nic extends Device {
    BootProtocol bootProtocol();
    
    boolean bootProtocolPresent();
    
    NicInterface interface_();
    
    boolean interface_Present();
    
    boolean linked();
    
    boolean linkedPresent();
    
    Mac mac();
    
    boolean macPresent();
    
    boolean onBoot();
    
    boolean onBootPresent();
    
    boolean plugged();
    
    boolean pluggedPresent();
    
    boolean synced();
    
    boolean syncedPresent();
    
    Network network();
    
    boolean networkPresent();
    
    List<NetworkAttachment> networkAttachments();
    
    boolean networkAttachmentsPresent();
    
    List<NetworkFilterParameter> networkFilterParameters();
    
    boolean networkFilterParametersPresent();
    
    List<NetworkLabel> networkLabels();
    
    boolean networkLabelsPresent();
    
    List<ReportedDevice> reportedDevices();
    
    boolean reportedDevicesPresent();
    
    List<Statistic> statistics();
    
    boolean statisticsPresent();
    
    List<NetworkLabel> virtualFunctionAllowedLabels();
    
    boolean virtualFunctionAllowedLabelsPresent();
    
    List<Network> virtualFunctionAllowedNetworks();
    
    boolean virtualFunctionAllowedNetworksPresent();
    
    VnicProfile vnicProfile();
    
    boolean vnicProfilePresent();
    
}
