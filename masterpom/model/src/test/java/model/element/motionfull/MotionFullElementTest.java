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

import contract.IMotionFullElement;

/**
 * @author Heidy Kengne
 *
 */
public class MotionFullElementTest {

	private IMotionFullElement x;
	private IMotionFullElement y;
	private int xDimension;
	private int yDimension;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.element.motionfull.MotionFullElement#getX()}.
	 */
	@Test
	public void testGetX() {
		final IMotionFullElement expected = x;
		fail("Not yet implemented");
		assertEquals(expected, this.x.getX());	}

	/**
	 * Test method for {@link model.element.motionfull.MotionFullElement#getY()}.
	 */
	@Test
	public void testGetY() {
		final IMotionFullElement expected = y;
		fail("Not yet implemented");
		assertEquals(expected, this.y.getY());	}

	/**
	 * Test method for {@link model.element.motionfull.MotionFullElement#getPosition()}.
	 */
	@Test
	public void testGetPosition() {
		final IMotionFullElement expected = x;
		final IMotionFullElement expected2 = y;
		fail("Not yet implemented");
		assertEquals(expected, this.x.getX());
		assertEquals(expected2, this.y.getY());	}

	/**
	 * Test method for {@link model.element.motionfull.MotionFullElement#moveUp()}.
	 */
	@Test
	public void testMoveUp() {
		final int expected = yDimension;
		yDimension--;
		fail("Not yet implemented");
		assertEquals(expected, this.y.getY());	}

	/**
	 * Test method for {@link model.element.motionfull.MotionFullElement#moveDown()}.
	 */
	@Test
	public void testMoveDown() {
		final int expected = yDimension;
		yDimension++;
		fail("Not yet implemented");
		assertEquals(expected, this.y.getY());	}

	/**
	 * Test method for {@link model.element.motionfull.MotionFullElement#moveLeft()}.
	 */
	@Test
	public void testMoveLeft() {
		final int expected = xDimension;
		xDimension--;
		fail("Not yet implemented");
		assertEquals(expected, this.x.getX());	}

	/**
	 * Test method for {@link model.element.motionfull.MotionFullElement#moveRight()}.
	 */
	@Test
	public void testMoveRight() {
		final int expected = xDimension;
		xDimension++;
		fail("Not yet implemented");
		assertEquals(expected, this.x.getX());	}

	/**
	 * Test method for {@link model.element.motionfull.MotionFullElement#die()}.
	 */
	@Test
	public void testDie() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.element.motionfull.MotionFullElement#fight()}.
	 */
	@Test
	public void testFight() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.element.motionfull.MotionFullElement#doNothing()}.
	 */
	@Test
	public void testDoNothing() {
		final int expected = xDimension;
		final int expected2 = yDimension;
		fail("Not yet implemented");
		assertEquals(expected, this.x.getX());
		assertEquals(expected2, this.y.getY());	}

}
