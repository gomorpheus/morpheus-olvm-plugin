/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigDecimal;
import org.ovirt.engine.sdk4.types.Value;

public class ValueContainer extends Container implements Value {
    private BigDecimal datum;
    private String detail;
    
    public BigDecimal datum() {
        return datum;
    }
    
    public void datum(BigDecimal newDatum) {
        datum = newDatum;
    }
    
    public boolean datumPresent() {
        return datum != null;
    }
    
    public String detail() {
        return detail;
    }
    
    public void detail(String newDetail) {
        detail = newDetail;
    }
    
    public boolean detailPresent() {
        return detail != null;
    }
    
}
