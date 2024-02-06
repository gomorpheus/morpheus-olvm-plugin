/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.lang.String;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.TicketBuilder;
import org.ovirt.engine.sdk4.types.GraphicsConsole;
import org.ovirt.engine.sdk4.types.ProxyTicket;
import org.ovirt.engine.sdk4.types.Ticket;

public interface VmGraphicsConsoleService extends Service {
    /**
     * Retrieves the graphics console configuration of the virtual machine.
     * 
     * IMPORTANT: By default, when the `current` parameter is not specified, the data returned
     * corresponds to the next execution of the virtual machine. In the current implementation of
     * the system this means that the `address` and `port` attributes will not be populated because
     * the system does not know what address and port will be used for the next execution. Since in most
     * cases those attributes are needed, it is strongly advised to aways explicitly include the
     * `current` parameter with the value `true`.
     */
    public interface GetRequest extends Request<GetRequest, GetResponse> {
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
         * GET /ovit-engine/api/vms/123/graphicsconsoles/456?current=true
         * ----
         * 
         * The default value is `false`.
         */
        GetRequest current(Boolean current);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
    }
    
    /**
     * Retrieves the graphics console configuration of the virtual machine.
     * 
     * IMPORTANT: By default, when the `current` parameter is not specified, the data returned
     * corresponds to the next execution of the virtual machine. In the current implementation of
     * the system this means that the `address` and `port` attributes will not be populated because
     * the system does not know what address and port will be used for the next execution. Since in most
     * cases those attributes are needed, it is strongly advised to aways explicitly include the
     * `current` parameter with the value `true`.
     */
    public interface GetResponse extends Response {
        /**
         * The information about the graphics console of the virtual machine.
         */
        GraphicsConsole console();
    }
    
    /**
     * Retrieves the graphics console configuration of the virtual machine.
     * 
     * IMPORTANT: By default, when the `current` parameter is not specified, the data returned
     * corresponds to the next execution of the virtual machine. In the current implementation of
     * the system this means that the `address` and `port` attributes will not be populated because
     * the system does not know what address and port will be used for the next execution. Since in most
     * cases those attributes are needed, it is strongly advised to aways explicitly include the
     * `current` parameter with the value `true`.
     */
    GetRequest get();
    
    public interface ProxyTicketRequest extends Request<ProxyTicketRequest, ProxyTicketResponse> {
        /**
         * Indicates if the generation of the ticket should be performed asynchronously.
         */
        ProxyTicketRequest async(Boolean async);
    }
    
    public interface ProxyTicketResponse extends Response {
        ProxyTicket proxyTicket();
    }
    
    ProxyTicketRequest proxyTicket();
    
    /**
     * Generates the file which is compatible with `remote-viewer` client.
     * 
     * Use the following request to generate remote viewer connection file of the graphics console.
     * Note that this action generates the file only if virtual machine is running.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/graphicsconsoles/456/remoteviewerconnectionfile
     * ----
     * 
     * The `remoteviewerconnectionfile` action does not take any action specific parameters,
     * so the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * The response contains the file, which can be used with `remote-viewer` client.
     * 
     * [source,xml]
     * ----
     * <action>
     *   <remote_viewer_connection_file>
     *     [virt-viewer]
     *     type=spice
     *     host=192.168.1.101
     *     port=-1
     *     password=123456789
     *     delete-this-file=1
     *     fullscreen=0
     *     toggle-fullscreen=shift+f11
     *     release-cursor=shift+f12
     *     secure-attention=ctrl+alt+end
     *     tls-port=5900
     *     enable-smartcard=0
     *     enable-usb-autoshare=0
     *     usb-filter=null
     *     tls-ciphers=DEFAULT
     *     host-subject=O=local,CN=example.com
     *     ca=...
     *   </remote_viewer_connection_file>
     * </action>
     * ----
     * 
     * E.g., to fetch the content of remote viewer connection file and save it into temporary file, user can use
     * oVirt Python SDK as follows:
     * 
     * [source,python]
     * ----
     * # Find the virtual machine:
     * vm = vms_service.list(search='name=myvm')[0]
     * 
     * # Locate the service that manages the virtual machine, as that is where
     * # the locators are defined:
     * vm_service = vms_service.vm_service(vm.id)
     * 
     * # Find the graphic console of the virtual machine:
     * graphics_consoles_service = vm_service.graphics_consoles_service()
     * graphics_console = graphics_consoles_service.list()[0]
     * 
     * # Generate the remote viewer connection file:
     * console_service = graphics_consoles_service.console_service(graphics_console.id)
     * remote_viewer_connection_file = console_service.remote_viewer_connection_file()
     * 
     * # Write the content to file "/tmp/remote_viewer_connection_file.vv"
     * path = "/tmp/remote_viewer_connection_file.vv"
     * with open(path, "w") as f:
     *     f.write(remote_viewer_connection_file)
     * ----
     * 
     * When you create the remote viewer connection file, then you can connect to virtual machine graphic console,
     * as follows:
     * 
     * [source,bash]
     * ----
     * #!/bin/sh -ex
     * 
     * remote-viewer --ovirt-ca-file=/etc/pki/ovirt-engine/ca.pem /tmp/remote_viewer_connection_file.vv
     * ----
     */
    public interface RemoteViewerConnectionFileRequest extends Request<RemoteViewerConnectionFileRequest, RemoteViewerConnectionFileResponse> {
    }
    
