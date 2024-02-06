/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Maps an external virtual NIC profile to one that exists in the {engine-name}.
 * The target may be specified as a profile ID or a pair of profile name and network name.
 * 
 * If, for example, the desired virtual NIC profile mapping includes the following lines:
 * 
 * [cols="25,35,40"]
 * |===
 * |Source network name|Source network profile name|Target virtual NIC profile ID\names
 * 
 * |`red`
 * |`gold`
 * |`738dd914-8ec8-4a8b-8628-34672a5d449b`
 * 
 * |`<empty>` (no network name)
 * |`<empty>` (no network profile name)
 * |`892a12ec-2028-4451-80aa-ff3bf55d6bac`
 * 
 * |`blue`
 * |`silver`
 * |`orange\copper`
 * 
 * |`yellow`
 * |`platinum`
 * |`<empty>` (no profile)
 * 
 * |`green`
 * |`bronze`
 * |
 * 
 * |===
 * 
 * Then the following snippet should be added to <<types/registration_configuration, RegistrationConfiguration>>
 * 
 * [source,xml]
 * ----
 * <vnic_profile_mappings>
 *   <registration_vnic_profile_mapping>
 *     <from>
 *       <name>gold</name>
 *       <network>
 *         <name>red</name>
 *       </network>
 *     </from>
 *     <to id="738dd914-8ec8-4a8b-8628-34672a5d449b"/>
 *   </registration_vnic_profile_mapping>
 *   <registration_vnic_profile_mapping>
 *     <from>
 *       <name></name>
 *       <network>
 *         <name></name>
 *       </network>
 *     </from>
 *     <to id="892a12ec-2028-4451-80aa-ff3bf55d6bac"/>
 *   </registration_vnic_profile_mapping>
 *   <registration_vnic_profile_mapping>
 *     <from>
 *       <name>silver</name>
 *       <network>
 *         <name>blue</name>
 *       </network>
 *     </from>
 *     <to>
 *       <name>copper</name>
 *       <network>
 *         <name>orange</name>
 *       </network>
 *     </to>
 *   </registration_vnic_profile_mapping>
 *   <registration_vnic_profile_mapping>
 *     <from>
 *       <name>platinum</name>
 *       <network>
 *         <name>yellow</name>
 *       </network>
 *     </from>
 *     <to>
 *       <name></name>
 *       <network>
 *         <name></name>
 *       </network>
 *     </to>
 *   </registration_vnic_profile_mapping>
 *   <registration_vnic_profile_mapping>
 *     <from>
 *       <name>bronze</name>
 *       <network>
 *         <name>green</name>
 *       </network>
 *     </from>
 *   </registration_vnic_profile_mapping>
 * </vnic_profile_mappings>
 * ----
 */
public interface RegistrationVnicProfileMapping {
    VnicProfile from();
    
    boolean fromPresent();
    
    VnicProfile to();
    
    boolean toPresent();
    
}
