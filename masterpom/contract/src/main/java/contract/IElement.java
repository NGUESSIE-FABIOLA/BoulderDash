package contract;

import java.awt.Image;
import java.awt.Point;

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
	Image getImage();
	
	public int getId();
	/*
	 * 
	 */
	public String getName();
	/*
	 * 
	 */
	public void setName(final String name);
	/*
	 * 
	 */
	public Sprite getSprite();
	/*
	 * 
	 */
	@Override
	public String toString();
	/*
	 * 
	 */
	public Permeability getPermeability();
	
	int getX();
	void setX(int x);
	int getY();
	void setY(int y);
	
	  @Override
	   Point getPosition();
}
