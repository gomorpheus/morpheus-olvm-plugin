/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.Date;
import java.util.List;

/**
 * Represents a virtual machine.
 */
public interface Vm extends VmBase {
    String fqdn();
    
    boolean fqdnPresent();
    
    GuestOperatingSystem guestOperatingSystem();
    
    boolean guestOperatingSystemPresent();
    
    TimeZone guestTimeZone();
    
    boolean guestTimeZonePresent();
    
    boolean hasIllegalImages();
    
    boolean hasIllegalImagesPresent();
    
    boolean nextRunConfigurationExists();
    
    boolean nextRunConfigurationExistsPresent();
    
    NumaTuneMode numaTuneMode();
    
    boolean numaTuneModePresent();
    
    List<Payload> payloads();
    
    boolean payloadsPresent();
    
    boolean runOnce();
    
    boolean runOncePresent();
    
    Date startTime();
    
    boolean startTimePresent();
    
    VmStatus status();
    
    boolean statusPresent();
    
    String statusDetail();
    
    boolean statusDetailPresent();
    
    String stopReason();
    
    boolean stopReasonPresent();
    
    Date stopTime();
    
    boolean stopTimePresent();
    
    boolean useLatestTemplateVersion();
    
    boolean useLatestTemplateVersionPresent();
    
    List<AffinityLabel> affinityLabels();
    
    boolean affinityLabelsPresent();
    
    List<Application> applications();
    
    boolean applicationsPresent();
    
    List<Cdrom> cdroms();
    
    boolean cdromsPresent();
    
    List<DiskAttachment> diskAttachments();
    
    boolean diskAttachmentsPresent();
    
    ExternalHostProvider externalHostProvider();
    
    boolean externalHostProviderPresent();
    
    List<Floppy> floppies();
    
    boolean floppiesPresent();
    
    List<GraphicsConsole> graphicsConsoles();
    
    boolean graphicsConsolesPresent();
    
    Host host();
    
    boolean hostPresent();
    
    List<HostDevice> hostDevices();
    
    boolean hostDevicesPresent();
    
    InstanceType instanceType();
    
    boolean instanceTypePresent();
    
    List<KatelloErratum> katelloErrata();
    
    boolean katelloErrataPresent();
    
    List<Nic> nics();
    
    boolean nicsPresent();
    
    List<NumaNode> numaNodes();
    
    boolean numaNodesPresent();
    
    Template originalTemplate();
    
    boolean originalTemplatePresent();
    
    List<Permission> permissions();
    
    boolean permissionsPresent();
    
    List<ReportedDevice> reportedDevices();
    
    boolean reportedDevicesPresent();
    
    List<Session> sessions();
    
    boolean sessionsPresent();
    
    List<Snapshot> snapshots();
    
    boolean snapshotsPresent();
    
    List<Statistic> statistics();
    
    boolean statisticsPresent();
    
    List<Tag> tags();
    
    boolean tagsPresent();
    
    Template template();
    
    boolean templatePresent();
    
    VmPool vmPool();
    
    boolean vmPoolPresent();
    
    List<Watchdog> watchdogs();
    
    boolean watchdogsPresent();
    
}
