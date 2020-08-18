<%@page import="java.sql.Date"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Books</title>
</head>
<body>
	<%!String member = "";
	String bookTitle = "";
	String bookAuthor = "";
	long millis = System.currentTimeMillis();
	Date date = new Date(millis);
	String date1 = "";
	String message = "";
	String message2 = "";
	int serialNo;
	String issueStatus = "";%>

	<h3>Book Issue Details</h3>
	<hr>
	<html:form action="issueBook" method="post">
		<table>
			<tr>
				<td><html:submit>Issue Serial No</html:submit></td>
				<%
					if (request.getAttribute("serialNo") != null) {
					serialNo = Integer.parseInt(request.getAttribute("serialNo").toString());
				}
				%>
				<td><%=serialNo%></td>
			</tr>
			<tr>
				<td>Member Code</td>
				<td><html:text property="memberCode" size="20" maxlength="20"></html:text></td>
				<td><html:submit>Verify Member Code</html:submit></td>
			</tr>
			<tr>
				<td>Name</td>

				<%
					if (request.getAttribute("member") != null) {
					member = request.getAttribute("member").toString();
				} else if (request.getAttribute("member") == null && request.getParameter("memberCode") != null) {
					member = "No members found";
				}
				%>
				<td><%=member%></td>
				<td>
					<%
						if (request.getAttribute("message") != null) {
						message = request.getAttribute("message").toString();
					} else if (request.getAttribute("message") == null) {
						message = "";
					}
					%> <%=message%>
				</td>
			</tr>
			<tr>
				<td>Book code</td>
				<td><html:text property="bookCode" size="20" maxlength="20"></html:text></td>
				<td><html:submit>Verify Book Code</html:submit></td>

			</tr>
			<tr>
				<td>Title</td>
				<%
					if (request.getParameter("bookCode") != null && request.getAttribute("book") == null) {
					bookTitle = "No books found";
					bookAuthor = "";
				} else if (request.getAttribute("book") != null) {
					bookTitle = request.getAttribute("bookTitle").toString();
					bookAuthor = request.getAttribute("bookAuthor").toString();
				}
				%>
				<td><%=bookTitle%></td>
				<td>
					<%
						if (request.getAttribute("message2") != null) {
						message2 = request.getAttribute("message2").toString();
					} else if (request.getAttribute("message2") == null) {
						message2 = "";
					}
					%> <%=message2%>
				</td>
			</tr>
			<tr>
				<td>Author</td>
				<td><%=bookAuthor%></td>
			</tr>
			<tr>
				<td>Date of Issue</td>
				<td><%=date%></td>
			</tr>
			<tr>
				<td>Due Date</td>
				<td>
					<%
						if (request.getAttribute("Date") != null) {
						date1 = request.getAttribute("Date").toString();
					} else if (request.getAttribute("Date") == null) {
						date1 = "";
					}
					%> <%=date1%></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><html:submit>Issue Book</html:submit></td>
				<td>
					<%
						if (request.getAttribute("issueStatus") != null) {
						issueStatus = request.getAttribute("issueStatus").toString();
					} else if (request.getAttribute("issueStatus") == null) {
						issueStatus = "";
					}
					%> <%=issueStatus%></td>
			</tr>
		</table>
	</html:form>
</body>
</html>