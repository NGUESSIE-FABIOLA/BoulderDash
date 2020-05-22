/**
 * 
 */
package model.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IMotionFullElement;

/**
 * @author nodji
 *
 */
public class ModelFacadeTest {
private Map map;
	
	private IMotionFullElement character;
	
	private ModelFacade model;

	private int List;
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
		this.map = new Map(List);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.element.ModelFacade#getMap()}.
	 */
	@Test
	public void testGetMap() {
		Map expected = map;
		fail("Not yet implemented");
		assertEquals(expected, this.map.getMap());
	}

	@Test
	public void testGetCharacter() {
		IMotionFullElement expected = character;
		fail("Not yet implemented");
		assertEquals(expected, model.getCharacter());
	}

}
