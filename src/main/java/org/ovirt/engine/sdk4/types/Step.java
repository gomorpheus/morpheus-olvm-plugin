/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Represents a step, which is part of `job` execution.
 * Step is used to describe and track a specific execution unit which is part of a wider sequence.
 * Some steps support reporting their progress.
 */
public interface Step extends Identified {
    Date endTime();
    
    boolean endTimePresent();
    
    boolean external();
    
    boolean externalPresent();
    
    ExternalSystemType externalType();
    
    boolean externalTypePresent();
    
    BigInteger number();
    Byte numberAsByte();
    Short numberAsShort();
    Integer numberAsInteger();
    Long numberAsLong();
    
    boolean numberPresent();
    
    BigInteger progress();
    Byte progressAsByte();
    Short progressAsShort();
    Integer progressAsInteger();
    Long progressAsLong();
    
    boolean progressPresent();
    
    Date startTime();
    
    boolean startTimePresent();
    
    StepStatus status();
    
    boolean statusPresent();
    
    StepEnum type();
    
    boolean typePresent();
    
    Host executionHost();
    
    boolean executionHostPresent();
    
    Job job();
    
    boolean jobPresent();
    
    Step parentStep();
    
    boolean parentStepPresent();
    
    List<Statistic> statistics();
    
    boolean statisticsPresent();
    
}
