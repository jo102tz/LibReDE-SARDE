/**
 */
package tools.descartes.librede.rrde.model.recommendation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.ValidationSpecification;
import tools.descartes.librede.rrde.model.optimization.InputData;
import tools.descartes.librede.rrde.model.recommendation.FeatureExtractorSpecifier;
import tools.descartes.librede.rrde.model.recommendation.RecommendationAlgorithmSpecifier;
import tools.descartes.librede.rrde.model.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.model.recommendation.RecommendationTrainingConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Training Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.impl.RecommendationTrainingConfigurationImpl#getValidator <em>Validator</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.impl.RecommendationTrainingConfigurationImpl#getTrainingData <em>Training Data</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.impl.RecommendationTrainingConfigurationImpl#getFeatureAlgorithm <em>Feature Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.impl.RecommendationTrainingConfigurationImpl#getLearningAlgorithm <em>Learning Algorithm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.impl.RecommendationTrainingConfigurationImpl#getEstimators <em>Estimators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecommendationTrainingConfigurationImpl extends MinimalEObjectImpl.Container implements RecommendationTrainingConfiguration {
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
	 * The cached value of the '{@link #getTrainingData() <em>Training Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrainingData()
	 * @generated
	 * @ordered
	 */
	protected EList<InputData> trainingData;

	/**
	 * The cached value of the '{@link #getFeatureAlgorithm() <em>Feature Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected FeatureExtractorSpecifier featureAlgorithm;

	/**
	 * The cached value of the '{@link #getLearningAlgorithm() <em>Learning Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLearningAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected RecommendationAlgorithmSpecifier learningAlgorithm;

	/**
	 * The cached value of the '{@link #getEstimators() <em>Estimators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEstimators()
	 * @generated
	 * @ordered
	 */
	protected EList<EstimationSpecification> estimators;

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
	public EList<InputData> getTrainingData() {
		if (trainingData == null) {
			trainingData = new EObjectContainmentEList<InputData>(InputData.class, this, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA);
		}
		return trainingData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureExtractorSpecifier getFeatureAlgorithm() {
		return featureAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFeatureAlgorithm(FeatureExtractorSpecifier newFeatureAlgorithm, NotificationChain msgs) {
		FeatureExtractorSpecifier oldFeatureAlgorithm = featureAlgorithm;
		featureAlgorithm = newFeatureAlgorithm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM, oldFeatureAlgorithm, newFeatureAlgorithm);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureAlgorithm(FeatureExtractorSpecifier newFeatureAlgorithm) {
		if (newFeatureAlgorithm != featureAlgorithm) {
			NotificationChain msgs = null;
			if (featureAlgorithm != null)
				msgs = ((InternalEObject)featureAlgorithm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM, null, msgs);
			if (newFeatureAlgorithm != null)
				msgs = ((InternalEObject)newFeatureAlgorithm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM, null, msgs);
			msgs = basicSetFeatureAlgorithm(newFeatureAlgorithm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM, newFeatureAlgorithm, newFeatureAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendationAlgorithmSpecifier getLearningAlgorithm() {
		return learningAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLearningAlgorithm(RecommendationAlgorithmSpecifier newLearningAlgorithm, NotificationChain msgs) {
		RecommendationAlgorithmSpecifier oldLearningAlgorithm = learningAlgorithm;
		learningAlgorithm = newLearningAlgorithm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM, oldLearningAlgorithm, newLearningAlgorithm);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLearningAlgorithm(RecommendationAlgorithmSpecifier newLearningAlgorithm) {
		if (newLearningAlgorithm != learningAlgorithm) {
			NotificationChain msgs = null;
			if (learningAlgorithm != null)
				msgs = ((InternalEObject)learningAlgorithm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM, null, msgs);
			if (newLearningAlgorithm != null)
				msgs = ((InternalEObject)newLearningAlgorithm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM, null, msgs);
			msgs = basicSetLearningAlgorithm(newLearningAlgorithm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM, newLearningAlgorithm, newLearningAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EstimationSpecification> getEstimators() {
		if (estimators == null) {
			estimators = new EObjectContainmentEList<EstimationSpecification>(EstimationSpecification.class, this, RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__ESTIMATORS);
		}
		return estimators;
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
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA:
				return ((InternalEList<?>)getTrainingData()).basicRemove(otherEnd, msgs);
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM:
				return basicSetFeatureAlgorithm(null, msgs);
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM:
				return basicSetLearningAlgorithm(null, msgs);
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__ESTIMATORS:
				return ((InternalEList<?>)getEstimators()).basicRemove(otherEnd, msgs);
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
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR:
				return getValidator();
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA:
				return getTrainingData();
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM:
				return getFeatureAlgorithm();
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM:
				return getLearningAlgorithm();
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__ESTIMATORS:
				return getEstimators();
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
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR:
				setValidator((ValidationSpecification)newValue);
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA:
				getTrainingData().clear();
				getTrainingData().addAll((Collection<? extends InputData>)newValue);
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM:
				setFeatureAlgorithm((FeatureExtractorSpecifier)newValue);
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM:
				setLearningAlgorithm((RecommendationAlgorithmSpecifier)newValue);
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__ESTIMATORS:
				getEstimators().clear();
				getEstimators().addAll((Collection<? extends EstimationSpecification>)newValue);
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
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR:
				setValidator((ValidationSpecification)null);
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA:
				getTrainingData().clear();
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM:
				setFeatureAlgorithm((FeatureExtractorSpecifier)null);
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM:
				setLearningAlgorithm((RecommendationAlgorithmSpecifier)null);
				return;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__ESTIMATORS:
				getEstimators().clear();
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
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__VALIDATOR:
				return validator != null;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__TRAINING_DATA:
				return trainingData != null && !trainingData.isEmpty();
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__FEATURE_ALGORITHM:
				return featureAlgorithm != null;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__LEARNING_ALGORITHM:
				return learningAlgorithm != null;
			case RecommendationPackage.RECOMMENDATION_TRAINING_CONFIGURATION__ESTIMATORS:
				return estimators != null && !estimators.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RecommendationTrainingConfigurationImpl
