/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.preview.handlers;

import java.net.URL;

import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.browser.WebBrowserEditor;
import org.eclipse.ui.internal.browser.WebBrowserEditorInput;

@SuppressWarnings("restriction")
public class SwaggerPreviewHandler extends SwaggerPreviewAbstractHandler {

	private static final String SWAGGER_BROWSER_ID = "org.obeonetwork.dsl.soa.gen.swagger.preview.SwaggerPreviewBrowser";
	
	@Override
	protected void openURL(URL url, String title) throws PartInitException {
		WebBrowserEditorInput webBrowserEditor = new WebBrowserEditorInput(url, SWT.NONE, SWAGGER_BROWSER_ID);
		webBrowserEditor.setName(title);

		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		page.openEditor((IEditorInput) webBrowserEditor, WebBrowserEditor.WEB_BROWSER_EDITOR_ID);
	}

}
