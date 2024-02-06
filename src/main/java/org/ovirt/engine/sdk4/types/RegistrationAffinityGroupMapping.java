/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * This type describes how to map affinity groups as part of the object registration. An object can be
 * a virtual machine, template, etc.
 * 
 * An example of an XML representation using this mapping:
 * 
 * [source,xml]
 * ----
 * <action>
 *   <registration_configuration>
 *     <affinity_group_mappings>
 *      <registration_affinity_group_mapping>
 *        <from>
 *          <name>affinity</name>
 *        </from>
 *        <to>
 *          <name>affinity2</name>
 *        </to>
 *      </registration_affinity_group_mapping>
 *     </affinity_group_mappings>
 *   </registration_configuration>
 * </action>
 * ----
 */
public interface RegistrationAffinityGroupMapping {
    AffinityGroup from();
    
    boolean fromPresent();
    
    AffinityGroup to();
    
    boolean toPresent();
    
}
