<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<c:choose>
	<c:when test="${!empty jsList}">
		<h1 style="color: maroon; text-align: center"><b><u>All JobSeeker's List</u></b></h1><br>
		
		<table border="1" align="center" bgcolor="maroon" style="color: white">
			<tr><th>Id</th> <th>Name</th> <th>Address</th> <th>Resume</th> <th>Photo</th> </tr>
			<tr>
				<c:forEach var="info" items="${jsList}">
					<tr>
						<td>${info.jsId}</td>
						<td>${info.jsName}</td>
						<td>${info.jsAddrs}</td>
						<td><a href="download?jsId=${info.jsId}&type=resume" style="color: white; text-decoration: none;">Download Resume</a></td>
						<td><a href="download?jsId=${info.jsId}&type=photo" style="color: white; text-decoration: none;">Download Photo</a></td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center">Records Not Found</h1>
	</c:otherwise>
</c:choose>
<br><br>

		<h2 align="center"><a href="./" style="color: maroon; text-decoration: none;">HOME</a></h2>