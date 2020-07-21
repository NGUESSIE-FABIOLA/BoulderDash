package model;

import java.awt.Point;

import controller.Order;
import fr.exia.showboard.IPawn;

/**
 *
 *@author Heidy Kengne
 *
 */
public interface IMobile extends IPawn, IElement {

    void moveUp();

    void moveLeft();

    void moveDown();

    void moveRight();

    void doNothing();

    int getX();

   
    int getY();

    Boolean isAlive();

  
    Boolean isCrushed();
    
  
    Boolean canMoveTo(final Order direction);

   
    Point getPosition();
    
   
    public void removeFromBoard();
    
   
    public void followMyStrategy();
    
   
    public Order getLastWallTouched();
 
    public void setLastWallTouched(final Order order);

    public boolean isFalling();


}
