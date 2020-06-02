/**
 * 
 */
package model.element.strategy;

import controller.Order;
import model.IMap;
import model.IMobile;

/**
 * @author Heidy Kengne
 *
 */
public class FollowWallClockWiseStrategy extends MonsterStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		// TODO Auto-generated method stub
		super.followStrategy(currentPawn, map);
		if(currentPawn.getPosition().y < 0)
		{
			return;
		}
		// first check until a wall is touched
		if (currentPawn.getLastWallTouched() == Order.NOP) {

			if (currentPawn.canMoveTo(Order.LEFT)) {

				currentPawn.moveLeft();
				if (!currentPawn.canMoveTo(Order.LEFT)) {
					currentPawn.setLastWallTouched(Order.LEFT);
				}

			} else if (currentPawn.canMoveTo(Order.DOWN)) {

				currentPawn.moveDown();
				if (!currentPawn.canMoveTo(Order.DOWN)) {
					currentPawn.setLastWallTouched(Order.DOWN);
				}

			} else if (currentPawn.canMoveTo(Order.RIGHT)) {

				currentPawn.moveRight();
				if (!currentPawn.canMoveTo(Order.RIGHT)) {
					currentPawn.setLastWallTouched(Order.RIGHT);
				}

			} else if (currentPawn.canMoveTo(Order.UP)) {

				currentPawn.moveUp();
				if (!currentPawn.canMoveTo(Order.UP)) {
					currentPawn.setLastWallTouched(Order.UP);
				}
			}
		}

		// a wall has been touched, follow it
		if (currentPawn.getLastWallTouched() == Order.LEFT) {
			if (currentPawn.canMoveTo(Order.DOWN)) {
				currentPawn.moveDown();
				if (!currentPawn.canMoveTo(Order.DOWN)) {
					currentPawn.setLastWallTouched(Order.DOWN);
				}
			} else if (currentPawn.canMoveTo(Order.RIGHT)) {
				currentPawn.moveRight();
				if (!currentPawn.canMoveTo(Order.RIGHT)) {
					currentPawn.setLastWallTouched(Order.RIGHT);
				}
			} else if (currentPawn.canMoveTo(Order.UP)) {
				currentPawn.moveUp();
				if (!currentPawn.canMoveTo(Order.UP)) {
					currentPawn.setLastWallTouched(Order.UP);
				}
			}
		} else if (currentPawn.getLastWallTouched() == Order.DOWN) {
			if (currentPawn.canMoveTo(Order.RIGHT)) {
				currentPawn.moveRight();
				if (!currentPawn.canMoveTo(Order.RIGHT)) {
					currentPawn.setLastWallTouched(Order.RIGHT);
				}
			} else if (currentPawn.canMoveTo(Order.UP)) {
				currentPawn.moveUp();
				if (!currentPawn.canMoveTo(Order.UP)) {
					currentPawn.setLastWallTouched(Order.UP);
				}
			} else if (currentPawn.canMoveTo(Order.LEFT)) {
				currentPawn.moveLeft();
				if (!currentPawn.canMoveTo(Order.LEFT)) {
					currentPawn.setLastWallTouched(Order.LEFT);
				}
			}

		} else if (currentPawn.getLastWallTouched() == Order.RIGHT) {
			if (currentPawn.canMoveTo(Order.UP)) {
				currentPawn.moveUp();
				if (!currentPawn.canMoveTo(Order.UP)) {
					currentPawn.setLastWallTouched(Order.UP);
				}
			} else if (currentPawn.canMoveTo(Order.LEFT)) {
				currentPawn.moveLeft();
				if (!currentPawn.canMoveTo(Order.LEFT)) {
					currentPawn.setLastWallTouched(Order.LEFT);
				}
			} else if (currentPawn.canMoveTo(Order.DOWN)) {
				currentPawn.moveDown();
				if (!currentPawn.canMoveTo(Order.DOWN)) {
					currentPawn.setLastWallTouched(Order.DOWN);
				}
			}

		} else if (currentPawn.getLastWallTouched() == Order.UP) {
			if (currentPawn.canMoveTo(Order.LEFT)) {
				currentPawn.moveLeft();
				if (!currentPawn.canMoveTo(Order.LEFT)) {
					currentPawn.setLastWallTouched(Order.LEFT);
				}
			} else if (currentPawn.canMoveTo(Order.DOWN)) {
				currentPawn.moveDown();
				if (!currentPawn.canMoveTo(Order.DOWN)) {
					currentPawn.setLastWallTouched(Order.DOWN);
				}
			} else if (currentPawn.canMoveTo(Order.RIGHT)) {
				currentPawn.moveRight();
				if (!currentPawn.canMoveTo(Order.RIGHT)) {
					currentPawn.setLastWallTouched(Order.RIGHT);
				}
			}

		}

	}


}


