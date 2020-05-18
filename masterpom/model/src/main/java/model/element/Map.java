/**
 * 
 */
package model.element;

import java.util.List;
import java.util.Observable;

/**
 * @author nodji
 *
 */
public class Map extends Observable {
	private int height;
	/*
	 * 
	 */
	private int widht;
	/*
	 * 
	 */
	//private ICAD icad;
	private int score;
	private int timer;
	private int objective;
	
	public Map(int level ) {
		// TODO Auto-generated constructor stub
	}
	public void loadlevel(int level) {
		
	}
	public void setElementPosition(int x, int y) {
		
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidht() {
		return widht;
	}
	public void setWidht(int widht) {
		this.widht = widht;
	}
	public IElement[][] getMap(){
		return null;
		
	}
	public void setMap(IElement[][] map) {
		
	}
	public List<IElement> getAllElement(){
		return null;
		
	}
	public IElement getElementByPosition(int x, int y) {
		return null;
		
	}
	public IElement getElementByID(int ID) {
		return null;
		
	}
	public IElement getElementByName(String name) {
		return null;
		
	}
	public void SetMapHasChanged() {
		
	}
	public Observable getObservable() {
		return null;
		
	} 
	
}
