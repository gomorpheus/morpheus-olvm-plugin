/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * Represents a physical NUMA node.
 * 
 * Example XML representation:
 * 
 * [source,xml]
 * ----
 * <host_numa_node href="/ovirt-engine/api/hosts/0923f1ea/numanodes/007cf1ab" id="007cf1ab">
 *   <cpu>
 *     <cores>
 *       <core>
 *         <index>0</index>
 *       </core>
 *     </cores>
 *   </cpu>
 *   <index>0</index>
 *   <memory>65536</memory>
 *   <node_distance>40 20 40 10</node_distance>
 *   <host href="/ovirt-engine/api/hosts/0923f1ea" id="0923f1ea"/>
 * </host_numa_node>
 * ----
 */
public interface NumaNode extends Identified {
    Cpu cpu();
    
    boolean cpuPresent();
    
    BigInteger index();
    Byte indexAsByte();
    Short indexAsShort();
    Integer indexAsInteger();
    Long indexAsLong();
    
    boolean indexPresent();
    
    BigInteger memory();
    Byte memoryAsByte();
    Short memoryAsShort();
    Integer memoryAsInteger();
    Long memoryAsLong();
    
    boolean memoryPresent();
    
    String nodeDistance();
    
    boolean nodeDistancePresent();
    
    Host host();
    
    boolean hostPresent();
    
    List<Statistic> statistics();
    
    boolean statisticsPresent();
    
}
