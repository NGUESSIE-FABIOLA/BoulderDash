package controller;

import java.io.IOException;
import java.sql.SQLException;

import contract.IController;
import contract.IModel;
import contract.IOrderPerformer;
import contract.IView;
import contract.Order;

/**
 * The Class Controller.
 */
public final class Controller implements IController, IOrderPerformer {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	  /**Order to execute */
    private Order order;
    
    
    private static final int 	speedCharacter = 250;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearOrder();
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() throws SQLException, InterruptedException {
		//this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
		
		int i=0;
		while (this.getModel().getCharacter().isAlive()) {
    		Thread.sleep(speedCharacter);
    		
    		switch (this.getOrder()) {
			case UP :
				this.getModel().getCharacter().moveUp();
				break;
			case DOWN :
				this.getModel().getCharacter().moveDown();
				break;
			case RIGHT :
				this.getModel().getCharacter().moveRight();
				break;
			case LEFT :
				this.getModel().getCharacter().moveLeft();
			case NOP :
			default :
				this.getModel().getCharacter().doNothing();
				break;	
		}
		this.clearOrder();
		}
	
	}

		 /**
	     * Gets the view.
	     *
	     * @return the view
	     */
	    public IView getView() {
	        return this.view;
	    }
	    
	    public void setView(final IView view){
	    	this.view = view;
	    }

	    /**
	     * Gets the model.
	     *
	     * @return the model
	     */
	    public IModel getModel() {
	        return this.model;
	    }
	    
	    /**
	     * Sets the Model
	     * 
	     * @param model of the game
	     */
	    public void setModel(final IModel model){
	    	this.model = model;
	    }

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	/*public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case English:
				this.model.loadHelloWorld("GB");
				break;
			case Francais:
				this.model.loadHelloWorld("FR");
				break;
			case Deutsch:
				this.model.loadHelloWorld("DE");
				break;
			case Indonesia:
				this.model.loadHelloWorld("ID");
				break;
			default:
				break;
		}
	}*/

	 /**
     * 	Gets the order
     * 
     * @return an order
     */
	public Order getOrder() {
		return order;
	}
	
	/**
	 * 
	 * @param order
	 * 			Send order to the Setter
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	
	/**
	 * Clear the order
	 */
	public void clearOrder(){
		this.order = Order.NOP;
	}
	
	/**
	 * 
	 * @param order
	 * 			Send Order to the Setter
	 * @throws IOException
	 */
	@Override
	public void orderPerform(Order order) throws IOException {
		this.setOrder(order);
	}

	/**
	 * Gets the Order Performer who return this control
	 */
	@Override
	public IOrderPerformer getOrderPerformer() {
		// TODO Auto-generated method stub
		return this;
	}
	
	
	//TODO debug of board repaint
	public void updateBoard(){
		
		
		
		//already works-ish by itself
		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
				this.getView().getBoard().addSquare(this.getModel().getMap().getElementByPosition(x, y),
						this.getModel().getMap().getElementByPosition(x, y).getX(),
						this.getModel().getMap().getElementByPosition(x, y).getY());
				this.getView().getBoard().addPawn(this.getModel().getMap().getElementByPosition(x, y));
			}
			
		}	
		//yes I know it spawn ConcurentModif ex sometimes but they don't seem to be a great deal and it's the only way I found
		this.getView().getBoard().repaint();
	}

	
}
