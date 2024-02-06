/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.KatelloErratumContainer;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.KatelloErratum;
import org.ovirt.engine.sdk4.types.Package;
import org.ovirt.engine.sdk4.types.Vm;

public class KatelloErratumBuilder {
    private String comment;
    private String description;
    private Host host;
    private String href;
    private String id;
    private Date issued;
    private String name;
    private List<Package> packages;
    private String severity;
    private String solution;
    private String summary;
    private String title;
    private String type;
    private Vm vm;
    
    public KatelloErratumBuilder comment(String newComment) {
        comment = newComment;
        return this;
    }
    
    
    public KatelloErratumBuilder description(String newDescription) {
        description = newDescription;
        return this;
    }
    
    
    public KatelloErratumBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public KatelloErratumBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public KatelloErratumBuilder href(String newHref) {
        href = newHref;
        return this;
    }
    
    
    public KatelloErratumBuilder id(String newId) {
        id = newId;
        return this;
    }
    
    
    public KatelloErratumBuilder issued(Date newIssued) {
        if (newIssued == null) {
            issued = null;
        }
        else {
            issued = new Date(newIssued.getTime());
        }
        return this;
    }
    
    
    public KatelloErratumBuilder name(String newName) {
        name = newName;
        return this;
    }
    
    
    public KatelloErratumBuilder packages(List<Package> newPackages) {
        if (newPackages != null) {
            if (packages == null) {
                packages = new ArrayList<>(newPackages);
            }
            else {
                packages.addAll(newPackages);
            }
        }
        return this;
    }
    
    public KatelloErratumBuilder packages(Package... newPackages) {
        if (newPackages != null) {
            if (packages == null) {
                packages = new ArrayList<>(newPackages.length);
            }
            Collections.addAll(packages, newPackages);
        }
        return this;
    }
    
    public KatelloErratumBuilder packages(PackageBuilder... newPackages) {
        if (newPackages != null) {
            if (packages == null) {
                packages = new ArrayList<>(newPackages.length);
            }
            for (PackageBuilder builder : newPackages) {
                packages.add(builder.build());
            }
        }
        return this;
    }
    
    
    public KatelloErratumBuilder severity(String newSeverity) {
        severity = newSeverity;
        return this;
    }
    
    
    public KatelloErratumBuilder solution(String newSolution) {
        solution = newSolution;
        return this;
    }
    
    
    public KatelloErratumBuilder summary(String newSummary) {
        summary = newSummary;
        return this;
    }
    
    
    public KatelloErratumBuilder title(String newTitle) {
        title = newTitle;
        return this;
    }
    
    
    public KatelloErratumBuilder type(String newType) {
        type = newType;
        return this;
    }
    
    
    public KatelloErratumBuilder vm(Vm newVm) {
        vm = newVm;
        return this;
    }
    
    public KatelloErratumBuilder vm(VmBuilder newVm) {
        if (newVm == null) {
            vm = null;
        }
        else {
            vm = newVm.build();
        }
        return this;
    }
    
    
    public KatelloErratum build() {
        KatelloErratumContainer container = new KatelloErratumContainer();
        container.comment(comment);
        container.description(description);
        container.host(host);
        container.href(href);
        container.id(id);
        container.issued(issued);
        container.name(name);
        container.packages(packages);
        container.severity(severity);
        container.solution(solution);
        container.summary(summary);
        container.title(title);
        container.type(type);
        container.vm(vm);
        return container;
    }
}
