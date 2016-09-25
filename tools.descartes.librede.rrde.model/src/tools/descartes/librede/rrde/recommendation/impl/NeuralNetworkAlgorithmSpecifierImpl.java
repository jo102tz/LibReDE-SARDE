/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.descartes.librede.rrde.recommendation.NeuralNetworkAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Neural Network Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.NeuralNetworkAlgorithmSpecifierImpl#getNumberOfNeurons <em>Number Of Neurons</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NeuralNetworkAlgorithmSpecifierImpl extends RecommendationAlgorithmSpecifierImpl implements NeuralNetworkAlgorithmSpecifier {
	/**
	 * The default value of the '{@link #getNumberOfNeurons() <em>Number Of Neurons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfNeurons()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_NEURONS_EDEFAULT = 100;

	/**
	 * The cached value of the '{@link #getNumberOfNeurons() <em>Number Of Neurons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfNeurons()
	 * @generated
	 * @ordered
	 */
	protected int numberOfNeurons = NUMBER_OF_NEURONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NeuralNetworkAlgorithmSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.NEURAL_NETWORK_ALGORITHM_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfNeurons() {
		return numberOfNeurons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfNeurons(int newNumberOfNeurons) {
		int oldNumberOfNeurons = numberOfNeurons;
		numberOfNeurons = newNumberOfNeurons;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.NEURAL_NETWORK_ALGORITHM_SPECIFIER__NUMBER_OF_NEURONS, oldNumberOfNeurons, numberOfNeurons));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.NEURAL_NETWORK_ALGORITHM_SPECIFIER__NUMBER_OF_NEURONS:
				return getNumberOfNeurons();
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
			case RecommendationPackage.NEURAL_NETWORK_ALGORITHM_SPECIFIER__NUMBER_OF_NEURONS:
				setNumberOfNeurons((Integer)newValue);
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
			case RecommendationPackage.NEURAL_NETWORK_ALGORITHM_SPECIFIER__NUMBER_OF_NEURONS:
				setNumberOfNeurons(NUMBER_OF_NEURONS_EDEFAULT);
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
			case RecommendationPackage.NEURAL_NETWORK_ALGORITHM_SPECIFIER__NUMBER_OF_NEURONS:
				return numberOfNeurons != NUMBER_OF_NEURONS_EDEFAULT;
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
		result.append(" (numberOfNeurons: ");
		result.append(numberOfNeurons);
		result.append(')');
		return result.toString();
	}

} //NeuralNetworkAlgorithmSpecifierImpl
