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

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import rich.connection.pojo.mgt.DBDetailManager;

public class DeleteDBDetailAction extends AbstractRichAcion {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("dbdetailid");
		if(id == null || id.equals("")){
			request.setAttribute(MESSAGE_FAIL, "id is null or empty");
			return mapping.findForward(FORWARD_FAIL);
		}
		try {
			if ( DBDetailManager.getInstance().deleteDBDetailById(Integer.parseInt(id))) {
				return mapping.findForward(FORWARD_SUCCESS);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errormsg", "DBDetailManager delete error on " + id +" and Exception:" + e.toString());
		}
		request.setAttribute(MESSAGE_FAIL, "DBDetailManager delete error on " + id);
		return mapping.findForward(FORWARD_FAIL);
	}

}
