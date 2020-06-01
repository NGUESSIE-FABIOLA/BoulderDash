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
	 * @throws InterruptedException
	 * 		interrupteException 
	 * @throws SQLException
	 * 		if no connection in DB
	 */
	 void control() throws InterruptedException, SQLException;

	
	/**
	 * @return orderPerformer
	 */
	IOrderPerformer getOrderPerformer();

	
	//public void orderPerform(ControllerOrder controllerOrder);
//	public void orderPerform(Order order);
}
