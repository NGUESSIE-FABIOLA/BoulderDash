package contract;

import java.util.Observable;

import model.element.Map;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */


	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */
	 Map getMap();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	public IMotionFullElement getCharacter();

	Observable getObservable();

}
