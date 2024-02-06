/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;

public interface EventSubscription extends Identified {
    String address();
    
    boolean addressPresent();
    
    NotifiableEvent event();
    
    boolean eventPresent();
    
    NotificationMethod notificationMethod();
    
    boolean notificationMethodPresent();
    
    User user();
    
    boolean userPresent();
    
}
