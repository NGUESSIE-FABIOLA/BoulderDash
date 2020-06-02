/**
 * 
 */
package controller;

import model.IMap;
import model.IMobile;

/**
 * @author Heidy Kengne
 *
 */
public interface IStrategy {

	  public void followStrategy(IMobile currentPawn, IMap map);

}
