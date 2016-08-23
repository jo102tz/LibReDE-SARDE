/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tools.descartes.librede.configuration.EstimationAlgorithmConfiguration;
import tools.descartes.librede.configuration.LibredeConfiguration;

import tools.descartes.librede.rrde.recommendation.DataSet;
import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.DataSetImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.DataSetImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.DataSetImpl#getEstimationErrors <em>Estimation Errors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataSetImpl extends MinimalEObjectImpl.Container implements DataSet {
	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected LibredeConfiguration configuration;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected FeatureVector features;

	/**
	 * The cached value of the '{@link #getEstimationErrors() <em>Estimation Errors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstimationErrors()
	 * @generated
	 * @ordered
	 */
	protected Map<EstimationAlgorithmConfiguration, Double> estimationErrors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.DATA_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibredeConfiguration getConfiguration() {
		if (configuration != null && configuration.eIsProxy()) {
			InternalEObject oldConfiguration = (InternalEObject)configuration;
			configuration = (LibredeConfiguration)eResolveProxy(oldConfiguration);
			if (configuration != oldConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.DATA_SET__CONFIGURATION, oldConfiguration, configuration));
			}
		}
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibredeConfiguration basicGetConfiguration() {
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(LibredeConfiguration newConfiguration) {
		LibredeConfiguration oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.DATA_SET__CONFIGURATION, oldConfiguration, configuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureVector getFeatures() {
		if (features != null && features.eIsProxy()) {
			InternalEObject oldFeatures = (InternalEObject)features;
			features = (FeatureVector)eResolveProxy(oldFeatures);
			if (features != oldFeatures) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.DATA_SET__FEATURES, oldFeatures, features));
			}
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureVector basicGetFeatures() {
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatures(FeatureVector newFeatures) {
		FeatureVector oldFeatures = features;
		features = newFeatures;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.DATA_SET__FEATURES, oldFeatures, features));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<EstimationAlgorithmConfiguration, Double> getEstimationErrors() {
		return estimationErrors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEstimationErrors(Map<EstimationAlgorithmConfiguration, Double> newEstimationErrors) {
		Map<EstimationAlgorithmConfiguration, Double> oldEstimationErrors = estimationErrors;
		estimationErrors = newEstimationErrors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.DATA_SET__ESTIMATION_ERRORS, oldEstimationErrors, estimationErrors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.DATA_SET__CONFIGURATION:
				if (resolve) return getConfiguration();
				return basicGetConfiguration();
			case RecommendationPackage.DATA_SET__FEATURES:
				if (resolve) return getFeatures();
				return basicGetFeatures();
			case RecommendationPackage.DATA_SET__ESTIMATION_ERRORS:
				return getEstimationErrors();
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
			case RecommendationPackage.DATA_SET__CONFIGURATION:
				setConfiguration((LibredeConfiguration)newValue);
				return;
			case RecommendationPackage.DATA_SET__FEATURES:
				setFeatures((FeatureVector)newValue);
				return;
			case RecommendationPackage.DATA_SET__ESTIMATION_ERRORS:
				setEstimationErrors((Map<EstimationAlgorithmConfiguration, Double>)newValue);
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
			case RecommendationPackage.DATA_SET__CONFIGURATION:
				setConfiguration((LibredeConfiguration)null);
				return;
			case RecommendationPackage.DATA_SET__FEATURES:
				setFeatures((FeatureVector)null);
				return;
			case RecommendationPackage.DATA_SET__ESTIMATION_ERRORS:
				setEstimationErrors((Map<EstimationAlgorithmConfiguration, Double>)null);
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
			case RecommendationPackage.DATA_SET__CONFIGURATION:
				return configuration != null;
			case RecommendationPackage.DATA_SET__FEATURES:
				return features != null;
			case RecommendationPackage.DATA_SET__ESTIMATION_ERRORS:
				return estimationErrors != null;
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
		result.append(" (estimationErrors: ");
		result.append(estimationErrors);
		result.append(')');
		return result.toString();
	}

} //DataSetImpl
