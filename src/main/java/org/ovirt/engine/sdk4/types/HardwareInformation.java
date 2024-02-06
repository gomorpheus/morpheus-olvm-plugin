/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

/**
 * Represents hardware information of host.
 * 
 * To get that information send a request like this:
 * 
 * ....
 * GET /ovirt-engine/api/hosts/123
 * ....
 * 
 * The result will be like this:
 * 
 * [source,xml]
 * ----
 * <host href="/ovirt-engine/api/hosts/123" id="123">
 *   ...
 *   <hardware_information>
 *     <family>Red Hat Enterprise Linux</family>
 *     <manufacturer>Red Hat</manufacturer>
 *     <product_name>RHEV Hypervisor</product_name>
 *     <serial_number>01234567-89AB-CDEF-0123-456789ABCDEF</serial_number>
 *     <supported_rng_sources>
 *       <supported_rng_source>random</supported_rng_source>
 *     </supported_rng_sources>
 *     <uuid>12345678-9ABC-DEF0-1234-56789ABCDEF0</uuid>
 *     <version>1.2-34.5.el7ev</version>
 *   </hardware_information>
 *   ...
 * </application>
 * ----
 */
public interface HardwareInformation {
    String family();
    
    boolean familyPresent();
    
    String manufacturer();
    
    boolean manufacturerPresent();
    
    String productName();
    
    boolean productNamePresent();
    
    String serialNumber();
    
    boolean serialNumberPresent();
    
    List<RngSource> supportedRngSources();
    
    boolean supportedRngSourcesPresent();
    
    String uuid();
    
    boolean uuidPresent();
    
    String version();
    
    boolean versionPresent();
    
}
