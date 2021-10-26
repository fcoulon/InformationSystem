/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.migration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;
import org.obeonetwork.tools.migration.BasicMigrationHelper;

public class DatabaseMigrationHelper extends BasicMigrationHelper {
	 
	@Override
	public EStructuralFeature findEStructuralFeature(EClass eClass, String name, EStructuralFeature found) {
		// pour l'instant ID est recalculée à chaque fois
		// Et techID a été calquée sur techicalid. Pour éviter la perte de donnée, les données de techid 
		// sont insérée dans technicalid
		if (DatabasePackage.eINSTANCE.getDatabaseElement().isSuperTypeOf(eClass)) {
//			System.out.println("Fields analysed : " + eClass.getName() + ":" + name);
//			Enumeration.fields => Enumeration.literals
			if ("techID".equals(name)) {
				found = TechnicalIDPackage.eINSTANCE.getIdentifiable_Technicalid();
			}
		}
		return found;
	}
}
