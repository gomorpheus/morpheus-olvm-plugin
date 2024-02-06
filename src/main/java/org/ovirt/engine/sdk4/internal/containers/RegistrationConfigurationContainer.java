/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.util.List;
import org.ovirt.engine.sdk4.types.RegistrationAffinityGroupMapping;
import org.ovirt.engine.sdk4.types.RegistrationAffinityLabelMapping;
import org.ovirt.engine.sdk4.types.RegistrationClusterMapping;
import org.ovirt.engine.sdk4.types.RegistrationConfiguration;
import org.ovirt.engine.sdk4.types.RegistrationDomainMapping;
import org.ovirt.engine.sdk4.types.RegistrationLunMapping;
import org.ovirt.engine.sdk4.types.RegistrationRoleMapping;
import org.ovirt.engine.sdk4.types.RegistrationVnicProfileMapping;

public class RegistrationConfigurationContainer extends Container implements RegistrationConfiguration {
    private List<RegistrationAffinityGroupMapping> affinityGroupMappings;
    private List<RegistrationAffinityLabelMapping> affinityLabelMappings;
    private List<RegistrationClusterMapping> clusterMappings;
    private List<RegistrationDomainMapping> domainMappings;
    private List<RegistrationLunMapping> lunMappings;
    private List<RegistrationRoleMapping> roleMappings;
    private List<RegistrationVnicProfileMapping> vnicProfileMappings;
    
    public List<RegistrationAffinityGroupMapping> affinityGroupMappings() {
        return makeUnmodifiableList(affinityGroupMappings);
    }
    
    public void affinityGroupMappings(List<RegistrationAffinityGroupMapping> newAffinityGroupMappings) {
        affinityGroupMappings = makeArrayList(newAffinityGroupMappings);
    }
    
    public boolean affinityGroupMappingsPresent() {
        return affinityGroupMappings != null && !affinityGroupMappings.isEmpty();
    }
    
    public List<RegistrationAffinityLabelMapping> affinityLabelMappings() {
        return makeUnmodifiableList(affinityLabelMappings);
    }
    
    public void affinityLabelMappings(List<RegistrationAffinityLabelMapping> newAffinityLabelMappings) {
        affinityLabelMappings = makeArrayList(newAffinityLabelMappings);
    }
    
    public boolean affinityLabelMappingsPresent() {
        return affinityLabelMappings != null && !affinityLabelMappings.isEmpty();
    }
    
    public List<RegistrationClusterMapping> clusterMappings() {
        return makeUnmodifiableList(clusterMappings);
    }
    
    public void clusterMappings(List<RegistrationClusterMapping> newClusterMappings) {
        clusterMappings = makeArrayList(newClusterMappings);
    }
    
    public boolean clusterMappingsPresent() {
        return clusterMappings != null && !clusterMappings.isEmpty();
    }
    
    public List<RegistrationDomainMapping> domainMappings() {
        return makeUnmodifiableList(domainMappings);
    }
    
    public void domainMappings(List<RegistrationDomainMapping> newDomainMappings) {
        domainMappings = makeArrayList(newDomainMappings);
    }
    
    public boolean domainMappingsPresent() {
        return domainMappings != null && !domainMappings.isEmpty();
    }
    
    public List<RegistrationLunMapping> lunMappings() {
        return makeUnmodifiableList(lunMappings);
    }
    
    public void lunMappings(List<RegistrationLunMapping> newLunMappings) {
        lunMappings = makeArrayList(newLunMappings);
    }
    
    public boolean lunMappingsPresent() {
        return lunMappings != null && !lunMappings.isEmpty();
    }
    
    public List<RegistrationRoleMapping> roleMappings() {
        return makeUnmodifiableList(roleMappings);
    }
    
    public void roleMappings(List<RegistrationRoleMapping> newRoleMappings) {
        roleMappings = makeArrayList(newRoleMappings);
    }
    
    public boolean roleMappingsPresent() {
        return roleMappings != null && !roleMappings.isEmpty();
    }
    
    public List<RegistrationVnicProfileMapping> vnicProfileMappings() {
        return makeUnmodifiableList(vnicProfileMappings);
    }
    
    public void vnicProfileMappings(List<RegistrationVnicProfileMapping> newVnicProfileMappings) {
        vnicProfileMappings = makeArrayList(newVnicProfileMappings);
    }
    
    public boolean vnicProfileMappingsPresent() {
        return vnicProfileMappings != null && !vnicProfileMappings.isEmpty();
    }
    
}
