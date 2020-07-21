/**
 * 
 */
package model.element.motionfull;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import controller.Order;
import imodel.IMap;
import imodel.IMobile;
import imodel.Permeability;
import imodel.Sprite;

/**
 * @author Heidy Kengne
 *
 */
public class Hero extends Mobile{

	private static final Sprite sprite = new Sprite('H', Sprite.characterTileSet, new Rectangle(0, 0, 16, 16));

	private static final Sprite spriteTurnLeft = new Sprite('H', Sprite.characterTileSet,
			new Rectangle(16, 16, 16, 16));

	private static final Sprite spriteTurnRight = new Sprite('H', Sprite.characterTileSet,
			new Rectangle(16, 48, 16, 16));

	private static final Sprite spriteTurnUp = new Sprite('H', Sprite.characterTileSet, new Rectangle(32, 80, 16, 16));

	private static final Sprite spriteTurnDown = new Sprite('H', Sprite.characterTileSet,
			new Rectangle(64, 16, 16, 16));

	private static final Sprite spriteDie = new Sprite('H', Sprite.characterTileSet, new Rectangle(0, 64, 16, 16));


	public Hero(final int x, final int y, final IMap map) throws IOException {
		super(x, y, sprite, map, Permeability.BLOCKING);
		spriteTurnLeft.loadImage();
		spriteTurnRight.loadImage();
		spriteTurnUp.loadImage();
		spriteTurnDown.loadImage();
		spriteDie.loadImage();
		sprite.loadImage();
	}

	@Override
	public final void moveLeft() {
		super.digDirt();
		super.moveLeft();
		this.setSprite(spriteTurnLeft);
	}

	@Override
	public final void moveRight() {
		super.digDirt();
		super.moveRight();
		this.setSprite(spriteTurnRight);
	}

	@Override
	public final void moveUp() {
		super.digDirt();
		super.moveUp();
		this.setSprite(spriteTurnUp);
	}

	@Override
	public final void moveDown() {
		super.digDirt();
		super.moveDown();
		this.setSprite(spriteTurnDown);
	}

	@Override
	public final void die() {
		super.die();
		this.setSprite(spriteDie);
	}

	@Override
	public final void doNothing() {
		super.doNothing();
		this.setSprite(sprite);
	}
	
	/**
	 * @return whether the square next to the player in the given direction is NOT BLOCKING.
	 */
	@Override
	protected boolean mapAllowsMovementTo(final Order direction) {
		switch (direction) {
		case UP:
			return this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() != Permeability.BLOCKING;
		case DOWN:
			return this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() != Permeability.BLOCKING;
		case RIGHT:
			return this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() != Permeability.BLOCKING;
		case LEFT:
			return this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() != Permeability.BLOCKING;
		case NOP:
		default:
			return true;
		}
	}

	@Override
	protected Boolean pawnsAllowMovementTo(final Order direction) {
		Boolean pushingAvailable = false;
		switch (direction) {
		case RIGHT:
			pushingAvailable = this.getMap().getOnTheMapXY(getX() + 2, getY())
					.getPermeability() == Permeability.PENETRABLE;
			if (pushingAvailable) {
				for (IMobile pawn : this.getMap().getPawns()) {
					if (pawn.getPosition().x == getX() + 2 && pawn.getPosition().y == getY()
							&& pawn.getPermeability() != Permeability.PENETRABLE) {
						pushingAvailable = false;
						break;
					}
				}
			}
			break;
		case LEFT:
			pushingAvailable = this.getMap().getOnTheMapXY(getX() - 2, getY())
					.getPermeability() == Permeability.PENETRABLE;
			if (pushingAvailable) {
				for (IMobile pawn : this.getMap().getPawns()) {
					if (pawn.getPosition().x == getX() - 2 && pawn.getPosition().y == getY()
							&& pawn.getPermeability() != Permeability.PENETRABLE) {
						pushingAvailable = false;
						break;
					}
				}
			}
			break;
		case NOP:
		default:
			break;
		}
		
		//TODO factor
		final Point desiredPosition = this.getPositionFromUserOrder(direction);
		for (IMobile pawn : this.getMap().getPawns()) {
			if (pawn.getPosition().equals(desiredPosition)) {
				if (pawn.getPermeability() == Permeability.BLOCKING) {
					if (pushingAvailable) {
						if (direction == Order.RIGHT)
							pawn.moveRight();
						else
							pawn.moveLeft();
						return true;
					} else {

						return false;
					}

				} else if (pawn.getPermeability() == Permeability.MINEABLE) {
					// Player stepped on a diamond

					pawn.removeFromBoard();
					this.getMap().getNbDiamond();
					this.getMap().getAddScore();

					return true;
				}
			}
		}
		return true;
	}

	@Override
	public Boolean canMoveTo(final Order direction) {
		return this.mapAllowsMovementTo(direction) && this.pawnsAllowMovementTo(direction);
	}

	public void setMap(final IMap map) {
		this.getMap().setCharacter(this);
	}

	@Override
	public Boolean isCrushed() {
		for (IMobile pawn : this.getMap().getPawns()) {
			if(pawn.getSprite().getConsoleImage() == 'M'){
				if (this.getPosition().equals(pawn.getPosition()))
					return true;
			}
		}
		return super.isCrushed();
	}

	public void followMyStrategy() {
		//nop
	}

}
