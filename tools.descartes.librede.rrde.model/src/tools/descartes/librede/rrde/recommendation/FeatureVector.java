/**
 */
package tools.descartes.librede.rrde.recommendation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Vector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getNumberOfRessources <em>Number Of Ressources</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getNumberOfWorkloadClasses <em>Number Of Workload Classes</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getVarianceInflationFactor <em>Variance Inflation Factor</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationStatistics <em>Utilization Statistics</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getResponseTimeStatistics <em>Response Time Statistics</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getArrivalRateStatistics <em>Arrival Rate Statistics</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getResponseArrivalCorrelation <em>Response Arrival Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getResponseArrivalCovariance <em>Response Arrival Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationResponseCorrelation <em>Utilization Response Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationResponseCovariance <em>Utilization Response Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationArrivalCorrelation <em>Utilization Arrival Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationArrivalCovariance <em>Utilization Arrival Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getIntraUtilizationCorrelation <em>Intra Utilization Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getIntraUtilizationCovariance <em>Intra Utilization Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getIntraResponseTimeCorrelation <em>Intra Response Time Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getIntraResponseTimeCovariance <em>Intra Response Time Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getIntraArrivalRateCorrelation <em>Intra Arrival Rate Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getIntraArrivalRateCovariance <em>Intra Arrival Rate Covariance</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector()
 * @model
 * @generated
 */
public interface FeatureVector extends EObject {
	/**
	 * Returns the value of the '<em><b>Number Of Ressources</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Ressources</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Ressources</em>' attribute.
	 * @see #setNumberOfRessources(int)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_NumberOfRessources()
	 * @model default="1" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNumberOfRessources();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getNumberOfRessources <em>Number Of Ressources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Ressources</em>' attribute.
	 * @see #getNumberOfRessources()
	 * @generated
	 */
	void setNumberOfRessources(int value);

	/**
	 * Returns the value of the '<em><b>Number Of Workload Classes</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Workload Classes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Workload Classes</em>' attribute.
	 * @see #setNumberOfWorkloadClasses(int)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_NumberOfWorkloadClasses()
	 * @model default="1" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNumberOfWorkloadClasses();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getNumberOfWorkloadClasses <em>Number Of Workload Classes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Workload Classes</em>' attribute.
	 * @see #getNumberOfWorkloadClasses()
	 * @generated
	 */
	void setNumberOfWorkloadClasses(int value);

	/**
	 * Returns the value of the '<em><b>Variance Inflation Factor</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variance Inflation Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variance Inflation Factor</em>' attribute.
	 * @see #setVarianceInflationFactor(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_VarianceInflationFactor()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getVarianceInflationFactor();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getVarianceInflationFactor <em>Variance Inflation Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variance Inflation Factor</em>' attribute.
	 * @see #getVarianceInflationFactor()
	 * @generated
	 */
	void setVarianceInflationFactor(double value);

	/**
	 * Returns the value of the '<em><b>Utilization Statistics</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Statistics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Statistics</em>' reference list.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationStatistics()
	 * @model required="true"
	 * @generated
	 */
	EList<StatisticalFeatures> getUtilizationStatistics();

	/**
	 * Returns the value of the '<em><b>Response Time Statistics</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Time Statistics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Time Statistics</em>' reference list.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_ResponseTimeStatistics()
	 * @model required="true"
	 * @generated
	 */
	EList<StatisticalFeatures> getResponseTimeStatistics();

	/**
	 * Returns the value of the '<em><b>Arrival Rate Statistics</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrival Rate Statistics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrival Rate Statistics</em>' reference list.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_ArrivalRateStatistics()
	 * @model required="true"
	 * @generated
	 */
	EList<StatisticalFeatures> getArrivalRateStatistics();

	/**
	 * Returns the value of the '<em><b>Response Arrival Correlation</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Arrival Correlation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Arrival Correlation</em>' attribute.
	 * @see #setResponseArrivalCorrelation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_ResponseArrivalCorrelation()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getResponseArrivalCorrelation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getResponseArrivalCorrelation <em>Response Arrival Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Arrival Correlation</em>' attribute.
	 * @see #getResponseArrivalCorrelation()
	 * @generated
	 */
	void setResponseArrivalCorrelation(double value);

	/**
	 * Returns the value of the '<em><b>Response Arrival Covariance</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Arrival Covariance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Arrival Covariance</em>' attribute.
	 * @see #setResponseArrivalCovariance(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_ResponseArrivalCovariance()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getResponseArrivalCovariance();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getResponseArrivalCovariance <em>Response Arrival Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Arrival Covariance</em>' attribute.
	 * @see #getResponseArrivalCovariance()
	 * @generated
	 */
	void setResponseArrivalCovariance(double value);

	/**
	 * Returns the value of the '<em><b>Utilization Response Correlation</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Response Correlation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Response Correlation</em>' attribute.
	 * @see #setUtilizationResponseCorrelation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationResponseCorrelation()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getUtilizationResponseCorrelation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationResponseCorrelation <em>Utilization Response Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization Response Correlation</em>' attribute.
	 * @see #getUtilizationResponseCorrelation()
	 * @generated
	 */
	void setUtilizationResponseCorrelation(double value);

