/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.ProxyTicket;

public class ProxyTicketContainer extends Container implements ProxyTicket {
    private String value;
    
    public String value() {
        return value;
    }
    
    public void value(String newValue) {
        value = newValue;
    }
    
    public boolean valuePresent() {
        return value != null;
    }
    
}
