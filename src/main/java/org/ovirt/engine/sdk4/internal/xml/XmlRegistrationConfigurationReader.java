/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.util.ArrayListWithHref;
import org.ovirt.api.metamodel.runtime.util.ListWithHref;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.internal.containers.RegistrationConfigurationContainer;
import org.ovirt.engine.sdk4.types.RegistrationConfiguration;

public class XmlRegistrationConfigurationReader {
    
    public static RegistrationConfiguration readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        RegistrationConfigurationContainer object = new RegistrationConfigurationContainer();
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "affinity_group_mappings":
                object.affinityGroupMappings(XmlRegistrationAffinityGroupMappingReader.readMany(reader));
                break;
                case "affinity_label_mappings":
                object.affinityLabelMappings(XmlRegistrationAffinityLabelMappingReader.readMany(reader));
                break;
                case "cluster_mappings":
                object.clusterMappings(XmlRegistrationClusterMappingReader.readMany(reader));
                break;
                case "domain_mappings":
                object.domainMappings(XmlRegistrationDomainMappingReader.readMany(reader));
                break;
                case "lun_mappings":
                object.lunMappings(XmlRegistrationLunMappingReader.readMany(reader));
                break;
                case "role_mappings":
                object.roleMappings(XmlRegistrationRoleMappingReader.readMany(reader));
                break;
                case "vnic_profile_mappings":
                object.vnicProfileMappings(XmlRegistrationVnicProfileMappingReader.readMany(reader));
                break;
                case "link":
                // Process the attributes:
                String rel = reader.getAttributeValue("rel");
                String href = reader.getAttributeValue("href");
                if (rel != null && href != null) {
                    links.add(new String[]{rel, href});
                }
                reader.skip();
                break;
                default:
                reader.skip();
                break;
            }
        }
        if (links != null) {
            for (String[] link : links) {
                processLink(object, link);
            }
        }
        
        // Discard the end tag:
        reader.next();
        
        return object;
    }
    
    public static Iterator<RegistrationConfiguration> iterateMany(final XmlReader reader) {
        return new Iterator<RegistrationConfiguration>() {
            private boolean first = true;
            
            @Override
            public void remove() {
                // Empty on purpose
            }
            
            @Override
            public boolean hasNext() {
                if (first) {
                    if (!reader.forward()) {
                        return false;
                    }
                    reader.next();
                    first = false;
                }
                if (!reader.forward()) {
                    reader.next();
                    return false;
                }
                return true;
            }
            
            @Override
            public RegistrationConfiguration next() {
                RegistrationConfiguration next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<RegistrationConfiguration> readMany(XmlReader reader) {
        List<RegistrationConfiguration> list = new ArrayList<>();
        Iterator<RegistrationConfiguration> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(RegistrationConfigurationContainer object, String[] link) {
    }
}

