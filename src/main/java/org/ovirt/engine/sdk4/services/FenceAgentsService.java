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
import org.ovirt.engine.sdk4.builders.AgentBuilder;
import org.ovirt.engine.sdk4.types.Agent;

/**
 * A service to manage fence agents for a specific host.
 */
public interface FenceAgentsService extends Service {
    /**
     * Add a new fencing-agent to the host.
     * 
     * [source]
     * 
     * ----
     * POST /ovirt-engine/api/hosts/123/fenceagents
     * 
     * You should consult the /usr/sbin/fence_<agent_name> manual page for
     * the legal parameters to [name1=value1, name2=value2,...] in the options field.
     * If any parameter in options appears by name that means that it is mandatory.
     * For example in <options>slot=7[,name1=value1, name2=value2,...]</options>
     * slot is mandatory.
     * ----
     * 
     * apc, bladecenter, wti fencing agent/s sample request:
     * 
     * [source,xml]
     * 
     *   <agent>
     *     <type>apc</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <port>9</port>
     *     <options>slot=7[,name1=value1, name2=value2,...]</options>
     *   </agent>
     * 
     * apc_snmp, hpblade, ilo, ilo2, ilo_ssh, redfish, rsa fencing agent/s sample request:
     * 
     * [source,xml]
     * 
     *   <agent>
     *     <type>apc_snmp</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <port>9</port>
     *     <options>[name1=value1, name2=value2,...]</options>
     *   </agent>
     * 
     * 
     * cisco_ucs, drac5, eps fencing agent/s sample request:
     * 
     * [source,xml]
     * 
     *   <agent>
     *     <type>cisco_ucs</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <options>slot=7[,name1=value1, name2=value2,...]</options>
     *   </agent>
     * 
     * drac7, ilo3, ilo4, ipmilan, rsb fencing agent/s sample request:
     * 
     * [source,xml]
     * 
     *   <agent>
     *     <type>drac7</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <options>[name1=value1, name2=value2,...]</options>
     *   </agent>
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest agent(Agent agent);
        AddRequest agent(AgentBuilder agent);
    }
    
    /**
     * Add a new fencing-agent to the host.
     * 
     * [source]
     * 
     * ----
     * POST /ovirt-engine/api/hosts/123/fenceagents
     * 
     * You should consult the /usr/sbin/fence_<agent_name> manual page for
     * the legal parameters to [name1=value1, name2=value2,...] in the options field.
     * If any parameter in options appears by name that means that it is mandatory.
     * For example in <options>slot=7[,name1=value1, name2=value2,...]</options>
     * slot is mandatory.
     * ----
     * 
     * apc, bladecenter, wti fencing agent/s sample request:
     * 
     * [source,xml]
     * 
     *   <agent>
     *     <type>apc</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <port>9</port>
     *     <options>slot=7[,name1=value1, name2=value2,...]</options>
     *   </agent>
     * 
     * apc_snmp, hpblade, ilo, ilo2, ilo_ssh, redfish, rsa fencing agent/s sample request:
     * 
     * [source,xml]
     * 
     *   <agent>
     *     <type>apc_snmp</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <port>9</port>
     *     <options>[name1=value1, name2=value2,...]</options>
     *   </agent>
     * 
     * 
     * cisco_ucs, drac5, eps fencing agent/s sample request:
     * 
     * [source,xml]
     * 
     *   <agent>
     *     <type>cisco_ucs</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <options>slot=7[,name1=value1, name2=value2,...]</options>
     *   </agent>
     * 
     * drac7, ilo3, ilo4, ipmilan, rsb fencing agent/s sample request:
     * 
     * [source,xml]
     * 
     *   <agent>
     *     <type>drac7</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <options>[name1=value1, name2=value2,...]</options>
     *   </agent>
     */
    public interface AddResponse extends Response {
        Agent agent();
    }
    
    /**
     * Add a new fencing-agent to the host.
     * 
     * [source]
     * 
     * ----
     * POST /ovirt-engine/api/hosts/123/fenceagents
     * 
     * You should consult the /usr/sbin/fence_<agent_name> manual page for
     * the legal parameters to [name1=value1, name2=value2,...] in the options field.
     * If any parameter in options appears by name that means that it is mandatory.
     * For example in <options>slot=7[,name1=value1, name2=value2,...]</options>
     * slot is mandatory.
     * ----
     * 
     * apc, bladecenter, wti fencing agent/s sample request:
     * 
     * [source,xml]
     * 
     *   <agent>
     *     <type>apc</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <port>9</port>
     *     <options>slot=7[,name1=value1, name2=value2,...]</options>
     *   </agent>
     * 
     * apc_snmp, hpblade, ilo, ilo2, ilo_ssh, redfish, rsa fencing agent/s sample request:
     * 
     * [source,xml]
     * 
     *   <agent>
     *     <type>apc_snmp</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <port>9</port>
     *     <options>[name1=value1, name2=value2,...]</options>
     *   </agent>
     * 
     * 
     * cisco_ucs, drac5, eps fencing agent/s sample request:
     * 
     * [source,xml]
     * 
     *   <agent>
     *     <type>cisco_ucs</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <options>slot=7[,name1=value1, name2=value2,...]</options>
     *   </agent>
     * 
     * drac7, ilo3, ilo4, ipmilan, rsb fencing agent/s sample request:
     * 
     * [source,xml]
     * 
     *   <agent>
     *     <type>drac7</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <options>[name1=value1, name2=value2,...]</options>
     *   </agent>
     */
    AddRequest add();
    
    /**
     * Returns the list of fencing agents configured for the host.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123/fenceagents
     * ----
     * 
     * And here is sample response:
     * 
     * [source,xml]
     * ----
     * <agents>
     *   <agent id="0">
     *     <type>apc</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <port>9</port>
     *     <options>name1=value1, name2=value2</options>
     *   </agent>
     * </agents>
     * ----
     * 
     * The order of the returned list of fencing agents isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of agents to return. If not specified all the agents are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of agents to return. If not specified all the agents are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of agents to return. If not specified all the agents are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of fencing agents configured for the host.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123/fenceagents
     * ----
     * 
     * And here is sample response:
     * 
     * [source,xml]
     * ----
     * <agents>
     *   <agent id="0">
     *     <type>apc</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <port>9</port>
     *     <options>name1=value1, name2=value2</options>
     *   </agent>
     * </agents>
     * ----
     * 
     * The order of the returned list of fencing agents isn't guaranteed.
     */
    public interface ListResponse extends Response {
        /**
         * List of fence agent details.
         */
        List<Agent> agents();
    }
    
    /**
     * Returns the list of fencing agents configured for the host.
     * 
     * [source]
     * ----
     * GET /ovirt-engine/api/hosts/123/fenceagents
     * ----
     * 
     * And here is sample response:
     * 
     * [source,xml]
     * ----
     * <agents>
     *   <agent id="0">
     *     <type>apc</type>
     *     <order>1</order>
     *     <ip>192.168.1.101</ip>
     *     <user>user</user>
     *     <password>xxx</password>
     *     <port>9</port>
     *     <options>name1=value1, name2=value2</options>
     *   </agent>
     * </agents>
     * ----
     * 
     * The order of the returned list of fencing agents isn't guaranteed.
     */
    ListRequest list();
    
    /**
     * Reference to service that manages a specific fence agent
     * for this host.
     */
    FenceAgentService agentService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

