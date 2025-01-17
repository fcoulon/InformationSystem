/**
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.tools.projectlibrary.ui.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.ext.base.Option;

/**
 * Utility class used by wizards
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class WizardUtils {

	/**
	 * Return all modeling projects in workspace
	 * @return
	 */
	public static List<ModelingProject> getAllModelingProjects() {
		List<ModelingProject> modelingProjects = new ArrayList<>();
		
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        IProject[] projects = workspaceRoot.getProjects();
        for(int i = 0; i < projects.length; i++) {
           IProject project = projects[i];
           if(project.isOpen() && ModelingProject.hasModelingProjectNature(project)) {
        	   Option<ModelingProject> optionModelingProject = ModelingProject.asModelingProject(project);
        	   modelingProjects.add(optionModelingProject.get());
           }
        }
        return modelingProjects;
	}
}
