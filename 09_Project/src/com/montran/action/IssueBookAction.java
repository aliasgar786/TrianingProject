package com.montran.action;

import java.sql.Date;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.actions.MappingDispatchAction;

import com.montran.dao.BookDAO;
import com.montran.form.IssueNewBook;
import com.montran.pojo.Book;
import com.montran.pojo.BookIssue;
import com.montran.pojo.Member;

public class IssueBookAction extends Action {
	long millis = System.currentTimeMillis();
	Date date = new Date(millis);
	Date date1 = null;
	BookDAO dao = new BookDAO();
	Book book = null;
	Member member = null;
	String message;
	String message2 ;
	int flag = 0;
	String issueStatus;
	Calendar dueDate = Calendar.getInstance();

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IssueNewBook form2 = (IssueNewBook) form;

		if (request.getParameter("issueSerialbtn") != null) {
			if (request.getParameter("issueSerialbtn").equals("Issue Serial No")) {
				int serialNo = dao.getSerialNo() + 1;
				request.setAttribute("serialNo", serialNo);
			}
			return mapping.findForward("member");
		}

		if (request.getParameter("memberbtn") != null) {
			if (request.getParameter("memberbtn").equals("Verify Member Code")) {
				if (form2.getMemberCode() != null && !"".equals(form2.getMemberCode())
						&& dao.getMember(form2.getMemberCode()) != null) {
					member = dao.getMember(form2.getMemberCode());
					request.setAttribute("member", member.getName());
					if (form2.getBookCode() != null && !"".equals(form2.getBookCode())
							&& dao.getBook(form2.getBookCode()) != null) {
						book = dao.getBook(form2.getBookCode());
						request.setAttribute("bookTitle", book.getTitle());
						request.setAttribute("bookAuthor", book.getAuthor());
						request.setAttribute("book", book);
					}
					if (member.getMemberType().equals("Student") && member.getNoOfCopiesIssued() >= 3) {
						flag = 1;
						message = "Member Student has exceeded its Books issue count";
						request.setAttribute("message", message);
					} else if (member.getMemberType().equals("Faculty") && member.getNoOfCopiesIssued() >= 25) {
						flag = 1;
						message = "Member Faculty has exceeded its book issue count";
						request.setAttribute("message", message);
					}

				} else {
					member = null;
					request.setAttribute("member", member);
				}
			}
			return mapping.findForward("member");
		}

		if (request.getParameter("bookbtn") != null) {
			if (request.getParameter("bookbtn").equals("Verify Book Code")) {
				if (form2.getBookCode() != null && !"".equals(form2.getBookCode())
						&& dao.getBook(form2.getBookCode()) != null) {
					book = dao.getBook(form2.getBookCode());
					member = dao.getMember(form2.getMemberCode());
					member = dao.getMember(form2.getMemberCode());
					request.setAttribute("member", member.getName());
					request.setAttribute("bookTitle", book.getTitle());
					request.setAttribute("bookAuthor", book.getAuthor());
					request.setAttribute("book", book);
					if (book.getIssueStatus().equals("Issuable")) {
						if (book.getIsIssued() == 0) {
							message2 = "";
							request.setAttribute("message2", message2);
							if (member.getMemberType().equals("Student")) {
								dueDate.add(Calendar.DATE, 10);
								date1 = new Date(dueDate.getTimeInMillis());
								request.setAttribute("Date", date1);
							} else {
								dueDate.add(Calendar.MONTH, 3);
								date1 = new Date(dueDate.getTimeInMillis());
								request.setAttribute("Date", date1);
							}
						} else {
							flag = 1;
							message2 = "Book already issued out";
							request.setAttribute("message2", message2);
						}
					} else {
						flag = 1;
						message2 = "Book is not issuable";
						request.setAttribute("message2", message2);
					}
				} else {

					book = null;
					request.setAttribute("book", book);
				}
			}
			return mapping.findForward("book");
		}

		if (request.getParameter("issueBookbtn") != null) {
			if (request.getParameter("issueBookbtn").equals("Issue Book")) {
				if (form2.getBookCode() != null && !"".equals(form2.getBookCode())
						&& dao.getBook(form2.getBookCode()) != null && dao.getMember(form2.getMemberCode()) != null) {
					if (flag == 0) {
						book = dao.getBook(form2.getBookCode());
						member = dao.getMember(form2.getMemberCode());
						BookIssue issue = new BookIssue();
						issue.setBook(book);
						issue.setMember(member);
						issue.setIssueDate(date);
						issue.setReturnDate(date1);
						dao.addNewBook(issue);
						issueStatus = "Book issued successfully";
						request.setAttribute("issueStatus", issueStatus);
					} else if (flag == 1) {
						issueStatus = "Failed to issue book";
						request.setAttribute("issueStatus", issueStatus);
					}
				}
			}
		}
		return mapping.findForward("success");
	}

}
