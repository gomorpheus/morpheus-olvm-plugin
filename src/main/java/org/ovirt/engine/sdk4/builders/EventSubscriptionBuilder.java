/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import org.ovirt.engine.sdk4.internal.containers.EventSubscriptionContainer;
import org.ovirt.engine.sdk4.types.EventSubscription;
import org.ovirt.engine.sdk4.types.NotifiableEvent;
import org.ovirt.engine.sdk4.types.NotificationMethod;
import org.ovirt.engine.sdk4.types.User;

public class EventSubscriptionBuilder {
    private String address;
    private String comment;
    private String description;
    private NotifiableEvent event;
    private String href;
    private String id;
    private String name;
    private NotificationMethod notificationMethod;
    private User user;
    
    public EventSubscriptionBuilder address(String newAddress) {
        address = newAddress;
        return this;
    }
    
    
    public EventSubscriptionBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public EventSubscriptionBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public EventSubscriptionBuilder event(NotifiableEvent newEvent) {
        event = newEvent;
        return this;
    }
    
    
    public EventSubscriptionBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public EventSubscriptionBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public EventSubscriptionBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public EventSubscriptionBuilder notificationMethod(NotificationMethod newNotificationMethod) {
        notificationMethod = newNotificationMethod;
        return this;
    }
    
    
    public EventSubscriptionBuilder user(User newUser) {
        user = newUser;
        return this;
    }
    
    public EventSubscriptionBuilder user(UserBuilder newUser) {
        if (newUser == null) {
            user = null;
        }
        else {
            user = newUser.build();
        }
        return this;
    }
    
    
    public EventSubscription build() {
        EventSubscriptionContainer container = new EventSubscriptionContainer();
        container.address(address);
        container.comment(comment);
        container.description(description);
        container.event(event);
        container.href(href);
        container.id(id);
        container.name(name);
        container.notificationMethod(notificationMethod);
        container.user(user);
        return container;
    }
}
