package view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IMap;
import contract.IModel;
import contract.IMotionFullElement;
import contract.IOrderPerformer;
import contract.IView;
import contract.Order;
import fr.exia.showboard.BoardFrame;


/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable {

	private int SIZESPRITE = 16;
	
	private int VIEWSIZE = SIZESPRITE * 15;

    private Rectangle closeView;
    
    private IMap map; 
    
    private IMotionFullElement mainCharacter;
    
    private Point characterPosition;
    
    private IOrderPerformer orderPerformer;
    
    private int mapViewSizeX = 20 ;
    
    private int mapViewSizeY = 20 ;
    
    private BoardFrame board;
    
    
	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		// this.getMyVehicle().getSprite().loadImage();
		// this.setCloseView(new Rectangle(0, this.getMyVehicle().getY(), this.getRoad().getWidth(), roadView));
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	
	public  void show(){
		
	}
	
	public  void cameraMove() {
		
	}
	
	private Order keyCodeToUserOrder(int keyCode) {
		return null;
		
		
	}
	
	// ON POURRA SUPPRIMER CETTE METHODE AVEC LA CLASSE CONTROLLERORDER//
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_G:
				return ControllerOrder.English;
			case KeyEvent.VK_F:
				return ControllerOrder.Francais;
			case KeyEvent.VK_D:
				return ControllerOrder.Deutsch;
			case KeyEvent.VK_I:
				return ControllerOrder.Indonesia;
			default:
				return ControllerOrder.English;
		}
	} 

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() 
	{
		this.viewFrame.setVisible(true);
		
		board = new BoardFrame("Close view");
       // boardFrame.setDimension(new Dimension(this.getRoad().getWidth(), this.getRoad().getHeight()));
        board.setDisplayFrame(this.closeView);
        board.setSize(this.closeView.width * VIEWSIZE, this.closeView.height * VIEWSIZE);
        board.setHeightLooped(true);
       // boardFrame.addKeyListener(this);
        board.setFocusable(true);
        board.setFocusTraversalKeysEnabled(false);

       // boardFrame.addPawn(this.getMyVehicle());

        //this.getRoad().getObservable().addObserver(boardFrame.getObserver());

        board.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}

	/**
	 * @return the closeView
	 */
	public Rectangle getCloseView() {
		return closeView;
	}

	/**
	 * @param closeView the closeView to set
	 */
	public void setCloseView(Rectangle closeView) {
		this.closeView = closeView;
	}

	/**
	 * @return the map
	 */
	public IMap getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(IMap map) {
		this.map = map;
	}

	/**
	 * @return the mainCharacter
	 */
	public IMotionFullElement getMainCharacter() {
		return mainCharacter;
	}

	/**
	 * @param mainCharacter the mainCharacter to set
	 */
	public void setMainCharacter(IMotionFullElement mainCharacter) {
		this.mainCharacter = mainCharacter;
	}

	/**
	 * @return the characterPosition
	 */
	public Point getCharacterPosition() {
		return characterPosition;
	}

	/**
	 * @param characterPosition the characterPosition to set
	 */
	public void setCharacterPosition(Point characterPosition) {
		this.characterPosition = characterPosition;
	}

	/**
	 * @return the orderPerformer
	 */
	public IOrderPerformer getOrderPerformer() {
		return orderPerformer;
	}

	/**
	 * @param orderPerformer the orderPerformer to set
	 */
	public void setOrderPerformer(IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	/**
	 * @return the mapViewSizeX
	 */
	public int getMapViewSizeX() {
		return mapViewSizeX;
	}

	/**
	 * @param mapViewSizeX the mapViewSizeX to set
	 */
	public void setMapViewSizeX(int mapViewSizeX) {
		this.mapViewSizeX = mapViewSizeX;
	}

	/**
	 * @return the mapViewSizeY
	 */
	public int getMapViewSizeY() {
		return mapViewSizeY;
	}

	/**
	 * @param mapViewSizeY the mapViewSizeY to set
	 */
	public void setMapViewSizeY(int mapViewSizeY) {
		this.mapViewSizeY = mapViewSizeY;
	}

	/**
	 * @return the board
	 */
	public BoardFrame getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(BoardFrame board) {
		this.board = board;
	}
	
	public void updateboard() {
		
	}
}
