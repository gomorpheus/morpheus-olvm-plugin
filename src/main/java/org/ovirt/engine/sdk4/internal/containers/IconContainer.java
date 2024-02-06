/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.Icon;

public class IconContainer extends IdentifiedContainer implements Icon {
    private String data;
    private String mediaType;
    
    public String data() {
        return data;
    }
    
    public void data(String newData) {
        data = newData;
    }
    
    public boolean dataPresent() {
        return data != null;
    }
    
    public String mediaType() {
        return mediaType;
    }
    
    public void mediaType(String newMediaType) {
        mediaType = newMediaType;
    }
    
    public boolean mediaTypePresent() {
        return mediaType != null;
    }
    
}
