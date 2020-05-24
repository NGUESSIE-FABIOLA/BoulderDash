package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import contract.IMotionFullElement;
import model.element.Map;
import model.element.motionfull.Character;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model implements IModel {
	
	/** The map*/
	private Map map;

	/** The player*/
	private IMotionFullElement character;
	public Model(int i) throws SQLException {
		// TODO Auto-generated constructor stub
		this.setMap(new Map(i));
	     this.setCharacter(new Character(getMap()) );
		// this.setCharacter(new Character(getMap())); // y5 x7 TODO get rid of the hard code
	       this.character.setX(7);
	       this.character.setY(5);
	}



	/**
	 * @return the map
	 */
	public Map getMap() {
		return this.map;
	}



	/**
	 * @param map the map to set
	 */
	public void setMap(Map map) {
		this.map = map;
	}



	/**
	 * @param character the character to set
	 */
	public void setCharacter(IMotionFullElement character) {
		this.character = character;
	}



	@Override
	public IMotionFullElement getCharacter() {
		// TODO Auto-generated method stub
		return this.getCharacter();
	}

	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}

	/** The helloWorld. */
	
}
