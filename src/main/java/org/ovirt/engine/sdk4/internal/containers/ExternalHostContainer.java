/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.ExternalHost;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;

public class ExternalHostContainer extends IdentifiedContainer implements ExternalHost {
    private String address;
    private ExternalHostProvider externalHostProvider;
    
    public String address() {
        return address;
    }
    
    public void address(String newAddress) {
        address = newAddress;
    }
    
    public boolean addressPresent() {
        return address != null;
    }
    
    public ExternalHostProvider externalHostProvider() {
        return externalHostProvider;
    }
    
    public void externalHostProvider(ExternalHostProvider newExternalHostProvider) {
        externalHostProvider = newExternalHostProvider;
    }
    
    public boolean externalHostProviderPresent() {
        return externalHostProvider != null;
    }
    
}
