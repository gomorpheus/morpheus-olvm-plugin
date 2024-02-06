/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * This type describes how to map LUNs as part of the object registration. An object can be
 * a virtual machine, template, etc.
 * 
 * An external LUN disk is an entity which does not reside on a storage domain.
 * It must be specified because it doesn't need to exist in the
 * environment where the object is registered.
 * An example of an XML representation using this mapping:
 * 
 * [source,xml]
 * ----
 * <action>
 *   <registration_configuration>
 *     <lun_mappings>
 *       <registration_lun_mapping>
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
 *   </registration_configuration>
 * </action>
 * ----
 */
public interface RegistrationLunMapping {
    Disk from();
    
    boolean fromPresent();
    
    Disk to();
    
    boolean toPresent();
    
}
