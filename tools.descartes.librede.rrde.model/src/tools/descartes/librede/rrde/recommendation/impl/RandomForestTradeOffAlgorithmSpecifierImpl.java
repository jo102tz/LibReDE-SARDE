/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import tools.descartes.librede.rrde.recommendation.RandomForestTradeOffAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Forest Trade Off Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.RandomForestTradeOffAlgorithmSpecifierImpl#getMaxTreeNodes <em>Max Tree Nodes</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.RandomForestTradeOffAlgorithmSpecifierImpl#getSplitThreshould <em>Split Threshould</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.RandomForestTradeOffAlgorithmSpecifierImpl#getTreeNumber <em>Tree Number</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RandomForestTradeOffAlgorithmSpecifierImpl extends RecommendationTradeOffAlgorithmSpecifierImpl implements RandomForestTradeOffAlgorithmSpecifier {
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
	 * The default value of the '{@link #getTreeNumber() <em>Tree Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTreeNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int TREE_NUMBER_EDEFAULT = 4;
	/**
	 * The cached value of the '{@link #getTreeNumber() <em>Tree Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTreeNumber()
	 * @generated
	 * @ordered
	 */
	protected int treeNumber = TREE_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomForestTradeOffAlgorithmSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__MAX_TREE_NODES, oldMaxTreeNodes, maxTreeNodes));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__SPLIT_THRESHOULD, oldSplitThreshould, splitThreshould));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTreeNumber() {
		return treeNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTreeNumber(int newTreeNumber) {
		int oldTreeNumber = treeNumber;
		treeNumber = newTreeNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__TREE_NUMBER, oldTreeNumber, treeNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__MAX_TREE_NODES:
				return getMaxTreeNodes();
			case RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__SPLIT_THRESHOULD:
				return getSplitThreshould();
			case RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__TREE_NUMBER:
				return getTreeNumber();
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
			case RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__MAX_TREE_NODES:
				setMaxTreeNodes((Integer)newValue);
				return;
			case RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__SPLIT_THRESHOULD:
				setSplitThreshould((Integer)newValue);
				return;
			case RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__TREE_NUMBER:
				setTreeNumber((Integer)newValue);
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
			case RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__MAX_TREE_NODES:
				setMaxTreeNodes(MAX_TREE_NODES_EDEFAULT);
				return;
			case RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__SPLIT_THRESHOULD:
				setSplitThreshould(SPLIT_THRESHOULD_EDEFAULT);
				return;
			case RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__TREE_NUMBER:
				setTreeNumber(TREE_NUMBER_EDEFAULT);
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
			case RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__MAX_TREE_NODES:
				return maxTreeNodes != MAX_TREE_NODES_EDEFAULT;
			case RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__SPLIT_THRESHOULD:
				return splitThreshould != SPLIT_THRESHOULD_EDEFAULT;
			case RecommendationPackage.RANDOM_FOREST_TRADE_OFF_ALGORITHM_SPECIFIER__TREE_NUMBER:
				return treeNumber != TREE_NUMBER_EDEFAULT;
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
		result.append(", treeNumber: ");
		result.append(treeNumber);
		result.append(')');
		return result.toString();
	}

} //RandomForestTradeOffAlgorithmSpecifierImpl
