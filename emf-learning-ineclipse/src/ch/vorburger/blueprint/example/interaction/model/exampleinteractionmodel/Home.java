/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Home</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home#getCurrentUser <em>Current User</em>}</li>
 *   <li>{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home#getCustomers <em>Customers</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.ExampleinteractionmodelPackage#getHome()
 * @model
 * @generated
 */
public interface Home extends EObject {
	/**
	 * Returns the value of the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference0</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference0</em>' reference.
	 * @see #setEReference0(Home)
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.ExampleinteractionmodelPackage#getHome_EReference0()
	 * @model
	 * @generated
	 */
	Home getEReference0();

	/**
	 * Sets the value of the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home#getEReference0 <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference0</em>' reference.
	 * @see #getEReference0()
	 * @generated
	 */
	void setEReference0(Home value);

	/**
	 * Returns the value of the '<em><b>Current User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current User</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current User</em>' containment reference.
	 * @see #setCurrentUser(User)
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.ExampleinteractionmodelPackage#getHome_CurrentUser()
	 * @model containment="true" required="true"
	 * @generated
	 */
	User getCurrentUser();

	/**
	 * Sets the value of the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home#getCurrentUser <em>Current User</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current User</em>' containment reference.
	 * @see #getCurrentUser()
	 * @generated
	 */
	void setCurrentUser(User value);

	/**
	 * Returns the value of the '<em><b>Customers</b></em>' reference list.
	 * The list contents are of type {@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Customer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customers</em>' reference list.
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.ExampleinteractionmodelPackage#getHome_Customers()
	 * @model
	 * @generated
	 */
	EList<Customer> getCustomers();

} // Home
