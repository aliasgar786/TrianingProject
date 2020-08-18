package com.montran.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookDAO;
import com.montran.form.DeleteBookForm;
import com.montran.pojo.BookIssue;

public class DeleteBook extends Action{
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	DeleteBookForm bookForm=(DeleteBookForm)form;
	BookDAO dao=new BookDAO();
	dao.getIssueBook(bookForm.getIssueNo());
	
	return mapping.findForward("success");
}
}
