<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
	<table border="0" width="100%" height="100%">
	<tr bgcolor="blue" height="20%">
		<td colspan="3"><tiles:insertAttribute name="header"/></td>
	</tr>
	<tr height="60%">
		<td bgcolor="maroon" width="10%"><tiles:insertAttribute name="menu"/></td>
		<td width="60%"><tiles:insertAttribute name="body"/></td>
		<td width="30%"><tiles:insertAttribute name="adv"/></td>
	</tr>
	</tr>
	<tr bgcolor="cyan" style="color: maroon" height="20%">
		<td colspan="3"><tiles:insertAttribute name="footer"/></td>
	</tr>
	
	</table>
</body>
</html>