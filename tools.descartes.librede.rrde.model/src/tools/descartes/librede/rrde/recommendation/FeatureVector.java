/**
 */
package tools.descartes.librede.rrde.recommendation;

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
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationFeatures <em>Utilization Features</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getResponseTimeFeatures <em>Response Time Features</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getArrivalTimeFeatures <em>Arrival Time Features</em>}</li>
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
	 * Returns the value of the '<em><b>Utilization Features</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Features</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Features</em>' reference.
	 * @see #setUtilizationFeatures(TraceFeatures)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationFeatures()
	 * @model required="true"
	 * @generated
	 */
	TraceFeatures getUtilizationFeatures();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationFeatures <em>Utilization Features</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization Features</em>' reference.
	 * @see #getUtilizationFeatures()
	 * @generated
	 */
	void setUtilizationFeatures(TraceFeatures value);

	/**
	 * Returns the value of the '<em><b>Response Time Features</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Time Features</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Time Features</em>' reference.
	 * @see #setResponseTimeFeatures(TraceFeatures)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_ResponseTimeFeatures()
	 * @model required="true"
	 * @generated
	 */
	TraceFeatures getResponseTimeFeatures();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getResponseTimeFeatures <em>Response Time Features</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Time Features</em>' reference.
	 * @see #getResponseTimeFeatures()
	 * @generated
	 */
	void setResponseTimeFeatures(TraceFeatures value);

	/**
	 * Returns the value of the '<em><b>Arrival Time Features</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrival Time Features</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrival Time Features</em>' reference.
	 * @see #setArrivalTimeFeatures(TraceFeatures)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_ArrivalTimeFeatures()
	 * @model required="true"
	 * @generated
	 */
	TraceFeatures getArrivalTimeFeatures();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getArrivalTimeFeatures <em>Arrival Time Features</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arrival Time Features</em>' reference.
	 * @see #getArrivalTimeFeatures()
	 * @generated
	 */
	void setArrivalTimeFeatures(TraceFeatures value);

} // FeatureVector
