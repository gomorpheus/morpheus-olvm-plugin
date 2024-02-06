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
import org.ovirt.engine.sdk4.internal.containers.OpenStackVolumeProviderContainer;
import org.ovirt.engine.sdk4.types.OpenStackVolumeProvider;

public class XmlOpenStackVolumeProviderReader {
    
    public static OpenStackVolumeProvider readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        OpenStackVolumeProviderContainer object = new OpenStackVolumeProviderContainer();
        
        // Process the attributes:
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            String name = reader.getAttributeLocalName(i);
            String image = reader.getAttributeValue(i);
            switch (name) {
                case "href":
                object.href(image);
                break;
                case "id":
                object.id(image);
                break;
                default:
                break;
            }
        }
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "authentication_keys":
                object.authenticationKeys(XmlOpenstackVolumeAuthenticationKeyReader.readMany(reader));
                break;
                case "authentication_url":
                object.authenticationUrl(reader.readString());
                break;
                case "certificates":
                object.certificates(XmlCertificateReader.readMany(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "data_center":
                object.dataCenter(XmlDataCenterReader.readOne(reader));
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "password":
                object.password(reader.readString());
                break;
                case "properties":
                object.properties(XmlPropertyReader.readMany(reader));
                break;
                case "requires_authentication":
                object.requiresAuthentication(reader.readBoolean());
                break;
                case "tenant_name":
                object.tenantName(reader.readString());
                break;
                case "url":
                object.url(reader.readString());
                break;
                case "username":
                object.username(reader.readString());
                break;
                case "volume_types":
                object.volumeTypes(XmlOpenStackVolumeTypeReader.readMany(reader));
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
    
    public static Iterator<OpenStackVolumeProvider> iterateMany(final XmlReader reader) {
        return new Iterator<OpenStackVolumeProvider>() {
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
            public OpenStackVolumeProvider next() {
                OpenStackVolumeProvider next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<OpenStackVolumeProvider> readMany(XmlReader reader) {
        List<OpenStackVolumeProvider> list = new ArrayList<>();
        Iterator<OpenStackVolumeProvider> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(OpenStackVolumeProviderContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "authenticationkeys":
                list = new ArrayListWithHref(object.authenticationKeys());
                list.href(href);
                object.authenticationKeys(list);
                break;
                case "certificates":
                list = new ArrayListWithHref(object.certificates());
                list.href(href);
                object.certificates(list);
                break;
                case "volumetypes":
                list = new ArrayListWithHref(object.volumeTypes());
                list.href(href);
                object.volumeTypes(list);
                break;
                default:
                break;
            }
        }
    }
}

