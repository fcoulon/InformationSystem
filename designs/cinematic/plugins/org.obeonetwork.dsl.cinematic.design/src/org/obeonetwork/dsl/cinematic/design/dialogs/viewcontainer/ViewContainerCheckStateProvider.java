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
package org.obeonetwork.dsl.cinematic.design.dialogs.viewcontainer;

import org.eclipse.jface.viewers.ICheckStateProvider;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 */
public class ViewContainerCheckStateProvider implements ICheckStateProvider {
	
	private ViewState viewState;
		
	public ViewContainerCheckStateProvider(ViewState viewState) {
		this.viewState = viewState;
	}

	/**
	 * A viewContainer is grayed if it is contained in a viewContainer referenced by the viewState.
	 */
	@Override
	public boolean isGrayed(Object element) {
		return isChecked(((ViewContainer) element).eContainer());
	}
	
	/**
	 * A viewContainer is checked in the tree if it is referenced by the viewState
	 */
	@Override
	public boolean isChecked(Object element) {
		if (element instanceof ViewContainer)
			return viewState.getViewContainers().contains(element) 
					|| isChecked(((ViewContainer) element).eContainer());
		else
			return false;
	}
	
	
}
