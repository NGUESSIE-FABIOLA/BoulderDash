package model.element;

import java.awt.Image;

/*
 * @author Souar SN
 */
public class Element implements IElement {
	private Sprite sprite;
	/*
	 * 
	 */
	public Element(final Sprite sprite, final Permeability permeability) {
		// TODO Auto-generated constructor stub
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}
	private Permeability permeability;

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
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return this.sprite;
	}

	@Override
	public Permeability getPermeability() {
		// TODO Auto-generated method stub
		return this.permeability;
	}

	public void setSprite(Sprite sprite) {
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
	public Image getImage() {
		// TODO Auto-generated method stub
		return this.getImage();
	}
	

}
