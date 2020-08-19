package com.montran.form;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class IssueNewBook extends ActionForm {

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (request.getParameter("memberbtn") != null) {
			if (request.getParameter("memberbtn").equals("Verify Member Code")) {
				if (getMemberCode() == null || ("".equals(getMemberCode()))) {
					errors.add("member.error", new ActionMessage("label.common.memberCode"));
				}
			}
		}
		if (request.getParameter("bookbtn") != null) {
			if (request.getParameter("bookbtn").equals("Verify Book Code")) {
				if (getBookCode() == null || ("".equals(getBookCode()))) {
					errors.add("book.error", new ActionMessage("label.common.bookCode"));
				}
			}
		}
		return errors;
	}

	private String memberCode;
	private String bookCode;

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

}
