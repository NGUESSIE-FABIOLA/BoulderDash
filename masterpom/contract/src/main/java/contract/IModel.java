package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	
	 IMap getMap();

	
	public IMotionFullElement getCharacter();


	Observable getObservable();




}
