/**
 * 
 */
package model.element.strategy;

import model.IMap;
import model.IMobile;

/**
 * @author Heidy Kengne
 *
 */
public class DiamondStrategy extends FallingObjectsStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		// TODO Auto-generated method stub
		if ((currentPawn.getPosition().y == map.getCharacter().getPosition().y - 1
				&& currentPawn.getPosition().x == map.getCharacter().getPosition().x)
				|| currentPawn.getPosition().equals(map.getCharacter().getPosition())) {
			currentPawn.removeFromBoard();
			map.decreaseDiamondCount();
			return;
		}
		super.followStrategy(currentPawn, map);
	}

}
