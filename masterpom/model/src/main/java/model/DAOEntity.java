package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Entity;

/**
 * The Class DAOEntity.
 *
 * @author Jean-Aymeric Diet
 *
 * 
 */
abstract class DAOEntity {


    /**
     * @param query
     * 			the query
     * @return connection
     */
    protected static ResultSet executeQuery(final String query) {
        return BoulderConnection.getInstance().executeQuery(query);
    }

    /**
     * Execute update.
     *
     * @param query
     *            the query
     * @return the int
     */
    protected static int executeUpdate(final String query) {
        return BoulderConnection.getInstance().executeUpdate(query);
    }

    /**
     * Prepare call.
     *
     * @param query
     *            the query
     * @return the callable statement
     */
    protected static CallableStatement prepareCall(final String query) {
        return BoulderConnection.getInstance().prepareCall(query);
    }

}
