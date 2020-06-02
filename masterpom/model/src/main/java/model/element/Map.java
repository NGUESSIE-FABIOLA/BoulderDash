/**
 * 
 */
package model.element;

import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import model.IElement;
import model.IMap;
import model.IMobile;
import model.Permeability;

/**
 * @author nodji
 *
 */
public class Map extends Observable implements IMap {
	/** The width */
	  private int width;
	  
	  /** The height */
	  private int height;
	  
	  /** The elements */
	  private IElement[][] map;
	  
	  /** The pawn list */
	  private ArrayList<IMobile> pawns;
	  
	  /** The myCharacter */
	  private IMobile Character = null;
	  
	  /** The diamond count */
	  private int diamondCount = 0;

	  /**
	   * Default constructor.
	   * 
	   * @param newWidth
	   *          the new width
	   * @param newHeight
	   *          the new height
	   * @param newMap
	   *          the new map
	   * @throws SQLException
	   *           expection
	   */
	  public Map(final int newWidth, final int newHeight, final IElement[][] newMap) throws SQLException {
	    super();
	    this.map = newMap;

	    this.width = newWidth;
	    this.height = newHeight;
	    this.pawns = new ArrayList<IMobile>();
	  }

	  
	  public void setCharacter(final IMobile newChara) {
	    this.Character = newChara;
	  }

	  
	  public void decreaseDiamondCount() {
	    this.diamondCount--;
	  }

	  
	  public void addDiamondCount() {
	    this.diamondCount++;
	  }

	  public int getDiamondCount() {
	    return this.diamondCount;
	  }

	  /**
	   * @return the map in ASCII character
	   */
	  
	  public final String toString() {
	    String temp = new String();
	    for (int y = 0; y < this.getHeight(); y++) {
	      for (int x = 0; x < this.getWidth(); x++) {
	        temp += map[x][y].getSprite().getConsoleImage();
	      }
	      temp += '\n';
	    }
	    return temp;
	  }

	  
	  public int getWidth() {
	    return this.width;
	  }

	  
	  public int getHeight() {
	    return this.height;
	  }

	  
	  public IElement getOnTheMapXY(final int x, final int y) {
	    if(x >= 0 && x < this.getWidth() && y >= 0 && y < this.getHeight())
	    	return this.map[x][y];
	    else
	    	return this.map[0][0];
	  }

	  
	  public Observable getObservable() {
	    return this;
	  }

	  
	  public final void setMobileHasChanged() {
	    this.setChanged();
	    this.notifyObservers();
	  }

	  
	  public void setOnTheMapXY(int x, int y, IElement elem) {
	    this.map[x][y] = elem;
	  }

	  
	  public void addPawn(IMobile pawn) {
	    this.pawns.add(pawn);
	  }

	  
	  public IMobile getCharacter() {
	    return this.Character;
	  }

	  
	  public ArrayList<IMobile> getPawns() {
	    return this.pawns;
	  }

	  /**
	   * Returns the permeability of an element on the map. Note that this will return
	   * the permeability of a pawn if one is there at the given coordonates.
	   * @param x
	   * @param y
	   * @return x and y
	   */
	  
	  public Permeability getSquareIsOccupiedXY(final int x, final int y) {
	    Point point = new Point(x, y);
	    for(IMobile pawn : this.getPawns()) {
	      if (pawn.getPosition().equals(point))
	        return pawn.getPermeability();
	    }
	    
	    if(this.getCharacter().getPosition().equals(point))
	    	return this.getCharacter().getPermeability();
	    
	    return this.getOnTheMapXY(x, y).getPermeability();
	  }

	
}
