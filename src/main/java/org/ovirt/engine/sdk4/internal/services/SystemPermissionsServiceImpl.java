/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.services.PermissionService;
import org.ovirt.engine.sdk4.services.SystemPermissionsService;

public class SystemPermissionsServiceImpl extends AssignedPermissionsServiceImpl implements SystemPermissionsService {
    
    public SystemPermissionsServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    public PermissionService permissionService(String id) {
        return new PermissionServiceImpl(getConnection(), getPath() + "/" + id);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        int index = path.indexOf('/');
        if (index == -1) {
            return permissionService(path);
        }
        return permissionService(path.substring(0, index)).service(path.substring(index + 1));
    }
    
    public String toString() {
        return "SystemPermissionsService:" + getPath();
    }
    
}

