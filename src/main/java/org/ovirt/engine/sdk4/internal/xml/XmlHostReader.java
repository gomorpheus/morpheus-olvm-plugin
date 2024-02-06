/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.util.ArrayListWithHref;
import org.ovirt.api.metamodel.runtime.util.ListWithHref;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.internal.containers.HostContainer;
import org.ovirt.engine.sdk4.types.Host;

public class XmlHostReader {
    
    public static Host readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        HostContainer object = new HostContainer();
        
        // Process the attributes:
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            String name = reader.getAttributeLocalName(i);
            String image = reader.getAttributeValue(i);
            switch (name) {
                case "href":
                object.href(image);
                break;
                case "id":
                object.id(image);
                break;
                default:
                break;
            }
        }
        
        // Process the inner elements:
        List<String[]> links = new ArrayList<>();
        reader.next();
        while (reader.forward()) {
            String name = reader.getLocalName();
            switch (name) {
                case "address":
                object.address(reader.readString());
                break;
                case "affinity_labels":
                object.affinityLabels(XmlAffinityLabelReader.readMany(reader));
                break;
                case "agents":
                object.agents(XmlAgentReader.readMany(reader));
                break;
                case "auto_numa_status":
                object.autoNumaStatus(XmlAutoNumaStatusReader.readOne(reader));
                break;
                case "certificate":
                object.certificate(XmlCertificateReader.readOne(reader));
                break;
                case "cluster":
                object.cluster(XmlClusterReader.readOne(reader));
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "cpu":
                object.cpu(XmlCpuReader.readOne(reader));
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "device_passthrough":
                object.devicePassthrough(XmlHostDevicePassthroughReader.readOne(reader));
                break;
                case "devices":
                object.devices(XmlHostDeviceReader.readMany(reader));
                break;
                case "display":
                object.display(XmlDisplayReader.readOne(reader));
                break;
                case "external_host_provider":
                object.externalHostProvider(XmlExternalHostProviderReader.readOne(reader));
                break;
                case "external_network_provider_configurations":
                object.externalNetworkProviderConfigurations(XmlExternalNetworkProviderConfigurationReader.readMany(reader));
                break;
                case "external_status":
                object.externalStatus(XmlExternalStatusReader.readOne(reader));
                break;
                case "hardware_information":
                object.hardwareInformation(XmlHardwareInformationReader.readOne(reader));
                break;
                case "hooks":
                object.hooks(XmlHookReader.readMany(reader));
                break;
                case "hosted_engine":
                object.hostedEngine(XmlHostedEngineReader.readOne(reader));
                break;
                case "iscsi":
                object.iscsi(XmlIscsiDetailsReader.readOne(reader));
                break;
                case "katello_errata":
                object.katelloErrata(XmlKatelloErratumReader.readMany(reader));
                break;
                case "kdump_status":
                object.kdumpStatus(XmlKdumpStatusReader.readOne(reader));
                break;
                case "ksm":
                object.ksm(XmlKsmReader.readOne(reader));
                break;
                case "libvirt_version":
                object.libvirtVersion(XmlVersionReader.readOne(reader));
                break;
                case "max_scheduling_memory":
                object.maxSchedulingMemory(reader.readInteger());
                break;
                case "memory":
                object.memory(reader.readInteger());
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "network_attachments":
                object.networkAttachments(XmlNetworkAttachmentReader.readMany(reader));
                break;
                case "network_operation_in_progress":
                object.networkOperationInProgress(reader.readBoolean());
                break;
                case "nics":
                object.nics(XmlHostNicReader.readMany(reader));
                break;
                case "host_numa_nodes":
                object.numaNodes(XmlNumaNodeReader.readMany(reader));
                break;
                case "numa_supported":
                object.numaSupported(reader.readBoolean());
                break;
                case "os":
                object.os(XmlOperatingSystemReader.readOne(reader));
                break;
                case "override_iptables":
                object.overrideIptables(reader.readBoolean());
                break;
                case "ovn_configured":
                object.ovnConfigured(reader.readBoolean());
                break;
                case "permissions":
                object.permissions(XmlPermissionReader.readMany(reader));
                break;
                case "port":
                object.port(reader.readInteger());
                break;
                case "power_management":
                object.powerManagement(XmlPowerManagementReader.readOne(reader));
                break;
                case "protocol":
                object.protocol(XmlHostProtocolReader.readOne(reader));
                break;
                case "reinstallation_required":
                object.reinstallationRequired(reader.readBoolean());
                break;
                case "root_password":
                object.rootPassword(reader.readString());
                break;
                case "se_linux":
                object.seLinux(XmlSeLinuxReader.readOne(reader));
                break;
                case "spm":
                object.spm(XmlSpmReader.readOne(reader));
                break;
                case "ssh":
                object.ssh(XmlSshReader.readOne(reader));
                break;
                case "statistics":
                object.statistics(XmlStatisticReader.readMany(reader));
                break;
                case "status":
                object.status(XmlHostStatusReader.readOne(reader));
                break;
                case "status_detail":
                object.statusDetail(reader.readString());
                break;
                case "storage_connection_extensions":
                object.storageConnectionExtensions(XmlStorageConnectionExtensionReader.readMany(reader));
                break;
                case "storages":
                object.storages(XmlHostStorageReader.readMany(reader));
                break;
                case "summary":
                object.summary(XmlVmSummaryReader.readOne(reader));
                break;
                case "tags":
                object.tags(XmlTagReader.readMany(reader));
                break;
                case "transparent_hugepages":
                object.transparentHugePages(XmlTransparentHugePagesReader.readOne(reader));
                break;
                case "type":
                object.type(XmlHostTypeReader.readOne(reader));
                break;
                case "unmanaged_networks":
                object.unmanagedNetworks(XmlUnmanagedNetworkReader.readMany(reader));
                break;
                case "update_available":
                object.updateAvailable(reader.readBoolean());
                break;
                case "version":
                object.version(XmlVersionReader.readOne(reader));
                break;
                case "vgpu_placement":
                object.vgpuPlacement(XmlVgpuPlacementReader.readOne(reader));
                break;
                case "link":
                // Process the attributes:
                String rel = reader.getAttributeValue("rel");
                String href = reader.getAttributeValue("href");
                if (rel != null && href != null) {
                    links.add(new String[]{rel, href});
                }
                reader.skip();
                break;
                default:
                reader.skip();
                break;
            }
        }
        if (links != null) {
            for (String[] link : links) {
                processLink(object, link);
            }
        }
        
        // Discard the end tag:
        reader.next();
        
        return object;
    }
    
    public static Iterator<Host> iterateMany(final XmlReader reader) {
        return new Iterator<Host>() {
            private boolean first = true;
            
            @Override
            public void remove() {
                // Empty on purpose
            }
            
            @Override
            public boolean hasNext() {
                if (first) {
                    if (!reader.forward()) {
                        return false;
                    }
                    reader.next();
                    first = false;
                }
                if (!reader.forward()) {
                    reader.next();
                    return false;
                }
                return true;
            }
            
            @Override
            public Host next() {
                Host next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Host> readMany(XmlReader reader) {
        List<Host> list = new ArrayList<>();
        Iterator<Host> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(HostContainer object, String[] link) {
        // Process the attributes:
        ListWithHref list;
        String rel = link[0];
        String href = link[1];
        if (href != null) {
            switch (rel) {
                case "affinitylabels":
                list = new ArrayListWithHref(object.affinityLabels());
                list.href(href);
                object.affinityLabels(list);
                break;
                case "agents":
                list = new ArrayListWithHref(object.agents());
                list.href(href);
                object.agents(list);
                break;
                case "devices":
                list = new ArrayListWithHref(object.devices());
                list.href(href);
                object.devices(list);
                break;
                case "externalnetworkproviderconfigurations":
                list = new ArrayListWithHref(object.externalNetworkProviderConfigurations());
                list.href(href);
                object.externalNetworkProviderConfigurations(list);
                break;
                case "hooks":
                list = new ArrayListWithHref(object.hooks());
                list.href(href);
                object.hooks(list);
                break;
                case "katelloerrata":
                list = new ArrayListWithHref(object.katelloErrata());
                list.href(href);
                object.katelloErrata(list);
                break;
                case "networkattachments":
                list = new ArrayListWithHref(object.networkAttachments());
                list.href(href);
                object.networkAttachments(list);
                break;
                case "nics":
                list = new ArrayListWithHref(object.nics());
                list.href(href);
                object.nics(list);
                break;
                case "numanodes":
                list = new ArrayListWithHref(object.numaNodes());
                list.href(href);
                object.numaNodes(list);
                break;
                case "permissions":
                list = new ArrayListWithHref(object.permissions());
                list.href(href);
                object.permissions(list);
                break;
                case "statistics":
                list = new ArrayListWithHref(object.statistics());
                list.href(href);
                object.statistics(list);
                break;
                case "storageconnectionextensions":
                list = new ArrayListWithHref(object.storageConnectionExtensions());
                list.href(href);
                object.storageConnectionExtensions(list);
                break;
                case "storages":
                list = new ArrayListWithHref(object.storages());
                list.href(href);
                object.storages(list);
                break;
                case "tags":
                list = new ArrayListWithHref(object.tags());
                list.href(href);
                object.tags(list);
                break;
                case "unmanagednetworks":
                list = new ArrayListWithHref(object.unmanagedNetworks());
                list.href(href);
                object.unmanagedNetworks(list);
                break;
                default:
                break;
            }
        }
    }
}

