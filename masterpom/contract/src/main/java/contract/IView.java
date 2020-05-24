package contract;

import fr.exia.showboard.BoardFrame;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	void printMessage(final String message);

	 void cameraMove();
	    
	    BoardFrame getBoard();
	    
	    void setBoard(BoardFrame board);
	    
}
