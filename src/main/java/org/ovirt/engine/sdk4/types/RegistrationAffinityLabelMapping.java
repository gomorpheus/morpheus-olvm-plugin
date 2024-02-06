/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * This type describes how to map affinity labels as part of the object registration. An object can be
 * a virtual machine, template, etc.
 * 
 * An example of an XML representation using mapping:
 * 
 * [source,xml]
 * ----
 * <action>
 *   <registration_configuration>
 *     <affinity_label_mappings>
 *      <registration_affinity_label_mapping>
 *        <from>
 *          <name>affinity_label</name>
 *        </from>
 *        <to>
 *          <name>affinity_label2</name>
 *        </to>
 *      </registration_affinity_label_mapping>
 *     </affinity_label_mappings>
 *   </registration_configuration>
 * </action>
 * ----
 */
public interface RegistrationAffinityLabelMapping {
    AffinityLabel from();
    
    boolean fromPresent();
    
    AffinityLabel to();
    
    boolean toPresent();
    
}
