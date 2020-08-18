<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book issue Details</title>
</head>
<body>
	<h3>Issued books details</h3>
	<hr>
	<table border="1">
		<tr>
			<th>Issue serial number</th>
			<th>Member code</th>
			<th>Member name</th>
			<th>Book Code</th>
			<th>Book name</th>
			<th>Date of Issue</th>
			<th>Date of return</th>
		</tr>
		<logic:iterate name="bookList" id="Books">
			<tr>
				<td><bean:write name="Books" property="issueNo" /></td>
			<td><bean:write name="Books" property="member.memberCode" /></td>
				<td><bean:write name="Books" property="member.name" /></td>
				<td><bean:write name="Books" property="book.bookCode" /></td>
				<td><bean:write name="Books" property="book.title" /></td> 
				<td><bean:write name="Books" property="issueDate" /></td>
				<td><bean:write name="Books" property="returnDate" /></td>
			</tr>
		</logic:iterate>
	</table>
	<br>
	<br>
	<a href="IssueBook.jsp">Issue New Book</a>
	<html:link action="/updateBook">Update Book</html:link>
	<a href="deleteBook.jsp">Delete Book</a>
</body>
</html>