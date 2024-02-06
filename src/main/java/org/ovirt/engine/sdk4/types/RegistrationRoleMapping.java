/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * This type describes how to map roles as part of the object registration. An object can be
 * a virtual machine, template, etc.
 * 
 * A role mapping is intended to map correlating roles between the primary site
 * and the secondary site.
 * For example, there may be permissions with role `UserVmRunTimeManager` for the virtual machine that
 * is being registered.
 * Therefore we can send a mapping that will register the virtual machine in the secondary setup
 * using the `SuperUser` role instead of `UserVmRunTimeManager`
 * An example of an XML representation using this mapping:
 * 
 * [source,xml]
 * ----
 * <action>
 *   <registration_configuration>
 *     <role_mappings>
 *       <registration_eole_mapping>
 *         <from>
 *           <name>SuperUser</name>
 *         </from>
 *         <to>
 *           <name>UserVmRunTimeManager</name>
 *         </to>
 *       </registration_role_mapping>
 *     </role_mappings>
 *   </registration_configuration>
 * </action>
 * ----
 */
public interface RegistrationRoleMapping {
    Role from();
    
    boolean fromPresent();
    
    Role to();
    
    boolean toPresent();
    
}
