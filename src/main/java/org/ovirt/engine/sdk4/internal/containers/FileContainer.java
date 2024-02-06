/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.File;
import org.ovirt.engine.sdk4.types.StorageDomain;

public class FileContainer extends IdentifiedContainer implements File {
    private String content;
    private String type;
    private StorageDomain storageDomain;
    
    public String content() {
        return content;
    }
    
    public void content(String newContent) {
        content = newContent;
    }
    
    public boolean contentPresent() {
        return content != null;
    }
    
    public String type() {
        return type;
    }
    
    public void type(String newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public StorageDomain storageDomain() {
        return storageDomain;
    }
    
    public void storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
    }
    
    public boolean storageDomainPresent() {
        return storageDomain != null;
    }
    
}
