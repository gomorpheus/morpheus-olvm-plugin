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

public interface VmGraphicsConsolesService extends Service {
    /**
     * Add new graphics console to the virtual machine.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest console(GraphicsConsole console);
        AddRequest console(GraphicsConsoleBuilder console);
    }
    
    /**
     * Add new graphics console to the virtual machine.
     */
    public interface AddResponse extends Response {
        GraphicsConsole console();
    }
    
    /**
     * Add new graphics console to the virtual machine.
     */
    AddRequest add();
    
    /**
     * Lists all the configured graphics consoles of the virtual machine.
     * 
     * IMPORTANT: By default, when the `current` parameter is not specified, the data returned
     * corresponds to the next execution of the virtual machine. In the current implementation of
     * the system this means that the `address` and `port` attributes will not be populated because
     * the system does not know what address and port will be used for the next execution. Since in most
     * cases those attributes are needed, it is strongly advised to aways explicitly include the
     * `current` parameter with the value `true`.
     * 
     * The order of the returned list of graphics consoles is not guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Specifies if the data returned should correspond to the next execution of
         * the virtual machine, or to the current execution.
         * 
         * IMPORTANT: The `address` and `port` attributes will not be populated unless the value is
         * `true`.
         * 
         * For example, to get data for the current execution of the virtual machine, including the
         * `address` and `port` attributes, send a request like this:
         * 
         * [source]
         * ----
         * GET /ovirt-engine/api/vms/123/graphicsconsoles?current=true
         * ----
         * 
         * The default value is `false`.
         */
        ListRequest current(Boolean current);
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
     * Lists all the configured graphics consoles of the virtual machine.
     * 
     * IMPORTANT: By default, when the `current` parameter is not specified, the data returned
     * corresponds to the next execution of the virtual machine. In the current implementation of
     * the system this means that the `address` and `port` attributes will not be populated because
     * the system does not know what address and port will be used for the next execution. Since in most
     * cases those attributes are needed, it is strongly advised to aways explicitly include the
     * `current` parameter with the value `true`.
     * 
     * The order of the returned list of graphics consoles is not guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * The list of graphics consoles of the virtual machine.
         */
        List<GraphicsConsole> consoles();
    }
    
    /**
     * Lists all the configured graphics consoles of the virtual machine.
     * 
     * IMPORTANT: By default, when the `current` parameter is not specified, the data returned
     * corresponds to the next execution of the virtual machine. In the current implementation of
     * the system this means that the `address` and `port` attributes will not be populated because
     * the system does not know what address and port will be used for the next execution. Since in most
     * cases those attributes are needed, it is strongly advised to aways explicitly include the
     * `current` parameter with the value `true`.
     * 
     * The order of the returned list of graphics consoles is not guaranteed.
     */
    ListRequest list();
    
    /**
     * Returns a reference to the service that manages a specific virtual machine graphics console.
     */
    VmGraphicsConsoleService consoleService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

