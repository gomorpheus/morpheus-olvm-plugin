/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.Date;
import org.ovirt.engine.sdk4.internal.containers.OpenstackVolumeAuthenticationKeyContainer;
import org.ovirt.engine.sdk4.types.OpenStackVolumeProvider;
import org.ovirt.engine.sdk4.types.OpenstackVolumeAuthenticationKey;
import org.ovirt.engine.sdk4.types.OpenstackVolumeAuthenticationKeyUsageType;

public class OpenstackVolumeAuthenticationKeyBuilder {
    private String comment;
    private Date creationDate;
    private String description;
    private String href;
    private String id;
    private String name;
    private OpenStackVolumeProvider openstackVolumeProvider;
    private OpenstackVolumeAuthenticationKeyUsageType usageType;
    private String uuid;
    private String value;
    
    public OpenstackVolumeAuthenticationKeyBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public OpenstackVolumeAuthenticationKeyBuilder creationDate(Date newCreationDate) {
        if (newCreationDate == null) {
            creationDate = null;
        }
        else {
            creationDate = new Date(newCreationDate.getTime());
        }
        return this;
    }
    
    
    public OpenstackVolumeAuthenticationKeyBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public OpenstackVolumeAuthenticationKeyBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public OpenstackVolumeAuthenticationKeyBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public OpenstackVolumeAuthenticationKeyBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public OpenstackVolumeAuthenticationKeyBuilder openstackVolumeProvider(OpenStackVolumeProvider newOpenstackVolumeProvider) {
        openstackVolumeProvider = newOpenstackVolumeProvider;
        return this;
    }
    
    public OpenstackVolumeAuthenticationKeyBuilder openstackVolumeProvider(OpenStackVolumeProviderBuilder newOpenstackVolumeProvider) {
        if (newOpenstackVolumeProvider == null) {
            openstackVolumeProvider = null;
        }
        else {
            openstackVolumeProvider = newOpenstackVolumeProvider.build();
        }
        return this;
    }
    
    
    public OpenstackVolumeAuthenticationKeyBuilder usageType(OpenstackVolumeAuthenticationKeyUsageType newUsageType) {
        usageType = newUsageType;
        return this;
    }
    
    
    public OpenstackVolumeAuthenticationKeyBuilder uuid(String newUuid) {
        uuid = newUuid;
        return this;
    }
    
    
    public OpenstackVolumeAuthenticationKeyBuilder value(String newValue) {
        value = newValue;
        return this;
    }
    
    
    public OpenstackVolumeAuthenticationKey build() {
        OpenstackVolumeAuthenticationKeyContainer container = new OpenstackVolumeAuthenticationKeyContainer();
        container.comment(comment);
        container.creationDate(creationDate);
        container.description(description);
        container.href(href);
        container.id(id);
        container.name(name);
        container.openstackVolumeProvider(openstackVolumeProvider);
        container.usageType(usageType);
        container.uuid(uuid);
        container.value(value);
        return container;
    }
}
