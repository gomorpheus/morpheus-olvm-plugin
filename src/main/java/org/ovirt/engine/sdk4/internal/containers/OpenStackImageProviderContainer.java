/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.Certificate;
import org.ovirt.engine.sdk4.types.OpenStackImage;
import org.ovirt.engine.sdk4.types.OpenStackImageProvider;

public class OpenStackImageProviderContainer extends OpenStackProviderContainer implements OpenStackImageProvider {
    private List<Certificate> certificates;
    private List<OpenStackImage> images;
    
    public List<Certificate> certificates() {
        return makeUnmodifiableList(certificates);
    }
    
    public void certificates(List<Certificate> newCertificates) {
        certificates = makeArrayList(newCertificates);
    }
    
    public boolean certificatesPresent() {
        return certificates != null && !certificates.isEmpty();
    }
    
    public List<OpenStackImage> images() {
        return makeUnmodifiableList(images);
    }
    
    public void images(List<OpenStackImage> newImages) {
        images = makeArrayList(newImages);
    }
    
    public boolean imagesPresent() {
        return images != null && !images.isEmpty();
    }
    
}
