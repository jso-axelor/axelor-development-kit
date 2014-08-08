/**
 * Axelor Business Solutions
 *
 * Copyright (C) 2012-2014 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.meta.schema.views;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonTypeName;

@XmlType
@JsonTypeName("field")
public class PanelField extends Field {
	
	@XmlElementWrapper(name = "editor")
	@XmlElements({
		@XmlElement(name = "field", type = PanelField.class),
		@XmlElement(name = "spacer", type = Spacer.class),
		@XmlElement(name = "label", type = Label.class),
	})
	private List<AbstractWidget> items;
	
	public List<AbstractWidget> getItems() {
		return items;
	}
	
	public void setItems(List<AbstractWidget> items) {
		if(items != null) {
			for (AbstractWidget widget : items) {
				widget.setModel(super.getModel());
			}
		}
		this.items = items;
	}
}