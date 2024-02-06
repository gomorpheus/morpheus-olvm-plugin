/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.CertificateContainer;
import org.ovirt.engine.sdk4.types.Certificate;

public class CertificateBuilder {
    private String comment;
    private String content;
    private String description;
    private String href;
    private String id;
    private String name;
    private String organization;
    private String subject;
    
    public CertificateBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public CertificateBuilder content(String newContent) {
        content = newContent;
        return this;
    }
    
    
    public CertificateBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public CertificateBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public CertificateBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public CertificateBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public CertificateBuilder organization(String newOrganization) {
        organization = newOrganization;
        return this;
    }
    
    
    public CertificateBuilder subject(String newSubject) {
        subject = newSubject;
        return this;
    }
    
    
    public Certificate build() {
        CertificateContainer container = new CertificateContainer();
        container.comment(comment);
        container.content(content);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.organization(organization);
        container.subject(subject);
        return container;
    }
}
