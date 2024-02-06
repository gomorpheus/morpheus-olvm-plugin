/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.NetworkAttachmentContainer;
import org.ovirt.engine.sdk4.types.DnsResolverConfiguration;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostNic;
import org.ovirt.engine.sdk4.types.IpAddressAssignment;
import org.ovirt.engine.sdk4.types.Network;
import org.ovirt.engine.sdk4.types.NetworkAttachment;
import org.ovirt.engine.sdk4.types.Property;
import org.ovirt.engine.sdk4.types.Qos;
import org.ovirt.engine.sdk4.types.ReportedConfiguration;

public class NetworkAttachmentBuilder {
    private String comment;
    private String description;
    private DnsResolverConfiguration dnsResolverConfiguration;
    private Host host;
    private HostNic hostNic;
    private String href;
    private String id;
    private Boolean inSync;
    private List<IpAddressAssignment> ipAddressAssignments;
    private String name;
    private Network network;
    private List<Property> properties;
    private Qos qos;
    private List<ReportedConfiguration> reportedConfigurations;
    
    public NetworkAttachmentBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public NetworkAttachmentBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public NetworkAttachmentBuilder dnsResolverConfiguration(DnsResolverConfiguration newDnsResolverConfiguration) {
        dnsResolverConfiguration = newDnsResolverConfiguration;
        return this;
    }
    
    public NetworkAttachmentBuilder dnsResolverConfiguration(DnsResolverConfigurationBuilder newDnsResolverConfiguration) {
        if (newDnsResolverConfiguration == null) {
            dnsResolverConfiguration = null;
        }
        else {
            dnsResolverConfiguration = newDnsResolverConfiguration.build();
        }
        return this;
    }
    
    
    public NetworkAttachmentBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public NetworkAttachmentBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public NetworkAttachmentBuilder hostNic(HostNic newHostNic) {
        hostNic = newHostNic;
        return this;
    }
    
    public NetworkAttachmentBuilder hostNic(HostNicBuilder newHostNic) {
        if (newHostNic == null) {
            hostNic = null;
        }
        else {
            hostNic = newHostNic.build();
        }
        return this;
    }
    
    
    public NetworkAttachmentBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public NetworkAttachmentBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public NetworkAttachmentBuilder inSync(boolean newInSync) {
        inSync = Boolean.valueOf(newInSync);
        return this;
    }
    
    public NetworkAttachmentBuilder inSync(Boolean newInSync) {
        inSync = newInSync;
        return this;
    }
    
    
    public NetworkAttachmentBuilder ipAddressAssignments(List<IpAddressAssignment> newIpAddressAssignments) {
        if (newIpAddressAssignments != null) {
            if (ipAddressAssignments == null) {
                ipAddressAssignments = new ArrayList<>(newIpAddressAssignments);
            }
            else {
                ipAddressAssignments.addAll(newIpAddressAssignments);
            }
        }
        return this;
    }
    
    public NetworkAttachmentBuilder ipAddressAssignments(IpAddressAssignment... newIpAddressAssignments) {
        if (newIpAddressAssignments != null) {
            if (ipAddressAssignments == null) {
                ipAddressAssignments = new ArrayList<>(newIpAddressAssignments.length);
            }
            Collections.addAll(ipAddressAssignments, newIpAddressAssignments);
        }
        return this;
    }
    
    public NetworkAttachmentBuilder ipAddressAssignments(IpAddressAssignmentBuilder... newIpAddressAssignments) {
        if (newIpAddressAssignments != null) {
            if (ipAddressAssignments == null) {
                ipAddressAssignments = new ArrayList<>(newIpAddressAssignments.length);
            }
            for (IpAddressAssignmentBuilder builder : newIpAddressAssignments) {
                ipAddressAssignments.add(builder.build());
            }
        }
        return this;
    }
    
    
    public NetworkAttachmentBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public NetworkAttachmentBuilder network(Network newNetwork) {
        network = newNetwork;
        return this;
    }
    
    public NetworkAttachmentBuilder network(NetworkBuilder newNetwork) {
        if (newNetwork == null) {
            network = null;
        }
        else {
            network = newNetwork.build();
        }
        return this;
    }
    
    
    public NetworkAttachmentBuilder properties(List<Property> newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties);
            }
            else {
                properties.addAll(newProperties);
            }
        }
        return this;
    }
    
    public NetworkAttachmentBuilder properties(Property... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            Collections.addAll(properties, newProperties);
        }
        return this;
    }
    
    public NetworkAttachmentBuilder properties(PropertyBuilder... newProperties) {
        if (newProperties != null) {
            if (properties == null) {
                properties = new ArrayList<>(newProperties.length);
            }
            for (PropertyBuilder builder : newProperties) {
                properties.add(builder.build());
            }
        }
        return this;
    }
    
    
    public NetworkAttachmentBuilder qos(Qos newQos) {
        qos = newQos;
        return this;
    }
    
    public NetworkAttachmentBuilder qos(QosBuilder newQos) {
        if (newQos == null) {
            qos = null;
        }
        else {
            qos = newQos.build();
        }
        return this;
    }
    
    
    public NetworkAttachmentBuilder reportedConfigurations(List<ReportedConfiguration> newReportedConfigurations) {
        if (newReportedConfigurations != null) {
            if (reportedConfigurations == null) {
                reportedConfigurations = new ArrayList<>(newReportedConfigurations);
            }
            else {
                reportedConfigurations.addAll(newReportedConfigurations);
            }
        }
        return this;
    }
    
    public NetworkAttachmentBuilder reportedConfigurations(ReportedConfiguration... newReportedConfigurations) {
        if (newReportedConfigurations != null) {
            if (reportedConfigurations == null) {
                reportedConfigurations = new ArrayList<>(newReportedConfigurations.length);
            }
            Collections.addAll(reportedConfigurations, newReportedConfigurations);
        }
        return this;
    }
    
    public NetworkAttachmentBuilder reportedConfigurations(ReportedConfigurationBuilder... newReportedConfigurations) {
        if (newReportedConfigurations != null) {
            if (reportedConfigurations == null) {
                reportedConfigurations = new ArrayList<>(newReportedConfigurations.length);
            }
            for (ReportedConfigurationBuilder builder : newReportedConfigurations) {
                reportedConfigurations.add(builder.build());
            }
        }
        return this;
    }
    
    
    public NetworkAttachment build() {
        NetworkAttachmentContainer container = new NetworkAttachmentContainer();
        container.comment(comment);
        container.description(description);
        container.dnsResolverConfiguration(dnsResolverConfiguration);
        container.host(host);
        container.hostNic(hostNic);
        container.href(href);
        container.id(id);
        container.inSync(inSync);
        container.ipAddressAssignments(ipAddressAssignments);
        container.name(name);
        container.network(network);
        container.properties(properties);
        container.qos(qos);
        container.reportedConfigurations(reportedConfigurations);
        return container;
    }
}
