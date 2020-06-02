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
public class RandomMonsterStrategy extends MonsterStrategy{

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		// TODO Auto-generated method stub
			super.followStrategy(currentPawn, map);
			if (currentPawn.getPosition().y < 0) {
				return;
			}

			Order orderToFollow = Order.RIGHT;
			int tries = 0;
			while (!currentPawn.canMoveTo(orderToFollow) && tries < 4) {
				orderToFollow = Order.randomOrder();
				tries++;
			}
			
			if(tries == 4)
				return;
			
			this.moveToOrder(orderToFollow, currentPawn);
		}

		private void moveToOrder(final Order orderToFollow, final IMobile currentPawn) {
			if (currentPawn.canMoveTo(orderToFollow)) {
				switch (orderToFollow) {
				case UP:
					currentPawn.moveUp();
					break;
				case DOWN:
					currentPawn.moveDown();
					break;
				case LEFT:
					currentPawn.moveLeft();
					break;
				case RIGHT:
					currentPawn.moveRight();
					break;
				default:
					currentPawn.doNothing();
					break;
				}
			}
		}
	}


