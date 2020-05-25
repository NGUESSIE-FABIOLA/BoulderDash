/**
 * 
 */
package model;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IMotionFullElement;
import model.element.Map;

/**
 * @author nodji
 *
 */
public class ModelTest {
private Map map;
	
	private IMotionFullElement character;
	
	private Model model;

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
		model = new Model(1);
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
		Map expected = map;
		// fail("Not yet implemented");
		assertEquals(expected, this.map.getMap());
	}


	/**
	 * Test method for {@link model.Model#setCharacter(contract.IMotionFullElement)}.
	 */
	@Test
	public void testSetCharacter() {
		IMotionFullElement expected = character;
		//	fail("Not yet implemented");
		assertEquals(expected, model.getCharacter());	
		//assertEquals(expected, model.getCharacter());
	}

	
}
