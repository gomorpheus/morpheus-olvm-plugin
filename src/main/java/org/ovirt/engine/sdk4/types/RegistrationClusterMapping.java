/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * This type describes how to map clusters as part of the object registration. An object can be
 * a virtual machine, template, etc.
 * 
 * An example of an XML representation using this mapping:
 * 
 * [source,xml]
 * ----
 * <action>
 *   <registration_configuration>
 *     <cluster_mappings>
 *       <registration_cluster_mapping>
 *         <from>
 *           <name>myoriginalcluster</name>
 *         </from>
 *         <to>
 *           <name>mynewcluster</name>
 *         </to>
 *       </registration_cluster_mapping>
 *     </cluster_mappings>
 *   </registration_configuration>
 * </action>
 * ----
 */
public interface RegistrationClusterMapping {
    Cluster from();
    
    boolean fromPresent();
    
    Cluster to();
    
    boolean toPresent();
    
}
