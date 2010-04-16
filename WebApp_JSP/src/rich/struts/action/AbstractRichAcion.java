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
package rich.struts.action;

import org.apache.struts.action.Action;

public abstract class AbstractRichAcion extends Action {

	public static final String FORWARD_SUCCESS = "success";
	public static final String FORWARD_FAIL = "fail";
	
	public static final String MESSAGE_FAIL = "errormsg";
}
