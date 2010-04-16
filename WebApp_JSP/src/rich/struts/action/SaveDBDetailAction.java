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

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import rich.connection.pojo.DBDetailDBPOJO;
import rich.connection.pojo.mgt.DBDetailManager;

public class SaveDBDetailAction extends AbstractRichAcion {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("savedbdetailid");
		boolean newPojo = false;
		String newPojoString = request.getParameter("newpojo");
		if(newPojoString != null && !newPojoString.equals("")){
			newPojo = Boolean.parseBoolean(newPojoString);
		}
		String stateIdString = request.getParameter("stateid");
		String dbdetailname = request.getParameter("dbdetailname");
		String dbdetailpassword = request.getParameter("dbdetailpassword");
		String dbdetailip = request.getParameter("dbdetailip");
		String dbdetailsid = request.getParameter("dbdetailsid");
		String dbdetaildescr = request.getParameter("dbdetaildescr");

		if (newPojo) {
			int dbdetailport = Integer.parseInt(request.getParameter("dbdetailport"));
			int stateID = 1;
			if(stateIdString != null && !stateIdString.equals("")){
				stateID = Integer.parseInt(stateIdString);
			}
			DBDetailDBPOJO pojo = new DBDetailDBPOJO(stateID, dbdetailname, dbdetailpassword, dbdetailip, dbdetailport, dbdetailsid, new Date(),dbdetaildescr, newPojo);
			if(DBDetailManager.getInstance().saveDBDetail(pojo)){
				return mapping.findForward(FORWARD_SUCCESS);
			}
			return mapping.findForward(FORWARD_FAIL);
		} else {
			if (id == null || id.equals("")) {
				request.setAttribute(MESSAGE_FAIL, "id is null or empty");
				return mapping.findForward(FORWARD_FAIL);
			}
			DBDetailDBPOJO pojo = DBDetailManager.getInstance().getDBDetailById(Integer.parseInt(id));
			pojo.setDescr(dbdetaildescr);
			if (DBDetailManager.getInstance().saveDBDetail(pojo)) {
				return mapping.findForward(FORWARD_SUCCESS);
			} else {
				return mapping.findForward(FORWARD_FAIL);
			}
		}
	}
}
