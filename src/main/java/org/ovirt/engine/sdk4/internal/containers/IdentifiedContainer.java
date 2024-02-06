/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.Identified;

public class IdentifiedContainer extends Container implements Identified {
    private String comment;
    private String description;
    private String href;
    private String id;
    private String name;
    
    public String comment() {
        return comment;
    }
    
    public void comment(String newComment) {
        comment = newComment;
    }
    
    public boolean commentPresent() {
        return comment != null;
    }
    
    public String description() {
        return description;
    }
    
    public void description(String newDescription) {
        description = newDescription;
    }
    
    public boolean descriptionPresent() {
        return description != null;
    }
    
    public String href() {
        return href;
    }
    
    public void href(String newHref) {
        href = newHref;
    }
    
    public boolean hrefPresent() {
        return href != null;
    }
    
    public String id() {
        return id;
    }
    
    public void id(String newId) {
        id = newId;
    }
    
    public boolean idPresent() {
        return id != null;
    }
    
    public String name() {
        return name;
    }
    
    public void name(String newName) {
        name = newName;
    }
    
    public boolean namePresent() {
        return name != null;
    }
    
}
