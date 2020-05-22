/**
 * 
 */
package contract;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Souar SN
 *
 */
public class Sprite {
	public static int LEVEL;

	/** The image*/
	
	private Image image;
	
	/*Image name**/
	private String imageName;
	
	/**Console image**/
	private char consoleImage;
	
	/**the image loaded**/
	private boolean imageLoaded;
	/*
	 * 
	 */
	public Sprite (final char character, final String imageName) {
		this.setConsoleImage(character);
		this.setImageName(imageName);
	}
	/*
	 * Instantiates a new sprite
	 */
	public Sprite(final char character) {
		this(character , "noimage.jpg");
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return this.image;
	}
	/*
	 * Loads Image
	 */
	public final void loadImage() throws IOException {
		
		this.setImage(ImageIO.read(new File("../images/ " +this.getImageName())));
	}
	/*
	 * sets the image
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	/*
	 * gets the image Name
	 */
	
	public final String getImageName() {
		return this.imageName;
	}
	/*
	 * set the Image name
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	/*
	 * Gets the console image
	 * @return the console image
	 */
	public char getConsoleImage() {
		return this.consoleImage;
	}
	/*
	 * 
	 */
	public void setConsoleImage(char consoleImage) {
		this.consoleImage = consoleImage;
	}
	/*
	 * check if Image loaded
	 * @return true, if image loaded
	 */
	public boolean isImageLoaded() {
		return this.imageLoaded;
	}
	/*
	 * Sets the image loaded
	 * @param isImageLoaded the new image loaded
	 */
	public void setImageLoaded(boolean imageLoaded) {
		this.imageLoaded = imageLoaded;
	}
	
}
