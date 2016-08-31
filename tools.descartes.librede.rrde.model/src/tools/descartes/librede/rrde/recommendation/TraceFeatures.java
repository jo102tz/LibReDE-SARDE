/**
 */
package tools.descartes.librede.rrde.recommendation;

import org.eclipse.emf.ecore.EObject;

import tools.descartes.librede.metrics.Aggregation;
import tools.descartes.librede.metrics.Metric;

import tools.descartes.librede.units.Dimension;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Features</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getStatisticalFeatures <em>Statistical Features</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getNumberOfSamples <em>Number Of Samples</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getAggregationType <em>Aggregation Type</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getAggregationInterval <em>Aggregation Interval</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getMetric <em>Metric</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#isOriginalInput <em>Original Input</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getTraceFeatures()
 * @model
 * @generated
 */
public interface TraceFeatures extends EObject {
	/**
	 * Returns the value of the '<em><b>Statistical Features</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statistical Features</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statistical Features</em>' reference.
	 * @see #setStatisticalFeatures(StatisticalFeatures)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getTraceFeatures_StatisticalFeatures()
	 * @model
	 * @generated
	 */
	StatisticalFeatures getStatisticalFeatures();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getStatisticalFeatures <em>Statistical Features</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statistical Features</em>' reference.
	 * @see #getStatisticalFeatures()
	 * @generated
	 */
	void setStatisticalFeatures(StatisticalFeatures value);

	/**
	 * Returns the value of the '<em><b>Number Of Samples</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Samples</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Samples</em>' attribute.
	 * @see #setNumberOfSamples(int)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getTraceFeatures_NumberOfSamples()
	 * @model default="-1" dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNumberOfSamples();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getNumberOfSamples <em>Number Of Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Samples</em>' attribute.
	 * @see #getNumberOfSamples()
	 * @generated
	 */
	void setNumberOfSamples(int value);

	/**
	 * Returns the value of the '<em><b>Aggregation Type</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
	 * The literals are from the enumeration {@link tools.descartes.librede.metrics.Aggregation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation Type</em>' attribute.
	 * @see tools.descartes.librede.metrics.Aggregation
	 * @see #setAggregationType(Aggregation)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getTraceFeatures_AggregationType()
	 * @model default="NONE" required="true"
	 * @generated
	 */
	Aggregation getAggregationType();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getAggregationType <em>Aggregation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation Type</em>' attribute.
	 * @see tools.descartes.librede.metrics.Aggregation
	 * @see #getAggregationType()
	 * @generated
	 */
	void setAggregationType(Aggregation value);

	/**
	 * Returns the value of the '<em><b>Aggregation Interval</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation Interval</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation Interval</em>' containment reference.
	 * @see #setAggregationInterval(Quantity)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getTraceFeatures_AggregationInterval()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Quantity<Time> getAggregationInterval();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getAggregationInterval <em>Aggregation Interval</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation Interval</em>' containment reference.
	 * @see #getAggregationInterval()
	 * @generated
	 */
	void setAggregationInterval(Quantity<Time> value);

	/**
	 * Returns the value of the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric</em>' reference.
	 * @see #setMetric(Metric)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getTraceFeatures_Metric()
	 * @model required="true"
	 * @generated
	 */
	Metric<? extends Dimension> getMetric();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#getMetric <em>Metric</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric</em>' reference.
	 * @see #getMetric()
	 * @generated
	 */
	void setMetric(Metric<? extends Dimension> value);

	/**
	 * Returns the value of the '<em><b>Original Input</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Input</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Input</em>' attribute.
	 * @see #setOriginalInput(boolean)
	 * @see tools.descartes.librede.rrde.recommendation.RecommendationPackage#getTraceFeatures_OriginalInput()
	 * @model default="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 * @generated
	 */
	boolean isOriginalInput();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.rrde.recommendation.TraceFeatures#isOriginalInput <em>Original Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Input</em>' attribute.
	 * @see #isOriginalInput()
	 * @generated
	 */
	void setOriginalInput(boolean value);

} // TraceFeatures
