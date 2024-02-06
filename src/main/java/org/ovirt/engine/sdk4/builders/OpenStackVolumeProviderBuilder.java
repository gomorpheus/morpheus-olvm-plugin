/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.OpenStackVolumeProviderContainer;
import org.ovirt.engine.sdk4.types.Certificate;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.OpenStackVolumeProvider;
import org.ovirt.engine.sdk4.types.OpenStackVolumeType;
import org.ovirt.engine.sdk4.types.OpenstackVolumeAuthenticationKey;
import org.ovirt.engine.sdk4.types.Property;

public class OpenStackVolumeProviderBuilder {
    private List<OpenstackVolumeAuthenticationKey> authenticationKeys;
    private String authenticationUrl;
    private List<Certificate> certificates;
    private String comment;
    private DataCenter dataCenter;
    private String description;
    private String href;
    private String id;
    private String name;
    private String password;
    private List<Property> properties;
    private Boolean requiresAuthentication;
    private String tenantName;
    private String url;
    private String username;
    private List<OpenStackVolumeType> volumeTypes;
    
    public OpenStackVolumeProviderBuilder authenticationKeys(List<OpenstackVolumeAuthenticationKey> newAuthenticationKeys) {
        if (newAuthenticationKeys != null) {
            if (authenticationKeys == null) {
                authenticationKeys = new ArrayList<>(newAuthenticationKeys);
            }
            else {
                authenticationKeys.addAll(newAuthenticationKeys);
            }
        }
        return this;
    }
    
    public OpenStackVolumeProviderBuilder authenticationKeys(OpenstackVolumeAuthenticationKey... newAuthenticationKeys) {
        if (newAuthenticationKeys != null) {
            if (authenticationKeys == null) {
                authenticationKeys = new ArrayList<>(newAuthenticationKeys.length);
            }
            Collections.addAll(authenticationKeys, newAuthenticationKeys);
        }
        return this;
    }
    
    public OpenStackVolumeProviderBuilder authenticationKeys(OpenstackVolumeAuthenticationKeyBuilder... newAuthenticationKeys) {
        if (newAuthenticationKeys != null) {
            if (authenticationKeys == null) {
                authenticationKeys = new ArrayList<>(newAuthenticationKeys.length);
            }
            for (OpenstackVolumeAuthenticationKeyBuilder builder : newAuthenticationKeys) {
                authenticationKeys.add(builder.build());
            }
        }
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder authenticationUrl(String newAuthenticationUrl) {
        authenticationUrl = newAuthenticationUrl;
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder certificates(List<Certificate> newCertificates) {
        if (newCertificates != null) {
            if (certificates == null) {
                certificates = new ArrayList<>(newCertificates);
            }
            else {
                certificates.addAll(newCertificates);
            }
        }
        return this;
    }
    
    public OpenStackVolumeProviderBuilder certificates(Certificate... newCertificates) {
        if (newCertificates != null) {
            if (certificates == null) {
                certificates = new ArrayList<>(newCertificates.length);
            }
            Collections.addAll(certificates, newCertificates);
        }
        return this;
    }
    
    public OpenStackVolumeProviderBuilder certificates(CertificateBuilder... newCertificates) {
        if (newCertificates != null) {
            if (certificates == null) {
                certificates = new ArrayList<>(newCertificates.length);
            }
            for (CertificateBuilder builder : newCertificates) {
                certificates.add(builder.build());
            }
        }
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
        return this;
    }
    
    public OpenStackVolumeProviderBuilder dataCenter(DataCenterBuilder newDataCenter) {
        if (newDataCenter == null) {
            dataCenter = null;
        }
        else {
            dataCenter = newDataCenter.build();
        }
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder properties(List<Property> newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties);
            }
            else {
                properties.addAll(newProperties);
            }
        }
        return this;
    }
    
    public OpenStackVolumeProviderBuilder properties(Property... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            Collections.addAll(properties, newProperties);
        }
        return this;
    }
    
    public OpenStackVolumeProviderBuilder properties(PropertyBuilder... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            for (PropertyBuilder builder : newProperties) {
                properties.add(builder.build());
            }
        }
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder requiresAuthentication(boolean newRequiresAuthentication) {
        requiresAuthentication = Boolean.valueOf(newRequiresAuthentication);
        return this;
    }
    
    public OpenStackVolumeProviderBuilder requiresAuthentication(Boolean newRequiresAuthentication) {
        requiresAuthentication = newRequiresAuthentication;
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder tenantName(String newTenantName) {
        tenantName = newTenantName;
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder url(String newUrl) {
        url = newUrl;
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public OpenStackVolumeProviderBuilder volumeTypes(List<OpenStackVolumeType> newVolumeTypes) {
        if (newVolumeTypes != null) {
            if (volumeTypes == null) {
                volumeTypes = new ArrayList<>(newVolumeTypes);
            }
            else {
                volumeTypes.addAll(newVolumeTypes);
            }
        }
        return this;
    }
    
    public OpenStackVolumeProviderBuilder volumeTypes(OpenStackVolumeType... newVolumeTypes) {
        if (newVolumeTypes != null) {
            if (volumeTypes == null) {
                volumeTypes = new ArrayList<>(newVolumeTypes.length);
            }
            Collections.addAll(volumeTypes, newVolumeTypes);
        }
        return this;
    }
    
    public OpenStackVolumeProviderBuilder volumeTypes(OpenStackVolumeTypeBuilder... newVolumeTypes) {
        if (newVolumeTypes != null) {
            if (volumeTypes == null) {
                volumeTypes = new ArrayList<>(newVolumeTypes.length);
            }
            for (OpenStackVolumeTypeBuilder builder : newVolumeTypes) {
                volumeTypes.add(builder.build());
            }
        }
        return this;
    }
    
    
    public OpenStackVolumeProvider build() {
        OpenStackVolumeProviderContainer container = new OpenStackVolumeProviderContainer();
        container.authenticationKeys(authenticationKeys);
        container.authenticationUrl(authenticationUrl);
        container.certificates(certificates);
        container.comment(comment);
        container.dataCenter(dataCenter);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.password(password);
        container.properties(properties);
        container.requiresAuthentication(requiresAuthentication);
        container.tenantName(tenantName);
        container.url(url);
        container.username(username);
        container.volumeTypes(volumeTypes);
        return container;
    }
}
