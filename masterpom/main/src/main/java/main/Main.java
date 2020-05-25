/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;
import java.sql.SQLException;

import contract.IModel;
import controller.Controller;
import model.Model;
import view.View;
import view.ViewFacade;

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
    	
        final Model model = new Model(1);
        final ViewFacade view = new ViewFacade(model.getMap(), model.getCharacter());
        final Controller controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPerformer());
        controller.control();
      //  controller.orderPerform(ControllerOrder.UP);
    }
}
