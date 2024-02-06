/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.xml;

import java.util.Iterator;
import org.ovirt.api.metamodel.runtime.xml.XmlWriter;
import org.ovirt.engine.sdk4.types.Action;

public class XmlActionWriter {
    
    public static void writeOne(Action object, XmlWriter writer) {
        writeOne(object, "action", writer);
    }
    
    public static void writeOne(Action object, String tag, XmlWriter writer) {
        writer.writeStartElement(tag);
        if (object.hrefPresent()) {
            writer.writeAttribute("href", object.href());
        }
        if (object.idPresent()) {
            writer.writeAttribute("id", object.id());
        }
        if (object.activatePresent()) {
            writer.writeBoolean("activate", object.activate());
        }
        if (object.allowPartialImportPresent()) {
            writer.writeBoolean("allow_partial_import", object.allowPartialImport());
        }
        if (object.asyncPresent()) {
            writer.writeBoolean("async", object.async());
        }
        if (object.attachmentPresent()) {
            XmlDiskAttachmentWriter.writeOne(object.attachment(), "attachment", writer);
        }
        if (object.authorizedKeyPresent()) {
            XmlAuthorizedKeyWriter.writeOne(object.authorizedKey(), "authorized_key", writer);
        }
        if (object.autoPinningPolicyPresent()) {
            XmlAutoPinningPolicyWriter.writeOne(object.autoPinningPolicy(), "auto_pinning_policy", writer);
        }
        if (object.bricksPresent()) {
            XmlGlusterBrickWriter.writeMany(object.bricks().iterator(), "brick", "bricks", writer);
        }
        if (object.certificatesPresent()) {
            XmlCertificateWriter.writeMany(object.certificates().iterator(), "certificate", "certificates", writer);
        }
        if (object.checkConnectivityPresent()) {
            writer.writeBoolean("check_connectivity", object.checkConnectivity());
        }
        if (object.clone_Present()) {
            writer.writeBoolean("clone", object.clone_());
        }
        if (object.clonePermissionsPresent()) {
            writer.writeBoolean("clone_permissions", object.clonePermissions());
        }
        if (object.clusterPresent()) {
            XmlClusterWriter.writeOne(object.cluster(), "cluster", writer);
        }
        if (object.collapseSnapshotsPresent()) {
            writer.writeBoolean("collapse_snapshots", object.collapseSnapshots());
        }
        if (object.commentPresent()) {
            writer.writeElement("comment", object.comment());
        }
        if (object.commitOnSuccessPresent()) {
            writer.writeBoolean("commit_on_success", object.commitOnSuccess());
        }
        if (object.connectionPresent()) {
            XmlStorageConnectionWriter.writeOne(object.connection(), "connection", writer);
        }
        if (object.connectivityTimeoutPresent()) {
            writer.writeInteger("connectivity_timeout", object.connectivityTimeout());
        }
        if (object.dataCenterPresent()) {
            XmlDataCenterWriter.writeOne(object.dataCenter(), "data_center", writer);
        }
        if (object.deployHostedEnginePresent()) {
            writer.writeBoolean("deploy_hosted_engine", object.deployHostedEngine());
        }
        if (object.descriptionPresent()) {
            writer.writeElement("description", object.description());
        }
        if (object.detailsPresent()) {
            XmlGlusterVolumeProfileDetailsWriter.writeOne(object.details(), "details", writer);
        }
        if (object.directoryPresent()) {
            writer.writeElement("directory", object.directory());
        }
        if (object.discardSnapshotsPresent()) {
            writer.writeBoolean("discard_snapshots", object.discardSnapshots());
        }
        if (object.discoveredTargetsPresent()) {
            XmlIscsiDetailsWriter.writeMany(object.discoveredTargets().iterator(), "iscsi_details", "discovered_targets", writer);
        }
        if (object.diskPresent()) {
            XmlDiskWriter.writeOne(object.disk(), "disk", writer);
        }
        if (object.diskProfilePresent()) {
            XmlDiskProfileWriter.writeOne(object.diskProfile(), "disk_profile", writer);
        }
        if (object.disksPresent()) {
            XmlDiskWriter.writeMany(object.disks().iterator(), "disk", "disks", writer);
        }
        if (object.exclusivePresent()) {
            writer.writeBoolean("exclusive", object.exclusive());
        }
        if (object.faultPresent()) {
            XmlFaultWriter.writeOne(object.fault(), "fault", writer);
        }
        if (object.fenceTypePresent()) {
            writer.writeElement("fence_type", object.fenceType());
        }
        if (object.filenamePresent()) {
            writer.writeElement("filename", object.filename());
        }
        if (object.filterPresent()) {
            writer.writeBoolean("filter", object.filter());
        }
        if (object.fixLayoutPresent()) {
            writer.writeBoolean("fix_layout", object.fixLayout());
        }
        if (object.forcePresent()) {
            writer.writeBoolean("force", object.force());
        }
        if (object.gracePeriodPresent()) {
            XmlGracePeriodWriter.writeOne(object.gracePeriod(), "grace_period", writer);
        }
        if (object.hostPresent()) {
            XmlHostWriter.writeOne(object.host(), "host", writer);
        }
        if (object.imagePresent()) {
            writer.writeElement("image", object.image());
        }
        if (object.imageTransferPresent()) {
            XmlImageTransferWriter.writeOne(object.imageTransfer(), "image_transfer", writer);
        }
        if (object.importAsTemplatePresent()) {
            writer.writeBoolean("import_as_template", object.importAsTemplate());
        }
        if (object.isAttachedPresent()) {
            writer.writeBoolean("is_attached", object.isAttached());
        }
        if (object.iscsiPresent()) {
            XmlIscsiDetailsWriter.writeOne(object.iscsi(), "iscsi", writer);
        }
        if (object.iscsiTargetsPresent()) {
            writer.writeElements("iscsi_targets", object.iscsiTargets());
        }
        if (object.jobPresent()) {
            XmlJobWriter.writeOne(object.job(), "job", writer);
        }
        if (object.leasePresent()) {
            XmlStorageDomainLeaseWriter.writeOne(object.lease(), "lease", writer);
        }
        if (object.logicalUnitsPresent()) {
            XmlLogicalUnitWriter.writeMany(object.logicalUnits().iterator(), "logical_unit", "logical_units", writer);
        }
        if (object.maintenanceAfterRestartPresent()) {
            writer.writeBoolean("maintenance_after_restart", object.maintenanceAfterRestart());
        }
        if (object.maintenanceEnabledPresent()) {
            writer.writeBoolean("maintenance_enabled", object.maintenanceEnabled());
        }
        if (object.migrateVmsInAffinityClosurePresent()) {
            writer.writeBoolean("migrate_vms_in_affinity_closure", object.migrateVmsInAffinityClosure());
        }
        if (object.modifiedBondsPresent()) {
            XmlHostNicWriter.writeMany(object.modifiedBonds().iterator(), "host_nic", "modified_bonds", writer);
        }
        if (object.modifiedLabelsPresent()) {
            XmlNetworkLabelWriter.writeMany(object.modifiedLabels().iterator(), "network_label", "modified_labels", writer);
        }
        if (object.modifiedNetworkAttachmentsPresent()) {
            XmlNetworkAttachmentWriter.writeMany(object.modifiedNetworkAttachments().iterator(), "network_attachment", "modified_network_attachments", writer);
        }
        if (object.namePresent()) {
            writer.writeElement("name", object.name());
        }
        if (object.optimizeCpuSettingsPresent()) {
            writer.writeBoolean("optimize_cpu_settings", object.optimizeCpuSettings());
        }
        if (object.optionPresent()) {
            XmlOptionWriter.writeOne(object.option(), "option", writer);
        }
        if (object.pausePresent()) {
            writer.writeBoolean("pause", object.pause());
        }
        if (object.permissionPresent()) {
            XmlPermissionWriter.writeOne(object.permission(), "permission", writer);
        }
        if (object.powerManagementPresent()) {
            XmlPowerManagementWriter.writeOne(object.powerManagement(), "power_management", writer);
        }
        if (object.proxyTicketPresent()) {
            XmlProxyTicketWriter.writeOne(object.proxyTicket(), "proxy_ticket", writer);
        }
        if (object.quotaPresent()) {
            XmlQuotaWriter.writeOne(object.quota(), "quota", writer);
        }
        if (object.reasonPresent()) {
            writer.writeElement("reason", object.reason());
        }
        if (object.reassignBadMacsPresent()) {
            writer.writeBoolean("reassign_bad_macs", object.reassignBadMacs());
        }
        if (object.rebootPresent()) {
            writer.writeBoolean("reboot", object.reboot());
        }
        if (object.registrationConfigurationPresent()) {
            XmlRegistrationConfigurationWriter.writeOne(object.registrationConfiguration(), "registration_configuration", writer);
        }
        if (object.remoteViewerConnectionFilePresent()) {
            writer.writeElement("remote_viewer_connection_file", object.remoteViewerConnectionFile());
        }
        if (object.removedBondsPresent()) {
            XmlHostNicWriter.writeMany(object.removedBonds().iterator(), "host_nic", "removed_bonds", writer);
        }
        if (object.removedLabelsPresent()) {
            XmlNetworkLabelWriter.writeMany(object.removedLabels().iterator(), "network_label", "removed_labels", writer);
        }
        if (object.removedNetworkAttachmentsPresent()) {
            XmlNetworkAttachmentWriter.writeMany(object.removedNetworkAttachments().iterator(), "network_attachment", "removed_network_attachments", writer);
        }
        if (object.resolutionTypePresent()) {
            writer.writeElement("resolution_type", object.resolutionType());
        }
        if (object.restoreMemoryPresent()) {
            writer.writeBoolean("restore_memory", object.restoreMemory());
        }
        if (object.rootPasswordPresent()) {
            writer.writeElement("root_password", object.rootPassword());
        }
        if (object.sealPresent()) {
            writer.writeBoolean("seal", object.seal());
        }
        if (object.snapshotPresent()) {
            XmlSnapshotWriter.writeOne(object.snapshot(), "snapshot", writer);
        }
        if (object.sourceHostPresent()) {
            XmlHostWriter.writeOne(object.sourceHost(), "source_host", writer);
        }
        if (object.sshPresent()) {
            XmlSshWriter.writeOne(object.ssh(), "ssh", writer);
        }
        if (object.statusPresent()) {
            writer.writeElement("status", object.status());
        }
        if (object.stopGlusterServicePresent()) {
            writer.writeBoolean("stop_gluster_service", object.stopGlusterService());
        }
        if (object.storageDomainPresent()) {
            XmlStorageDomainWriter.writeOne(object.storageDomain(), "storage_domain", writer);
        }
        if (object.storageDomainsPresent()) {
            XmlStorageDomainWriter.writeMany(object.storageDomains().iterator(), "storage_domain", "storage_domains", writer);
        }
        if (object.succeededPresent()) {
            writer.writeBoolean("succeeded", object.succeeded());
        }
        if (object.synchronizedNetworkAttachmentsPresent()) {
            XmlNetworkAttachmentWriter.writeMany(object.synchronizedNetworkAttachments().iterator(), "network_attachment", "synchronized_network_attachments", writer);
        }
        if (object.templatePresent()) {
            XmlTemplateWriter.writeOne(object.template(), "template", writer);
        }
        if (object.ticketPresent()) {
            XmlTicketWriter.writeOne(object.ticket(), "ticket", writer);
        }
        if (object.timeoutPresent()) {
            writer.writeInteger("timeout", object.timeout());
        }
        if (object.undeployHostedEnginePresent()) {
            writer.writeBoolean("undeploy_hosted_engine", object.undeployHostedEngine());
        }
        if (object.upgradeActionPresent()) {
            XmlClusterUpgradeActionWriter.writeOne(object.upgradeAction(), "upgrade_action", writer);
        }
        if (object.useCloudInitPresent()) {
            writer.writeBoolean("use_cloud_init", object.useCloudInit());
        }
        if (object.useIgnitionPresent()) {
            writer.writeBoolean("use_ignition", object.useIgnition());
        }
        if (object.useInitializationPresent()) {
            writer.writeBoolean("use_initialization", object.useInitialization());
        }
        if (object.useSysprepPresent()) {
            writer.writeBoolean("use_sysprep", object.useSysprep());
        }
        if (object.virtualFunctionsConfigurationPresent()) {
            XmlHostNicVirtualFunctionsConfigurationWriter.writeOne(object.virtualFunctionsConfiguration(), "virtual_functions_configuration", writer);
        }
        if (object.vmPresent()) {
            XmlVmWriter.writeOne(object.vm(), "vm", writer);
        }
        if (object.vnicProfileMappingsPresent()) {
            XmlVnicProfileMappingWriter.writeMany(object.vnicProfileMappings().iterator(), "vnic_profile_mapping", "vnic_profile_mappings", writer);
        }
        if (object.volatile_Present()) {
            writer.writeBoolean("volatile", object.volatile_());
        }
        writer.writeEndElement();
    }
    
    public static void writeMany(Iterator<Action> list, XmlWriter writer) {
        writeMany(list, "action", "actions", writer);
    }
    
    public static void writeMany(Iterator<Action> list, String singular, String plural, XmlWriter writer) {
        writer.writeStartElement(plural);
        while (list.hasNext()) {
            XmlActionWriter.writeOne(list.next(), singular, writer);
        }
        writer.writeEndElement();
    }
    
}

