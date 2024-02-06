/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Network filters filter packets sent to and from the virtual machine's NIC according to defined rules.
 * 
 * There are several types of network filters supported based on libvirt.
 * For more details about the different network filters see https://libvirt.org/firewall.html[here].
 * 
 * The default Network Filter is based on network type and configuration.
 * VM network's default filter is `vdsm-no-mac-spoof` if `EnableMACAntiSpoofingFilterRules` is True, otherwise
 * the filter is not configured, for `OVN` networks the filter is not configured.
 * 
 * 
 * In addition to libvirt's network filters, there are two additional network filters:
 * The first is called `vdsm-no-mac-spoofing` and is composed of `no-mac-spoofing` and `no-arp-mac-spoofing`.
 * The second is called `ovirt-no-filter` and is used when no network filter is to be defined for the virtual machine's NIC.
 * The `ovirt-no-filter` network filter is only used for internal implementation, and
 * does not exist on the NICs.
 * 
 * This is a example of the XML representation:
 * 
 * [source,xml]
 * ----
 * <network_filter id="00000019-0019-0019-0019-00000000026c">
 *   <name>example-filter</name>
 *   <version>
 *     <major>4</major>
 *     <minor>0</minor>
 *     <build>-1</build>
 *     <revision>-1</revision>
 *   </version>
 * </network_filter>
 * ----
 * 
 * If any part of the version is not present, it is represented by -1.
 */
public interface NetworkFilter extends Identified {
    Version version();
    
    boolean versionPresent();
    
}
