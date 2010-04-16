/* == start of automated copyright prologue block == */
/*
 * Copyright (c) 2009 Affiliated Computer Services, Inc.
 * All rights reserved.
 * 
 * This item contains confidential and trade secret information
 * and may not be transferred, published, disclosed, reproduced,
 * or used by any party without the express written permission of
 * Affiliated Computer Services, Inc.
 */
/* == end of automated copyright prologue block == */
package rich.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	public static final int SQL_TYPE_MYSQL = 1;
	public static final int SQL_TYPE_ORACLE = 2;
	// most shared stuff.
	protected String _dbUserName;
	protected String _dbPassword;
	protected String _hostName;
	protected int _hostPort = 1433;
	protected String _dbName;
	protected static int _jdbcReadTimeoutMs = 0;
	protected String _connectString = null;
	protected static ConnectionManager _instance = new ConnectionManager();

	private ConnectionManager() {
		Properties configPro = new Properties();
		try {
			configPro.load(ConnectionManager.class.getResourceAsStream("/config/dbconfig.properties"));
			_dbUserName = configPro.getProperty("username");
			_dbPassword = configPro.getProperty("password");

			_hostName = configPro.getProperty("hostname");
			_dbName = configPro.getProperty("sid");
			_hostPort = Integer.parseInt(configPro.getProperty("port"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getDefaultConnection() throws SQLException{
		return getStaticConnection(ConnectionManager.SQL_TYPE_MYSQL);
	}
	
	protected static Connection getStaticConnection(int sqlType) throws SQLException {
		Properties prop = _instance.setConfigValues(sqlType);
		if (prop == null) {
			throw new SQLException("Not support type:" + sqlType);
		}
		return _instance.getPhysConnectionPrivate(prop);
	}

	/**
	 * sets up configuration values
	 * 
	 * @param userId
	 *            The new configValues value
	 * @param password
	 *            The new configValues value
	 * @param hostname
	 *            The new configValues value
	 * @param connectString
	 *            The new configValues value
	 * @param dbName
	 *            The new configValues value
	 * @param dbPort
	 *            The new configValues value
	 */
	public Properties setConfigValues(int sqlType) {


		Properties prop = new Properties();
		switch (sqlType) {
		case SQL_TYPE_MYSQL:
			_connectString = "jdbc:mysql://" + _hostName + ":" + _hostPort + "/" + _dbName + "?user=" + _dbUserName
					+ "&" + "password=" + _dbPassword;
			break;
		case SQL_TYPE_ORACLE:
			prop.put("user", _dbUserName);
			prop.put("password", _dbPassword);

			// Set parameters for version 8 compatibility
			prop.put("oracle.jdbc.V8Compatible", "true");
			prop.put("oracle.jdbc.J2EE13Compliant", "false");
			prop.put("oracle.jdbc.TcpNoDelay", "true");
			// Allow overriding the Oracle TCP socket read timeout 
			if (_jdbcReadTimeoutMs > 0) {
				prop.put("oracle.jdbc.ReadTimeout", "" + _jdbcReadTimeoutMs);
			}
			_connectString = "jdbc:ORACLE:thin" + ":@" + _hostName + ":" + _hostPort + ":" + _dbName;
			break;
		default:
			return null;

		}
		return prop;
	}

	/**
	 * generates a new phys connection from source maybe pooled connections?
	 * 
	 * @return The physConnection value
	 * @exception SQLException
	 *                Description of the Exception
	 */
	protected Connection getPhysConnectionPrivate(Properties prop) throws SQLException {
		Connection con = DriverManager.getConnection(_connectString, prop);
		return con;
		// ((OracleConnection) oc).setStmtCacheSize(ORACLE9_STMT_CACHE_SIZE);
	}

}
