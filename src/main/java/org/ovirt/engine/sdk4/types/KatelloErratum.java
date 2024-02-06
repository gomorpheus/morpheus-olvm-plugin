/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.Date;
import java.util.List;

/**
 * Type representing a Katello erratum.
 */
public interface KatelloErratum extends Identified {
    Date issued();
    
    boolean issuedPresent();
    
    List<Package> packages();
    
    boolean packagesPresent();
    
    String severity();
    
    boolean severityPresent();
    
    String solution();
    
    boolean solutionPresent();
    
    String summary();
    
    boolean summaryPresent();
    
    String title();
    
    boolean titlePresent();
    
    String type();
    
    boolean typePresent();
    
    Host host();
    
    boolean hostPresent();
    
    Vm vm();
    
    boolean vmPresent();
    
}
