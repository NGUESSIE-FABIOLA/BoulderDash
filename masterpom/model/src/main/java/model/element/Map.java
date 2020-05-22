/**
 * 
 */
package model.element;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import contract.IElement;
import model.Elementboulder;
import model.element.motionfull.MotionFullElementFactory;

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
	
	
	/**
	 * @param level
	 * @throws SQLException 
	 */
	public Map(int level ) throws SQLException {
		super();
		this.setLevel(level);
		this.loadlevel(getLevel());
	}
	/*
	 * 
	 */
	public void loadlevel(int level) throws SQLException {
		this.setHeight(Elementboulder.getMapHeight(level));
		this.setWidth(Elementboulder.getMapWidth(level));
		map = new IElement[this.getWidth()][this.getHeight()];
		MotionFullElementFactory.setMap(this);

		char[][] consoleMap = Elementboulder.getMap(level);
		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				this.setElementPosition(ElementFactory.getFromFileSymbol(consoleMap[x][y]), x, y);
			}
		}
		
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
	public void loadFile(final String fileName) throws IOException {
		final BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String Line;
		int y = 0;
		Line = buff.readLine();
		this.setHeight(Integer.parseInt(Line));
		Line = buff.readLine();
		this.setWidth(Integer.parseInt(Line));
		
		char map[][]= new char[this.getWidth()][this.getHeight()];
		while(Line != null) {
			for(int x =0; x< Line.toCharArray().length; x++) {
				
				map[x][y]= Line.toCharArray()[x];
			}
			Line = buff.readLine();
			y++;
		}
		buff.close();
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
	/**
	 * 
	 */
	public void setMapHasChanged() {
		// TODO Auto-generated method stub
		this.setChanged();
		this.notifyObservers();
		
	}
	/**
	 * @return
	 */
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
