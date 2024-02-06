/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.GlusterHookStatus;
import org.ovirt.engine.sdk4.types.GlusterServerHook;
import org.ovirt.engine.sdk4.types.HookContentType;
import org.ovirt.engine.sdk4.types.Host;

public class GlusterServerHookContainer extends IdentifiedContainer implements GlusterServerHook {
    private String checksum;
    private HookContentType contentType;
    private GlusterHookStatus status;
    private Host host;
    
    public String checksum() {
        return checksum;
    }
    
    public void checksum(String newChecksum) {
        checksum = newChecksum;
    }
    
    public boolean checksumPresent() {
        return checksum != null;
    }
    
    public HookContentType contentType() {
        return contentType;
    }
    
    public void contentType(HookContentType newContentType) {
        contentType = newContentType;
    }
    
    public boolean contentTypePresent() {
        return contentType != null;
    }
    
    public GlusterHookStatus status() {
        return status;
    }
    
    public void status(GlusterHookStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
}
