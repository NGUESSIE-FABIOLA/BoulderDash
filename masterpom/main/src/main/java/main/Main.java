/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import contract.IModel;
import controller.Controller;
import model.Model;
import view.BoulderdashView;
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
		
		int level = (int)JOptionPane.showInputDialog(null, "Choose your level", "Boulderdash", JOptionPane.QUESTION_MESSAGE, null, levelchoice, levelchoice[0]);
	
		JOptionPane.showMessageDialog(null, "Vous avez choisi le niveau" + level, null, JOptionPane.INFORMATION_MESSAGE);
		
		final Model model = new Model(level);
        final BoulderdashView view = new BoulderdashView (model.getMap(), model.getCharacter());
       
        final Controller controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPerformer());
        controller.control();
    }
}
