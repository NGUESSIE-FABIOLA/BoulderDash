/**
 * 
 */
package model.element.motionfull;

import model.element.Map;
import model.element.Permeability;
import model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */
public abstract class Enemy extends MotionFullElement{


   public Enemy(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

   public Enemy(Map map) {
	   
	   super(map);
   }
public void die() {
	   
   }

}