    /**
     * Generates the file which is compatible with `remote-viewer` client.
     * 
     * Use the following request to generate remote viewer connection file of the graphics console.
     * Note that this action generates the file only if virtual machine is running.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/graphicsconsoles/456/remoteviewerconnectionfile
     * ----
     * 
     * The `remoteviewerconnectionfile` action does not take any action specific parameters,
     * so the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * The response contains the file, which can be used with `remote-viewer` client.
     * 
     * [source,xml]
     * ----
     * <action>
     *   <remote_viewer_connection_file>
     *     [virt-viewer]
     *     type=spice
     *     host=192.168.1.101
     *     port=-1
     *     password=123456789
     *     delete-this-file=1
     *     fullscreen=0
     *     toggle-fullscreen=shift+f11
     *     release-cursor=shift+f12
     *     secure-attention=ctrl+alt+end
     *     tls-port=5900
     *     enable-smartcard=0
     *     enable-usb-autoshare=0
     *     usb-filter=null
     *     tls-ciphers=DEFAULT
     *     host-subject=O=local,CN=example.com
     *     ca=...
     *   </remote_viewer_connection_file>
     * </action>
     * ----
     * 
     * E.g., to fetch the content of remote viewer connection file and save it into temporary file, user can use
     * oVirt Python SDK as follows:
     * 
     * [source,python]
     * ----
     * # Find the virtual machine:
     * vm = vms_service.list(search='name=myvm')[0]
     * 
     * # Locate the service that manages the virtual machine, as that is where
     * # the locators are defined:
     * vm_service = vms_service.vm_service(vm.id)
     * 
     * # Find the graphic console of the virtual machine:
     * graphics_consoles_service = vm_service.graphics_consoles_service()
     * graphics_console = graphics_consoles_service.list()[0]
     * 
     * # Generate the remote viewer connection file:
     * console_service = graphics_consoles_service.console_service(graphics_console.id)
     * remote_viewer_connection_file = console_service.remote_viewer_connection_file()
     * 
     * # Write the content to file "/tmp/remote_viewer_connection_file.vv"
     * path = "/tmp/remote_viewer_connection_file.vv"
     * with open(path, "w") as f:
     *     f.write(remote_viewer_connection_file)
     * ----
     * 
     * When you create the remote viewer connection file, then you can connect to virtual machine graphic console,
     * as follows:
     * 
     * [source,bash]
     * ----
     * #!/bin/sh -ex
     * 
     * remote-viewer --ovirt-ca-file=/etc/pki/ovirt-engine/ca.pem /tmp/remote_viewer_connection_file.vv
     * ----
     */
    public interface RemoteViewerConnectionFileResponse extends Response {
        /**
         * Contains the file which is compatible with `remote-viewer` client.
         * 
         * User can use the content of this attribute to create a file, which can be passed to `remote-viewer` client to
         * connect to virtual machine graphic console.
         */
        String remoteViewerConnectionFile();
    }
    
