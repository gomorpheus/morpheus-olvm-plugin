/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.util.Date;
import java.util.List;
import org.ovirt.engine.sdk4.types.AffinityLabel;
import org.ovirt.engine.sdk4.types.Application;
import org.ovirt.engine.sdk4.types.Cdrom;
import org.ovirt.engine.sdk4.types.DiskAttachment;
import org.ovirt.engine.sdk4.types.ExternalHostProvider;
import org.ovirt.engine.sdk4.types.Floppy;
import org.ovirt.engine.sdk4.types.GraphicsConsole;
import org.ovirt.engine.sdk4.types.GuestOperatingSystem;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.HostDevice;
import org.ovirt.engine.sdk4.types.InstanceType;
import org.ovirt.engine.sdk4.types.KatelloErratum;
import org.ovirt.engine.sdk4.types.Nic;
import org.ovirt.engine.sdk4.types.NumaNode;
import org.ovirt.engine.sdk4.types.NumaTuneMode;
import org.ovirt.engine.sdk4.types.Payload;
import org.ovirt.engine.sdk4.types.Permission;
import org.ovirt.engine.sdk4.types.ReportedDevice;
import org.ovirt.engine.sdk4.types.Session;
import org.ovirt.engine.sdk4.types.Snapshot;
import org.ovirt.engine.sdk4.types.Statistic;
import org.ovirt.engine.sdk4.types.Tag;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.TimeZone;
import org.ovirt.engine.sdk4.types.Vm;
import org.ovirt.engine.sdk4.types.VmPool;
import org.ovirt.engine.sdk4.types.VmStatus;
import org.ovirt.engine.sdk4.types.Watchdog;

public class VmContainer extends VmBaseContainer implements Vm {
    private String fqdn;
    private GuestOperatingSystem guestOperatingSystem;
    private TimeZone guestTimeZone;
    private Boolean hasIllegalImages;
    private Boolean nextRunConfigurationExists;
    private NumaTuneMode numaTuneMode;
    private List<Payload> payloads;
    private Boolean runOnce;
    private Date startTime;
    private VmStatus status;
    private String statusDetail;
    private String stopReason;
    private Date stopTime;
    private Boolean useLatestTemplateVersion;
    private List<AffinityLabel> affinityLabels;
    private List<Application> applications;
    private List<Cdrom> cdroms;
    private List<DiskAttachment> diskAttachments;
    private ExternalHostProvider externalHostProvider;
    private List<Floppy> floppies;
    private List<GraphicsConsole> graphicsConsoles;
    private Host host;
    private List<HostDevice> hostDevices;
    private InstanceType instanceType;
    private List<KatelloErratum> katelloErrata;
    private List<Nic> nics;
    private List<NumaNode> numaNodes;
    private Template originalTemplate;
    private List<Permission> permissions;
    private List<ReportedDevice> reportedDevices;
    private List<Session> sessions;
    private List<Snapshot> snapshots;
    private List<Statistic> statistics;
    private List<Tag> tags;
    private Template template;
    private VmPool vmPool;
    private List<Watchdog> watchdogs;
    
    public String fqdn() {
        return fqdn;
    }
    
    public void fqdn(String newFqdn) {
        fqdn = newFqdn;
    }
    
    public boolean fqdnPresent() {
        return fqdn != null;
    }
    
    public GuestOperatingSystem guestOperatingSystem() {
        return guestOperatingSystem;
    }
    
    public void guestOperatingSystem(GuestOperatingSystem newGuestOperatingSystem) {
        guestOperatingSystem = newGuestOperatingSystem;
    }
    
    public boolean guestOperatingSystemPresent() {
        return guestOperatingSystem != null;
    }
    
    public TimeZone guestTimeZone() {
        return guestTimeZone;
    }
    
    public void guestTimeZone(TimeZone newGuestTimeZone) {
        guestTimeZone = newGuestTimeZone;
    }
    
    public boolean guestTimeZonePresent() {
        return guestTimeZone != null;
    }
    
    public boolean hasIllegalImages() {
        return hasIllegalImages;
    }
    
    public void hasIllegalImages(boolean newHasIllegalImages) {
        hasIllegalImages = Boolean.valueOf(newHasIllegalImages);
    }
    
    public void hasIllegalImages(Boolean newHasIllegalImages) {
        hasIllegalImages = newHasIllegalImages;
    }
    
    public boolean hasIllegalImagesPresent() {
        return hasIllegalImages != null;
    }
    
    public boolean nextRunConfigurationExists() {
        return nextRunConfigurationExists;
    }
    
    public void nextRunConfigurationExists(boolean newNextRunConfigurationExists) {
        nextRunConfigurationExists = Boolean.valueOf(newNextRunConfigurationExists);
    }
    
    public void nextRunConfigurationExists(Boolean newNextRunConfigurationExists) {
        nextRunConfigurationExists = newNextRunConfigurationExists;
    }
    
    public boolean nextRunConfigurationExistsPresent() {
        return nextRunConfigurationExists != null;
    }
    
