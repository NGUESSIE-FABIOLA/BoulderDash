/**
 * 
 */
package model.element.motionfull;

import contract.IDestructible;
import contract.IElement;
import contract.IMotionFullElement;
import contract.Permeability;
import contract.Sprite;
import model.element.Element;
import model.element.Map;
import model.element.motionless.MotionlessElementFactory;

/**
 * @author Heidy Kengne
 *
 */

public abstract class MotionFullElement extends Element implements IMotionFullElement {

	Map map;

	public MotionFullElement(Sprite sprite, Permeability permeability, Map map, int x, int y) {
		super(sprite, permeability);
		this.setMap(map);
		this.setX(x);
		this.setY(y);
		this.alive = true;
	}

	public MotionFullElement(Sprite sprite, Permeability permeability, Map map) {
		super(sprite, permeability);
		this.setMap(map);

	}

	public void moveUp() {
		if(this.getMap().getElementByPosition(this.getX(), this.getY() - 1).getPermeability() == Permeability.PENETRABLE) {
			this.getMap().getElementByPosition(this.getX(), this.getY() - 1).getSprite().getConsoleImage();
			fillEmptySpace(this.getX(), this.getY());
			this.setY(this.getY() - 1);
		//	System.out.println("x: "+this.getX()+"y: "+this.getY());
			this.getMap().setElementPosition(this, this.getX(), this.getY());
			this.setHasMoved();
		}
	}
	
	public void moveDown() {
		if (this.getMap().getElementByPosition(this.getX(), this.getY() + 1).getPermeability() == Permeability.PENETRABLE) {
			this.getMap().getElementByPosition(this.getX(), this.getY() + 1).getSprite().getConsoleImage();
			//System.out.println("x: "+this.getX()+"y: "+this.getY());
			fillEmptySpace(this.getX(), this.getY());
			this.setY(this.getY() + 1);
			//System.out.println("x: "+this.getX()+"y: "+this.getY());
			this.getMap().setElementPosition(this, this.getX(), this.getY());
			this.setHasMoved();
		}
	}
	

	public void moveLeft() {
		if (this.getMap().getElementByPosition(this.getX() - 1, this.getY()).getPermeability() == Permeability.PENETRABLE) {
			this.getMap().getElementByPosition(this.getX() - 1, this.getY()).getSprite().getConsoleImage();
			//System.out.println("x: "+this.getX()+"y: "+this.getY());
			fillEmptySpace(this.getX(), this.getY());
			this.setX(this.getX() - 1);
		//	System.out.println("x: "+this.getX()+"y: "+this.getY());
			this.getMap().setElementPosition(this, this.getX(), this.getY());
			this.setHasMoved();
		}
	}
	
	public void moveRight() {
		if (this.getMap().getElementByPosition(this.getX() + 1, this.getY()).getPermeability() == Permeability.PENETRABLE) {
			this.getMap().getElementByPosition(this.getX() + 1, this.getY()).getSprite().getConsoleImage();
			//System.out.println("x: "+this.getX()+"y: "+this.getY());
			fillEmptySpace(this.getX(), this.getY());
			this.setX(this.getX() + 1);
		//	System.out.println("x: "+this.getX()+"y: "+this.getY());
			this.getMap().setElementPosition(this, this.getX(), this.getY());
			this.setHasMoved();
	}

	}

	 
	 /**
	 *
	 */
	public void doNothing() {
		 
	 }

	  public void fillEmptySpace(int x, int y) {
			IElement bg = MotionlessElementFactory.getFromFileSymbol('_');
			bg.setX(x);
			bg.setY(y);
			this.getMap().setElementPosition(bg, x, y);
		}
	  
	

		/**
		 * Gets the map
		 * 
		 * @return the map
		 */
		public Map getMap() {
			return map;
		}

		/**
		 * Sets the map
		 * 
		 * @param map
		 * 			the new map
		 */
		public void setMap(Map map) {
			this.map = map;
		}
		
/*	public Point getPosition() {
	
		return this.getPosition();
	}
*/
		/**
		 * Notifies the observers it has changed
		 * 
		 */
		public void setHasMoved() {
			this.getMap().setMapHasChanged();

		}
}
