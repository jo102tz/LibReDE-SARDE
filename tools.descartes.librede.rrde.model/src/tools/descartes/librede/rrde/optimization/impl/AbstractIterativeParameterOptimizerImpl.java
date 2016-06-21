/**
 */
package tools.descartes.librede.rrde.optimization.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tools.descartes.librede.configuration.EstimationSpecification;

import tools.descartes.librede.rrde.optimization.AbstractIterativeParameterOptimizer;
import tools.descartes.librede.rrde.optimization.InputData;
import tools.descartes.librede.rrde.optimization.OptimizationPackage;
import tools.descartes.librede.rrde.optimization.OptimizationSettings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Iterative Parameter Optimizer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.AbstractIterativeParameterOptimizerImpl#getTimeOut <em>Time Out</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.AbstractIterativeParameterOptimizerImpl#getNumberOfSplits <em>Number Of Splits</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.AbstractIterativeParameterOptimizerImpl#getNumberOfExplorations <em>Number Of Explorations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractIterativeParameterOptimizerImpl extends MinimalEObjectImpl.Container implements AbstractIterativeParameterOptimizer {
	/**
	 * The default value of the '{@link #getTimeOut() <em>Time Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeOut()
	 * @generated
	 * @ordered
	 */
	protected static final long TIME_OUT_EDEFAULT = -1L;

	/**
	 * The cached value of the '{@link #getTimeOut() <em>Time Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeOut()
	 * @generated
	 * @ordered
	 */
	protected long timeOut = TIME_OUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfSplits() <em>Number Of Splits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfSplits()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_SPLITS_EDEFAULT = 10;

	/**
	 * The cached value of the '{@link #getNumberOfSplits() <em>Number Of Splits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfSplits()
	 * @generated
	 * @ordered
	 */
	protected int numberOfSplits = NUMBER_OF_SPLITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfExplorations() <em>Number Of Explorations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfExplorations()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_EXPLORATIONS_EDEFAULT = 50;

	/**
	 * The cached value of the '{@link #getNumberOfExplorations() <em>Number Of Explorations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfExplorations()
	 * @generated
	 * @ordered
	 */
	protected int numberOfExplorations = NUMBER_OF_EXPLORATIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractIterativeParameterOptimizerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimizationPackage.Literals.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimeOut() {
		return timeOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeOut(long newTimeOut) {
		long oldTimeOut = timeOut;
		timeOut = newTimeOut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__TIME_OUT, oldTimeOut, timeOut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfSplits() {
		return numberOfSplits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfSplits(int newNumberOfSplits) {
		int oldNumberOfSplits = numberOfSplits;
		numberOfSplits = newNumberOfSplits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_SPLITS, oldNumberOfSplits, numberOfSplits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfExplorations() {
		return numberOfExplorations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfExplorations(int newNumberOfExplorations) {
		int oldNumberOfExplorations = numberOfExplorations;
		numberOfExplorations = newNumberOfExplorations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_EXPLORATIONS, oldNumberOfExplorations, numberOfExplorations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean stop() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EstimationSpecification runOptimization(InputData input, OptimizationSettings settings, EstimationSpecification estimation) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean configure(String parameter, EObject value) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__TIME_OUT:
				return getTimeOut();
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_SPLITS:
				return getNumberOfSplits();
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_EXPLORATIONS:
				return getNumberOfExplorations();
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
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__TIME_OUT:
				setTimeOut((Long)newValue);
				return;
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_SPLITS:
				setNumberOfSplits((Integer)newValue);
				return;
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_EXPLORATIONS:
				setNumberOfExplorations((Integer)newValue);
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
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__TIME_OUT:
				setTimeOut(TIME_OUT_EDEFAULT);
				return;
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_SPLITS:
				setNumberOfSplits(NUMBER_OF_SPLITS_EDEFAULT);
				return;
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_EXPLORATIONS:
				setNumberOfExplorations(NUMBER_OF_EXPLORATIONS_EDEFAULT);
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
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__TIME_OUT:
				return timeOut != TIME_OUT_EDEFAULT;
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_SPLITS:
				return numberOfSplits != NUMBER_OF_SPLITS_EDEFAULT;
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER__NUMBER_OF_EXPLORATIONS:
				return numberOfExplorations != NUMBER_OF_EXPLORATIONS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER___STOP:
				return stop();
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER___RUN_OPTIMIZATION__INPUTDATA_OPTIMIZATIONSETTINGS_ESTIMATIONSPECIFICATION:
				return runOptimization((InputData)arguments.get(0), (OptimizationSettings)arguments.get(1), (EstimationSpecification)arguments.get(2));
			case OptimizationPackage.ABSTRACT_ITERATIVE_PARAMETER_OPTIMIZER___CONFIGURE__STRING_EOBJECT:
				return configure((String)arguments.get(0), (EObject)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (timeOut: ");
		result.append(timeOut);
		result.append(", numberOfSplits: ");
		result.append(numberOfSplits);
		result.append(", numberOfExplorations: ");
		result.append(numberOfExplorations);
		result.append(')');
		return result.toString();
	}

} //AbstractIterativeParameterOptimizerImpl
