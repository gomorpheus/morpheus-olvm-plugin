/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.math.BigInteger;
import org.ovirt.engine.sdk4.internal.containers.QosContainer;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.Qos;
import org.ovirt.engine.sdk4.types.QosType;

public class QosBuilder {
    private String comment;
    private BigInteger cpuLimit;
    private DataCenter dataCenter;
    private String description;
    private String href;
    private String id;
    private BigInteger inboundAverage;
    private BigInteger inboundBurst;
    private BigInteger inboundPeak;
    private BigInteger maxIops;
    private BigInteger maxReadIops;
    private BigInteger maxReadThroughput;
    private BigInteger maxThroughput;
    private BigInteger maxWriteIops;
    private BigInteger maxWriteThroughput;
    private String name;
    private BigInteger outboundAverage;
    private BigInteger outboundAverageLinkshare;
    private BigInteger outboundAverageRealtime;
    private BigInteger outboundAverageUpperlimit;
    private BigInteger outboundBurst;
    private BigInteger outboundPeak;
    private QosType type;
    
    public QosBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public QosBuilder cpuLimit(int newCpuLimit) {
        cpuLimit = BigInteger.valueOf((long) newCpuLimit);
        return this;
    }
    
    public QosBuilder cpuLimit(Integer newCpuLimit) {
        if (newCpuLimit == null) {
            cpuLimit = null;
        }
        else {
            cpuLimit = BigInteger.valueOf(newCpuLimit.longValue());
        }
        return this;
    }
    
    public QosBuilder cpuLimit(long newCpuLimit) {
        cpuLimit = BigInteger.valueOf(newCpuLimit);
        return this;
    }
    
    public QosBuilder cpuLimit(Long newCpuLimit) {
        if (newCpuLimit == null) {
            cpuLimit = null;
        }
        else {
            cpuLimit = BigInteger.valueOf(newCpuLimit.longValue());
        }
        return this;
    }
    
