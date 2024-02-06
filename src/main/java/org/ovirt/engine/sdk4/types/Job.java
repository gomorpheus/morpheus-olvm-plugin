/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.Date;
import java.util.List;

/**
 * Represents a job, which monitors execution of a flow in the system.
 * A job can contain multiple steps in a hierarchic structure.
 * The steps can be processed in parallel, depends on the implementation of the flow.
 */
public interface Job extends Identified {
    boolean autoCleared();
    
    boolean autoClearedPresent();
    
    Date endTime();
    
    boolean endTimePresent();
    
    boolean external();
    
    boolean externalPresent();
    
    Date lastUpdated();
    
    boolean lastUpdatedPresent();
    
    Date startTime();
    
    boolean startTimePresent();
    
    JobStatus status();
    
    boolean statusPresent();
    
    User owner();
    
    boolean ownerPresent();
    
    List<Step> steps();
    
    boolean stepsPresent();
    
}
