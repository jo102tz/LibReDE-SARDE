/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tools.descartes.librede.rrde.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.recommendation.StatisticalFeatures;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statistical Features</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getN <em>N</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getArithmeticMean <em>Arithmetic Mean</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getGeometricMean <em>Geometric Mean</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getStandardDeviation <em>Standard Deviation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getQuadraticMean <em>Quadratic Mean</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getKurtosis <em>Kurtosis</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getSkewness <em>Skewness</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getTenthpercentile <em>Tenthpercentile</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getNinetiethpercentile <em>Ninetiethpercentile</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getPearsonCorrelationMatrixNorm <em>Pearson Correlation Matrix Norm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getSpearmanCorrelationMatrixNorm <em>Spearman Correlation Matrix Norm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getKendallCorrelationMatrixNorm <em>Kendall Correlation Matrix Norm</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.StatisticalFeaturesImpl#getCovarianceMatrixNorm <em>Covariance Matrix Norm</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatisticalFeaturesImpl extends MinimalEObjectImpl.Container implements StatisticalFeatures {
	/**
	 * The default value of the '{@link #getN() <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getN()
	 * @generated
	 * @ordered
	 */
	protected static final double N_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getN() <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getN()
	 * @generated
	 * @ordered
	 */
	protected double n = N_EDEFAULT;

	/**
	 * The default value of the '{@link #getArithmeticMean() <em>Arithmetic Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArithmeticMean()
	 * @generated
	 * @ordered
	 */
	protected static final double ARITHMETIC_MEAN_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getArithmeticMean() <em>Arithmetic Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArithmeticMean()
	 * @generated
	 * @ordered
	 */
	protected double arithmeticMean = ARITHMETIC_MEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getGeometricMean() <em>Geometric Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeometricMean()
	 * @generated
	 * @ordered
	 */
	protected static final double GEOMETRIC_MEAN_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getGeometricMean() <em>Geometric Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeometricMean()
	 * @generated
	 * @ordered
	 */
	protected double geometricMean = GEOMETRIC_MEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getStandardDeviation() <em>Standard Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardDeviation()
	 * @generated
	 * @ordered
	 */
	protected static final double STANDARD_DEVIATION_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getStandardDeviation() <em>Standard Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandardDeviation()
	 * @generated
	 * @ordered
	 */
	protected double standardDeviation = STANDARD_DEVIATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuadraticMean() <em>Quadratic Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuadraticMean()
	 * @generated
	 * @ordered
	 */
	protected static final double QUADRATIC_MEAN_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getQuadraticMean() <em>Quadratic Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuadraticMean()
	 * @generated
	 * @ordered
	 */
	protected double quadraticMean = QUADRATIC_MEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected static final double MINIMUM_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getMinimum() <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimum()
	 * @generated
	 * @ordered
	 */
	protected double minimum = MINIMUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected static final double MAXIMUM_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximum()
	 * @generated
	 * @ordered
	 */
	protected double maximum = MAXIMUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getKurtosis() <em>Kurtosis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKurtosis()
	 * @generated
	 * @ordered
	 */
	protected static final double KURTOSIS_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getKurtosis() <em>Kurtosis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKurtosis()
	 * @generated
	 * @ordered
	 */
	protected double kurtosis = KURTOSIS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSkewness() <em>Skewness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkewness()
	 * @generated
	 * @ordered
	 */
	protected static final double SKEWNESS_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getSkewness() <em>Skewness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkewness()
	 * @generated
	 * @ordered
	 */
	protected double skewness = SKEWNESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTenthpercentile() <em>Tenthpercentile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTenthpercentile()
	 * @generated
	 * @ordered
	 */
	protected static final double TENTHPERCENTILE_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getTenthpercentile() <em>Tenthpercentile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTenthpercentile()
	 * @generated
	 * @ordered
	 */
	protected double tenthpercentile = TENTHPERCENTILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNinetiethpercentile() <em>Ninetiethpercentile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNinetiethpercentile()
	 * @generated
	 * @ordered
	 */
	protected static final double NINETIETHPERCENTILE_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getNinetiethpercentile() <em>Ninetiethpercentile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNinetiethpercentile()
	 * @generated
	 * @ordered
	 */
	protected double ninetiethpercentile = NINETIETHPERCENTILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPearsonCorrelationMatrixNorm() <em>Pearson Correlation Matrix Norm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPearsonCorrelationMatrixNorm()
	 * @generated
	 * @ordered
	 */
	protected static final double PEARSON_CORRELATION_MATRIX_NORM_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getPearsonCorrelationMatrixNorm() <em>Pearson Correlation Matrix Norm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPearsonCorrelationMatrixNorm()
	 * @generated
	 * @ordered
	 */
	protected double pearsonCorrelationMatrixNorm = PEARSON_CORRELATION_MATRIX_NORM_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpearmanCorrelationMatrixNorm() <em>Spearman Correlation Matrix Norm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpearmanCorrelationMatrixNorm()
	 * @generated
	 * @ordered
	 */
	protected static final double SPEARMAN_CORRELATION_MATRIX_NORM_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getSpearmanCorrelationMatrixNorm() <em>Spearman Correlation Matrix Norm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpearmanCorrelationMatrixNorm()
	 * @generated
	 * @ordered
	 */
	protected double spearmanCorrelationMatrixNorm = SPEARMAN_CORRELATION_MATRIX_NORM_EDEFAULT;

	/**
	 * The default value of the '{@link #getKendallCorrelationMatrixNorm() <em>Kendall Correlation Matrix Norm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKendallCorrelationMatrixNorm()
	 * @generated
	 * @ordered
	 */
	protected static final double KENDALL_CORRELATION_MATRIX_NORM_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getKendallCorrelationMatrixNorm() <em>Kendall Correlation Matrix Norm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKendallCorrelationMatrixNorm()
	 * @generated
	 * @ordered
	 */
	protected double kendallCorrelationMatrixNorm = KENDALL_CORRELATION_MATRIX_NORM_EDEFAULT;

	/**
	 * The default value of the '{@link #getCovarianceMatrixNorm() <em>Covariance Matrix Norm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCovarianceMatrixNorm()
	 * @generated
	 * @ordered
	 */
	protected static final double COVARIANCE_MATRIX_NORM_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getCovarianceMatrixNorm() <em>Covariance Matrix Norm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCovarianceMatrixNorm()
	 * @generated
	 * @ordered
	 */
	protected double covarianceMatrixNorm = COVARIANCE_MATRIX_NORM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalFeaturesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.STATISTICAL_FEATURES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getN() {
		return n;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setN(double newN) {
		double oldN = n;
		n = newN;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__N, oldN, n));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getArithmeticMean() {
		return arithmeticMean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArithmeticMean(double newArithmeticMean) {
		double oldArithmeticMean = arithmeticMean;
		arithmeticMean = newArithmeticMean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__ARITHMETIC_MEAN, oldArithmeticMean, arithmeticMean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getGeometricMean() {
		return geometricMean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeometricMean(double newGeometricMean) {
		double oldGeometricMean = geometricMean;
		geometricMean = newGeometricMean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__GEOMETRIC_MEAN, oldGeometricMean, geometricMean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStandardDeviation() {
		return standardDeviation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandardDeviation(double newStandardDeviation) {
		double oldStandardDeviation = standardDeviation;
		standardDeviation = newStandardDeviation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__STANDARD_DEVIATION, oldStandardDeviation, standardDeviation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getQuadraticMean() {
		return quadraticMean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuadraticMean(double newQuadraticMean) {
		double oldQuadraticMean = quadraticMean;
		quadraticMean = newQuadraticMean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__QUADRATIC_MEAN, oldQuadraticMean, quadraticMean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMinimum() {
		return minimum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimum(double newMinimum) {
		double oldMinimum = minimum;
		minimum = newMinimum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__MINIMUM, oldMinimum, minimum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaximum() {
		return maximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximum(double newMaximum) {
		double oldMaximum = maximum;
		maximum = newMaximum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__MAXIMUM, oldMaximum, maximum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getKurtosis() {
		return kurtosis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKurtosis(double newKurtosis) {
		double oldKurtosis = kurtosis;
		kurtosis = newKurtosis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__KURTOSIS, oldKurtosis, kurtosis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSkewness() {
		return skewness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSkewness(double newSkewness) {
		double oldSkewness = skewness;
		skewness = newSkewness;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__SKEWNESS, oldSkewness, skewness));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTenthpercentile() {
		return tenthpercentile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTenthpercentile(double newTenthpercentile) {
		double oldTenthpercentile = tenthpercentile;
		tenthpercentile = newTenthpercentile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__TENTHPERCENTILE, oldTenthpercentile, tenthpercentile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getNinetiethpercentile() {
		return ninetiethpercentile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNinetiethpercentile(double newNinetiethpercentile) {
		double oldNinetiethpercentile = ninetiethpercentile;
		ninetiethpercentile = newNinetiethpercentile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__NINETIETHPERCENTILE, oldNinetiethpercentile, ninetiethpercentile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPearsonCorrelationMatrixNorm() {
		return pearsonCorrelationMatrixNorm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPearsonCorrelationMatrixNorm(double newPearsonCorrelationMatrixNorm) {
		double oldPearsonCorrelationMatrixNorm = pearsonCorrelationMatrixNorm;
		pearsonCorrelationMatrixNorm = newPearsonCorrelationMatrixNorm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__PEARSON_CORRELATION_MATRIX_NORM, oldPearsonCorrelationMatrixNorm, pearsonCorrelationMatrixNorm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSpearmanCorrelationMatrixNorm() {
		return spearmanCorrelationMatrixNorm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpearmanCorrelationMatrixNorm(double newSpearmanCorrelationMatrixNorm) {
		double oldSpearmanCorrelationMatrixNorm = spearmanCorrelationMatrixNorm;
		spearmanCorrelationMatrixNorm = newSpearmanCorrelationMatrixNorm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__SPEARMAN_CORRELATION_MATRIX_NORM, oldSpearmanCorrelationMatrixNorm, spearmanCorrelationMatrixNorm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getKendallCorrelationMatrixNorm() {
		return kendallCorrelationMatrixNorm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKendallCorrelationMatrixNorm(double newKendallCorrelationMatrixNorm) {
		double oldKendallCorrelationMatrixNorm = kendallCorrelationMatrixNorm;
		kendallCorrelationMatrixNorm = newKendallCorrelationMatrixNorm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__KENDALL_CORRELATION_MATRIX_NORM, oldKendallCorrelationMatrixNorm, kendallCorrelationMatrixNorm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCovarianceMatrixNorm() {
		return covarianceMatrixNorm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCovarianceMatrixNorm(double newCovarianceMatrixNorm) {
		double oldCovarianceMatrixNorm = covarianceMatrixNorm;
		covarianceMatrixNorm = newCovarianceMatrixNorm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.STATISTICAL_FEATURES__COVARIANCE_MATRIX_NORM, oldCovarianceMatrixNorm, covarianceMatrixNorm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.STATISTICAL_FEATURES__N:
				return getN();
			case RecommendationPackage.STATISTICAL_FEATURES__ARITHMETIC_MEAN:
				return getArithmeticMean();
			case RecommendationPackage.STATISTICAL_FEATURES__GEOMETRIC_MEAN:
				return getGeometricMean();
			case RecommendationPackage.STATISTICAL_FEATURES__STANDARD_DEVIATION:
				return getStandardDeviation();
			case RecommendationPackage.STATISTICAL_FEATURES__QUADRATIC_MEAN:
				return getQuadraticMean();
			case RecommendationPackage.STATISTICAL_FEATURES__MINIMUM:
				return getMinimum();
			case RecommendationPackage.STATISTICAL_FEATURES__MAXIMUM:
				return getMaximum();
			case RecommendationPackage.STATISTICAL_FEATURES__KURTOSIS:
				return getKurtosis();
			case RecommendationPackage.STATISTICAL_FEATURES__SKEWNESS:
				return getSkewness();
			case RecommendationPackage.STATISTICAL_FEATURES__TENTHPERCENTILE:
				return getTenthpercentile();
			case RecommendationPackage.STATISTICAL_FEATURES__NINETIETHPERCENTILE:
				return getNinetiethpercentile();
			case RecommendationPackage.STATISTICAL_FEATURES__PEARSON_CORRELATION_MATRIX_NORM:
				return getPearsonCorrelationMatrixNorm();
			case RecommendationPackage.STATISTICAL_FEATURES__SPEARMAN_CORRELATION_MATRIX_NORM:
				return getSpearmanCorrelationMatrixNorm();
			case RecommendationPackage.STATISTICAL_FEATURES__KENDALL_CORRELATION_MATRIX_NORM:
				return getKendallCorrelationMatrixNorm();
			case RecommendationPackage.STATISTICAL_FEATURES__COVARIANCE_MATRIX_NORM:
				return getCovarianceMatrixNorm();
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
			case RecommendationPackage.STATISTICAL_FEATURES__N:
				setN((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__ARITHMETIC_MEAN:
				setArithmeticMean((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__GEOMETRIC_MEAN:
				setGeometricMean((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__STANDARD_DEVIATION:
				setStandardDeviation((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__QUADRATIC_MEAN:
				setQuadraticMean((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__MINIMUM:
				setMinimum((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__MAXIMUM:
				setMaximum((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__KURTOSIS:
				setKurtosis((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__SKEWNESS:
				setSkewness((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__TENTHPERCENTILE:
				setTenthpercentile((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__NINETIETHPERCENTILE:
				setNinetiethpercentile((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__PEARSON_CORRELATION_MATRIX_NORM:
				setPearsonCorrelationMatrixNorm((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__SPEARMAN_CORRELATION_MATRIX_NORM:
				setSpearmanCorrelationMatrixNorm((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__KENDALL_CORRELATION_MATRIX_NORM:
				setKendallCorrelationMatrixNorm((Double)newValue);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__COVARIANCE_MATRIX_NORM:
				setCovarianceMatrixNorm((Double)newValue);
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
			case RecommendationPackage.STATISTICAL_FEATURES__N:
				setN(N_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__ARITHMETIC_MEAN:
				setArithmeticMean(ARITHMETIC_MEAN_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__GEOMETRIC_MEAN:
				setGeometricMean(GEOMETRIC_MEAN_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__STANDARD_DEVIATION:
				setStandardDeviation(STANDARD_DEVIATION_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__QUADRATIC_MEAN:
				setQuadraticMean(QUADRATIC_MEAN_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__MINIMUM:
				setMinimum(MINIMUM_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__MAXIMUM:
				setMaximum(MAXIMUM_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__KURTOSIS:
				setKurtosis(KURTOSIS_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__SKEWNESS:
				setSkewness(SKEWNESS_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__TENTHPERCENTILE:
				setTenthpercentile(TENTHPERCENTILE_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__NINETIETHPERCENTILE:
				setNinetiethpercentile(NINETIETHPERCENTILE_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__PEARSON_CORRELATION_MATRIX_NORM:
				setPearsonCorrelationMatrixNorm(PEARSON_CORRELATION_MATRIX_NORM_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__SPEARMAN_CORRELATION_MATRIX_NORM:
				setSpearmanCorrelationMatrixNorm(SPEARMAN_CORRELATION_MATRIX_NORM_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__KENDALL_CORRELATION_MATRIX_NORM:
				setKendallCorrelationMatrixNorm(KENDALL_CORRELATION_MATRIX_NORM_EDEFAULT);
				return;
			case RecommendationPackage.STATISTICAL_FEATURES__COVARIANCE_MATRIX_NORM:
				setCovarianceMatrixNorm(COVARIANCE_MATRIX_NORM_EDEFAULT);
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
			case RecommendationPackage.STATISTICAL_FEATURES__N:
				return n != N_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__ARITHMETIC_MEAN:
				return arithmeticMean != ARITHMETIC_MEAN_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__GEOMETRIC_MEAN:
				return geometricMean != GEOMETRIC_MEAN_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__STANDARD_DEVIATION:
				return standardDeviation != STANDARD_DEVIATION_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__QUADRATIC_MEAN:
				return quadraticMean != QUADRATIC_MEAN_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__MINIMUM:
				return minimum != MINIMUM_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__MAXIMUM:
				return maximum != MAXIMUM_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__KURTOSIS:
				return kurtosis != KURTOSIS_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__SKEWNESS:
				return skewness != SKEWNESS_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__TENTHPERCENTILE:
				return tenthpercentile != TENTHPERCENTILE_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__NINETIETHPERCENTILE:
				return ninetiethpercentile != NINETIETHPERCENTILE_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__PEARSON_CORRELATION_MATRIX_NORM:
				return pearsonCorrelationMatrixNorm != PEARSON_CORRELATION_MATRIX_NORM_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__SPEARMAN_CORRELATION_MATRIX_NORM:
				return spearmanCorrelationMatrixNorm != SPEARMAN_CORRELATION_MATRIX_NORM_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__KENDALL_CORRELATION_MATRIX_NORM:
				return kendallCorrelationMatrixNorm != KENDALL_CORRELATION_MATRIX_NORM_EDEFAULT;
			case RecommendationPackage.STATISTICAL_FEATURES__COVARIANCE_MATRIX_NORM:
				return covarianceMatrixNorm != COVARIANCE_MATRIX_NORM_EDEFAULT;
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
		result.append(" (N: ");
		result.append(n);
		result.append(", arithmeticMean: ");
		result.append(arithmeticMean);
		result.append(", geometricMean: ");
		result.append(geometricMean);
		result.append(", standardDeviation: ");
		result.append(standardDeviation);
		result.append(", quadraticMean: ");
		result.append(quadraticMean);
		result.append(", minimum: ");
		result.append(minimum);
		result.append(", maximum: ");
		result.append(maximum);
		result.append(", kurtosis: ");
		result.append(kurtosis);
		result.append(", skewness: ");
		result.append(skewness);
		result.append(", tenthpercentile: ");
		result.append(tenthpercentile);
		result.append(", ninetiethpercentile: ");
		result.append(ninetiethpercentile);
		result.append(", pearsonCorrelationMatrixNorm: ");
		result.append(pearsonCorrelationMatrixNorm);
		result.append(", spearmanCorrelationMatrixNorm: ");
		result.append(spearmanCorrelationMatrixNorm);
		result.append(", kendallCorrelationMatrixNorm: ");
		result.append(kendallCorrelationMatrixNorm);
		result.append(", covarianceMatrixNorm: ");
		result.append(covarianceMatrixNorm);
		result.append(')');
		return result.toString();
	}

} //StatisticalFeaturesImpl
