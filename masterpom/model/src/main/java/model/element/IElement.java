package model.element;

/*
 * @author Souar SN
 */
public interface IElement {
	
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
}
