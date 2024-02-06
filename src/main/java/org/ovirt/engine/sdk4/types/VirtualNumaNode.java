/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * Represents the virtual NUMA node.
 * 
 * An example XML representation:
 * 
 * [source,xml]
 * ----
 * <vm_numa_node href="/ovirt-engine/api/vms/123/numanodes/456" id="456">
 *   <cpu>
 *     <cores>
 *       <core>
 *         <index>0</index>
 *       </core>
 *     </cores>
 *   </cpu>
 *   <index>0</index>
 *   <memory>1024</memory>
 *   <numa_node_pins>
 *     <numa_node_pin>
 *       <index>0</index>
 *     </numa_node_pin>
 *   </numa_node_pins>
 *   <vm href="/ovirt-engine/api/vms/123" id="123" />
 * </vm_numa_node>
 * ----
 */
public interface VirtualNumaNode extends NumaNode {
    List<NumaNodePin> numaNodePins();
    
    boolean numaNodePinsPresent();
    
    NumaTuneMode numaTuneMode();
    
    boolean numaTuneModePresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
