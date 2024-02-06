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
import org.ovirt.engine.sdk4.internal.containers.CloudInitContainer;
import org.ovirt.engine.sdk4.types.AuthorizedKey;
import org.ovirt.engine.sdk4.types.CloudInit;
import org.ovirt.engine.sdk4.types.File;
import org.ovirt.engine.sdk4.types.Host;
import org.ovirt.engine.sdk4.types.NetworkConfiguration;
import org.ovirt.engine.sdk4.types.User;

public class CloudInitBuilder {
    private List<AuthorizedKey> authorizedKeys;
    private List<File> files;
    private Host host;
    private NetworkConfiguration networkConfiguration;
    private Boolean regenerateSshKeys;
    private String timezone;
    private List<User> users;
    
    public CloudInitBuilder authorizedKeys(List<AuthorizedKey> newAuthorizedKeys) {
        if (newAuthorizedKeys != null) {
            if (authorizedKeys == null) {
                authorizedKeys = new ArrayList<>(newAuthorizedKeys);
            }
            else {
                authorizedKeys.addAll(newAuthorizedKeys);
            }
        }
        return this;
    }
    
    public CloudInitBuilder authorizedKeys(AuthorizedKey... newAuthorizedKeys) {
        if (newAuthorizedKeys != null) {
            if (authorizedKeys == null) {
                authorizedKeys = new ArrayList<>(newAuthorizedKeys.length);
            }
            Collections.addAll(authorizedKeys, newAuthorizedKeys);
        }
        return this;
    }
    
    public CloudInitBuilder authorizedKeys(AuthorizedKeyBuilder... newAuthorizedKeys) {
        if (newAuthorizedKeys != null) {
            if (authorizedKeys == null) {
                authorizedKeys = new ArrayList<>(newAuthorizedKeys.length);
            }
            for (AuthorizedKeyBuilder builder : newAuthorizedKeys) {
                authorizedKeys.add(builder.build());
            }
        }
        return this;
    }
    
    
    public CloudInitBuilder files(List<File> newFiles) {
        if (newFiles != null) {
            if (files == null) {
                files = new ArrayList<>(newFiles);
            }
            else {
                files.addAll(newFiles);
            }
        }
        return this;
    }
    
    public CloudInitBuilder files(File... newFiles) {
        if (newFiles != null) {
            if (files == null) {
                files = new ArrayList<>(newFiles.length);
            }
            Collections.addAll(files, newFiles);
        }
        return this;
    }
    
    public CloudInitBuilder files(FileBuilder... newFiles) {
        if (newFiles != null) {
            if (files == null) {
                files = new ArrayList<>(newFiles.length);
            }
            for (FileBuilder builder : newFiles) {
                files.add(builder.build());
            }
        }
        return this;
    }
    
    
    public CloudInitBuilder host(Host newHost) {
        host = newHost;
        return this;
    }
    
    public CloudInitBuilder host(HostBuilder newHost) {
        if (newHost == null) {
            host = null;
        }
        else {
            host = newHost.build();
        }
        return this;
    }
    
    
    public CloudInitBuilder networkConfiguration(NetworkConfiguration newNetworkConfiguration) {
        networkConfiguration = newNetworkConfiguration;
        return this;
    }
    
    public CloudInitBuilder networkConfiguration(NetworkConfigurationBuilder newNetworkConfiguration) {
        if (newNetworkConfiguration == null) {
            networkConfiguration = null;
        }
        else {
            networkConfiguration = newNetworkConfiguration.build();
        }
        return this;
    }
    
    
    public CloudInitBuilder regenerateSshKeys(boolean newRegenerateSshKeys) {
        regenerateSshKeys = Boolean.valueOf(newRegenerateSshKeys);
        return this;
    }
    
    public CloudInitBuilder regenerateSshKeys(Boolean newRegenerateSshKeys) {
        regenerateSshKeys = newRegenerateSshKeys;
        return this;
    }
    
    
    public CloudInitBuilder timezone(String newTimezone) {
        timezone = newTimezone;
        return this;
    }
    
    
    public CloudInitBuilder users(List<User> newUsers) {
        if (newUsers != null) {
            if (users == null) {
                users = new ArrayList<>(newUsers);
            }
            else {
                users.addAll(newUsers);
            }
        }
        return this;
    }
    
    public CloudInitBuilder users(User... newUsers) {
        if (newUsers != null) {
            if (users == null) {
                users = new ArrayList<>(newUsers.length);
            }
            Collections.addAll(users, newUsers);
        }
        return this;
    }
    
    public CloudInitBuilder users(UserBuilder... newUsers) {
        if (newUsers != null) {
            if (users == null) {
                users = new ArrayList<>(newUsers.length);
            }
            for (UserBuilder builder : newUsers) {
                users.add(builder.build());
            }
        }
        return this;
    }
    
    
    public CloudInit build() {
        CloudInitContainer container = new CloudInitContainer();
        container.authorizedKeys(authorizedKeys);
        container.files(files);
        container.host(host);
        container.networkConfiguration(networkConfiguration);
        container.regenerateSshKeys(regenerateSshKeys);
        container.timezone(timezone);
        container.users(users);
        return container;
    }
}
