/**
 * 
 */
package model.element.motionfull;

import java.awt.Rectangle;
import java.io.IOException;

import controller.IStrategy;
import controller.Order;
import imodel.IMap;
import imodel.Permeability;
import imodel.Sprite;
import model.element.strategy.FollowWallAntiClockWiseStrategy;
import model.element.strategy.FollowWallClockWiseStrategy;
import model.element.strategy.NoStrategy;
import model.element.strategy.RandomMonsterStrategy;

/**
 * @author Heidy Kengne
 *
 */
public class Monster extends Mobile{

	private static final Sprite sprite = new Sprite('M', Sprite.mapTileSet, new Rectangle(144, 16, 16, 16));
	
	private static final IStrategy randomStrategy = new RandomMonsterStrategy();
	
	private static final IStrategy followWallClockWiseStrategy = new FollowWallClockWiseStrategy();
	
	private static final IStrategy followWallAntiClockWiseStrategy = new FollowWallAntiClockWiseStrategy();
	
	private static final IStrategy noStrategy = new NoStrategy();
	
	private IStrategy myStrategy = null;
	
	private Order lastWallTouched = Order.NOP;

	public Monster(final int x, final int y, final IMap map) throws IOException {
		super(x, y, sprite, map, Permeability.BLOCKING);
		sprite.loadImage();
		switch ((int) (Math.random() * (3))) {
		case 1:
			this.myStrategy = Monster.randomStrategy;
			break;
		case 2:
			this.myStrategy = Monster.followWallAntiClockWiseStrategy;
			break;
		default:
			this.myStrategy = Monster.followWallClockWiseStrategy;
			break;
		}
	}

	@Override
	public final void moveLeft() {
		super.moveLeft();
	}

	@Override
	public final void moveRight() {
		super.moveRight();
	}

	@Override
	public final void moveUp() {
		super.moveUp();
	}

	@Override
	public final void moveDown() {
		super.moveDown();
	}

	@Override
	protected final void die() {
		// Nop
	}

	@Override
	public final void doNothing() {
		super.doNothing();
	}

	@Override
	public void followMyStrategy() {
		this.myStrategy.followStrategy(this, this.getMap());
	}

	@Override
	public Order getLastWallTouched() {
		return this.lastWallTouched;
	}

	@Override
	public void setLastWallTouched(final Order order) {
		this.lastWallTouched = order;
	}
	
	public void removeStrategy() {
		this.myStrategy = Monster.noStrategy;
	}
	
}
