/**
 * 
 */
package model.element;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Observable;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IElement;
import contract.IMap;

/**
 * @author nodji
 *
 */
public class MapTest {
/*	private int height;
	private int width;
	private IElement[][] sizeMap;
	
	private Map map;
	private int List;
	private Observable observable;
	private IMap map2;
	private String name;
	private int id;
*/
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
	//	this.map = new Map(List);
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
	//	final int expected = 0;
		//fail("Not yet implemented");
	//	assertEquals(expected, this.map.getHeight());
	}

	/**
	 * Test method for {@link model.element.Map#setHeight(int)}.
	 */
	@Test
	public void testSetHeight() {
//	final int expected = 40;
//	this.map.setHeight(expected);
//	assertEquals(expected, this.map.getHeight());
	}

	/**
	 * Test method for {@link model.element.Map#getAllElements()}.
	 * @throws SQLException 
	 */
	@Test
	public void testGetAllElements() throws SQLException {
		//IMap expected = map2;
	//	fail("Not yet implemented");
	//	assertEquals(expected, this.map2.getAllElements());
	}
	
	@Test
	public void testGetElementByPosition() {
	//	IMap expected = map2;
	//	fail("Not yet implemented");
	//	assertEquals(expected, this.map2.getElementByPosition(height, width));
	}
	
	@Test
	public void testGetElementByID() {
	//	IMap expected = map2;
	//	fail("Not yet implemented");
	//	assertEquals(expected, this.map2.getElementByID(id));
	}

	@Test
	public void testGetElementByName() throws SQLException {
	//	IMap expected = map2;
		//fail("Not yet implemented");
	//	assertEquals(expected, this.map2.getElementByName(name));
	}
	
	@Test
	public void testGetMap() {
	//	final Map expected = map;
		//fail("Not yet implemented");
	//	assertEquals(expected, this.map.getMap());
		
	}

	@Test
	public void testSetMap() {
	//	final Map expected = map;
	//	this.map.setMap(sizeMap);
		//fail("Not yet implemented");
	//	assertEquals(expected, this.map.getMap());
	}

	/**
	 * Test method for {@link model.element.Map#getWidth()}.
	 */
	@Test
	public void testGetWidth() {
	//	final int expected = 0;
	//	fail("Not yet implemented");
	//	assertEquals(expected, this.map.getWidth());// TODO
	}

	/**
	 * Test method for {@link model.element.Map#setWidth(int)}.
	 */
	@Test
	public void testSetWidth() {
	//	final int expected = 40;
	//	this.map.setWidth(expected);
		//assertEquals(expected, this.map.getWidth());
	}
	
	@Test
	public void testSetMapHasChanged() {
	//	final Map expected = map;
	//	this.map.setMap(sizeMap);
		//fail("Not yet implemented");
	//	assertEquals(expected, this.map.getMap());
	}
	
	@Test
	public void testGetObservable() {
	//	Observable expected = observable;
	//	fail("Not yet implemented");
	//	assertEquals(expected, ((Map) this.observable).getObservable());
	}

}
