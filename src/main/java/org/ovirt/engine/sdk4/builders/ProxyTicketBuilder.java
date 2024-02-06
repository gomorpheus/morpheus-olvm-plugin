/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.ProxyTicketContainer;
import org.ovirt.engine.sdk4.types.ProxyTicket;

public class ProxyTicketBuilder {
    private String value;
    
    public ProxyTicketBuilder value(String newValue) {
        value = newValue;
        return this;
    }
    
    
    public ProxyTicket build() {
        ProxyTicketContainer container = new ProxyTicketContainer();
        container.value(value);
        return container;
    }
}
