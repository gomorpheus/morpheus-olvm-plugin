/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.RegistrationConfiguration;

public class XmlRegistrationConfigurationWriter {
    
    public static void writeOne(RegistrationConfiguration object, XmlWriter writer) {
        writeOne(object, "registration_configuration", writer);
    }
    
    public static void writeOne(RegistrationConfiguration object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.affinityGroupMappingsPresent()) {
            XmlRegistrationAffinityGroupMappingWriter.writeMany(object.affinityGroupMappings().iterator(), "registration_affinity_group_mapping", "affinity_group_mappings", writer);
        }
        if (object.affinityLabelMappingsPresent()) {
            XmlRegistrationAffinityLabelMappingWriter.writeMany(object.affinityLabelMappings().iterator(), "registration_affinity_label_mapping", "affinity_label_mappings", writer);
        }
        if (object.clusterMappingsPresent()) {
            XmlRegistrationClusterMappingWriter.writeMany(object.clusterMappings().iterator(), "registration_cluster_mapping", "cluster_mappings", writer);
        }
        if (object.domainMappingsPresent()) {
            XmlRegistrationDomainMappingWriter.writeMany(object.domainMappings().iterator(), "registration_domain_mapping", "domain_mappings", writer);
        }
        if (object.lunMappingsPresent()) {
            XmlRegistrationLunMappingWriter.writeMany(object.lunMappings().iterator(), "registration_lun_mapping", "lun_mappings", writer);
        }
        if (object.roleMappingsPresent()) {
            XmlRegistrationRoleMappingWriter.writeMany(object.roleMappings().iterator(), "registration_role_mapping", "role_mappings", writer);
        }
        if (object.vnicProfileMappingsPresent()) {
            XmlRegistrationVnicProfileMappingWriter.writeMany(object.vnicProfileMappings().iterator(), "registration_vnic_profile_mapping", "vnic_profile_mappings", writer);
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<RegistrationConfiguration> list, XmlWriter writer) {
        writeMany(list, "registration_configuration", "registration_configurations", writer);
    }
    
    public static void writeMany(Iterator<RegistrationConfiguration> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlRegistrationConfigurationWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

