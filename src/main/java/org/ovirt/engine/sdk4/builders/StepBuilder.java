/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.StepContainer;
import org.ovirt.engine.sdk4.types.ExternalSystemType;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.Job;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.Step;
import org.ovirt.engine.sdk4.types.StepEnum;
import org.ovirt.engine.sdk4.types.StepStatus;

public class StepBuilder {
    private String comment;
    private String description;
    private Date endTime;
    private Host executionHost;
    private Boolean external;
    private ExternalSystemType externalType;
    private String href;
    private String id;
    private Job job;
    private String name;
    private BigInteger number;
    private Step parentStep;
    private BigInteger progress;
    private Date startTime;
    private List<Statistic> statistics;
    private StepStatus status;
    private StepEnum type;
    
    public StepBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public StepBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public StepBuilder endTime(Date newEndTime) {
        if (newEndTime == null) {
            endTime = null;
        }
        else {
            endTime = new Date(newEndTime.getTime());
        }
        return this;
    }
    
    
    public StepBuilder executionHost(Host newExecutionHost) {
        executionHost = newExecutionHost;
        return this;
    }
    
    public StepBuilder executionHost(HostBuilder newExecutionHost) {
        if (newExecutionHost == null) {
            executionHost = null;
        }
        else {
            executionHost = newExecutionHost.build();
        }
        return this;
    }
    
    
    public StepBuilder external(boolean newExternal) {
        external = Boolean.valueOf(newExternal);
        return this;
    }
    
    public StepBuilder external(Boolean newExternal) {
        external = newExternal;
        return this;
    }
    
    
    public StepBuilder externalType(ExternalSystemType newExternalType) {
        externalType = newExternalType;
        return this;
    }
    
    
    public StepBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public StepBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public StepBuilder job(Job newJob) {
        job = newJob;
        return this;
    }
    
    public StepBuilder job(JobBuilder newJob) {
        if (newJob == null) {
            job = null;
        }
        else {
            job = newJob.build();
        }
        return this;
    }
    
    
    public StepBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public StepBuilder number(int newNumber) {
        number = BigInteger.valueOf((long) newNumber);
        return this;
    }
    
    public StepBuilder number(Integer newNumber) {
        if (newNumber == null) {
            number = null;
        }
        else {
            number = BigInteger.valueOf(newNumber.longValue());
        }
        return this;
    }
    
    public StepBuilder number(long newNumber) {
        number = BigInteger.valueOf(newNumber);
        return this;
    }
    
    public StepBuilder number(Long newNumber) {
        if (newNumber == null) {
            number = null;
        }
        else {
            number = BigInteger.valueOf(newNumber.longValue());
        }
        return this;
    }
    
    public StepBuilder number(BigInteger newNumber) {
        number = newNumber;
        return this;
    }
    
    
    public StepBuilder parentStep(Step newParentStep) {
        parentStep = newParentStep;
        return this;
    }
    
    public StepBuilder parentStep(StepBuilder newParentStep) {
        if (newParentStep == null) {
            parentStep = null;
        }
        else {
            parentStep = newParentStep.build();
        }
        return this;
    }
    
    
    public StepBuilder progress(int newProgress) {
        progress = BigInteger.valueOf((long) newProgress);
        return this;
    }
    
    public StepBuilder progress(Integer newProgress) {
        if (newProgress == null) {
            progress = null;
        }
        else {
            progress = BigInteger.valueOf(newProgress.longValue());
        }
        return this;
    }
    
    public StepBuilder progress(long newProgress) {
        progress = BigInteger.valueOf(newProgress);
        return this;
    }
    
    public StepBuilder progress(Long newProgress) {
        if (newProgress == null) {
            progress = null;
        }
        else {
            progress = BigInteger.valueOf(newProgress.longValue());
        }
        return this;
    }
    
    public StepBuilder progress(BigInteger newProgress) {
        progress = newProgress;
        return this;
    }
    
    
    public StepBuilder startTime(Date newStartTime) {
        if (newStartTime == null) {
            startTime = null;
        }
        else {
            startTime = new Date(newStartTime.getTime());
        }
        return this;
    }
    
    
    public StepBuilder statistics(List<Statistic> newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics);
            }
            else {
                statistics.addAll(newStatistics);
            }
        }
        return this;
    }
    
    public StepBuilder statistics(Statistic... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            Collections.addAll(statistics, newStatistics);
        }
        return this;
    }
    
    public StepBuilder statistics(StatisticBuilder... newStatistics) {
        if (newStatistics != null) {
            if (statistics == null) {
                statistics = new ArrayList<>(newStatistics.length);
            }
            for (StatisticBuilder builder : newStatistics) {
                statistics.add(builder.build());
            }
        }
        return this;
    }
    
    
    public StepBuilder status(StepStatus newStatus) {
        status = newStatus;
        return this;
    }
    
    
    public StepBuilder type(StepEnum newType) {
        type = newType;
        return this;
    }
    
    
    public Step build() {
        StepContainer container = new StepContainer();
        container.comment(comment);
        container.description(description);
        container.endTime(endTime);
        container.executionHost(executionHost);
        container.external(external);
        container.externalType(externalType);
        container.href(href);
        container.id(id);
        container.job(job);
        container.name(name);
        container.number(number);
        container.parentStep(parentStep);
        container.progress(progress);
        container.startTime(startTime);
        container.statistics(statistics);
        container.status(status);
        container.type(type);
        return container;
    }
}
