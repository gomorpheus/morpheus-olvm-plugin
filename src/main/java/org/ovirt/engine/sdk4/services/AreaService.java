/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;

/**
 * This annotation is intended to specify what oVirt area is the annotated concept related to. Currently the following
 * areas are in use, and they are closely related to the oVirt teams, but not necessarily the same:
 * 
 * - Infrastructure
 * - Network
 * - SLA
 * - Storage
 * - Virtualization
 * 
 * A concept may be associated to more than one area, or to no area.
 * 
 * The value of this annotation is intended for reporting only, and it doesn't affect at all the generated code or the
 * validity of the model
 */
public interface AreaService extends Service {
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

