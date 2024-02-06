/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Deprecated type that maps an external virtual NIC profile to one that exists in the {engine-name}.
 * 
 * If, for example, the desired virtual NIC profile's mapping includes the following two lines:
 * 
 * [cols="25,35,40"]
 * |===
 * |Source network name|Source network profile name|Target virtual NIC profile ID
 * 
 * |`red`
 * |`gold`
 * |`738dd914-8ec8-4a8b-8628-34672a5d449b`
 * 
 * |`blue`
 * |`silver`
 * |`892a12ec-2028-4451-80aa-ff3bf55d6bac`
 * 
 * |===
 * 
 * The following form is deprecated since 4.2.1 and will be removed in the future:
 * 
 * [source,xml]
 * ----
 * <vnic_profile_mappings>
 *   <vnic_profile_mapping>
 *     <source_network_name>red</source_network_name>
 *     <source_network_profile_name>gold</source_network_profile_name>
 *     <target_vnic_profile id="738dd914-8ec8-4a8b-8628-34672a5d449b"/>
 *   </vnic_profile_mapping>
 *   <vnic_profile_mapping>
 *     <source_network_name>blue</source_network_name>
 *     <source_network_profile_name>silver</source_network_profile_name>
 *     <target_vnic_profile id="892a12ec-2028-4451-80aa-ff3bf55d6bac"/>
 *   </vnic_profile_mapping>
 * </vnic_profile_mappings>
 * ----
 */
public interface VnicProfileMapping {
    String sourceNetworkName();
    
    boolean sourceNetworkNamePresent();
    
    String sourceNetworkProfileName();
    
    boolean sourceNetworkProfileNamePresent();
    
    VnicProfile targetVnicProfile();
    
    boolean targetVnicProfilePresent();
    
}
