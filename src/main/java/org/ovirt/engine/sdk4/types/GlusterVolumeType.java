/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Type representing the type of Gluster Volume.
 */
public enum GlusterVolumeType {
    /**
     * Dispersed volumes are based on erasure codes, providing space-efficient protection against disk or server
     * failures.
     * 
     * Dispersed volumes an encoded fragment of the original file to each brick in a way that only a subset of the
     * fragments is needed to recover the original file. The number of bricks that can be missing without losing access
     * to data is configured by the administrator on volume creation time.
     */
    DISPERSE("disperse"),
    /**
     * Distributed volumes distributes files throughout the bricks in the volume.
     * 
     * Distributed volumes can be used where the requirement is to scale storage and the redundancy is either not
     * important or is provided by other hardware/software layers.
     */
    DISTRIBUTE("distribute"),
    /**
     * Distributed dispersed volumes distribute files across dispersed subvolumes.
     * 
     * This has the same advantages of distribute replicate volumes, but using disperse to store the data into the
     * bricks.
     */
    DISTRIBUTED_DISPERSE("distributed_disperse"),
    /**
     * Distributed replicated volumes distributes files across replicated bricks in the volume.
     * 
     * Distributed replicated volumes can be used in environments where the requirement is to scale storage and
     * high-reliability is critical. Distributed replicated volumes also offer improved read performance in most
     * environments.
     */
    DISTRIBUTED_REPLICATE("distributed_replicate"),
    /**
     * Distributed striped volumes stripe data across two or more nodes in the cluster.
     * 
     * Distributed striped volumes should be used where the requirement is to scale storage and in high concurrency
     * environments accessing very large files is critical.
     * 
     * Note: With the introduction of Sharding in Glusterfs 3.7 releases, striped volumes are not recommended and it
     * will be removed in future release.
     */
    DISTRIBUTED_STRIPE("distributed_stripe"),
    /**
     * Distributed striped replicated volumes distributes striped data across replicated bricks in the cluster.
     * 
     * For best results, distributed striped replicated volumes should be used in highly concurrent environments where
     * parallel access of very large files and performance is critical.
     * 
     * Note: With the introduction of Sharding in Glusterfs 3.7 releases, striped volumes are not recommended and it
     * will be removed in future release.
     */
    DISTRIBUTED_STRIPED_REPLICATE("distributed_striped_replicate"),
    /**
     * Replicated volumes replicates files across bricks in the volume.
     * 
     * Replicated volumes can be used in environments where high-availability and high-reliability are critical.
     */
    REPLICATE("replicate"),
    /**
     * Striped volumes stripes data across bricks in the volume.
     * 
     * For best results, striped volumes should only in high concurrency environments accessing very large files.
     * 
     * Note: With the introduction of Sharding in Glusterfs 3.7 releases, striped volumes are not recommended and it
     * will be removed in future release.
     */
    STRIPE("stripe"),
    /**
     * Striped replicated volumes stripes data across replicated bricks in the cluster.
     * 
     * For best results, striped replicated volumes should be used in highly concurrent environments where there is
     * parallel access of very large files and performance is critical.
     * 
     * Note: With the introduction of Sharding in Glusterfs 3.7 releases, striped volumes are not recommended and it
     * will be removed in future release.
     */
    STRIPED_REPLICATE("striped_replicate"),
    ;
    
    private static final Logger log = LoggerFactory.getLogger(GlusterVolumeType.class);
    
    private String image;
    
    GlusterVolumeType(String image) {
        this.image = image;
    }
    
    public String value() {
        return image;
    }
    
    public static GlusterVolumeType fromValue(String value) {
        try {
            return valueOf(value.toUpperCase());
        }
        catch (IllegalArgumentException exception) {
            log.error(
            "The string '" + value + "' isn't a valid value for the 'GlusterVolumeType' enumerated type. " +
            "Valid values are 'disperse', 'distribute', 'distributed_disperse', 'distributed_replicate', 'distributed_stripe', 'distributed_striped_replicate', 'replicate', 'stripe' and 'striped_replicate'.",
            exception
            );
            return null;
        }
    }
    
}

