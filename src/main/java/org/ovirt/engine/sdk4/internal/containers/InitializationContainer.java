/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import org.ovirt.engine.sdk4.types.CloudInit;
import org.ovirt.engine.sdk4.types.CloudInitNetworkProtocol;
import org.ovirt.engine.sdk4.types.Configuration;
import org.ovirt.engine.sdk4.types.Initialization;
import org.ovirt.engine.sdk4.types.NicConfiguration;

public class InitializationContainer extends Container implements Initialization {
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
    
    public String activeDirectoryOu() {
        return activeDirectoryOu;
    }
    
    public void activeDirectoryOu(String newActiveDirectoryOu) {
        activeDirectoryOu = newActiveDirectoryOu;
    }
    
    public boolean activeDirectoryOuPresent() {
        return activeDirectoryOu != null;
    }
    
    public String authorizedSshKeys() {
        return authorizedSshKeys;
    }
    
    public void authorizedSshKeys(String newAuthorizedSshKeys) {
        authorizedSshKeys = newAuthorizedSshKeys;
    }
    
    public boolean authorizedSshKeysPresent() {
        return authorizedSshKeys != null;
    }
    
    public CloudInit cloudInit() {
        return cloudInit;
    }
    
    public void cloudInit(CloudInit newCloudInit) {
        cloudInit = newCloudInit;
    }
    
    public boolean cloudInitPresent() {
        return cloudInit != null;
    }
    
    public CloudInitNetworkProtocol cloudInitNetworkProtocol() {
        return cloudInitNetworkProtocol;
    }
    
    public void cloudInitNetworkProtocol(CloudInitNetworkProtocol newCloudInitNetworkProtocol) {
        cloudInitNetworkProtocol = newCloudInitNetworkProtocol;
    }
    
    public boolean cloudInitNetworkProtocolPresent() {
        return cloudInitNetworkProtocol != null;
    }
    
    public Configuration configuration() {
        return configuration;
    }
    
    public void configuration(Configuration newConfiguration) {
        configuration = newConfiguration;
    }
    
    public boolean configurationPresent() {
        return configuration != null;
    }
    
    public String customScript() {
        return customScript;
    }
    
    public void customScript(String newCustomScript) {
        customScript = newCustomScript;
    }
    
    public boolean customScriptPresent() {
        return customScript != null;
    }
    
    public String dnsSearch() {
        return dnsSearch;
    }
    
    public void dnsSearch(String newDnsSearch) {
        dnsSearch = newDnsSearch;
    }
    
    public boolean dnsSearchPresent() {
        return dnsSearch != null;
    }
    
    public String dnsServers() {
        return dnsServers;
    }
    
    public void dnsServers(String newDnsServers) {
        dnsServers = newDnsServers;
    }
    
    public boolean dnsServersPresent() {
        return dnsServers != null;
    }
    
    public String domain() {
        return domain;
    }
    
    public void domain(String newDomain) {
        domain = newDomain;
    }
    
    public boolean domainPresent() {
        return domain != null;
    }
    
    public String hostName() {
        return hostName;
    }
    
    public void hostName(String newHostName) {
        hostName = newHostName;
    }
    
    public boolean hostNamePresent() {
        return hostName != null;
    }
    
    public String inputLocale() {
        return inputLocale;
    }
    
    public void inputLocale(String newInputLocale) {
        inputLocale = newInputLocale;
    }
    
    public boolean inputLocalePresent() {
        return inputLocale != null;
    }
    
    public List<NicConfiguration> nicConfigurations() {
        return makeUnmodifiableList(nicConfigurations);
    }
    
    public void nicConfigurations(List<NicConfiguration> newNicConfigurations) {
        nicConfigurations = makeArrayList(newNicConfigurations);
    }
    
    public boolean nicConfigurationsPresent() {
        return nicConfigurations != null && !nicConfigurations.isEmpty();
    }
    
    public String orgName() {
        return orgName;
    }
    
    public void orgName(String newOrgName) {
        orgName = newOrgName;
    }
    
    public boolean orgNamePresent() {
        return orgName != null;
    }
    
    public boolean regenerateIds() {
        return regenerateIds;
    }
    
    public void regenerateIds(boolean newRegenerateIds) {
        regenerateIds = Boolean.valueOf(newRegenerateIds);
    }
    
    public void regenerateIds(Boolean newRegenerateIds) {
        regenerateIds = newRegenerateIds;
    }
    
    public boolean regenerateIdsPresent() {
        return regenerateIds != null;
    }
    
    public boolean regenerateSshKeys() {
        return regenerateSshKeys;
    }
    
    public void regenerateSshKeys(boolean newRegenerateSshKeys) {
        regenerateSshKeys = Boolean.valueOf(newRegenerateSshKeys);
    }
    
    public void regenerateSshKeys(Boolean newRegenerateSshKeys) {
        regenerateSshKeys = newRegenerateSshKeys;
    }
    
    public boolean regenerateSshKeysPresent() {
        return regenerateSshKeys != null;
    }
    
    public String rootPassword() {
        return rootPassword;
    }
    
    public void rootPassword(String newRootPassword) {
        rootPassword = newRootPassword;
    }
    
    public boolean rootPasswordPresent() {
        return rootPassword != null;
    }
    
    public String systemLocale() {
        return systemLocale;
    }
    
    public void systemLocale(String newSystemLocale) {
        systemLocale = newSystemLocale;
    }
    
    public boolean systemLocalePresent() {
        return systemLocale != null;
    }
    
    public String timezone() {
        return timezone;
    }
    
    public void timezone(String newTimezone) {
        timezone = newTimezone;
    }
    
    public boolean timezonePresent() {
        return timezone != null;
    }
    
    public String uiLanguage() {
        return uiLanguage;
    }
    
    public void uiLanguage(String newUiLanguage) {
        uiLanguage = newUiLanguage;
    }
    
    public boolean uiLanguagePresent() {
        return uiLanguage != null;
    }
    
    public String userLocale() {
        return userLocale;
    }
    
    public void userLocale(String newUserLocale) {
        userLocale = newUserLocale;
    }
    
    public boolean userLocalePresent() {
        return userLocale != null;
    }
    
    public String userName() {
        return userName;
    }
    
    public void userName(String newUserName) {
        userName = newUserName;
    }
    
    public boolean userNamePresent() {
        return userName != null;
    }
    
    public String windowsLicenseKey() {
        return windowsLicenseKey;
    }
    
    public void windowsLicenseKey(String newWindowsLicenseKey) {
        windowsLicenseKey = newWindowsLicenseKey;
    }
    
    public boolean windowsLicenseKeyPresent() {
        return windowsLicenseKey != null;
    }
    
}
