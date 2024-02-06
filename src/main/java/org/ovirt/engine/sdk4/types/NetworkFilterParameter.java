/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Parameter for the <<types/network_filter,network filter>>.
 * 
 * See https://libvirt.org/formatnwfilter.html#nwfconceptsvars[Libvirt-Filters] for further details.
 * This is a example of the XML representation:
 * 
 * [source,xml]
 * ----
 * <network_filter_parameter id="123">
 *   <name>IP</name>
 *   <value>10.0.1.2</value>
 * </network_filter_parameter>
 * ----
 */
public interface NetworkFilterParameter extends Identified {
    String value();
    
    boolean valuePresent();
    
    Nic nic();
    
    boolean nicPresent();
    
}
