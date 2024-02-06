/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * This type describes how to map the users' domain as part of the object registration. An object can be
 * a virtual machine, template, etc.
 * NOTE: This is based on the assumption that user names will be the same, and that only
 * the domain name will be changed.
 * 
 * An example of an XML representation using this mapping:
 * 
 * [source,xml]
 * ----
 * <action>
 *   <registration_configuration>
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
 *   </registration_configuration>
 * </action>
 * ----
 */
public interface RegistrationDomainMapping {
    Domain from();
    
    boolean fromPresent();
    
    Domain to();
    
    boolean toPresent();
    
}
