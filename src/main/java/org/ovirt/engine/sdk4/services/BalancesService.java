/*
 * Copyright oVirt Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.ovirt.engine.sdk4.services;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import org.ovirt.engine.sdk4.Request;
import org.ovirt.engine.sdk4.Response;
import org.ovirt.engine.sdk4.Service;
import org.ovirt.engine.sdk4.builders.BalanceBuilder;
import org.ovirt.engine.sdk4.types.Balance;

public interface BalancesService extends Service {
    /**
     * Add a balance module to a specified user defined scheduling policy.
     */
    public interface AddRequest extends Request<AddRequest, AddResponse> {
        AddRequest balance(Balance balance);
        AddRequest balance(BalanceBuilder balance);
    }
    
    /**
     * Add a balance module to a specified user defined scheduling policy.
     */
    public interface AddResponse extends Response {
        Balance balance();
    }
    
    /**
     * Add a balance module to a specified user defined scheduling policy.
     */
    AddRequest add();
    
    /**
     * Returns the list of balance modules used by the scheduling policy.
     * 
     * The order of the returned balance modules isn't guaranteed.
     */
    public interface ListRequest extends Request<ListRequest, ListResponse> {
        /**
         * Indicates if the results should be filtered according to the permissions of the user.
         */
        ListRequest filter(Boolean filter);
        /**
         * Indicates which inner links should be _followed_. The objects referenced by these links will be fetched as part
         * of the current request. See <<documents/003_common_concepts/follow, here>> for details.
         */
        ListRequest follow(String follow);
        /**
         * Sets the maximum number of balances to return. If not specified all the balances are returned.
         */
        ListRequest max(Integer max);
        /**
         * Sets the maximum number of balances to return. If not specified all the balances are returned.
         */
        ListRequest max(Long max);
        /**
         * Sets the maximum number of balances to return. If not specified all the balances are returned.
         */
        ListRequest max(BigInteger max);
    }
    
    /**
     * Returns the list of balance modules used by the scheduling policy.
     * 
     * The order of the returned balance modules isn't guaranteed.
     */
    public interface ListResponse extends Response {
        List<Balance> balances();
    }
    
    /**
     * Returns the list of balance modules used by the scheduling policy.
     * 
     * The order of the returned balance modules isn't guaranteed.
     */
    ListRequest list();
    
    BalanceService balanceService(String id);
    /**
     * Service locator method, returns individual service on which the URI is dispatched.
     */
    Service service(String path);
}

