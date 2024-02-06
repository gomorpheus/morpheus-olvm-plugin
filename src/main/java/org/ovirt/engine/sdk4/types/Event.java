/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;
import java.util.Date;

/**
 * Type representing an event.
 */
public interface Event extends Identified {
    BigInteger code();
    Byte codeAsByte();
    Short codeAsShort();
    Integer codeAsInteger();
    Long codeAsLong();
    
    boolean codePresent();
    
    String correlationId();
    
    boolean correlationIdPresent();
    
    String customData();
    
    boolean customDataPresent();
    
    BigInteger customId();
    Byte customIdAsByte();
    Short customIdAsShort();
    Integer customIdAsInteger();
    Long customIdAsLong();
    
    boolean customIdPresent();
    
    BigInteger floodRate();
    Byte floodRateAsByte();
    Short floodRateAsShort();
    Integer floodRateAsInteger();
    Long floodRateAsLong();
    
    boolean floodRatePresent();
    
    BigInteger index();
    Byte indexAsByte();
    Short indexAsShort();
    Integer indexAsInteger();
    Long indexAsLong();
    
    boolean indexPresent();
    
    boolean logOnHost();
    
    boolean logOnHostPresent();
    
    String origin();
    
    boolean originPresent();
    
    LogSeverity severity();
    
    boolean severityPresent();
    
    Date time();
    
    boolean timePresent();
    
    Cluster cluster();
    
    boolean clusterPresent();
    
    DataCenter dataCenter();
    
    boolean dataCenterPresent();
    
    Host host();
    
    boolean hostPresent();
    
    StorageDomain storageDomain();
    
    boolean storageDomainPresent();
    
    Template template();
    
    boolean templatePresent();
    
    User user();
    
    boolean userPresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
