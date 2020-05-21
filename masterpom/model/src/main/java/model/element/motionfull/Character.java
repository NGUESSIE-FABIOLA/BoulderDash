/**
 * 
 */
package model.element.motionfull;

import java.io.IOException;

import model.element.Map;
import model.element.Permeability;
import model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */
public class Character extends MotionFullElement{

    /** The Constant SPRITE. */
    private static final Sprite sprite      = new Sprite('H', "R1.png");

    /** The Constant spriteUp. */
    private static final Sprite spriteUp   = new Sprite('H', "2.png");
    
    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteLeft  = new Sprite('H', "A1.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteRight = new Sprite('H', "D1.png");

    /** The Constant spriteDie. */
    private static final Sprite spriteDie   = new Sprite('H', "Death.png");

    /** The Constant spriteDown. */
    private static final Sprite spriteDown   = new Sprite('H', "U1.png");
	  /** The Constant SPRITE. */
    
    private static final Sprite spriteFight = new Sprite('H', "F1.png");

	private Map map;

    /**
     * Instantiates a new Character.
     * @throws IOException 
     */
    
    public Character(final int x, final int y) throws IOException {
        super(x, y, sprite, Permeability.BLOCKING);
        spriteUp.loadImage();
        spriteDown.loadImage();
        spriteLeft.loadImage();
        spriteRight.loadImage();
        spriteFight.loadImage();
        spriteDie.loadImage();
    }

   
    public Character(Map map) {
		// TODO Auto-generated constructor stub
    	this.map = map;
	}


	/*
     * (non-Javadoc)
=     */
    @Override
    public final void moveUp() {
        super.moveLeft();
        this.setSprite(spriteUp);
    }
    
    /*
     * (non-Javadoc)
=     */
    @Override
    public final void moveDown() {
        super.moveLeft();
        this.setSprite(spriteDown);
    }
    
    /*
     * (non-Javadoc)
=     */
    @Override
    public final void Fight() {
        super.moveLeft();
        this.setSprite(spriteFight);
    }
    
    /*
     * (non-Javadoc)
=     */
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteLeft);
    }

    /*
     * (non-Javadoc)
=     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteRight);
    }

    /*
     * (non-Javadoc)
=     */
    @Override
	public
    final void die() {
        super.die();
        this.setSprite(spriteDie);
    }

    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }
}
