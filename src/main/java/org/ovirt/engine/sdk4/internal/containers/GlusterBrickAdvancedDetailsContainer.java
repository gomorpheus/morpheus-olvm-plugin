/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.types.GlusterBrickAdvancedDetails;
import org.ovirt.engine.sdk4.types.GlusterClient;
import org.ovirt.engine.sdk4.types.GlusterMemoryPool;

public class GlusterBrickAdvancedDetailsContainer extends DeviceContainer implements GlusterBrickAdvancedDetails {
    private String device;
    private String fsName;
    private List<GlusterClient> glusterClients;
    private List<GlusterMemoryPool> memoryPools;
    private String mntOptions;
    private BigInteger pid;
    private BigInteger port;
    
    public String device() {
        return device;
    }
    
    public void device(String newDevice) {
        device = newDevice;
    }
    
    public boolean devicePresent() {
        return device != null;
    }
    
    public String fsName() {
        return fsName;
    }
    
    public void fsName(String newFsName) {
        fsName = newFsName;
    }
    
    public boolean fsNamePresent() {
        return fsName != null;
    }
    
    public List<GlusterClient> glusterClients() {
        return makeUnmodifiableList(glusterClients);
    }
    
    public void glusterClients(List<GlusterClient> newGlusterClients) {
        glusterClients = makeArrayList(newGlusterClients);
    }
    
    public boolean glusterClientsPresent() {
        return glusterClients != null && !glusterClients.isEmpty();
    }
    
    public List<GlusterMemoryPool> memoryPools() {
        return makeUnmodifiableList(memoryPools);
    }
    
    public void memoryPools(List<GlusterMemoryPool> newMemoryPools) {
        memoryPools = makeArrayList(newMemoryPools);
    }
    
    public boolean memoryPoolsPresent() {
        return memoryPools != null && !memoryPools.isEmpty();
    }
    
    public String mntOptions() {
        return mntOptions;
    }
    
    public void mntOptions(String newMntOptions) {
        mntOptions = newMntOptions;
    }
    
    public boolean mntOptionsPresent() {
        return mntOptions != null;
    }
    
    public BigInteger pid() {
        return pid;
    }
    
    public Byte pidAsByte() {
        return asByte("GlusterBrickAdvancedDetails", "pid", pid);
    }
    
    public Short pidAsShort() {
        return asShort("GlusterBrickAdvancedDetails", "pid", pid);
    }
    
    public Integer pidAsInteger() {
        return asInteger("GlusterBrickAdvancedDetails", "pid", pid);
    }
    
    public Long pidAsLong() {
        return asLong("GlusterBrickAdvancedDetails", "pid", pid);
    }
    
    public void pid(BigInteger newPid) {
        pid = newPid;
    }
    
    public boolean pidPresent() {
        return pid != null;
    }
    
    public BigInteger port() {
        return port;
    }
    
    public Byte portAsByte() {
        return asByte("GlusterBrickAdvancedDetails", "port", port);
    }
    
    public Short portAsShort() {
        return asShort("GlusterBrickAdvancedDetails", "port", port);
    }
    
    public Integer portAsInteger() {
        return asInteger("GlusterBrickAdvancedDetails", "port", port);
    }
    
    public Long portAsLong() {
        return asLong("GlusterBrickAdvancedDetails", "port", port);
    }
    
    public void port(BigInteger newPort) {
        port = newPort;
    }
    
    public boolean portPresent() {
        return port != null;
    }
    
}
