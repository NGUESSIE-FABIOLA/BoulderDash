/**
 * 
 */
package model.element.strategy;

import controller.IStrategy;
import imodel.IMap;
import imodel.IMobile;
import model.element.motionfull.Monster;

/**
 * @author Heidy Kengne
 *
 */
public abstract class MonsterStrategy implements IStrategy{
	
	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		if(currentPawn.isCrushed()) {
			Monster monster = (Monster)(currentPawn);
			monster.removeStrategy();
			monster.removeFromBoard();
		}
	}
}
