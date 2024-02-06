/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;

public interface GlusterHook extends Identified {
    String checksum();
    
    boolean checksumPresent();
    
    BigInteger conflictStatus();
    Byte conflictStatusAsByte();
    Short conflictStatusAsShort();
    Integer conflictStatusAsInteger();
    Long conflictStatusAsLong();
    
    boolean conflictStatusPresent();
    
    String conflicts();
    
    boolean conflictsPresent();
    
    String content();
    
    boolean contentPresent();
    
    HookContentType contentType();
    
    boolean contentTypePresent();
    
    String glusterCommand();
    
    boolean glusterCommandPresent();
    
    HookStage stage();
    
    boolean stagePresent();
    
    GlusterHookStatus status();
    
    boolean statusPresent();
    
    Cluster cluster();
    
    boolean clusterPresent();
    
    List<GlusterServerHook> serverHooks();
    
    boolean serverHooksPresent();
    
}
