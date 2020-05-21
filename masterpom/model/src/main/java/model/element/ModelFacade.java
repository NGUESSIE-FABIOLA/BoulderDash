/**
 * 
 */
package model.element;

import java.sql.SQLException;
import java.util.Observable;

import contract.IMap;
import contract.IModel;
import contract.IMotionFullElement;
import entity.HelloWorld;
import model.element.motionfull.MotionFullElement;

/**
 * @author Souar SN
 *
 */
public class ModelFacade implements IModel {
	private Map map;

	private IMotionFullElement character;
	
	public ModelFacade(int level) throws Exception {
		// TODO Auto-generated constructor stub
		this.setMap(new Map(level));
		this.setCharacter(new Character(getMap()));
		this.character.setX(7);
		this.character.setY(6);
	}
	

	@Override
	public Map getMap() {
		// TODO Auto-generated method stub
		return this.map;
	}

	
	/**
	 * @param map the map to set
	 */
	public void setMap(Map map) {
		this.map = map;
	}

	@Override
	public IMotionFullElement getCharacter() {
		return this.character;
	}

	/**
	 * @param character
	 */
	public void setCharacter(IMotionFullElement character){
		this.character = character;
	}


	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}

}
