<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Book</title>
</head>
<body>
	<h3>Delete Book</h3>
	<hr>
	<html:form action="deleteBook" method="post">
		<table>
			<tr>
				<td>Issue Serial No</td>

				<td><html:text property="issueNo" size="20" maxlength="20"></html:text></td>
			</tr>
			<tr>
				<td></td>
				<td><html:submit>Delete Book</html:submit></td>
			</tr>
		</table>
	</html:form>
</body>
</html>