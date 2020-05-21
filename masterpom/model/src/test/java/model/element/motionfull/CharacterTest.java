/**
 * 
 */
package model.element.motionfull;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.IElement;
import model.element.Sprite;

/**
 * @author Heidy Kengne
 *
 */
public class CharacterTest {


	private IElement sprite;
	private IElement permeability;
	private Character character;
	private IMotionFullElement x;
	private IMotionFullElement y;
	private Sprite image;
	private int xDimension;
	private int yDimension;
	/**
	 * Test method for {@link model.element.motionfull.Character#moveUp()}.
	 */

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testMoveUp() {
		final int expected = yDimension;
		yDimension--;
		fail("Not yet implemented");
		assertEquals(expected, this.y.getY());	}

	/**
	 * Test method for {@link model.element.motionfull.Character#moveDown()}.
	 */
	@Test
	public void testMoveDown() {
		final int expected = yDimension;
		yDimension++;
		fail("Not yet implemented");
		assertEquals(expected, this.y.getY());	}

	/**
	 * Test method for {@link model.element.motionfull.Character#moveLeft()}.
	 */
	@Test
	public void testMoveLeft() {
		final int expected = xDimension;
		xDimension--;
		fail("Not yet implemented");
		assertEquals(expected, this.x.getX());	}

	/**
	 * Test method for {@link model.element.motionfull.Character#moveRight()}.
	 */
	@Test
	public void testMoveRight() {
		final int expected = xDimension;
		xDimension++;
		fail("Not yet implemented");
		assertEquals(expected, this.x.getX());	}

	/**
	 * Test method for {@link model.element.motionfull.Character#die()}.
	 */
	@Test
	public void testDie() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.element.motionfull.Character#doNothing()}.
	 */
	@Test
	public void testDoNothing() {
		final int expected = xDimension;
		final int expected2 = yDimension;
		fail("Not yet implemented");
		assertEquals(expected, this.x.getX());
		assertEquals(expected2, this.y.getY());	}

	/**
	 * Test method for {@link model.element.motionfull.Character#Character(int, int)}.
	 */

	@Test
	public void testGetSprite() {
		final IElement expected = sprite;
		fail("Not yet implemented");
		assertEquals(expected, this.sprite.getSprite());
	}

	@Test
	public void testGetPermeability() {
		final IElement expected = permeability;
		fail("Not yet implemented");
		assertEquals(expected, this.permeability.getPermeability());
	}
	/**
	 * Test method for {@link model.element.motionfull.Character#Fight()}.
	 */
	@Test
	public void testFight() {
		fail("Not yet implemented");
		assertNotNull(character);
	}
	
	@Test
	public void testGetX() {
		final IMotionFullElement expected = x;
		fail("Not yet implemented");
		assertEquals(expected, this.x.getX());
	}

	@Test
	public void testGetY() {
		final IMotionFullElement expected = y;
		fail("Not yet implemented");
		assertEquals(expected, this.y.getY());
	}

}
