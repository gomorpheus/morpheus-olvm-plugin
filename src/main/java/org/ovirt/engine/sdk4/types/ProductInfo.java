/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

/**
 * Product information.
 * 
 * The entry point contains a `product_info` element to help an API user determine the legitimacy of the
 * {product-name} environment. This includes the name of the product, the `vendor` and the `version`.
 * 
 * Verify a genuine {product-name} environment
 * 
 * The follow elements identify a genuine {product-name} environment:
 * 
 * [source]
 * ----
 * <api>
 * ...
 * <product_info>
 *   <name>oVirt Engine</name>
 *   <vendor>ovirt.org</vendor>
 *   <version>
 *     <build>0</build>
 *     <full_version>4.1.0_master</full_version>
 *     <major>4</major>
 *     <minor>1</minor>
 *     <revision>0</revision>
 *   </version>
 * </product_info>
 * ...
 * </api>
 * ----
 */
public interface ProductInfo {
    String instanceId();
    
    boolean instanceIdPresent();
    
    String name();
    
    boolean namePresent();
    
    String vendor();
    
    boolean vendorPresent();
    
    Version version();
    
    boolean versionPresent();
    
}
