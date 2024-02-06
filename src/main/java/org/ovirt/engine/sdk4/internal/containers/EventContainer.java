/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.math.BigInteger;
import java.util.Date;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.DataCenter;
import org.ovirt.engine.sdk4.types.Event;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.LogSeverity;
import org.ovirt.engine.sdk4.types.StorageDomain;
import org.ovirt.engine.sdk4.types.Template;
import org.ovirt.engine.sdk4.types.User;
import org.ovirt.engine.sdk4.types.Vm;

public class EventContainer extends IdentifiedContainer implements Event {
    private BigInteger code;
    private String correlationId;
    private String customData;
    private BigInteger customId;
    private BigInteger floodRate;
    private BigInteger index;
    private Boolean logOnHost;
    private String origin;
    private LogSeverity severity;
    private Date time;
    private Cluster cluster;
    private DataCenter dataCenter;
    private Host host;
    private StorageDomain storageDomain;
    private Template template;
    private User user;
    private Vm vm;
    
    public BigInteger code() {
        return code;
    }
    
    public Byte codeAsByte() {
        return asByte("Event", "code", code);
    }
    
    public Short codeAsShort() {
        return asShort("Event", "code", code);
    }
    
    public Integer codeAsInteger() {
        return asInteger("Event", "code", code);
    }
    
    public Long codeAsLong() {
        return asLong("Event", "code", code);
    }
    
    public void code(BigInteger newCode) {
        code = newCode;
    }
    
    public boolean codePresent() {
        return code != null;
    }
    
    public String correlationId() {
        return correlationId;
    }
    
    public void correlationId(String newCorrelationId) {
        correlationId = newCorrelationId;
    }
    
    public boolean correlationIdPresent() {
        return correlationId != null;
    }
    
    public String customData() {
        return customData;
    }
    
    public void customData(String newCustomData) {
        customData = newCustomData;
    }
    
    public boolean customDataPresent() {
        return customData != null;
    }
    
    public BigInteger customId() {
        return customId;
    }
    
    public Byte customIdAsByte() {
        return asByte("Event", "customId", customId);
    }
    
    public Short customIdAsShort() {
        return asShort("Event", "customId", customId);
    }
    
    public Integer customIdAsInteger() {
        return asInteger("Event", "customId", customId);
    }
    
    public Long customIdAsLong() {
        return asLong("Event", "customId", customId);
    }
    
    public void customId(BigInteger newCustomId) {
        customId = newCustomId;
    }
    
    public boolean customIdPresent() {
        return customId != null;
    }
    
    public BigInteger floodRate() {
        return floodRate;
    }
    
    public Byte floodRateAsByte() {
        return asByte("Event", "floodRate", floodRate);
    }
    
    public Short floodRateAsShort() {
        return asShort("Event", "floodRate", floodRate);
    }
    
    public Integer floodRateAsInteger() {
        return asInteger("Event", "floodRate", floodRate);
    }
    
    public Long floodRateAsLong() {
        return asLong("Event", "floodRate", floodRate);
    }
    
    public void floodRate(BigInteger newFloodRate) {
        floodRate = newFloodRate;
    }
    
    public boolean floodRatePresent() {
        return floodRate != null;
    }
    
    public BigInteger index() {
        return index;
    }
    
    public Byte indexAsByte() {
        return asByte("Event", "index", index);
    }
    
    public Short indexAsShort() {
        return asShort("Event", "index", index);
    }
    
    public Integer indexAsInteger() {
        return asInteger("Event", "index", index);
    }
    
    public Long indexAsLong() {
        return asLong("Event", "index", index);
    }
    
    public void index(BigInteger newIndex) {
        index = newIndex;
    }
    
    public boolean indexPresent() {
        return index != null;
    }
    
    public boolean logOnHost() {
        return logOnHost;
    }
    
    public void logOnHost(boolean newLogOnHost) {
        logOnHost = Boolean.valueOf(newLogOnHost);
    }
    
    public void logOnHost(Boolean newLogOnHost) {
        logOnHost = newLogOnHost;
    }
    
    public boolean logOnHostPresent() {
        return logOnHost != null;
    }
    
    public String origin() {
        return origin;
    }
    
    public void origin(String newOrigin) {
        origin = newOrigin;
    }
    
    public boolean originPresent() {
        return origin != null;
    }
    
    public LogSeverity severity() {
        return severity;
    }
    
    public void severity(LogSeverity newSeverity) {
        severity = newSeverity;
    }
    
    public boolean severityPresent() {
        return severity != null;
    }
    
    public Date time() {
        if (time == null) {
            return null;
        }
        else {
            return new Date(time.getTime());
        }
    }
    
    public void time(Date newTime) {
        if (newTime == null) {
            time = null;
        }
        else {
            time = new Date(newTime.getTime());
        }
    }
    
    public boolean timePresent() {
        return time != null;
    }
    
    public Cluster cluster() {
        return cluster;
    }
    
    public void cluster(Cluster newCluster) {
        cluster = newCluster;
    }
    
    public boolean clusterPresent() {
        return cluster != null;
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
    
    public Host host() {
        return host;
    }
    
    public void host(Host newHost) {
        host = newHost;
    }
    
    public boolean hostPresent() {
        return host != null;
    }
    
    public StorageDomain storageDomain() {
        return storageDomain;
    }
    
    public void storageDomain(StorageDomain newStorageDomain) {
        storageDomain = newStorageDomain;
    }
    
    public boolean storageDomainPresent() {
        return storageDomain != null;
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
    
    public User user() {
        return user;
    }
    
    public void user(User newUser) {
        user = newUser;
    }
    
    public boolean userPresent() {
        return user != null;
    }
    
    public Vm vm() {
        return vm;
    }
    
    public void vm(Vm newVm) {
        vm = newVm;
    }
    
    public boolean vmPresent() {
        return vm != null;
    }
    
}
