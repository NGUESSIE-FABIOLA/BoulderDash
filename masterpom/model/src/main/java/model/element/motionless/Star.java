/**
 * 
 */
package model.element.motionless;

import java.awt.Rectangle;

import imodel.Permeability;
import imodel.Sprite;

/**
 * @author Heidy Kengne
 *
 */
public class Star extends MotionlessElement {

	  /** The Constant SPRITE. */

	private static final Sprite sprite = new Sprite('*', Sprite.mapTileSet, new Rectangle(0, 8, 16, 16));

	public Star() {
		super(sprite, Permeability.BLOCKING);
	} 
}
