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
 * This service doesn't add any new methods, it is just a placeholder for the annotation that specifies the path of the
 * resource that manages the permissions assigned to the system object.
 */
public interface SystemPermissionsService extends AssignedPermissionsService {
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

