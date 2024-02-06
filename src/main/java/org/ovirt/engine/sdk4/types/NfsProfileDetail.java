/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface NfsProfileDetail extends EntityProfileDetail {
    String nfsServerIp();
    
    boolean nfsServerIpPresent();
    
}
