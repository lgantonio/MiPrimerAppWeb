package es.open4job.model.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GenericDAO {

	protected Connection connection = null;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public static final Logger logger = Logger.getLogger(GenericDAO.class
			.getName());

	public GenericDAO() {
	}

	public void abrirConexion() throws SQLException, ClassNotFoundException,
			NamingException {

		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		connection = ds.getConnection();

		/*
		 * try { Class.forName(driver); connection =
		 * DriverManager.getConnection(url, user, password);
		 * connection.setAutoCommit(false); } catch (ClassNotFoundException e) {
		 * logger.log(Level.SEVERE, "Exception : " + e.getMessage()); throw e; }
		 * catch (SQLException e) { logger.log(Level.SEVERE, "Exception : " +
		 * e.getMessage()); throw e; }
		 */
	}

	public void cerrarConexion() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}

}