    public NumaTuneMode numaTuneMode() {
        return numaTuneMode;
    }
    
    public void numaTuneMode(NumaTuneMode newNumaTuneMode) {
        numaTuneMode = newNumaTuneMode;
    }
    
    public boolean numaTuneModePresent() {
        return numaTuneMode != null;
    }
    
    public List<Payload> payloads() {
        return makeUnmodifiableList(payloads);
    }
    
    public void payloads(List<Payload> newPayloads) {
        payloads = makeArrayList(newPayloads);
    }
    
    public boolean payloadsPresent() {
        return payloads != null && !payloads.isEmpty();
    }
    
    public boolean runOnce() {
        return runOnce;
    }
    
    public void runOnce(boolean newRunOnce) {
        runOnce = Boolean.valueOf(newRunOnce);
    }
    
    public void runOnce(Boolean newRunOnce) {
        runOnce = newRunOnce;
    }
    
    public boolean runOncePresent() {
        return runOnce != null;
    }
    
    public Date startTime() {
        if (startTime == null) {
            return null;
        }
        else {
            return new Date(startTime.getTime());
        }
    }
    
    public void startTime(Date newStartTime) {
        if (newStartTime == null) {
            startTime = null;
        }
        else {
            startTime = new Date(newStartTime.getTime());
        }
    }
    
    public boolean startTimePresent() {
        return startTime != null;
    }
    
    public VmStatus status() {
        return status;
    }
    
    public void status(VmStatus newStatus) {
        status = newStatus;
    }
    
    public boolean statusPresent() {
        return status != null;
    }
    
    public String statusDetail() {
        return statusDetail;
    }
    
    public void statusDetail(String newStatusDetail) {
        statusDetail = newStatusDetail;
    }
    
    public boolean statusDetailPresent() {
        return statusDetail != null;
    }
    
    public String stopReason() {
        return stopReason;
    }
    
    public void stopReason(String newStopReason) {
        stopReason = newStopReason;
    }
    
    public boolean stopReasonPresent() {
        return stopReason != null;
    }
    
    public Date stopTime() {
        if (stopTime == null) {
            return null;
        }
        else {
            return new Date(stopTime.getTime());
        }
    }
    
    public void stopTime(Date newStopTime) {
        if (newStopTime == null) {
            stopTime = null;
        }
        else {
            stopTime = new Date(newStopTime.getTime());
        }
    }
    
    public boolean stopTimePresent() {
        return stopTime != null;
    }
    
    public boolean useLatestTemplateVersion() {
        return useLatestTemplateVersion;
    }
    
    public void useLatestTemplateVersion(boolean newUseLatestTemplateVersion) {
        useLatestTemplateVersion = Boolean.valueOf(newUseLatestTemplateVersion);
    }
    
    public void useLatestTemplateVersion(Boolean newUseLatestTemplateVersion) {
        useLatestTemplateVersion = newUseLatestTemplateVersion;
    }
    
    public boolean useLatestTemplateVersionPresent() {
        return useLatestTemplateVersion != null;
    }
    
    public List<AffinityLabel> affinityLabels() {
        return makeUnmodifiableList(affinityLabels);
    }
    
    public void affinityLabels(List<AffinityLabel> newAffinityLabels) {
        affinityLabels = makeArrayList(newAffinityLabels);
    }
    
    public boolean affinityLabelsPresent() {
        return affinityLabels != null && !affinityLabels.isEmpty();
    }
    
    public List<Application> applications() {
        return makeUnmodifiableList(applications);
    }
    
    public void applications(List<Application> newApplications) {
        applications = makeArrayList(newApplications);
    }
    
    public boolean applicationsPresent() {
        return applications != null && !applications.isEmpty();
    }
    
    public List<Cdrom> cdroms() {
        return makeUnmodifiableList(cdroms);
    }
    
    public void cdroms(List<Cdrom> newCdroms) {
        cdroms = makeArrayList(newCdroms);
    }
    
    public boolean cdromsPresent() {
        return cdroms != null && !cdroms.isEmpty();
    }
    
    public List<DiskAttachment> diskAttachments() {
        return makeUnmodifiableList(diskAttachments);
    }
    
    public void diskAttachments(List<DiskAttachment> newDiskAttachments) {
        diskAttachments = makeArrayList(newDiskAttachments);
    }
    
    public boolean diskAttachmentsPresent() {
        return diskAttachments != null && !diskAttachments.isEmpty();
    }
    
    public ExternalHostProvider externalHostProvider() {
        return externalHostProvider;
    }
    
    public void externalHostProvider(ExternalHostProvider newExternalHostProvider) {
        externalHostProvider = newExternalHostProvider;
    }
    
    public boolean externalHostProviderPresent() {
        return externalHostProvider != null;
    }
    
    public List<Floppy> floppies() {
        return makeUnmodifiableList(floppies);
    }
    
    public void floppies(List<Floppy> newFloppies) {
        floppies = makeArrayList(newFloppies);
    }
    
    public boolean floppiesPresent() {
        return floppies != null && !floppies.isEmpty();
    }
    
