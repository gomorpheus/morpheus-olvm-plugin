/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.util.List;

public interface EntityProfileDetail {
    List<ProfileDetail> profileDetails();
    
    boolean profileDetailsPresent();
    
}
