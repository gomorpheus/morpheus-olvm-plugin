/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.util.List;

/**
 * Deprecated type to specify _cloud-init_ configuration.
 * 
 * This type has been deprecated and replaced by alternative attributes inside the
 * <<types/initialization, Initialization>> type. See the
 * <<types/initialization/attributes/cloud_init, cloud_init>> attribute documentation for details.
 */
public interface CloudInit {
    List<AuthorizedKey> authorizedKeys();
    
    boolean authorizedKeysPresent();
    
    List<File> files();
    
    boolean filesPresent();
    
    Host host();
    
    boolean hostPresent();
    
    NetworkConfiguration networkConfiguration();
    
    boolean networkConfigurationPresent();
    
    boolean regenerateSshKeys();
    
    boolean regenerateSshKeysPresent();
    
    String timezone();
    
    boolean timezonePresent();
    
    List<User> users();
    
    boolean usersPresent();
    
}
