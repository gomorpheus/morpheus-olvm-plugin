/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.internal.containers;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import org.ovirt.engine.sdk4.types.AuthorizedKey;
import org.ovirt.engine.sdk4.types.CloudInit;
import org.ovirt.engine.sdk4.types.File;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.NetworkConfiguration;
import org.ovirt.engine.sdk4.types.User;

public class CloudInitContainer extends Container implements CloudInit {
    private List<AuthorizedKey> authorizedKeys;
    private List<File> files;
    private Host host;
    private NetworkConfiguration networkConfiguration;
    private Boolean regenerateSshKeys;
    private String timezone;
    private List<User> users;
    
    public List<AuthorizedKey> authorizedKeys() {
        return makeUnmodifiableList(authorizedKeys);
    }
    
    public void authorizedKeys(List<AuthorizedKey> newAuthorizedKeys) {
        authorizedKeys = makeArrayList(newAuthorizedKeys);
    }
    
    public boolean authorizedKeysPresent() {
        return authorizedKeys != null && !authorizedKeys.isEmpty();
    }
    
    public List<File> files() {
        return makeUnmodifiableList(files);
    }
    
    public void files(List<File> newFiles) {
        files = makeArrayList(newFiles);
    }
    
    public boolean filesPresent() {
        return files != null && !files.isEmpty();
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
    
    public NetworkConfiguration networkConfiguration() {
        return networkConfiguration;
    }
    
    public void networkConfiguration(NetworkConfiguration newNetworkConfiguration) {
        networkConfiguration = newNetworkConfiguration;
    }
    
    public boolean networkConfigurationPresent() {
        return networkConfiguration != null;
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
    
    public String timezone() {
        return timezone;
    }
    
    public void timezone(String newTimezone) {
        timezone = newTimezone;
    }
    
    public boolean timezonePresent() {
        return timezone != null;
    }
    
    public List<User> users() {
        return makeUnmodifiableList(users);
    }
    
    public void users(List<User> newUsers) {
        users = makeArrayList(newUsers);
    }
    
    public boolean usersPresent() {
        return users != null && !users.isEmpty();
    }
    
}
