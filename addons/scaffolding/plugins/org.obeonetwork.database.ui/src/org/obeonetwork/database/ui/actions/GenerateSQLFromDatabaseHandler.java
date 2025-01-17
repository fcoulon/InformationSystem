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
package org.obeonetwork.database.ui.actions;

import org.eclipse.emf.compare.Comparison;

public class GenerateSQLFromDatabaseHandler extends AbstractGenerateScriptsFromDatabaseHandler {

	@Override
	protected void doGenerate(Comparison comparison) {
		ExportAsSQLScriptsAction action = new ExportAsSQLScriptsAction();
		action.exportComparison(comparison);
	}

}
