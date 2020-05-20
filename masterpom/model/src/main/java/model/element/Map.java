/**
 * 
 */
package model.element;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author nodji
 *
 */
public class Map extends Observable {
	/**The current level*/
	private int level;
	
	/**The height of the map*/
	private int height; // height of the map
	
	/**The width of the map*/
	private int width; // width of the map
	
	/**The double array of elements which constitute the map*/
	private IElement[][] map;
	
	/**Unused list of elements*/
	private ArrayList<IElement> elements;
	
	/**The current score*/
	public int score;
	
	/**Time left till game over*/
	private int timer;
	
	/**Number of diamonds left to collect*/
	public int objective;
	
	
	public Map(int level ) {
		// TODO Auto-generated constructor stub
	}
	/*
	 * 
	 */
	public void loadlevel(int level) {
		
	}
	
	/**
	 * @return the level
	 */
	public final int getLevel() {
		return this.level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
		Sprite.LEVEL = level;
	}
	
	
	public void setElementPosition(IElement element,int x, int y) {
		element.setX(x);
		element.setY(y);
		this.map[x][y] = element;
	}
	public int getHeight() {
		return this.height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	/*
	 * @return map
	 */
	public final IElement[][] getMap(){
		return this.map;
		
	}
	
	public final void setMap(IElement[][] map) {
		this.map = map;
	}
	/*
	 * Get elements in database
	 */
	public List<IElement> getAllElement()throws SQLException{
		return this.elements;
		
	}
	public final IElement getElementByPosition(int x, int y) {
		return this.map[x][y];
		
	}
	/*
	 * 
	 * get by ID
	 */
	public IElement getElementByID(int ID) {
		return null;
		
	}
	public IElement getElementByName(String name) {
		return null;
		
	}
	/*
	 * 
	 */
	public IElement getAllElements() {
		// TODO Auto-generated method stub
		return null;
	}
	public IElement getElementByID() {
		// TODO Auto-generated method stub
		return null;
	}
	public IElement getElementByName() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setMapHasChanged() {
		// TODO Auto-generated method stub
		this.setChanged();
		this.notifyObservers();
		
	}
	public Observable getObservable() {
		return this;
		
	}
	/**
	 * @return the score
	 */
	public final int getScore() {
		return this.score;
	}
	/**
	 * @return the width
	 */
	public final int getWidth() {
		return this.width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the elements
	 */
	public final ArrayList<IElement> getElements() {
		return this.elements;
	}
	/**
	 * @param elements the elements to set
	 */
	public void setElements(ArrayList<IElement> elements) {
		this.elements = elements;
	}
	
	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * @return the objective
	 */
	public final int getObjective() {
		return this.objective;
	}
	/**
	 * @param objective the objective to set
	 */
	public void setObjective(int objective) {
		this.objective = objective;
	}
 
}
