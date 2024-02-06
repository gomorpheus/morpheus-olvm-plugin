/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.services;

import org.ovirt.engine.sdk4.Error;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.internal.HttpConnection;
import org.ovirt.engine.sdk4.services.EngineKatelloErrataService;
import org.ovirt.engine.sdk4.services.KatelloErratumService;

public class EngineKatelloErrataServiceImpl extends KatelloErrataServiceImpl implements EngineKatelloErrataService {
    
    public EngineKatelloErrataServiceImpl(HttpConnection connection, String path) {
        super(connection, path);
    }
    
    public KatelloErratumService katelloErratumService(String id) {
        return new KatelloErratumServiceImpl(getConnection(), getPath() + "/" + id);
    }
    
    public Service service(String path) {
        if (path == null) {
            return this;
        }
        
        int index = path.indexOf('/');
        if (index == -1) {
            return katelloErratumService(path);
        }
        return katelloErratumService(path.substring(0, index)).service(path.substring(index + 1));
    }
    
    public String toString() {
        return "EngineKatelloErrataService:" + getPath();
    }
    
}

