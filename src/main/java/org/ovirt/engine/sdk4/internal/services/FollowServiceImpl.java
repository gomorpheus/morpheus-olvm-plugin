/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.services.FollowService;

public class FollowServiceImpl extends ServiceImpl implements FollowService {
    
    public FollowServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        throw new Error("The path " + path + " doesn't correspond to any service");
    }
    
    public String toString() {
        return "FollowService:" + getPath();
    }
    
}

