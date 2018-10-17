/**
 */
package tools.descartes.librede.rrde.model.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.descartes.librede.rrde.model.recommendation.NeuralNetworkAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.recommendation.RecommendationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Neural Network Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.impl.NeuralNetworkAlgorithmSpecifierImpl#getNumberOfNeurons <em>Number Of Neurons</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.impl.NeuralNetworkAlgorithmSpecifierImpl#getEpochs <em>Epochs</em>}</li>
 * </ul>
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
	 * The default value of the '{@link #getEpochs() <em>Epochs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEpochs()
	 * @generated
	 * @ordered
	 */
	protected static final int EPOCHS_EDEFAULT = 5;

	/**
	 * The cached value of the '{@link #getEpochs() <em>Epochs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEpochs()
	 * @generated
	 * @ordered
	 */
	protected int epochs = EPOCHS_EDEFAULT;

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
	public int getEpochs() {
		return epochs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEpochs(int newEpochs) {
		int oldEpochs = epochs;
		epochs = newEpochs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.NEURAL_NETWORK_ALGORITHM_SPECIFIER__EPOCHS, oldEpochs, epochs));
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
			case RecommendationPackage.NEURAL_NETWORK_ALGORITHM_SPECIFIER__EPOCHS:
				return getEpochs();
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
			case RecommendationPackage.NEURAL_NETWORK_ALGORITHM_SPECIFIER__EPOCHS:
				setEpochs((Integer)newValue);
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
			case RecommendationPackage.NEURAL_NETWORK_ALGORITHM_SPECIFIER__EPOCHS:
				setEpochs(EPOCHS_EDEFAULT);
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
			case RecommendationPackage.NEURAL_NETWORK_ALGORITHM_SPECIFIER__EPOCHS:
				return epochs != EPOCHS_EDEFAULT;
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
		result.append(", epochs: ");
		result.append(epochs);
		result.append(')');
		return result.toString();
	}

} //NeuralNetworkAlgorithmSpecifierImpl
