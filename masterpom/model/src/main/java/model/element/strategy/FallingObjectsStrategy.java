/**
 * 
 */
package model.element.strategy;

import controller.IStrategy;
import controller.Order;
import model.IMap;
import model.IMobile;
import model.Permeability;

/**
 * @author Heidy Kengne
 *
 */
public class FallingObjectsStrategy implements IStrategy{

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		// if current pawn can go down
		if (currentPawn.canMoveTo(Order.DOWN)) {
			currentPawn.moveDown();
		} else {

			// if not, check if he can fall on the sides
			for (IMobile pawnVerif : map.getPawns()) {

				// if there is a pawn under current pawn
				if (currentPawn.getPosition().y == pawnVerif.getPosition().y - 1
						&& currentPawn.getPosition().x == pawnVerif.getPosition().x) {

					// if the current pawn can go to left
					if (currentPawn.canMoveTo(Order.LEFT)) {

						// if the current pawn can go slide to the left to fall
						if (map.getSquareIsOccupiedXY(pawnVerif.getPosition().x - 1,
								pawnVerif.getPosition().y) == Permeability.PENETRABLE) {
							currentPawn.moveLeft();
							return;
						}
					}

					// if the current pawn can go to right
					if (currentPawn.canMoveTo(Order.RIGHT)) {

						// if the current pawn can go slide to the right to fall
						if (map.getSquareIsOccupiedXY(pawnVerif.getPosition().x + 1,
								pawnVerif.getPosition().y) == Permeability.PENETRABLE) {
							currentPawn.moveRight();
							return;
						}
					}
				}
			}
			currentPawn.doNothing();
		}
	}
}
