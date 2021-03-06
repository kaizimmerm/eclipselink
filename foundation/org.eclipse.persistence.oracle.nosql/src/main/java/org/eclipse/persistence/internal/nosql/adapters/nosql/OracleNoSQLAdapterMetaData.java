/*
 * Copyright (c) 2011, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation
package org.eclipse.persistence.internal.nosql.adapters.nosql;

import jakarta.resource.cci.*;
import org.eclipse.persistence.Version;

/**
 * Defines the meta-data for the Oracle NoSQL adapter
 *
 * @author James
 * @since EclipseLink 2.4
 */
public class OracleNoSQLAdapterMetaData implements ResourceAdapterMetaData {

    /**
     * Default constructor.
     */
    public OracleNoSQLAdapterMetaData() {
    }

    @Override
    public String getAdapterName() {
        return "Oracle NoSQL Adapter";
    }

    @Override
    public String getAdapterShortDescription() {
        return "Oracle NoSQL JCA adapter.";
    }

    @Override
    public String getAdapterVendorName() {
        return "Oracle";
    }

    @Override
    public String getAdapterVersion() {
        return Version.getVersion();
    }

    @Override
    public String[] getInteractionSpecsSupported() {
        String[] specs = new String[2];
        specs[0] = "org.eclipse.persistence.internal.eis.adapters.nosql.AQEnqueueInteractionSpec";
        return specs;
    }

    @Override
    public String getSpecVersion() {
        return "1.5";
    }

    @Override
    public boolean supportsExecuteWithInputAndOutputRecord() {
        return true;
    }

    @Override
    public boolean supportsExecuteWithInputRecordOnly() {
        return true;
    }

    @Override
    public boolean supportsLocalTransactionDemarcation() {
        return true;
    }
}
