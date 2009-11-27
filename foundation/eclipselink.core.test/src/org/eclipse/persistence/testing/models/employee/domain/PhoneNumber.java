/*******************************************************************************
 * Copyright (c) 1998, 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/  
package org.eclipse.persistence.testing.models.employee.domain;

import java.io.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import org.eclipse.persistence.descriptors.changetracking.*;
import org.eclipse.persistence.indirection.*;

/**
 * <p><b>Purpose</b>: Describes an Employee's phone number.
 * <p><b>Description</b>: Used in a 1:M relationship from an employee. Since many people have various numbers
 * they can be contacted at the type describes where the phone number could reach the Employee.
 */
public class PhoneNumber implements Serializable, ChangeTracker {
    // implements ChangeTracker for testing

    /** Holds values such as Home, Work, Cellular, Pager, Fax, etc.  Since the combination of the Employee's ID and
    the type field are what makes the entry in the database unique the type fields must be unique within an
    Employee's Vector of PhoneNumbers.*/
    public String type;
    public String areaCode;

    /** 7 digit number with no hyphen, this is added during toString() only*/
    public String number;

    /** Owner maintains the 1:1 mapping to an Employee (required for 1:M relationship in Employee) */
    public ValueHolderInterface owner;
    public PropertyChangeListener listener;

    public PropertyChangeListener _persistence_getPropertyChangeListener() {
        return listener;
    }

    public void _persistence_setPropertyChangeListener(PropertyChangeListener listener) {
        this.listener = listener;
    }

    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        if (listener != null) {
            if (oldValue != newValue) {
                listener.propertyChange(new PropertyChangeEvent(this, propertyName, oldValue, newValue));
            }
        }
    }

    public void collectionChange(String propertyName, Object oldValue, Object newValue, int changeType) {
        if (listener != null) {
            listener.propertyChange(new CollectionChangeEvent(this, propertyName, oldValue, newValue, changeType));
        }
    }

    public PhoneNumber() {
        this("home", "###", "#######");
    }

    public PhoneNumber(String type, String theAreaCode, String theNumber) {
        this.type = type;
        this.areaCode = theAreaCode;
        this.number = theNumber;
        this.owner = new ValueHolder();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }

    public org.eclipse.persistence.testing.models.employee.interfaces.Employee getOwner() {
        return (Employee)owner.getValue();
    }

    public String getType() {
        return type;
    }

    public void setAreaCode(String areaCode) {
        propertyChange("areaCode", this.areaCode, areaCode);
        this.areaCode = areaCode;
    }

    public void setNumber(String number) {
        propertyChange("number", this.number, number);
        this.number = number;
    }

    public void setOwner(org.eclipse.persistence.testing.models.employee.interfaces.Employee owner) {
        propertyChange("owner", this.owner.getValue(), owner);
        this.owner.setValue(owner);
    }

    public void setType(String type) {
        propertyChange("type", this.type, type);
        this.type = type;
    }

    /**
     * Print the phone.
     * Example: Phone[Work]: (613) 225-8812
     */
    public String toString() {
        StringWriter writer = new StringWriter();

        writer.write("PhoneNumber [");
        writer.write(getType());
        writer.write("]: (");
        writer.write(this.getAreaCode());
        writer.write(")");
        writer.write(this.getNumber().substring(0, Math.min(3, this.getNumber().length())));
        writer.write("-");
        writer.write(this.getNumber().substring(Math.min(3, this.getNumber().length()), Math.min(7, this.getNumber().length())));
        return writer.toString();
    }
}
