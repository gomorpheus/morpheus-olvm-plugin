/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigDecimal;

public interface Value {
    BigDecimal datum();
    
    boolean datumPresent();
    
    String detail();
    
    boolean detailPresent();
    
}
