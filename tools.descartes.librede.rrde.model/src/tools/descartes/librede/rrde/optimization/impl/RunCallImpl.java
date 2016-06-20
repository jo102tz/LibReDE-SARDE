/**
 */
package tools.descartes.librede.rrde.optimization.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import tools.descartes.librede.configuration.EstimationSpecification;

import tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithm;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.optimization.OptimizationSettings;
import tools.descartes.librede.rrde.optimization.RunCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Run Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl#getTrainingData <em>Training Data</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl#getEstimationSpecification <em>Estimation Specification</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RunCallImpl extends MinimalEObjectImpl.Container implements RunCall {
	/**
	 * The cached value of the '{@link #getTrainingData() <em>Training Data</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrainingData()
	 * @generated
	 * @ordered
	 */
	protected EList<InputData> trainingData;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected IConfigurationOptimizationAlgorithm algorithm;

	/**
	 * The cached value of the '{@link #getEstimationSpecification() <em>Estimation Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstimationSpecification()
	 * @generated
	 * @ordered
	 */
	protected EstimationSpecification estimationSpecification;

	/**
	 * The cached value of the '{@link #getSettings() <em>Settings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSettings()
	 * @generated
	 * @ordered
	 */
	protected OptimizationSettings settings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RunCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimizationPackage.Literals.RUN_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputData> getTrainingData() {
		if (trainingData == null) {
			trainingData = new EObjectResolvingEList<InputData>(InputData.class, this, OptimizationPackage.RUN_CALL__TRAINING_DATA);
		}
		return trainingData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConfigurationOptimizationAlgorithm getAlgorithm() {
		if (algorithm != null && algorithm.eIsProxy()) {
			InternalEObject oldAlgorithm = (InternalEObject)algorithm;
			algorithm = (IConfigurationOptimizationAlgorithm)eResolveProxy(oldAlgorithm);
			if (algorithm != oldAlgorithm) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OptimizationPackage.RUN_CALL__ALGORITHM, oldAlgorithm, algorithm));
			}
		}
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConfigurationOptimizationAlgorithm basicGetAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithm(IConfigurationOptimizationAlgorithm newAlgorithm) {
		IConfigurationOptimizationAlgorithm oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.RUN_CALL__ALGORITHM, oldAlgorithm, algorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EstimationSpecification getEstimationSpecification() {
		if (estimationSpecification != null && estimationSpecification.eIsProxy()) {
			InternalEObject oldEstimationSpecification = (InternalEObject)estimationSpecification;
			estimationSpecification = (EstimationSpecification)eResolveProxy(oldEstimationSpecification);
			if (estimationSpecification != oldEstimationSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION, oldEstimationSpecification, estimationSpecification));
			}
		}
		return estimationSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EstimationSpecification basicGetEstimationSpecification() {
		return estimationSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEstimationSpecification(EstimationSpecification newEstimationSpecification) {
		EstimationSpecification oldEstimationSpecification = estimationSpecification;
		estimationSpecification = newEstimationSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION, oldEstimationSpecification, estimationSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationSettings getSettings() {
		if (settings != null && settings.eIsProxy()) {
			InternalEObject oldSettings = (InternalEObject)settings;
			settings = (OptimizationSettings)eResolveProxy(oldSettings);
			if (settings != oldSettings) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OptimizationPackage.RUN_CALL__SETTINGS, oldSettings, settings));
			}
		}
		return settings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationSettings basicGetSettings() {
		return settings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSettings(OptimizationSettings newSettings) {
		OptimizationSettings oldSettings = settings;
		settings = newSettings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.RUN_CALL__SETTINGS, oldSettings, settings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptimizationPackage.RUN_CALL__TRAINING_DATA:
				return getTrainingData();
			case OptimizationPackage.RUN_CALL__ALGORITHM:
				if (resolve) return getAlgorithm();
				return basicGetAlgorithm();
			case OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION:
				if (resolve) return getEstimationSpecification();
				return basicGetEstimationSpecification();
			case OptimizationPackage.RUN_CALL__SETTINGS:
				if (resolve) return getSettings();
				return basicGetSettings();
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
			case OptimizationPackage.RUN_CALL__TRAINING_DATA:
				getTrainingData().clear();
				getTrainingData().addAll((Collection<? extends InputData>)newValue);
				return;
			case OptimizationPackage.RUN_CALL__ALGORITHM:
				setAlgorithm((IConfigurationOptimizationAlgorithm)newValue);
				return;
			case OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION:
				setEstimationSpecification((EstimationSpecification)newValue);
				return;
			case OptimizationPackage.RUN_CALL__SETTINGS:
				setSettings((OptimizationSettings)newValue);
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
			case OptimizationPackage.RUN_CALL__TRAINING_DATA:
				getTrainingData().clear();
				return;
			case OptimizationPackage.RUN_CALL__ALGORITHM:
				setAlgorithm((IConfigurationOptimizationAlgorithm)null);
				return;
			case OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION:
				setEstimationSpecification((EstimationSpecification)null);
				return;
			case OptimizationPackage.RUN_CALL__SETTINGS:
				setSettings((OptimizationSettings)null);
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
			case OptimizationPackage.RUN_CALL__TRAINING_DATA:
				return trainingData != null && !trainingData.isEmpty();
			case OptimizationPackage.RUN_CALL__ALGORITHM:
				return algorithm != null;
			case OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION:
				return estimationSpecification != null;
			case OptimizationPackage.RUN_CALL__SETTINGS:
				return settings != null;
		}
		return super.eIsSet(featureID);
	}

} //RunCallImpl
