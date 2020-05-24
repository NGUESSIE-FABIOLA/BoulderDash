/**
 * 
 */
package model.element.motionfull;

import contract.IElement;
import contract.Sprite;
import model.element.Map;
import model.element.motionless.Border;
import model.element.motionless.MotionlessElementFactory;

/**
 * @author Heidy Kengne
 *
 */
public class DiamondEnemy extends Enemy{

private static final Sprite DIAMOND_ENEMY = new Sprite('E');
	
	public DiamondEnemy(Map map) {
		super(DIAMOND_ENEMY, map);
		this.alive = true;
	}

	/**
	 * Spawns 9 stars, then 9 diamonds in a 1 square radius
	 * */
	public void die(){
		
		IElement[][] map =this.getMap().getMap();
		
		
		//del elements next to it
		//spawn 9 stars where stuff blew up		
		for(int i = this.getX()-1; i<=this.getX()+1;i++){
			for(int j = this.getY()-1;j <= this.getY()+1;j++){
				if(!(map[i][j]).getClass().equals(Border.class))
				map[i][j] = MotionlessElementFactory.createStar(getMap().getLevel());
			}
		}
		
		// spawn 9 diamonds where the stars were
		for(int i = this.getX()-1; i<=this.getX()+1;i++){
			for(int j = this.getY()-1;j <= this.getY()+1;j++){
				map[i][j] = MotionFullElementFactory.createDiamondEnemy(getMap());
			}
		}
		
	}


}
