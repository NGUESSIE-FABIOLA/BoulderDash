package model.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IElement;

public class ElementTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private IElement sprite;
	private IElement permeability;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSprite() {
		IElement excepted = sprite;
		//fail("Not yet implemented"); // TODO
		assertEquals(excepted, this.sprite.getSprite());
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
	this.sprite.getSprite();
		assertEquals(expected, this.sprite.getSprite());
	}

	@Test
	public void testSetPermeability() {
		final IElement excepted = permeability;
		//fail("Not yet implemented"); // TODO
		//this.permeability.getPermeability(); miss map to complete
		assertEquals(excepted, this.permeability);
	}

}
