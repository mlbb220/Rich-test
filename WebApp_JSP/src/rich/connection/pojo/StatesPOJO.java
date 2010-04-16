/*
 * Copyright (c) 2009 Affiliated Computer Services, Inc.
 * All rights reserved.
 * 
 * This item contains confidential and trade secret information
 * and may not be transferred, published, disclosed, reproduced,
 * or used by any party without the express written permission of
 * Affiliated Computer Services, Inc.
 */
package rich.connection.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatesPOJO extends AbstractDBPOJO {

	public static final String DBDETAIL_DB_NAME = "states";
	
	private int id;
	private String name;
	private String descr;
	
	private boolean newPojo = false;
	
	public StatesPOJO(){
		super();
	}
	
	public StatesPOJO(int id, String name, String descr) {
		super();
		this.id = id;
		this.name = name;
		this.descr = descr;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescr() {
		return descr;
	}

	@Override
	public void load(ResultSet rs) throws SQLException {
		this.id = rs.getInt(1);
		this.name = rs.getString(2);
		this.descr = rs.getString(3);
		newPojo = false;
	}

	@Override
	public boolean save(Connection con) throws SQLException {
		String sql;
		PreparedStatement pst;
		if (newPojo) {
			sql = "insert into " + DBDETAIL_DB_NAME
					+ "(name,descr) VALUES(?,?)";
			pst = con.prepareCall(sql);
			pst.setString(1, this.name);
			pst.setString(2, this.descr==null?"":descr);
		} else {
			sql = "update " + DBDETAIL_DB_NAME
					+ " set name=?,descr=? where id=?";
			pst = con.prepareCall(sql);
			pst.setString(1, this.name);
			pst.setString(2, this.descr==null?"":descr);
			pst.setInt(3, this.id);
		}
		int result = pst.executeUpdate();
		if (result == -1) {
			throw new SQLException("update fail.");
		}
		return true;
	}

}
