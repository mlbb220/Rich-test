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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rich.connection.pojo.DBDetailDBPOJO;

public class DBDetailManager extends AbstractPOJOManager{

	private static DBDetailManager _instance = new DBDetailManager();
	
	
	private DBDetailManager(){
		
	}
	
	public static DBDetailManager getInstance(){
		return _instance;
	}
	
	public List<DBDetailDBPOJO> getAllDBDetails() throws SQLException{
		String sql = "select * from "+ DBDetailDBPOJO.DBDETAIL_DB_NAME + " order by id";
		ResultSet rs = querySql(sql);
		List<DBDetailDBPOJO> dbs = new ArrayList<DBDetailDBPOJO>();
		while (rs.next()) {
			DBDetailDBPOJO pojo = new DBDetailDBPOJO();
			pojo.load(rs);
			dbs.add(pojo);
		}
		return dbs;
	}
	
	public DBDetailDBPOJO getDBDetailById(int id) throws SQLException{
		String sql = "select * from "+ DBDetailDBPOJO.DBDETAIL_DB_NAME +" where id=" +id;
		ResultSet rs = querySql(sql);
		DBDetailDBPOJO pojo = new DBDetailDBPOJO();
		if (rs.next()) {
			pojo.load(rs);
			return pojo;
		}else{
			return null;
		}

	}
	
	public boolean deleteDBDetailById(int id) throws SQLException{
		String sql = "delete from "+DBDetailDBPOJO.DBDETAIL_DB_NAME+ " where id=" +id;
		int result = updateSql(sql);
		return (result != -1);
	}
	
	public boolean saveDBDetail(DBDetailDBPOJO pojo) throws SQLException{
		Connection con = getConnection();
		return pojo.save(con);
	}
}
