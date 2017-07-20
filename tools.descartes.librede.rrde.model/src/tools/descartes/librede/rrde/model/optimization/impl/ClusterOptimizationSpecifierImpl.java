/**
 */
package tools.descartes.librede.rrde.model.optimization.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.descartes.librede.rrde.model.optimization.ClusterOptimizationSpecifier;
import tools.descartes.librede.rrde.model.optimization.ConfigurationOptimizationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.optimization.OptimizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cluster Optimization Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.impl.ClusterOptimizationSpecifierImpl#getClusterAlgorithm <em>Cluster Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.optimization.impl.ClusterOptimizationSpecifierImpl#getSubAlgorithm <em>Sub Algorithm</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClusterOptimizationSpecifierImpl extends ConfigurationOptimizationAlgorithmSpecifierImpl implements ClusterOptimizationSpecifier {
	/**
	 * The default value of the '{@link #getClusterAlgorithm() <em>Cluster Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected static final String CLUSTER_ALGORITHM_EDEFAULT = "";

	protected boolean featureCluster = true;
	
	/**
	 * The cached value of the '{@link #getClusterAlgorithm() <em>Cluster Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected String clusterAlgorithm = CLUSTER_ALGORITHM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubAlgorithm() <em>Sub Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected ConfigurationOptimizationAlgorithmSpecifier subAlgorithm;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusterOptimizationSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimizationPackage.Literals.CLUSTER_OPTIMIZATION_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClusterAlgorithm() {
		return clusterAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClusterAlgorithm(String newClusterAlgorithm) {
		String oldClusterAlgorithm = clusterAlgorithm;
		clusterAlgorithm = newClusterAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.CLUSTER_OPTIMIZATION_SPECIFIER__CLUSTER_ALGORITHM, oldClusterAlgorithm, clusterAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationOptimizationAlgorithmSpecifier getSubAlgorithm() {
		if (subAlgorithm != null && subAlgorithm.eIsProxy()) {
			InternalEObject oldSubAlgorithm = (InternalEObject)subAlgorithm;
			subAlgorithm = (ConfigurationOptimizationAlgorithmSpecifier)eResolveProxy(oldSubAlgorithm);
			if (subAlgorithm != oldSubAlgorithm) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OptimizationPackage.CLUSTER_OPTIMIZATION_SPECIFIER__SUB_ALGORITHM, oldSubAlgorithm, subAlgorithm));
			}
		}
		return subAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationOptimizationAlgorithmSpecifier basicGetSubAlgorithm() {
		return subAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubAlgorithm(ConfigurationOptimizationAlgorithmSpecifier newSubAlgorithm) {
		ConfigurationOptimizationAlgorithmSpecifier oldSubAlgorithm = subAlgorithm;
		subAlgorithm = newSubAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptimizationPackage.CLUSTER_OPTIMIZATION_SPECIFIER__SUB_ALGORITHM, oldSubAlgorithm, subAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptimizationPackage.CLUSTER_OPTIMIZATION_SPECIFIER__CLUSTER_ALGORITHM:
				return getClusterAlgorithm();
			case OptimizationPackage.CLUSTER_OPTIMIZATION_SPECIFIER__SUB_ALGORITHM:
				if (resolve) return getSubAlgorithm();
				return basicGetSubAlgorithm();
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
			case OptimizationPackage.CLUSTER_OPTIMIZATION_SPECIFIER__CLUSTER_ALGORITHM:
				setClusterAlgorithm((String)newValue);
				return;
			case OptimizationPackage.CLUSTER_OPTIMIZATION_SPECIFIER__SUB_ALGORITHM:
				setSubAlgorithm((ConfigurationOptimizationAlgorithmSpecifier)newValue);
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
			case OptimizationPackage.CLUSTER_OPTIMIZATION_SPECIFIER__CLUSTER_ALGORITHM:
				setClusterAlgorithm(CLUSTER_ALGORITHM_EDEFAULT);
				return;
			case OptimizationPackage.CLUSTER_OPTIMIZATION_SPECIFIER__SUB_ALGORITHM:
				setSubAlgorithm((ConfigurationOptimizationAlgorithmSpecifier)null);
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
			case OptimizationPackage.CLUSTER_OPTIMIZATION_SPECIFIER__CLUSTER_ALGORITHM:
				return CLUSTER_ALGORITHM_EDEFAULT == null ? clusterAlgorithm != null : !CLUSTER_ALGORITHM_EDEFAULT.equals(clusterAlgorithm);
			case OptimizationPackage.CLUSTER_OPTIMIZATION_SPECIFIER__SUB_ALGORITHM:
				return subAlgorithm != null;
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
		result.append(" (clusterAlgorithm: ");
		result.append(clusterAlgorithm);
		result.append(')');
		return result.toString();
	}

	@Override
	public boolean featureCluster() {
		return featureCluster;
	}

} //ClusterOptimizationSpecifierImpl
