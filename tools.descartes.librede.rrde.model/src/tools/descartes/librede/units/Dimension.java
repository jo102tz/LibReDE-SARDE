/**
 */
package tools.descartes.librede.units;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tools.descartes.librede.units.Dimension#getBaseUnit <em>Base Unit</em>}</li>
 *   <li>{@link tools.descartes.librede.units.Dimension#getUnits <em>Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see tools.descartes.librede.units.UnitsPackage#getDimension()
 * @model abstract="true"
 * @generated
 */
public interface Dimension extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Unit</em>' reference.
	 * @see #setBaseUnit(Unit)
	 * @see tools.descartes.librede.units.UnitsPackage#getDimension_BaseUnit()
	 * @model required="true"
	 * @generated
	 */
	Unit<?> getBaseUnit();

	/**
	 * Sets the value of the '{@link tools.descartes.librede.units.Dimension#getBaseUnit <em>Base Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Unit</em>' reference.
	 * @see #getBaseUnit()
	 * @generated
	 */
	void setBaseUnit(Unit<?> value);

	/**
	 * Returns the value of the '<em><b>Units</b></em>' containment reference list.
	 * The list contents are of type {@link tools.descartes.librede.units.Unit}&lt;?>.
	 * It is bidirectional and its opposite is '{@link tools.descartes.librede.units.Unit#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units</em>' containment reference list.
	 * @see tools.descartes.librede.units.UnitsPackage#getDimension_Units()
	 * @see tools.descartes.librede.units.Unit#getDimension
	 * @model opposite="dimension" containment="true" required="true"
	 * @generated
	 */
	EList<Unit<?>> getUnits();

} // Dimension
