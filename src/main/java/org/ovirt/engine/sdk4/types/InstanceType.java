/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;


/**
 * Describes the hardware configuration of virtual machines.
 * 
 * For example `medium` instance type includes 1 virtual CPU and 4 GiB of memory. It is a top-level
 * entity (e.g. not bound to any data center or cluster). The attributes that are used for instance
 * types and are common to virtual machine and template types are:
 * 
 * - `console`
 * - `cpu`
 * - `custom_cpu_model`
 * - `custom_emulated_machine`
 * - `display`
 * - `high_availability`
 * - `io`
 * - `memory`
 * - `memory_policy`
 * - `migration`
 * - `migration_downtime`
 * - `os`
 * - `rng_device`
 * - `soundcard_enabled`
 * - `usb`
 * - `virtio_scsi`
 * 
 * When creating a virtual machine from both an instance type and a template, the virtual machine
 * will inherit the hardware configurations from the instance type
 * 
 * NOTE: An instance type inherits it's attributes from the template entity although most template
 * attributes are not used in instance types.
 */
public interface InstanceType extends Template {
}
