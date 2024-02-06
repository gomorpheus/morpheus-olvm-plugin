/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface GlusterServerHook extends Identified {
    String checksum();
    
    boolean checksumPresent();
    
    HookContentType contentType();
    
    boolean contentTypePresent();
    
    GlusterHookStatus status();
    
    boolean statusPresent();
    
    Host host();
    
    boolean hostPresent();
    
}
