/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.String;
import java.util.Date;
import java.util.List;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.KatelloErratum;
import org.ovirt.engine.sdk4.types.Package;
import org.ovirt.engine.sdk4.types.Vm;

public class KatelloErratumContainer extends IdentifiedContainer implements KatelloErratum {
    private Date issued;
    private List<Package> packages;
    private String severity;
    private String solution;
    private String summary;
    private String title;
    private String type;
    private Host host;
    private Vm vm;
    
    public Date issued() {
        if (issued == null) {
            return null;
        }
        else {
            return new Date(issued.getTime());
        }
    }
    
    public void issued(Date newIssued) {
        if (newIssued == null) {
            issued = null;
        }
        else {
            issued = new Date(newIssued.getTime());
        }
    }
    
    public boolean issuedPresent() {
        return issued != null;
    }
    
    public List<Package> packages() {
        return makeUnmodifiableList(packages);
    }
    
    public void packages(List<Package> newPackages) {
        packages = makeArrayList(newPackages);
    }
    
    public boolean packagesPresent() {
        return packages != null && !packages.isEmpty();
    }
    
    public String severity() {
        return severity;
    }
    
    public void severity(String newSeverity) {
        severity = newSeverity;
    }
    
    public boolean severityPresent() {
        return severity != null;
    }
    
    public String solution() {
        return solution;
    }
    
    public void solution(String newSolution) {
        solution = newSolution;
    }
    
    public boolean solutionPresent() {
        return solution != null;
    }
    
    public String summary() {
        return summary;
    }
    
    public void summary(String newSummary) {
        summary = newSummary;
    }
    
    public boolean summaryPresent() {
        return summary != null;
    }
    
    public String title() {
        return title;
    }
    
    public void title(String newTitle) {
        title = newTitle;
    }
    
    public boolean titlePresent() {
        return title != null;
    }
    
    public String type() {
        return type;
    }
    
    public void type(String newType) {
        type = newType;
    }
    
    public boolean typePresent() {
        return type != null;
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
