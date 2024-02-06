/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.OpenStackProvider;

public class OpenStackProviderContainer extends ExternalProviderContainer implements OpenStackProvider {
    private String tenantName;
    
    public String tenantName() {
        return tenantName;
    }
    
    public void tenantName(String newTenantName) {
        tenantName = newTenantName;
    }
    
    public boolean tenantNamePresent() {
        return tenantName != null;
    }
    
}
