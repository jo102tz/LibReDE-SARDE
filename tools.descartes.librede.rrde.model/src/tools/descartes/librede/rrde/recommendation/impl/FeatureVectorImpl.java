/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import tools.descartes.librede.rrde.recommendation.FeatureVector;
import tools.descartes.librede.rrde.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.recommendation.StatisticalFeatures;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Vector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getNumberOfRessources <em>Number Of Ressources</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getNumberOfWorkloadClasses <em>Number Of Workload Classes</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getVarianceInflationFactor <em>Variance Inflation Factor</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getUtilizationStatistics <em>Utilization Statistics</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getResponseTimeStatistics <em>Response Time Statistics</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getArrivalRateStatistics <em>Arrival Rate Statistics</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getResponseArrivalCorrelation <em>Response Arrival Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getResponseArrivalCovariance <em>Response Arrival Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getUtilizationResponseCorrelation <em>Utilization Response Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getUtilizationResponseCovariance <em>Utilization Response Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getUtilizationArrivalCorrelation <em>Utilization Arrival Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getUtilizationArrivalCovariance <em>Utilization Arrival Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getIntraUtilizationCorrelation <em>Intra Utilization Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getIntraUtilizationCovariance <em>Intra Utilization Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getIntraResponseTimeCorrelation <em>Intra Response Time Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getIntraResponseTimeCovariance <em>Intra Response Time Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getIntraArrivalRateCorrelation <em>Intra Arrival Rate Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getIntraArrivalRateCovariance <em>Intra Arrival Rate Covariance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureVectorImpl extends MinimalEObjectImpl.Container implements FeatureVector {
	/**
	 * The default value of the '{@link #getNumberOfRessources() <em>Number Of Ressources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfRessources()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_RESSOURCES_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getNumberOfRessources() <em>Number Of Ressources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfRessources()
	 * @generated
	 * @ordered
	 */
	protected int numberOfRessources = NUMBER_OF_RESSOURCES_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumberOfWorkloadClasses() <em>Number Of Workload Classes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfWorkloadClasses()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_WORKLOAD_CLASSES_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getNumberOfWorkloadClasses() <em>Number Of Workload Classes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfWorkloadClasses()
	 * @generated
	 * @ordered
	 */
	protected int numberOfWorkloadClasses = NUMBER_OF_WORKLOAD_CLASSES_EDEFAULT;

	/**
	 * The default value of the '{@link #getVarianceInflationFactor() <em>Variance Inflation Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarianceInflationFactor()
	 * @generated
	 * @ordered
	 */
	protected static final double VARIANCE_INFLATION_FACTOR_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getVarianceInflationFactor() <em>Variance Inflation Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarianceInflationFactor()
	 * @generated
	 * @ordered
	 */
	protected double varianceInflationFactor = VARIANCE_INFLATION_FACTOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUtilizationStatistics() <em>Utilization Statistics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationStatistics()
	 * @generated
	 * @ordered
	 */
	protected EList<StatisticalFeatures> utilizationStatistics;

	/**
	 * The cached value of the '{@link #getResponseTimeStatistics() <em>Response Time Statistics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseTimeStatistics()
	 * @generated
	 * @ordered
	 */
	protected EList<StatisticalFeatures> responseTimeStatistics;

	/**
	 * The cached value of the '{@link #getArrivalRateStatistics() <em>Arrival Rate Statistics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrivalRateStatistics()
	 * @generated
	 * @ordered
	 */
	protected EList<StatisticalFeatures> arrivalRateStatistics;

	/**
	 * The default value of the '{@link #getResponseArrivalCorrelation() <em>Response Arrival Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseArrivalCorrelation()
	 * @generated
	 * @ordered
	 */
	protected static final double RESPONSE_ARRIVAL_CORRELATION_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getResponseArrivalCorrelation() <em>Response Arrival Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseArrivalCorrelation()
	 * @generated
	 * @ordered
	 */
	protected double responseArrivalCorrelation = RESPONSE_ARRIVAL_CORRELATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getResponseArrivalCovariance() <em>Response Arrival Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseArrivalCovariance()
	 * @generated
	 * @ordered
	 */
	protected static final double RESPONSE_ARRIVAL_COVARIANCE_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getResponseArrivalCovariance() <em>Response Arrival Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseArrivalCovariance()
	 * @generated
	 * @ordered
	 */
	protected double responseArrivalCovariance = RESPONSE_ARRIVAL_COVARIANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUtilizationResponseCorrelation() <em>Utilization Response Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationResponseCorrelation()
	 * @generated
	 * @ordered
	 */
	protected static final double UTILIZATION_RESPONSE_CORRELATION_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getUtilizationResponseCorrelation() <em>Utilization Response Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationResponseCorrelation()
	 * @generated
	 * @ordered
	 */
	protected double utilizationResponseCorrelation = UTILIZATION_RESPONSE_CORRELATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getUtilizationResponseCovariance() <em>Utilization Response Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationResponseCovariance()
	 * @generated
	 * @ordered
	 */
	protected static final double UTILIZATION_RESPONSE_COVARIANCE_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getUtilizationResponseCovariance() <em>Utilization Response Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationResponseCovariance()
	 * @generated
	 * @ordered
	 */
	protected double utilizationResponseCovariance = UTILIZATION_RESPONSE_COVARIANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUtilizationArrivalCorrelation() <em>Utilization Arrival Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationArrivalCorrelation()
	 * @generated
	 * @ordered
	 */
	protected static final double UTILIZATION_ARRIVAL_CORRELATION_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getUtilizationArrivalCorrelation() <em>Utilization Arrival Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationArrivalCorrelation()
	 * @generated
	 * @ordered
	 */
	protected double utilizationArrivalCorrelation = UTILIZATION_ARRIVAL_CORRELATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getUtilizationArrivalCovariance() <em>Utilization Arrival Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationArrivalCovariance()
	 * @generated
	 * @ordered
	 */
	protected static final double UTILIZATION_ARRIVAL_COVARIANCE_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getUtilizationArrivalCovariance() <em>Utilization Arrival Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilizationArrivalCovariance()
	 * @generated
	 * @ordered
	 */
	protected double utilizationArrivalCovariance = UTILIZATION_ARRIVAL_COVARIANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntraUtilizationCorrelation() <em>Intra Utilization Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraUtilizationCorrelation()
	 * @generated
	 * @ordered
	 */
	protected static final double INTRA_UTILIZATION_CORRELATION_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getIntraUtilizationCorrelation() <em>Intra Utilization Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraUtilizationCorrelation()
	 * @generated
	 * @ordered
	 */
	protected double intraUtilizationCorrelation = INTRA_UTILIZATION_CORRELATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntraUtilizationCovariance() <em>Intra Utilization Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraUtilizationCovariance()
	 * @generated
	 * @ordered
	 */
	protected static final double INTRA_UTILIZATION_COVARIANCE_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getIntraUtilizationCovariance() <em>Intra Utilization Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraUtilizationCovariance()
	 * @generated
	 * @ordered
	 */
	protected double intraUtilizationCovariance = INTRA_UTILIZATION_COVARIANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntraResponseTimeCorrelation() <em>Intra Response Time Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraResponseTimeCorrelation()
	 * @generated
	 * @ordered
	 */
	protected static final double INTRA_RESPONSE_TIME_CORRELATION_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getIntraResponseTimeCorrelation() <em>Intra Response Time Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraResponseTimeCorrelation()
	 * @generated
	 * @ordered
	 */
	protected double intraResponseTimeCorrelation = INTRA_RESPONSE_TIME_CORRELATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntraResponseTimeCovariance() <em>Intra Response Time Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraResponseTimeCovariance()
	 * @generated
	 * @ordered
	 */
	protected static final double INTRA_RESPONSE_TIME_COVARIANCE_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getIntraResponseTimeCovariance() <em>Intra Response Time Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraResponseTimeCovariance()
	 * @generated
	 * @ordered
	 */
	protected double intraResponseTimeCovariance = INTRA_RESPONSE_TIME_COVARIANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntraArrivalRateCorrelation() <em>Intra Arrival Rate Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraArrivalRateCorrelation()
	 * @generated
	 * @ordered
	 */
	protected static final double INTRA_ARRIVAL_RATE_CORRELATION_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getIntraArrivalRateCorrelation() <em>Intra Arrival Rate Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraArrivalRateCorrelation()
	 * @generated
	 * @ordered
	 */
	protected double intraArrivalRateCorrelation = INTRA_ARRIVAL_RATE_CORRELATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntraArrivalRateCovariance() <em>Intra Arrival Rate Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraArrivalRateCovariance()
	 * @generated
	 * @ordered
	 */
	protected static final double INTRA_ARRIVAL_RATE_COVARIANCE_EDEFAULT = -1.0;

	/**
	 * The cached value of the '{@link #getIntraArrivalRateCovariance() <em>Intra Arrival Rate Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntraArrivalRateCovariance()
	 * @generated
	 * @ordered
	 */
	protected double intraArrivalRateCovariance = INTRA_ARRIVAL_RATE_COVARIANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureVectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.FEATURE_VECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfRessources() {
		return numberOfRessources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfRessources(int newNumberOfRessources) {
		int oldNumberOfRessources = numberOfRessources;
		numberOfRessources = newNumberOfRessources;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_RESSOURCES, oldNumberOfRessources, numberOfRessources));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfWorkloadClasses() {
		return numberOfWorkloadClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfWorkloadClasses(int newNumberOfWorkloadClasses) {
		int oldNumberOfWorkloadClasses = numberOfWorkloadClasses;
		numberOfWorkloadClasses = newNumberOfWorkloadClasses;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES, oldNumberOfWorkloadClasses, numberOfWorkloadClasses));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getVarianceInflationFactor() {
		return varianceInflationFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarianceInflationFactor(double newVarianceInflationFactor) {
		double oldVarianceInflationFactor = varianceInflationFactor;
		varianceInflationFactor = newVarianceInflationFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR, oldVarianceInflationFactor, varianceInflationFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StatisticalFeatures> getUtilizationStatistics() {
		if (utilizationStatistics == null) {
			utilizationStatistics = new EObjectResolvingEList<StatisticalFeatures>(StatisticalFeatures.class, this, RecommendationPackage.FEATURE_VECTOR__UTILIZATION_STATISTICS);
		}
		return utilizationStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StatisticalFeatures> getResponseTimeStatistics() {
		if (responseTimeStatistics == null) {
			responseTimeStatistics = new EObjectResolvingEList<StatisticalFeatures>(StatisticalFeatures.class, this, RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_STATISTICS);
		}
		return responseTimeStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StatisticalFeatures> getArrivalRateStatistics() {
		if (arrivalRateStatistics == null) {
			arrivalRateStatistics = new EObjectResolvingEList<StatisticalFeatures>(StatisticalFeatures.class, this, RecommendationPackage.FEATURE_VECTOR__ARRIVAL_RATE_STATISTICS);
		}
		return arrivalRateStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getResponseArrivalCorrelation() {
		return responseArrivalCorrelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseArrivalCorrelation(double newResponseArrivalCorrelation) {
		double oldResponseArrivalCorrelation = responseArrivalCorrelation;
		responseArrivalCorrelation = newResponseArrivalCorrelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__RESPONSE_ARRIVAL_CORRELATION, oldResponseArrivalCorrelation, responseArrivalCorrelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getResponseArrivalCovariance() {
		return responseArrivalCovariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseArrivalCovariance(double newResponseArrivalCovariance) {
		double oldResponseArrivalCovariance = responseArrivalCovariance;
		responseArrivalCovariance = newResponseArrivalCovariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__RESPONSE_ARRIVAL_COVARIANCE, oldResponseArrivalCovariance, responseArrivalCovariance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUtilizationResponseCorrelation() {
		return utilizationResponseCorrelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationResponseCorrelation(double newUtilizationResponseCorrelation) {
		double oldUtilizationResponseCorrelation = utilizationResponseCorrelation;
		utilizationResponseCorrelation = newUtilizationResponseCorrelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__UTILIZATION_RESPONSE_CORRELATION, oldUtilizationResponseCorrelation, utilizationResponseCorrelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUtilizationResponseCovariance() {
		return utilizationResponseCovariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationResponseCovariance(double newUtilizationResponseCovariance) {
		double oldUtilizationResponseCovariance = utilizationResponseCovariance;
		utilizationResponseCovariance = newUtilizationResponseCovariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__UTILIZATION_RESPONSE_COVARIANCE, oldUtilizationResponseCovariance, utilizationResponseCovariance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUtilizationArrivalCorrelation() {
		return utilizationArrivalCorrelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationArrivalCorrelation(double newUtilizationArrivalCorrelation) {
		double oldUtilizationArrivalCorrelation = utilizationArrivalCorrelation;
		utilizationArrivalCorrelation = newUtilizationArrivalCorrelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__UTILIZATION_ARRIVAL_CORRELATION, oldUtilizationArrivalCorrelation, utilizationArrivalCorrelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getUtilizationArrivalCovariance() {
		return utilizationArrivalCovariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilizationArrivalCovariance(double newUtilizationArrivalCovariance) {
		double oldUtilizationArrivalCovariance = utilizationArrivalCovariance;
		utilizationArrivalCovariance = newUtilizationArrivalCovariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__UTILIZATION_ARRIVAL_COVARIANCE, oldUtilizationArrivalCovariance, utilizationArrivalCovariance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIntraUtilizationCorrelation() {
		return intraUtilizationCorrelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntraUtilizationCorrelation(double newIntraUtilizationCorrelation) {
		double oldIntraUtilizationCorrelation = intraUtilizationCorrelation;
		intraUtilizationCorrelation = newIntraUtilizationCorrelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__INTRA_UTILIZATION_CORRELATION, oldIntraUtilizationCorrelation, intraUtilizationCorrelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIntraUtilizationCovariance() {
		return intraUtilizationCovariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntraUtilizationCovariance(double newIntraUtilizationCovariance) {
		double oldIntraUtilizationCovariance = intraUtilizationCovariance;
		intraUtilizationCovariance = newIntraUtilizationCovariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__INTRA_UTILIZATION_COVARIANCE, oldIntraUtilizationCovariance, intraUtilizationCovariance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIntraResponseTimeCorrelation() {
		return intraResponseTimeCorrelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntraResponseTimeCorrelation(double newIntraResponseTimeCorrelation) {
		double oldIntraResponseTimeCorrelation = intraResponseTimeCorrelation;
		intraResponseTimeCorrelation = newIntraResponseTimeCorrelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__INTRA_RESPONSE_TIME_CORRELATION, oldIntraResponseTimeCorrelation, intraResponseTimeCorrelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIntraResponseTimeCovariance() {
		return intraResponseTimeCovariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntraResponseTimeCovariance(double newIntraResponseTimeCovariance) {
		double oldIntraResponseTimeCovariance = intraResponseTimeCovariance;
		intraResponseTimeCovariance = newIntraResponseTimeCovariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__INTRA_RESPONSE_TIME_COVARIANCE, oldIntraResponseTimeCovariance, intraResponseTimeCovariance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIntraArrivalRateCorrelation() {
		return intraArrivalRateCorrelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntraArrivalRateCorrelation(double newIntraArrivalRateCorrelation) {
		double oldIntraArrivalRateCorrelation = intraArrivalRateCorrelation;
		intraArrivalRateCorrelation = newIntraArrivalRateCorrelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__INTRA_ARRIVAL_RATE_CORRELATION, oldIntraArrivalRateCorrelation, intraArrivalRateCorrelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIntraArrivalRateCovariance() {
		return intraArrivalRateCovariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntraArrivalRateCovariance(double newIntraArrivalRateCovariance) {
		double oldIntraArrivalRateCovariance = intraArrivalRateCovariance;
		intraArrivalRateCovariance = newIntraArrivalRateCovariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__INTRA_ARRIVAL_RATE_COVARIANCE, oldIntraArrivalRateCovariance, intraArrivalRateCovariance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_RESSOURCES:
				return getNumberOfRessources();
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES:
				return getNumberOfWorkloadClasses();
			case RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR:
				return getVarianceInflationFactor();
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_STATISTICS:
				return getUtilizationStatistics();
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_STATISTICS:
				return getResponseTimeStatistics();
			case RecommendationPackage.FEATURE_VECTOR__ARRIVAL_RATE_STATISTICS:
				return getArrivalRateStatistics();
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_ARRIVAL_CORRELATION:
				return getResponseArrivalCorrelation();
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_ARRIVAL_COVARIANCE:
				return getResponseArrivalCovariance();
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_RESPONSE_CORRELATION:
				return getUtilizationResponseCorrelation();
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_RESPONSE_COVARIANCE:
				return getUtilizationResponseCovariance();
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_ARRIVAL_CORRELATION:
				return getUtilizationArrivalCorrelation();
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_ARRIVAL_COVARIANCE:
				return getUtilizationArrivalCovariance();
			case RecommendationPackage.FEATURE_VECTOR__INTRA_UTILIZATION_CORRELATION:
				return getIntraUtilizationCorrelation();
			case RecommendationPackage.FEATURE_VECTOR__INTRA_UTILIZATION_COVARIANCE:
				return getIntraUtilizationCovariance();
			case RecommendationPackage.FEATURE_VECTOR__INTRA_RESPONSE_TIME_CORRELATION:
				return getIntraResponseTimeCorrelation();
			case RecommendationPackage.FEATURE_VECTOR__INTRA_RESPONSE_TIME_COVARIANCE:
				return getIntraResponseTimeCovariance();
			case RecommendationPackage.FEATURE_VECTOR__INTRA_ARRIVAL_RATE_CORRELATION:
				return getIntraArrivalRateCorrelation();
			case RecommendationPackage.FEATURE_VECTOR__INTRA_ARRIVAL_RATE_COVARIANCE:
				return getIntraArrivalRateCovariance();
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
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_RESSOURCES:
				setNumberOfRessources((Integer)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES:
				setNumberOfWorkloadClasses((Integer)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR:
				setVarianceInflationFactor((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_STATISTICS:
				getUtilizationStatistics().clear();
				getUtilizationStatistics().addAll((Collection<? extends StatisticalFeatures>)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_STATISTICS:
				getResponseTimeStatistics().clear();
				getResponseTimeStatistics().addAll((Collection<? extends StatisticalFeatures>)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__ARRIVAL_RATE_STATISTICS:
				getArrivalRateStatistics().clear();
				getArrivalRateStatistics().addAll((Collection<? extends StatisticalFeatures>)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_ARRIVAL_CORRELATION:
				setResponseArrivalCorrelation((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_ARRIVAL_COVARIANCE:
				setResponseArrivalCovariance((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_RESPONSE_CORRELATION:
				setUtilizationResponseCorrelation((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_RESPONSE_COVARIANCE:
				setUtilizationResponseCovariance((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_ARRIVAL_CORRELATION:
				setUtilizationArrivalCorrelation((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_ARRIVAL_COVARIANCE:
				setUtilizationArrivalCovariance((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_UTILIZATION_CORRELATION:
				setIntraUtilizationCorrelation((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_UTILIZATION_COVARIANCE:
				setIntraUtilizationCovariance((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_RESPONSE_TIME_CORRELATION:
				setIntraResponseTimeCorrelation((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_RESPONSE_TIME_COVARIANCE:
				setIntraResponseTimeCovariance((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_ARRIVAL_RATE_CORRELATION:
				setIntraArrivalRateCorrelation((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_ARRIVAL_RATE_COVARIANCE:
				setIntraArrivalRateCovariance((Double)newValue);
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
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_RESSOURCES:
				setNumberOfRessources(NUMBER_OF_RESSOURCES_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES:
				setNumberOfWorkloadClasses(NUMBER_OF_WORKLOAD_CLASSES_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR:
				setVarianceInflationFactor(VARIANCE_INFLATION_FACTOR_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_STATISTICS:
				getUtilizationStatistics().clear();
				return;
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_STATISTICS:
				getResponseTimeStatistics().clear();
				return;
			case RecommendationPackage.FEATURE_VECTOR__ARRIVAL_RATE_STATISTICS:
				getArrivalRateStatistics().clear();
				return;
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_ARRIVAL_CORRELATION:
				setResponseArrivalCorrelation(RESPONSE_ARRIVAL_CORRELATION_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_ARRIVAL_COVARIANCE:
				setResponseArrivalCovariance(RESPONSE_ARRIVAL_COVARIANCE_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_RESPONSE_CORRELATION:
				setUtilizationResponseCorrelation(UTILIZATION_RESPONSE_CORRELATION_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_RESPONSE_COVARIANCE:
				setUtilizationResponseCovariance(UTILIZATION_RESPONSE_COVARIANCE_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_ARRIVAL_CORRELATION:
				setUtilizationArrivalCorrelation(UTILIZATION_ARRIVAL_CORRELATION_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_ARRIVAL_COVARIANCE:
				setUtilizationArrivalCovariance(UTILIZATION_ARRIVAL_COVARIANCE_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_UTILIZATION_CORRELATION:
				setIntraUtilizationCorrelation(INTRA_UTILIZATION_CORRELATION_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_UTILIZATION_COVARIANCE:
				setIntraUtilizationCovariance(INTRA_UTILIZATION_COVARIANCE_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_RESPONSE_TIME_CORRELATION:
				setIntraResponseTimeCorrelation(INTRA_RESPONSE_TIME_CORRELATION_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_RESPONSE_TIME_COVARIANCE:
				setIntraResponseTimeCovariance(INTRA_RESPONSE_TIME_COVARIANCE_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_ARRIVAL_RATE_CORRELATION:
				setIntraArrivalRateCorrelation(INTRA_ARRIVAL_RATE_CORRELATION_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_ARRIVAL_RATE_COVARIANCE:
				setIntraArrivalRateCovariance(INTRA_ARRIVAL_RATE_COVARIANCE_EDEFAULT);
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
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_RESSOURCES:
				return numberOfRessources != NUMBER_OF_RESSOURCES_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__NUMBER_OF_WORKLOAD_CLASSES:
				return numberOfWorkloadClasses != NUMBER_OF_WORKLOAD_CLASSES_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__VARIANCE_INFLATION_FACTOR:
				return varianceInflationFactor != VARIANCE_INFLATION_FACTOR_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_STATISTICS:
				return utilizationStatistics != null && !utilizationStatistics.isEmpty();
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_TIME_STATISTICS:
				return responseTimeStatistics != null && !responseTimeStatistics.isEmpty();
			case RecommendationPackage.FEATURE_VECTOR__ARRIVAL_RATE_STATISTICS:
				return arrivalRateStatistics != null && !arrivalRateStatistics.isEmpty();
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_ARRIVAL_CORRELATION:
				return responseArrivalCorrelation != RESPONSE_ARRIVAL_CORRELATION_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__RESPONSE_ARRIVAL_COVARIANCE:
				return responseArrivalCovariance != RESPONSE_ARRIVAL_COVARIANCE_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_RESPONSE_CORRELATION:
				return utilizationResponseCorrelation != UTILIZATION_RESPONSE_CORRELATION_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_RESPONSE_COVARIANCE:
				return utilizationResponseCovariance != UTILIZATION_RESPONSE_COVARIANCE_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_ARRIVAL_CORRELATION:
				return utilizationArrivalCorrelation != UTILIZATION_ARRIVAL_CORRELATION_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__UTILIZATION_ARRIVAL_COVARIANCE:
				return utilizationArrivalCovariance != UTILIZATION_ARRIVAL_COVARIANCE_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_UTILIZATION_CORRELATION:
				return intraUtilizationCorrelation != INTRA_UTILIZATION_CORRELATION_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_UTILIZATION_COVARIANCE:
				return intraUtilizationCovariance != INTRA_UTILIZATION_COVARIANCE_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_RESPONSE_TIME_CORRELATION:
				return intraResponseTimeCorrelation != INTRA_RESPONSE_TIME_CORRELATION_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_RESPONSE_TIME_COVARIANCE:
				return intraResponseTimeCovariance != INTRA_RESPONSE_TIME_COVARIANCE_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_ARRIVAL_RATE_CORRELATION:
				return intraArrivalRateCorrelation != INTRA_ARRIVAL_RATE_CORRELATION_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__INTRA_ARRIVAL_RATE_COVARIANCE:
				return intraArrivalRateCovariance != INTRA_ARRIVAL_RATE_COVARIANCE_EDEFAULT;
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
		result.append(" (numberOfRessources: ");
		result.append(numberOfRessources);
		result.append(", numberOfWorkloadClasses: ");
		result.append(numberOfWorkloadClasses);
		result.append(", varianceInflationFactor: ");
		result.append(varianceInflationFactor);
		result.append(", responseArrivalCorrelation: ");
		result.append(responseArrivalCorrelation);
		result.append(", responseArrivalCovariance: ");
		result.append(responseArrivalCovariance);
		result.append(", utilizationResponseCorrelation: ");
		result.append(utilizationResponseCorrelation);
		result.append(", utilizationResponseCovariance: ");
		result.append(utilizationResponseCovariance);
		result.append(", utilizationArrivalCorrelation: ");
		result.append(utilizationArrivalCorrelation);
		result.append(", utilizationArrivalCovariance: ");
		result.append(utilizationArrivalCovariance);
		result.append(", intraUtilizationCorrelation: ");
		result.append(intraUtilizationCorrelation);
		result.append(", intraUtilizationCovariance: ");
		result.append(intraUtilizationCovariance);
		result.append(", intraResponseTimeCorrelation: ");
		result.append(intraResponseTimeCorrelation);
		result.append(", intraResponseTimeCovariance: ");
		result.append(intraResponseTimeCovariance);
		result.append(", intraArrivalRateCorrelation: ");
		result.append(intraArrivalRateCorrelation);
		result.append(", intraArrivalRateCovariance: ");
		result.append(intraArrivalRateCovariance);
		result.append(')');
		return result.toString();
	}

} //FeatureVectorImpl
