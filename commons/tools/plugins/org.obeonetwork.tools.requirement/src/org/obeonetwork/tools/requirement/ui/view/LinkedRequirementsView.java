/**
 * 
 */
package org.obeonetwork.tools.requirement.ui.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.operation.WizardEditingOperation;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.obeonetwork.tools.linker.ui.view.EObjectLinksView;
import org.obeonetwork.tools.linker.ui.view.util.EObjectLinkContentProvider;
import org.obeonetwork.tools.requirement.RequirementLinkerPlugin;
import org.obeonetwork.tools.requirement.core.RequirementLink;
import org.obeonetwork.tools.requirement.ui.view.action.CreateRequirementAction;
import org.obeonetwork.tools.requirement.ui.view.action.EditRequirementAction;
import org.obeonetwork.tools.requirement.ui.view.action.LinkRequirementAction;
import org.obeonetwork.tools.requirement.ui.view.action.UnlinkRequirementAction;
import org.obeonetwork.tools.requirement.ui.view.util.LinkedRequirementsContentProvider;
import org.obeonetwork.tools.requirement.ui.view.util.LinkedRequirementsLableProvider;
import org.obeonetwork.tools.requirement.wizard.operation.RequirementEditingOperation;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class LinkedRequirementsView extends EObjectLinksView {

	public static final String ID = "org.obeonetwork.tools.requirement.views.LinkedRequirementsView"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#addColumns()
	 */
	@Override
	protected void addColumns() {
		addColumn(RequirementLinkerPlugin.getInstance().getString("LinkedRequirementsView_IDColumn_title"), 20); //$NON-NLS-1$
		addColumn(RequirementLinkerPlugin.getInstance().getString("LinkedRequirementsView_NameColumn_title"), 40); //$NON-NLS-1$
		addColumn(RequirementLinkerPlugin.getInstance().getString("LinkedRequirementsView_CategoryColumn_title"), 40); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#createContentProvider()
	 */
	@Override
	protected EObjectLinkContentProvider createContentProvider() {
		return new LinkedRequirementsContentProvider();
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#createLabelProvider()
	 */
	@Override
	protected CellLabelProvider createLabelProvider() {
		return new LinkedRequirementsLableProvider(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#createFilters()
	 */
	@Override
	protected List<ViewerFilter> createFilters() {
		List<ViewerFilter> result = new ArrayList<ViewerFilter>();
		result.add(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return element instanceof RequirementLink;
			}
		});
		return result;
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#fillLocalActionBar()
	 */
	@Override
	protected void fillLocalActionBar() {
		getViewSite().getActionBars().getToolBarManager().add(new CreateRequirementAction(this));
		getViewSite().getActionBars().getToolBarManager().add(new EditRequirementAction(this));
		getViewSite().getActionBars().getToolBarManager().add(new LinkRequirementAction(this));
		getViewSite().getActionBars().getToolBarManager().add(new UnlinkRequirementAction(this));
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.tools.linker.ui.view.EObjectLinksView#createDoubleClickAction()
	 */
	@Override
	protected Action createDoubleClickAction() {
		return new Action() {

			/**
			 * {@inheritDoc}
			 * @see org.eclipse.jface.action.Action#run()
			 */
			@Override
			public void run() {
				if (getSelectedEntries().size() > 0) {
					RequirementLink eObjectLink = (RequirementLink) getSelectedEntries().get(0);
					
					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(getInput());
					DomainPropertiesEditionContext propertiesEditionContext = new DomainPropertiesEditionContext(
							null, null, editingDomain, adapterFactory, eObjectLink.getRequirement());
					WizardEditingOperation operation = new RequirementEditingOperation(propertiesEditionContext);
					try {
						operation.execute(new NullProgressMonitor(), null);
						refresh();
					} catch (ExecutionException e) {
						EEFRuntimePlugin.getDefault().logError("An error occured during wizard editing.", e); //$NON-NLS-1$
					} 
				}
			}

		};
	}

	@Override
	protected String getShowChildrenActionTitle() {
		return RequirementLinkerPlugin.getInstance().getString("LinkedRequirementsView_ShowChildrenAction_title");
	}

	@Override
	protected String getShowChildrenActionDescription() {
		return RequirementLinkerPlugin.getInstance().getString("LinkedRequirementsView_ShowChildrenAction_description");
	}
}
