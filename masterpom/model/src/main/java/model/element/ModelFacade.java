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
	private IMap map;

	@Override
	public IMap getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HelloWorld getHelloWorld() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MotionFullElement getCharacter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}

}
