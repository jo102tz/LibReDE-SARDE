/**
 */
package tools.descartes.librede.rrde.recommendation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tools.descartes.librede.metrics.Aggregation;
import tools.descartes.librede.metrics.Metric;

import tools.descartes.librede.rrde.recommendation.RecommendationPackage;
import tools.descartes.librede.rrde.recommendation.StatisticalFeatures;
import tools.descartes.librede.rrde.recommendation.TraceFeatures;

import tools.descartes.librede.units.Dimension;
import tools.descartes.librede.units.Quantity;
import tools.descartes.librede.units.Time;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Features</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.TraceFeaturesImpl#getStatisticalFeatures <em>Statistical Features</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.TraceFeaturesImpl#getNumberOfSamples <em>Number Of Samples</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.TraceFeaturesImpl#getAggregationType <em>Aggregation Type</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.TraceFeaturesImpl#getAggregationInterval <em>Aggregation Interval</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.TraceFeaturesImpl#getMetric <em>Metric</em>}</li>
 *   <li>{@link tools.descartes.librede.rrde.recommendation.impl.TraceFeaturesImpl#isOriginalInput <em>Original Input</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceFeaturesImpl extends MinimalEObjectImpl.Container implements TraceFeatures {
	/**
	 * The cached value of the '{@link #getStatisticalFeatures() <em>Statistical Features</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatisticalFeatures()
	 * @generated
	 * @ordered
	 */
	protected StatisticalFeatures statisticalFeatures;

	/**
	 * The default value of the '{@link #getNumberOfSamples() <em>Number Of Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfSamples()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_SAMPLES_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getNumberOfSamples() <em>Number Of Samples</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfSamples()
	 * @generated
	 * @ordered
	 */
	protected int numberOfSamples = NUMBER_OF_SAMPLES_EDEFAULT;

	/**
	 * The default value of the '{@link #getAggregationType() <em>Aggregation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregationType()
	 * @generated
	 * @ordered
	 */
	protected static final Aggregation AGGREGATION_TYPE_EDEFAULT = Aggregation.NONE;

	/**
	 * The cached value of the '{@link #getAggregationType() <em>Aggregation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregationType()
	 * @generated
	 * @ordered
	 */
	protected Aggregation aggregationType = AGGREGATION_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAggregationInterval() <em>Aggregation Interval</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregationInterval()
	 * @generated
	 * @ordered
	 */
	protected Quantity<Time> aggregationInterval;

	/**
	 * The cached value of the '{@link #getMetric() <em>Metric</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetric()
	 * @generated
	 * @ordered
	 */
	protected Metric<? extends Dimension> metric;

	/**
	 * The default value of the '{@link #isOriginalInput() <em>Original Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOriginalInput()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ORIGINAL_INPUT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isOriginalInput() <em>Original Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOriginalInput()
	 * @generated
	 * @ordered
	 */
	protected boolean originalInput = ORIGINAL_INPUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceFeaturesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommendationPackage.Literals.TRACE_FEATURES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalFeatures getStatisticalFeatures() {
		if (statisticalFeatures != null && statisticalFeatures.eIsProxy()) {
			InternalEObject oldStatisticalFeatures = (InternalEObject)statisticalFeatures;
			statisticalFeatures = (StatisticalFeatures)eResolveProxy(oldStatisticalFeatures);
			if (statisticalFeatures != oldStatisticalFeatures) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.TRACE_FEATURES__STATISTICAL_FEATURES, oldStatisticalFeatures, statisticalFeatures));
			}
		}
		return statisticalFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticalFeatures basicGetStatisticalFeatures() {
		return statisticalFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatisticalFeatures(StatisticalFeatures newStatisticalFeatures) {
		StatisticalFeatures oldStatisticalFeatures = statisticalFeatures;
		statisticalFeatures = newStatisticalFeatures;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.TRACE_FEATURES__STATISTICAL_FEATURES, oldStatisticalFeatures, statisticalFeatures));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfSamples() {
		return numberOfSamples;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfSamples(int newNumberOfSamples) {
		int oldNumberOfSamples = numberOfSamples;
		numberOfSamples = newNumberOfSamples;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.TRACE_FEATURES__NUMBER_OF_SAMPLES, oldNumberOfSamples, numberOfSamples));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aggregation getAggregationType() {
		return aggregationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregationType(Aggregation newAggregationType) {
		Aggregation oldAggregationType = aggregationType;
		aggregationType = newAggregationType == null ? AGGREGATION_TYPE_EDEFAULT : newAggregationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.TRACE_FEATURES__AGGREGATION_TYPE, oldAggregationType, aggregationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quantity<Time> getAggregationInterval() {
		return aggregationInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAggregationInterval(Quantity<Time> newAggregationInterval, NotificationChain msgs) {
		Quantity<Time> oldAggregationInterval = aggregationInterval;
		aggregationInterval = newAggregationInterval;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RecommendationPackage.TRACE_FEATURES__AGGREGATION_INTERVAL, oldAggregationInterval, newAggregationInterval);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregationInterval(Quantity<Time> newAggregationInterval) {
		if (newAggregationInterval != aggregationInterval) {
			NotificationChain msgs = null;
			if (aggregationInterval != null)
				msgs = ((InternalEObject)aggregationInterval).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RecommendationPackage.TRACE_FEATURES__AGGREGATION_INTERVAL, null, msgs);
			if (newAggregationInterval != null)
				msgs = ((InternalEObject)newAggregationInterval).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RecommendationPackage.TRACE_FEATURES__AGGREGATION_INTERVAL, null, msgs);
			msgs = basicSetAggregationInterval(newAggregationInterval, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.TRACE_FEATURES__AGGREGATION_INTERVAL, newAggregationInterval, newAggregationInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Metric<? extends Dimension> getMetric() {
		if (metric != null && metric.eIsProxy()) {
			InternalEObject oldMetric = (InternalEObject)metric;
			metric = (Metric<? extends Dimension>)eResolveProxy(oldMetric);
			if (metric != oldMetric) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RecommendationPackage.TRACE_FEATURES__METRIC, oldMetric, metric));
			}
		}
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metric<? extends Dimension> basicGetMetric() {
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetric(Metric<? extends Dimension> newMetric) {
		Metric<? extends Dimension> oldMetric = metric;
		metric = newMetric;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.TRACE_FEATURES__METRIC, oldMetric, metric));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOriginalInput() {
		return originalInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalInput(boolean newOriginalInput) {
		boolean oldOriginalInput = originalInput;
		originalInput = newOriginalInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommendationPackage.TRACE_FEATURES__ORIGINAL_INPUT, oldOriginalInput, originalInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RecommendationPackage.TRACE_FEATURES__AGGREGATION_INTERVAL:
				return basicSetAggregationInterval(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RecommendationPackage.TRACE_FEATURES__STATISTICAL_FEATURES:
				if (resolve) return getStatisticalFeatures();
				return basicGetStatisticalFeatures();
			case RecommendationPackage.TRACE_FEATURES__NUMBER_OF_SAMPLES:
				return getNumberOfSamples();
			case RecommendationPackage.TRACE_FEATURES__AGGREGATION_TYPE:
				return getAggregationType();
			case RecommendationPackage.TRACE_FEATURES__AGGREGATION_INTERVAL:
				return getAggregationInterval();
			case RecommendationPackage.TRACE_FEATURES__METRIC:
				if (resolve) return getMetric();
				return basicGetMetric();
			case RecommendationPackage.TRACE_FEATURES__ORIGINAL_INPUT:
				return isOriginalInput();
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
			case RecommendationPackage.TRACE_FEATURES__STATISTICAL_FEATURES:
				setStatisticalFeatures((StatisticalFeatures)newValue);
				return;
			case RecommendationPackage.TRACE_FEATURES__NUMBER_OF_SAMPLES:
				setNumberOfSamples((Integer)newValue);
				return;
			case RecommendationPackage.TRACE_FEATURES__AGGREGATION_TYPE:
				setAggregationType((Aggregation)newValue);
				return;
			case RecommendationPackage.TRACE_FEATURES__AGGREGATION_INTERVAL:
				setAggregationInterval((Quantity<Time>)newValue);
				return;
			case RecommendationPackage.TRACE_FEATURES__METRIC:
				setMetric((Metric<? extends Dimension>)newValue);
				return;
			case RecommendationPackage.TRACE_FEATURES__ORIGINAL_INPUT:
				setOriginalInput((Boolean)newValue);
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
			case RecommendationPackage.TRACE_FEATURES__STATISTICAL_FEATURES:
				setStatisticalFeatures((StatisticalFeatures)null);
				return;
			case RecommendationPackage.TRACE_FEATURES__NUMBER_OF_SAMPLES:
				setNumberOfSamples(NUMBER_OF_SAMPLES_EDEFAULT);
				return;
			case RecommendationPackage.TRACE_FEATURES__AGGREGATION_TYPE:
				setAggregationType(AGGREGATION_TYPE_EDEFAULT);
				return;
			case RecommendationPackage.TRACE_FEATURES__AGGREGATION_INTERVAL:
				setAggregationInterval((Quantity<Time>)null);
				return;
			case RecommendationPackage.TRACE_FEATURES__METRIC:
				setMetric((Metric<? extends Dimension>)null);
				return;
			case RecommendationPackage.TRACE_FEATURES__ORIGINAL_INPUT:
				setOriginalInput(ORIGINAL_INPUT_EDEFAULT);
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
			case RecommendationPackage.TRACE_FEATURES__STATISTICAL_FEATURES:
				return statisticalFeatures != null;
			case RecommendationPackage.TRACE_FEATURES__NUMBER_OF_SAMPLES:
				return numberOfSamples != NUMBER_OF_SAMPLES_EDEFAULT;
			case RecommendationPackage.TRACE_FEATURES__AGGREGATION_TYPE:
				return aggregationType != AGGREGATION_TYPE_EDEFAULT;
			case RecommendationPackage.TRACE_FEATURES__AGGREGATION_INTERVAL:
				return aggregationInterval != null;
			case RecommendationPackage.TRACE_FEATURES__METRIC:
				return metric != null;
			case RecommendationPackage.TRACE_FEATURES__ORIGINAL_INPUT:
				return originalInput != ORIGINAL_INPUT_EDEFAULT;
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
		result.append(" (numberOfSamples: ");
		result.append(numberOfSamples);
		result.append(", aggregationType: ");
		result.append(aggregationType);
		result.append(", originalInput: ");
		result.append(originalInput);
		result.append(')');
		return result.toString();
	}

} //TraceFeaturesImpl
