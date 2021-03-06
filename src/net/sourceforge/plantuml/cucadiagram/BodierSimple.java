/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2020, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
 * 
 * If you like this project or if you find it useful, you can support us at:
 * 
 * http://plantuml.com/patreon (only 1$ per month!)
 * http://plantuml.com/paypal
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 * 
 *
 */
package net.sourceforge.plantuml.cucadiagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sourceforge.plantuml.FontParam;
import net.sourceforge.plantuml.ISkinParam;
import net.sourceforge.plantuml.graphic.HorizontalAlignment;
import net.sourceforge.plantuml.graphic.TextBlock;
import net.sourceforge.plantuml.style.Style;
import net.sourceforge.plantuml.ugraphic.color.NoSuchColorException;

public class BodierSimple implements Bodier {

	private final List<CharSequence> rawBody = new ArrayList<CharSequence>();
	private ILeaf leaf;

	public void muteClassToObject() {
		throw new UnsupportedOperationException();
	}

	BodierSimple() {
	}

	public void setLeaf(ILeaf leaf) {
		if (leaf == null) {
			throw new IllegalArgumentException();
		}
		this.leaf = leaf;
	}

	public void addFieldOrMethod(String s) throws NoSuchColorException {
		final Display display = Display.getWithNewlines2(s);
		rawBody.addAll(display.asList());
	}

	public Display getMethodsToDisplay() {
		throw new UnsupportedOperationException();
	}

	public Display getFieldsToDisplay() {
		throw new UnsupportedOperationException();
	}

	public boolean hasUrl() {
		return false;
	}

	public List<CharSequence> getRawBody() {
		return Collections.unmodifiableList(rawBody);
	}

	public TextBlock getBody(FontParam fontParam, ISkinParam skinParam, boolean showMethods, boolean showFields,
			Stereotype stereotype, Style style) {
		return BodyFactory.create1(skinParam.getDefaultTextAlignment(HorizontalAlignment.LEFT), rawBody, fontParam,
				skinParam, stereotype, leaf, style);
	}

}
