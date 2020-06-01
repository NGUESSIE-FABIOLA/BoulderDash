/**
 * 
 */
package model.element;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import contract.IElement;
import contract.IMap;
import contract.Sprite;
import model.Elementboulder;
import model.element.motionfull.Diamond;
import model.element.motionfull.Enemy;
import model.element.motionfull.MotionFullElement;
import model.element.motionfull.MotionFullElementFactory;
import model.element.motionfull.Rock;
import model.element.motionless.Background;
import model.element.motionless.MotionlessElementFactory;

/**
 * @author nodji
 *
 */
public class Map extends Observable implements IMap {
	/**The current level*/
	private int level;
	
	/**The height of the map*/
	private int height ; // height of the map
	
	/**The width of the map*/
	private int width ; // width of the map
	
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
		this.height = height;
		this.width = width;
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
	
	/*
	 * @return map
	 */
	public IElement[][] getMap(){
		return this.map;
		
	}
	
	public final void setMap(IElement[][] map) {
		this.map = map;
	}
	/*
	 * Get elements in database
	 */
	@Override
	public List<IElement> getAllElements() throws SQLException {
		// TODO Auto-generated method stub
		return this.elements;
	}
 
	
	/**
	 *
	 */
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
	
	/**
	 *
	 */
	public int getHeight() {
		return this.height;
	}
	/**
	 * @param height
	 */
	public void setHeight(final int height) {
		this.height = height;
	}
	

	/**
	 * @return the width
	 */
	public int getWidth() {
		return this.width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth( final int width) {
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
	 * Gets if there's a background (air) at the given location
	 * 
	 * @param x the x coordinate
	 * @param y the y coordiante
	 * @return whether there's background or not
	 */
	public boolean isEmpty(int x, int y) {
		if (getElementByPosition(x, y).getClass().equals(Background.class)) {
			return true;
		}
		return false;
	}

	/**
	 * @param element
	 */
	public void moveEnemy(MotionFullElement element) {
		int x = 0;
		int y = 0;
		x = element.getX();
		y = element.getY();

		if (isEmpty(x + 1, y)) {
			element.setX(x + 1);
			element.setY(y);
		} else if (isEmpty(x, y - 1) && !isEmpty(x + 1, y)) {
			element.setX(x);
			element.setY(y - 1);
		} else if (isEmpty(x - 1, y) && !isEmpty(x, y - 1) && !isEmpty(x + 1, y)) {
			element.setX(x - 1);
			element.setY(y);
		} else if (isEmpty(x, y - 1) && !isEmpty(x - 1, y) && !isEmpty(x, y - 1) && !isEmpty(x + 1, y)) {
			element.setX(x);
			element.setY(y - 1);
		} else {
			element.doNothing();
		}
	}
	
	
	/**
	 * @param fileName
	 * @throws IOException
	 */
	public void loadFile(final String fileName) throws IOException {
		final BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String Line;
		int y = 0;
		Line = buff.readLine();
		this.setHeight(Integer.parseInt(Line));
		Line = buff.readLine();
		this.setWidth(Integer.parseInt(Line));
		int level = Integer.parseInt(Line);
		Line = buff.readLine();
		
		char map[][]= new char[this.getWidth()][this.getHeight()];
		while(Line != null) {
			for(int x =0; x< Line.toCharArray().length; x++) {
				
				map[x][y]= Line.toCharArray()[x];
			}
			Line = buff.readLine();
			y++;
		}
		buff.close();
		Elementboulder.saveMap(map, level, this.getHeight(), this.getWidth());
	}
	/**
	 * 
	 */
	public void applyPhysics() {
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				if (map[x][y].getClass().equals(Rock.class) || map[x][y].getClass().equals(Diamond.class)) {

					MotionFullElement element = (MotionFullElement.class.cast((map[x][y])));
					
					//TODO supp debug
					Element e = (Element) map[element.getX()][element.getY() + 1];
					Class buffer =map[element.getX()][element.getY() + 1].getClass();
					Class buffer2 = Background.class;
					
					
					
					//
					if (map[element.getX()][element.getY() - 1].getClass().equals(Background.class)) {
						element.setY(element.getY() - 1);
						map[x][y] = MotionlessElementFactory.createBackground(level);
						map[x][y - 1] = element;
					} else if ((map[element.getX()][element.getY() - 1].getClass().equals(Rock.class)
							|| map[element.getX()][element.getY() - 1].getClass().equals(Diamond.class))
							&& map[element.getX() + 1][element.getY()].getClass().equals(Background.class)
							&& map[element.getX() - 1][element.getY()].getClass().equals(Background.class)) {
						int rand = (int) (Math.random() * 10);
						element.setY(element.getY() - 1);
						if (rand == 0) {
							element.setX(element.getX() + 1);
							map[x + 1][y - 1] = element;
						} else {
							element.setX(element.getX() - 1);
							map[x - 1][y - 1] = element;
						}
						map[x][y] = MotionlessElementFactory.createBackground(level);

					} else if ((map[element.getX()][element.getY() - 1].getClass().equals(Rock.class)
							|| map[element.getX()][element.getY() - 1].getClass().equals(Diamond.class))
							&& map[element.getX() - 1][element.getY()].getClass().equals(Background.class)) {
						element.setY(element.getY() - 1);
						element.setX(element.getX() - 1);
						map[x][y] = MotionlessElementFactory.createBackground(level);
						map[x - 1][y - 1] = element;
					} else if ((map[element.getX()][element.getY() - 1].getClass().equals(Rock.class)
							|| map[element.getX()][element.getY() - 1].getClass().equals(Diamond.class))
							&& map[element.getX() + 1][element.getY()].getClass().equals(Background.class)) {
						element.setY(element.getY() - 1);
						element.setX(element.getX() + 1);
						map[x][y] = MotionlessElementFactory.createBackground(level);
						map[x + 1][y - 1] = element;
					}
				}
			}
		}
	}

	
	public void lookForAndMoveEnemy() {
		IElement[][] elem = getMap();
		for (int j = 0; j < elem.length; j++) {
			for (int i = 0; i < elem[i].length; i++) {
				if (getElementByPosition(i, j).getClass().equals(Enemy.class)) {
					moveEnemy((MotionFullElement) getElementByPosition(i, j));
				}
			}
		}
	}
	/**
	 * @return the score
	 */
	public final int getScore() {
		return this.score;
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
