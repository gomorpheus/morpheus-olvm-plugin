/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.JobContainer;
import org.ovirt.engine.sdk4.types.Job;
import org.ovirt.engine.sdk4.types.JobStatus;
import org.ovirt.engine.sdk4.types.Step;
import org.ovirt.engine.sdk4.types.User;

public class JobBuilder {
    private Boolean autoCleared;
    private String comment;
    private String description;
    private Date endTime;
    private Boolean external;
    private String href;
    private String id;
    private Date lastUpdated;
    private String name;
    private User owner;
    private Date startTime;
    private JobStatus status;
    private List<Step> steps;
    
    public JobBuilder autoCleared(boolean newAutoCleared) {
        autoCleared = Boolean.valueOf(newAutoCleared);
        return this;
    }
    
    public JobBuilder autoCleared(Boolean newAutoCleared) {
        autoCleared = newAutoCleared;
        return this;
    }
    
    
    public JobBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public JobBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public JobBuilder endTime(Date newEndTime) {
        if (newEndTime == null) {
            endTime = null;
        }
        else {
            endTime = new Date(newEndTime.getTime());
        }
        return this;
    }
    
    
    public JobBuilder external(boolean newExternal) {
        external = Boolean.valueOf(newExternal);
        return this;
    }
    
    public JobBuilder external(Boolean newExternal) {
        external = newExternal;
        return this;
    }
    
    
    public JobBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public JobBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public JobBuilder lastUpdated(Date newLastUpdated) {
        if (newLastUpdated == null) {
            lastUpdated = null;
        }
        else {
            lastUpdated = new Date(newLastUpdated.getTime());
        }
        return this;
    }
    
    
    public JobBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public JobBuilder owner(User newOwner) {
        owner = newOwner;
        return this;
    }
    
    public JobBuilder owner(UserBuilder newOwner) {
        if (newOwner == null) {
            owner = null;
        }
        else {
            owner = newOwner.build();
        }
        return this;
    }
    
    
    public JobBuilder startTime(Date newStartTime) {
        if (newStartTime == null) {
            startTime = null;
        }
        else {
            startTime = new Date(newStartTime.getTime());
        }
        return this;
    }
    
    
    public JobBuilder status(JobStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public JobBuilder steps(List<Step> newSteps) {
        if (newSteps != null) {
            if (steps == null) {
                steps = new ArrayList<>(newSteps);
            }
            else {
                steps.addAll(newSteps);
            }
        }
        return this;
    }
    
    public JobBuilder steps(Step... newSteps) {
        if (newSteps != null) {
            if (steps == null) {
                steps = new ArrayList<>(newSteps.length);
            }
            Collections.addAll(steps, newSteps);
        }
        return this;
    }
    
    public JobBuilder steps(StepBuilder... newSteps) {
        if (newSteps != null) {
            if (steps == null) {
                steps = new ArrayList<>(newSteps.length);
            }
            for (StepBuilder builder : newSteps) {
                steps.add(builder.build());
            }
        }
        return this;
    }
    
    
    public Job build() {
        JobContainer container = new JobContainer();
        container.autoCleared(autoCleared);
        container.comment(comment);
        container.description(description);
        container.endTime(endTime);
        container.external(external);
        container.href(href);
        container.id(id);
        container.lastUpdated(lastUpdated);
        container.name(name);
        container.owner(owner);
        container.startTime(startTime);
        container.status(status);
        container.steps(steps);
        return container;
    }
}
