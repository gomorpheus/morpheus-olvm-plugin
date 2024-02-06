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
import org.ovirt.engine.sdk4.internal.containers.UserContainer;
import org.ovirt.engine.sdk4.types.User;

public class XmlUserReader {
    
    public static User readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        UserContainer object = new UserContainer();
        
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
                case "comment":
                object.comment(reader.readString());
                break;
                case "department":
                object.department(reader.readString());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "domain":
                object.domain(XmlDomainReader.readOne(reader));
                break;
                case "domain_entry_id":
                object.domainEntryId(reader.readString());
                break;
                case "email":
                object.email(reader.readString());
                break;
                case "groups":
                object.groups(XmlGroupReader.readMany(reader));
                break;
                case "last_name":
                object.lastName(reader.readString());
                break;
                case "logged_in":
                object.loggedIn(reader.readBoolean());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "namespace":
                object.namespace(reader.readString());
                break;
                case "options":
                object.options(XmlUserOptionReader.readMany(reader));
                break;
                case "password":
                object.password(reader.readString());
                break;
                case "permissions":
                object.permissions(XmlPermissionReader.readMany(reader));
                break;
                case "principal":
                object.principal(reader.readString());
                break;
                case "roles":
                object.roles(XmlRoleReader.readMany(reader));
                break;
                case "ssh_public_keys":
                object.sshPublicKeys(XmlSshPublicKeyReader.readMany(reader));
                break;
                case "tags":
                object.tags(XmlTagReader.readMany(reader));
                break;
                case "user_name":
                object.userName(reader.readString());
                break;
                case "user_options":
                object.userOptions(XmlPropertyReader.readMany(reader));
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
    
    public static Iterator<User> iterateMany(final XmlReader reader) {
        return new Iterator<User>() {
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
            public User next() {
                User next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<User> readMany(XmlReader reader) {
        List<User> list = new ArrayList<>();
        Iterator<User> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(UserContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "groups":
                list = new ArrayListWithHref(object.groups());
                list.href(href);
                object.groups(list);
                break;
                case "options":
                list = new ArrayListWithHref(object.options());
                list.href(href);
                object.options(list);
                break;
                case "permissions":
                list = new ArrayListWithHref(object.permissions());
                list.href(href);
                object.permissions(list);
                break;
                case "roles":
                list = new ArrayListWithHref(object.roles());
                list.href(href);
                object.roles(list);
                break;
                case "sshpublickeys":
                list = new ArrayListWithHref(object.sshPublicKeys());
                list.href(href);
                object.sshPublicKeys(list);
                break;
                case "tags":
                list = new ArrayListWithHref(object.tags());
                list.href(href);
                object.tags(list);
                break;
                default:
                break;
            }
        }
    }
}

