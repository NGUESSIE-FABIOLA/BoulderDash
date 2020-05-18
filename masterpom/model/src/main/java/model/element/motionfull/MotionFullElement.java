/**
 * 
 */
package model.element.motionfull;

import java.awt.Point;

import contract.IDestructible;
import model.element.Element;

/**
 * @author Heidy Kengne
 *
 */

public abstract class MotionFullElement extends Element implements IDestructible {

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
}
