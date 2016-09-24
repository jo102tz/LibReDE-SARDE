/**
 */
package tools.descartes.librede.rrde.optimization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import tools.descartes.librede.rrde.optimization.LocalSearchSpecifier;
import tools.descartes.librede.rrde.optimization.OptimizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Search Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.LocalSearchSpecifierImpl#getTolerance <em>Tolerance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.LocalSearchSpecifierImpl#getMaximumNumberOfSteps <em>Maximum Number Of Steps</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.LocalSearchSpecifierImpl#getStepSize <em>Step Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalSearchSpecifierImpl extends ConfigurationOptimizationAlgorithmSpecifierImpl implements LocalSearchSpecifier {
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
	protected static final long MAXIMUM_NUMBER_OF_STEPS_EDEFAULT = -1L;

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
	public LocalSearchSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimizationPackage.Literals.LOCAL_SEARCH_SPECIFIER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.LOCAL_SEARCH_SPECIFIER__TOLERANCE, oldTolerance, tolerance));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.LOCAL_SEARCH_SPECIFIER__MAXIMUM_NUMBER_OF_STEPS, oldMaximumNumberOfSteps, maximumNumberOfSteps));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.LOCAL_SEARCH_SPECIFIER__STEP_SIZE, oldStepSize, stepSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER__TOLERANCE:
				return getTolerance();
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER__MAXIMUM_NUMBER_OF_STEPS:
				return getMaximumNumberOfSteps();
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER__STEP_SIZE:
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
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER__TOLERANCE:
				setTolerance((Double)newValue);
				return;
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER__MAXIMUM_NUMBER_OF_STEPS:
				setMaximumNumberOfSteps((Long)newValue);
				return;
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER__STEP_SIZE:
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
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER__TOLERANCE:
				setTolerance(TOLERANCE_EDEFAULT);
				return;
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER__MAXIMUM_NUMBER_OF_STEPS:
				setMaximumNumberOfSteps(MAXIMUM_NUMBER_OF_STEPS_EDEFAULT);
				return;
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER__STEP_SIZE:
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
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER__TOLERANCE:
				return tolerance != TOLERANCE_EDEFAULT;
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER__MAXIMUM_NUMBER_OF_STEPS:
				return maximumNumberOfSteps != MAXIMUM_NUMBER_OF_STEPS_EDEFAULT;
			case OptimizationPackage.LOCAL_SEARCH_SPECIFIER__STEP_SIZE:
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
		result.append(" (tolerance: ");
		result.append(tolerance);
		result.append(", maximumNumberOfSteps: ");
		result.append(maximumNumberOfSteps);
		result.append(", stepSize: ");
		result.append(stepSize);
		result.append(')');
		return result.toString();
	}

} //LocalSearchSpecifierImpl
