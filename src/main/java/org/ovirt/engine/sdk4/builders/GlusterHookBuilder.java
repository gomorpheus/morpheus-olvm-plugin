/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.GlusterHookContainer;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.GlusterHook;
import org.ovirt.engine.sdk4.types.GlusterHookStatus;
import org.ovirt.engine.sdk4.types.GlusterServerHook;
import org.ovirt.engine.sdk4.types.HookContentType;
import org.ovirt.engine.sdk4.types.HookStage;

public class GlusterHookBuilder {
    private String checksum;
    private Cluster cluster;
    private String comment;
    private BigInteger conflictStatus;
    private String conflicts;
    private String content;
    private HookContentType contentType;
    private String description;
    private String glusterCommand;
    private String href;
    private String id;
    private String name;
    private List<GlusterServerHook> serverHooks;
    private HookStage stage;
    private GlusterHookStatus status;
    
    public GlusterHookBuilder checksum(String newChecksum) {
        checksum = newChecksum;
        return this;
    }
    
    
    public GlusterHookBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public GlusterHookBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public GlusterHookBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public GlusterHookBuilder conflictStatus(int newConflictStatus) {
        conflictStatus = BigInteger.valueOf((long) newConflictStatus);
        return this;
    }
    
    public GlusterHookBuilder conflictStatus(Integer newConflictStatus) {
        if (newConflictStatus == null) {
            conflictStatus = null;
        }
        else {
            conflictStatus = BigInteger.valueOf(newConflictStatus.longValue());
        }
        return this;
    }
    
    public GlusterHookBuilder conflictStatus(long newConflictStatus) {
        conflictStatus = BigInteger.valueOf(newConflictStatus);
        return this;
    }
    
    public GlusterHookBuilder conflictStatus(Long newConflictStatus) {
        if (newConflictStatus == null) {
            conflictStatus = null;
        }
        else {
            conflictStatus = BigInteger.valueOf(newConflictStatus.longValue());
        }
        return this;
    }
    
    public GlusterHookBuilder conflictStatus(BigInteger newConflictStatus) {
        conflictStatus = newConflictStatus;
        return this;
    }
    
    
    public GlusterHookBuilder conflicts(String newConflicts) {
        conflicts = newConflicts;
        return this;
    }
    
    
    public GlusterHookBuilder content(String newContent) {
        content = newContent;
        return this;
    }
    
    
    public GlusterHookBuilder contentType(HookContentType newContentType) {
        contentType = newContentType;
        return this;
    }
    
    
    public GlusterHookBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public GlusterHookBuilder glusterCommand(String newGlusterCommand) {
        glusterCommand = newGlusterCommand;
        return this;
    }
    
    
    public GlusterHookBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public GlusterHookBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public GlusterHookBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public GlusterHookBuilder serverHooks(List<GlusterServerHook> newServerHooks) {
        if (newServerHooks != null) {
            if (serverHooks == null) {
                serverHooks = new ArrayList<>(newServerHooks);
            }
            else {
                serverHooks.addAll(newServerHooks);
            }
        }
        return this;
    }
    
    public GlusterHookBuilder serverHooks(GlusterServerHook... newServerHooks) {
        if (newServerHooks != null) {
            if (serverHooks == null) {
                serverHooks = new ArrayList<>(newServerHooks.length);
            }
            Collections.addAll(serverHooks, newServerHooks);
        }
        return this;
    }
    
    public GlusterHookBuilder serverHooks(GlusterServerHookBuilder... newServerHooks) {
        if (newServerHooks != null) {
            if (serverHooks == null) {
                serverHooks = new ArrayList<>(newServerHooks.length);
            }
            for (GlusterServerHookBuilder builder : newServerHooks) {
                serverHooks.add(builder.build());
            }
        }
        return this;
    }
    
    
    public GlusterHookBuilder stage(HookStage newStage) {
        stage = newStage;
        return this;
    }
    
    
    public GlusterHookBuilder status(GlusterHookStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public GlusterHook build() {
        GlusterHookContainer container = new GlusterHookContainer();
        container.checksum(checksum);
        container.cluster(cluster);
        container.comment(comment);
        container.conflictStatus(conflictStatus);
        container.conflicts(conflicts);
        container.content(content);
        container.contentType(contentType);
        container.description(description);
        container.glusterCommand(glusterCommand);
        container.href(href);
        container.id(id);
        container.name(name);
        container.serverHooks(serverHooks);
        container.stage(stage);
        container.status(status);
        return container;
    }
}
