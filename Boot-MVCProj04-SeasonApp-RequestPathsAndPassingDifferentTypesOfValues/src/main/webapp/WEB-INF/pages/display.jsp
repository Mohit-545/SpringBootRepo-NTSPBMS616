<%@ page isELIgnored="false" import="java.util.*"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
		<h1 style="color:green; text-align: center"><b>${season}</b></h1>
		<br><br>
		<!-- Simple Values output displayed to browser -->
		<h1 style="color:maroon; text-align: center"><b>Cricketer Info ::</b></h1><h2 style="color:maroon; text-align: center"><b> ${cname} &nbsp;${speciality}</b></h2>
		<br>
		<%-- <!-- Collection Values output displayed to browser -->
		<h1 style="color:maroon; text-align: center"><b>Collection Values ::</b></h1>
			<h2 style="color:maroon; text-align: center">
			<b>Different Colors :: <%=Arrays.toString((String[])request.getAttribute("favColor")) %></b><br>
				<b>Different Nicknames :: ${nickNames}</b><br>
				<b>Different Phone Numbers :: ${phoneNumbers}</b><br>
				<b>Different Id Details :: ${idDetails}</b></h2><br><br> --%>
		
		<!-- jstl library tags code -->
		<h1 style="color:maroon; text-align: center"><b>Collection Type Values ::</b></h1>
		<h2 style="color:maroon; text-align: center">Favrourite Colors :: 
		<c:forEach var="color" items="${favColor}"> 
			<b>${color}</b>
		</c:forEach> </h2>

		<h2 style="color:maroon; text-align: center">Nicknames ::
		<c:forEach var="name" items="${nickNames}"> 
			<b>${name}</b>
		</c:forEach> </h2> 

		<h2 style="color:maroon; text-align: center">Phone Numbers :: 
		<c:forEach var="phone" items="${phoneNumbers}"> 
			<b>${phone}</b>
		</c:forEach></h2> 

		<h2 style="color:maroon; text-align: center">Id Details :: 
		<c:forEach var="id" items="${idDetails}"> 
			<b>${id}</b><br>
		</c:forEach></h2> <br>
		
		<h1 style="color:maroon; text-align: center"><b>Model Class Objects Values ::</b></h1>
		<c:choose>
			<c:when test="${!empty empListInfo}">
				<table border="1" align="center" bgcolor="maroon" style="color:white; text-align:center">
					<tr><th>EmpId</th> <th>EmpName</th> <th>EmpSalary</th> <th>IsVaccinated</th></tr>
						<c:forEach var="emp" items="${empListInfo}">
							<tr>
								<td>${emp.empId}</td>
								<td>${emp.ename}</td>
								<td>${emp.salary}</td>
								<td>${emp.vaccinated}</td>
							</tr>
						</c:forEach>
				</table>
			</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">Employee Details not Found...!!!!</h1>
		</c:otherwise>
		</c:choose>
		
		<h2 style="color:purple; text-align:center"><a href = "./">HOME</a></h2>
		
</body>
</html>