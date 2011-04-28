/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.ExampleinteractionmodelPackage
 * @generated
 */
public interface ExampleinteractionmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExampleinteractionmodelFactory eINSTANCE = ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Home</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Home</em>'.
	 * @generated
	 */
	Home createHome();

	/**
	 * Returns a new object of class '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
	User createUser();

	/**
	 * Returns a new object of class '<em>Order</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Order</em>'.
	 * @generated
	 */
	Order createOrder();

	/**
	 * Returns a new object of class '<em>Line Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line Item</em>'.
	 * @generated
	 */
	LineItem createLineItem();

	/**
	 * Returns a new object of class '<em>User Full</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Full</em>'.
	 * @generated
	 */
	UserFull createUserFull();

	/**
	 * Returns a new object of class '<em>Customer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Customer</em>'.
	 * @generated
	 */
	Customer createCustomer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExampleinteractionmodelPackage getExampleinteractionmodelPackage();

} //ExampleinteractionmodelFactory
