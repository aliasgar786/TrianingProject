package com.montran.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookDAO;
import com.montran.pojo.BookIssue;

public class BookListAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BookDAO dao = new BookDAO();

		List<BookIssue> bookList = dao.getAllIssuedBooks();
		request.setAttribute("bookList", bookList);
		
		return mapping.findForward("success");
	}
}
