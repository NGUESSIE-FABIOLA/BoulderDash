/**
 * 
 */
package model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author nodji
 *
 */
public class ElementboulderTest {

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
	 * Test method for {@link model.Elementboulder#getMapHeight(int)}.
	 */
	@Test
	public void testGetMapHeight() {
		int height = 28;
		try {
			assertEquals(height, Elementboulder.getMapHeight(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link model.Elementboulder#getMapWidth(int)}.
	 */
	@Test
	public void testGetMapWidth() {
		int width = 48;
		try {
			assertEquals(width, Elementboulder.getMapWidth(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link model.Elementboulder#getMap(int)}.
	 */
	@Test
	public void testGetMap() {
		try {
			assertNotNull(Elementboulder.getMap(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
