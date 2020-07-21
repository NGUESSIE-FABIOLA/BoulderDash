package model;

import java.awt.Image;

import fr.exia.showboard.ISquare;

/**
 *
 *@author Heidy Kengne
 *
 */
public interface IElement extends ISquare {


    Sprite getSprite();

  
    Permeability getPermeability();

    
    Image getImage();

}
