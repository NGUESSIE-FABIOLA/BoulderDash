package model.element;

import java.awt.Image;

import model.IElement;
import model.Permeability;
import model.Sprite;


/*
 * @author Souar SN
 */
public abstract class Element implements IElement {
	private Sprite sprite;
	/*
	 * 
	 */
	private Permeability permeability;
		
	public Element(final Sprite sprite, final Permeability permeability) {
		// TODO Auto-generated constructor stub
		   this.setSprite(sprite);
	       this.setPermeability(permeability);

	}
	
	public final Sprite getSprite() {
		return this.sprite;
	}

	protected final void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}

	public final Permeability getPermeability() {
		return this.permeability;
	}

	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	public final Image getImage() {
		return this.getSprite().getImage();
	}
}
