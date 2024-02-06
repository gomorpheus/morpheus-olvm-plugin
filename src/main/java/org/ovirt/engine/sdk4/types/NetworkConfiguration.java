/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

public interface NetworkConfiguration {
    Dns dns();
    
    boolean dnsPresent();
    
    List<Nic> nics();
    
    boolean nicsPresent();
    
}
