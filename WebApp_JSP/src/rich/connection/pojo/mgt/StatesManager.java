/*
 * Copyright (c) 2009 Affiliated Computer Services, Inc.
 * All rights reserved.
 * 
 * This item contains confidential and trade secret information
 * and may not be transferred, published, disclosed, reproduced,
 * or used by any party without the express written permission of
 * Affiliated Computer Services, Inc.
 */
package rich.connection.pojo.mgt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rich.connection.pojo.StatesPOJO;

public class StatesManager extends AbstractPOJOManager {

	
	private static StatesManager _instance = new StatesManager();
	
	
	private StatesManager(){
		
	}
	
	public static StatesManager getInstance(){
		return _instance;
	}
	
	
	public List<StatesPOJO> getAllStates() throws SQLException {
		String sql = "select * from " + StatesPOJO.DBDETAIL_DB_NAME + " order by id";
		ResultSet rs = querySql(sql);
		List<StatesPOJO> states = new ArrayList<StatesPOJO>();
		while (rs.next()) {
			StatesPOJO pojo = new StatesPOJO();
			pojo.load(rs);
			states.add(pojo);
		}
		return states;
	}
}
