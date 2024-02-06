/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

/**
 * Represents a MAC address pool.
 * 
 * Example of an XML representation of a MAC address pool:
 * 
 * [source,xml]
 * ----
 * <mac_pool href="/ovirt-engine/api/macpools/123" id="123">
 *   <name>Default</name>
 *   <description>Default MAC pool</description>
 *   <allow_duplicates>false</allow_duplicates>
 *   <default_pool>true</default_pool>
 *   <ranges>
 *     <range>
 *       <from>00:1A:4A:16:01:51</from>
 *       <to>00:1A:4A:16:01:E6</to>
 *     </range>
 *   </ranges>
 * </mac_pool>
 * ----
 */
public interface MacPool extends Identified {
    boolean allowDuplicates();
    
    boolean allowDuplicatesPresent();
    
    boolean defaultPool();
    
    boolean defaultPoolPresent();
    
    List<Range> ranges();
    
    boolean rangesPresent();
    
    List<Permission> permissions();
    
    boolean permissionsPresent();
    
}
