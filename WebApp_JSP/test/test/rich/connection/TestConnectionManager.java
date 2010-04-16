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
package test.rich.connection;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import rich.connection.ConnectionManager;

public class TestConnectionManager {

	@Before
	public void setUp() {

	}

	@Test
	public void testMysql() {
		try {
			Connection con = ConnectionManager.getDefaultConnection();
			String sql = "select * from states";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.print("rs name is :" + rs.getString(1));
				System.out.print("|||rs descr is:" + rs.getString(2));
				System.out.println("|||rs descr is:" + rs.getString(3));
			}

		} catch (SQLException e) {
			fail("get connettion" + e.getMessage());
		}
	}

	
}
