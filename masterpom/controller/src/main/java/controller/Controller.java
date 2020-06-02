package controller;

import java.io.IOException;

import model.IModel;
import view.IView;


/**
 * The Class Controller.
 */
public final class Controller implements IController, IOrderPerformer {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	  private static final int speed = 200;

	  private Order stackOrder = Order.NOP;
	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		super();
		this.view = view;
		this.model = model;
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	 public void start() throws InterruptedException {
		    this.getModel().getMap().setCharacter(this.getModel().getCharacter());
		    while (this.getModel().getCharacter().isAlive()) {
		      Thread.sleep(speed);
		      
		      if (this.getModel().getCharacter().canMoveTo(this.getStackOrder())) {
		        switch (this.getStackOrder()) {
		        case RIGHT:
		          this.getModel().getCharacter().moveRight();
		          break;
		        case LEFT:
		          this.getModel().getCharacter().moveLeft();
		          break;
		        case DOWN:
		          this.getModel().getCharacter().moveDown();
		          break;
		        case UP:
		          this.getModel().getCharacter().moveUp();
		          break;
		        case NOP:
		        default:
		          this.getModel().getCharacter().doNothing();
		          break;
		        }  
		      }
    		 this.getModel().movePawns();
   	      this.clearStackOrder();

   	      this.getView().cameraMove();
   	      this.getView().updateBoard();

   	      if (this.getModel().getMap().getDiamondCount() == 0) {
   	        this.getView().displayMessage("You won !! Congratulations ;) ");
   	        System.exit(0);
   	      }
   	    }
   	    this.getView().displayMessage("You are dead, GAME OVER. ");
   	    System.exit(0);
   	  }

   	  private IView getView() {
   	    return this.view;
   	  }

   	  private IModel getModel() {
   	    return this.model;
   	  }

   	  public IOrderPerformer getOrderPeformer() {
   	    return this;
   	  }
   	  

   	  
   	  public final void orderPerform(final Order order) throws IOException {
   	    this.setStackOrder(order);
   	  }

   	  private Order getStackOrder() {
   	    return this.stackOrder;
   	  }

   	  private void setStackOrder(Order order) {
   	    this.stackOrder = order;
   	  }

   	  private void clearStackOrder() {
   	    this.stackOrder = Order.NOP;
   	  }
}
