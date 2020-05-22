/**
 * 
 */
package model.element.motionfull;

import contract.IGravitable;
import contract.Permeability;
import contract.Sprite;
import model.element.Map;

/**
 * @author Heidy Kengne
 *
 */
public class Diamond extends MotionFullElement implements IGravitable {

	  public Diamond(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

	  /** The Constant SPRITE. */
	    private static final Sprite SPRITE = new Sprite('x', "Dia.png");

	    /**
	     * Instantiates a new SpecialStoneWall.
	     */
	   Diamond() {
	        super(SPRITE, Permeability.PENETRABLE);
	    }
		  
   
   public Diamond(Map map) {
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
