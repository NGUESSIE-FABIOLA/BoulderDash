package model.element;

import fr.exia.showboard.IPawn;
import fr.exia.showboard.ISquare;


/*
 * @author Souar SN
 */
public interface IElement extends ISquare, IPawn {
	
	public Boolean isAlive ();
	/*
	 * 
	 */
	public int getID();
	/*
	 * 
	 */
	public String getName();
	/*
	 * 
	 */
	public void setName(String name);
	/*
	 * 
	 */
	public Sprite getSprite();
	/*
	 * 
	 */
	public String toString();
	/*
	 * 
	 */
	public Permeability getPermeability();
	int getX();
	void setX(int x);
	int getY();
	void setY(int y);
	
}
