/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.obeonetwork.dsl.database.dbevolution;

import org.eclipse.emf.compare.Match;
import org.obeonetwork.dsl.database.Index;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Update Index</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.database.dbevolution.UpdateIndex#getNewIndex <em>New Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdateIndex()
 * @model
 * @generated
 */
public interface UpdateIndex extends IndexChange {

	/**
	 * Returns the value of the '<em><b>New Index</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Index</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Index</em>' reference.
	 * @see #setNewIndex(Index)
	 * @see org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage#getUpdateIndex_NewIndex()
	 * @model required="true"
	 * @generated
	 */
	Index getNewIndex();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.database.dbevolution.UpdateIndex#getNewIndex <em>New Index</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Index</em>' reference.
	 * @see #getNewIndex()
	 * @generated
	 */
	void setNewIndex(Index value);
} // UpdateIndex
