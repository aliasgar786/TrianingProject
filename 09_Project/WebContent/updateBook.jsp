<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
</head>
<body>
	<h3>Update Book</h3>
	<hr>
	<html:form action="updateBook" method="post">
		<table>
			<tr>
				<td>Serial No</td>
				<td><html:text property="serialNo"></html:text></td>
				
			</tr>
			<tr>
				<td>Date of issue</td>

				<td><label for="issueDate"></label> <input type="date"
					id="issueDate" name="issueDate"></td>
			</tr>
			<tr>
				<td>Due Date</td>

				<td><label for="dueDate"></label> <input type="date"
					id="dueDate" name="dueDate"></td>
			</tr>
			<tr>
				<td></td>
				<td><html:submit>Update Entry</html:submit></td>
			</tr>
		</table>
	</html:form>
</body>
</html>