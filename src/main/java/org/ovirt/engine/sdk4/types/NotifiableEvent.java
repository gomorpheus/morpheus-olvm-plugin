/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing a subset of events in the {product-name} server:
 * those which a user may subscribe to receive a notification about.
 */
public enum NotifiableEvent {
    /**
     * HA Reservation check has failed
     */
    CLUSTER_ALERT_HA_RESERVATION("cluster_alert_ha_reservation"),
    /**
     * HA Reservation check has passed
     */
    CLUSTER_ALERT_HA_RESERVATION_DOWN("cluster_alert_ha_reservation_down"),
    /**
     * ETL Service Error
     */
    DWH_ERROR("dwh_error"),
    /**
     * ETL Service Stopped
     */
    DWH_STOPPED("dwh_stopped"),
    /**
     * Engine backup completed successfully
     */
    ENGINE_BACKUP_COMPLETED("engine_backup_completed"),
    /**
     * Engine backup failed
     */
    ENGINE_BACKUP_FAILED("engine_backup_failed"),
    /**
     * Engine backup started
     */
    ENGINE_BACKUP_STARTED("engine_backup_started"),
    /**
     * Engine CA's certification has expired
     */
    ENGINE_CA_CERTIFICATION_HAS_EXPIRED("engine_ca_certification_has_expired"),
    /**
     * Engine CA's certification is about to expire
     */
    ENGINE_CA_CERTIFICATION_IS_ABOUT_TO_EXPIRE("engine_ca_certification_is_about_to_expire"),
    /**
     * Engine's certification has expired
     */
    ENGINE_CERTIFICATION_HAS_EXPIRED("engine_certification_has_expired"),
    /**
     * Engine's certification is about to expire
     */
    ENGINE_CERTIFICATION_IS_ABOUT_TO_EXPIRE("engine_certification_is_about_to_expire"),
    /**
     * Engine has stopped
     */
    ENGINE_STOP("engine_stop"),
    /**
     * Faulty multipath paths on host
     */
    FAULTY_MULTIPATHS_ON_HOST("faulty_multipaths_on_host"),
    /**
     * Detected change in status of brick
     */
    GLUSTER_BRICK_STATUS_CHANGED("gluster_brick_status_changed"),
    /**
     * Failed to add Gluster Hook on conflicting servers
     */
    GLUSTER_HOOK_ADD_FAILED("gluster_hook_add_failed"),
    /**
     * Added Gluster Hook
     */
    GLUSTER_HOOK_ADDED("gluster_hook_added"),
    /**
     * Detected conflict in Gluster Hook
     */
    GLUSTER_HOOK_CONFLICT_DETECTED("gluster_hook_conflict_detected"),
    /**
     * Detected removal of Gluster Hook
     */
    GLUSTER_HOOK_DETECTED_DELETE("gluster_hook_detected_delete"),
    /**
     * Detected new Gluster Hook
     */
    GLUSTER_HOOK_DETECTED_NEW("gluster_hook_detected_new"),
    /**
     * Gluster Hook Disabled
     */
    GLUSTER_HOOK_DISABLE("gluster_hook_disable"),
    /**
     * Failed to Disable Gluster Hook
     */
    GLUSTER_HOOK_DISABLE_FAILED("gluster_hook_disable_failed"),
    /**
     * Gluster Hook Enabled
     */
    GLUSTER_HOOK_ENABLE("gluster_hook_enable"),
    /**
     * Failed to Enable Gluster Hook
     */
    GLUSTER_HOOK_ENABLE_FAILED("gluster_hook_enable_failed"),
    /**
     * Failed to remove Gluster Hook from cluster
     */
    GLUSTER_HOOK_REMOVE_FAILED("gluster_hook_remove_failed"),
    /**
     * Removed Gluster Hook
     */
    GLUSTER_HOOK_REMOVED("gluster_hook_removed"),
    /**
     * Failed to Add Gluster Server
     */
    GLUSTER_SERVER_ADD_FAILED("gluster_server_add_failed"),
    /**
     * Gluster Server Removed
     */
    GLUSTER_SERVER_REMOVE("gluster_server_remove"),
    /**
     * Failed to Remove Gluster Server
     */
    GLUSTER_SERVER_REMOVE_FAILED("gluster_server_remove_failed"),
    /**
     * Failed to re-start Gluster Service
     */
    GLUSTER_SERVICE_RESTART_FAILED("gluster_service_restart_failed"),
    /**
     * Gluster Service re-started
     */
    GLUSTER_SERVICE_RESTARTED("gluster_service_restarted"),
    /**
     * Failed to start Gluster service
     */
    GLUSTER_SERVICE_START_FAILED("gluster_service_start_failed"),
    /**
     * Gluster Service started
     */
    GLUSTER_SERVICE_STARTED("gluster_service_started"),
    /**
     * Failed to stop Gluster service
     */
    GLUSTER_SERVICE_STOP_FAILED("gluster_service_stop_failed"),
    /**
     * Gluster Service stopped
     */
    GLUSTER_SERVICE_STOPPED("gluster_service_stopped"),
    /**
     * Gluster Volume brick(s) added
     */
    GLUSTER_VOLUME_ADD_BRICK("gluster_volume_add_brick"),
    /**
     * Failed to add brick(s) on Gluster Volume
     */
    GLUSTER_VOLUME_ADD_BRICK_FAILED("gluster_volume_add_brick_failed"),
    /**
     * Failed to delete snapshots on the volume
     */
    GLUSTER_VOLUME_ALL_SNAPSHOTS_DELETE_FAILED("gluster_volume_all_snapshots_delete_failed"),
    /**
     * All the snapshots deleted on the volume
     */
    GLUSTER_VOLUME_ALL_SNAPSHOTS_DELETED("gluster_volume_all_snapshots_deleted"),
    /**
     * Gluster Volume Brick Replaced
     */
    GLUSTER_VOLUME_BRICK_REPLACED("gluster_volume_brick_replaced"),
    /**
     * Low space for volume confirmed
     */
    GLUSTER_VOLUME_CONFIRMED_SPACE_LOW("gluster_volume_confirmed_space_low"),
    /**
     * Gluster Volume Created
     */
    GLUSTER_VOLUME_CREATE("gluster_volume_create"),
    /**
     * Gluster Volume could not be created
     */
    GLUSTER_VOLUME_CREATE_FAILED("gluster_volume_create_failed"),
    /**
     * Gluster Volume deleted
     */
    GLUSTER_VOLUME_DELETE("gluster_volume_delete"),
    /**
     * Gluster Volume could not be deleted
     */
    GLUSTER_VOLUME_DELETE_FAILED("gluster_volume_delete_failed"),
    /**
     * Gluster Volume migration of data for remove brick finished
     */
    GLUSTER_VOLUME_MIGRATE_BRICK_DATA_FINISHED("gluster_volume_migrate_brick_data_finished"),
    /**
     * Gluster Volume Option added
     */
    GLUSTER_VOLUME_OPTION_ADDED("gluster_volume_option_added"),
    /**
     * Gluster Volume Option modified
     */
    GLUSTER_VOLUME_OPTION_MODIFIED("gluster_volume_option_modified"),
    /**
     * Gluster Volume Option could not be set
     */
    GLUSTER_VOLUME_OPTION_SET_FAILED("gluster_volume_option_set_failed"),
    /**
     * Gluster Volume Options reset
     */
    GLUSTER_VOLUME_OPTIONS_RESET("gluster_volume_options_reset"),
    /**
     * All the Gluster Volume Options reset
     */
    GLUSTER_VOLUME_OPTIONS_RESET_ALL("gluster_volume_options_reset_all"),
    /**
     * Gluster Volume Options could not be reset
     */
    GLUSTER_VOLUME_OPTIONS_RESET_FAILED("gluster_volume_options_reset_failed"),
    /**
     * Gluster Volume Profile started
     */
    GLUSTER_VOLUME_PROFILE_START("gluster_volume_profile_start"),
    /**
     * Failed to start Gluster Volume Profile
     */
    GLUSTER_VOLUME_PROFILE_START_FAILED("gluster_volume_profile_start_failed"),
    /**
     * Gluster Volume Profile stopped
     */
    GLUSTER_VOLUME_PROFILE_STOP("gluster_volume_profile_stop"),
    /**
     * Failed to stop Gluster Volume Profile
     */
    GLUSTER_VOLUME_PROFILE_STOP_FAILED("gluster_volume_profile_stop_failed"),
    /**
     * Gluster Volume rebalance finished
     */
    GLUSTER_VOLUME_REBALANCE_FINISHED("gluster_volume_rebalance_finished"),
    /**
     * Could not find information for rebalance on volume from CLI. Marking it as unknown.
     */
    GLUSTER_VOLUME_REBALANCE_NOT_FOUND_FROM_CLI("gluster_volume_rebalance_not_found_from_cli"),
    /**
     * Gluster Volume Rebalance started
     */
    GLUSTER_VOLUME_REBALANCE_START("gluster_volume_rebalance_start"),
    /**
     * Detected start of rebalance on gluster volume from CLI
     */
    GLUSTER_VOLUME_REBALANCE_START_DETECTED_FROM_CLI("gluster_volume_rebalance_start_detected_from_cli"),
    /**
     * Gluster Volume Rebalance could not be started
     */
    GLUSTER_VOLUME_REBALANCE_START_FAILED("gluster_volume_rebalance_start_failed"),
    /**
     * Gluster Volume Rebalance stopped
     */
    GLUSTER_VOLUME_REBALANCE_STOP("gluster_volume_rebalance_stop"),
    /**
     * Gluster Volume Rebalance could not be stopped
     */
    GLUSTER_VOLUME_REBALANCE_STOP_FAILED("gluster_volume_rebalance_stop_failed"),
    /**
     * Gluster Volume Bricks Removed
     */
    GLUSTER_VOLUME_REMOVE_BRICKS("gluster_volume_remove_bricks"),
    /**
     * Gluster Volume Bricks could not be removed
     */
    GLUSTER_VOLUME_REMOVE_BRICKS_FAILED("gluster_volume_remove_bricks_failed"),
    /**
     * Stopped removing bricks from Gluster Volume
     */
    GLUSTER_VOLUME_REMOVE_BRICKS_STOP("gluster_volume_remove_bricks_stop"),
    /**
     * Failed to stop remove bricks from Gluster Volume
     */
    GLUSTER_VOLUME_REMOVE_BRICKS_STOP_FAILED("gluster_volume_remove_bricks_stop_failed"),
    /**
     * Gluster Volume Replace Brick Failed
     */
    GLUSTER_VOLUME_REPLACE_BRICK_FAILED("gluster_volume_replace_brick_failed"),
    /**
     * Gluster Volume Replace Brick Started
     */
    GLUSTER_VOLUME_REPLACE_BRICK_START("gluster_volume_replace_brick_start"),
    /**
     * Gluster Volume Replace Brick could not be started
     */
    GLUSTER_VOLUME_REPLACE_BRICK_START_FAILED("gluster_volume_replace_brick_start_failed"),
    /**
     * Failed to activate snapshot on the volume
     */
    GLUSTER_VOLUME_SNAPSHOT_ACTIVATE_FAILED("gluster_volume_snapshot_activate_failed"),
    /**
     * Snapshot activated on the volume
     */
    GLUSTER_VOLUME_SNAPSHOT_ACTIVATED("gluster_volume_snapshot_activated"),
    /**
     * Could not create snapshot for volume ${glusterVolumeName} on cluster ${clusterName}.
     */
    GLUSTER_VOLUME_SNAPSHOT_CREATE_FAILED("gluster_volume_snapshot_create_failed"),
    /**
     * Snapshot ${snapname} created for volume ${glusterVolumeName} on cluster ${clusterName}.
     */
    GLUSTER_VOLUME_SNAPSHOT_CREATED("gluster_volume_snapshot_created"),
    /**
     * Failed to de-activate snapshot on the volume
     */
    GLUSTER_VOLUME_SNAPSHOT_DEACTIVATE_FAILED("gluster_volume_snapshot_deactivate_failed"),
    /**
     * Snapshot de-activated on the volume
     */
    GLUSTER_VOLUME_SNAPSHOT_DEACTIVATED("gluster_volume_snapshot_deactivated"),
    /**
     * Failed to delete snapshot on volume
     */
    GLUSTER_VOLUME_SNAPSHOT_DELETE_FAILED("gluster_volume_snapshot_delete_failed"),
    /**
     * Snapshot deleted on volume
     */
    GLUSTER_VOLUME_SNAPSHOT_DELETED("gluster_volume_snapshot_deleted"),
    /**
     * Failed to restore snapshot on the volume
     */
    GLUSTER_VOLUME_SNAPSHOT_RESTORE_FAILED("gluster_volume_snapshot_restore_failed"),
    /**
     * Snapshot restore on the volume
     */
    GLUSTER_VOLUME_SNAPSHOT_RESTORED("gluster_volume_snapshot_restored"),
    /**
     * Gluster volume started
     */
    GLUSTER_VOLUME_START("gluster_volume_start"),
    /**
     * Gluster Volume could not be started
     */
    GLUSTER_VOLUME_START_FAILED("gluster_volume_start_failed"),
    /**
     * Gluster volume stopped
     */
    GLUSTER_VOLUME_STOP("gluster_volume_stop"),
    /**
     * Gluster Volume could not be stopped
     */
    GLUSTER_VOLUME_STOP_FAILED("gluster_volume_stop_failed"),
    /**
     * Highly-Available VM failed
     */
    HA_VM_FAILED("ha_vm_failed"),
    /**
     * Highly-Available VM restart failed
     */
    HA_VM_RESTART_FAILED("ha_vm_restart_failed"),
    /**
     * Failed to activate Host
     */
    HOST_ACTIVATE_FAILED("host_activate_failed"),
    /**
     * Host was activated, but the Hosted Engine HA service may still be in maintenance mode
     */
    HOST_ACTIVATE_MANUAL_HA("host_activate_manual_ha"),
    /**
     * Failed to approve Host
     */
    HOST_APPROVE_FAILED("host_approve_failed"),
    /**
     * Host's slave of bond changed state to down
     */
    HOST_BOND_SLAVE_STATE_DOWN("host_bond_slave_state_down"),
    /**
     * Host's certificate contains invalid subject alternative name (SAN)
     */
    HOST_CERTIFICATE_HAS_INVALID_SAN("host_certificate_has_invalid_san"),
    /**
     * Host's certification has expired
     */
    HOST_CERTIFICATION_HAS_EXPIRED("host_certification_has_expired"),
    /**
     * Host's certification is about to expire
     */
    HOST_CERTIFICATION_IS_ABOUT_TO_EXPIRE("host_certification_is_about_to_expire"),
    /**
     * Host is non responsive
     */
    HOST_FAILURE("host_failure"),
    /**
     * Host cpu usage exceeded defined threshold
     */
    HOST_HIGH_CPU_USE("host_high_cpu_use"),
    /**
     * Host memory usage exceeded defined threshold
     */
    HOST_HIGH_MEM_USE("host_high_mem_use"),
    /**
     * Host swap memory usage exceeded defined threshold
     */
    HOST_HIGH_SWAP_USE("host_high_swap_use"),
    /**
     * Failed to restart VM on a different host
     */
    HOST_INITIATED_RUN_VM_FAILED("host_initiated_run_vm_failed"),
    /**
     * Host installation failed
     */
    HOST_INSTALL_FAILED("host_install_failed"),
    /**
     * Host network interface usage exceeded defined threshold
     */
    HOST_INTERFACE_HIGH_NETWORK_USE("host_interface_high_network_use"),
    /**
     * Host's interface changed state to down
     */
    HOST_INTERFACE_STATE_DOWN("host_interface_state_down"),
    /**
     * Host free memory is under defined threshold
     */
    HOST_LOW_MEM("host_low_mem"),
    /**
     * Host free swap memory is under defined threshold
     */
    HOST_LOW_SWAP("host_low_swap"),
    /**
     * Host failed to recover
     */
    HOST_RECOVER_FAILED("host_recover_failed"),
    /**
     * Host state was set to non-operational
     */
    HOST_SET_NONOPERATIONAL("host_set_nonoperational"),
    /**
     * Host state was set to non-operational due to inaccessible Storage Domain
     */
    HOST_SET_NONOPERATIONAL_DOMAIN("host_set_nonoperational_domain"),
    /**
     * Host state was set to non-operational due to a missing Interface
     */
    HOST_SET_NONOPERATIONAL_IFACE_DOWN("host_set_nonoperational_iface_down"),
    /**
     * Slow storage response time
     */
    HOST_SLOW_STORAGE_RESPONSE_TIME("host_slow_storage_response_time"),
    /**
     * Host has time-drift
     */
    HOST_TIME_DRIFT_ALERT("host_time_drift_alert"),
    /**
     * Host state was set to non-operational. Host is untrusted by the attestation service
     */
    HOST_UNTRUSTED("host_untrusted"),
    /**
     * Host has available updates
     */
    HOST_UPDATES_ARE_AVAILABLE("host_updates_are_available"),
    /**
     * Host has available packages to update
     */
    HOST_UPDATES_ARE_AVAILABLE_WITH_PACKAGES("host_updates_are_available_with_packages"),
    /**
     * Template imported from trusted cluster into non-trusted cluster
     */
    IMPORTEXPORT_IMPORT_TEMPLATE_FROM_TRUSTED_TO_UNTRUSTED("importexport_import_template_from_trusted_to_untrusted"),
    /**
     * Template imported from non-trusted cluster into trusted cluster
     */
    IMPORTEXPORT_IMPORT_TEMPLATE_FROM_UNTRUSTED_TO_TRUSTED("importexport_import_template_from_untrusted_to_trusted"),
    /**
     * Import VM from trusted cluster into non-trusted cluster
     */
    IMPORTEXPORT_IMPORT_VM_FROM_TRUSTED_TO_UNTRUSTED("importexport_import_vm_from_trusted_to_untrusted"),
    /**
     * Import VM from non-trusted cluster into trusted cluster
     */
    IMPORTEXPORT_IMPORT_VM_FROM_UNTRUSTED_TO_TRUSTED("importexport_import_vm_from_untrusted_to_trusted"),
    /**
     * Confirmed low disk space
     */
    IRS_CONFIRMED_DISK_SPACE_LOW("irs_confirmed_disk_space_low"),
    /**
     * Low disk space
     */
    IRS_DISK_SPACE_LOW("irs_disk_space_low"),
    /**
     * Critically low disk space
     */
    IRS_DISK_SPACE_LOW_ERROR("irs_disk_space_low_error"),
    /**
     * Failed to access Storage
     */
    IRS_FAILURE("irs_failure"),
    /**
     * VM with external MAC address
     */
    MAC_ADDRESS_IS_EXTERNAL("mac_address_is_external"),
    /**
     * Multipath devices without valid paths on host
     */
    MULTIPATH_DEVICES_WITHOUT_VALID_PATHS_ON_HOST("multipath_devices_without_valid_paths_on_host"),
    /**
     * Display network was updated on cluster with an active VM
     */
    NETWORK_UPDATE_DISPLAY_FOR_CLUSTER_WITH_ACTIVE_VM("network_update_display_for_cluster_with_active_vm"),
    /**
     * Display network was updated on host with an active VM
     */
    NETWORK_UPDATE_DISPLAY_FOR_HOST_WITH_ACTIVE_VM("network_update_display_for_host_with_active_vm"),
    /**
     * No faulty multipath paths on host
     */
    NO_FAULTY_MULTIPATHS_ON_HOST("no_faulty_multipaths_on_host"),
    /**
     * Storage Domain's number of LVs exceeded threshold
     */
    NUMBER_OF_LVS_ON_STORAGE_DOMAIN_EXCEEDED_THRESHOLD("number_of_lvs_on_storage_domain_exceeded_threshold"),
    /**
     * Could not find information for remove brick on volume from CLI. Marking it as unknown.
     */
    REMOVE_GLUSTER_VOLUME_BRICKS_NOT_FOUND_FROM_CLI("remove_gluster_volume_bricks_not_found_from_cli"),
    /**
     * Started removing bricks from Volume
     */
    START_REMOVING_GLUSTER_VOLUME_BRICKS("start_removing_gluster_volume_bricks"),
    /**
     * Detected start of brick removal for bricks on volume from CLI
     */
    START_REMOVING_GLUSTER_VOLUME_BRICKS_DETECTED_FROM_CLI("start_removing_gluster_volume_bricks_detected_from_cli"),
    /**
     * Could not remove volume bricks
     */
    START_REMOVING_GLUSTER_VOLUME_BRICKS_FAILED("start_removing_gluster_volume_bricks_failed"),
    /**
     * Failed electing an SPM for the Data-Center
     */
    SYSTEM_CHANGE_STORAGE_POOL_STATUS_NO_HOST_FOR_SPM("system_change_storage_pool_status_no_host_for_spm"),
    /**
     * Storage Domain state was set to inactive
     */
    SYSTEM_DEACTIVATED_STORAGE_DOMAIN("system_deactivated_storage_domain"),
    /**
     * A non-trusted VM was created from trusted Template
     */
    USER_ADD_VM_FROM_TRUSTED_TO_UNTRUSTED("user_add_vm_from_trusted_to_untrusted"),
    /**
     * A trusted VM was created from non-trusted Template
     */
    USER_ADD_VM_FROM_UNTRUSTED_TO_TRUSTED("user_add_vm_from_untrusted_to_trusted"),
    /**
     * A non-trusted Template was created from trusted VM
     */
    USER_ADD_VM_TEMPLATE_FROM_TRUSTED_TO_UNTRUSTED("user_add_vm_template_from_trusted_to_untrusted"),
    /**
     * A trusted Template was created from non-trusted VM
     */
    USER_ADD_VM_TEMPLATE_FROM_UNTRUSTED_TO_TRUSTED("user_add_vm_template_from_untrusted_to_trusted"),
    /**
     * Host was switched to Maintenance Mode
     */
    USER_HOST_MAINTENANCE("user_host_maintenance"),
    /**
     * Host was switched to Maintenance Mode, but Hosted Engine HA maintenance mode could not be enabled
     */
    USER_HOST_MAINTENANCE_MANUAL_HA("user_host_maintenance_manual_ha"),
    /**
     * Failed to switch Host to Maintenance mode
     */
    USER_HOST_MAINTENANCE_MIGRATION_FAILED("user_host_maintenance_migration_failed"),
    /**
     * VM moved from trusted cluster to non-trusted cluster
     */
    USER_UPDATE_VM_FROM_TRUSTED_TO_UNTRUSTED("user_update_vm_from_trusted_to_untrusted"),
    /**
     * VM moved from non-trusted cluster to trusted cluster
     */
    USER_UPDATE_VM_FROM_UNTRUSTED_TO_TRUSTED("user_update_vm_from_untrusted_to_trusted"),
    /**
     * Template moved from trusted cluster to non-trusted cluster
     */
    USER_UPDATE_VM_TEMPLATE_FROM_TRUSTED_TO_UNTRUSTED("user_update_vm_template_from_trusted_to_untrusted"),
    /**
     * Template moved from a non-trusted cluster to a trusted cluster
     */
    USER_UPDATE_VM_TEMPLATE_FROM_UNTRUSTED_TO_TRUSTED("user_update_vm_template_from_untrusted_to_trusted"),
    /**
     * VM console connected
     */
    VM_CONSOLE_CONNECTED("vm_console_connected"),
    /**
     * VM console disconnected
     */
    VM_CONSOLE_DISCONNECTED("vm_console_disconnected"),
    /**
     * VM is down with error
     */
    VM_DOWN_ERROR("vm_down_error"),
    /**
     * VM cannot be found on Host
     */
    VM_FAILURE("vm_failure"),
    /**
     * Migration failed
     */
    VM_MIGRATION_FAILED("vm_migration_failed"),
    /**
     * Starting migration of VM
     */
    VM_MIGRATION_START("vm_migration_start"),
    /**
     * Migration of VM to a destination host failed
     */
    VM_MIGRATION_TO_SERVER_FAILED("vm_migration_to_server_failed"),
    /**
     * VM is not responding
     */
    VM_NOT_RESPONDING("vm_not_responding"),
    /**
     * VM has been paused
     */
    VM_PAUSED("vm_paused"),
    /**
     * VM has been paused due to a storage I/O error
     */
    VM_PAUSED_EIO("vm_paused_eio"),
    /**
     * VM has been paused due to lack of storage space
     */
    VM_PAUSED_ENOSPC("vm_paused_enospc"),
    /**
     * VM has been paused due to storage read/write permissions problem
     */
    VM_PAUSED_EPERM("vm_paused_eperm"),
    /**
     * VM has been paused due to unknown storage error
     */
    VM_PAUSED_ERROR("vm_paused_error"),
    /**
     * VM has recovered from paused back to up
     */
    VM_RECOVERED_FROM_PAUSE_ERROR("vm_recovered_from_pause_error"),
    /**
     * VM console session initiated
     */
    VM_SET_TICKET("vm_set_ticket"),
    /**
     * VM status restored
     */
    VM_STATUS_RESTORED("vm_status_restored"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(NotifiableEvent.class);
    
    private String image;
    
    NotifiableEvent(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static NotifiableEvent fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'NotifiableEvent' enumerated type. " +
            "Valid values are 'cluster_alert_ha_reservation', 'cluster_alert_ha_reservation_down', 'dwh_error', 'dwh_stopped', 'engine_backup_completed', 'engine_backup_failed', 'engine_backup_started', 'engine_ca_certification_has_expired', 'engine_ca_certification_is_about_to_expire', 'engine_certification_has_expired', 'engine_certification_is_about_to_expire', 'engine_stop', 'faulty_multipaths_on_host', 'gluster_brick_status_changed', 'gluster_hook_add_failed', 'gluster_hook_added', 'gluster_hook_conflict_detected', 'gluster_hook_detected_delete', 'gluster_hook_detected_new', 'gluster_hook_disable', 'gluster_hook_disable_failed', 'gluster_hook_enable', 'gluster_hook_enable_failed', 'gluster_hook_remove_failed', 'gluster_hook_removed', 'gluster_server_add_failed', 'gluster_server_remove', 'gluster_server_remove_failed', 'gluster_service_restart_failed', 'gluster_service_restarted', 'gluster_service_start_failed', 'gluster_service_started', 'gluster_service_stop_failed', 'gluster_service_stopped', 'gluster_volume_add_brick', 'gluster_volume_add_brick_failed', 'gluster_volume_all_snapshots_delete_failed', 'gluster_volume_all_snapshots_deleted', 'gluster_volume_brick_replaced', 'gluster_volume_confirmed_space_low', 'gluster_volume_create', 'gluster_volume_create_failed', 'gluster_volume_delete', 'gluster_volume_delete_failed', 'gluster_volume_migrate_brick_data_finished', 'gluster_volume_option_added', 'gluster_volume_option_modified', 'gluster_volume_option_set_failed', 'gluster_volume_options_reset', 'gluster_volume_options_reset_all', 'gluster_volume_options_reset_failed', 'gluster_volume_profile_start', 'gluster_volume_profile_start_failed', 'gluster_volume_profile_stop', 'gluster_volume_profile_stop_failed', 'gluster_volume_rebalance_finished', 'gluster_volume_rebalance_not_found_from_cli', 'gluster_volume_rebalance_start', 'gluster_volume_rebalance_start_detected_from_cli', 'gluster_volume_rebalance_start_failed', 'gluster_volume_rebalance_stop', 'gluster_volume_rebalance_stop_failed', 'gluster_volume_remove_bricks', 'gluster_volume_remove_bricks_failed', 'gluster_volume_remove_bricks_stop', 'gluster_volume_remove_bricks_stop_failed', 'gluster_volume_replace_brick_failed', 'gluster_volume_replace_brick_start', 'gluster_volume_replace_brick_start_failed', 'gluster_volume_snapshot_activate_failed', 'gluster_volume_snapshot_activated', 'gluster_volume_snapshot_create_failed', 'gluster_volume_snapshot_created', 'gluster_volume_snapshot_deactivate_failed', 'gluster_volume_snapshot_deactivated', 'gluster_volume_snapshot_delete_failed', 'gluster_volume_snapshot_deleted', 'gluster_volume_snapshot_restore_failed', 'gluster_volume_snapshot_restored', 'gluster_volume_start', 'gluster_volume_start_failed', 'gluster_volume_stop', 'gluster_volume_stop_failed', 'ha_vm_failed', 'ha_vm_restart_failed', 'host_activate_failed', 'host_activate_manual_ha', 'host_approve_failed', 'host_bond_slave_state_down', 'host_certificate_has_invalid_san', 'host_certification_has_expired', 'host_certification_is_about_to_expire', 'host_failure', 'host_high_cpu_use', 'host_high_mem_use', 'host_high_swap_use', 'host_initiated_run_vm_failed', 'host_install_failed', 'host_interface_high_network_use', 'host_interface_state_down', 'host_low_mem', 'host_low_swap', 'host_recover_failed', 'host_set_nonoperational', 'host_set_nonoperational_domain', 'host_set_nonoperational_iface_down', 'host_slow_storage_response_time', 'host_time_drift_alert', 'host_untrusted', 'host_updates_are_available', 'host_updates_are_available_with_packages', 'importexport_import_template_from_trusted_to_untrusted', 'importexport_import_template_from_untrusted_to_trusted', 'importexport_import_vm_from_trusted_to_untrusted', 'importexport_import_vm_from_untrusted_to_trusted', 'irs_confirmed_disk_space_low', 'irs_disk_space_low', 'irs_disk_space_low_error', 'irs_failure', 'mac_address_is_external', 'multipath_devices_without_valid_paths_on_host', 'network_update_display_for_cluster_with_active_vm', 'network_update_display_for_host_with_active_vm', 'no_faulty_multipaths_on_host', 'number_of_lvs_on_storage_domain_exceeded_threshold', 'remove_gluster_volume_bricks_not_found_from_cli', 'start_removing_gluster_volume_bricks', 'start_removing_gluster_volume_bricks_detected_from_cli', 'start_removing_gluster_volume_bricks_failed', 'system_change_storage_pool_status_no_host_for_spm', 'system_deactivated_storage_domain', 'user_add_vm_from_trusted_to_untrusted', 'user_add_vm_from_untrusted_to_trusted', 'user_add_vm_template_from_trusted_to_untrusted', 'user_add_vm_template_from_untrusted_to_trusted', 'user_host_maintenance', 'user_host_maintenance_manual_ha', 'user_host_maintenance_migration_failed', 'user_update_vm_from_trusted_to_untrusted', 'user_update_vm_from_untrusted_to_trusted', 'user_update_vm_template_from_trusted_to_untrusted', 'user_update_vm_template_from_untrusted_to_trusted', 'vm_console_connected', 'vm_console_disconnected', 'vm_down_error', 'vm_failure', 'vm_migration_failed', 'vm_migration_start', 'vm_migration_to_server_failed', 'vm_not_responding', 'vm_paused', 'vm_paused_eio', 'vm_paused_enospc', 'vm_paused_eperm', 'vm_paused_error', 'vm_recovered_from_pause_error', 'vm_set_ticket' and 'vm_status_restored'.",
            exception
            );
            return null;
        }
    }
    
}

