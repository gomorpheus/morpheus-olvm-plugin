/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.util.Date;
import java.util.List;
import org.ovirt.engine.sdk4.types.Job;
import org.ovirt.engine.sdk4.types.JobStatus;
import org.ovirt.engine.sdk4.types.Step;
import org.ovirt.engine.sdk4.types.User;

public class JobContainer extends IdentifiedContainer implements Job {
    private Boolean autoCleared;
    private Date endTime;
    private Boolean external;
    private Date lastUpdated;
    private Date startTime;
    private JobStatus status;
    private User owner;
    private List<Step> steps;
    
    public boolean autoCleared() {
        return autoCleared;
    }
    
    public void autoCleared(boolean newAutoCleared) {
        autoCleared = Boolean.valueOf(newAutoCleared);
    }
    
    public void autoCleared(Boolean newAutoCleared) {
        autoCleared = newAutoCleared;
    }
    
    public boolean autoClearedPresent() {
        return autoCleared != null;
    }
    
    public Date endTime() {
        if (endTime == null) {
            return null;
        }
        else {
            return new Date(endTime.getTime());
        }
    }
    
    public void endTime(Date newEndTime) {
        if (newEndTime == null) {
            endTime = null;
        }
        else {
            endTime = new Date(newEndTime.getTime());
        }
    }
    
    public boolean endTimePresent() {
        return endTime != null;
    }
    
    public boolean external() {
        return external;
    }
    
    public void external(boolean newExternal) {
        external = Boolean.valueOf(newExternal);
    }
    
    public void external(Boolean newExternal) {
        external = newExternal;
    }
    
    public boolean externalPresent() {
        return external != null;
    }
    
    public Date lastUpdated() {
        if (lastUpdated == null) {
            return null;
        }
        else {
            return new Date(lastUpdated.getTime());
        }
    }
    
    public void lastUpdated(Date newLastUpdated) {
        if (newLastUpdated == null) {
            lastUpdated = null;
        }
        else {
            lastUpdated = new Date(newLastUpdated.getTime());
        }
    }
    
    public boolean lastUpdatedPresent() {
        return lastUpdated != null;
    }
    
    public Date startTime() {
        if (startTime == null) {
            return null;
        }
        else {
            return new Date(startTime.getTime());
        }
    }
    
    public void startTime(Date newStartTime) {
        if (newStartTime == null) {
            startTime = null;
        }
        else {
            startTime = new Date(newStartTime.getTime());
        }
    }
    
    public boolean startTimePresent() {
        return startTime != null;
    }
    
    public JobStatus status() {
        return status;
    }
    
    public void status(JobStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public User owner() {
        return owner;
    }
    
    public void owner(User newOwner) {
        owner = newOwner;
    }
    
    public boolean ownerPresent() {
        return owner != null;
    }
    
    public List<Step> steps() {
        return makeUnmodifiableList(steps);
    }
    
    public void steps(List<Step> newSteps) {
        steps = makeArrayList(newSteps);
    }
    
    public boolean stepsPresent() {
        return steps != null && !steps.isEmpty();
    }
    
}
