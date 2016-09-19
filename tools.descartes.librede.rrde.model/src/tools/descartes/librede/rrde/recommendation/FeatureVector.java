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
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterUtilizationCorrelation <em>Inter Utilization Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterUtilizationCovariance <em>Inter Utilization Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterResponseTimeCorrelation <em>Inter Response Time Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterResponseTimeCovariance <em>Inter Response Time Covariance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterArrivalRateCorrelation <em>Inter Arrival Rate Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterArrivalRateCovariance <em>Inter Arrival Rate Covariance</em>}</li>
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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Arrival Correlation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Arrival Correlation</em>' attribute.
	 * @see #setResponseArrivalCorrelation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_ResponseArrivalCorrelation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Arrival Covariance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Arrival Covariance</em>' attribute.
	 * @see #setResponseArrivalCovariance(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_ResponseArrivalCovariance()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Response Correlation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Response Correlation</em>' attribute.
	 * @see #setUtilizationResponseCorrelation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationResponseCorrelation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Response Covariance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Response Covariance</em>' attribute.
	 * @see #setUtilizationResponseCovariance(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationResponseCovariance()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Arrival Correlation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Arrival Correlation</em>' attribute.
	 * @see #setUtilizationArrivalCorrelation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationArrivalCorrelation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Arrival Covariance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Arrival Covariance</em>' attribute.
	 * @see #setUtilizationArrivalCovariance(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationArrivalCovariance()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
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
	 * Returns the value of the '<em><b>Inter Utilization Correlation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inter Utilization Correlation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inter Utilization Correlation</em>' attribute.
	 * @see #setInterUtilizationCorrelation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_InterUtilizationCorrelation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getInterUtilizationCorrelation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterUtilizationCorrelation <em>Inter Utilization Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inter Utilization Correlation</em>' attribute.
	 * @see #getInterUtilizationCorrelation()
	 * @generated
	 */
	void setInterUtilizationCorrelation(double value);

	/**
	 * Returns the value of the '<em><b>Inter Utilization Covariance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inter Utilization Covariance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inter Utilization Covariance</em>' attribute.
	 * @see #setInterUtilizationCovariance(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_InterUtilizationCovariance()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getInterUtilizationCovariance();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterUtilizationCovariance <em>Inter Utilization Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inter Utilization Covariance</em>' attribute.
	 * @see #getInterUtilizationCovariance()
	 * @generated
	 */
	void setInterUtilizationCovariance(double value);

	/**
	 * Returns the value of the '<em><b>Inter Response Time Correlation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inter Response Time Correlation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inter Response Time Correlation</em>' attribute.
	 * @see #setInterResponseTimeCorrelation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_InterResponseTimeCorrelation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getInterResponseTimeCorrelation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterResponseTimeCorrelation <em>Inter Response Time Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inter Response Time Correlation</em>' attribute.
	 * @see #getInterResponseTimeCorrelation()
	 * @generated
	 */
	void setInterResponseTimeCorrelation(double value);

	/**
	 * Returns the value of the '<em><b>Inter Response Time Covariance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inter Response Time Covariance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inter Response Time Covariance</em>' attribute.
	 * @see #setInterResponseTimeCovariance(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_InterResponseTimeCovariance()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getInterResponseTimeCovariance();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterResponseTimeCovariance <em>Inter Response Time Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inter Response Time Covariance</em>' attribute.
	 * @see #getInterResponseTimeCovariance()
	 * @generated
	 */
	void setInterResponseTimeCovariance(double value);

	/**
	 * Returns the value of the '<em><b>Inter Arrival Rate Correlation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inter Arrival Rate Correlation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inter Arrival Rate Correlation</em>' attribute.
	 * @see #setInterArrivalRateCorrelation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_InterArrivalRateCorrelation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getInterArrivalRateCorrelation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterArrivalRateCorrelation <em>Inter Arrival Rate Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inter Arrival Rate Correlation</em>' attribute.
	 * @see #getInterArrivalRateCorrelation()
	 * @generated
	 */
	void setInterArrivalRateCorrelation(double value);

	/**
	 * Returns the value of the '<em><b>Inter Arrival Rate Covariance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inter Arrival Rate Covariance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inter Arrival Rate Covariance</em>' attribute.
	 * @see #setInterArrivalRateCovariance(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_InterArrivalRateCovariance()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getInterArrivalRateCovariance();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getInterArrivalRateCovariance <em>Inter Arrival Rate Covariance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inter Arrival Rate Covariance</em>' attribute.
	 * @see #getInterArrivalRateCovariance()
	 * @generated
	 */
	void setInterArrivalRateCovariance(double value);

} // FeatureVector
