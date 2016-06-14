/**
 */
package optimization;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link optimization.Settings#getTimeOut <em>Time Out</em>}</li>
 * </ul>
 * </p>
 *
 * @see optimization.OptimizationPackage#getSettings()
 * @model abstract="true"
 * @generated
 */
public interface Settings extends EObject {
	/**
	 * Returns the value of the '<em><b>Time Out</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Out</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Out</em>' attribute.
	 * @see #setTimeOut(long)
	 * @see optimization.OptimizationPackage#getSettings_TimeOut()
	 * @model default="-1"
	 * @generated
	 */
	long getTimeOut();

	/**
	 * Sets the value of the '{@link optimization.Settings#getTimeOut <em>Time Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Out</em>' attribute.
	 * @see #getTimeOut()
	 * @generated
	 */
	void setTimeOut(long value);

} // Settings
