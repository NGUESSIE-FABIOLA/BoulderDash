/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Controller;
import controller.IController;
import model.IModel;
import model.Model;
import view.View;
//import view.ViewFacade;

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
     * 			Input output error
     * @throws InterruptedException
     * 			interrupted 
     * @throws SQLException
     * 			SQL error 
     */
    public static void main(final String[] args) throws IOException, SQLException, InterruptedException {
    	
    	
    	Object[] levelchoice = {1, 2, 3, 4, 5};
		
		int level = (int)JOptionPane.showInputDialog(null, "Choose your level", "BoulderDash", JOptionPane.QUESTION_MESSAGE, null, levelchoice, levelchoice[0]);
	
		JOptionPane.showMessageDialog(null, "Vous avez choisi le niveau" + level, null, JOptionPane.INFORMATION_MESSAGE);
		final IModel model = new Model(level);
    	final View view = new View(model.getMap(), model.getCharacter(), model.getMap().getPawns());
        final IController controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        try {
            controller.start();
        } catch (InterruptedException e) {
        	System.out.println(e.getMessage());
			e.printStackTrace();
		}
    }
}
