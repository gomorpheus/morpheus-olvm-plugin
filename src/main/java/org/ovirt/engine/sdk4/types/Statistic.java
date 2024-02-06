/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * A generic type used for all kinds of statistics.
 * 
 * Statistic contains the statistics values for various entities.
 * The following object contain statistics:
 * 
 * * Disk
 * * Host
 * * HostNic
 * * NumaNode
 * * Nic
 * * Vm
 * * GlusterBrick
 * * Step
 * * GlusterVolume
 * 
 * An example of a XML representation:
 * 
 * [source,xml]
 * ----
 * <statistics>
 *   <statistic id="1234" href="/ovirt-engine/api/hosts/1234/nics/1234/statistics/1234">
 *     <name>data.current.rx</name>
 *     <description>Receive data rate</description>
 *     <values type="DECIMAL">
 *       <value>
 *         <datum>0</datum>
 *       </value>
 *     </values>
 *     <type>GAUGE</type>
 *     <unit>BYTES_PER_SECOND</unit>
 *     <host_nic id="1234" href="/ovirt-engine/api/hosts/1234/nics/1234"/>
 *   </statistic>
 *   ...
 * </statistics>
 * ----
 * 
 * NOTE: This statistics sub-collection is read-only.
 */
public interface Statistic extends Identified {
    StatisticKind kind();
    
    boolean kindPresent();
    
    ValueType type();
    
    boolean typePresent();
    
    StatisticUnit unit();
    
    boolean unitPresent();
    
    List<Value> values();
    
    boolean valuesPresent();
    
    GlusterBrick brick();
    
    boolean brickPresent();
    
    Disk disk();
    
    boolean diskPresent();
    
    GlusterVolume glusterVolume();
    
    boolean glusterVolumePresent();
    
    Host host();
    
    boolean hostPresent();
    
    HostNic hostNic();
    
    boolean hostNicPresent();
    
    NumaNode hostNumaNode();
    
    boolean hostNumaNodePresent();
    
    Nic nic();
    
    boolean nicPresent();
    
    Step step();
    
    boolean stepPresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
