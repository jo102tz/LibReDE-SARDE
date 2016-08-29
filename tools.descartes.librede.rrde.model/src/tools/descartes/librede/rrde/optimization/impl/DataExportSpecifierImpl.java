/**
 */
package tools.descartes.librede.rrde.optimization.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tools.descartes.librede.rrde.optimization.DataExportSpecifier;
import tools.descartes.librede.rrde.optimization.OptimizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Export Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.DataExportSpecifierImpl#getTimeOut <em>Time Out</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.DataExportSpecifierImpl#getAlgorithmName <em>Algorithm Name</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.DataExportSpecifierImpl#getOutputDirectory <em>Output Directory</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.DataExportSpecifierImpl#getStepSize <em>Step Size</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.DataExportSpecifierImpl#isMultidimensional <em>Multidimensional</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.optimization.impl.DataExportSpecifierImpl#isSplitConfigurations <em>Split Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataExportSpecifierImpl extends MinimalEObjectImpl.Container implements DataExportSpecifier {
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
	 * The default value of the '{@link #getAlgorithmName() <em>Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmName()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgorithmName() <em>Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmName()
	 * @generated
	 * @ordered
	 */
	protected String algorithmName = ALGORITHM_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputDirectory() <em>Output Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_DIRECTORY_EDEFAULT = "\"\"";

	/**
	 * The cached value of the '{@link #getOutputDirectory() <em>Output Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputDirectory()
	 * @generated
	 * @ordered
	 */
	protected String outputDirectory = OUTPUT_DIRECTORY_EDEFAULT;

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
	 * The default value of the '{@link #isMultidimensional() <em>Multidimensional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultidimensional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTIDIMENSIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMultidimensional() <em>Multidimensional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultidimensional()
	 * @generated
	 * @ordered
	 */
	protected boolean multidimensional = MULTIDIMENSIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isSplitConfigurations() <em>Split Configurations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSplitConfigurations()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SPLIT_CONFIGURATIONS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isSplitConfigurations() <em>Split Configurations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSplitConfigurations()
	 * @generated
	 * @ordered
	 */
	protected boolean splitConfigurations = SPLIT_CONFIGURATIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataExportSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimizationPackage.Literals.DATA_EXPORT_SPECIFIER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.DATA_EXPORT_SPECIFIER__TIME_OUT, oldTimeOut, timeOut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlgorithmName() {
		return algorithmName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithmName(String newAlgorithmName) {
		String oldAlgorithmName = algorithmName;
		algorithmName = newAlgorithmName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.DATA_EXPORT_SPECIFIER__ALGORITHM_NAME, oldAlgorithmName, algorithmName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputDirectory() {
		return outputDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputDirectory(String newOutputDirectory) {
		String oldOutputDirectory = outputDirectory;
		outputDirectory = newOutputDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.DATA_EXPORT_SPECIFIER__OUTPUT_DIRECTORY, oldOutputDirectory, outputDirectory));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.DATA_EXPORT_SPECIFIER__STEP_SIZE, oldStepSize, stepSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultidimensional() {
		return multidimensional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultidimensional(boolean newMultidimensional) {
		boolean oldMultidimensional = multidimensional;
		multidimensional = newMultidimensional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.DATA_EXPORT_SPECIFIER__MULTIDIMENSIONAL, oldMultidimensional, multidimensional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSplitConfigurations() {
		return splitConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSplitConfigurations(boolean newSplitConfigurations) {
		boolean oldSplitConfigurations = splitConfigurations;
		splitConfigurations = newSplitConfigurations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.DATA_EXPORT_SPECIFIER__SPLIT_CONFIGURATIONS, oldSplitConfigurations, splitConfigurations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__TIME_OUT:
				return getTimeOut();
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__ALGORITHM_NAME:
				return getAlgorithmName();
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__OUTPUT_DIRECTORY:
				return getOutputDirectory();
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__STEP_SIZE:
				return getStepSize();
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__MULTIDIMENSIONAL:
				return isMultidimensional();
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__SPLIT_CONFIGURATIONS:
				return isSplitConfigurations();
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
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__TIME_OUT:
				setTimeOut((Long)newValue);
				return;
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__ALGORITHM_NAME:
				setAlgorithmName((String)newValue);
				return;
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__OUTPUT_DIRECTORY:
				setOutputDirectory((String)newValue);
				return;
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__STEP_SIZE:
				setStepSize((Double)newValue);
				return;
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__MULTIDIMENSIONAL:
				setMultidimensional((Boolean)newValue);
				return;
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__SPLIT_CONFIGURATIONS:
				setSplitConfigurations((Boolean)newValue);
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
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__TIME_OUT:
				setTimeOut(TIME_OUT_EDEFAULT);
				return;
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__ALGORITHM_NAME:
				setAlgorithmName(ALGORITHM_NAME_EDEFAULT);
				return;
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__OUTPUT_DIRECTORY:
				setOutputDirectory(OUTPUT_DIRECTORY_EDEFAULT);
				return;
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__STEP_SIZE:
				setStepSize(STEP_SIZE_EDEFAULT);
				return;
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__MULTIDIMENSIONAL:
				setMultidimensional(MULTIDIMENSIONAL_EDEFAULT);
				return;
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__SPLIT_CONFIGURATIONS:
				setSplitConfigurations(SPLIT_CONFIGURATIONS_EDEFAULT);
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
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__TIME_OUT:
				return timeOut != TIME_OUT_EDEFAULT;
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__ALGORITHM_NAME:
				return ALGORITHM_NAME_EDEFAULT == null ? algorithmName != null : !ALGORITHM_NAME_EDEFAULT.equals(algorithmName);
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__OUTPUT_DIRECTORY:
				return OUTPUT_DIRECTORY_EDEFAULT == null ? outputDirectory != null : !OUTPUT_DIRECTORY_EDEFAULT.equals(outputDirectory);
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__STEP_SIZE:
				return stepSize != STEP_SIZE_EDEFAULT;
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__MULTIDIMENSIONAL:
				return multidimensional != MULTIDIMENSIONAL_EDEFAULT;
			case OptimizationPackage.DATA_EXPORT_SPECIFIER__SPLIT_CONFIGURATIONS:
				return splitConfigurations != SPLIT_CONFIGURATIONS_EDEFAULT;
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
		result.append(" (timeOut: ");
		result.append(timeOut);
		result.append(", algorithmName: ");
		result.append(algorithmName);
		result.append(", OutputDirectory: ");
		result.append(outputDirectory);
		result.append(", stepSize: ");
		result.append(stepSize);
		result.append(", multidimensional: ");
		result.append(multidimensional);
		result.append(", splitConfigurations: ");
		result.append(splitConfigurations);
		result.append(')');
		return result.toString();
	}

} //DataExportSpecifierImpl
