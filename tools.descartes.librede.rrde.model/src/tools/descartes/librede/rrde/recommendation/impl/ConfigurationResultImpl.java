/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tools.descartes.librede.configuration.EstimationSpecification;

import tools.descartes.librede.rrde.recommendation.ConfigurationResult;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.ConfigurationResultImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.ConfigurationResultImpl#getErrorValue <em>Error Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationResultImpl extends MinimalEObjectImpl.Container implements ConfigurationResult {
	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EstimationSpecification configuration;

	/**
	 * The default value of the '{@link #getErrorValue() <em>Error Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorValue()
	 * @generated
	 * @ordered
	 */
	protected static final double ERROR_VALUE_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getErrorValue() <em>Error Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorValue()
	 * @generated
	 * @ordered
	 */
	protected double errorValue = ERROR_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.CONFIGURATION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EstimationSpecification getConfiguration() {
		if (configuration != null && configuration.eIsProxy()) {
			InternalEObject oldConfiguration = (InternalEObject)configuration;
			configuration = (EstimationSpecification)eResolveProxy(oldConfiguration);
			if (configuration != oldConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.CONFIGURATION_RESULT__CONFIGURATION, oldConfiguration, configuration));
			}
		}
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EstimationSpecification basicGetConfiguration() {
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(EstimationSpecification newConfiguration) {
		EstimationSpecification oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.CONFIGURATION_RESULT__CONFIGURATION, oldConfiguration, configuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getErrorValue() {
		return errorValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorValue(double newErrorValue) {
		double oldErrorValue = errorValue;
		errorValue = newErrorValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.CONFIGURATION_RESULT__ERROR_VALUE, oldErrorValue, errorValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.CONFIGURATION_RESULT__CONFIGURATION:
				if (resolve) return getConfiguration();
				return basicGetConfiguration();
			case RecommendationPackage.CONFIGURATION_RESULT__ERROR_VALUE:
				return getErrorValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RecommendationPackage.CONFIGURATION_RESULT__CONFIGURATION:
				setConfiguration((EstimationSpecification)newValue);
				return;
			case RecommendationPackage.CONFIGURATION_RESULT__ERROR_VALUE:
				setErrorValue((Double)newValue);
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
			case RecommendationPackage.CONFIGURATION_RESULT__CONFIGURATION:
				setConfiguration((EstimationSpecification)null);
				return;
			case RecommendationPackage.CONFIGURATION_RESULT__ERROR_VALUE:
				setErrorValue(ERROR_VALUE_EDEFAULT);
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
			case RecommendationPackage.CONFIGURATION_RESULT__CONFIGURATION:
				return configuration != null;
			case RecommendationPackage.CONFIGURATION_RESULT__ERROR_VALUE:
				return errorValue != ERROR_VALUE_EDEFAULT;
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
		result.append(" (errorValue: ");
		result.append(errorValue);
		result.append(')');
		return result.toString();
	}

} //ConfigurationResultImpl
