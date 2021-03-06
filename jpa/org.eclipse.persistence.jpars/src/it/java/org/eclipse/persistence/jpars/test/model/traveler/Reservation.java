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
//      gonural - initial
package org.eclipse.persistence.jpars.test.model.traveler;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import org.eclipse.persistence.annotations.FetchGroup;

@FetchGroup(name = "1", attributes = {})
@Entity
@Table(name = "JPARS_RESERVATION")
public class Reservation {
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue
    private int id;

    @Basic
    private String city;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String country;

    public Reservation() {
    }

    public Reservation(String city, String country, String province, String postalCode, String street) {
        super();
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int addressId) {
        this.id = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
