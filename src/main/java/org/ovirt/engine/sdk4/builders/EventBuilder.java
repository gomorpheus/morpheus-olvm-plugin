/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.Date;
import org.ovirt.engine.sdk4.internal.containers.EventContainer;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.Event;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.LogSeverity;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.User;
import org.ovirt.engine.sdk4.types.Vm;

public class EventBuilder {
    private Cluster cluster;
    private BigInteger code;
    private String comment;
    private String correlationId;
    private String customData;
    private BigInteger customId;
    private DataCenter dataCenter;
    private String description;
    private BigInteger floodRate;
    private Host host;
    private String href;
    private String id;
    private BigInteger index;
    private Boolean logOnHost;
    private String name;
    private String origin;
    private LogSeverity severity;
    private StorageDomain storageDomain;
    private Template template;
    private Date time;
    private User user;
    private Vm vm;
    
    public EventBuilder cluster(Cluster newCluster) {
        cluster = newCluster;
        return this;
    }
    
    public EventBuilder cluster(ClusterBuilder newCluster) {
        if (newCluster == null) {
            cluster = null;
        }
        else {
            cluster = newCluster.build();
        }
        return this;
    }
    
    
    public EventBuilder code(int newCode) {
        code = BigInteger.valueOf((long) newCode);
        return this;
    }
    
    public EventBuilder code(Integer newCode) {
        if (newCode == null) {
            code = null;
        }
        else {
            code = BigInteger.valueOf(newCode.longValue());
        }
        return this;
    }
    
    public EventBuilder code(long newCode) {
        code = BigInteger.valueOf(newCode);
        return this;
    }
    
    public EventBuilder code(Long newCode) {
        if (newCode == null) {
            code = null;
        }
        else {
            code = BigInteger.valueOf(newCode.longValue());
        }
        return this;
    }
    
    public EventBuilder code(BigInteger newCode) {
        code = newCode;
        return this;
    }
    
    
    public EventBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public EventBuilder correlationId(String newCorrelationId) {
        correlationId = newCorrelationId;
        return this;
    }
    
    
    public EventBuilder customData(String newCustomData) {
        customData = newCustomData;
        return this;
    }
    
    
    public EventBuilder customId(int newCustomId) {
        customId = BigInteger.valueOf((long) newCustomId);
        return this;
    }
    
    public EventBuilder customId(Integer newCustomId) {
        if (newCustomId == null) {
            customId = null;
        }
        else {
            customId = BigInteger.valueOf(newCustomId.longValue());
        }
        return this;
    }
    
    public EventBuilder customId(long newCustomId) {
        customId = BigInteger.valueOf(newCustomId);
        return this;
    }
    
    public EventBuilder customId(Long newCustomId) {
        if (newCustomId == null) {
            customId = null;
        }
        else {
            customId = BigInteger.valueOf(newCustomId.longValue());
        }
        return this;
    }
    
    public EventBuilder customId(BigInteger newCustomId) {
        customId = newCustomId;
        return this;
    }
    
    
    public EventBuilder dataCenter(DataCenter newDataCenter) {
        dataCenter = newDataCenter;
        return this;
    }
    
    public EventBuilder dataCenter(DataCenterBuilder newDataCenter) {
        if (newDataCenter == null) {
            dataCenter = null;
        }
        else {
            dataCenter = newDataCenter.build();
        }
        return this;
    }
    
    
    public EventBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public EventBuilder floodRate(int newFloodRate) {
        floodRate = BigInteger.valueOf((long) newFloodRate);
        return this;
    }
    
    public EventBuilder floodRate(Integer newFloodRate) {
        if (newFloodRate == null) {
            floodRate = null;
        }
        else {
            floodRate = BigInteger.valueOf(newFloodRate.longValue());
        }
        return this;
    }
    
    public EventBuilder floodRate(long newFloodRate) {
        floodRate = BigInteger.valueOf(newFloodRate);
        return this;
    }
    
    public EventBuilder floodRate(Long newFloodRate) {
        if (newFloodRate == null) {
            floodRate = null;
        }
        else {
            floodRate = BigInteger.valueOf(newFloodRate.longValue());
        }
        return this;
    }
    
    public EventBuilder floodRate(BigInteger newFloodRate) {
        floodRate = newFloodRate;
        return this;
    }
    
    
    public EventBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public EventBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public EventBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public EventBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public EventBuilder index(int newIndex) {
        index = BigInteger.valueOf((long) newIndex);
        return this;
    }
    
    public EventBuilder index(Integer newIndex) {
        if (newIndex == null) {
            index = null;
        }
        else {
            index = BigInteger.valueOf(newIndex.longValue());
        }
        return this;
    }
    
    public EventBuilder index(long newIndex) {
        index = BigInteger.valueOf(newIndex);
        return this;
    }
    
    public EventBuilder index(Long newIndex) {
        if (newIndex == null) {
            index = null;
        }
        else {
            index = BigInteger.valueOf(newIndex.longValue());
        }
        return this;
    }
    
    public EventBuilder index(BigInteger newIndex) {
        index = newIndex;
        return this;
    }
    
    
    public EventBuilder logOnHost(boolean newLogOnHost) {
        logOnHost = Boolean.valueOf(newLogOnHost);
        return this;
    }
    
    public EventBuilder logOnHost(Boolean newLogOnHost) {
        logOnHost = newLogOnHost;
        return this;
    }
    
    
    public EventBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public EventBuilder origin(String newOrigin) {
        origin = newOrigin;
        return this;
    }
    
    
    public EventBuilder severity(LogSeverity newSeverity) {
        severity = newSeverity;
        return this;
    }
    
    
    public EventBuilder storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
        return this;
    }
    
    public EventBuilder storageDomain(StorageDomainBuilder newStorageDomain) {
        if (newStorageDomain == null) {
            storageDomain = null;
        }
        else {
            storageDomain = newStorageDomain.build();
        }
        return this;
    }
    
    
    public EventBuilder template(Template newTemplate) {
        template = newTemplate;
        return this;
    }
    
    public EventBuilder template(TemplateBuilder newTemplate) {
        if (newTemplate == null) {
            template = null;
        }
        else {
            template = newTemplate.build();
        }
        return this;
    }
    
    
    public EventBuilder time(Date newTime) {
        if (newTime == null) {
            time = null;
        }
        else {
            time = new Date(newTime.getTime());
        }
        return this;
    }
    
    
    public EventBuilder user(User newUser) {
        user = newUser;
        return this;
    }
    
    public EventBuilder user(UserBuilder newUser) {
        if (newUser == null) {
            user = null;
        }
        else {
            user = newUser.build();
        }
        return this;
    }
    
    
    public EventBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public EventBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public Event build() {
        EventContainer container = new EventContainer();
        container.cluster(cluster);
        container.code(code);
        container.comment(comment);
        container.correlationId(correlationId);
        container.customData(customData);
        container.customId(customId);
        container.dataCenter(dataCenter);
        container.description(description);
        container.floodRate(floodRate);
        container.host(host);
        container.href(href);
        container.id(id);
        container.index(index);
        container.logOnHost(logOnHost);
        container.name(name);
        container.origin(origin);
        container.severity(severity);
        container.storageDomain(storageDomain);
        container.template(template);
        container.time(time);
        container.user(user);
        container.vm(vm);
        return container;
    }
}
