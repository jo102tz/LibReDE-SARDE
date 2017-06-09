/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.descartes.librede.rrde.recommendation.DecisionTreeAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decision Tree Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.DecisionTreeAlgorithmSpecifierImpl#getMaximumNumberOfNodes <em>Maximum Number Of Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DecisionTreeAlgorithmSpecifierImpl extends RecommendationAlgorithmSpecifierImpl implements DecisionTreeAlgorithmSpecifier {
	/**
	 * The default value of the '{@link #getMaximumNumberOfNodes() <em>Maximum Number Of Nodes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfNodes()
	 * @generated
	 * @ordered
	 */
	protected static final int MAXIMUM_NUMBER_OF_NODES_EDEFAULT = 100;

	/**
	 * The cached value of the '{@link #getMaximumNumberOfNodes() <em>Maximum Number Of Nodes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfNodes()
	 * @generated
	 * @ordered
	 */
	protected int maximumNumberOfNodes = MAXIMUM_NUMBER_OF_NODES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecisionTreeAlgorithmSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.DECISION_TREE_ALGORITHM_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaximumNumberOfNodes() {
		return maximumNumberOfNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumNumberOfNodes(int newMaximumNumberOfNodes) {
		int oldMaximumNumberOfNodes = maximumNumberOfNodes;
		maximumNumberOfNodes = newMaximumNumberOfNodes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.DECISION_TREE_ALGORITHM_SPECIFIER__MAXIMUM_NUMBER_OF_NODES, oldMaximumNumberOfNodes, maximumNumberOfNodes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.DECISION_TREE_ALGORITHM_SPECIFIER__MAXIMUM_NUMBER_OF_NODES:
				return getMaximumNumberOfNodes();
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
			case RecommendationPackage.DECISION_TREE_ALGORITHM_SPECIFIER__MAXIMUM_NUMBER_OF_NODES:
				setMaximumNumberOfNodes((Integer)newValue);
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
			case RecommendationPackage.DECISION_TREE_ALGORITHM_SPECIFIER__MAXIMUM_NUMBER_OF_NODES:
				setMaximumNumberOfNodes(MAXIMUM_NUMBER_OF_NODES_EDEFAULT);
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
			case RecommendationPackage.DECISION_TREE_ALGORITHM_SPECIFIER__MAXIMUM_NUMBER_OF_NODES:
				return maximumNumberOfNodes != MAXIMUM_NUMBER_OF_NODES_EDEFAULT;
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
		result.append(" (maximumNumberOfNodes: ");
		result.append(maximumNumberOfNodes);
		result.append(')');
		return result.toString();
	}

} //DecisionTreeAlgorithmSpecifierImpl