    public QosBuilder cpuLimit(BigInteger newCpuLimit) {
        cpuLimit = newCpuLimit;
        return this;
    }
    
    
    public QosBuilder dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
        return this;
    }
    
    public QosBuilder dataCenter(DataCenterBuilder newDataCenter) {
        if (newDataCenter == null) {
            dataCenter = null;
        }
        else {
            dataCenter = newDataCenter.build();
        }
        return this;
    }
    
    
    public QosBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public QosBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public QosBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public QosBuilder inboundAverage(int newInboundAverage) {
        inboundAverage = BigInteger.valueOf((long) newInboundAverage);
        return this;
    }
    
    public QosBuilder inboundAverage(Integer newInboundAverage) {
        if (newInboundAverage == null) {
            inboundAverage = null;
        }
        else {
            inboundAverage = BigInteger.valueOf(newInboundAverage.longValue());
        }
        return this;
    }
    
    public QosBuilder inboundAverage(long newInboundAverage) {
        inboundAverage = BigInteger.valueOf(newInboundAverage);
        return this;
    }
    
    public QosBuilder inboundAverage(Long newInboundAverage) {
        if (newInboundAverage == null) {
            inboundAverage = null;
        }
        else {
            inboundAverage = BigInteger.valueOf(newInboundAverage.longValue());
        }
        return this;
    }
    
    public QosBuilder inboundAverage(BigInteger newInboundAverage) {
        inboundAverage = newInboundAverage;
        return this;
    }
    
    
    public QosBuilder inboundBurst(int newInboundBurst) {
        inboundBurst = BigInteger.valueOf((long) newInboundBurst);
        return this;
    }
    
    public QosBuilder inboundBurst(Integer newInboundBurst) {
        if (newInboundBurst == null) {
            inboundBurst = null;
        }
        else {
            inboundBurst = BigInteger.valueOf(newInboundBurst.longValue());
        }
        return this;
    }
    
    public QosBuilder inboundBurst(long newInboundBurst) {
        inboundBurst = BigInteger.valueOf(newInboundBurst);
        return this;
    }
    
    public QosBuilder inboundBurst(Long newInboundBurst) {
        if (newInboundBurst == null) {
            inboundBurst = null;
        }
        else {
            inboundBurst = BigInteger.valueOf(newInboundBurst.longValue());
        }
        return this;
    }
    
    public QosBuilder inboundBurst(BigInteger newInboundBurst) {
        inboundBurst = newInboundBurst;
        return this;
    }
    
    
    public QosBuilder inboundPeak(int newInboundPeak) {
        inboundPeak = BigInteger.valueOf((long) newInboundPeak);
        return this;
    }
    
    public QosBuilder inboundPeak(Integer newInboundPeak) {
        if (newInboundPeak == null) {
            inboundPeak = null;
        }
        else {
            inboundPeak = BigInteger.valueOf(newInboundPeak.longValue());
        }
        return this;
    }
    
    public QosBuilder inboundPeak(long newInboundPeak) {
        inboundPeak = BigInteger.valueOf(newInboundPeak);
        return this;
    }
    
    public QosBuilder inboundPeak(Long newInboundPeak) {
        if (newInboundPeak == null) {
            inboundPeak = null;
        }
        else {
            inboundPeak = BigInteger.valueOf(newInboundPeak.longValue());
        }
        return this;
    }
    
    public QosBuilder inboundPeak(BigInteger newInboundPeak) {
        inboundPeak = newInboundPeak;
        return this;
    }
    
    
    public QosBuilder maxIops(int newMaxIops) {
        maxIops = BigInteger.valueOf((long) newMaxIops);
        return this;
    }
    
    public QosBuilder maxIops(Integer newMaxIops) {
        if (newMaxIops == null) {
            maxIops = null;
        }
        else {
            maxIops = BigInteger.valueOf(newMaxIops.longValue());
        }
        return this;
    }
    
    public QosBuilder maxIops(long newMaxIops) {
        maxIops = BigInteger.valueOf(newMaxIops);
        return this;
    }
    
    public QosBuilder maxIops(Long newMaxIops) {
        if (newMaxIops == null) {
            maxIops = null;
        }
        else {
            maxIops = BigInteger.valueOf(newMaxIops.longValue());
        }
        return this;
    }
    
    public QosBuilder maxIops(BigInteger newMaxIops) {
        maxIops = newMaxIops;
        return this;
    }
    
    
    public QosBuilder maxReadIops(int newMaxReadIops) {
        maxReadIops = BigInteger.valueOf((long) newMaxReadIops);
        return this;
    }
    
    public QosBuilder maxReadIops(Integer newMaxReadIops) {
        if (newMaxReadIops == null) {
            maxReadIops = null;
        }
        else {
            maxReadIops = BigInteger.valueOf(newMaxReadIops.longValue());
        }
        return this;
    }
    
    public QosBuilder maxReadIops(long newMaxReadIops) {
        maxReadIops = BigInteger.valueOf(newMaxReadIops);
        return this;
    }
    
    public QosBuilder maxReadIops(Long newMaxReadIops) {
        if (newMaxReadIops == null) {
            maxReadIops = null;
        }
        else {
            maxReadIops = BigInteger.valueOf(newMaxReadIops.longValue());
        }
        return this;
    }
    
    public QosBuilder maxReadIops(BigInteger newMaxReadIops) {
        maxReadIops = newMaxReadIops;
        return this;
    }
    
    
    public QosBuilder maxReadThroughput(int newMaxReadThroughput) {
        maxReadThroughput = BigInteger.valueOf((long) newMaxReadThroughput);
        return this;
    }
    
    public QosBuilder maxReadThroughput(Integer newMaxReadThroughput) {
        if (newMaxReadThroughput == null) {
            maxReadThroughput = null;
        }
        else {
            maxReadThroughput = BigInteger.valueOf(newMaxReadThroughput.longValue());
        }
        return this;
    }
    
    public QosBuilder maxReadThroughput(long newMaxReadThroughput) {
        maxReadThroughput = BigInteger.valueOf(newMaxReadThroughput);
        return this;
    }
    
    public QosBuilder maxReadThroughput(Long newMaxReadThroughput) {
        if (newMaxReadThroughput == null) {
            maxReadThroughput = null;
        }
        else {
            maxReadThroughput = BigInteger.valueOf(newMaxReadThroughput.longValue());
        }
        return this;
    }
    
    public QosBuilder maxReadThroughput(BigInteger newMaxReadThroughput) {
        maxReadThroughput = newMaxReadThroughput;
        return this;
    }
    
    
    public QosBuilder maxThroughput(int newMaxThroughput) {
        maxThroughput = BigInteger.valueOf((long) newMaxThroughput);
        return this;
    }
    
    public QosBuilder maxThroughput(Integer newMaxThroughput) {
        if (newMaxThroughput == null) {
            maxThroughput = null;
        }
        else {
            maxThroughput = BigInteger.valueOf(newMaxThroughput.longValue());
        }
        return this;
    }
    
    public QosBuilder maxThroughput(long newMaxThroughput) {
        maxThroughput = BigInteger.valueOf(newMaxThroughput);
        return this;
    }
    
    public QosBuilder maxThroughput(Long newMaxThroughput) {
        if (newMaxThroughput == null) {
            maxThroughput = null;
        }
        else {
            maxThroughput = BigInteger.valueOf(newMaxThroughput.longValue());
        }
        return this;
    }
    
    public QosBuilder maxThroughput(BigInteger newMaxThroughput) {
        maxThroughput = newMaxThroughput;
        return this;
    }
    
    
    public QosBuilder maxWriteIops(int newMaxWriteIops) {
        maxWriteIops = BigInteger.valueOf((long) newMaxWriteIops);
        return this;
    }
    
    public QosBuilder maxWriteIops(Integer newMaxWriteIops) {
        if (newMaxWriteIops == null) {
            maxWriteIops = null;
        }
        else {
            maxWriteIops = BigInteger.valueOf(newMaxWriteIops.longValue());
        }
        return this;
    }
    
    public QosBuilder maxWriteIops(long newMaxWriteIops) {
        maxWriteIops = BigInteger.valueOf(newMaxWriteIops);
        return this;
    }
    
    public QosBuilder maxWriteIops(Long newMaxWriteIops) {
        if (newMaxWriteIops == null) {
            maxWriteIops = null;
        }
        else {
            maxWriteIops = BigInteger.valueOf(newMaxWriteIops.longValue());
        }
        return this;
    }
    
    public QosBuilder maxWriteIops(BigInteger newMaxWriteIops) {
        maxWriteIops = newMaxWriteIops;
        return this;
    }
    
    
    public QosBuilder maxWriteThroughput(int newMaxWriteThroughput) {
        maxWriteThroughput = BigInteger.valueOf((long) newMaxWriteThroughput);
        return this;
    }
    
    public QosBuilder maxWriteThroughput(Integer newMaxWriteThroughput) {
        if (newMaxWriteThroughput == null) {
            maxWriteThroughput = null;
        }
        else {
            maxWriteThroughput = BigInteger.valueOf(newMaxWriteThroughput.longValue());
        }
        return this;
    }
    
    public QosBuilder maxWriteThroughput(long newMaxWriteThroughput) {
        maxWriteThroughput = BigInteger.valueOf(newMaxWriteThroughput);
        return this;
    }
    
    public QosBuilder maxWriteThroughput(Long newMaxWriteThroughput) {
        if (newMaxWriteThroughput == null) {
            maxWriteThroughput = null;
        }
        else {
            maxWriteThroughput = BigInteger.valueOf(newMaxWriteThroughput.longValue());
        }
        return this;
    }
    
    public QosBuilder maxWriteThroughput(BigInteger newMaxWriteThroughput) {
        maxWriteThroughput = newMaxWriteThroughput;
        return this;
    }
    
    
    public QosBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public QosBuilder outboundAverage(int newOutboundAverage) {
        outboundAverage = BigInteger.valueOf((long) newOutboundAverage);
        return this;
    }
    
    public QosBuilder outboundAverage(Integer newOutboundAverage) {
        if (newOutboundAverage == null) {
            outboundAverage = null;
        }
        else {
            outboundAverage = BigInteger.valueOf(newOutboundAverage.longValue());
        }
        return this;
    }
    
    public QosBuilder outboundAverage(long newOutboundAverage) {
        outboundAverage = BigInteger.valueOf(newOutboundAverage);
        return this;
    }
    
    public QosBuilder outboundAverage(Long newOutboundAverage) {
        if (newOutboundAverage == null) {
            outboundAverage = null;
        }
        else {
            outboundAverage = BigInteger.valueOf(newOutboundAverage.longValue());
        }
        return this;
    }
    
    public QosBuilder outboundAverage(BigInteger newOutboundAverage) {
        outboundAverage = newOutboundAverage;
        return this;
    }
    
    
    public QosBuilder outboundAverageLinkshare(int newOutboundAverageLinkshare) {
        outboundAverageLinkshare = BigInteger.valueOf((long) newOutboundAverageLinkshare);
        return this;
    }
    
    public QosBuilder outboundAverageLinkshare(Integer newOutboundAverageLinkshare) {
        if (newOutboundAverageLinkshare == null) {
            outboundAverageLinkshare = null;
        }
        else {
            outboundAverageLinkshare = BigInteger.valueOf(newOutboundAverageLinkshare.longValue());
        }
        return this;
    }
    
    public QosBuilder outboundAverageLinkshare(long newOutboundAverageLinkshare) {
        outboundAverageLinkshare = BigInteger.valueOf(newOutboundAverageLinkshare);
        return this;
    }
    
    public QosBuilder outboundAverageLinkshare(Long newOutboundAverageLinkshare) {
        if (newOutboundAverageLinkshare == null) {
            outboundAverageLinkshare = null;
        }
        else {
            outboundAverageLinkshare = BigInteger.valueOf(newOutboundAverageLinkshare.longValue());
        }
        return this;
    }
    
    public QosBuilder outboundAverageLinkshare(BigInteger newOutboundAverageLinkshare) {
        outboundAverageLinkshare = newOutboundAverageLinkshare;
        return this;
    }
    
    
    public QosBuilder outboundAverageRealtime(int newOutboundAverageRealtime) {
        outboundAverageRealtime = BigInteger.valueOf((long) newOutboundAverageRealtime);
        return this;
    }
    
    public QosBuilder outboundAverageRealtime(Integer newOutboundAverageRealtime) {
        if (newOutboundAverageRealtime == null) {
            outboundAverageRealtime = null;
        }
        else {
            outboundAverageRealtime = BigInteger.valueOf(newOutboundAverageRealtime.longValue());
        }
        return this;
    }
    
    public QosBuilder outboundAverageRealtime(long newOutboundAverageRealtime) {
        outboundAverageRealtime = BigInteger.valueOf(newOutboundAverageRealtime);
        return this;
    }
    
    public QosBuilder outboundAverageRealtime(Long newOutboundAverageRealtime) {
        if (newOutboundAverageRealtime == null) {
            outboundAverageRealtime = null;
        }
        else {
            outboundAverageRealtime = BigInteger.valueOf(newOutboundAverageRealtime.longValue());
        }
        return this;
    }
    
    public QosBuilder outboundAverageRealtime(BigInteger newOutboundAverageRealtime) {
        outboundAverageRealtime = newOutboundAverageRealtime;
        return this;
    }
    
    
    public QosBuilder outboundAverageUpperlimit(int newOutboundAverageUpperlimit) {
        outboundAverageUpperlimit = BigInteger.valueOf((long) newOutboundAverageUpperlimit);
        return this;
    }
    
    public QosBuilder outboundAverageUpperlimit(Integer newOutboundAverageUpperlimit) {
        if (newOutboundAverageUpperlimit == null) {
            outboundAverageUpperlimit = null;
        }
        else {
            outboundAverageUpperlimit = BigInteger.valueOf(newOutboundAverageUpperlimit.longValue());
        }
        return this;
    }
    
    public QosBuilder outboundAverageUpperlimit(long newOutboundAverageUpperlimit) {
        outboundAverageUpperlimit = BigInteger.valueOf(newOutboundAverageUpperlimit);
        return this;
    }
    
    public QosBuilder outboundAverageUpperlimit(Long newOutboundAverageUpperlimit) {
        if (newOutboundAverageUpperlimit == null) {
            outboundAverageUpperlimit = null;
        }
        else {
            outboundAverageUpperlimit = BigInteger.valueOf(newOutboundAverageUpperlimit.longValue());
        }
        return this;
    }
    
    public QosBuilder outboundAverageUpperlimit(BigInteger newOutboundAverageUpperlimit) {
        outboundAverageUpperlimit = newOutboundAverageUpperlimit;
        return this;
    }
    
    
    public QosBuilder outboundBurst(int newOutboundBurst) {
        outboundBurst = BigInteger.valueOf((long) newOutboundBurst);
        return this;
    }
    
    public QosBuilder outboundBurst(Integer newOutboundBurst) {
        if (newOutboundBurst == null) {
            outboundBurst = null;
        }
        else {
            outboundBurst = BigInteger.valueOf(newOutboundBurst.longValue());
        }
        return this;
    }
    
    public QosBuilder outboundBurst(long newOutboundBurst) {
        outboundBurst = BigInteger.valueOf(newOutboundBurst);
        return this;
    }
    
    public QosBuilder outboundBurst(Long newOutboundBurst) {
        if (newOutboundBurst == null) {
            outboundBurst = null;
        }
        else {
            outboundBurst = BigInteger.valueOf(newOutboundBurst.longValue());
        }
        return this;
    }
    
    public QosBuilder outboundBurst(BigInteger newOutboundBurst) {
        outboundBurst = newOutboundBurst;
        return this;
    }
    
    
    public QosBuilder outboundPeak(int newOutboundPeak) {
        outboundPeak = BigInteger.valueOf((long) newOutboundPeak);
        return this;
    }
    
    public QosBuilder outboundPeak(Integer newOutboundPeak) {
        if (newOutboundPeak == null) {
            outboundPeak = null;
        }
        else {
            outboundPeak = BigInteger.valueOf(newOutboundPeak.longValue());
        }
        return this;
    }
    
    public QosBuilder outboundPeak(long newOutboundPeak) {
        outboundPeak = BigInteger.valueOf(newOutboundPeak);
        return this;
    }
    
    public QosBuilder outboundPeak(Long newOutboundPeak) {
        if (newOutboundPeak == null) {
            outboundPeak = null;
        }
        else {
            outboundPeak = BigInteger.valueOf(newOutboundPeak.longValue());
        }
        return this;
    }
    
    public QosBuilder outboundPeak(BigInteger newOutboundPeak) {
        outboundPeak = newOutboundPeak;
        return this;
    }
    
    
    public QosBuilder type(QosType newType) {
        type = newType;
        return this;
    }
    
    
    public Qos build() {
        QosContainer container = new QosContainer();
        container.comment(comment);
        container.cpuLimit(cpuLimit);
        container.dataCenter(dataCenter);
        container.description(description);
        container.href(href);
        container.id(id);
        container.inboundAverage(inboundAverage);
        container.inboundBurst(inboundBurst);
        container.inboundPeak(inboundPeak);
        container.maxIops(maxIops);
        container.maxReadIops(maxReadIops);
        container.maxReadThroughput(maxReadThroughput);
        container.maxThroughput(maxThroughput);
        container.maxWriteIops(maxWriteIops);
        container.maxWriteThroughput(maxWriteThroughput);
        container.name(name);
        container.outboundAverage(outboundAverage);
        container.outboundAverageLinkshare(outboundAverageLinkshare);
        container.outboundAverageRealtime(outboundAverageRealtime);
        container.outboundAverageUpperlimit(outboundAverageUpperlimit);
        container.outboundBurst(outboundBurst);
        container.outboundPeak(outboundPeak);
        container.type(type);
        return container;
    }
}
