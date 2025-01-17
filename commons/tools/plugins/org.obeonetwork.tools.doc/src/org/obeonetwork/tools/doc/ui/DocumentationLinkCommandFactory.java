/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.tools.doc.ui;

import org.eclipse.core.commands.IHandler;
import org.obeonetwork.tools.doc.core.DocumentationLink;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public interface DocumentationLinkCommandFactory {
	
	/**
	 * Creates a new {@link IHandler} to open the given {@link DocumentationLink}.
	 * @param entry to open
	 * @return the Handler opening the given {@link DocumentationLink}.
	 */
	IHandler createOpenCommand(DocumentationLink entry);
}
