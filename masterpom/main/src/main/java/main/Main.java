/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;
import java.sql.SQLException;

import contract.ControllerOrder;
import contract.IModel;
import controller.Controller;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException 
     * @throws InterruptedException 
     * @throws SQLException 
     */
    public static void main(final String[] args) throws IOException, SQLException, InterruptedException {
    	
        final IModel model = new Model(1);
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);

        controller.control();
      //  controller.orderPerform(ControllerOrder.UP);
    }
}
