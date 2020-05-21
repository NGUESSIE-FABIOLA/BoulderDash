/**
 * 
 */
package model.element.motionfull;

import contract.IGravitable;
import model.element.Map;
import model.element.Permeability;
import model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */
public class Rock extends MotionFullElement implements IGravitable {

	  /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('R', "rock.png");

    /**
     * Instantiates a new SpecialStoneWall.
     */
    Rock() {
        super(SPRITE, Permeability.PENETRABLE);
    }
	    
   
   public Rock(Map map) {
		// TODO Auto-generated constructor stub
	   super(map);
	}


public void fall() {
	   
   }


@Override
public void Fight() {
	// TODO Auto-generated method stub
	
}
}