	/**
	 * Returns the value of the '<em><b>Utilization Response Covariance</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Response Covariance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Response Covariance</em>' attribute.
	 * @see #setUtilizationResponseCovariance(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationResponseCovariance()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getUtilizationResponseCovariance();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationResponseCovariance <em>Utilization Response Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization Response Covariance</em>' attribute.
	 * @see #getUtilizationResponseCovariance()
	 * @generated
	 */
	void setUtilizationResponseCovariance(double value);

	/**
	 * Returns the value of the '<em><b>Utilization Arrival Correlation</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Arrival Correlation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Arrival Correlation</em>' attribute.
	 * @see #setUtilizationArrivalCorrelation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationArrivalCorrelation()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getUtilizationArrivalCorrelation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationArrivalCorrelation <em>Utilization Arrival Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization Arrival Correlation</em>' attribute.
	 * @see #getUtilizationArrivalCorrelation()
	 * @generated
	 */
	void setUtilizationArrivalCorrelation(double value);

	/**
	 * Returns the value of the '<em><b>Utilization Arrival Covariance</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Arrival Covariance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Arrival Covariance</em>' attribute.
	 * @see #setUtilizationArrivalCovariance(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationArrivalCovariance()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getUtilizationArrivalCovariance();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationArrivalCovariance <em>Utilization Arrival Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization Arrival Covariance</em>' attribute.
	 * @see #getUtilizationArrivalCovariance()
	 * @generated
	 */
	void setUtilizationArrivalCovariance(double value);

	/**
	 * Returns the value of the '<em><b>Intra Utilization Correlation</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intra Utilization Correlation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intra Utilization Correlation</em>' attribute.
	 * @see #setIntraUtilizationCorrelation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_IntraUtilizationCorrelation()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getIntraUtilizationCorrelation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getIntraUtilizationCorrelation <em>Intra Utilization Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intra Utilization Correlation</em>' attribute.
	 * @see #getIntraUtilizationCorrelation()
	 * @generated
	 */
	void setIntraUtilizationCorrelation(double value);

	/**
	 * Returns the value of the '<em><b>Intra Utilization Covariance</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intra Utilization Covariance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intra Utilization Covariance</em>' attribute.
	 * @see #setIntraUtilizationCovariance(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_IntraUtilizationCovariance()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getIntraUtilizationCovariance();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getIntraUtilizationCovariance <em>Intra Utilization Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intra Utilization Covariance</em>' attribute.
	 * @see #getIntraUtilizationCovariance()
	 * @generated
	 */
	void setIntraUtilizationCovariance(double value);

	/**
	 * Returns the value of the '<em><b>Intra Response Time Correlation</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intra Response Time Correlation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intra Response Time Correlation</em>' attribute.
	 * @see #setIntraResponseTimeCorrelation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_IntraResponseTimeCorrelation()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getIntraResponseTimeCorrelation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getIntraResponseTimeCorrelation <em>Intra Response Time Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intra Response Time Correlation</em>' attribute.
	 * @see #getIntraResponseTimeCorrelation()
	 * @generated
	 */
	void setIntraResponseTimeCorrelation(double value);

	/**
	 * Returns the value of the '<em><b>Intra Response Time Covariance</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intra Response Time Covariance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intra Response Time Covariance</em>' attribute.
	 * @see #setIntraResponseTimeCovariance(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_IntraResponseTimeCovariance()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getIntraResponseTimeCovariance();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getIntraResponseTimeCovariance <em>Intra Response Time Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intra Response Time Covariance</em>' attribute.
	 * @see #getIntraResponseTimeCovariance()
	 * @generated
	 */
	void setIntraResponseTimeCovariance(double value);

	/**
	 * Returns the value of the '<em><b>Intra Arrival Rate Correlation</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intra Arrival Rate Correlation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intra Arrival Rate Correlation</em>' attribute.
	 * @see #setIntraArrivalRateCorrelation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_IntraArrivalRateCorrelation()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getIntraArrivalRateCorrelation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getIntraArrivalRateCorrelation <em>Intra Arrival Rate Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intra Arrival Rate Correlation</em>' attribute.
	 * @see #getIntraArrivalRateCorrelation()
	 * @generated
	 */
	void setIntraArrivalRateCorrelation(double value);

	/**
	 * Returns the value of the '<em><b>Intra Arrival Rate Covariance</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intra Arrival Rate Covariance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intra Arrival Rate Covariance</em>' attribute.
	 * @see #setIntraArrivalRateCovariance(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_IntraArrivalRateCovariance()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getIntraArrivalRateCovariance();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getIntraArrivalRateCovariance <em>Intra Arrival Rate Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intra Arrival Rate Covariance</em>' attribute.
	 * @see #getIntraArrivalRateCovariance()
	 * @generated
	 */
	void setIntraArrivalRateCovariance(double value);

} // FeatureVector
