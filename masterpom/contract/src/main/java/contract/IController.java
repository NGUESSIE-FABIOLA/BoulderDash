package contract;

import java.sql.SQLException;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control() throws InterruptedException, SQLException;

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	
	IOrderPerformer getOrderPerformer();
	
	//public void orderPerform(ControllerOrder controllerOrder);
}
