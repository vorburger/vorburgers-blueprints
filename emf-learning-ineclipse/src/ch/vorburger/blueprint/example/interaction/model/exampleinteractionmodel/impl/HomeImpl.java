/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl;

import ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Customer;
import ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.ExampleinteractionmodelPackage;
import ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.Home;
import ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.User;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Home</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.HomeImpl#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.HomeImpl#getCurrentUser <em>Current User</em>}</li>
 *   <li>{@link ch.vorburger.blueprint.example.interaction.model.exampleinteractionmodel.impl.HomeImpl#getCustomers <em>Customers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HomeImpl extends EObjectImpl implements Home {
	/**
	 * The cached value of the '{@link #getEReference0() <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference0()
	 * @generated
	 * @ordered
	 */
	protected Home eReference0;

	/**
	 * The cached value of the '{@link #getCurrentUser() <em>Current User</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentUser()
	 * @generated
	 * @ordered
	 */
	protected User currentUser;

	/**
	 * The cached value of the '{@link #getCustomers() <em>Customers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomers()
	 * @generated
	 * @ordered
	 */
	protected EList<Customer> customers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HomeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExampleinteractionmodelPackage.Literals.HOME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Home getEReference0() {
		if (eReference0 != null && eReference0.eIsProxy()) {
			InternalEObject oldEReference0 = (InternalEObject)eReference0;
			eReference0 = (Home)eResolveProxy(oldEReference0);
			if (eReference0 != oldEReference0) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExampleinteractionmodelPackage.HOME__EREFERENCE0, oldEReference0, eReference0));
			}
		}
		return eReference0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Home basicGetEReference0() {
		return eReference0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReference0(Home newEReference0) {
		Home oldEReference0 = eReference0;
		eReference0 = newEReference0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExampleinteractionmodelPackage.HOME__EREFERENCE0, oldEReference0, eReference0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCurrentUser(User newCurrentUser, NotificationChain msgs) {
		User oldCurrentUser = currentUser;
		currentUser = newCurrentUser;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExampleinteractionmodelPackage.HOME__CURRENT_USER, oldCurrentUser, newCurrentUser);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentUser(User newCurrentUser) {
		if (newCurrentUser != currentUser) {
			NotificationChain msgs = null;
			if (currentUser != null)
				msgs = ((InternalEObject)currentUser).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExampleinteractionmodelPackage.HOME__CURRENT_USER, null, msgs);
			if (newCurrentUser != null)
				msgs = ((InternalEObject)newCurrentUser).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExampleinteractionmodelPackage.HOME__CURRENT_USER, null, msgs);
			msgs = basicSetCurrentUser(newCurrentUser, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExampleinteractionmodelPackage.HOME__CURRENT_USER, newCurrentUser, newCurrentUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Customer> getCustomers() {
		if (customers == null) {
			customers = new EObjectResolvingEList<Customer>(Customer.class, this, ExampleinteractionmodelPackage.HOME__CUSTOMERS);
		}
		return customers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExampleinteractionmodelPackage.HOME__CURRENT_USER:
				return basicSetCurrentUser(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExampleinteractionmodelPackage.HOME__EREFERENCE0:
				if (resolve) return getEReference0();
				return basicGetEReference0();
			case ExampleinteractionmodelPackage.HOME__CURRENT_USER:
				return getCurrentUser();
			case ExampleinteractionmodelPackage.HOME__CUSTOMERS:
				return getCustomers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExampleinteractionmodelPackage.HOME__EREFERENCE0:
				setEReference0((Home)newValue);
				return;
			case ExampleinteractionmodelPackage.HOME__CURRENT_USER:
				setCurrentUser((User)newValue);
				return;
			case ExampleinteractionmodelPackage.HOME__CUSTOMERS:
				getCustomers().clear();
				getCustomers().addAll((Collection<? extends Customer>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExampleinteractionmodelPackage.HOME__EREFERENCE0:
				setEReference0((Home)null);
				return;
			case ExampleinteractionmodelPackage.HOME__CURRENT_USER:
				setCurrentUser((User)null);
				return;
			case ExampleinteractionmodelPackage.HOME__CUSTOMERS:
				getCustomers().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExampleinteractionmodelPackage.HOME__EREFERENCE0:
				return eReference0 != null;
			case ExampleinteractionmodelPackage.HOME__CURRENT_USER:
				return currentUser != null;
			case ExampleinteractionmodelPackage.HOME__CUSTOMERS:
				return customers != null && !customers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //HomeImpl
