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
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getInterUtilizationCorrelation <em>Inter Utilization Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getInterUtilizationCovariance <em>Inter Utilization Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getInterResponseTimeCorrelation <em>Inter Response Time Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getInterResponseTimeCovariance <em>Inter Response Time Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getInterArrivalRateCorrelation <em>Inter Arrival Rate Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.FeatureVectorImpl#getInterArrivalRateCovariance <em>Inter Arrival Rate Covariance</em>}</li>
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
	protected static final double RESPONSE_ARRIVAL_CORRELATION_EDEFAULT = 0.0;

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
	protected static final double RESPONSE_ARRIVAL_COVARIANCE_EDEFAULT = 0.0;

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
	protected static final double UTILIZATION_RESPONSE_CORRELATION_EDEFAULT = 0.0;

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
	protected static final double UTILIZATION_RESPONSE_COVARIANCE_EDEFAULT = 0.0;

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
	protected static final double UTILIZATION_ARRIVAL_CORRELATION_EDEFAULT = 0.0;

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
	protected static final double UTILIZATION_ARRIVAL_COVARIANCE_EDEFAULT = 0.0;

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
	 * The default value of the '{@link #getInterUtilizationCorrelation() <em>Inter Utilization Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterUtilizationCorrelation()
	 * @generated
	 * @ordered
	 */
	protected static final double INTER_UTILIZATION_CORRELATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInterUtilizationCorrelation() <em>Inter Utilization Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterUtilizationCorrelation()
	 * @generated
	 * @ordered
	 */
	protected double interUtilizationCorrelation = INTER_UTILIZATION_CORRELATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterUtilizationCovariance() <em>Inter Utilization Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterUtilizationCovariance()
	 * @generated
	 * @ordered
	 */
	protected static final double INTER_UTILIZATION_COVARIANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInterUtilizationCovariance() <em>Inter Utilization Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterUtilizationCovariance()
	 * @generated
	 * @ordered
	 */
	protected double interUtilizationCovariance = INTER_UTILIZATION_COVARIANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterResponseTimeCorrelation() <em>Inter Response Time Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterResponseTimeCorrelation()
	 * @generated
	 * @ordered
	 */
	protected static final double INTER_RESPONSE_TIME_CORRELATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInterResponseTimeCorrelation() <em>Inter Response Time Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterResponseTimeCorrelation()
	 * @generated
	 * @ordered
	 */
	protected double interResponseTimeCorrelation = INTER_RESPONSE_TIME_CORRELATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterResponseTimeCovariance() <em>Inter Response Time Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterResponseTimeCovariance()
	 * @generated
	 * @ordered
	 */
	protected static final double INTER_RESPONSE_TIME_COVARIANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInterResponseTimeCovariance() <em>Inter Response Time Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterResponseTimeCovariance()
	 * @generated
	 * @ordered
	 */
	protected double interResponseTimeCovariance = INTER_RESPONSE_TIME_COVARIANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterArrivalRateCorrelation() <em>Inter Arrival Rate Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterArrivalRateCorrelation()
	 * @generated
	 * @ordered
	 */
	protected static final double INTER_ARRIVAL_RATE_CORRELATION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInterArrivalRateCorrelation() <em>Inter Arrival Rate Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterArrivalRateCorrelation()
	 * @generated
	 * @ordered
	 */
	protected double interArrivalRateCorrelation = INTER_ARRIVAL_RATE_CORRELATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInterArrivalRateCovariance() <em>Inter Arrival Rate Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterArrivalRateCovariance()
	 * @generated
	 * @ordered
	 */
	protected static final double INTER_ARRIVAL_RATE_COVARIANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInterArrivalRateCovariance() <em>Inter Arrival Rate Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterArrivalRateCovariance()
	 * @generated
	 * @ordered
	 */
	protected double interArrivalRateCovariance = INTER_ARRIVAL_RATE_COVARIANCE_EDEFAULT;

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
	public double getInterUtilizationCorrelation() {
		return interUtilizationCorrelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterUtilizationCorrelation(double newInterUtilizationCorrelation) {
		double oldInterUtilizationCorrelation = interUtilizationCorrelation;
		interUtilizationCorrelation = newInterUtilizationCorrelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__INTER_UTILIZATION_CORRELATION, oldInterUtilizationCorrelation, interUtilizationCorrelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInterUtilizationCovariance() {
		return interUtilizationCovariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterUtilizationCovariance(double newInterUtilizationCovariance) {
		double oldInterUtilizationCovariance = interUtilizationCovariance;
		interUtilizationCovariance = newInterUtilizationCovariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__INTER_UTILIZATION_COVARIANCE, oldInterUtilizationCovariance, interUtilizationCovariance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInterResponseTimeCorrelation() {
		return interResponseTimeCorrelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterResponseTimeCorrelation(double newInterResponseTimeCorrelation) {
		double oldInterResponseTimeCorrelation = interResponseTimeCorrelation;
		interResponseTimeCorrelation = newInterResponseTimeCorrelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__INTER_RESPONSE_TIME_CORRELATION, oldInterResponseTimeCorrelation, interResponseTimeCorrelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInterResponseTimeCovariance() {
		return interResponseTimeCovariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterResponseTimeCovariance(double newInterResponseTimeCovariance) {
		double oldInterResponseTimeCovariance = interResponseTimeCovariance;
		interResponseTimeCovariance = newInterResponseTimeCovariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__INTER_RESPONSE_TIME_COVARIANCE, oldInterResponseTimeCovariance, interResponseTimeCovariance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInterArrivalRateCorrelation() {
		return interArrivalRateCorrelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterArrivalRateCorrelation(double newInterArrivalRateCorrelation) {
		double oldInterArrivalRateCorrelation = interArrivalRateCorrelation;
		interArrivalRateCorrelation = newInterArrivalRateCorrelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__INTER_ARRIVAL_RATE_CORRELATION, oldInterArrivalRateCorrelation, interArrivalRateCorrelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInterArrivalRateCovariance() {
		return interArrivalRateCovariance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterArrivalRateCovariance(double newInterArrivalRateCovariance) {
		double oldInterArrivalRateCovariance = interArrivalRateCovariance;
		interArrivalRateCovariance = newInterArrivalRateCovariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.FEATURE_VECTOR__INTER_ARRIVAL_RATE_COVARIANCE, oldInterArrivalRateCovariance, interArrivalRateCovariance));
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
			case RecommendationPackage.FEATURE_VECTOR__INTER_UTILIZATION_CORRELATION:
				return getInterUtilizationCorrelation();
			case RecommendationPackage.FEATURE_VECTOR__INTER_UTILIZATION_COVARIANCE:
				return getInterUtilizationCovariance();
			case RecommendationPackage.FEATURE_VECTOR__INTER_RESPONSE_TIME_CORRELATION:
				return getInterResponseTimeCorrelation();
			case RecommendationPackage.FEATURE_VECTOR__INTER_RESPONSE_TIME_COVARIANCE:
				return getInterResponseTimeCovariance();
			case RecommendationPackage.FEATURE_VECTOR__INTER_ARRIVAL_RATE_CORRELATION:
				return getInterArrivalRateCorrelation();
			case RecommendationPackage.FEATURE_VECTOR__INTER_ARRIVAL_RATE_COVARIANCE:
				return getInterArrivalRateCovariance();
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
			case RecommendationPackage.FEATURE_VECTOR__INTER_UTILIZATION_CORRELATION:
				setInterUtilizationCorrelation((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTER_UTILIZATION_COVARIANCE:
				setInterUtilizationCovariance((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTER_RESPONSE_TIME_CORRELATION:
				setInterResponseTimeCorrelation((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTER_RESPONSE_TIME_COVARIANCE:
				setInterResponseTimeCovariance((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTER_ARRIVAL_RATE_CORRELATION:
				setInterArrivalRateCorrelation((Double)newValue);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTER_ARRIVAL_RATE_COVARIANCE:
				setInterArrivalRateCovariance((Double)newValue);
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
			case RecommendationPackage.FEATURE_VECTOR__INTER_UTILIZATION_CORRELATION:
				setInterUtilizationCorrelation(INTER_UTILIZATION_CORRELATION_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTER_UTILIZATION_COVARIANCE:
				setInterUtilizationCovariance(INTER_UTILIZATION_COVARIANCE_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTER_RESPONSE_TIME_CORRELATION:
				setInterResponseTimeCorrelation(INTER_RESPONSE_TIME_CORRELATION_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTER_RESPONSE_TIME_COVARIANCE:
				setInterResponseTimeCovariance(INTER_RESPONSE_TIME_COVARIANCE_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTER_ARRIVAL_RATE_CORRELATION:
				setInterArrivalRateCorrelation(INTER_ARRIVAL_RATE_CORRELATION_EDEFAULT);
				return;
			case RecommendationPackage.FEATURE_VECTOR__INTER_ARRIVAL_RATE_COVARIANCE:
				setInterArrivalRateCovariance(INTER_ARRIVAL_RATE_COVARIANCE_EDEFAULT);
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
			case RecommendationPackage.FEATURE_VECTOR__INTER_UTILIZATION_CORRELATION:
				return interUtilizationCorrelation != INTER_UTILIZATION_CORRELATION_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__INTER_UTILIZATION_COVARIANCE:
				return interUtilizationCovariance != INTER_UTILIZATION_COVARIANCE_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__INTER_RESPONSE_TIME_CORRELATION:
				return interResponseTimeCorrelation != INTER_RESPONSE_TIME_CORRELATION_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__INTER_RESPONSE_TIME_COVARIANCE:
				return interResponseTimeCovariance != INTER_RESPONSE_TIME_COVARIANCE_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__INTER_ARRIVAL_RATE_CORRELATION:
				return interArrivalRateCorrelation != INTER_ARRIVAL_RATE_CORRELATION_EDEFAULT;
			case RecommendationPackage.FEATURE_VECTOR__INTER_ARRIVAL_RATE_COVARIANCE:
				return interArrivalRateCovariance != INTER_ARRIVAL_RATE_COVARIANCE_EDEFAULT;
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
		result.append(", interUtilizationCorrelation: ");
		result.append(interUtilizationCorrelation);
		result.append(", interUtilizationCovariance: ");
		result.append(interUtilizationCovariance);
		result.append(", interResponseTimeCorrelation: ");
		result.append(interResponseTimeCorrelation);
		result.append(", interResponseTimeCovariance: ");
		result.append(interResponseTimeCovariance);
		result.append(", interArrivalRateCorrelation: ");
		result.append(interArrivalRateCorrelation);
		result.append(", interArrivalRateCovariance: ");
		result.append(interArrivalRateCovariance);
		result.append(')');
		return result.toString();
	}

} //FeatureVectorImpl
