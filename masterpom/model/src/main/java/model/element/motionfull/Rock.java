/**
 * 
 */
package model.element.motionfull;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import controller.IStrategy;
import controller.Order;
import model.IMap;
import model.Permeability;
import model.Sprite;
import model.element.strategy.RockStrategy;

/**
 * @author Heidy Kengne
 *
 */
public class Rock extends Mobile {

    private static final Sprite sprite          = new Sprite('O', Sprite.mapTileSet, new Rectangle(48, 0, 16, 16));
    
    private static final IStrategy strategy = new RockStrategy();
    
    
    public Rock(final int x, final int y, final IMap map) throws IOException{
        super(x, y, sprite, map, Permeability.BLOCKING);
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
        //Nop
    }

    @Override
    public final void moveDown() {
        super.moveDown();
    }

    @Override
    protected final void die() {
        //Nop
    }

    @Override
    public final void doNothing() {
        super.doNothing();
    }

    @Override
	public void followMyStrategy() {
		Rock.strategy.followStrategy(this, this.getMap());
	}
	
	@Override
	protected Boolean pawnsAllowMovementTo(final Order direction) {
		Point desiredPosition = null;
		switch (direction) {
		case UP:
			desiredPosition = new Point(this.getX(), this.getY() - 1);
			break;
		case DOWN:
			desiredPosition = new Point(this.getX(), this.getY() + 1);
			break;
		case RIGHT:
			desiredPosition = new Point(this.getX() + 1, this.getY());
			break;
		case LEFT:
			desiredPosition = new Point(this.getX() - 1, this.getY());
			break;
		case NOP:
		default:
			return true;
		}
	
		if (this.getMap().getCharacter().getPosition().equals(desiredPosition)) {
			return false;
		}
		else {
			return super.pawnsAllowMovementTo(direction);
		}
	}
}
