package model.element;

import model.element.motionless.Background;
import model.element.motionless.Mud;
import model.element.motionless.Wall;

/*
 * @author Souar SN
 */


public abstract class ElementFactory {

	  /** The Constant wall. */
    private static final Wall        		 wall          		 = new Wall();

    /** The Constant dugDirt. */
    private static final Background	         background            = new Background();

    /** The Constant filledDirt. */
    private static final Mud   		 mud   		 = new Mud();

    /**
     * The motionless elements is an array of all possible MotionlessElement.
     * used for get from char symbol
     */
    private static Element[]       elements  = {
    	background,
    	mud,
    	wall
     };

    /**
     * Create a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Element createBackground() {
        return background;
    }

    /**
     * Create a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Element Mud() {
        return mud;
    }

    /**
     * Create a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Element createWall() {
        return wall;
    }

    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static Element getFromFileSymbol(final char fileSymbol) {
        for (final Element motionlessElement : elements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return background;
    }
	
    	/*public static IElement getFromFileSymbol(char c) {
		switch(c){
		
		case 'D':
		case 'E':
		case 'H':
		case 'P':
		case 'O':
			return MotionFullElementFactory.getFromFileSymbol(c);
		case '_':
		case '|':
		case 'X':
		case 'M':
		case 'S':
		case '*':
		case 'W':
			return MotionlessElementFactory.getFromFileSymbol(c);
		
		default: return null; 
				
			
	}
}*/
	
}
