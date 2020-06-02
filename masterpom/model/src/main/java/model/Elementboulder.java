package model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.element.ElementFactory;
import model.element.Map;
import model.element.motionfull.Diamond;
import model.element.motionfull.Monster;
import model.element.motionfull.Rock;

/**
 * The Class DAOHelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
public class Elementboulder extends DAOEntity {

	/**The char array which constitute the map*/
//	char[][] map;
	
	/** The sql map by id. */
	private static String sqlMapById = "{call getMapByID(?)}";

	//private static int idColumnIndex = 1;

	private static int widthColumnIndex = 2;

	private static int heightColumnIndex = 3;

	private static int mapColumnIndex = 4;

	
	public static Map getMapById(final int id) throws SQLException, IOException {
		final CallableStatement callStatement = prepareCall(sqlMapById);
		callStatement.setInt(1, id);
		int width = 0;
		int height = 0;
		Map tempMap = null;

		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				width = result.getInt(widthColumnIndex);
				height = result.getInt(heightColumnIndex);
				
					try {
						Elementboulder.testCorrectLevel(width, height, result.getString(mapColumnIndex));
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.exit(0);
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				tempMap = new Map(width, height, new IElement[width][height]);

				Elementboulder.placePawnsOnMap(result, tempMap, width);
			} else {
				System.out.println("Could not find map");
				System.exit(1);
			}
			result.close();
		}
		return tempMap;
	}

	private static void testCorrectLevel(int width, int height, String mapString) throws Exception {
		// TODO Auto-generated method stub
		if(width * height + height != mapString.length())
			throw new Exception("Level is not good >:( x:" + width + " y: " + height + " size: " + mapString.length());
	
	}
	

	private static void placePawnsOnMap(ResultSet result, Map tempMap, int width) throws IOException, SQLException {
		// TODO Auto-generated method stub
		int currentXToWrite = 0;
		int currentYToWrite = 0;
		boolean skipNext = false;

		for (char c : result.getString(mapColumnIndex).toCharArray()) {
			if (!skipNext) {
				// Adding map element, if pawn, adding dug dirt
				tempMap.setOnTheMapXY(currentXToWrite, currentYToWrite, ElementFactory.getFromFileSymbol(c));

				// Now let's check if the element to insert is an IMobile
				// (boulder, diamond..)
				if (c == 'O')
					tempMap.addPawn(new Rock(currentXToWrite, currentYToWrite, tempMap));
				else if (c == 'V') {
					tempMap.addPawn(new Diamond(currentXToWrite, currentYToWrite, tempMap));
					tempMap.addDiamondCount();
				} else if (c == 'M') {

					tempMap.addPawn(new Monster(currentXToWrite, currentYToWrite, tempMap));
				}
				currentXToWrite++;
			} else {
				skipNext = false;
			}
			// If we get to the carriage return character
			if (currentXToWrite % width == 0 && currentXToWrite != 0) {
				currentXToWrite = 0;
				currentYToWrite++;
				skipNext = true;
			}
		}
	}





	/*public static int getMapHeight(int level) throws SQLException {
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

	
	public static char[][] getMap(int level) throws SQLException {
		int width = getMapWidth(level);
		int height = getMapHeight(level);
		char[][] map = new char[width][height];
		CallableStatement callStatement = prepareCall(getMap2);
		callStatement.setInt(1, level);
			for(int y =0; y<height; y++){
				for(int x=0; x<width; x++){
				//CallableStatement callStatement = prepareCall(getMap);
				//callStatement.setInt(1, level);
				//callStatement.setInt(2, x);
				//callStatement.setInt(3, y);
				
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

	
	@Deprecated
	public static void saveMapSize(int level, int height, int width) throws SQLException{
		CallableStatement callStatement = prepareCall(saveMapSize);
		callStatement.setInt(1, level);
		callStatement.setInt(2, height);
		callStatement.setInt(3, width);
		
		callStatement.execute();
			
	}
	
	
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
	

	 //only used to push the maps in the database
	public static void saveMap(char[][] map, int level, int height, int width) {
				
		try{
		Connection cn = BoulderConnection.getInstance().getConnection();
		java.sql.Statement st = BoulderConnection.getInstance().getStatement();
		
		

			String setNbLigneEtColone ="INSERT INTO `infolevel`(`Level`, `Height`, `Width`) VALUES ("+level+"," + width + ", " + height + ")";
			st.executeUpdate(setNbLigneEtColone);

			String elements = "";
			for (int i = 0; i < width; i++) {
				//System.out.println(elements);
				for (int j = 0; j < height; j++) {
					elements+=map[i][j];
				}
			}
			System.out.println(elements);*/
			/*String setElement = "INSERT INTO `level2`(`levelNum`, `linenum`,`elements`) VALUES ("+level+ ", " + (i + 1) + ", \"" + elements + "\")";
			Statement st2 = cn.createStatement();
			st2.executeUpdate(setElement);*/
			
	/*	} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
}
