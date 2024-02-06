/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.math.BigInteger;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.Qos;
import org.ovirt.engine.sdk4.types.QosType;

public class QosContainer extends IdentifiedContainer implements Qos {
    private BigInteger cpuLimit;
    private BigInteger inboundAverage;
    private BigInteger inboundBurst;
    private BigInteger inboundPeak;
    private BigInteger maxIops;
    private BigInteger maxReadIops;
    private BigInteger maxReadThroughput;
    private BigInteger maxThroughput;
    private BigInteger maxWriteIops;
    private BigInteger maxWriteThroughput;
    private BigInteger outboundAverage;
    private BigInteger outboundAverageLinkshare;
    private BigInteger outboundAverageRealtime;
    private BigInteger outboundAverageUpperlimit;
    private BigInteger outboundBurst;
    private BigInteger outboundPeak;
    private QosType type;
    private DataCenter dataCenter;
    
    public BigInteger cpuLimit() {
        return cpuLimit;
    }
    
    public Byte cpuLimitAsByte() {
        return asByte("Qos", "cpuLimit", cpuLimit);
    }
    
    public Short cpuLimitAsShort() {
        return asShort("Qos", "cpuLimit", cpuLimit);
    }
    
    public Integer cpuLimitAsInteger() {
        return asInteger("Qos", "cpuLimit", cpuLimit);
    }
    
    public Long cpuLimitAsLong() {
        return asLong("Qos", "cpuLimit", cpuLimit);
    }
    
    public void cpuLimit(BigInteger newCpuLimit) {
        cpuLimit = newCpuLimit;
    }
    
    public boolean cpuLimitPresent() {
        return cpuLimit != null;
    }
    
    public BigInteger inboundAverage() {
        return inboundAverage;
    }
    
    public Byte inboundAverageAsByte() {
        return asByte("Qos", "inboundAverage", inboundAverage);
    }
    
    public Short inboundAverageAsShort() {
        return asShort("Qos", "inboundAverage", inboundAverage);
    }
    
    public Integer inboundAverageAsInteger() {
        return asInteger("Qos", "inboundAverage", inboundAverage);
    }
    
    public Long inboundAverageAsLong() {
        return asLong("Qos", "inboundAverage", inboundAverage);
    }
    
    public void inboundAverage(BigInteger newInboundAverage) {
        inboundAverage = newInboundAverage;
    }
    
    public boolean inboundAveragePresent() {
        return inboundAverage != null;
    }
    
    public BigInteger inboundBurst() {
        return inboundBurst;
    }
    
    public Byte inboundBurstAsByte() {
        return asByte("Qos", "inboundBurst", inboundBurst);
    }
    
    public Short inboundBurstAsShort() {
        return asShort("Qos", "inboundBurst", inboundBurst);
    }
    
    public Integer inboundBurstAsInteger() {
        return asInteger("Qos", "inboundBurst", inboundBurst);
    }
    
    public Long inboundBurstAsLong() {
        return asLong("Qos", "inboundBurst", inboundBurst);
    }
    
    public void inboundBurst(BigInteger newInboundBurst) {
        inboundBurst = newInboundBurst;
    }
    
    public boolean inboundBurstPresent() {
        return inboundBurst != null;
    }
    
    public BigInteger inboundPeak() {
        return inboundPeak;
    }
    
    public Byte inboundPeakAsByte() {
        return asByte("Qos", "inboundPeak", inboundPeak);
    }
    
    public Short inboundPeakAsShort() {
        return asShort("Qos", "inboundPeak", inboundPeak);
    }
    
    public Integer inboundPeakAsInteger() {
        return asInteger("Qos", "inboundPeak", inboundPeak);
    }
    
    public Long inboundPeakAsLong() {
        return asLong("Qos", "inboundPeak", inboundPeak);
    }
    
    public void inboundPeak(BigInteger newInboundPeak) {
        inboundPeak = newInboundPeak;
    }
    
    public boolean inboundPeakPresent() {
        return inboundPeak != null;
    }
    
    public BigInteger maxIops() {
        return maxIops;
    }
    
    public Byte maxIopsAsByte() {
        return asByte("Qos", "maxIops", maxIops);
    }
    
    public Short maxIopsAsShort() {
        return asShort("Qos", "maxIops", maxIops);
    }
    
    public Integer maxIopsAsInteger() {
        return asInteger("Qos", "maxIops", maxIops);
    }
    
    public Long maxIopsAsLong() {
        return asLong("Qos", "maxIops", maxIops);
    }
    
    public void maxIops(BigInteger newMaxIops) {
        maxIops = newMaxIops;
    }
    
    public boolean maxIopsPresent() {
        return maxIops != null;
    }
    
    public BigInteger maxReadIops() {
        return maxReadIops;
    }
    
    public Byte maxReadIopsAsByte() {
        return asByte("Qos", "maxReadIops", maxReadIops);
    }
    
