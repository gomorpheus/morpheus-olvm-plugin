/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.math.BigInteger;
import java.util.List;

/**
 * Storage domain.
 * 
 * An XML representation of a NFS storage domain with identifier `123`:
 * 
 * [source,xml]
 * ----
 * <storage_domain href="/ovirt-engine/api/storagedomains/123" id="123">
 *   <name>mydata</name>
 *   <description>My data</description>
 *   <available>38654705664</available>
 *   <committed>1073741824</committed>
 *   <critical_space_action_blocker>5</critical_space_action_blocker>
 *   <external_status>ok</external_status>
 *   <master>true</master>
 *   <storage>
 *     <address>mynfs.example.com</address>
 *     <nfs_version>v3</nfs_version>
 *     <path>/exports/mydata</path>
 *     <type>nfs</type>
 *   </storage>
 *   <storage_format>v3</storage_format>
 *   <type>data</type>
 *   <used>13958643712</used>
 *   <warning_low_space_indicator>10</warning_low_space_indicator>
 *   <wipe_after_delete>false</wipe_after_delete>
 *   <data_centers>
 *     <data_center href="/ovirt-engine/api/datacenters/456" id="456"/>
 *   </data_centers>
 * </storage_domain>
 * ----
 */
public interface StorageDomain extends Identified {
    BigInteger available();
    Byte availableAsByte();
    Short availableAsShort();
    Integer availableAsInteger();
    Long availableAsLong();
    
    boolean availablePresent();
    
    boolean backup();
    
    boolean backupPresent();
    
    BigInteger blockSize();
    Byte blockSizeAsByte();
    Short blockSizeAsShort();
    Integer blockSizeAsInteger();
    Long blockSizeAsLong();
    
    boolean blockSizePresent();
    
    BigInteger committed();
    Byte committedAsByte();
    Short committedAsShort();
    Integer committedAsInteger();
    Long committedAsLong();
    
    boolean committedPresent();
    
    BigInteger criticalSpaceActionBlocker();
    Byte criticalSpaceActionBlockerAsByte();
    Short criticalSpaceActionBlockerAsShort();
    Integer criticalSpaceActionBlockerAsInteger();
    Long criticalSpaceActionBlockerAsLong();
    
    boolean criticalSpaceActionBlockerPresent();
    
    boolean discardAfterDelete();
    
    boolean discardAfterDeletePresent();
    
    ExternalStatus externalStatus();
    
    boolean externalStatusPresent();
    
    boolean import_();
    
    boolean import_Present();
    
    boolean master();
    
    boolean masterPresent();
    
    StorageDomainStatus status();
    
    boolean statusPresent();
    
    HostStorage storage();
    
    boolean storagePresent();
    
    StorageFormat storageFormat();
    
    boolean storageFormatPresent();
    
    boolean supportsDiscard();
    
    boolean supportsDiscardPresent();
    
    boolean supportsDiscardZeroesData();
    
    boolean supportsDiscardZeroesDataPresent();
    
    StorageDomainType type();
    
    boolean typePresent();
    
    BigInteger used();
    Byte usedAsByte();
    Short usedAsShort();
    Integer usedAsInteger();
    Long usedAsLong();
    
    boolean usedPresent();
    
    BigInteger warningLowSpaceIndicator();
    Byte warningLowSpaceIndicatorAsByte();
    Short warningLowSpaceIndicatorAsShort();
    Integer warningLowSpaceIndicatorAsInteger();
    Long warningLowSpaceIndicatorAsLong();
    
    boolean warningLowSpaceIndicatorPresent();
    
    boolean wipeAfterDelete();
    
    boolean wipeAfterDeletePresent();
    
    DataCenter dataCenter();
    
    boolean dataCenterPresent();
    
    List<DataCenter> dataCenters();
    
    boolean dataCentersPresent();
    
    List<DiskProfile> diskProfiles();
    
    boolean diskProfilesPresent();
    
    List<DiskSnapshot> diskSnapshots();
    
    boolean diskSnapshotsPresent();
    
    List<Disk> disks();
    
    boolean disksPresent();
    
    List<File> files();
    
    boolean filesPresent();
    
    Host host();
    
    boolean hostPresent();
    
    List<Image> images();
    
    boolean imagesPresent();
    
    List<Permission> permissions();
    
    boolean permissionsPresent();
    
    List<StorageConnection> storageConnections();
    
    boolean storageConnectionsPresent();
    
    List<Template> templates();
    
    boolean templatesPresent();
    
    List<Vm> vms();
    
    boolean vmsPresent();
    
}
