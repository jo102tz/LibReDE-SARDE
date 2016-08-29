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
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationMean <em>Utilization Mean</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationVariance <em>Utilization Variance</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getTraces <em>Traces</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getVarianceInflationFactor <em>Variance Inflation Factor</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationMin <em>Utilization Min</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationMax <em>Utilization Max</em>}</li>
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
	 * Returns the value of the '<em><b>Utilization Mean</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Mean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Mean</em>' attribute.
	 * @see #setUtilizationMean(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationMean()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getUtilizationMean();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationMean <em>Utilization Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization Mean</em>' attribute.
	 * @see #getUtilizationMean()
	 * @generated
	 */
	void setUtilizationMean(double value);

	/**
	 * Returns the value of the '<em><b>Utilization Variance</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Variance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Variance</em>' attribute.
	 * @see #setUtilizationVariance(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationVariance()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getUtilizationVariance();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationVariance <em>Utilization Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization Variance</em>' attribute.
	 * @see #getUtilizationVariance()
	 * @generated
	 */
	void setUtilizationVariance(double value);

	/**
	 * Returns the value of the '<em><b>Traces</b></em>' reference list.
	 * The list contents are of type {@link tools.descartes.librede.rrde.recommendation.TraceFeatures}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traces</em>' reference list.
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_Traces()
	 * @model
	 * @generated
	 */
	EList<TraceFeatures> getTraces();

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
	 * Returns the value of the '<em><b>Utilization Min</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Min</em>' attribute.
	 * @see #setUtilizationMin(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationMin()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getUtilizationMin();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationMin <em>Utilization Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization Min</em>' attribute.
	 * @see #getUtilizationMin()
	 * @generated
	 */
	void setUtilizationMin(double value);

	/**
	 * Returns the value of the '<em><b>Utilization Max</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization Max</em>' attribute.
	 * @see #setUtilizationMax(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getFeatureVector_UtilizationMax()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getUtilizationMax();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.FeatureVector#getUtilizationMax <em>Utilization Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization Max</em>' attribute.
	 * @see #getUtilizationMax()
	 * @generated
	 */
	void setUtilizationMax(double value);

} // FeatureVector
