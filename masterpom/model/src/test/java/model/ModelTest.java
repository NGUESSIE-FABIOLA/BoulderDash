/**
 * 
 */
package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import imodel.IMap;
import model.element.motionfull.Hero;

/**
 * @author Souar
 *
 */
public class ModelTest {
	private IMap map;
	
	private Hero character;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	 * Test method for {@link model.Model#getMap()}.
	 */
	@Test
	public void testGetMap() {
		IMap excepted = map;
		assertEquals(excepted, this.map);
		
	}

	/**
	 * Test method for {@link model.Model#setMap(imodel.IMap)}.
	 */
	@Test
	public void testSetMap() {
		final IMap excepted = map;
		assertEquals(excepted, this.map);
	}

	/**
	 * Test method for {@link model.Model#getCharacter()}.
	 */
	@Test
	public void testGetCharacter() {
		Hero excepted = character;
		assertEquals(excepted, this.character);
	}

}
