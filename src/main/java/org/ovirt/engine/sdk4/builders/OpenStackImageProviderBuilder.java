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
import org.ovirt.engine.sdk4.internal.containers.OpenStackImageProviderContainer;
import org.ovirt.engine.sdk4.types.Certificate;
import org.ovirt.engine.sdk4.types.OpenStackImage;
import org.ovirt.engine.sdk4.types.OpenStackImageProvider;
import org.ovirt.engine.sdk4.types.Property;

public class OpenStackImageProviderBuilder {
    private String authenticationUrl;
    private List<Certificate> certificates;
    private String comment;
    private String description;
    private String href;
    private String id;
    private List<OpenStackImage> images;
    private String name;
    private String password;
    private List<Property> properties;
    private Boolean requiresAuthentication;
    private String tenantName;
    private String url;
    private String username;
    
    public OpenStackImageProviderBuilder authenticationUrl(String newAuthenticationUrl) {
        authenticationUrl = newAuthenticationUrl;
        return this;
    }
    
    
    public OpenStackImageProviderBuilder certificates(List<Certificate> newCertificates) {
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
    
    public OpenStackImageProviderBuilder certificates(Certificate... newCertificates) {
        if (newCertificates != null) {
            if (certificates == null) {
                certificates = new ArrayList<>(newCertificates.length);
            }
            Collections.addAll(certificates, newCertificates);
        }
        return this;
    }
    
    public OpenStackImageProviderBuilder certificates(CertificateBuilder... newCertificates) {
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
    
    
    public OpenStackImageProviderBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public OpenStackImageProviderBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public OpenStackImageProviderBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public OpenStackImageProviderBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public OpenStackImageProviderBuilder images(List<OpenStackImage> newImages) {
        if (newImages != null) {
            if (images == null) {
                images = new ArrayList<>(newImages);
            }
            else {
                images.addAll(newImages);
            }
        }
        return this;
    }
    
    public OpenStackImageProviderBuilder images(OpenStackImage... newImages) {
        if (newImages != null) {
            if (images == null) {
                images = new ArrayList<>(newImages.length);
            }
            Collections.addAll(images, newImages);
        }
        return this;
    }
    
    public OpenStackImageProviderBuilder images(OpenStackImageBuilder... newImages) {
        if (newImages != null) {
            if (images == null) {
                images = new ArrayList<>(newImages.length);
            }
            for (OpenStackImageBuilder builder : newImages) {
                images.add(builder.build());
            }
        }
        return this;
    }
    
    
    public OpenStackImageProviderBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public OpenStackImageProviderBuilder password(String newPassword) {
        password = newPassword;
        return this;
    }
    
    
    public OpenStackImageProviderBuilder properties(List<Property> newProperties) {
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
    
    public OpenStackImageProviderBuilder properties(Property... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            Collections.addAll(properties, newProperties);
        }
        return this;
    }
    
    public OpenStackImageProviderBuilder properties(PropertyBuilder... newProperties) {
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
    
    
    public OpenStackImageProviderBuilder requiresAuthentication(boolean newRequiresAuthentication) {
        requiresAuthentication = Boolean.valueOf(newRequiresAuthentication);
        return this;
    }
    
    public OpenStackImageProviderBuilder requiresAuthentication(Boolean newRequiresAuthentication) {
        requiresAuthentication = newRequiresAuthentication;
        return this;
    }
    
    
    public OpenStackImageProviderBuilder tenantName(String newTenantName) {
        tenantName = newTenantName;
        return this;
    }
    
    
    public OpenStackImageProviderBuilder url(String newUrl) {
        url = newUrl;
        return this;
    }
    
    
    public OpenStackImageProviderBuilder username(String newUsername) {
        username = newUsername;
        return this;
    }
    
    
    public OpenStackImageProvider build() {
        OpenStackImageProviderContainer container = new OpenStackImageProviderContainer();
        container.authenticationUrl(authenticationUrl);
        container.certificates(certificates);
        container.comment(comment);
        container.description(description);
        container.href(href);
        container.id(id);
        container.images(images);
        container.name(name);
        container.password(password);
        container.properties(properties);
        container.requiresAuthentication(requiresAuthentication);
        container.tenantName(tenantName);
        container.url(url);
        container.username(username);
        return container;
    }
}
