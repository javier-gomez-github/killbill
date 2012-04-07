/*
 * Copyright 2010-2011 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.catalog.overdue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.ning.billing.account.api.Account;
import com.ning.billing.catalog.StandaloneCatalog;
import com.ning.billing.catalog.api.overdue.OverdueStateSet;
import com.ning.billing.entitlement.api.user.SubscriptionBundle;
import com.ning.billing.util.config.ValidatingConfig;
import com.ning.billing.util.config.ValidationErrors;

@XmlAccessorType(XmlAccessType.NONE)
public class OverdueRules  extends ValidatingConfig<StandaloneCatalog> {

    @XmlElement(required=false, name="bundleOverdueStates")
    private OverdueStatesBundle bundleOverdueStates;
    
    @XmlElement(required=false, name="accountOverdueStates")
    private OverdueStatesAccount accountOverdueStates;


    public DefaultOverdueStateSet<SubscriptionBundle> getBundleStateSet() {
        return bundleOverdueStates;
    }


    @Override
    public ValidationErrors validate(StandaloneCatalog root,
            ValidationErrors errors) {
        return bundleOverdueStates.validate(root, errors);
    }


    public DefaultOverdueStateSet<Account> getAccountStateSet() {
        return accountOverdueStates;
    }
}
