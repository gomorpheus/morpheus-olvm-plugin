/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.GlusterHook;
import org.ovirt.engine.sdk4.types.GlusterHookStatus;
import org.ovirt.engine.sdk4.types.GlusterServerHook;
import org.ovirt.engine.sdk4.types.HookContentType;
import org.ovirt.engine.sdk4.types.HookStage;

public class GlusterHookContainer extends IdentifiedContainer implements GlusterHook {
    private String checksum;
    private BigInteger conflictStatus;
    private String conflicts;
    private String content;
    private HookContentType contentType;
    private String glusterCommand;
    private HookStage stage;
    private GlusterHookStatus status;
    private Cluster cluster;
    private List<GlusterServerHook> serverHooks;
    
    public String checksum() {
        return checksum;
    }
    
    public void checksum(String newChecksum) {
        checksum = newChecksum;
    }
    
    public boolean checksumPresent() {
        return checksum != null;
    }
    
    public BigInteger conflictStatus() {
        return conflictStatus;
    }
    
    public Byte conflictStatusAsByte() {
        return asByte("GlusterHook", "conflictStatus", conflictStatus);
    }
    
    public Short conflictStatusAsShort() {
        return asShort("GlusterHook", "conflictStatus", conflictStatus);
    }
    
    public Integer conflictStatusAsInteger() {
        return asInteger("GlusterHook", "conflictStatus", conflictStatus);
    }
    
    public Long conflictStatusAsLong() {
        return asLong("GlusterHook", "conflictStatus", conflictStatus);
    }
    
    public void conflictStatus(BigInteger newConflictStatus) {
        conflictStatus = newConflictStatus;
    }
    
    public boolean conflictStatusPresent() {
        return conflictStatus != null;
    }
    
    public String conflicts() {
        return conflicts;
    }
    
    public void conflicts(String newConflicts) {
        conflicts = newConflicts;
    }
    
    public boolean conflictsPresent() {
        return conflicts != null;
    }
    
    public String content() {
        return content;
    }
    
    public void content(String newContent) {
        content = newContent;
    }
    
    public boolean contentPresent() {
        return content != null;
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
    
    public String glusterCommand() {
        return glusterCommand;
    }
    
    public void glusterCommand(String newGlusterCommand) {
        glusterCommand = newGlusterCommand;
    }
    
    public boolean glusterCommandPresent() {
        return glusterCommand != null;
    }
    
    public HookStage stage() {
        return stage;
    }
    
    public void stage(HookStage newStage) {
        stage = newStage;
    }
    
    public boolean stagePresent() {
        return stage != null;
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
    
    public Cluster cluster() {
        return cluster;
    }
    
    public void cluster(Cluster newCluster) {
        cluster = newCluster;
    }
    
    public boolean clusterPresent() {
        return cluster != null;
    }
    
    public List<GlusterServerHook> serverHooks() {
        return makeUnmodifiableList(serverHooks);
    }
    
    public void serverHooks(List<GlusterServerHook> newServerHooks) {
        serverHooks = makeArrayList(newServerHooks);
    }
    
    public boolean serverHooksPresent() {
        return serverHooks != null && !serverHooks.isEmpty();
    }
    
}
