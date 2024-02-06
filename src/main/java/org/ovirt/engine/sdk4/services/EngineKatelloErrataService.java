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
 * A service to manage Katello errata assigned to the engine.
 * The information is retrieved from Katello.
 */
public interface EngineKatelloErrataService extends KatelloErrataService {
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

