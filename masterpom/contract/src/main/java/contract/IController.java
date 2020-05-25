package contract;

import java.io.IOException;
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

	/**
	 * 
	 * @param up
	 * 			Send Order to the Setter
	 * @throws IOException
	 */
	
	//public void orderPerform(ControllerOrder controllerOrder);
	public void orderPerform(Order order);
}
