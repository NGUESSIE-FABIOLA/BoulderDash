package view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IMap;
import contract.IModel;
import contract.IView;
import fr.exia.showboard.*;

 /**
 * @author bryan
 *
 */

public final class View implements IView, Runnable{
	

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
		this.setMap(map);

		this.setMainCharacter(IMotionFullElement character);
		this.getMainCharacter().getSprite().loadImage();
		this.setCloseView(new Rectangle(0, this.getMainCharacter().getY(), mapViewSizeX, mapViewSizeY));
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
		
		// // TODO Remplir la fonction show qui ne renvoie rien, mais print les
				// // sprites
				// System.out.println("afficher");
				// int y = yStart % this.getMap().getHeight();
				// for (int view = 0; view < this.getViewMapX(); view++) {
				// for (int x = 0; x < this.getViewMapY(); x++) {
				// if ((x == this.getMainCharacter().getX()) && (y == yStart)) {
				// System.out.print(this.getMainCharacter().getSprite().getConsoleImage());
				// } else {
				// System.out.print(this.getMap().getElementByPosition(x,
				// y).getSprite().getConsoleImage());
				// }
				// }
				// y = (y + 1) % this.getMap().getHeight();
				// System.out.print("\n");
				// }
	}
	
	public  void cameraMove() {
		
		int x;
		int y;
		x = (int) this.getMainCharacter().getX();
		y = (int) this.getMainCharacter().getY();
		if (x < this.getCloseView().x + 5) {
			this.getCloseView().x--;
		} else if (x > this.getCloseView().x + 10) {
			this.getCloseView().x++;
		}
		if (y < this.getCloseView().y + 4) {
			this.getCloseView().y--;
		} else if (y > this.getCloseView().y + 10) {
			this.getCloseView().y++;
		}
	}
	
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		
		switch (keyCode) {
		
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.RIGHT;
				
			case KeyEvent.VK_LEFT:
				return ControllerOrder.LEFT;
				
			case KeyEvent.VK_UP:
				return ControllerOrder.UP;
				
			case KeyEvent.VK_DOWN:
				return ControllerOrder.DOWN;
				
			case KeyEvent.VK_C:
				return ControllerOrder.CARRY;
				
			default:
				return ControllerOrder.NOP;
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
		
       final BoardFrame boardFrame = new BoardFrame("BoulderDash");
		boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
		boardFrame.setDisplayFrame(closeView);
		boardFrame.setSize(this.closeView.width * SIZESPRITE * 2, this.closeView.height * SIZESPRITE * 2);
		//boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);

		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				this.map.getElementByPosition(x, y).setX(x);
				this.map.getElementByPosition(x, y).setY(y);

				boardFrame.addSquare((ISquare) this.map.getElementByPosition(x, y), x, y);
				// boardFrame.addPawn((IPawn)this.getMap().getElementByPosition(x,
				// y));
				boardFrame.addPawn((IPawn) this.map.getElementByPosition(x, y));
			}
		}

		boardFrame.addPawn(this.getMainCharacter());

		this.getMap().getObservable().addObserver(boardFrame.getObserver());

		boardFrame.setVisible(true);

		setBoard(boardFrame);
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
		for (int y = 0; y < this.getMap().getHeight(); y++) {
			for (int x = 0; x < this.getMap().getWidth(); x++) {
				this.getMap().getElementByPosition(x, y).getSprite().loadImage();
			}
		}
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
		
		BoardFrame boardFrame = new BoardFrame("BoulderDash");
		boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
		boardFrame.setDisplayFrame(closeView);
		boardFrame.setSize(this.closeView.width * SIZESPRITE * 2, this.closeView.height * SIZESPRITE * 2);
		//boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);

		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				this.map.getElementByPosition(x, y).setX(x);
				this.map.getElementByPosition(x, y).setY(y);

				boardFrame.addSquare((ISquare) this.map.getElementByPosition(x, y), x, y);
				// boardFrame.addPawn((IPawn)this.getMap().getElementByPosition(x,
				// y));
				boardFrame.addPawn((IPawn) this.map.getElementByPosition(x, y));
			}
		}

		boardFrame.addPawn(this.getMainCharacter());

		this.getMap().getObservable().addObserver(boardFrame.getObserver());

		boardFrame.setVisible(true);
		
	}
}
