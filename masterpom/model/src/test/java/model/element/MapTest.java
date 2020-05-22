/**
 * 
 */
package model.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IElement;

/**
 * @author nodji
 *
 */
public class MapTest {
	private int height;
	private int widht;
	private IElement[][] sizeMap;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	private Map map;
	private int List;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.map = new Map(List);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.element.Map#getHeight()}.
	 */
	@Test
	public void testGetHeight() {
		final int expected = 21;
		//fail("Not yet implemented");
		assertEquals(expected, this.map.getHeight());
	}

	/**
	 * Test method for {@link model.element.Map#setHeight(int)}.
	 */
	@Test
	public void testSetHeight() {
	final int expected = 21;
	this.map.setHeight(expected);
	assertEquals(expected, this.map.getHeight());
	}

	/**
	 * Test method for {@link model.element.Map#getAllElements()}.
	 */
	@Test
	public void testGetAllElements() {
		fail("Not yet implemented"); // TODO
	}
	@Test
	public void testGetMap() {
		final Map expected = map;
//		fail("Not yet implemented");
		assertEquals(expected, this.map.getMap());
		
	}

	@Test
	public void testSetMap() {
		final Map expected = map;
		this.map.setMap(sizeMap);
	//	fail("Not yet implemented");
		assertEquals(expected, this.map.getMap());
	}

	/**
	 * Test method for {@link model.element.Map#getWidth()}.
	 */
	@Test
	public void testGetWidth() {
		final int expected = 40;
	//	fail("Not yet implemented");
		assertEquals(expected, this.map.getWidth());// TODO
	}

	/**
	 * Test method for {@link model.element.Map#setWidth(int)}.
	 */
	@Test
	public void testSetWidth() {
		final int expected = 40;
		this.map.setWidth(expected);
		assertEquals(expected, this.map.getWidth());
	}

}
