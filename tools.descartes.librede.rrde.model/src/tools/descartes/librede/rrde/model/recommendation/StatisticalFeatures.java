/**
 */
package tools.descartes.librede.rrde.model.recommendation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statistical Features</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getN <em>N</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getArithmeticMean <em>Arithmetic Mean</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getGeometricMean <em>Geometric Mean</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getStandardDeviation <em>Standard Deviation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getQuadraticMean <em>Quadratic Mean</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getKurtosis <em>Kurtosis</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getSkewness <em>Skewness</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getTenthpercentile <em>Tenthpercentile</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getNinetiethpercentile <em>Ninetiethpercentile</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getAutocorrelation <em>Autocorrelation</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getIsNormalDistributed <em>Is Normal Distributed</em>}</li>
 * </ul>
 *
 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures()
 * @model
 * @generated
 */
public interface StatisticalFeatures extends EObject {
	/**
	 * Returns the value of the '<em><b>N</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>N</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>N</em>' attribute.
	 * @see #setN(double)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures_N()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getN();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getN <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>N</em>' attribute.
	 * @see #getN()
	 * @generated
	 */
	void setN(double value);

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
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures_ArithmeticMean()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getArithmeticMean();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getArithmeticMean <em>Arithmetic Mean</em>}' attribute.
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
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures_GeometricMean()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getGeometricMean();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getGeometricMean <em>Geometric Mean</em>}' attribute.
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
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures_StandardDeviation()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getStandardDeviation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getStandardDeviation <em>Standard Deviation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Standard Deviation</em>' attribute.
	 * @see #getStandardDeviation()
	 * @generated
	 */
	void setStandardDeviation(double value);

	/**
	 * Returns the value of the '<em><b>Quadratic Mean</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quadratic Mean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quadratic Mean</em>' attribute.
	 * @see #setQuadraticMean(double)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures_QuadraticMean()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getQuadraticMean();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getQuadraticMean <em>Quadratic Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quadratic Mean</em>' attribute.
	 * @see #getQuadraticMean()
	 * @generated
	 */
	void setQuadraticMean(double value);

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
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures_Minimum()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getMinimum();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getMinimum <em>Minimum</em>}' attribute.
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
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures_Maximum()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getMaximum();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(double value);

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
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures_Kurtosis()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getKurtosis();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getKurtosis <em>Kurtosis</em>}' attribute.
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
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures_Skewness()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getSkewness();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getSkewness <em>Skewness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skewness</em>' attribute.
	 * @see #getSkewness()
	 * @generated
	 */
	void setSkewness(double value);

	/**
	 * Returns the value of the '<em><b>Tenthpercentile</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tenthpercentile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tenthpercentile</em>' attribute.
	 * @see #setTenthpercentile(double)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures_Tenthpercentile()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getTenthpercentile();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getTenthpercentile <em>Tenthpercentile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tenthpercentile</em>' attribute.
	 * @see #getTenthpercentile()
	 * @generated
	 */
	void setTenthpercentile(double value);

	/**
	 * Returns the value of the '<em><b>Ninetiethpercentile</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ninetiethpercentile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ninetiethpercentile</em>' attribute.
	 * @see #setNinetiethpercentile(double)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures_Ninetiethpercentile()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getNinetiethpercentile();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getNinetiethpercentile <em>Ninetiethpercentile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ninetiethpercentile</em>' attribute.
	 * @see #getNinetiethpercentile()
	 * @generated
	 */
	void setNinetiethpercentile(double value);

	/**
	 * Returns the value of the '<em><b>Autocorrelation</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Autocorrelation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Autocorrelation</em>' attribute.
	 * @see #setAutocorrelation(double)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures_Autocorrelation()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getAutocorrelation();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getAutocorrelation <em>Autocorrelation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Autocorrelation</em>' attribute.
	 * @see #getAutocorrelation()
	 * @generated
	 */
	void setAutocorrelation(double value);

	/**
	 * Returns the value of the '<em><b>Is Normal Distributed</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Normal Distributed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Normal Distributed</em>' attribute.
	 * @see #setIsNormalDistributed(double)
	 * @see tools.descartes.librede.rrde.model.recommendation.RecommendationPackage#getStatisticalFeatures_IsNormalDistributed()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getIsNormalDistributed();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.model.recommendation.StatisticalFeatures#getIsNormalDistributed <em>Is Normal Distributed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Normal Distributed</em>' attribute.
	 * @see #getIsNormalDistributed()
	 * @generated
	 */
	void setIsNormalDistributed(double value);

} // StatisticalFeatures
