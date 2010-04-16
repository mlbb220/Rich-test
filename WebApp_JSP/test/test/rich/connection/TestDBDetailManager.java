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

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import rich.connection.pojo.DBDetailDBPOJO;
import rich.connection.pojo.mgt.DBDetailManager;

public class TestDBDetailManager {

	@Before
	public void setUp() {

	}

	@Test
	public void insertDBDetailDBPOJO() {
		DBDetailDBPOJO pojo = new DBDetailDBPOJO(1, "name", "password", "ip", 3306, "sid", new Date(), true);
		try {
			Assert.assertTrue(DBDetailManager.getInstance().saveDBDetail(pojo));
		} catch (SQLException e) {
			fail("get connettion" + e.getMessage());
		}
	}

	@Test
	public void getAllDBDetailDBPOJO() {
		try {
			List<DBDetailDBPOJO> dbs = DBDetailManager.getInstance().getAllDBDetails();
			for (Object object : dbs) {
				System.out.println(object);
			}

		} catch (SQLException e) {
			fail("get connettion" + e.getMessage());
		}
	}

	@Test
	public void getDBDetailDBPOJOById() {
		try {
			List<DBDetailDBPOJO> dbs = DBDetailManager.getInstance().getAllDBDetails();
			if (dbs.size() > 0) {
				DBDetailDBPOJO pojo = DBDetailManager.getInstance().getDBDetailById(dbs.get(0).getId());
				System.out.println(pojo);
			} else {
				System.out.println("there is not enough pojo");
			}
		} catch (SQLException e) {
			fail("get connettion" + e.getMessage());
		}
	}

	@Test
	public void updateDBDetailDBPOJO() {
		try {
			List<DBDetailDBPOJO> dbs = DBDetailManager.getInstance().getAllDBDetails();
			if (dbs.size() > 0) {
				DBDetailDBPOJO pojo = DBDetailManager.getInstance().getDBDetailById(dbs.get(0).getId());
				pojo.setDescr("only for test descr");
				DBDetailManager.getInstance().saveDBDetail(pojo);
			} else {
				System.out.println("there is not enough pojo");
			}
		} catch (SQLException e) {
			fail("get connettion" + e.getMessage());
		}
	}

	@Test
	public void deleteDBDetailDBPOJO() {
		try {
			List<DBDetailDBPOJO> dbs = DBDetailManager.getInstance().getAllDBDetails();
			if (dbs.size() > 0) {
				int id = dbs.get(0).getId();
				System.out.println("will delete "+ id);
				Assert.assertTrue(DBDetailManager.getInstance().deleteDBDetailById(id));
			} else {
				System.out.println("there is not enough pojo");
			}
		} catch (SQLException e) {
			fail("get connettion" + e.getMessage());
		}
	}
}
