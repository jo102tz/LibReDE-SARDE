/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.descartes.librede.rrde.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.recommendation.RegressionTreeTradeOffAlgorithmSpecifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Regression Tree Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.RegressionTreeTradeOffAlgorithmSpecifierImpl#getMaxTreeNodes <em>Max Tree Nodes</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.RegressionTreeTradeOffAlgorithmSpecifierImpl#getSplitThreshould <em>Split Threshould</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RegressionTreeTradeOffAlgorithmSpecifierImpl extends RecommendationTradeOffAlgorithmSpecifierImpl implements RegressionTreeTradeOffAlgorithmSpecifier {
	/**
	 * The default value of the '{@link #getMaxTreeNodes() <em>Max Tree Nodes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxTreeNodes()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_TREE_NODES_EDEFAULT = 1000;

	/**
	 * The cached value of the '{@link #getMaxTreeNodes() <em>Max Tree Nodes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxTreeNodes()
	 * @generated
	 * @ordered
	 */
	protected int maxTreeNodes = MAX_TREE_NODES_EDEFAULT;

	/**
	 * The default value of the '{@link #getSplitThreshould() <em>Split Threshould</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSplitThreshould()
	 * @generated
	 * @ordered
	 */
	protected static final int SPLIT_THRESHOULD_EDEFAULT = 4;

	/**
	 * The cached value of the '{@link #getSplitThreshould() <em>Split Threshould</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSplitThreshould()
	 * @generated
	 * @ordered
	 */
	protected int splitThreshould = SPLIT_THRESHOULD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegressionTreeTradeOffAlgorithmSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.REGRESSION_TREE_TRADE_OFF_ALGORITHM_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxTreeNodes() {
		return maxTreeNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxTreeNodes(int newMaxTreeNodes) {
		int oldMaxTreeNodes = maxTreeNodes;
		maxTreeNodes = newMaxTreeNodes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.REGRESSION_TREE_TRADE_OFF_ALGORITHM_SPECIFIER__MAX_TREE_NODES, oldMaxTreeNodes, maxTreeNodes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSplitThreshould() {
		return splitThreshould;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSplitThreshould(int newSplitThreshould) {
		int oldSplitThreshould = splitThreshould;
		splitThreshould = newSplitThreshould;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.REGRESSION_TREE_TRADE_OFF_ALGORITHM_SPECIFIER__SPLIT_THRESHOULD, oldSplitThreshould, splitThreshould));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.REGRESSION_TREE_TRADE_OFF_ALGORITHM_SPECIFIER__MAX_TREE_NODES:
				return getMaxTreeNodes();
			case RecommendationPackage.REGRESSION_TREE_TRADE_OFF_ALGORITHM_SPECIFIER__SPLIT_THRESHOULD:
				return getSplitThreshould();
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
			case RecommendationPackage.REGRESSION_TREE_TRADE_OFF_ALGORITHM_SPECIFIER__MAX_TREE_NODES:
				setMaxTreeNodes((Integer)newValue);
				return;
			case RecommendationPackage.REGRESSION_TREE_TRADE_OFF_ALGORITHM_SPECIFIER__SPLIT_THRESHOULD:
				setSplitThreshould((Integer)newValue);
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
			case RecommendationPackage.REGRESSION_TREE_TRADE_OFF_ALGORITHM_SPECIFIER__MAX_TREE_NODES:
				setMaxTreeNodes(MAX_TREE_NODES_EDEFAULT);
				return;
			case RecommendationPackage.REGRESSION_TREE_TRADE_OFF_ALGORITHM_SPECIFIER__SPLIT_THRESHOULD:
				setSplitThreshould(SPLIT_THRESHOULD_EDEFAULT);
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
			case RecommendationPackage.REGRESSION_TREE_TRADE_OFF_ALGORITHM_SPECIFIER__MAX_TREE_NODES:
				return maxTreeNodes != MAX_TREE_NODES_EDEFAULT;
			case RecommendationPackage.REGRESSION_TREE_TRADE_OFF_ALGORITHM_SPECIFIER__SPLIT_THRESHOULD:
				return splitThreshould != SPLIT_THRESHOULD_EDEFAULT;
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
		result.append(" (maxTreeNodes: ");
		result.append(maxTreeNodes);
		result.append(", splitThreshould: ");
		result.append(splitThreshould);
		result.append(')');
		return result.toString();
	}

} //RegressionTreeTradeOffAlgorithmSpecifierImpl
