/**
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import controller.Order;
import fr.exia.showboard.BoardFrame;
import model.IMap;
import model.IMobile;

/**
 * @author bryan
 *
 */

	public class View implements IView, Runnable, KeyListener {
		
		/** The Constant squareSize. */
		private static final int squareSize = Toolkit.getDefaultToolkit().getScreenSize().width / 30;

		/** The map. */
		private IMap map = null;

		/** The player's character. */
		private IMobile character = null;

		/** The list of pawns. */
		private ArrayList<IMobile> pawns = null;

		/** The close view on the player. */
		private Rectangle closeView = null;

		/** The order performer. */
		private IOrderPerformer orderPerformer = null;

		/** The BoardFrame. */
		private final BoardFrame boardFrame = new BoardFrame("BoulderDash");

		
		/**
		 * Instantiates a new view facade.
		 * 
		 * @throws IOException
		 *             reject exceptions
		 */
		public View(final IMap map, final IMobile character, final ArrayList<IMobile> pawns) throws IOException {
			super();
			this.setMap(map);
			this.setCharacter(character);
			this.setPawns(pawns);
			this.setCloseView(this.getReasonableViewPort());

			SwingUtilities.invokeLater(this);
		}

		/**
		 * Displays the message in dialog box.
		 * 
		 * @see contract.view.IView#displayMessage(java.lang.String)
		 */
		public final void displayMessage(final String message) {
			JOptionPane.showMessageDialog(null, message);
		}

		private void setMap(final IMap newMap) throws IOException {
			this.map = newMap;
			for (int x = 0; x < this.getMap().getWidth(); x++) {
				for (int y = 0; y < this.getMap().getHeight(); y++) {
					this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
				}
			}
		}

		
		public final void keyPressed(final KeyEvent keyEvent) {
			try {
				this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
			} catch (final IOException exception) {
				exception.printStackTrace();
			}
		}

		public void keyReleased(final KeyEvent keyEvent) {
			// Nop
		}

		public void keyTyped(final KeyEvent keyEvent) {
			// Nop
		}

		public final void run() {
			boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
			boardFrame.setDisplayFrame(this.closeView);
			boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
			boardFrame.addKeyListener(this);
			boardFrame.setFocusable(true);
			boardFrame.setFocusTraversalKeysEnabled(false);
			
			for (int x = 0; x < this.getMap().getWidth(); x++) {
				for (int y = 0; y < this.getMap().getHeight(); y++) {
					boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
				}
			}
			boardFrame.addPawn(this.getCharacter());
			for (IMobile pawn : this.pawns) {
				boardFrame.addPawn(pawn);
			}

			this.getMap().getObservable().addObserver(boardFrame.getObserver());
			this.cameraMove();

			boardFrame.setVisible(true);

		}

		/**
		 * Move the view to focus on the character.
		 */
		public void cameraMove() {
			this.getCloseView().y = (int) (this.character.getY() - (this.getCloseView().getHeight() / 2));
			this.getCloseView().x = (int) (this.character.getX() - (this.getCloseView().getWidth() / 2));

			if (this.character.getY() < this.getCloseView().getHeight() / 2) {
				this.getCloseView().y = 0;
			} else if (this.character.getY() > (this.map.getHeight() - (this.getCloseView().getHeight() / 2))) {
				this.getCloseView().y = (int) (this.map.getHeight() - this.getCloseView().getHeight());
			}
			if (this.character.getX() < this.getCloseView().getWidth() / 2) {
				this.getCloseView().x = 0;
			} else if (this.character.getX() > (this.map.getWidth() - (this.getCloseView().getWidth() / 2))) {
				this.getCloseView().x = (int) (this.map.getWidth() - this.getCloseView().getWidth());
			}
		}
		
		protected static Order keyCodeToUserOrder(final int keyCode) {
			Order order;
			switch (keyCode) {
			case KeyEvent.VK_RIGHT:
				order = Order.RIGHT;
				break;
			case KeyEvent.VK_LEFT:
				order = Order.LEFT;
				break;
			case KeyEvent.VK_UP:
				order = Order.UP;
				break;
			case KeyEvent.VK_DOWN:
				order = Order.DOWN;
				break;
			default:
				order = Order.NOP;
				break;
			}
			return order;
		}

		protected void setCharacter(final IMobile newCharacter) {
			this.character = newCharacter;
		}

		protected IMobile getCharacter() {
			return this.character;
		}

		protected void setCloseView(final Rectangle newView) {
			this.closeView = newView;
		}

		/**
		 * Gets a reasonable size for the close view depending on the map.
		 * 
		 * @return A rectangle with reasonable dimensions
		 */
		protected Rectangle getReasonableViewPort() {
			int reasonableWidth;
			int reasonableHeight;

			// First let's find a reasonable width
			if ((int) (map.getWidth() * 0.75) > 10) {
				reasonableWidth = 10;
			} else if ((int) (map.getWidth() * 0.75) < 5) {
				reasonableWidth = map.getWidth();
			} else {
				reasonableWidth = (int) (map.getWidth() * 0.75);
			}

			// Now the same with height
			if ((int) (map.getHeight() * 0.75) > 10) {
				reasonableHeight = 10;
			} else if ((int) (map.getHeight() * 0.75) < 5) {
				reasonableHeight = map.getHeight();
			} else {
				reasonableHeight = (int) (map.getHeight() * 0.75);
			}

			return new Rectangle(0, 0, reasonableWidth, reasonableHeight);
		}

		protected IMap getMap() {
			return this.map;
		}

		public Rectangle getCloseView() {
			return closeView;
		}

		protected IOrderPerformer getOrderPerformer() {
			return this.orderPerformer;
		}

		public void setOrderPerformer(final IOrderPerformer newPerformer) {
			this.orderPerformer = newPerformer;
		}

		/**
		 * Update the board frame and redraws squares.
		 */
		public void updateBoard() {
			for (int x = 0; x < this.getMap().getWidth(); x++) {
				for (int y = 0; y < this.getMap().getHeight(); y++) {
					boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
				}
			}
		}

		/**
		 * 
		 * @param newPawns
		 *            The pawn list.
		 */
		protected void setPawns(final ArrayList<IMobile> newPawns) {
			this.pawns = newPawns;
		}

	}
	
