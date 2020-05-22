/**
 * 
 */
package model.element.motionfull;

import java.awt.Point;

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

public abstract class MotionFullElement extends Element implements IDestructible, IMotionFullElement {

	public MotionFullElement(int x, int y, Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}


	public MotionFullElement(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

	public MotionFullElement(Map map) {
		// TODO Auto-generated constructor stub
		super(map);
	}

	public void moveUp() {
		if (this.getMap().getElementByPosition(this.getX(), this.getY() - 1).getPermeability() == Permeability.PENETRABLE) {
			System.out.println(this.getMap().getElementByPosition(this.getX(), this.getY() - 1).getSprite().getConsoleImage());
			fillEmptySpace(this.getX(), this.getY());
			this.setY(this.getY() - 1);
			System.out.println("x: "+this.getX()+"y: "+this.getY());
			this.getMap().setElementPosition(this, this.getX(), this.getY());
			this.setHasMoved();
		}
		// TODO suppr this debug
		else {
			System.out.println(this.getMap().getElementByPosition(this.getX(), this.getY() - 1).getSprite().getConsoleImage());
			System.out.println("can't go through");
		}
	}
	
	public void moveDown() {
		if (this.getMap().getElementByPosition(this.getX(), this.getY() + 1).getPermeability() == Permeability.PENETRABLE) {
			System.out.println(this.getMap().getElementByPosition(this.getX(), this.getY() + 1).getSprite().getConsoleImage());
			System.out.println("x: "+this.getX()+"y: "+this.getY());
			fillEmptySpace(this.getX(), this.getY());
			this.setY(this.getY() + 1);
			System.out.println("x: "+this.getX()+"y: "+this.getY());
			this.getMap().setElementPosition(this, this.getX(), this.getY());
			this.setHasMoved();
		}
		// TODO suppr this debug
		else {
			System.out.println(this.getMap().getElementByPosition(this.getX(), this.getY() + 1).getSprite().getConsoleImage());
			System.out.println("can't go through");
		}
		
	}

	public void moveLeft() {
		if (this.getMap().getElementByPosition(this.getX() - 1, this.getY()).getPermeability() == Permeability.PENETRABLE) {
			System.out.println(this.getMap().getElementByPosition(this.getX() - 1, this.getY()).getSprite().getConsoleImage());
			System.out.println("x: "+this.getX()+"y: "+this.getY());
			fillEmptySpace(this.getX(), this.getY());
			this.setX(this.getX() - 1);
			System.out.println("x: "+this.getX()+"y: "+this.getY());
			this.getMap().setElementPosition(this, this.getX(), this.getY());
			this.setHasMoved();
		}
		// TODO suppr this debug
		else {
			System.out.println(this.getMap().getElementByPosition(this.getX() - 1, this.getY()).getSprite().getConsoleImage());
			System.out.println("can't go through");
		}
	}
	
	public void moveRight() {
		if (this.getMap().getElementByPosition(this.getX() + 1, this.getY()).getPermeability() == Permeability.PENETRABLE) {
			System.out.println(this.getMap().getElementByPosition(this.getX() + 1, this.getY()).getSprite().getConsoleImage());
			System.out.println("x: "+this.getX()+"y: "+this.getY());
			fillEmptySpace(this.getX(), this.getY());
			this.setX(this.getX() + 1);
			System.out.println("x: "+this.getX()+"y: "+this.getY());
			this.getMap().setElementPosition(this, this.getX(), this.getY());
			this.setHasMoved();
		}
		// TODO suppr this debug
		else {
			System.out.println(this.getMap().getElementByPosition(this.getX() + 1, this.getY()).getSprite().getConsoleImage());
			System.out.println("can't go through");
		}
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return 0;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return 0;
	}

	public Point getPosition() {
	   return this.getPosition();
	    }
	
	  public void die() {
	        
	    }
	  
	  public void fillEmptySpace(int x, int y) {
			IElement bg = MotionlessElementFactory.getFromFileSymbol(' ');
			bg.setX(x);
			bg.setY(y);
			this.getMap().setElementPosition(bg, x, y);
		}
	  
	 public void fight() {
		 
	 }
	 
	 public void doNothing() {
		 
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

		
		/**
		 * Notifies the observers it has changed
		 * 
		 */
		public void setHasMoved() {
			this.getMap().setMapHasChanged();

		}
}
