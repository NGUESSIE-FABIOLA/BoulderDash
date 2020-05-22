package model;

import java.util.Observable;

import contract.IModel;
import contract.IMotionFullElement;
import model.element.Map;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model implements IModel {

	private Map map;

	@Override
	public Map getMap() {
		// TODO Auto-generated method stub
		return this.map;
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
