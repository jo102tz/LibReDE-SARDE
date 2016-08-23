/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import tools.descartes.librede.configuration.EstimationSpecification;

import tools.descartes.librede.configuration.ValidationSpecification;
import tools.descartes.librede.rrde.optimization.InputData;

import tools.descartes.librede.rrde.recommendation.FeatureExtractorSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationAlgorithmSpecifier;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.recommendation.RecommendationTrainingConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Training Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.RecommendationTrainingConfigurationImpl#getTrainingData <em>Training Data</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.RecommendationTrainingConfigurationImpl#getLearningAlgorithm <em>Learning Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.RecommendationTrainingConfigurationImpl#getFeatureAlgorithm <em>Feature Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.RecommendationTrainingConfigurationImpl#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.RecommendationTrainingConfigurationImpl#getValidator <em>Validator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecommendationTrainingConfigurationImpl extends MinimalEObjectImpl.Container implements RecommendationTrainingConfiguration {
	/**
	 * The cached value of the '{@link #getTrainingData() <em>Training Data</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrainingData()
	 * @generated
	 * @ordered
	 */
	protected EList<InputData> trainingData;

	/**
	 * The cached value of the '{@link #getLearningAlgorithm() <em>Learning Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLearningAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected RecommendationAlgorithmSpecifier learningAlgorithm;

	/**
	 * The cached value of the '{@link #getFeatureAlgorithm() <em>Feature Algorithm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected FeatureExtractorSpecifier featureAlgorithm;

	/**
	 * The cached value of the '{@link #getConfigurations() <em>Configurations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<EstimationSpecification> configurations;

	/**
	 * The cached value of the '{@link #getValidator() <em>Validator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidator()
	 * @generated
	 * @ordered
	 */
	protected ValidationSpecification validator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationTrainingConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.RECOMMENDATION_TRAINING_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputData> getTrainingData() {
		if (trainingData == null) {
			trainingData = new EObjectResolvingEList<InputData>(InputData.class, this, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA);
		}
		return trainingData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationAlgorithmSpecifier getLearningAlgorithm() {
		if (learningAlgorithm != null && learningAlgorithm.eIsProxy()) {
			InternalEObject oldLearningAlgorithm = (InternalEObject)learningAlgorithm;
			learningAlgorithm = (RecommendationAlgorithmSpecifier)eResolveProxy(oldLearningAlgorithm);
			if (learningAlgorithm != oldLearningAlgorithm) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM, oldLearningAlgorithm, learningAlgorithm));
			}
		}
		return learningAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationAlgorithmSpecifier basicGetLearningAlgorithm() {
		return learningAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLearningAlgorithm(RecommendationAlgorithmSpecifier newLearningAlgorithm) {
		RecommendationAlgorithmSpecifier oldLearningAlgorithm = learningAlgorithm;
		learningAlgorithm = newLearningAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM, oldLearningAlgorithm, learningAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureExtractorSpecifier getFeatureAlgorithm() {
		if (featureAlgorithm != null && featureAlgorithm.eIsProxy()) {
			InternalEObject oldFeatureAlgorithm = (InternalEObject)featureAlgorithm;
			featureAlgorithm = (FeatureExtractorSpecifier)eResolveProxy(oldFeatureAlgorithm);
			if (featureAlgorithm != oldFeatureAlgorithm) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM, oldFeatureAlgorithm, featureAlgorithm));
			}
		}
		return featureAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureExtractorSpecifier basicGetFeatureAlgorithm() {
		return featureAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureAlgorithm(FeatureExtractorSpecifier newFeatureAlgorithm) {
		FeatureExtractorSpecifier oldFeatureAlgorithm = featureAlgorithm;
		featureAlgorithm = newFeatureAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM, oldFeatureAlgorithm, featureAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EstimationSpecification> getConfigurations() {
		if (configurations == null) {
			configurations = new EObjectResolvingEList<EstimationSpecification>(EstimationSpecification.class, this, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__CONFIGURATIONS);
		}
		return configurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidationSpecification getValidator() {
		return validator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValidator(ValidationSpecification newValidator, NotificationChain msgs) {
		ValidationSpecification oldValidator = validator;
		validator = newValidator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR, oldValidator, newValidator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidator(ValidationSpecification newValidator) {
		if (newValidator != validator) {
			NotificationChain msgs = null;
			if (validator != null)
				msgs = ((InternalEObject)validator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR, null, msgs);
			if (newValidator != null)
				msgs = ((InternalEObject)newValidator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR, null, msgs);
			msgs = basicSetValidator(newValidator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR, newValidator, newValidator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR:
				return basicSetValidator(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA:
				return getTrainingData();
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM:
				if (resolve) return getLearningAlgorithm();
				return basicGetLearningAlgorithm();
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM:
				if (resolve) return getFeatureAlgorithm();
				return basicGetFeatureAlgorithm();
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__CONFIGURATIONS:
				return getConfigurations();
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR:
				return getValidator();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA:
				getTrainingData().clear();
				getTrainingData().addAll((Collection<? extends InputData>)newValue);
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM:
				setLearningAlgorithm((RecommendationAlgorithmSpecifier)newValue);
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM:
				setFeatureAlgorithm((FeatureExtractorSpecifier)newValue);
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__CONFIGURATIONS:
				getConfigurations().clear();
				getConfigurations().addAll((Collection<? extends EstimationSpecification>)newValue);
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR:
				setValidator((ValidationSpecification)newValue);
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
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA:
				getTrainingData().clear();
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM:
				setLearningAlgorithm((RecommendationAlgorithmSpecifier)null);
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM:
				setFeatureAlgorithm((FeatureExtractorSpecifier)null);
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__CONFIGURATIONS:
				getConfigurations().clear();
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR:
				setValidator((ValidationSpecification)null);
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
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA:
				return trainingData != null && !trainingData.isEmpty();
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM:
				return learningAlgorithm != null;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM:
				return featureAlgorithm != null;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__CONFIGURATIONS:
				return configurations != null && !configurations.isEmpty();
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR:
				return validator != null;
		}
		return super.eIsSet(featureID);
	}

} //RecommendationTrainingConfigurationImpl
