/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Full</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.UserFull#getEmail <em>Email</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.ExampleinteractionmodelPackage#getUserFull()
 * @model
 * @generated
 */
public interface UserFull extends User {
	/**
	 * Returns the value of the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email</em>' attribute.
	 * @see #setEmail(String)
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.ExampleinteractionmodelPackage#getUserFull_Email()
	 * @model dataType="ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Email"
	 * @generated
	 */
	String getEmail();

	/**
	 * Sets the value of the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.UserFull#getEmail <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email</em>' attribute.
	 * @see #getEmail()
	 * @generated
	 */
	void setEmail(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void changePassword();

} // UserFull
