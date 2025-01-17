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
package org.obeonetwork.database.transfo;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import org.obeonetwork.database.scaffold.ScaffoldInfo;
import org.obeonetwork.database.scaffold.ScaffoldType;

public interface Transformation {
	
	public boolean transform(URI scaffoldInfoURI, ScaffoldType scaffoldType);
	public boolean transform(ScaffoldInfo scaffoldInfo, ScaffoldType scaffoldType);
	public boolean doTransformationFirstStep(ScaffoldInfo scaffoldInfo, ScaffoldType scaffoldType);
	public void doTransformationFinalStep();
	public Resource getResult();
	public void setSaveFinalResource(boolean saveFinalResource);
}
