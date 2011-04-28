/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.ExampleinteractionmodelFactory
 * @model kind="package"
 * @generated
 */
public interface ExampleinteractionmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "exampleinteractionmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://exampleinteractionmodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "exampleinteractionmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExampleinteractionmodelPackage eINSTANCE = ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.HomeImpl <em>Home</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.HomeImpl
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getHome()
	 * @generated
	 */
	int HOME = 0;

	/**
	 * The feature id for the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME__EREFERENCE0 = 0;

	/**
	 * The feature id for the '<em><b>Current User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME__CURRENT_USER = 1;

	/**
	 * The feature id for the '<em><b>Customers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME__CUSTOMERS = 2;

	/**
	 * The number of structural features of the '<em>Home</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOME_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.UserImpl
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getUser()
	 * @generated
	 */
	int USER = 1;

	/**
	 * The feature id for the '<em><b>Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__UID = 0;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__FULL_NAME = 1;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.OrderImpl <em>Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.OrderImpl
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getOrder()
	 * @generated
	 */
	int ORDER = 2;

	/**
	 * The number of structural features of the '<em>Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.LineItemImpl <em>Line Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.LineItemImpl
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getLineItem()
	 * @generated
	 */
	int LINE_ITEM = 3;

	/**
	 * The number of structural features of the '<em>Line Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_ITEM_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.UserFullImpl <em>User Full</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.UserFullImpl
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getUserFull()
	 * @generated
	 */
	int USER_FULL = 4;

	/**
	 * The feature id for the '<em><b>Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FULL__UID = USER__UID;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FULL__FULL_NAME = USER__FULL_NAME;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FULL__EMAIL = USER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Full</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FULL_FEATURE_COUNT = USER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.CustomerImpl <em>Customer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.CustomerImpl
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getCustomer()
	 * @generated
	 */
	int CUSTOMER = 5;

	/**
	 * The number of structural features of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '<em>Email</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getEmail()
	 * @generated
	 */
	int EMAIL = 6;


	/**
	 * Returns the meta object for class '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home <em>Home</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Home</em>'.
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home
	 * @generated
	 */
	EClass getHome();

	/**
	 * Returns the meta object for the reference '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference0</em>'.
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home#getEReference0()
	 * @see #getHome()
	 * @generated
	 */
	EReference getHome_EReference0();

	/**
	 * Returns the meta object for the containment reference '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home#getCurrentUser <em>Current User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Current User</em>'.
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home#getCurrentUser()
	 * @see #getHome()
	 * @generated
	 */
	EReference getHome_CurrentUser();

	/**
	 * Returns the meta object for the reference list '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home#getCustomers <em>Customers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Customers</em>'.
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home#getCustomers()
	 * @see #getHome()
	 * @generated
	 */
	EReference getHome_Customers();

	/**
	 * Returns the meta object for class '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.User#getUid <em>Uid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uid</em>'.
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.User#getUid()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Uid();

	/**
	 * Returns the meta object for the attribute '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.User#getFullName <em>Full Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Name</em>'.
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.User#getFullName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_FullName();

	/**
	 * Returns the meta object for class '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Order <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Order</em>'.
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Order
	 * @generated
	 */
	EClass getOrder();

	/**
	 * Returns the meta object for class '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.LineItem <em>Line Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Item</em>'.
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.LineItem
	 * @generated
	 */
	EClass getLineItem();

	/**
	 * Returns the meta object for class '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.UserFull <em>User Full</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Full</em>'.
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.UserFull
	 * @generated
	 */
	EClass getUserFull();

	/**
	 * Returns the meta object for the attribute '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.UserFull#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.UserFull#getEmail()
	 * @see #getUserFull()
	 * @generated
	 */
	EAttribute getUserFull_Email();

	/**
	 * Returns the meta object for class '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Email</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getEmail();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExampleinteractionmodelFactory getExampleinteractionmodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.HomeImpl <em>Home</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.HomeImpl
		 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getHome()
		 * @generated
		 */
		EClass HOME = eINSTANCE.getHome();

		/**
		 * The meta object literal for the '<em><b>EReference0</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOME__EREFERENCE0 = eINSTANCE.getHome_EReference0();

		/**
		 * The meta object literal for the '<em><b>Current User</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOME__CURRENT_USER = eINSTANCE.getHome_CurrentUser();

		/**
		 * The meta object literal for the '<em><b>Customers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HOME__CUSTOMERS = eINSTANCE.getHome_Customers();

		/**
		 * The meta object literal for the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.UserImpl
		 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>Uid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__UID = eINSTANCE.getUser_Uid();

		/**
		 * The meta object literal for the '<em><b>Full Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__FULL_NAME = eINSTANCE.getUser_FullName();

		/**
		 * The meta object literal for the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.OrderImpl <em>Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.OrderImpl
		 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getOrder()
		 * @generated
		 */
		EClass ORDER = eINSTANCE.getOrder();

		/**
		 * The meta object literal for the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.LineItemImpl <em>Line Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.LineItemImpl
		 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getLineItem()
		 * @generated
		 */
		EClass LINE_ITEM = eINSTANCE.getLineItem();

		/**
		 * The meta object literal for the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.UserFullImpl <em>User Full</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.UserFullImpl
		 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getUserFull()
		 * @generated
		 */
		EClass USER_FULL = eINSTANCE.getUserFull();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_FULL__EMAIL = eINSTANCE.getUserFull_Email();

		/**
		 * The meta object literal for the '{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.CustomerImpl <em>Customer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.CustomerImpl
		 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getCustomer()
		 * @generated
		 */
		EClass CUSTOMER = eINSTANCE.getCustomer();

		/**
		 * The meta object literal for the '<em>Email</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.ExampleinteractionmodelPackageImpl#getEmail()
		 * @generated
		 */
		EDataType EMAIL = eINSTANCE.getEmail();

	}

} //ExampleinteractionmodelPackage
