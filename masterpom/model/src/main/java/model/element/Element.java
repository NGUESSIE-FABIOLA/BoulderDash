package model.element;

/*
 * @author Souar SN
 */
public class Element implements IElement {
	private Sprite sprite;
	/*
	 * 
	 */
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
	

}
