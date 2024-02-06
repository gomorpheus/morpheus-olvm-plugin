/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.Date;
import java.util.List;

public interface Checkpoint extends Identified {
    Date creationDate();
    
    boolean creationDatePresent();
    
    String parentId();
    
    boolean parentIdPresent();
    
    CheckpointState state();
    
    boolean statePresent();
    
    List<Disk> disks();
    
    boolean disksPresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
