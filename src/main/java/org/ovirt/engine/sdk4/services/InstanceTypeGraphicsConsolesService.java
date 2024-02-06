/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.GraphicsConsoleBuilder;
import org.ovirt.engine.sdk4.types.GraphicsConsole;

public interface InstanceTypeGraphicsConsolesService extends Service {
    /**
     * Add new graphics console to the instance type.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest console(GraphicsConsole console);
        AddRequest console(GraphicsConsoleBuilder console);
    }
    
    /**
     * Add new graphics console to the instance type.
     */
    public interface AddResponse extends Response {
        GraphicsConsole console();
    }
    
    /**
     * Add new graphics console to the instance type.
     */
    AddRequest add();
    
    /**
     * Lists all the configured graphics consoles of the instance type.
     * 
     * The order of the returned list of graphics consoles isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of consoles to return. If not specified all the consoles are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of consoles to return. If not specified all the consoles are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of consoles to return. If not specified all the consoles are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Lists all the configured graphics consoles of the instance type.
     * 
     * The order of the returned list of graphics consoles isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of graphics consoles of the instance type.
         */
        List<GraphicsConsole> consoles();
    }
    
    /**
     * Lists all the configured graphics consoles of the instance type.
     * 
     * The order of the returned list of graphics consoles isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Returns a reference to the service that manages a specific instance type graphics console.
     */
    InstanceTypeGraphicsConsoleService consoleService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

