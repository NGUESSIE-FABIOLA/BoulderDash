/**
 * 
 */
package model.element.motionfull;

import java.awt.Point;

import contract.IDestructible;
import contract.IMotionFullElement;
import model.element.Element;
import model.element.Permeability;
import model.element.Sprite;

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

	public void moveUp() {
		
	}
	
	public void moveDown() {
		
	}

	public void moveLeft() {
		
	}
	
	public void moveRight() {
		
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
	  
	 public void fight() {
		 
	 }
	 
	 public void doNothing() {
		 
		 
	 }
}
