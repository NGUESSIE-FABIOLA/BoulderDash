/**
 * 
 */
package controller;

import java.util.Random;

/**
 * @author Heidy Kengne
 *
 */
public enum Order {
	
	/** The right. */
	RIGHT,

	/** The left. */
	LEFT,

	/** The up. */
	UP,

	/** Down there. */
	DOWN,

	/** The nope. */
	NOP;
	
	/**
	 * 
	 * @return a random value of UserOrder
	 */
	public static Order randomOrder() {
	    int pick = new Random().nextInt(Order.values().length);
	    return Order.values()[pick];
	}
}
