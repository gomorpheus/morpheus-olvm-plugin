/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.types.HostStorage;

public interface StorageService extends Service {
    public interface GetRequest extends Request<GetRequest, GetResponse> {
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        GetRequest follow(String follow);
        /**
         * Indicates if the status of the LUNs in the storage should be checked.
         * Checking the status of the LUN is an heavy weight operation and
         * this data is not always needed by the user.
         * This parameter will give the option to not perform the status check of the LUNs.
         * 
         * The default is `true` for backward compatibility.
         * 
         * Here an example with the LUN status :
         * 
         * [source,xml]
         * ----
         * <host_storage id="360014051136c20574f743bdbd28177fd">
         *   <logical_units>
         *     <logical_unit id="360014051136c20574f743bdbd28177fd">
         *       <lun_mapping>0</lun_mapping>
         *       <paths>1</paths>
         *       <product_id>lun0</product_id>
         *       <serial>SLIO-ORG_lun0_1136c205-74f7-43bd-bd28-177fd5ce6993</serial>
         *       <size>10737418240</size>
         *       <status>used</status>
         *       <vendor_id>LIO-ORG</vendor_id>
         *       <volume_group_id>O9Du7I-RahN-ECe1-dZ1w-nh0b-64io-MNzIBZ</volume_group_id>
         *     </logical_unit>
         *   </logical_units>
         *   <type>iscsi</type>
         *   <host id="8bb5ade5-e988-4000-8b93-dbfc6717fe50"/>
         * </host_storage>
         * ----
         * 
         * Here an example without the LUN status :
         * 
         * [source,xml]
         * ----
         * <host_storage id="360014051136c20574f743bdbd28177fd">
         *   <logical_units>
         *     <logical_unit id="360014051136c20574f743bdbd28177fd">
         *       <lun_mapping>0</lun_mapping>
         *       <paths>1</paths>
         *       <product_id>lun0</product_id>
         *       <serial>SLIO-ORG_lun0_1136c205-74f7-43bd-bd28-177fd5ce6993</serial>
         *       <size>10737418240</size>
         *       <vendor_id>LIO-ORG</vendor_id>
         *       <volume_group_id>O9Du7I-RahN-ECe1-dZ1w-nh0b-64io-MNzIBZ</volume_group_id>
         *     </logical_unit>
         *   </logical_units>
         *   <type>iscsi</type>
         *   <host id="8bb5ade5-e988-4000-8b93-dbfc6717fe50"/>
         * </host_storage>
         * ----
         */
        GetRequest reportStatus(Boolean reportStatus);
    }
    
    public interface GetResponse extends Response {
        HostStorage storage();
    }
    
    GetRequest get();
    
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