    public Short maxReadIopsAsShort() {
        return asShort("Qos", "maxReadIops", maxReadIops);
    }
    
    public Integer maxReadIopsAsInteger() {
        return asInteger("Qos", "maxReadIops", maxReadIops);
    }
    
    public Long maxReadIopsAsLong() {
        return asLong("Qos", "maxReadIops", maxReadIops);
    }
    
    public void maxReadIops(BigInteger newMaxReadIops) {
        maxReadIops = newMaxReadIops;
    }
    
    public boolean maxReadIopsPresent() {
        return maxReadIops != null;
    }
    
    public BigInteger maxReadThroughput() {
        return maxReadThroughput;
    }
    
    public Byte maxReadThroughputAsByte() {
        return asByte("Qos", "maxReadThroughput", maxReadThroughput);
    }
    
    public Short maxReadThroughputAsShort() {
        return asShort("Qos", "maxReadThroughput", maxReadThroughput);
    }
    
    public Integer maxReadThroughputAsInteger() {
        return asInteger("Qos", "maxReadThroughput", maxReadThroughput);
    }
    
    public Long maxReadThroughputAsLong() {
        return asLong("Qos", "maxReadThroughput", maxReadThroughput);
    }
    
    public void maxReadThroughput(BigInteger newMaxReadThroughput) {
        maxReadThroughput = newMaxReadThroughput;
    }
    
    public boolean maxReadThroughputPresent() {
        return maxReadThroughput != null;
    }
    
    public BigInteger maxThroughput() {
        return maxThroughput;
    }
    
    public Byte maxThroughputAsByte() {
        return asByte("Qos", "maxThroughput", maxThroughput);
    }
    
    public Short maxThroughputAsShort() {
        return asShort("Qos", "maxThroughput", maxThroughput);
    }
    
    public Integer maxThroughputAsInteger() {
        return asInteger("Qos", "maxThroughput", maxThroughput);
    }
    
    public Long maxThroughputAsLong() {
        return asLong("Qos", "maxThroughput", maxThroughput);
    }
    
    public void maxThroughput(BigInteger newMaxThroughput) {
        maxThroughput = newMaxThroughput;
    }
    
    public boolean maxThroughputPresent() {
        return maxThroughput != null;
    }
    
    public BigInteger maxWriteIops() {
        return maxWriteIops;
    }
    
    public Byte maxWriteIopsAsByte() {
        return asByte("Qos", "maxWriteIops", maxWriteIops);
    }
    
    public Short maxWriteIopsAsShort() {
        return asShort("Qos", "maxWriteIops", maxWriteIops);
    }
    
    public Integer maxWriteIopsAsInteger() {
        return asInteger("Qos", "maxWriteIops", maxWriteIops);
    }
    
    public Long maxWriteIopsAsLong() {
        return asLong("Qos", "maxWriteIops", maxWriteIops);
    }
    
    public void maxWriteIops(BigInteger newMaxWriteIops) {
        maxWriteIops = newMaxWriteIops;
    }
    
    public boolean maxWriteIopsPresent() {
        return maxWriteIops != null;
    }
    
    public BigInteger maxWriteThroughput() {
        return maxWriteThroughput;
    }
    
    public Byte maxWriteThroughputAsByte() {
        return asByte("Qos", "maxWriteThroughput", maxWriteThroughput);
    }
    
    public Short maxWriteThroughputAsShort() {
        return asShort("Qos", "maxWriteThroughput", maxWriteThroughput);
    }
    
    public Integer maxWriteThroughputAsInteger() {
        return asInteger("Qos", "maxWriteThroughput", maxWriteThroughput);
    }
    
    public Long maxWriteThroughputAsLong() {
        return asLong("Qos", "maxWriteThroughput", maxWriteThroughput);
    }
    
    public void maxWriteThroughput(BigInteger newMaxWriteThroughput) {
        maxWriteThroughput = newMaxWriteThroughput;
    }
    
    public boolean maxWriteThroughputPresent() {
        return maxWriteThroughput != null;
    }
    
    public BigInteger outboundAverage() {
        return outboundAverage;
    }
    
    public Byte outboundAverageAsByte() {
        return asByte("Qos", "outboundAverage", outboundAverage);
    }
    
    public Short outboundAverageAsShort() {
        return asShort("Qos", "outboundAverage", outboundAverage);
    }
    
    public Integer outboundAverageAsInteger() {
        return asInteger("Qos", "outboundAverage", outboundAverage);
    }
    
    public Long outboundAverageAsLong() {
        return asLong("Qos", "outboundAverage", outboundAverage);
    }
    
    public void outboundAverage(BigInteger newOutboundAverage) {
        outboundAverage = newOutboundAverage;
    }
    
    public boolean outboundAveragePresent() {
        return outboundAverage != null;
    }
    
    public BigInteger outboundAverageLinkshare() {
        return outboundAverageLinkshare;
    }
    
