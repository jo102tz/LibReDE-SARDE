/**
 */
package tools.descartes.librede.rrde.optimization.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.descartes.librede.configuration.EstimationSpecification;

import tools.descartes.librede.rrde.optimization.IConfigurationOptimizationAlgorithmSpecifier;
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
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl#getTrainingData <em>Training Data</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl#getSettings <em>Settings</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl#getEstimation <em>Estimation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RunCallImpl extends MinimalEObjectImpl.Container implements RunCall {
	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected IConfigurationOptimizationAlgorithmSpecifier algorithm;

	/**
	 * The cached value of the '{@link #getTrainingData() <em>Training Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrainingData()
	 * @generated
	 * @ordered
	 */
	protected EList<InputData> trainingData;

	/**
	 * The cached value of the '{@link #getSettings() <em>Settings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSettings()
	 * @generated
	 * @ordered
	 */
	protected OptimizationSettings settings;

	/**
	 * The cached value of the '{@link #getEstimation() <em>Estimation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstimation()
	 * @generated
	 * @ordered
	 */
	protected EstimationSpecification estimation;

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
	public IConfigurationOptimizationAlgorithmSpecifier getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlgorithm(IConfigurationOptimizationAlgorithmSpecifier newAlgorithm, NotificationChain msgs) {
		IConfigurationOptimizationAlgorithmSpecifier oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptimizationPackage.RUN_CALL__ALGORITHM, oldAlgorithm, newAlgorithm);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithm(IConfigurationOptimizationAlgorithmSpecifier newAlgorithm) {
		if (newAlgorithm != algorithm) {
			NotificationChain msgs = null;
			if (algorithm != null)
				msgs = ((InternalEObject)algorithm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.RUN_CALL__ALGORITHM, null, msgs);
			if (newAlgorithm != null)
				msgs = ((InternalEObject)newAlgorithm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.RUN_CALL__ALGORITHM, null, msgs);
			msgs = basicSetAlgorithm(newAlgorithm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.RUN_CALL__ALGORITHM, newAlgorithm, newAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputData> getTrainingData() {
		if (trainingData == null) {
			trainingData = new EObjectContainmentEList<InputData>(InputData.class, this, OptimizationPackage.RUN_CALL__TRAINING_DATA);
		}
		return trainingData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationSettings getSettings() {
		return settings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSettings(OptimizationSettings newSettings, NotificationChain msgs) {
		OptimizationSettings oldSettings = settings;
		settings = newSettings;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptimizationPackage.RUN_CALL__SETTINGS, oldSettings, newSettings);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSettings(OptimizationSettings newSettings) {
		if (newSettings != settings) {
			NotificationChain msgs = null;
			if (settings != null)
				msgs = ((InternalEObject)settings).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.RUN_CALL__SETTINGS, null, msgs);
			if (newSettings != null)
				msgs = ((InternalEObject)newSettings).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.RUN_CALL__SETTINGS, null, msgs);
			msgs = basicSetSettings(newSettings, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.RUN_CALL__SETTINGS, newSettings, newSettings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EstimationSpecification getEstimation() {
		return estimation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEstimation(EstimationSpecification newEstimation, NotificationChain msgs) {
		EstimationSpecification oldEstimation = estimation;
		estimation = newEstimation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptimizationPackage.RUN_CALL__ESTIMATION, oldEstimation, newEstimation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEstimation(EstimationSpecification newEstimation) {
		if (newEstimation != estimation) {
			NotificationChain msgs = null;
			if (estimation != null)
				msgs = ((InternalEObject)estimation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.RUN_CALL__ESTIMATION, null, msgs);
			if (newEstimation != null)
				msgs = ((InternalEObject)newEstimation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.RUN_CALL__ESTIMATION, null, msgs);
			msgs = basicSetEstimation(newEstimation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.RUN_CALL__ESTIMATION, newEstimation, newEstimation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OptimizationPackage.RUN_CALL__ALGORITHM:
				return basicSetAlgorithm(null, msgs);
			case OptimizationPackage.RUN_CALL__TRAINING_DATA:
				return ((InternalEList<?>)getTrainingData()).basicRemove(otherEnd, msgs);
			case OptimizationPackage.RUN_CALL__SETTINGS:
				return basicSetSettings(null, msgs);
			case OptimizationPackage.RUN_CALL__ESTIMATION:
				return basicSetEstimation(null, msgs);
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
			case OptimizationPackage.RUN_CALL__ALGORITHM:
				return getAlgorithm();
			case OptimizationPackage.RUN_CALL__TRAINING_DATA:
				return getTrainingData();
			case OptimizationPackage.RUN_CALL__SETTINGS:
				return getSettings();
			case OptimizationPackage.RUN_CALL__ESTIMATION:
				return getEstimation();
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
			case OptimizationPackage.RUN_CALL__ALGORITHM:
				setAlgorithm((IConfigurationOptimizationAlgorithmSpecifier)newValue);
				return;
			case OptimizationPackage.RUN_CALL__TRAINING_DATA:
				getTrainingData().clear();
				getTrainingData().addAll((Collection<? extends InputData>)newValue);
				return;
			case OptimizationPackage.RUN_CALL__SETTINGS:
				setSettings((OptimizationSettings)newValue);
				return;
			case OptimizationPackage.RUN_CALL__ESTIMATION:
				setEstimation((EstimationSpecification)newValue);
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
			case OptimizationPackage.RUN_CALL__ALGORITHM:
				setAlgorithm((IConfigurationOptimizationAlgorithmSpecifier)null);
				return;
			case OptimizationPackage.RUN_CALL__TRAINING_DATA:
				getTrainingData().clear();
				return;
			case OptimizationPackage.RUN_CALL__SETTINGS:
				setSettings((OptimizationSettings)null);
				return;
			case OptimizationPackage.RUN_CALL__ESTIMATION:
				setEstimation((EstimationSpecification)null);
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
			case OptimizationPackage.RUN_CALL__ALGORITHM:
				return algorithm != null;
			case OptimizationPackage.RUN_CALL__TRAINING_DATA:
				return trainingData != null && !trainingData.isEmpty();
			case OptimizationPackage.RUN_CALL__SETTINGS:
				return settings != null;
			case OptimizationPackage.RUN_CALL__ESTIMATION:
				return estimation != null;
		}
		return super.eIsSet(featureID);
	}

} //RunCallImpl
