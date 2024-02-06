/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.RegistrationConfigurationContainer;
import org.ovirt.engine.sdk4.types.RegistrationAffinityGroupMapping;
import org.ovirt.engine.sdk4.types.RegistrationAffinityLabelMapping;
import org.ovirt.engine.sdk4.types.RegistrationClusterMapping;
import org.ovirt.engine.sdk4.types.RegistrationConfiguration;
import org.ovirt.engine.sdk4.types.RegistrationDomainMapping;
import org.ovirt.engine.sdk4.types.RegistrationLunMapping;
import org.ovirt.engine.sdk4.types.RegistrationRoleMapping;
import org.ovirt.engine.sdk4.types.RegistrationVnicProfileMapping;

public class RegistrationConfigurationBuilder {
    private List<RegistrationAffinityGroupMapping> affinityGroupMappings;
    private List<RegistrationAffinityLabelMapping> affinityLabelMappings;
    private List<RegistrationClusterMapping> clusterMappings;
    private List<RegistrationDomainMapping> domainMappings;
    private List<RegistrationLunMapping> lunMappings;
    private List<RegistrationRoleMapping> roleMappings;
    private List<RegistrationVnicProfileMapping> vnicProfileMappings;
    
    public RegistrationConfigurationBuilder affinityGroupMappings(List<RegistrationAffinityGroupMapping> newAffinityGroupMappings) {
        if (newAffinityGroupMappings != null) {
            if (affinityGroupMappings == null) {
                affinityGroupMappings = new ArrayList<>(newAffinityGroupMappings);
            }
            else {
                affinityGroupMappings.addAll(newAffinityGroupMappings);
            }
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder affinityGroupMappings(RegistrationAffinityGroupMapping... newAffinityGroupMappings) {
        if (newAffinityGroupMappings != null) {
            if (affinityGroupMappings == null) {
                affinityGroupMappings = new ArrayList<>(newAffinityGroupMappings.length);
            }
            Collections.addAll(affinityGroupMappings, newAffinityGroupMappings);
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder affinityGroupMappings(RegistrationAffinityGroupMappingBuilder... newAffinityGroupMappings) {
        if (newAffinityGroupMappings != null) {
            if (affinityGroupMappings == null) {
                affinityGroupMappings = new ArrayList<>(newAffinityGroupMappings.length);
            }
            for (RegistrationAffinityGroupMappingBuilder builder : newAffinityGroupMappings) {
                affinityGroupMappings.add(builder.build());
            }
        }
        return this;
    }
    
    
    public RegistrationConfigurationBuilder affinityLabelMappings(List<RegistrationAffinityLabelMapping> newAffinityLabelMappings) {
        if (newAffinityLabelMappings != null) {
            if (affinityLabelMappings == null) {
                affinityLabelMappings = new ArrayList<>(newAffinityLabelMappings);
            }
            else {
                affinityLabelMappings.addAll(newAffinityLabelMappings);
            }
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder affinityLabelMappings(RegistrationAffinityLabelMapping... newAffinityLabelMappings) {
        if (newAffinityLabelMappings != null) {
            if (affinityLabelMappings == null) {
                affinityLabelMappings = new ArrayList<>(newAffinityLabelMappings.length);
            }
            Collections.addAll(affinityLabelMappings, newAffinityLabelMappings);
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder affinityLabelMappings(RegistrationAffinityLabelMappingBuilder... newAffinityLabelMappings) {
        if (newAffinityLabelMappings != null) {
            if (affinityLabelMappings == null) {
                affinityLabelMappings = new ArrayList<>(newAffinityLabelMappings.length);
            }
            for (RegistrationAffinityLabelMappingBuilder builder : newAffinityLabelMappings) {
                affinityLabelMappings.add(builder.build());
            }
        }
        return this;
    }
    
    
    public RegistrationConfigurationBuilder clusterMappings(List<RegistrationClusterMapping> newClusterMappings) {
        if (newClusterMappings != null) {
            if (clusterMappings == null) {
                clusterMappings = new ArrayList<>(newClusterMappings);
            }
            else {
                clusterMappings.addAll(newClusterMappings);
            }
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder clusterMappings(RegistrationClusterMapping... newClusterMappings) {
        if (newClusterMappings != null) {
            if (clusterMappings == null) {
                clusterMappings = new ArrayList<>(newClusterMappings.length);
            }
            Collections.addAll(clusterMappings, newClusterMappings);
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder clusterMappings(RegistrationClusterMappingBuilder... newClusterMappings) {
        if (newClusterMappings != null) {
            if (clusterMappings == null) {
                clusterMappings = new ArrayList<>(newClusterMappings.length);
            }
            for (RegistrationClusterMappingBuilder builder : newClusterMappings) {
                clusterMappings.add(builder.build());
            }
        }
        return this;
    }
    
    
    public RegistrationConfigurationBuilder domainMappings(List<RegistrationDomainMapping> newDomainMappings) {
        if (newDomainMappings != null) {
            if (domainMappings == null) {
                domainMappings = new ArrayList<>(newDomainMappings);
            }
            else {
                domainMappings.addAll(newDomainMappings);
            }
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder domainMappings(RegistrationDomainMapping... newDomainMappings) {
        if (newDomainMappings != null) {
            if (domainMappings == null) {
                domainMappings = new ArrayList<>(newDomainMappings.length);
            }
            Collections.addAll(domainMappings, newDomainMappings);
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder domainMappings(RegistrationDomainMappingBuilder... newDomainMappings) {
        if (newDomainMappings != null) {
            if (domainMappings == null) {
                domainMappings = new ArrayList<>(newDomainMappings.length);
            }
            for (RegistrationDomainMappingBuilder builder : newDomainMappings) {
                domainMappings.add(builder.build());
            }
        }
        return this;
    }
    
    
    public RegistrationConfigurationBuilder lunMappings(List<RegistrationLunMapping> newLunMappings) {
        if (newLunMappings != null) {
            if (lunMappings == null) {
                lunMappings = new ArrayList<>(newLunMappings);
            }
            else {
                lunMappings.addAll(newLunMappings);
            }
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder lunMappings(RegistrationLunMapping... newLunMappings) {
        if (newLunMappings != null) {
            if (lunMappings == null) {
                lunMappings = new ArrayList<>(newLunMappings.length);
            }
            Collections.addAll(lunMappings, newLunMappings);
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder lunMappings(RegistrationLunMappingBuilder... newLunMappings) {
        if (newLunMappings != null) {
            if (lunMappings == null) {
                lunMappings = new ArrayList<>(newLunMappings.length);
            }
            for (RegistrationLunMappingBuilder builder : newLunMappings) {
                lunMappings.add(builder.build());
            }
        }
        return this;
    }
    
    
    public RegistrationConfigurationBuilder roleMappings(List<RegistrationRoleMapping> newRoleMappings) {
        if (newRoleMappings != null) {
            if (roleMappings == null) {
                roleMappings = new ArrayList<>(newRoleMappings);
            }
            else {
                roleMappings.addAll(newRoleMappings);
            }
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder roleMappings(RegistrationRoleMapping... newRoleMappings) {
        if (newRoleMappings != null) {
            if (roleMappings == null) {
                roleMappings = new ArrayList<>(newRoleMappings.length);
            }
            Collections.addAll(roleMappings, newRoleMappings);
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder roleMappings(RegistrationRoleMappingBuilder... newRoleMappings) {
        if (newRoleMappings != null) {
            if (roleMappings == null) {
                roleMappings = new ArrayList<>(newRoleMappings.length);
            }
            for (RegistrationRoleMappingBuilder builder : newRoleMappings) {
                roleMappings.add(builder.build());
            }
        }
        return this;
    }
    
    
    public RegistrationConfigurationBuilder vnicProfileMappings(List<RegistrationVnicProfileMapping> newVnicProfileMappings) {
        if (newVnicProfileMappings != null) {
            if (vnicProfileMappings == null) {
                vnicProfileMappings = new ArrayList<>(newVnicProfileMappings);
            }
            else {
                vnicProfileMappings.addAll(newVnicProfileMappings);
            }
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder vnicProfileMappings(RegistrationVnicProfileMapping... newVnicProfileMappings) {
        if (newVnicProfileMappings != null) {
            if (vnicProfileMappings == null) {
                vnicProfileMappings = new ArrayList<>(newVnicProfileMappings.length);
            }
            Collections.addAll(vnicProfileMappings, newVnicProfileMappings);
        }
        return this;
    }
    
    public RegistrationConfigurationBuilder vnicProfileMappings(RegistrationVnicProfileMappingBuilder... newVnicProfileMappings) {
        if (newVnicProfileMappings != null) {
            if (vnicProfileMappings == null) {
                vnicProfileMappings = new ArrayList<>(newVnicProfileMappings.length);
            }
            for (RegistrationVnicProfileMappingBuilder builder : newVnicProfileMappings) {
                vnicProfileMappings.add(builder.build());
            }
        }
        return this;
    }
    
    
    public RegistrationConfiguration build() {
        RegistrationConfigurationContainer container = new RegistrationConfigurationContainer();
        container.affinityGroupMappings(affinityGroupMappings);
        container.affinityLabelMappings(affinityLabelMappings);
        container.clusterMappings(clusterMappings);
        container.domainMappings(domainMappings);
        container.lunMappings(lunMappings);
        container.roleMappings(roleMappings);
        container.vnicProfileMappings(vnicProfileMappings);
        return container;
    }
}
