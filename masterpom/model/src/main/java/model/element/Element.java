package model.element;

import java.awt.Image;
import java.awt.Point;

/*
 * @author Souar SN
 */
public class Element implements IElement {
	private Sprite sprite;
	/*
	 * 
	 */
	private Permeability permeability;
	
	private Point position;
	
	public Element(final Sprite sprite, final Permeability permeability) {
		// TODO Auto-generated constructor stub
		   this.setSprite(sprite);
	       this.setPermeability(permeability);
	       this.position = new Point();

	}


	@Override
	public Boolean isAlive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Sprite getSprite() {
		// TODO Auto-generated method stub
		return this.sprite;
	}

	@Override
	public final Permeability getPermeability() {
		// TODO Auto-generated method stub
		return this.permeability;
	}

	public final void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.getPosition().x;
	}
	
	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.getPosition().x = x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.getPosition().y;
	}
	


	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.getPosition().y = y;
	}


	/**
	 * @return the position
	 */
	public Point getPosition() {
		return this.position;
	}


	/**
	 * @param position the position to set
	 */
	public void setPosition(Point position) {
		this.position = position;
	}


	@Override
	public final Image getImage() {
		// TODO Auto-generated method stub
		return this.getSprite().getImage();
	}
}