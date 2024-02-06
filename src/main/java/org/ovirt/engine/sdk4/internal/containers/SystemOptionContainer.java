/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.SystemOption;
import org.ovirt.engine.sdk4.types.SystemOptionValue;

public class SystemOptionContainer extends IdentifiedContainer implements SystemOption {
    private List<SystemOptionValue> values;
    
    public List<SystemOptionValue> values() {
        return makeUnmodifiableList(values);
    }
    
    public void values(List<SystemOptionValue> newValues) {
        values = makeArrayList(newValues);
    }
    
    public boolean valuesPresent() {
        return values != null && !values.isEmpty();
    }
    
}
