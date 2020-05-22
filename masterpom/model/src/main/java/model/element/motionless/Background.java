/**
 * 
 */
package model.element.motionless;

import contract.Permeability;
import contract.Sprite;

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
