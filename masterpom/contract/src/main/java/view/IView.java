package view;

/**
 * 
 * @author Heidy Kengne
 * 
 */
public interface IView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);
    
    /**
     * Follow myCharacter.
     */
    void cameraMove();
    
    /**
     * Refreshes and redraws elements on the board
     */
    void updateBoard();
}
