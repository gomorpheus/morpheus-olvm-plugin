/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.types;

import java.lang.String;
import java.math.BigInteger;

public interface LogicalUnit {
    String address();
    
    boolean addressPresent();
    
    BigInteger discardMaxSize();
    Byte discardMaxSizeAsByte();
    Short discardMaxSizeAsShort();
    Integer discardMaxSizeAsInteger();
    Long discardMaxSizeAsLong();
    
    boolean discardMaxSizePresent();
    
    boolean discardZeroesData();
    
    boolean discardZeroesDataPresent();
    
    String diskId();
    
    boolean diskIdPresent();
    
    String id();
    
    boolean idPresent();
    
    BigInteger lunMapping();
    Byte lunMappingAsByte();
    Short lunMappingAsShort();
    Integer lunMappingAsInteger();
    Long lunMappingAsLong();
    
    boolean lunMappingPresent();
    
    String password();
    
    boolean passwordPresent();
    
    BigInteger paths();
    Byte pathsAsByte();
    Short pathsAsShort();
    Integer pathsAsInteger();
    Long pathsAsLong();
    
    boolean pathsPresent();
    
    BigInteger port();
    Byte portAsByte();
    Short portAsShort();
    Integer portAsInteger();
    Long portAsLong();
    
    boolean portPresent();
    
    String portal();
    
    boolean portalPresent();
    
    String productId();
    
    boolean productIdPresent();
    
    String serial();
    
    boolean serialPresent();
    
    BigInteger size();
    Byte sizeAsByte();
    Short sizeAsShort();
    Integer sizeAsInteger();
    Long sizeAsLong();
    
    boolean sizePresent();
    
    LunStatus status();
    
    boolean statusPresent();
    
    String storageDomainId();
    
    boolean storageDomainIdPresent();
    
    String target();
    
    boolean targetPresent();
    
    String username();
    
    boolean usernamePresent();
    
    String vendorId();
    
    boolean vendorIdPresent();
    
    String volumeGroupId();
    
    boolean volumeGroupIdPresent();
    
}
