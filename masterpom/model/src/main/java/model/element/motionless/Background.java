/**
 * 
 */
package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */
public class Background extends MotionlessElement{

	  /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "Bac.png");

    /**
     * Instantiates a new Background.
     */
    Background() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
