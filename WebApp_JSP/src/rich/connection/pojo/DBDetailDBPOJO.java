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
package rich.connection.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DBDetailDBPOJO extends AbstractDBPOJO {

	public static String DBDETAIL_DB_NAME = "dbdetail";

	private int id;
	private int states_id;
	private String name;
	private String password;
	private String ip;
	private int port;
	private String sid;
	private Date entry_date;
	private String descr;
	
	private boolean newPojo;

	public DBDetailDBPOJO() {
		newPojo = true;
	}

	public DBDetailDBPOJO(int statesId, String name, String password, String ip, int port, String sid, Date entryDate,
			boolean newPojo) {
		super();
		states_id = statesId;
		this.name = name;
		this.password = password;
		this.ip = ip;
		this.port = port;
		this.sid = sid;
		entry_date = entryDate;
		this.newPojo = newPojo;
	}
	
	public DBDetailDBPOJO(int statesId, String name, String password, String ip, int port, String sid, Date entryDate,
			String descr,boolean newPojo) {
		super();
		states_id = statesId;
		this.name = name;
		this.password = password;
		this.ip = ip;
		this.port = port;
		this.sid = sid;
		entry_date = entryDate;
		this.descr = descr;
		this.newPojo = newPojo;
	}

	public String getSid() {
		return sid;
	}

	public int getId() {
		return id;
	}

	public int getStates_id() {
		return states_id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	
	public String getDescr() {
		return descr;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	
	
	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public void load(ResultSet rs) throws SQLException {
		this.id = rs.getInt(1);
		this.states_id = rs.getInt(2);
		this.name = rs.getString(3);
		this.password = rs.getString(4);
		this.ip = rs.getString(5);
		this.port = rs.getInt(6);
		this.sid = rs.getString(7);
		this.entry_date = rs.getTimestamp(8);
		this.descr = rs.getString(9);
		newPojo = false;
	}

	@Override
	public boolean save(Connection con) throws SQLException {
		String sql;
		PreparedStatement pst;
		if (newPojo) {
			sql = "insert into " + DBDETAIL_DB_NAME
					+ "(states_id,name,password,ip,port,sid,entry_date,descr) VALUES(?,?,?,?,?,?,?,?)";
			pst = con.prepareCall(sql);
			pst.setInt(1, this.states_id);
			pst.setString(2, this.name);
			pst.setString(3, this.password);
			pst.setString(4, this.ip);
			pst.setInt(5, this.port);
			pst.setString(6, this.sid);
			pst.setTimestamp(7, new java.sql.Timestamp(this.entry_date.getTime()));
			pst.setString(8, this.descr==null?"":descr);
		} else {
			sql = "update " + DBDETAIL_DB_NAME
					+ " set states_id=?,name=?,password=?,ip=?,port=?,sid=?,entry_date=?,descr=? where id=?";
			pst = con.prepareCall(sql);
			pst.setInt(1, this.states_id);
			pst.setString(2, this.name);
			pst.setString(3, this.password);
			pst.setString(4, this.ip);
			pst.setInt(5, this.port);
			pst.setString(6, this.sid);
			pst.setTimestamp(7, new java.sql.Timestamp(this.entry_date.getTime()));
			pst.setString(8, this.descr==null?"":descr);
			pst.setInt(9, this.id);
		}
		int result = pst.executeUpdate();
		if (result == -1) {
			throw new SQLException("update fail.");
		}
		return true;

	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("id is:" + this.id + "\r\n");
		sb.append("states_id is:" + this.states_id + "\r\n");
		sb.append("name is:" + this.name + "\r\n");
		sb.append("password is:" + this.password + "\r\n");
		sb.append("ip is:" + this.ip + "\r\n");
		sb.append("port is:" + this.port + "\r\n");
		sb.append("sid is:" + this.sid + "\r\n");
		sb.append("descr is:" + this.descr + "\r\n");
		sb.append("entry_date is:" + this.entry_date + "\r\n");
		return sb.toString();
	}

}
