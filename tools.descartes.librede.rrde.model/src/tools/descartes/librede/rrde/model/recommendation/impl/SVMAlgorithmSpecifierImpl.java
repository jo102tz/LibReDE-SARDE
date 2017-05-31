/**
 */
package tools.descartes.librede.rrde.model.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.descartes.librede.rrde.model.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.model.recommendation.SVMAlgorithmSpecifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SVM Algorithm Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.impl.SVMAlgorithmSpecifierImpl#getGaussianSigma <em>Gaussian Sigma</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.impl.SVMAlgorithmSpecifierImpl#getSoftMarginPenalty <em>Soft Margin Penalty</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SVMAlgorithmSpecifierImpl extends RecommendationAlgorithmSpecifierImpl implements SVMAlgorithmSpecifier {
	/**
	 * The default value of the '{@link #getGaussianSigma() <em>Gaussian Sigma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGaussianSigma()
	 * @generated
	 * @ordered
	 */
	protected static final double GAUSSIAN_SIGMA_EDEFAULT = 8.0;

	/**
	 * The cached value of the '{@link #getGaussianSigma() <em>Gaussian Sigma</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGaussianSigma()
	 * @generated
	 * @ordered
	 */
	protected double gaussianSigma = GAUSSIAN_SIGMA_EDEFAULT;

	/**
	 * The default value of the '{@link #getSoftMarginPenalty() <em>Soft Margin Penalty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoftMarginPenalty()
	 * @generated
	 * @ordered
	 */
	protected static final double SOFT_MARGIN_PENALTY_EDEFAULT = 5.0;

	/**
	 * The cached value of the '{@link #getSoftMarginPenalty() <em>Soft Margin Penalty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoftMarginPenalty()
	 * @generated
	 * @ordered
	 */
	protected double softMarginPenalty = SOFT_MARGIN_PENALTY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SVMAlgorithmSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.SVM_ALGORITHM_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getGaussianSigma() {
		return gaussianSigma;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGaussianSigma(double newGaussianSigma) {
		double oldGaussianSigma = gaussianSigma;
		gaussianSigma = newGaussianSigma;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.SVM_ALGORITHM_SPECIFIER__GAUSSIAN_SIGMA, oldGaussianSigma, gaussianSigma));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSoftMarginPenalty() {
		return softMarginPenalty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoftMarginPenalty(double newSoftMarginPenalty) {
		double oldSoftMarginPenalty = softMarginPenalty;
		softMarginPenalty = newSoftMarginPenalty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.SVM_ALGORITHM_SPECIFIER__SOFT_MARGIN_PENALTY, oldSoftMarginPenalty, softMarginPenalty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.SVM_ALGORITHM_SPECIFIER__GAUSSIAN_SIGMA:
				return getGaussianSigma();
			case RecommendationPackage.SVM_ALGORITHM_SPECIFIER__SOFT_MARGIN_PENALTY:
				return getSoftMarginPenalty();
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
			case RecommendationPackage.SVM_ALGORITHM_SPECIFIER__GAUSSIAN_SIGMA:
				setGaussianSigma((Double)newValue);
				return;
			case RecommendationPackage.SVM_ALGORITHM_SPECIFIER__SOFT_MARGIN_PENALTY:
				setSoftMarginPenalty((Double)newValue);
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
			case RecommendationPackage.SVM_ALGORITHM_SPECIFIER__GAUSSIAN_SIGMA:
				setGaussianSigma(GAUSSIAN_SIGMA_EDEFAULT);
				return;
			case RecommendationPackage.SVM_ALGORITHM_SPECIFIER__SOFT_MARGIN_PENALTY:
				setSoftMarginPenalty(SOFT_MARGIN_PENALTY_EDEFAULT);
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
			case RecommendationPackage.SVM_ALGORITHM_SPECIFIER__GAUSSIAN_SIGMA:
				return gaussianSigma != GAUSSIAN_SIGMA_EDEFAULT;
			case RecommendationPackage.SVM_ALGORITHM_SPECIFIER__SOFT_MARGIN_PENALTY:
				return softMarginPenalty != SOFT_MARGIN_PENALTY_EDEFAULT;
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
		result.append(" (gaussianSigma: ");
		result.append(gaussianSigma);
		result.append(", softMarginPenalty: ");
		result.append(softMarginPenalty);
		result.append(')');
		return result.toString();
	}

} //SVMAlgorithmSpecifierImpl
