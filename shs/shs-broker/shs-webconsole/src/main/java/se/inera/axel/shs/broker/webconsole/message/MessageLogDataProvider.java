/**
 * Copyright (C) 2013 Inera AB (http://www.inera.se)
 *
 * This file is part of Inera Axel (http://code.google.com/p/inera-axel).
 *
 * Inera Axel is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Inera Axel is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package se.inera.axel.shs.broker.webconsole.message;

import com.google.common.collect.Lists;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import se.inera.axel.shs.broker.messagestore.MessageLogAdminService;
import se.inera.axel.shs.broker.messagestore.ShsMessageEntry;

import java.util.Iterator;
import java.util.List;

public class MessageLogDataProvider implements IDataProvider<ShsMessageEntry> {

	private static final long serialVersionUID = 1L;
    MessageLogAdminService messageLogAdminService;
	private List<ShsMessageEntry> messageEntries;
    int size = -1;
    MessageLogAdminService.Filter filter;

	public MessageLogDataProvider(
            MessageLogAdminService messageLogAdminService, MessageLogAdminService.Filter filter) {
		super();
		this.messageLogAdminService = messageLogAdminService;
        this.filter = filter;
	}

	@Override
	public void detach() {
        messageEntries = null;
        size = -1;
	}

	@Override
	public Iterator<ShsMessageEntry> iterator(int first, int count) {
        if (filter != null) {
            filter.setLimit(count);
            filter.setSkip(first);
        }
		if (messageEntries == null) {
            messageEntries = Lists.newArrayList(messageLogAdminService.findMessages(filter));
		}
		return messageEntries.iterator();
	}

    public void reload() {
        messageEntries = null;
        size = -1;
	}

	@Override
	public int size() {
		if (size < 0) {
            size = messageLogAdminService.countMessages(filter);
		}
		return size;
	}

	@Override
	public IModel<ShsMessageEntry> model(ShsMessageEntry messageEntry) {
		return new CompoundPropertyModel<ShsMessageEntry>(messageEntry);
	}

}