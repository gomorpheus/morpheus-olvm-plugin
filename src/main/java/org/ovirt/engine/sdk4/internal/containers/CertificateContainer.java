/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.Certificate;

public class CertificateContainer extends IdentifiedContainer implements Certificate {
    private String content;
    private String organization;
    private String subject;
    
    public String content() {
        return content;
    }
    
    public void content(String newContent) {
        content = newContent;
    }
    
    public boolean contentPresent() {
        return content != null;
    }
    
    public String organization() {
        return organization;
    }
    
    public void organization(String newOrganization) {
        organization = newOrganization;
    }
    
    public boolean organizationPresent() {
        return organization != null;
    }
    
    public String subject() {
        return subject;
    }
    
    public void subject(String newSubject) {
        subject = newSubject;
    }
    
    public boolean subjectPresent() {
        return subject != null;
    }
    
}
