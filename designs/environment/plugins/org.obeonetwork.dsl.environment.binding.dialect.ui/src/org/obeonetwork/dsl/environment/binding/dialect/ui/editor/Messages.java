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
package org.obeonetwork.dsl.environment.binding.dialect.ui.editor;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.obeonetwork.dsl.environment.binding.dialect.ui.editor.messages"; //$NON-NLS-1$
	public static String BindingTreeEditor_Button_Label_AutoBind;
	public static String BindingTreeEditor_Error_representationRefresh;
	public static String BindingTreeEditor_Frame_Label_BindingDetails;
	public static String BindingTreeEditor_Frame_Label_Separator;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
