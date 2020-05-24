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


	public MotionFullElement(Sprite sprite, Permeability permeability, Map map) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

	public MotionFullElement(Map map) {
		// TODO Auto-generated constructor stub
		super(map);
	}

	public void moveUp() {
		//this.getMap().getElementByPosition(this.getX(), this.getY() - 1).getPermeability() == Permeability.PENETRABLE) {
			this.getMap().getElementByPosition(this.getX(), this.getY() - 1).getSprite().getConsoleImage();
			fillEmptySpace(this.getX(), this.getY());
			this.setY(this.getY() - 1);
		//	System.out.println("x: "+this.getX()+"y: "+this.getY());
			this.getMap().setElementPosition(this, this.getX(), this.getY());
			this.setHasMoved();
		
	}
	
	public void moveDown() {
		//if (this.getMap().getElementByPosition(this.getX(), this.getY() + 1).getPermeability() == Permeability.PENETRABLE) {
			this.getMap().getElementByPosition(this.getX(), this.getY() + 1).getSprite().getConsoleImage();
			//System.out.println("x: "+this.getX()+"y: "+this.getY());
			fillEmptySpace(this.getX(), this.getY());
			this.setY(this.getY() + 1);
			//System.out.println("x: "+this.getX()+"y: "+this.getY());
			this.getMap().setElementPosition(this, this.getX(), this.getY());
			this.setHasMoved();
		}
	

	public void moveLeft() {
	//	if (this.getMap().getElementByPosition(this.getX() - 1, this.getY()).getPermeability() == Permeability.PENETRABLE) {
			this.getMap().getElementByPosition(this.getX() - 1, this.getY()).getSprite().getConsoleImage();
			//System.out.println("x: "+this.getX()+"y: "+this.getY());
			fillEmptySpace(this.getX(), this.getY());
			this.setX(this.getX() - 1);
		//	System.out.println("x: "+this.getX()+"y: "+this.getY());
			this.getMap().setElementPosition(this, this.getX(), this.getY());
			this.setHasMoved();
	
	}
	
	public void moveRight() {
	//	if (this.getMap().getElementByPosition(this.getX() + 1, this.getY()).getPermeability() == Permeability.PENETRABLE) {
			this.getMap().getElementByPosition(this.getX() + 1, this.getY()).getSprite().getConsoleImage();
			//System.out.println("x: "+this.getX()+"y: "+this.getY());
			fillEmptySpace(this.getX(), this.getY());
			this.setX(this.getX() + 1);
		//	System.out.println("x: "+this.getX()+"y: "+this.getY());
			this.getMap().setElementPosition(this, this.getX(), this.getY());
			this.setHasMoved();

	}

	/**
	 * @return the x
	 */
	@Override
	public int getX() {
		return 0;
	}

	/**
	 * @return the y
	 */
	@Override
	public int getY() {
		return 0;
	}
	
	  public void die() {
	        
	    }
	  
	  public void fillEmptySpace(int x, int y) {
			IElement bg = MotionlessElementFactory.getFromFileSymbol(' ');
			bg.setX(x);
			bg.setY(y);
			this.getMap().setElementPosition(bg, x, y);
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
		
	public Point getPosition() {
	
		return this.getPosition();
	}

		
		/**
		 * Notifies the observers it has changed
		 * 
		 */
		public void setHasMoved() {
			this.getMap().setMapHasChanged();

		}
}
