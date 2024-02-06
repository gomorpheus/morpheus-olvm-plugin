/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.ovirt.api.metamodel.runtime.util.ArrayListWithHref;
import org.ovirt.api.metamodel.runtime.util.ListWithHref;
import org.ovirt.api.metamodel.runtime.xml.XmlReader;
import org.ovirt.engine.sdk4.internal.containers.ActionContainer;
import org.ovirt.engine.sdk4.types.Action;

public class XmlActionReader {
    
    public static Action readOne(XmlReader reader) {
        // Do nothing if there aren't more tags:
        if (!reader.forward()) {
            return null;
        }
        
        // Create the object:
        ActionContainer object = new ActionContainer();
        
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
                case "activate":
                object.activate(reader.readBoolean());
                break;
                case "allow_partial_import":
                object.allowPartialImport(reader.readBoolean());
                break;
                case "async":
                object.async(reader.readBoolean());
                break;
                case "attachment":
                object.attachment(XmlDiskAttachmentReader.readOne(reader));
                break;
                case "authorized_key":
                object.authorizedKey(XmlAuthorizedKeyReader.readOne(reader));
                break;
                case "auto_pinning_policy":
                object.autoPinningPolicy(XmlAutoPinningPolicyReader.readOne(reader));
                break;
                case "bricks":
                object.bricks(XmlGlusterBrickReader.readMany(reader));
                break;
                case "certificates":
                object.certificates(XmlCertificateReader.readMany(reader));
                break;
                case "check_connectivity":
                object.checkConnectivity(reader.readBoolean());
                break;
                case "clone":
                object.clone_(reader.readBoolean());
                break;
                case "clone_permissions":
                object.clonePermissions(reader.readBoolean());
                break;
                case "cluster":
                object.cluster(XmlClusterReader.readOne(reader));
                break;
                case "collapse_snapshots":
                object.collapseSnapshots(reader.readBoolean());
                break;
                case "comment":
                object.comment(reader.readString());
                break;
                case "commit_on_success":
                object.commitOnSuccess(reader.readBoolean());
                break;
                case "connection":
                object.connection(XmlStorageConnectionReader.readOne(reader));
                break;
                case "connectivity_timeout":
                object.connectivityTimeout(reader.readInteger());
                break;
                case "data_center":
                object.dataCenter(XmlDataCenterReader.readOne(reader));
                break;
                case "deploy_hosted_engine":
                object.deployHostedEngine(reader.readBoolean());
                break;
                case "description":
                object.description(reader.readString());
                break;
                case "details":
                object.details(XmlGlusterVolumeProfileDetailsReader.readOne(reader));
                break;
                case "directory":
                object.directory(reader.readString());
                break;
                case "discard_snapshots":
                object.discardSnapshots(reader.readBoolean());
                break;
                case "discovered_targets":
                object.discoveredTargets(XmlIscsiDetailsReader.readMany(reader));
                break;
                case "disk":
                object.disk(XmlDiskReader.readOne(reader));
                break;
                case "disk_profile":
                object.diskProfile(XmlDiskProfileReader.readOne(reader));
                break;
                case "disks":
                object.disks(XmlDiskReader.readMany(reader));
                break;
                case "exclusive":
                object.exclusive(reader.readBoolean());
                break;
                case "fault":
                object.fault(XmlFaultReader.readOne(reader));
                break;
                case "fence_type":
                object.fenceType(reader.readString());
                break;
                case "filename":
                object.filename(reader.readString());
                break;
                case "filter":
                object.filter(reader.readBoolean());
                break;
                case "fix_layout":
                object.fixLayout(reader.readBoolean());
                break;
                case "force":
                object.force(reader.readBoolean());
                break;
                case "grace_period":
                object.gracePeriod(XmlGracePeriodReader.readOne(reader));
                break;
                case "host":
                object.host(XmlHostReader.readOne(reader));
                break;
                case "image":
                object.image(reader.readString());
                break;
                case "image_transfer":
                object.imageTransfer(XmlImageTransferReader.readOne(reader));
                break;
                case "import_as_template":
                object.importAsTemplate(reader.readBoolean());
                break;
                case "is_attached":
                object.isAttached(reader.readBoolean());
                break;
                case "iscsi":
                object.iscsi(XmlIscsiDetailsReader.readOne(reader));
                break;
                case "iscsi_targets":
                object.iscsiTargets(reader.readStrings());
                break;
                case "job":
                object.job(XmlJobReader.readOne(reader));
                break;
                case "lease":
                object.lease(XmlStorageDomainLeaseReader.readOne(reader));
                break;
                case "logical_units":
                object.logicalUnits(XmlLogicalUnitReader.readMany(reader));
                break;
                case "maintenance_after_restart":
                object.maintenanceAfterRestart(reader.readBoolean());
                break;
                case "maintenance_enabled":
                object.maintenanceEnabled(reader.readBoolean());
                break;
                case "migrate_vms_in_affinity_closure":
                object.migrateVmsInAffinityClosure(reader.readBoolean());
                break;
                case "modified_bonds":
                object.modifiedBonds(XmlHostNicReader.readMany(reader));
                break;
                case "modified_labels":
                object.modifiedLabels(XmlNetworkLabelReader.readMany(reader));
                break;
                case "modified_network_attachments":
                object.modifiedNetworkAttachments(XmlNetworkAttachmentReader.readMany(reader));
                break;
                case "name":
                object.name(reader.readString());
                break;
                case "optimize_cpu_settings":
                object.optimizeCpuSettings(reader.readBoolean());
                break;
                case "option":
                object.option(XmlOptionReader.readOne(reader));
                break;
                case "pause":
                object.pause(reader.readBoolean());
                break;
                case "permission":
                object.permission(XmlPermissionReader.readOne(reader));
                break;
                case "power_management":
                object.powerManagement(XmlPowerManagementReader.readOne(reader));
                break;
                case "proxy_ticket":
                object.proxyTicket(XmlProxyTicketReader.readOne(reader));
                break;
                case "quota":
                object.quota(XmlQuotaReader.readOne(reader));
                break;
                case "reason":
                object.reason(reader.readString());
                break;
                case "reassign_bad_macs":
                object.reassignBadMacs(reader.readBoolean());
                break;
                case "reboot":
                object.reboot(reader.readBoolean());
                break;
                case "registration_configuration":
                object.registrationConfiguration(XmlRegistrationConfigurationReader.readOne(reader));
                break;
                case "remote_viewer_connection_file":
                object.remoteViewerConnectionFile(reader.readString());
                break;
                case "removed_bonds":
                object.removedBonds(XmlHostNicReader.readMany(reader));
                break;
                case "removed_labels":
                object.removedLabels(XmlNetworkLabelReader.readMany(reader));
                break;
                case "removed_network_attachments":
                object.removedNetworkAttachments(XmlNetworkAttachmentReader.readMany(reader));
                break;
                case "resolution_type":
                object.resolutionType(reader.readString());
                break;
                case "restore_memory":
                object.restoreMemory(reader.readBoolean());
                break;
                case "root_password":
                object.rootPassword(reader.readString());
                break;
                case "seal":
                object.seal(reader.readBoolean());
                break;
                case "snapshot":
                object.snapshot(XmlSnapshotReader.readOne(reader));
                break;
                case "source_host":
                object.sourceHost(XmlHostReader.readOne(reader));
                break;
                case "ssh":
                object.ssh(XmlSshReader.readOne(reader));
                break;
                case "status":
                object.status(reader.readString());
                break;
                case "stop_gluster_service":
                object.stopGlusterService(reader.readBoolean());
                break;
                case "storage_domain":
                object.storageDomain(XmlStorageDomainReader.readOne(reader));
                break;
                case "storage_domains":
                object.storageDomains(XmlStorageDomainReader.readMany(reader));
                break;
                case "succeeded":
                object.succeeded(reader.readBoolean());
                break;
                case "synchronized_network_attachments":
                object.synchronizedNetworkAttachments(XmlNetworkAttachmentReader.readMany(reader));
                break;
                case "template":
                object.template(XmlTemplateReader.readOne(reader));
                break;
                case "ticket":
                object.ticket(XmlTicketReader.readOne(reader));
                break;
                case "timeout":
                object.timeout(reader.readInteger());
                break;
                case "undeploy_hosted_engine":
                object.undeployHostedEngine(reader.readBoolean());
                break;
                case "upgrade_action":
                object.upgradeAction(XmlClusterUpgradeActionReader.readOne(reader));
                break;
                case "use_cloud_init":
                object.useCloudInit(reader.readBoolean());
                break;
                case "use_ignition":
                object.useIgnition(reader.readBoolean());
                break;
                case "use_initialization":
                object.useInitialization(reader.readBoolean());
                break;
                case "use_sysprep":
                object.useSysprep(reader.readBoolean());
                break;
                case "virtual_functions_configuration":
                object.virtualFunctionsConfiguration(XmlHostNicVirtualFunctionsConfigurationReader.readOne(reader));
                break;
                case "vm":
                object.vm(XmlVmReader.readOne(reader));
                break;
                case "vnic_profile_mappings":
                object.vnicProfileMappings(XmlVnicProfileMappingReader.readMany(reader));
                break;
                case "volatile":
                object.volatile_(reader.readBoolean());
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
    
    public static Iterator<Action> iterateMany(final XmlReader reader) {
        return new Iterator<Action>() {
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
            public Action next() {
                Action next = readOne(reader);
                if (next == null) {
                    throw new NoSuchElementException();
                }
                return next;
            }
        };
    }
    
    public static List<Action> readMany(XmlReader reader) {
        List<Action> list = new ArrayList<>();
        Iterator<Action> iterator = iterateMany(reader);
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    
    private static void processLink(ActionContainer object, String[] link) {
    }
}

