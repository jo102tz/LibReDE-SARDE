/**
 */
package tools.descartes.librede.configuration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.descartes.librede.configuration.ConfigurationPackage;
import tools.descartes.librede.configuration.TraceFilter;
import tools.descartes.librede.configuration.TraceToEntityMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace To Entity Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.configuration.impl.TraceToEntityMappingImpl#getTraceColumn <em>Trace Column</em>}</li>
 *   <li>{@link tools.descartes.librede.configuration.impl.TraceToEntityMappingImpl#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceToEntityMappingImpl extends ObservationToEntityMappingImpl implements TraceToEntityMapping {
	/**
	 * The default value of the '{@link #getTraceColumn() <em>Trace Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceColumn()
	 * @generated
	 * @ordered
	 */
	protected static final int TRACE_COLUMN_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getTraceColumn() <em>Trace Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceColumn()
	 * @generated
	 * @ordered
	 */
	protected int traceColumn = TRACE_COLUMN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFilters() <em>Filters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilters()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceFilter> filters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceToEntityMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.TRACE_TO_ENTITY_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTraceColumn() {
		return traceColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceColumn(int newTraceColumn) {
		int oldTraceColumn = traceColumn;
		traceColumn = newTraceColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.TRACE_TO_ENTITY_MAPPING__TRACE_COLUMN, oldTraceColumn, traceColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TraceFilter> getFilters() {
		if (filters == null) {
			filters = new EObjectContainmentEList<TraceFilter>(TraceFilter.class, this, ConfigurationPackage.TRACE_TO_ENTITY_MAPPING__FILTERS);
		}
		return filters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.TRACE_TO_ENTITY_MAPPING__FILTERS:
				return ((InternalEList<?>)getFilters()).basicRemove(otherEnd, msgs);
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
			case ConfigurationPackage.TRACE_TO_ENTITY_MAPPING__TRACE_COLUMN:
				return getTraceColumn();
			case ConfigurationPackage.TRACE_TO_ENTITY_MAPPING__FILTERS:
				return getFilters();
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
			case ConfigurationPackage.TRACE_TO_ENTITY_MAPPING__TRACE_COLUMN:
				setTraceColumn((Integer)newValue);
				return;
			case ConfigurationPackage.TRACE_TO_ENTITY_MAPPING__FILTERS:
				getFilters().clear();
				getFilters().addAll((Collection<? extends TraceFilter>)newValue);
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
			case ConfigurationPackage.TRACE_TO_ENTITY_MAPPING__TRACE_COLUMN:
				setTraceColumn(TRACE_COLUMN_EDEFAULT);
				return;
			case ConfigurationPackage.TRACE_TO_ENTITY_MAPPING__FILTERS:
				getFilters().clear();
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
			case ConfigurationPackage.TRACE_TO_ENTITY_MAPPING__TRACE_COLUMN:
				return traceColumn != TRACE_COLUMN_EDEFAULT;
			case ConfigurationPackage.TRACE_TO_ENTITY_MAPPING__FILTERS:
				return filters != null && !filters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (traceColumn: ");
		result.append(traceColumn);
		result.append(')');
		return result.toString();
	}

} //TraceToEntityMappingImpl
