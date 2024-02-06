/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.Date;
import java.util.List;

public interface Backup extends Identified {
    Date creationDate();
    
    boolean creationDatePresent();
    
    String fromCheckpointId();
    
    boolean fromCheckpointIdPresent();
    
    Date modificationDate();
    
    boolean modificationDatePresent();
    
    BackupPhase phase();
    
    boolean phasePresent();
    
    String toCheckpointId();
    
    boolean toCheckpointIdPresent();
    
    List<Disk> disks();
    
    boolean disksPresent();
    
    Host host();
    
    boolean hostPresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
