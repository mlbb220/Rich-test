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
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DBPOJO {

	public boolean save(Connection con) throws SQLException;
	
	public void load(ResultSet rs) throws SQLException;
}
