/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigDecimal;
import org.ovirt.engine.sdk4.internal.containers.ValueContainer;
import org.ovirt.engine.sdk4.types.Value;

public class ValueBuilder {
    private BigDecimal datum;
    private String detail;
    
    public ValueBuilder datum(float newDatum) {
        datum = BigDecimal.valueOf((double) newDatum);
        return this;
    }
    
    public ValueBuilder datum(Float newDatum) {
        if (newDatum == null) {
            datum = null;
        }
        else {
            datum = BigDecimal.valueOf(newDatum.doubleValue());
        }
        return this;
    }
    
    public ValueBuilder datum(double newDatum) {
        datum = BigDecimal.valueOf(newDatum);
        return this;
    }
    
    public ValueBuilder datum(Double newDatum) {
        if (newDatum == null) {
            datum = null;
        }
        else {
            datum = BigDecimal.valueOf(newDatum.doubleValue());
        }
        return this;
    }
    
    public ValueBuilder datum(BigDecimal newDatum) {
        datum = newDatum;
        return this;
    }
    
    
    public ValueBuilder detail(String newDetail) {
        detail = newDetail;
        return this;
    }
    
    
    public Value build() {
        ValueContainer container = new ValueContainer();
        container.datum(datum);
        container.detail(detail);
        return container;
    }
}
