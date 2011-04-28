/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.User#getUid <em>Uid</em>}</li>
 *   <li>{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.User#getFullName <em>Full Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.ExampleinteractionmodelPackage#getUser()
 * @model
 * @generated
 */
public interface User extends EObject {
	/**
	 * Returns the value of the '<em><b>Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uid</em>' attribute.
	 * @see #setUid(String)
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.ExampleinteractionmodelPackage#getUser_Uid()
	 * @model
	 * @generated
	 */
	String getUid();

	/**
	 * Sets the value of the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.User#getUid <em>Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uid</em>' attribute.
	 * @see #getUid()
	 * @generated
	 */
	void setUid(String value);

	/**
	 * Returns the value of the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Full Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Full Name</em>' attribute.
	 * @see #setFullName(String)
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.ExampleinteractionmodelPackage#getUser_FullName()
	 * @model
	 * @generated
	 */
	String getFullName();

	/**
	 * Sets the value of the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.User#getFullName <em>Full Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Full Name</em>' attribute.
	 * @see #getFullName()
	 * @generated
	 */
	void setFullName(String value);

} // User
