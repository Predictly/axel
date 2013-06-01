/**
 * Copyright (C) 2013 Inera AB (http://www.inera.se)
 *
 * This file is part of Inera Axel (http://code.google.com/p/inera-axel).
 *
 * Inera Axel is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Inera Axel is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package se.inera.axel.shs.messagestore;

import se.inera.axel.shs.exception.ShsException;
import se.inera.axel.shs.xml.label.ShsLabel;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class ShsMessageEntry implements Serializable {


    private String id;

    private ShsLabel label;

    private MessageState state;

    private Date stateTimeStamp;

    private ShsException shsException;

    private int retries;

    public ShsMessageEntry() {

    }

    // TODO add more fields. What do we need?

    public ShsLabel getLabel() {
        return label;
    }

    public void setLabel(ShsLabel label) {
        this.label = label;
    }

    public MessageState getState() {
        return state;
    }

    public void setState(MessageState state) {
        this.state = state;
    }

    public Date getStateTimeStamp() {
        return stateTimeStamp;
    }

    public void setStateTimeStamp(Date stateTimeStamp) {
        this.stateTimeStamp = stateTimeStamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setShsException(ShsException e) {
        this.shsException = e;
    }

    public ShsException getShsException() {
        return this.shsException;
    }

    public boolean isError() {
        return this.shsException != null;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

    public static ShsMessageEntry createNewEntry(ShsLabel label) {
        ShsMessageEntry entry = new ShsMessageEntry();
        entry.setLabel(label);
        entry.setId(UUID.randomUUID().toString());
        return entry;
    }

    @Override
    public String toString() {
        return "ShsMessageEntry{" +
                "id='" + id + '\'' +
                ", label=" + label +
                ", state=" + state +
                ", stateTimeStamp=" + stateTimeStamp +
                ", shsException=" + shsException +
                ", retries=" + retries +
                '}';
    }
}