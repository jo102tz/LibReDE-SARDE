/**
 */
package tools.descartes.librede.rrde.recommendation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statistical Features</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getArithmeticMean <em>Arithmetic Mean</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getGeometricMean <em>Geometric Mean</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getStandardDeviation <em>Standard Deviation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getAutoCorrelation <em>Auto Correlation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getKurtosis <em>Kurtosis</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getSkewness <em>Skewness</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getStatisticalFeatures()
 * @model
 * @generated
 */
public interface StatisticalFeatures extends EObject {
	/**
	 * Returns the value of the '<em><b>Arithmetic Mean</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arithmetic Mean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arithmetic Mean</em>' attribute.
	 * @see #setArithmeticMean(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getStatisticalFeatures_ArithmeticMean()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getArithmeticMean();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getArithmeticMean <em>Arithmetic Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arithmetic Mean</em>' attribute.
	 * @see #getArithmeticMean()
	 * @generated
	 */
	void setArithmeticMean(double value);

	/**
	 * Returns the value of the '<em><b>Geometric Mean</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Geometric Mean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Geometric Mean</em>' attribute.
	 * @see #setGeometricMean(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getStatisticalFeatures_GeometricMean()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getGeometricMean();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getGeometricMean <em>Geometric Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Geometric Mean</em>' attribute.
	 * @see #getGeometricMean()
	 * @generated
	 */
	void setGeometricMean(double value);

	/**
	 * Returns the value of the '<em><b>Standard Deviation</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Standard Deviation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Standard Deviation</em>' attribute.
	 * @see #setStandardDeviation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getStatisticalFeatures_StandardDeviation()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getStandardDeviation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getStandardDeviation <em>Standard Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Standard Deviation</em>' attribute.
	 * @see #getStandardDeviation()
	 * @generated
	 */
	void setStandardDeviation(double value);

	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum</em>' attribute.
	 * @see #setMinimum(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getStatisticalFeatures_Minimum()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getMinimum();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getMinimum <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' attribute.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(double value);

	/**
	 * Returns the value of the '<em><b>Maximum</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum</em>' attribute.
	 * @see #setMaximum(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getStatisticalFeatures_Maximum()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getMaximum();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(double value);

	/**
	 * Returns the value of the '<em><b>Auto Correlation</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Correlation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Correlation</em>' attribute.
	 * @see #setAutoCorrelation(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getStatisticalFeatures_AutoCorrelation()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getAutoCorrelation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getAutoCorrelation <em>Auto Correlation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Correlation</em>' attribute.
	 * @see #getAutoCorrelation()
	 * @generated
	 */
	void setAutoCorrelation(double value);

	/**
	 * Returns the value of the '<em><b>Kurtosis</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kurtosis</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kurtosis</em>' attribute.
	 * @see #setKurtosis(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getStatisticalFeatures_Kurtosis()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getKurtosis();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getKurtosis <em>Kurtosis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kurtosis</em>' attribute.
	 * @see #getKurtosis()
	 * @generated
	 */
	void setKurtosis(double value);

	/**
	 * Returns the value of the '<em><b>Skewness</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Skewness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Skewness</em>' attribute.
	 * @see #setSkewness(double)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getStatisticalFeatures_Skewness()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getSkewness();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.StatisticalFeatures#getSkewness <em>Skewness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skewness</em>' attribute.
	 * @see #getSkewness()
	 * @generated
	 */
	void setSkewness(double value);

} // StatisticalFeatures