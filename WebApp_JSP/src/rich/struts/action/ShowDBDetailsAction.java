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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import rich.connection.pojo.DBDetailDBPOJO;
import rich.connection.pojo.StatesPOJO;
import rich.connection.pojo.mgt.DBDetailManager;
import rich.connection.pojo.mgt.StatesManager;
import rich.staticvalue.StaticValues;

public class ShowDBDetailsAction extends AbstractRichAcion {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String id = request.getParameter("dbdetailid");
		if (id != null && !id.equals("")) {
			request.setAttribute("dbdetailid", id);
		}
		List<DBDetailDBPOJO> dbDetails = DBDetailManager.getInstance().getAllDBDetails();
		request.setAttribute(StaticValues.REQUEST_ATTR_DBDETAILS, dbDetails);
		
		List<StatesPOJO> states = StatesManager.getInstance().getAllStates();
		request.setAttribute(StaticValues.REQUEST_ATTR_STATES, states);
		
		return mapping.findForward(FORWARD_SUCCESS);
	}

}
