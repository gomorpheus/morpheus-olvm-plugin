/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import org.ovirt.engine.sdk4.types.OpenStackImage;
import org.ovirt.engine.sdk4.types.OpenStackImageProvider;

public class OpenStackImageContainer extends IdentifiedContainer implements OpenStackImage {
    private OpenStackImageProvider openstackImageProvider;
    
    public OpenStackImageProvider openstackImageProvider() {
        return openstackImageProvider;
    }
    
    public void openstackImageProvider(OpenStackImageProvider newOpenstackImageProvider) {
        openstackImageProvider = newOpenstackImageProvider;
    }
    
    public boolean openstackImageProviderPresent() {
        return openstackImageProvider != null;
    }
    
}