    public List<GraphicsConsole> graphicsConsoles() {
        return makeUnmodifiableList(graphicsConsoles);
    }
    
    public void graphicsConsoles(List<GraphicsConsole> newGraphicsConsoles) {
        graphicsConsoles = makeArrayList(newGraphicsConsoles);
    }
    
    public boolean graphicsConsolesPresent() {
        return graphicsConsoles != null && !graphicsConsoles.isEmpty();
    }
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
    public List<HostDevice> hostDevices() {
        return makeUnmodifiableList(hostDevices);
    }
    
    public void hostDevices(List<HostDevice> newHostDevices) {
        hostDevices = makeArrayList(newHostDevices);
    }
    
    public boolean hostDevicesPresent() {
        return hostDevices != null && !hostDevices.isEmpty();
    }
    
    public InstanceType instanceType() {
        return instanceType;
    }
    
    public void instanceType(InstanceType newInstanceType) {
        instanceType = newInstanceType;
    }
    
    public boolean instanceTypePresent() {
        return instanceType != null;
    }
    
    public List<KatelloErratum> katelloErrata() {
        return makeUnmodifiableList(katelloErrata);
    }
    
    public void katelloErrata(List<KatelloErratum> newKatelloErrata) {
        katelloErrata = makeArrayList(newKatelloErrata);
    }
    
    public boolean katelloErrataPresent() {
        return katelloErrata != null && !katelloErrata.isEmpty();
    }
    
    public List<Nic> nics() {
        return makeUnmodifiableList(nics);
    }
    
    public void nics(List<Nic> newNics) {
        nics = makeArrayList(newNics);
    }
    
    public boolean nicsPresent() {
        return nics != null && !nics.isEmpty();
    }
    
    public List<NumaNode> numaNodes() {
        return makeUnmodifiableList(numaNodes);
    }
    
    public void numaNodes(List<NumaNode> newNumaNodes) {
        numaNodes = makeArrayList(newNumaNodes);
    }
    
    public boolean numaNodesPresent() {
        return numaNodes != null && !numaNodes.isEmpty();
    }
    
    public Template originalTemplate() {
        return originalTemplate;
    }
    
    public void originalTemplate(Template newOriginalTemplate) {
        originalTemplate = newOriginalTemplate;
    }
    
    public boolean originalTemplatePresent() {
        return originalTemplate != null;
    }
    
    public List<Permission> permissions() {
        return makeUnmodifiableList(permissions);
    }
    
    public void permissions(List<Permission> newPermissions) {
        permissions = makeArrayList(newPermissions);
    }
    
    public boolean permissionsPresent() {
        return permissions != null && !permissions.isEmpty();
    }
    
    public List<ReportedDevice> reportedDevices() {
        return makeUnmodifiableList(reportedDevices);
    }
    
    public void reportedDevices(List<ReportedDevice> newReportedDevices) {
        reportedDevices = makeArrayList(newReportedDevices);
    }
    
    public boolean reportedDevicesPresent() {
        return reportedDevices != null && !reportedDevices.isEmpty();
    }
    
    public List<Session> sessions() {
        return makeUnmodifiableList(sessions);
    }
    
    public void sessions(List<Session> newSessions) {
        sessions = makeArrayList(newSessions);
    }
    
    public boolean sessionsPresent() {
        return sessions != null && !sessions.isEmpty();
    }
    
    public List<Snapshot> snapshots() {
        return makeUnmodifiableList(snapshots);
    }
    
    public void snapshots(List<Snapshot> newSnapshots) {
        snapshots = makeArrayList(newSnapshots);
    }
    
    public boolean snapshotsPresent() {
        return snapshots != null && !snapshots.isEmpty();
    }
    
    public List<Statistic> statistics() {
        return makeUnmodifiableList(statistics);
    }
    
    public void statistics(List<Statistic> newStatistics) {
        statistics = makeArrayList(newStatistics);
    }
    
    public boolean statisticsPresent() {
        return statistics != null && !statistics.isEmpty();
    }
    
    public List<Tag> tags() {
        return makeUnmodifiableList(tags);
    }
    
    public void tags(List<Tag> newTags) {
        tags = makeArrayList(newTags);
    }
    
    public boolean tagsPresent() {
        return tags != null && !tags.isEmpty();
    }
    
    public Template template() {
        return template;
    }
    
    public void template(Template newTemplate) {
        template = newTemplate;
    }
    
    public boolean templatePresent() {
        return template != null;
    }
    
    public VmPool vmPool() {
        return vmPool;
    }
    
    public void vmPool(VmPool newVmPool) {
        vmPool = newVmPool;
    }
    
    public boolean vmPoolPresent() {
        return vmPool != null;
    }
    
    public List<Watchdog> watchdogs() {
        return makeUnmodifiableList(watchdogs);
    }
    
    public void watchdogs(List<Watchdog> newWatchdogs) {
        watchdogs = makeArrayList(newWatchdogs);
    }
    
    public boolean watchdogsPresent() {
        return watchdogs != null && !watchdogs.isEmpty();
    }
    
}
