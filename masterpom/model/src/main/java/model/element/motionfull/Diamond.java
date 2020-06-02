/**
 * 
 */
package model.element.motionfull;

import java.awt.Rectangle;
import java.io.IOException;

import controller.IStrategy;
import model.IMap;
import model.Permeability;
import model.Sprite;
import model.element.strategy.DiamondStrategy;

/**
 * @author Heidy Kengne
 *
 */
public class Diamond extends Mobile {

	private static final Sprite sprite = new Sprite('V', Sprite.mapTileSet, new Rectangle(64, 0, 16, 16));

	private static final IStrategy strategy = new DiamondStrategy();

	public Diamond(final int x, final int y, final IMap map) throws IOException {
		super(x, y, sprite, map, Permeability.MINEABLE);
		sprite.loadImage();
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
	
	}
	
	@Override
	public final void moveDown() {
		super.moveDown();
	}

	@Override
	public final void doNothing() {
		super.doNothing();
	}
	
	@Override
	public void followMyStrategy() {
		// TODO Auto-generated method stub
		Diamond.strategy.followStrategy(this, this.getMap());

	}
}