    /**
     * Generates the file which is compatible with `remote-viewer` client.
     * 
     * Use the following request to generate remote viewer connection file of the graphics console.
     * Note that this action generates the file only if virtual machine is running.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/graphicsconsoles/456/remoteviewerconnectionfile
     * ----
     * 
     * The `remoteviewerconnectionfile` action does not take any action specific parameters,
     * so the request body should contain an empty `action`:
     * 
     * [source,xml]
     * ----
     * <action/>
     * ----
     * 
     * The response contains the file, which can be used with `remote-viewer` client.
     * 
     * [source,xml]
     * ----
     * <action>
     *   <remote_viewer_connection_file>
     *     [virt-viewer]
     *     type=spice
     *     host=192.168.1.101
     *     port=-1
     *     password=123456789
     *     delete-this-file=1
     *     fullscreen=0
     *     toggle-fullscreen=shift+f11
     *     release-cursor=shift+f12
     *     secure-attention=ctrl+alt+end
     *     tls-port=5900
     *     enable-smartcard=0
     *     enable-usb-autoshare=0
     *     usb-filter=null
     *     tls-ciphers=DEFAULT
     *     host-subject=O=local,CN=example.com
     *     ca=...
     *   </remote_viewer_connection_file>
     * </action>
     * ----
     * 
     * E.g., to fetch the content of remote viewer connection file and save it into temporary file, user can use
     * oVirt Python SDK as follows:
     * 
     * [source,python]
     * ----
     * # Find the virtual machine:
     * vm = vms_service.list(search='name=myvm')[0]
     * 
     * # Locate the service that manages the virtual machine, as that is where
     * # the locators are defined:
     * vm_service = vms_service.vm_service(vm.id)
     * 
     * # Find the graphic console of the virtual machine:
     * graphics_consoles_service = vm_service.graphics_consoles_service()
     * graphics_console = graphics_consoles_service.list()[0]
     * 
     * # Generate the remote viewer connection file:
     * console_service = graphics_consoles_service.console_service(graphics_console.id)
     * remote_viewer_connection_file = console_service.remote_viewer_connection_file()
     * 
     * # Write the content to file "/tmp/remote_viewer_connection_file.vv"
     * path = "/tmp/remote_viewer_connection_file.vv"
     * with open(path, "w") as f:
     *     f.write(remote_viewer_connection_file)
     * ----
     * 
     * When you create the remote viewer connection file, then you can connect to virtual machine graphic console,
     * as follows:
     * 
     * [source,bash]
     * ----
     * #!/bin/sh -ex
     * 
     * remote-viewer --ovirt-ca-file=/etc/pki/ovirt-engine/ca.pem /tmp/remote_viewer_connection_file.vv
     * ----
     */
    RemoteViewerConnectionFileRequest remoteViewerConnectionFile();
    
    /**
     * Remove the graphics console from the virtual machine.
     */
    public interface RemoveRequest extends Request<RemoveRequest, RemoveResponse> {
        /**
         * Indicates if the remove should be performed asynchronously.
         */
        RemoveRequest async(Boolean async);
    }
    
    /**
     * Remove the graphics console from the virtual machine.
     */
    public interface RemoveResponse extends Response {
    }
    
    /**
     * Remove the graphics console from the virtual machine.
     */
    RemoveRequest remove();
    
    /**
     * Generates a time-sensitive authentication token for accessing this virtual machine's console.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/graphicsconsoles/456/ticket
     * ----
     * 
     * The client-provided action optionally includes a desired ticket value and/or an expiry time in seconds.
     * 
     * In any case, the response specifies the actual ticket value and expiry used.
     * 
     * [source,xml]
     * ----
     * <action>
     *   <ticket>
     *     <value>abcd12345</value>
     *     <expiry>120</expiry>
     *   </ticket>
     * </action>
     * ----
     */
    public interface TicketRequest extends Request<TicketRequest, TicketResponse> {
        TicketRequest ticket(Ticket ticket);
        /**
         * The generated ticket that can be used to access this console.
         */
        TicketRequest ticket(TicketBuilder ticket);
    }
    
    /**
     * Generates a time-sensitive authentication token for accessing this virtual machine's console.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/graphicsconsoles/456/ticket
     * ----
     * 
     * The client-provided action optionally includes a desired ticket value and/or an expiry time in seconds.
     * 
     * In any case, the response specifies the actual ticket value and expiry used.
     * 
     * [source,xml]
     * ----
     * <action>
     *   <ticket>
     *     <value>abcd12345</value>
     *     <expiry>120</expiry>
     *   </ticket>
     * </action>
     * ----
     */
    public interface TicketResponse extends Response {
        /**
         * The generated ticket that can be used to access this console.
         */
        Ticket ticket();
    }
    
    /**
     * Generates a time-sensitive authentication token for accessing this virtual machine's console.
     * 
     * [source]
     * ----
     * POST /ovirt-engine/api/vms/123/graphicsconsoles/456/ticket
     * ----
     * 
     * The client-provided action optionally includes a desired ticket value and/or an expiry time in seconds.
     * 
     * In any case, the response specifies the actual ticket value and expiry used.
     * 
     * [source,xml]
     * ----
     * <action>
     *   <ticket>
     *     <value>abcd12345</value>
     *     <expiry>120</expiry>
     *   </ticket>
     * </action>
     * ----
     */
    TicketRequest ticket();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

