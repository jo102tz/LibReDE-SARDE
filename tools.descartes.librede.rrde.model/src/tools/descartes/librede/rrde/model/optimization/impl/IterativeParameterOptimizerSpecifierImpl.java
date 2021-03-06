/**
 */
package tools.descartes.librede.rrde.model.optimization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.descartes.librede.rrde.model.optimization.IterativeParameterOptimizerSpecifier;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterative Parameter Optimizer Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.impl.IterativeParameterOptimizerSpecifierImpl#getNumberOfSplits <em>Number Of Splits</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.impl.IterativeParameterOptimizerSpecifierImpl#getNumberOfExplorations <em>Number Of Explorations</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.impl.IterativeParameterOptimizerSpecifierImpl#getNumberOfIterations <em>Number Of Iterations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IterativeParameterOptimizerSpecifierImpl extends ConfigurationOptimizationAlgorithmSpecifierImpl implements IterativeParameterOptimizerSpecifier {
	/**
	 * The default value of the '{@link #getNumberOfSplits() <em>Number Of Splits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfSplits()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_SPLITS_EDEFAULT = 3;

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
	protected static final int NUMBER_OF_EXPLORATIONS_EDEFAULT = 3;

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
	 * The default value of the '{@link #getNumberOfIterations() <em>Number Of Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfIterations()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_ITERATIONS_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getNumberOfIterations() <em>Number Of Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfIterations()
	 * @generated
	 * @ordered
	 */
	protected int numberOfIterations = NUMBER_OF_ITERATIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterativeParameterOptimizerSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimizationPackage.Literals.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_SPLITS, oldNumberOfSplits, numberOfSplits));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_EXPLORATIONS, oldNumberOfExplorations, numberOfExplorations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfIterations() {
		return numberOfIterations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfIterations(int newNumberOfIterations) {
		int oldNumberOfIterations = numberOfIterations;
		numberOfIterations = newNumberOfIterations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_ITERATIONS, oldNumberOfIterations, numberOfIterations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_SPLITS:
				return getNumberOfSplits();
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_EXPLORATIONS:
				return getNumberOfExplorations();
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_ITERATIONS:
				return getNumberOfIterations();
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
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_SPLITS:
				setNumberOfSplits((Integer)newValue);
				return;
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_EXPLORATIONS:
				setNumberOfExplorations((Integer)newValue);
				return;
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_ITERATIONS:
				setNumberOfIterations((Integer)newValue);
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
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_SPLITS:
				setNumberOfSplits(NUMBER_OF_SPLITS_EDEFAULT);
				return;
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_EXPLORATIONS:
				setNumberOfExplorations(NUMBER_OF_EXPLORATIONS_EDEFAULT);
				return;
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_ITERATIONS:
				setNumberOfIterations(NUMBER_OF_ITERATIONS_EDEFAULT);
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
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_SPLITS:
				return numberOfSplits != NUMBER_OF_SPLITS_EDEFAULT;
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_EXPLORATIONS:
				return numberOfExplorations != NUMBER_OF_EXPLORATIONS_EDEFAULT;
			case OptimizationPackage.ITERATIVE_PARAMETER_OPTIMIZER_SPECIFIER__NUMBER_OF_ITERATIONS:
				return numberOfIterations != NUMBER_OF_ITERATIONS_EDEFAULT;
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
		result.append(" (numberOfSplits: ");
		result.append(numberOfSplits);
		result.append(", numberOfExplorations: ");
		result.append(numberOfExplorations);
		result.append(", numberOfIterations: ");
		result.append(numberOfIterations);
		result.append(')');
		return result.toString();
	}

} //IterativeParameterOptimizerSpecifierImpl
