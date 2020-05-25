/**
 * 
 */
package contract;

import fr.exia.showboard.IPawn;

/**
 * @author Heidy Kengne
 *
 */
public interface IMotionFullElement extends IPawn, IElement{

	/**
     * Move up.
     */
    void moveUp();

    /**
     * Move left.
     */
    void moveLeft();

    /**
     * Move down.
     */
    void moveDown();

    /**
     * Move right.
     */
    void moveRight();

    /**
     * Do nothing.
     */
   void doNothing();

  
}
