/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.builders;

import java.lang.Boolean;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.ovirt.engine.sdk4.internal.containers.InitializationContainer;
import org.ovirt.engine.sdk4.types.CloudInit;
import org.ovirt.engine.sdk4.types.CloudInitNetworkProtocol;
import org.ovirt.engine.sdk4.types.Configuration;
import org.ovirt.engine.sdk4.types.Initialization;
import org.ovirt.engine.sdk4.types.NicConfiguration;

public class InitializationBuilder {
    private String activeDirectoryOu;
    private String authorizedSshKeys;
    private CloudInit cloudInit;
    private CloudInitNetworkProtocol cloudInitNetworkProtocol;
    private Configuration configuration;
    private String customScript;
    private String dnsSearch;
    private String dnsServers;
    private String domain;
    private String hostName;
    private String inputLocale;
    private List<NicConfiguration> nicConfigurations;
    private String orgName;
    private Boolean regenerateIds;
    private Boolean regenerateSshKeys;
    private String rootPassword;
    private String systemLocale;
    private String timezone;
    private String uiLanguage;
    private String userLocale;
    private String userName;
    private String windowsLicenseKey;
    
    public InitializationBuilder activeDirectoryOu(String newActiveDirectoryOu) {
        activeDirectoryOu = newActiveDirectoryOu;
        return this;
    }
    
    
    public InitializationBuilder authorizedSshKeys(String newAuthorizedSshKeys) {
        authorizedSshKeys = newAuthorizedSshKeys;
        return this;
    }
    
    
    public InitializationBuilder cloudInit(CloudInit newCloudInit) {
        cloudInit = newCloudInit;
        return this;
    }
    
    public InitializationBuilder cloudInit(CloudInitBuilder newCloudInit) {
        if (newCloudInit == null) {
            cloudInit = null;
        }
        else {
            cloudInit = newCloudInit.build();
        }
        return this;
    }
    
    
    public InitializationBuilder cloudInitNetworkProtocol(CloudInitNetworkProtocol newCloudInitNetworkProtocol) {
        cloudInitNetworkProtocol = newCloudInitNetworkProtocol;
        return this;
    }
    
    
    public InitializationBuilder configuration(Configuration newConfiguration) {
        configuration = newConfiguration;
        return this;
    }
    
    public InitializationBuilder configuration(ConfigurationBuilder newConfiguration) {
        if (newConfiguration == null) {
            configuration = null;
        }
        else {
            configuration = newConfiguration.build();
        }
        return this;
    }
    
    
    public InitializationBuilder customScript(String newCustomScript) {
        customScript = newCustomScript;
        return this;
    }
    
    
    public InitializationBuilder dnsSearch(String newDnsSearch) {
        dnsSearch = newDnsSearch;
        return this;
    }
    
    
    public InitializationBuilder dnsServers(String newDnsServers) {
        dnsServers = newDnsServers;
        return this;
    }
    
    
    public InitializationBuilder domain(String newDomain) {
        domain = newDomain;
        return this;
    }
    
    
    public InitializationBuilder hostName(String newHostName) {
        hostName = newHostName;
        return this;
    }
    
    
    public InitializationBuilder inputLocale(String newInputLocale) {
        inputLocale = newInputLocale;
        return this;
    }
    
    
    public InitializationBuilder nicConfigurations(List<NicConfiguration> newNicConfigurations) {
        if (newNicConfigurations != null) {
            if (nicConfigurations == null) {
                nicConfigurations = new ArrayList<>(newNicConfigurations);
            }
            else {
                nicConfigurations.addAll(newNicConfigurations);
            }
        }
        return this;
    }
    
    public InitializationBuilder nicConfigurations(NicConfiguration... newNicConfigurations) {
        if (newNicConfigurations != null) {
            if (nicConfigurations == null) {
                nicConfigurations = new ArrayList<>(newNicConfigurations.length);
            }
            Collections.addAll(nicConfigurations, newNicConfigurations);
        }
        return this;
    }
    
    public InitializationBuilder nicConfigurations(NicConfigurationBuilder... newNicConfigurations) {
        if (newNicConfigurations != null) {
            if (nicConfigurations == null) {
                nicConfigurations = new ArrayList<>(newNicConfigurations.length);
            }
            for (NicConfigurationBuilder builder : newNicConfigurations) {
                nicConfigurations.add(builder.build());
            }
        }
        return this;
    }
    
    
    public InitializationBuilder orgName(String newOrgName) {
        orgName = newOrgName;
        return this;
    }
    
    
    public InitializationBuilder regenerateIds(boolean newRegenerateIds) {
        regenerateIds = Boolean.valueOf(newRegenerateIds);
        return this;
    }
    
    public InitializationBuilder regenerateIds(Boolean newRegenerateIds) {
        regenerateIds = newRegenerateIds;
        return this;
    }
    
    
    public InitializationBuilder regenerateSshKeys(boolean newRegenerateSshKeys) {
        regenerateSshKeys = Boolean.valueOf(newRegenerateSshKeys);
        return this;
    }
    
    public InitializationBuilder regenerateSshKeys(Boolean newRegenerateSshKeys) {
        regenerateSshKeys = newRegenerateSshKeys;
        return this;
    }
    
    
    public InitializationBuilder rootPassword(String newRootPassword) {
        rootPassword = newRootPassword;
        return this;
    }
    
    
    public InitializationBuilder systemLocale(String newSystemLocale) {
        systemLocale = newSystemLocale;
        return this;
    }
    
    
    public InitializationBuilder timezone(String newTimezone) {
        timezone = newTimezone;
        return this;
    }
    
    
    public InitializationBuilder uiLanguage(String newUiLanguage) {
        uiLanguage = newUiLanguage;
        return this;
    }
    
    
    public InitializationBuilder userLocale(String newUserLocale) {
        userLocale = newUserLocale;
        return this;
    }
    
    
    public InitializationBuilder userName(String newUserName) {
        userName = newUserName;
        return this;
    }
    
    
    public InitializationBuilder windowsLicenseKey(String newWindowsLicenseKey) {
        windowsLicenseKey = newWindowsLicenseKey;
        return this;
    }
    
    
    public Initialization build() {
        InitializationContainer container = new InitializationContainer();
        container.activeDirectoryOu(activeDirectoryOu);
        container.authorizedSshKeys(authorizedSshKeys);
        container.cloudInit(cloudInit);
        container.cloudInitNetworkProtocol(cloudInitNetworkProtocol);
        container.configuration(configuration);
        container.customScript(customScript);
        container.dnsSearch(dnsSearch);
        container.dnsServers(dnsServers);
        container.domain(domain);
        container.hostName(hostName);
        container.inputLocale(inputLocale);
        container.nicConfigurations(nicConfigurations);
        container.orgName(orgName);
        container.regenerateIds(regenerateIds);
        container.regenerateSshKeys(regenerateSshKeys);
        container.rootPassword(rootPassword);
        container.systemLocale(systemLocale);
        container.timezone(timezone);
        container.uiLanguage(uiLanguage);
        container.userLocale(userLocale);
        container.userName(userName);
        container.windowsLicenseKey(windowsLicenseKey);
        return container;
    }
}
