/**
 * 
 */
package model.element;

import java.util.Observable;

import contract.IMap;
import contract.IModel;
import entity.HelloWorld;
import model.element.motionfull.MotionFullElement;

/**
 * @author Souar SN
 *
 */
public class ModelFacade implements IModel {
	private Map map;

	private MotionFullElement character;
	
	public ModelFacade(int level) {
		// TODO Auto-generated constructor stub
		this.setMap(new Map(level));
		//this.setCharacter(new Character(getMap()));
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
	public MotionFullElement getCharacter() {
		// TODO Auto-generated method stub
		return this.character;
	
	}

	/**
	 * @param character the character to set
	 */
	public void setCharacter(MotionFullElement character) {
		this.character = character;
	}



	/*@Override
	public HelloWorld getHelloWorld() {
		// TODO Auto-generated method stub
		return null;
	}*/



	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public HelloWorld getHelloWorld() {
		// TODO Auto-generated method stub
		return null;
	}



}
