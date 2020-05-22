package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class BoulderConnection.
 *
 *
 * @author nodji
 *
 */
final class BoulderConnection {
	/** The instance. */
	private static BoulderConnection	INSTANCE	= null;

	/** The connection. */
	private Connection					connection;

	private java.sql.Statement 					statement;

	/**
	 * Instantiates a new DB connection.
	 */
	private BoulderConnection() {
		this.open();
	}

	/**
	 * Gets the single instance of DBConnection.
	 *
	 * @return single instance of DBConnection
	 */
	public static synchronized BoulderConnection getInstance() {
		if (BoulderConnection.INSTANCE == null) {
			BoulderConnection.INSTANCE = new BoulderConnection();
		}
		return BoulderConnection.INSTANCE;
	}
	 /**
	 * @param INSTANCE
	 */
	private static void setInstance(final BoulderConnection INSTANCE) {
	        BoulderConnection.INSTANCE = INSTANCE;
	    }

	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	private Boolean open() {
		final DBProperties dbProperties = new DBProperties();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(), dbProperties.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}


	/**
	 * @param query
	 * @return
	 */
	public ResultSet executeQuery(final String query) {
		try {
			return this.getStatement().executeQuery(query);
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * @param query
	 * @return
	 */
	public CallableStatement prepareCall(final String query) {
		try {
			return this.getConnection().prepareCall(query);
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param query
	 * @return
	 */
	public int executeUpdate(String query) {
		try {
			return this.statement.executeUpdate(query, java.sql.Statement.RETURN_GENERATED_KEYS);
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}

/**
	 * @param connection
	 */
	public void setConnection(final Connection connection) {
		this.connection = connection;
	}

	/**
	 * @return
	 */
	public java.sql.Statement getStatement() {
		// TODO Auto-generated method stub
		return this.statement;
	}
	/**
	 * @param statement
	 */
	public void setStatement(final java.sql.Statement statement) {
		this.statement = statement;
	}
}
