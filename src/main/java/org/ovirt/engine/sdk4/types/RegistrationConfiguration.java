/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * This type describes how an object (virtual machine, template,
 * etc) is registered, and is used for the implementation of disaster recovery solutions.
 * 
 * Each mapping contained in this type can be used to map
 * objects in the original system to corresponding objects
 * in the system where the virtual machine or template is being registered.
 * For example, there could be a primary setup with a virtual machine
 * configured on cluster A, and an active secondary setup with cluster B.
 * Cluster B is compatible with that virtual machine, and in case of a
 * disaster recovery scenario the storage domain can be
 * imported to the secondary setup, and the user can register the
 * virtual machine to cluster B.
 * 
 * In that case, we can automate the recovery process by defining a cluster mapping.
 * After the entity is registered, its OVF will indicate it belongs to
 * cluster A, but the mapping will indicate that cluster A will
 * be replaced with cluster B.
 * {engine-name} should do the switch and register the virtual machine to cluster B
 * in the secondary site.
 * 
 * Cluster mapping is just one example, there are different types of mappings:
 * 
 * - Cluster mapping.
 * - LUN mapping.
 * - Role mapping.
 * - Domain mapping.
 * - Permissions mapping.
 * - Affinity Group mapping.
 * - Affinity Label mapping.
 * - Virtual NIC profile mapping.
 * 
 * Each mapping will be used for its specific OVF's data once the register operation
 * takes place in the {engine-name}.
 * 
 * An example of an XML representation using the mapping:
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
 *     <role_mappings>
 *       <registration_role_mapping>
 *         <from>
 *           <name>SuperUser</name>
 *         </from>
 *         <to>
 *           <name>UserVmRunTimeManager</name>
 *         </to>
 *       </registration_role_mapping>
 *     </role_mappings>
 *     <domain_mappings>
 *       <registration_domain_mapping>
 *         <from>
 *           <name>redhat</name>
 *         </from>
 *         <to>
 *           <name>internal</name>
 *         </to>
 *       </registration_domain_mapping>
 *     </domain_mappings>
 *     <lun_mappings>
 *      <registration_lun_mapping>
 *        <from id="111">
 *        </from>
 *        <to id="222">
 *          <alias>weTestLun</alias>
 *          <lun_storage>
 *            <type>iscsi</type>
 *            <logical_units>
 *               <logical_unit id="36001405fb1ddb4b91e44078f1fffcfef">
 *                  <address>44.33.11.22</address>
 *                  <port>3260</port>
 *                  <portal>1</portal>
 *                  <target>iqn.2017-11.com.name.redhat:444</target>
 *               </logical_unit>
 *            </logical_units>
 *          </lun_storage>
 *        </to>
 *      </registration_lun_mapping>
 *     </lun_mappings>
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
 *     <vnic_profile_mappings>
 *       <registration_vnic_profile_mapping>
 *         <from>
 *           <name>gold</name>
 *           <network>
 *             <name>red</name>
 *           </network>
 *         </from>
 *         <to id="738dd914-8ec8-4a8b-8628-34672a5d449b"/>
 *       </registration_vnic_profile_mapping>
 *       <registration_vnic_profile_mapping>
 *         <from>
 *           <name>silver</name>
 *           <network>
 *             <name>blue</name>
 *           </network>
 *         </from>
 *         <to>
 *           <name>copper</name>
 *           <network>
 *             <name>orange</name>
 *           </network>
 *         </to>
 *       </registration_vnic_profile_mapping>
 *     </vnic_profile_mappings>
 *   </registration_configuration>
 * </action>
 * ----
 */
public interface RegistrationConfiguration {
    List<RegistrationAffinityGroupMapping> affinityGroupMappings();
    
    boolean affinityGroupMappingsPresent();
    
    List<RegistrationAffinityLabelMapping> affinityLabelMappings();
    
    boolean affinityLabelMappingsPresent();
    
    List<RegistrationClusterMapping> clusterMappings();
    
    boolean clusterMappingsPresent();
    
    List<RegistrationDomainMapping> domainMappings();
    
    boolean domainMappingsPresent();
    
    List<RegistrationLunMapping> lunMappings();
    
    boolean lunMappingsPresent();
    
    List<RegistrationRoleMapping> roleMappings();
    
    boolean roleMappingsPresent();
    
    List<RegistrationVnicProfileMapping> vnicProfileMappings();
    
    boolean vnicProfileMappingsPresent();
    
}
