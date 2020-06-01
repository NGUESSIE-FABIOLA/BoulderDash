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
	
	public static int SPRITE_SIZE = 16;

	/*
	 * 
	 */
	/*public Sprite (final char character, final String imageName) {
		this.setConsoleImage(character);
		try {
			this.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public Sprite(final char consoleImage) {

		this.setConsoleImage(consoleImage);
			try {
				this.loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		// this.setImageName(imageName);
	}

	/*
	 * Instantiates a new sprite
	 */
/*	public Sprite(final char character) {
		this(character , "noimage.jpg");
	}
*/
	/**
	 * @return the image
	 */
	public final Image getImage() {
		return this.image;
	}
	/*
	 * Loads Image
	 */
	public final void loadImage() throws IOException {
		
		//this.setImage(ImageIO.read(new File("../images/ " +this.getImageName())));
		
BufferedImage buffer;
		
		switch(getConsoleImage()){

		case 'C': 
			buffer = ImageIO.read(new File("../images/player.png")).getSubimage(0, 16, 16, 16);
			setImage(buffer);
			setImageLoaded(true);
			break;
		case 'c':
			buffer = ImageIO.read(new File("../images/player.png")).getSubimage(0, 48, 16, 16);
			setImage(buffer);
			setImageLoaded(true);
			break;
		case 'h':
			buffer = ImageIO.read(new File("../images/player.png")).getSubimage(0, 64, 16, 16);
			setImage(buffer);
			setImageLoaded(true);
			break;
		case 'N' :
			buffer= ImageIO.read(new File("../images/player.png")).getSubimage(0, 32, 16, 16);
			setImage(buffer);
			setImageLoaded(true);
			break;
		case 'H':
			buffer= ImageIO.read(new File("../images/player.png")).getSubimage(0*16,0*16, 16, 16);
			//buffer = ImageIO.read(new File("../images/player.png"));
			setImage(buffer);
			setImageLoaded(true);
			break;
		
		default:
			buffer = ImageIO.read(new File("../images/sprite.png"));
			
			switch(getConsoleImage()){
			case '|':
			case 'B':
				buffer = buffer.getSubimage(0*SPRITE_SIZE,SPRITE_SIZE*4*(LEVEL-1) , SPRITE_SIZE, SPRITE_SIZE);
				break;
			case 'M':
				buffer = buffer.getSubimage(1*SPRITE_SIZE,SPRITE_SIZE*4*(LEVEL-1) , SPRITE_SIZE, SPRITE_SIZE);			
				break;
			case '_':
				buffer = buffer.getSubimage(2*SPRITE_SIZE,SPRITE_SIZE*4*(LEVEL-1) , SPRITE_SIZE, SPRITE_SIZE);			
				break;
			case 'O':
				buffer = buffer.getSubimage(3*SPRITE_SIZE,SPRITE_SIZE*4*(LEVEL-1) , SPRITE_SIZE, SPRITE_SIZE);			
				break;
			case 'D':
				buffer = buffer.getSubimage(4*SPRITE_SIZE,SPRITE_SIZE*4*(LEVEL-1) , SPRITE_SIZE, SPRITE_SIZE);			
				break;
			case 'E':
				buffer = buffer.getSubimage(5*SPRITE_SIZE,SPRITE_SIZE*4*(LEVEL-1) , SPRITE_SIZE, SPRITE_SIZE);			
				break;
			case 'X':
				buffer = buffer.getSubimage(6*SPRITE_SIZE,SPRITE_SIZE*4*(LEVEL-1) , SPRITE_SIZE, SPRITE_SIZE);
				break;
			case 'S':
				buffer = buffer.getSubimage(8*SPRITE_SIZE,SPRITE_SIZE*4*(LEVEL-1) , SPRITE_SIZE, SPRITE_SIZE);			
				break;
			case 'P':
				buffer = buffer.getSubimage(1*SPRITE_SIZE,SPRITE_SIZE*4*(LEVEL-1) , SPRITE_SIZE, SPRITE_SIZE);			
				break;
				
			}
			setImage(buffer);
			setImageLoaded(true);
			break;
		}
	

		
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
