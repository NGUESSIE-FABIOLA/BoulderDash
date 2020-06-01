package controller;

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

		updateBoard();
	
		this.getModel().getMap().applyPhysics();
		
		this.getView().cameraMove();
	}
	
		this.getView().displayMessage("Game Over !");
		
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
	 */
	@Override
	public void orderPerform(Order order) {
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
	
		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
				this.getView().getBoard().addSquare(this.getModel().getMap().getElementByPosition(x, y),
						this.getModel().getMap().getElementByPosition(x, y).getX(),
						this.getModel().getMap().getElementByPosition(x, y).getY());
				this.getView().getBoard().addPawn(this.getModel().getMap().getElementByPosition(x, y));
			}
		}	
		this.getView().getBoard().repaint();
	}

	
	/*public void animate() {
		
		Object[] levelchoice = {1, 2, 3, 4, 5};
		
		int level = (int)JOptionPane.showInputDialog(null, "Choose your level", "Boulderdash", JOptionPane.QUESTION_MESSAGE, null, levelchoice, levelchoice[4]);
		
		JOptionPane.showMessageDialog(null, "Vous avez choisi le niveau" + level, null, JOptionPane.INFORMATION_MESSAGE);
		
		final Model model = new Model(1);
        final BoulderdashView view = new BoulderdashView (model.getMap(), model.getCharacter());
		} */
	
}
