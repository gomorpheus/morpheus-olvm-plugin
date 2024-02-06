/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.util.Date;
import org.ovirt.engine.sdk4.types.OpenStackVolumeProvider;
import org.ovirt.engine.sdk4.types.OpenstackVolumeAuthenticationKey;
import org.ovirt.engine.sdk4.types.OpenstackVolumeAuthenticationKeyUsageType;

public class OpenstackVolumeAuthenticationKeyContainer extends IdentifiedContainer implements OpenstackVolumeAuthenticationKey {
    private Date creationDate;
    private OpenstackVolumeAuthenticationKeyUsageType usageType;
    private String uuid;
    private String value;
    private OpenStackVolumeProvider openstackVolumeProvider;
    
    public Date creationDate() {
        if (creationDate == null) {
            return null;
        }
        else {
            return new Date(creationDate.getTime());
        }
    }
    
    public void creationDate(Date newCreationDate) {
        if (newCreationDate == null) {
            creationDate = null;
        }
        else {
            creationDate = new Date(newCreationDate.getTime());
        }
    }
    
    public boolean creationDatePresent() {
        return creationDate != null;
    }
    
    public OpenstackVolumeAuthenticationKeyUsageType usageType() {
        return usageType;
    }
    
    public void usageType(OpenstackVolumeAuthenticationKeyUsageType newUsageType) {
        usageType = newUsageType;
    }
    
    public boolean usageTypePresent() {
        return usageType != null;
    }
    
    public String uuid() {
        return uuid;
    }
    
    public void uuid(String newUuid) {
        uuid = newUuid;
    }
    
    public boolean uuidPresent() {
        return uuid != null;
    }
    
    public String value() {
        return value;
    }
    
    public void value(String newValue) {
        value = newValue;
    }
    
    public boolean valuePresent() {
        return value != null;
    }
    
    public OpenStackVolumeProvider openstackVolumeProvider() {
        return openstackVolumeProvider;
    }
    
    public void openstackVolumeProvider(OpenStackVolumeProvider newOpenstackVolumeProvider) {
        openstackVolumeProvider = newOpenstackVolumeProvider;
    }
    
    public boolean openstackVolumeProviderPresent() {
        return openstackVolumeProvider != null;
    }
    
}
