/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import org.ovirt.engine.sdk4.types.ExternalSystemType;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Job;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.Step;
import org.ovirt.engine.sdk4.types.StepEnum;
import org.ovirt.engine.sdk4.types.StepStatus;

public class StepContainer extends IdentifiedContainer implements Step {
    private Date endTime;
    private Boolean external;
    private ExternalSystemType externalType;
    private BigInteger number;
    private BigInteger progress;
    private Date startTime;
    private StepStatus status;
    private StepEnum type;
    private Host executionHost;
    private Job job;
    private Step parentStep;
    private List<Statistic> statistics;
    
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
    
    public ExternalSystemType externalType() {
        return externalType;
    }
    
    public void externalType(ExternalSystemType newExternalType) {
        externalType = newExternalType;
    }
    
    public boolean externalTypePresent() {
        return externalType != null;
    }
    
    public BigInteger number() {
        return number;
    }
    
    public Byte numberAsByte() {
        return asByte("Step", "number", number);
    }
    
    public Short numberAsShort() {
        return asShort("Step", "number", number);
    }
    
    public Integer numberAsInteger() {
        return asInteger("Step", "number", number);
    }
    
    public Long numberAsLong() {
        return asLong("Step", "number", number);
    }
    
    public void number(BigInteger newNumber) {
        number = newNumber;
    }
    
    public boolean numberPresent() {
        return number != null;
    }
    
    public BigInteger progress() {
        return progress;
    }
    
    public Byte progressAsByte() {
        return asByte("Step", "progress", progress);
    }
    
    public Short progressAsShort() {
        return asShort("Step", "progress", progress);
    }
    
    public Integer progressAsInteger() {
        return asInteger("Step", "progress", progress);
    }
    
    public Long progressAsLong() {
        return asLong("Step", "progress", progress);
    }
    
    public void progress(BigInteger newProgress) {
        progress = newProgress;
    }
    
    public boolean progressPresent() {
        return progress != null;
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
    
    public StepStatus status() {
        return status;
    }
    
    public void status(StepStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public StepEnum type() {
        return type;
    }
    
    public void type(StepEnum newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public Host executionHost() {
        return executionHost;
    }
    
    public void executionHost(Host newExecutionHost) {
        executionHost = newExecutionHost;
    }
    
    public boolean executionHostPresent() {
        return executionHost != null;
    }
    
    public Job job() {
        return job;
    }
    
    public void job(Job newJob) {
        job = newJob;
    }
    
    public boolean jobPresent() {
        return job != null;
    }
    
    public Step parentStep() {
        return parentStep;
    }
    
    public void parentStep(Step newParentStep) {
        parentStep = newParentStep;
    }
    
    public boolean parentStepPresent() {
        return parentStep != null;
    }
    
    public List<Statistic> statistics() {
        return makeUnmodifiableList(statistics);
    }
    
    public void statistics(List<Statistic> newStatistics) {
        statistics = makeArrayList(newStatistics);
    }
    
    public boolean statisticsPresent() {
        return statistics != null && !statistics.isEmpty();
    }
    
}
