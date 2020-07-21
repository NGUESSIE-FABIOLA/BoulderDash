/**
 * 
 */
package controller;

import imodel.IMap;
import imodel.IMobile;

/**
 * @author Heidy Kengne
 *
 */
public interface IStrategy {

	  public void followStrategy(IMobile currentPawn, IMap map);

}