    public Byte outboundAverageLinkshareAsByte() {
        return asByte("Qos", "outboundAverageLinkshare", outboundAverageLinkshare);
    }
    
    public Short outboundAverageLinkshareAsShort() {
        return asShort("Qos", "outboundAverageLinkshare", outboundAverageLinkshare);
    }
    
    public Integer outboundAverageLinkshareAsInteger() {
        return asInteger("Qos", "outboundAverageLinkshare", outboundAverageLinkshare);
    }
    
    public Long outboundAverageLinkshareAsLong() {
        return asLong("Qos", "outboundAverageLinkshare", outboundAverageLinkshare);
    }
    
    public void outboundAverageLinkshare(BigInteger newOutboundAverageLinkshare) {
        outboundAverageLinkshare = newOutboundAverageLinkshare;
    }
    
    public boolean outboundAverageLinksharePresent() {
        return outboundAverageLinkshare != null;
    }
    
    public BigInteger outboundAverageRealtime() {
        return outboundAverageRealtime;
    }
    
    public Byte outboundAverageRealtimeAsByte() {
        return asByte("Qos", "outboundAverageRealtime", outboundAverageRealtime);
    }
    
    public Short outboundAverageRealtimeAsShort() {
        return asShort("Qos", "outboundAverageRealtime", outboundAverageRealtime);
    }
    
    public Integer outboundAverageRealtimeAsInteger() {
        return asInteger("Qos", "outboundAverageRealtime", outboundAverageRealtime);
    }
    
    public Long outboundAverageRealtimeAsLong() {
        return asLong("Qos", "outboundAverageRealtime", outboundAverageRealtime);
    }
    
    public void outboundAverageRealtime(BigInteger newOutboundAverageRealtime) {
        outboundAverageRealtime = newOutboundAverageRealtime;
    }
    
    public boolean outboundAverageRealtimePresent() {
        return outboundAverageRealtime != null;
    }
    
    public BigInteger outboundAverageUpperlimit() {
        return outboundAverageUpperlimit;
    }
    
    public Byte outboundAverageUpperlimitAsByte() {
        return asByte("Qos", "outboundAverageUpperlimit", outboundAverageUpperlimit);
    }
    
    public Short outboundAverageUpperlimitAsShort() {
        return asShort("Qos", "outboundAverageUpperlimit", outboundAverageUpperlimit);
    }
    
    public Integer outboundAverageUpperlimitAsInteger() {
        return asInteger("Qos", "outboundAverageUpperlimit", outboundAverageUpperlimit);
    }
    
    public Long outboundAverageUpperlimitAsLong() {
        return asLong("Qos", "outboundAverageUpperlimit", outboundAverageUpperlimit);
    }
    
    public void outboundAverageUpperlimit(BigInteger newOutboundAverageUpperlimit) {
        outboundAverageUpperlimit = newOutboundAverageUpperlimit;
    }
    
    public boolean outboundAverageUpperlimitPresent() {
        return outboundAverageUpperlimit != null;
    }
    
    public BigInteger outboundBurst() {
        return outboundBurst;
    }
    
    public Byte outboundBurstAsByte() {
        return asByte("Qos", "outboundBurst", outboundBurst);
    }
    
    public Short outboundBurstAsShort() {
        return asShort("Qos", "outboundBurst", outboundBurst);
    }
    
    public Integer outboundBurstAsInteger() {
        return asInteger("Qos", "outboundBurst", outboundBurst);
    }
    
    public Long outboundBurstAsLong() {
        return asLong("Qos", "outboundBurst", outboundBurst);
    }
    
    public void outboundBurst(BigInteger newOutboundBurst) {
        outboundBurst = newOutboundBurst;
    }
    
    public boolean outboundBurstPresent() {
        return outboundBurst != null;
    }
    
    public BigInteger outboundPeak() {
        return outboundPeak;
    }
    
    public Byte outboundPeakAsByte() {
        return asByte("Qos", "outboundPeak", outboundPeak);
    }
    
    public Short outboundPeakAsShort() {
        return asShort("Qos", "outboundPeak", outboundPeak);
    }
    
    public Integer outboundPeakAsInteger() {
        return asInteger("Qos", "outboundPeak", outboundPeak);
    }
    
    public Long outboundPeakAsLong() {
        return asLong("Qos", "outboundPeak", outboundPeak);
    }
    
    public void outboundPeak(BigInteger newOutboundPeak) {
        outboundPeak = newOutboundPeak;
    }
    
    public boolean outboundPeakPresent() {
        return outboundPeak != null;
    }
    
    public QosType type() {
        return type;
    }
    
    public void type(QosType newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
    }
    
    public DataCenter dataCenter() {
        return dataCenter;
    }
    
    public void dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
    }
    
    public boolean dataCenterPresent() {
        return dataCenter != null;
    }
    
}
