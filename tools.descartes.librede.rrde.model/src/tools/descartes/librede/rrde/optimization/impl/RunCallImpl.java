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
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl#getTrainingData <em>Training Data</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl#getSettings <em>Settings</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.RunCallImpl#getEstimationSpecification <em>Estimation Specification</em>}</li>
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
	protected IConfigurationOptimizationAlgorithm algorithm;

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
	 * The cached value of the '{@link #getEstimationSpecification() <em>Estimation Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstimationSpecification()
	 * @generated
	 * @ordered
	 */
	protected EstimationSpecification estimationSpecification;

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
	public IConfigurationOptimizationAlgorithm getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlgorithm(IConfigurationOptimizationAlgorithm newAlgorithm, NotificationChain msgs) {
		IConfigurationOptimizationAlgorithm oldAlgorithm = algorithm;
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
	public void setAlgorithm(IConfigurationOptimizationAlgorithm newAlgorithm) {
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
	public EstimationSpecification getEstimationSpecification() {
		return estimationSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEstimationSpecification(EstimationSpecification newEstimationSpecification, NotificationChain msgs) {
		EstimationSpecification oldEstimationSpecification = estimationSpecification;
		estimationSpecification = newEstimationSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION, oldEstimationSpecification, newEstimationSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEstimationSpecification(EstimationSpecification newEstimationSpecification) {
		if (newEstimationSpecification != estimationSpecification) {
			NotificationChain msgs = null;
			if (estimationSpecification != null)
				msgs = ((InternalEObject)estimationSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION, null, msgs);
			if (newEstimationSpecification != null)
				msgs = ((InternalEObject)newEstimationSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION, null, msgs);
			msgs = basicSetEstimationSpecification(newEstimationSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION, newEstimationSpecification, newEstimationSpecification));
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
			case OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION:
				return basicSetEstimationSpecification(null, msgs);
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
			case OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION:
				return getEstimationSpecification();
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
				setAlgorithm((IConfigurationOptimizationAlgorithm)newValue);
				return;
			case OptimizationPackage.RUN_CALL__TRAINING_DATA:
				getTrainingData().clear();
				getTrainingData().addAll((Collection<? extends InputData>)newValue);
				return;
			case OptimizationPackage.RUN_CALL__SETTINGS:
				setSettings((OptimizationSettings)newValue);
				return;
			case OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION:
				setEstimationSpecification((EstimationSpecification)newValue);
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
				setAlgorithm((IConfigurationOptimizationAlgorithm)null);
				return;
			case OptimizationPackage.RUN_CALL__TRAINING_DATA:
				getTrainingData().clear();
				return;
			case OptimizationPackage.RUN_CALL__SETTINGS:
				setSettings((OptimizationSettings)null);
				return;
			case OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION:
				setEstimationSpecification((EstimationSpecification)null);
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
			case OptimizationPackage.RUN_CALL__ESTIMATION_SPECIFICATION:
				return estimationSpecification != null;
		}
		return super.eIsSet(featureID);
	}

} //RunCallImpl
