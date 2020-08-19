package com.montran.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookDAO;
import com.montran.form.UpdateForm;
import com.montran.pojo.BookIssue;

public class UpdateBookAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UpdateForm updateForm = (UpdateForm) form;
		BookDAO dao = new BookDAO();
		BookIssue issue = new BookIssue();
	
		dao.updateBook(updateForm.getSerialNo(),updateForm.getIssueDate(),updateForm.getDueDate());

		return mapping.findForward("success");
	}
}
