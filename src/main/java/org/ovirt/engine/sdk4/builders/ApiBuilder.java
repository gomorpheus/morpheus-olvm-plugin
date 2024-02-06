/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.util.Date;
import org.ovirt.engine.sdk4.internal.containers.ApiContainer;
import org.ovirt.engine.sdk4.types.Api;
import org.ovirt.engine.sdk4.types.ApiSummary;
import org.ovirt.engine.sdk4.types.ProductInfo;
import org.ovirt.engine.sdk4.types.SpecialObjects;
import org.ovirt.engine.sdk4.types.User;

public class ApiBuilder {
    private User authenticatedUser;
    private User effectiveUser;
    private ProductInfo productInfo;
    private SpecialObjects specialObjects;
    private ApiSummary summary;
    private Date time;
    
    public ApiBuilder authenticatedUser(User newAuthenticatedUser) {
        authenticatedUser = newAuthenticatedUser;
        return this;
    }
    
    public ApiBuilder authenticatedUser(UserBuilder newAuthenticatedUser) {
        if (newAuthenticatedUser == null) {
            authenticatedUser = null;
        }
        else {
            authenticatedUser = newAuthenticatedUser.build();
        }
        return this;
    }
    
    
    public ApiBuilder effectiveUser(User newEffectiveUser) {
        effectiveUser = newEffectiveUser;
        return this;
    }
    
    public ApiBuilder effectiveUser(UserBuilder newEffectiveUser) {
        if (newEffectiveUser == null) {
            effectiveUser = null;
        }
        else {
            effectiveUser = newEffectiveUser.build();
        }
        return this;
    }
    
    
    public ApiBuilder productInfo(ProductInfo newProductInfo) {
        productInfo = newProductInfo;
        return this;
    }
    
    public ApiBuilder productInfo(ProductInfoBuilder newProductInfo) {
        if (newProductInfo == null) {
            productInfo = null;
        }
        else {
            productInfo = newProductInfo.build();
        }
        return this;
    }
    
    
    public ApiBuilder specialObjects(SpecialObjects newSpecialObjects) {
        specialObjects = newSpecialObjects;
        return this;
    }
    
    public ApiBuilder specialObjects(SpecialObjectsBuilder newSpecialObjects) {
        if (newSpecialObjects == null) {
            specialObjects = null;
        }
        else {
            specialObjects = newSpecialObjects.build();
        }
        return this;
    }
    
    
    public ApiBuilder summary(ApiSummary newSummary) {
        summary = newSummary;
        return this;
    }
    
    public ApiBuilder summary(ApiSummaryBuilder newSummary) {
        if (newSummary == null) {
            summary = null;
        }
        else {
            summary = newSummary.build();
        }
        return this;
    }
    
    
    public ApiBuilder time(Date newTime) {
        if (newTime == null) {
            time = null;
        }
        else {
            time = new Date(newTime.getTime());
        }
        return this;
    }
    
    
    public Api build() {
        ApiContainer container = new ApiContainer();
        container.authenticatedUser(authenticatedUser);
        container.effectiveUser(effectiveUser);
        container.productInfo(productInfo);
        container.specialObjects(specialObjects);
        container.summary(summary);
        container.time(time);
        return container;
    }
}
