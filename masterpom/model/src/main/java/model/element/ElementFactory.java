package model.element;
/*
 * @author Souar SN
 */

import contract.IElement;
import model.element.motionfull.MotionFullElementFactory;
import model.element.motionless.MotionlessElementFactory;

public class ElementFactory {

	public static IElement getFromFileSymbol(char c) {
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
}
	
}
