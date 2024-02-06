/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.Date;

/**
 * This type contains the information returned by the root service of the API.
 * 
 * To get that information send a request like this:
 * 
 * ....
 * GET /ovirt-engine/api
 * ....
 * 
 * The result will be like this:
 * 
 * [source,xml]
 * ----
 * <api>
 *   <link rel="hosts" href="/ovirt-engine/api/hosts"/>
 *   <link rel="vms" href="/ovirt-engine/api/vms"/>
 *   ...
 *   <product_info>
 *     <name>oVirt Engine</name>
 *     <vendor>ovirt.org</vendor>
 *     <version>
 *       <build>0</build>
 *       <full_version>4.1.0_master</full_version>
 *       <major>4</major>
 *       <minor>1</minor>
 *       <revision>0</revision>
 *     </version>
 *   </product_info>
 *   <special_objects>
 *     <link rel="templates/blank" href="..."/>
 *     <link rel="tags/root" href="..."/>
 *   </special_objects>
 *   <summary>
 *     <vms>
 *       <total>10</total>
 *       <active>3</active>
 *     </vms>
 *     <hosts>
 *       <total>2</total>
 *       <active>2</active>
 *     </hosts>
 *     <users>
 *       <total>8</total>
 *       <active>2</active>
 *     </users>
 *     <storage_domains>
 *       <total>2</total>
 *       <active>2</active>
 *     </storage_domains>
 *   </summary>
 *   <time>2016-12-12T12:22:25.866+01:00</time>
 * </api>
 * ----
 */
public interface Api {
    ProductInfo productInfo();
    
    boolean productInfoPresent();
    
    SpecialObjects specialObjects();
    
    boolean specialObjectsPresent();
    
    ApiSummary summary();
    
    boolean summaryPresent();
    
    Date time();
    
    boolean timePresent();
    
    User authenticatedUser();
    
    boolean authenticatedUserPresent();
    
    User effectiveUser();
    
    boolean effectiveUserPresent();
    
}
