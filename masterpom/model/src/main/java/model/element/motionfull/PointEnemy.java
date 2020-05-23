/**
 * 
 */
package model.element.motionfull;

import contract.Permeability;
import contract.Sprite;
import model.element.Map;

/**
 * @author Heidy Kengne
 *
 */
public class PointEnemy extends Enemy {

   public PointEnemy(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

public PointEnemy(Map map) {
	// TODO Auto-generated constructor stub
	super(map);
}

public void die() {
	   
   }

@Override
public void Fight() {
	// TODO Auto-generated method stub
	
}
}
