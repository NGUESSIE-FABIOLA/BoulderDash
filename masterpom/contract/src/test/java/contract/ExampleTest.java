/**
 * 
 */
package contract;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Heidy Kengne
 *
 */
public class ExampleTest {

    private Example example;

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
        this.example = new Example(1, "Example test");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link contract.Example#getId()}.
	 */
	@Test
	public void testGetId() {
		 final int expected = 1;
	        assertEquals(expected, this.example.getId());
	}

	/**
	 * Test method for {@link contract.Example#getName()}.
	 */
	@Test
	public void testGetName() {
		final String expected = "Example test";
        assertEquals(expected, this.example.getName());    
	}

	/**
	 * Test method for {@link contract.Example#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		 String expected = "Example test";
	        assertEquals(expected, this.example.getName());
	        expected = "Example test modified";
	        this.example.setName(expected);
	        assertEquals(expected, this.example.getName());      
	}

	/**
	 * Test method for {@link contract.Example#toString()}.
	 */
	@Test
	public void testToString() {
		  final String expected = "1 : Example test";
	        assertEquals(expected, this.example.toString());       
	}

}
