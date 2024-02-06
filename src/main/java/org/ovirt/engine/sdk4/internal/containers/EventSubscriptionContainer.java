/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import org.ovirt.engine.sdk4.types.EventSubscription;
import org.ovirt.engine.sdk4.types.NotifiableEvent;
import org.ovirt.engine.sdk4.types.NotificationMethod;
import org.ovirt.engine.sdk4.types.User;

public class EventSubscriptionContainer extends IdentifiedContainer implements EventSubscription {
    private String address;
    private NotifiableEvent event;
    private NotificationMethod notificationMethod;
    private User user;
    
    public String address() {
        return address;
    }
    
    public void address(String newAddress) {
        address = newAddress;
    }
    
    public boolean addressPresent() {
        return address != null;
    }
    
    public NotifiableEvent event() {
        return event;
    }
    
    public void event(NotifiableEvent newEvent) {
        event = newEvent;
    }
    
    public boolean eventPresent() {
        return event != null;
    }
    
    public NotificationMethod notificationMethod() {
        return notificationMethod;
    }
    
    public void notificationMethod(NotificationMethod newNotificationMethod) {
        notificationMethod = newNotificationMethod;
    }
    
    public boolean notificationMethodPresent() {
        return notificationMethod != null;
    }
    
    public User user() {
        return user;
    }
    
    public void user(User newUser) {
        user = newUser;
    }
    
    public boolean userPresent() {
        return user != null;
    }
    
}
