/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

public interface Initialization {
    String activeDirectoryOu();
    
    boolean activeDirectoryOuPresent();
    
    String authorizedSshKeys();
    
    boolean authorizedSshKeysPresent();
    
    CloudInit cloudInit();
    
    boolean cloudInitPresent();
    
    CloudInitNetworkProtocol cloudInitNetworkProtocol();
    
    boolean cloudInitNetworkProtocolPresent();
    
    Configuration configuration();
    
    boolean configurationPresent();
    
    String customScript();
    
    boolean customScriptPresent();
    
    String dnsSearch();
    
    boolean dnsSearchPresent();
    
    String dnsServers();
    
    boolean dnsServersPresent();
    
    String domain();
    
    boolean domainPresent();
    
    String hostName();
    
    boolean hostNamePresent();
    
    String inputLocale();
    
    boolean inputLocalePresent();
    
    List<NicConfiguration> nicConfigurations();
    
    boolean nicConfigurationsPresent();
    
    String orgName();
    
    boolean orgNamePresent();
    
    boolean regenerateIds();
    
    boolean regenerateIdsPresent();
    
    boolean regenerateSshKeys();
    
    boolean regenerateSshKeysPresent();
    
    String rootPassword();
    
    boolean rootPasswordPresent();
    
    String systemLocale();
    
    boolean systemLocalePresent();
    
    String timezone();
    
    boolean timezonePresent();
    
    String uiLanguage();
    
    boolean uiLanguagePresent();
    
    String userLocale();
    
    boolean userLocalePresent();
    
    String userName();
    
    boolean userNamePresent();
    
    String windowsLicenseKey();
    
    boolean windowsLicenseKeyPresent();
    
}
