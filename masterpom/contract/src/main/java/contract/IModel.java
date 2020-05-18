package contract;

import java.util.Observable;

import entity.HelloWorld;
import model.element.motionfull.MotionFullElement;

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
	HelloWorld getHelloWorld();

	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */
	public IMap getMap();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	public MotionFullElement getCharacter();

}
