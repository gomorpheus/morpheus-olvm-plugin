/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.Date;
import org.ovirt.engine.sdk4.types.Api;
import org.ovirt.engine.sdk4.types.ApiSummary;
import org.ovirt.engine.sdk4.types.ProductInfo;
import org.ovirt.engine.sdk4.types.SpecialObjects;
import org.ovirt.engine.sdk4.types.User;

public class ApiContainer extends Container implements Api {
    private ProductInfo productInfo;
    private SpecialObjects specialObjects;
    private ApiSummary summary;
    private Date time;
    private User authenticatedUser;
    private User effectiveUser;
    
    public ProductInfo productInfo() {
        return productInfo;
    }
    
    public void productInfo(ProductInfo newProductInfo) {
        productInfo = newProductInfo;
    }
    
    public boolean productInfoPresent() {
        return productInfo != null;
    }
    
    public SpecialObjects specialObjects() {
        return specialObjects;
    }
    
    public void specialObjects(SpecialObjects newSpecialObjects) {
        specialObjects = newSpecialObjects;
    }
    
    public boolean specialObjectsPresent() {
        return specialObjects != null;
    }
    
    public ApiSummary summary() {
        return summary;
    }
    
    public void summary(ApiSummary newSummary) {
        summary = newSummary;
    }
    
    public boolean summaryPresent() {
        return summary != null;
    }
    
    public Date time() {
        if (time == null) {
            return null;
        }
        else {
            return new Date(time.getTime());
        }
    }
    
    public void time(Date newTime) {
        if (newTime == null) {
            time = null;
        }
        else {
            time = new Date(newTime.getTime());
        }
    }
    
    public boolean timePresent() {
        return time != null;
    }
    
    public User authenticatedUser() {
        return authenticatedUser;
    }
    
    public void authenticatedUser(User newAuthenticatedUser) {
        authenticatedUser = newAuthenticatedUser;
    }
    
    public boolean authenticatedUserPresent() {
        return authenticatedUser != null;
    }
    
    public User effectiveUser() {
        return effectiveUser;
    }
    
    public void effectiveUser(User newEffectiveUser) {
        effectiveUser = newEffectiveUser;
    }
    
    public boolean effectiveUserPresent() {
        return effectiveUser != null;
    }
    
}
