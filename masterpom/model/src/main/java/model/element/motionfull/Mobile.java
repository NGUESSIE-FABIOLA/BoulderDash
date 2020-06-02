/**
 * 
 */
package model.element.motionfull;

import java.awt.Point;
import java.io.IOException;

import controller.Order;
import fr.exia.showboard.IBoard;
import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.element.Element;
import model.element.ElementFactory;

/**
 * @author Heidy Kengne
 *
 */
public abstract class Mobile extends Element implements IMobile {

	private Point position;

	private Boolean alive = true;

	private IMap map;

	private IBoard board;

	private boolean fallSpeed = false;

	
	Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
		super(sprite, permeability);
		this.map = map;
		this.position = new Point();
	}


	protected Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
		this(sprite, map, permeability);
		// Following code will not work: if (0, y) or (x, 0) is BLOCKING,
		// The game will end instanty. We have to set the initial position
		// without
		// Checking for collisions
		// this.setX(x);
		// this.setY(y);

		this.getPosition().x = x;
		this.getPosition().y = y;
	}

	public void moveUp() {
		this.setY(this.getY() - 1);
		this.setHasMoved();
	}

	public void moveLeft() {
		this.setX(this.getX() - 1);
		this.setHasMoved();
	}

	public void moveDown() {
		this.setY(this.getY() + 1);
		this.setHasMoved();
		this.fallSpeed = true;
	}

	public void moveRight() {
		this.setX(this.getX() + 1);
		this.setHasMoved();
	}

	public void doNothing() {
		this.setHasMoved();
		this.fallSpeed = false;
	}

	private void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}

	public final int getX() {
		return this.getPosition().x;
	}

	public final void setX(final int x) {
		this.getPosition().x = x;
		if (this.isCrushed()) {
			this.die();
		}
	}

	public void digDirt() {
		this.getMap().setOnTheMapXY(this.getX(), this.getY(), ElementFactory.createBackground());
		try {
			this.getMap().getOnTheMapXY(getX(), getY()).getSprite().loadImage();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public final int getY() {
		return this.getPosition().y;
	}

	public final void setY(final int y) {
		this.getPosition().y = y;
		if (this.isCrushed()) {
			this.die();
		}
	}

	public IMap getMap() {
		return this.map;
	}

	public Boolean isAlive() {
		return this.alive;
	}

	protected void die() {
		this.alive = false;
		this.setHasMoved();
	}

	public Boolean isCrushed() {
		for (IMobile pawn : this.getMap().getPawns()) {
			if (pawn.getSprite().getConsoleImage() == 'O' || pawn.getSprite().getConsoleImage() == 'V') {
				if (pawn.getPosition().x == this.getPosition().x
						&& pawn.getPosition().y == this.getPosition().y - 1 && pawn.isFalling()) {
					return true;
				}
			}
		}
		return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
	}

	public Boolean canMoveTo(final Order direction) {
		return this.mapAllowsMovementTo(direction) && this.pawnsAllowMovementTo(direction);
	}

	protected boolean mapAllowsMovementTo(final Order direction) {
		switch (direction) {
		case UP:
			return this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1)
					.getPermeability() == Permeability.PENETRABLE;
		case DOWN:
			return this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
					.getPermeability() == Permeability.PENETRABLE;
		case RIGHT:
			return this.getMap().getOnTheMapXY(this.getX() + 1, this.getY())
					.getPermeability() == Permeability.PENETRABLE;
		case LEFT:
			return this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
					.getPermeability() == Permeability.PENETRABLE;
		case NOP:
		default:
			return true;
		}
	}

	protected Boolean pawnsAllowMovementTo(final Order direction) {
		Point desiredPosition = this.getPositionFromUserOrder(direction);
		for (IMobile pawn : this.getMap().getPawns()) {
			if (pawn.getPosition().equals(desiredPosition)) {
				if (pawn.getPermeability() != Permeability.PENETRABLE) {
					return false;
				} else {
					return true;
				}
			}
		}

		return true;
	}
	
	protected Point getPositionFromUserOrder(final Order direction){
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
			desiredPosition = new Point(this.getX(), this.getY());
			break;
		}
		
		return desiredPosition;
	}

	public Point getPosition() {
		return this.position;
	}

	public void setPosition(final Point position) {
		this.position = position;
	}

	protected IBoard getBoard() {
		return this.board;
	}

	public boolean isFalling() {
		return fallSpeed;
	}

	public void removeFromBoard() {
		this.setPosition(new Point(1, -1));
		this.getMap().getPawns().remove(this);
	}

	public Order getLastWallTouched() {
		return Order.NOP;
	}

	public void setLastWallTouched(final Order Order) {
		// nop
	}
}
