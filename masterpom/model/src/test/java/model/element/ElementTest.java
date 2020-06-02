/**
 * 
 */
package model.element;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.IElement;

/**
 * @author Souar SN
 *
 */
public class ElementTest {

	private IElement sprite;
	private IElement permeability;

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

	@Test
	public void testGetSprite() {
		IElement excepted = sprite;
		//fail("Not yet implemented"); // TODO
		assertEquals(excepted, this.sprite);
	}

	@Test
	public void testGetPermeability() {
		IElement excepted = permeability;
		//fail("Not yet implemented"); // TODO
		assertEquals(excepted, this.permeability);
	}

	@Test
	public void testSetSprite() {
	final IElement expected = sprite;
		//fail("Not yet implemented"); // TODO
//	this.sprite.getSprite();
		assertEquals(expected, this.sprite);
	}

	@Test
	public void testSetPermeability() {
		final IElement excepted = permeability;
		//fail("Not yet implemented"); // TODO
		//this.permeability.getPermeability(); //miss map to complete
		assertEquals(excepted, this.permeability);
	}

}
