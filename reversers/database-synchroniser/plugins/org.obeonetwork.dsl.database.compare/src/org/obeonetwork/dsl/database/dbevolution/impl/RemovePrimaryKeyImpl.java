/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.compare.impl.ReferenceChangeImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.dbevolution.PrimaryKeyChange;
import org.obeonetwork.dsl.database.dbevolution.RemovePrimaryKey;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Remove Primary Key</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RemovePrimaryKeyImpl extends PrimaryKeyChangeImpl implements RemovePrimaryKey {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RemovePrimaryKeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DbevolutionPackage.Literals.REMOVE_PRIMARY_KEY;
	}

} // RemovePrimaryKeyImpl
