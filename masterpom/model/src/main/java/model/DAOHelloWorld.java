package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import entity.HelloWorld;

/**
 * The Class DAOHelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
class DAOHelloWorld extends DAOEntity<HelloWorld> {
	public DAOHelloWorld(Connection connection) throws SQLException {
		super(connection);
		// TODO Auto-generated constructor stub
	}


	/**The char array which constitute the map*/
	char[][] map;
	
	/**Callable statement used to save the size of the map*/
	public static String saveMapSize = "{call saveMapSize(?,?,?}";
	
	/**Callable statement used to save an element of the map at given coordinates*/
	public static String saveMapElement = "{call saveMapElement(?,?,?,?)";
	
	/**Callable statement used to get the height of the map*/
	public static String mapHeightQuerry = "{call getMapHeight(?)}";
	
	/**Callable statement used to get the width of the map*/
	public static String mapWidthQuerry = "{call getMapWidth(?)}";
	
	/**Callable statement used to get an element of the map at given coordinates*/
	public static String getMap = "{call getElement(?,?,?)}";

	/**Callable statement used to get an element of the map at given coordinates*/
	public static String getMap2 = "{call getMap(?)}";
	
	/**Callable statement used to get a whole line map*/
	public static String getLine = "{call getLine(?,?)}";
	
	/**Callable statement used to save a whole line map*/
	public static String saveLine = "{call saveLine(?,?)}";
	
	/**Callable statement used to save a whole line map*/
	public static String saveMap = "{call saveMap(?,?)}";
	

	/**
	 * Gets the map's height
	 * 
	 * @param level, the wanted level
	 * @return height
	 * @throws SQLException
	 */
	public static int getMapHeight(int level) throws SQLException {
		CallableStatement callStatement = prepareCall(mapHeightQuerry);
		callStatement.setInt(1, level);
		int height=0;
		if(callStatement.execute()){
			ResultSet result = callStatement.getResultSet();
			if(result.next()){
			height = result.getInt(1);
			}
			result.close();
		}
		return height;
	}

	/**
	 * Gets the map's width
	 * 
	 * @param level, the wanted level
	 * @return width
	 * @throws SQLException
	 */
	public static int getMapWidth(int level) throws SQLException {
		CallableStatement callStatement = prepareCall(mapWidthQuerry);
		callStatement.setInt(1, level);
		int width=0;
		if(callStatement.execute()){
			ResultSet result = callStatement.getResultSet();
			if(result.next()){
			width = result.getInt(1); 
			}
			result.close();
		}
		return width;
	}

	/**
	 * Gets the whole map
	 * 
	 * @param level, the wanted level
	 * @return map
	 * @throws SQLException
	 */
	public static char[][] getMap(int level) throws SQLException {
		int width = getMapWidth(level);
		int height = getMapHeight(level);
		char[][] map = new char[width][height];
		CallableStatement callStatement = prepareCall(getMap2);
		callStatement.setInt(1, level);
			for(int y =0; y<height; y++){
				for(int x=0; x<width; x++){
				/*CallableStatement callStatement = prepareCall(getMap);
				callStatement.setInt(1, level);
				callStatement.setInt(2, x);
				callStatement.setInt(3, y);*/
				
				if(callStatement.execute()){
					ResultSet result = callStatement.getResultSet();
					if(result.next()){
						char e = result.getString(1).charAt((y)*width+x);
					map[x][y] = e;
					}
					result.close();
				}
			}
		}
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(map[j][i]);
			}
			System.out.println();
		}
		return map;
	}

	
	/**
	 * Saves the map's size
	 * 
	 * @param level
	 * @param height
	 * @param width
	 * @throws SQLException
	 */
	@Deprecated
	public static void saveMapSize(int level, int height, int width) throws SQLException{
		CallableStatement callStatement = prepareCall(saveMapSize);
		callStatement.setInt(1, level);
		callStatement.setInt(2, height);
		callStatement.setInt(3, width);
		
		callStatement.execute();
			
	}
	
	/**
	 * Saves an element at a given location 
	 * @param level
	 * @param height
	 * @param width
	 * @param element
	 * @throws SQLException
	 */
	@Deprecated
	 //I actually genuinely don't know how this worked, it shouldn't if it was the way it's now
	public static void saveMapElement(int level, int height, int width, char element) throws SQLException{
		CallableStatement callStatement = prepareCall(saveMapElement);
		
		for(int x= 1; x<=width;x++){
			for(int y =1; y<height; y++){

				callStatement.setInt(1, level);
				callStatement.setInt(2, y);
				callStatement.setInt(3, x);
				String buffer = ""+element;
				callStatement.setString(4, buffer); //there's no method to send a single char
				
				callStatement.execute();
				
			}
		}
		
		
	}
	
	
	/**
	 * Saves the map into the database
	 * 
	 * @param map
	 * @param level
	 * @param height
	 * @param width
	 */
	@Deprecated  //only used to push the maps in the database
	public static void saveMap(char[][] map, int level, int height, int width) {
				
		try{
		Connection cn = DBConnection.getInstance().getConnection();
		Statement st = DBConnection.getInstance().getStatement();
		
		

			String setNbLigneEtColone ="INSERT INTO `infolevel`(`Level`, `Height`, `Width`) VALUES ("+level+"," + width + ", " + height + ")";
			st.executeUpdate(setNbLigneEtColone);

			String elements = "";
			for (int i = 0; i < width; i++) {
				//System.out.println(elements);
				for (int j = 0; j < height; j++) {
					elements+=map[i][j];
				}
			}
			System.out.println(elements);
			/*String setElement = "INSERT INTO `level2`(`levelNum`, `linenum`,`elements`) VALUES ("+level+ ", " + (i + 1) + ", \"" + elements + "\")";
			Statement st2 = cn.createStatement();
			st2.executeUpdate(setElement);*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(HelloWorld entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(HelloWorld entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(HelloWorld entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HelloWorld find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HelloWorld find(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
