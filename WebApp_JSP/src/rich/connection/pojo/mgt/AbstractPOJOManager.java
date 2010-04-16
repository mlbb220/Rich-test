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
package rich.connection.pojo.mgt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rich.connection.ConnectionManager;

public abstract class AbstractPOJOManager {

	protected Connection getConnection() throws SQLException{
		return ConnectionManager.getDefaultConnection();
	}
	
	protected PreparedStatement getPreparedStmt(String sql) throws SQLException{
		return ConnectionManager.getDefaultConnection().prepareStatement(sql);
	}
	
	protected ResultSet querySql(String sql) throws SQLException {
		PreparedStatement pst = getPreparedStmt(sql);
		return pst.executeQuery();
	}
	
	protected int updateSql(String sql) throws SQLException {
		PreparedStatement pst = getPreparedStmt(sql);
		return pst.executeUpdate();
	}
	
	protected void closeConnection(Connection con,PreparedStatement pst) throws SQLException{
		if(pst != null){
			pst.close();
		}
		if(con != null){
			con.close();
		}
	}
}
