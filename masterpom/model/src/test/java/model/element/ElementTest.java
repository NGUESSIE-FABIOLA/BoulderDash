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

import imodel.IElement;

/**
 * @author Souar
 *
 */
public class ElementTest {

	private IElement sprite;
	private IElement permeability;

	/**
	 * @throws java.lang.Exception
	 * 			exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 * 			exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 * 		exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 * 			exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSprite() {
		IElement excepted = sprite;
		
		assertEquals(excepted, this.sprite);
	}

	@Test
	public void testGetPermeability() {
		IElement excepted = permeability;
		
		assertEquals(excepted, this.permeability);
	}

	@Test
	public void testSetSprite() {
	final IElement expected = sprite;

		assertEquals(expected, this.sprite);
	}

	@Test
	public void testSetPermeability() {
		final IElement excepted = permeability;
		assertEquals(excepted, this.permeability);
	}

}
