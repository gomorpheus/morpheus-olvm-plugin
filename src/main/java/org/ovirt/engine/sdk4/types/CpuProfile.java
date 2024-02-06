/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

public interface CpuProfile extends Identified {
    Cluster cluster();
    
    boolean clusterPresent();
    
    List<Permission> permissions();
    
    boolean permissionsPresent();
    
    Qos qos();
    
    boolean qosPresent();
    
}
