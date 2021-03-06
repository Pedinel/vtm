/*
 * Copyright 2014 Ludwig M Brinckmann
 * Copyright 2016 devemux86
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.oscim.theme;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Entry class for automatically building menus from render theme files.
 * This class holds all the defined layers and allows to retrieve them by name or through iteration.
 * This class is Serializable to be able to pass an instance of it through the Android Intent
 * mechanism.
 */
public class XmlRenderThemeStyleMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String defaultLanguage;
    private final String defaultValue;
    private final String id;
    private final Map<String, XmlRenderThemeStyleLayer> layers;

    public XmlRenderThemeStyleMenu(String id, String defaultLanguage, String defaultValue) {
        this.id = id;
        this.defaultLanguage = defaultLanguage;
        this.defaultValue = defaultValue;
        this.layers = new LinkedHashMap<>();
    }

    public XmlRenderThemeStyleLayer createLayer(String id, boolean visible, boolean enabled) {
        XmlRenderThemeStyleLayer style = new XmlRenderThemeStyleLayer(id, visible, enabled, this.defaultLanguage);
        this.layers.put(id, style);
        return style;
    }

    public String getDefaultLanguage() {
        return this.defaultLanguage;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public String getId() {
        return this.id;
    }

    public XmlRenderThemeStyleLayer getLayer(String id) {
        return this.layers.get(id);
    }

    public Map<String, XmlRenderThemeStyleLayer> getLayers() {
        return this.layers;
    }
}
