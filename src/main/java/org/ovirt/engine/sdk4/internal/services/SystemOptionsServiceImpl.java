/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.services.SystemOptionService;
import org.ovirt.engine.sdk4.services.SystemOptionsService;

public class SystemOptionsServiceImpl extends ServiceImpl implements SystemOptionsService {
    
    public SystemOptionsServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    public SystemOptionService optionService(String id) {
        return new SystemOptionServiceImpl(getConnection(), getPath() + "/" + id);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        int index = path.indexOf('/');
        if (index == -1) {
            return optionService(path);
        }
        return optionService(path.substring(0, index)).service(path.substring(index + 1));
    }
    
    public String toString() {
        return "SystemOptionsService:" + getPath();
    }
    
}

