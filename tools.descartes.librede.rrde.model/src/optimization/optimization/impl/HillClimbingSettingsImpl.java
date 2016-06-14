/**
 */
package optimization.optimization.impl;

import optimization.impl.SettingsImpl;

import optimization.optimization.HillClimbingSettings;
import optimization.optimization.OptimizationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hill Climbing Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link optimization.optimization.impl.HillClimbingSettingsImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link optimization.optimization.impl.HillClimbingSettingsImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link optimization.optimization.impl.HillClimbingSettingsImpl#getTolerance <em>Tolerance</em>}</li>
 *   <li>{@link optimization.optimization.impl.HillClimbingSettingsImpl#getMaximumNumberOfSteps <em>Maximum Number Of Steps</em>}</li>
 *   <li>{@link optimization.optimization.impl.HillClimbingSettingsImpl#getStartValue <em>Start Value</em>}</li>
 *   <li>{@link optimization.optimization.impl.HillClimbingSettingsImpl#getStepSize <em>Step Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HillClimbingSettingsImpl extends SettingsImpl implements HillClimbingSettings {
	/**
	 * The default value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected static final double MINIMUM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected double minimum = MINIMUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected static final double MAXIMUM_EDEFAULT = 200.0;

	/**
	 * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected double maximum = MAXIMUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getTolerance() <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTolerance()
	 * @generated
	 * @ordered
	 */
	protected static final double TOLERANCE_EDEFAULT = 0.05;

	/**
	 * The cached value of the '{@link #getTolerance() <em>Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTolerance()
	 * @generated
	 * @ordered
	 */
	protected double tolerance = TOLERANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumNumberOfSteps() <em>Maximum Number Of Steps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfSteps()
	 * @generated
	 * @ordered
	 */
	protected static final long MAXIMUM_NUMBER_OF_STEPS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaximumNumberOfSteps() <em>Maximum Number Of Steps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfSteps()
	 * @generated
	 * @ordered
	 */
	protected long maximumNumberOfSteps = MAXIMUM_NUMBER_OF_STEPS_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartValue() <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartValue()
	 * @generated
	 * @ordered
	 */
	protected static final double START_VALUE_EDEFAULT = 60.0;

	/**
	 * The cached value of the '{@link #getStartValue() <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartValue()
	 * @generated
	 * @ordered
	 */
	protected double startValue = START_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStepSize() <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepSize()
	 * @generated
	 * @ordered
	 */
	protected static final double STEP_SIZE_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getStepSize() <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepSize()
	 * @generated
	 * @ordered
	 */
	protected double stepSize = STEP_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HillClimbingSettingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimizationPackage.Literals.HILL_CLIMBING_SETTINGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMinimum() {
		return minimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimum(double newMinimum) {
		double oldMinimum = minimum;
		minimum = newMinimum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.HILL_CLIMBING_SETTINGS__MINIMUM, oldMinimum, minimum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaximum() {
		return maximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximum(double newMaximum) {
		double oldMaximum = maximum;
		maximum = newMaximum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.HILL_CLIMBING_SETTINGS__MAXIMUM, oldMaximum, maximum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTolerance() {
		return tolerance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTolerance(double newTolerance) {
		double oldTolerance = tolerance;
		tolerance = newTolerance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.HILL_CLIMBING_SETTINGS__TOLERANCE, oldTolerance, tolerance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMaximumNumberOfSteps() {
		return maximumNumberOfSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumNumberOfSteps(long newMaximumNumberOfSteps) {
		long oldMaximumNumberOfSteps = maximumNumberOfSteps;
		maximumNumberOfSteps = newMaximumNumberOfSteps;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.HILL_CLIMBING_SETTINGS__MAXIMUM_NUMBER_OF_STEPS, oldMaximumNumberOfSteps, maximumNumberOfSteps));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStartValue() {
		return startValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartValue(double newStartValue) {
		double oldStartValue = startValue;
		startValue = newStartValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.HILL_CLIMBING_SETTINGS__START_VALUE, oldStartValue, startValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStepSize() {
		return stepSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepSize(double newStepSize) {
		double oldStepSize = stepSize;
		stepSize = newStepSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.HILL_CLIMBING_SETTINGS__STEP_SIZE, oldStepSize, stepSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MINIMUM:
				return getMinimum();
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MAXIMUM:
				return getMaximum();
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__TOLERANCE:
				return getTolerance();
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MAXIMUM_NUMBER_OF_STEPS:
				return getMaximumNumberOfSteps();
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__START_VALUE:
				return getStartValue();
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__STEP_SIZE:
				return getStepSize();
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
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MINIMUM:
				setMinimum((Double)newValue);
				return;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MAXIMUM:
				setMaximum((Double)newValue);
				return;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__TOLERANCE:
				setTolerance((Double)newValue);
				return;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MAXIMUM_NUMBER_OF_STEPS:
				setMaximumNumberOfSteps((Long)newValue);
				return;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__START_VALUE:
				setStartValue((Double)newValue);
				return;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__STEP_SIZE:
				setStepSize((Double)newValue);
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
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MINIMUM:
				setMinimum(MINIMUM_EDEFAULT);
				return;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MAXIMUM:
				setMaximum(MAXIMUM_EDEFAULT);
				return;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__TOLERANCE:
				setTolerance(TOLERANCE_EDEFAULT);
				return;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MAXIMUM_NUMBER_OF_STEPS:
				setMaximumNumberOfSteps(MAXIMUM_NUMBER_OF_STEPS_EDEFAULT);
				return;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__START_VALUE:
				setStartValue(START_VALUE_EDEFAULT);
				return;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__STEP_SIZE:
				setStepSize(STEP_SIZE_EDEFAULT);
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
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MINIMUM:
				return minimum != MINIMUM_EDEFAULT;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MAXIMUM:
				return maximum != MAXIMUM_EDEFAULT;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__TOLERANCE:
				return tolerance != TOLERANCE_EDEFAULT;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__MAXIMUM_NUMBER_OF_STEPS:
				return maximumNumberOfSteps != MAXIMUM_NUMBER_OF_STEPS_EDEFAULT;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__START_VALUE:
				return startValue != START_VALUE_EDEFAULT;
			case OptimizationPackage.HILL_CLIMBING_SETTINGS__STEP_SIZE:
				return stepSize != STEP_SIZE_EDEFAULT;
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
		result.append(" (minimum: ");
		result.append(minimum);
		result.append(", maximum: ");
		result.append(maximum);
		result.append(", tolerance: ");
		result.append(tolerance);
		result.append(", maximumNumberOfSteps: ");
		result.append(maximumNumberOfSteps);
		result.append(", startValue: ");
		result.append(startValue);
		result.append(", stepSize: ");
		result.append(stepSize);
		result.append(')');
		return result.toString();
	}

} //HillClimbingSettingsImpl
