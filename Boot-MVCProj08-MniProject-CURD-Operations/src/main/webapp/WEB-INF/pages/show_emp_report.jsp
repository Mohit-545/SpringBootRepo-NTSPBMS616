<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty resultList}">
		<h1 style="color: purple; text-align: center"><b><u>All EMPLOYEE DATA</u></b></h1>
		<table border="1" align="center", bgcolor="maroon" style="color: white; text-align: center">
			<tr> <th>EmpNo</th> <th>EmpName</th> <th>Designation</th> <th>Salary</th> <th>Edit</th> <th>Delete</th> </tr>
			<c:forEach var="emp" items="${resultList}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.sal}</td>
					<td><a href="emp_edit?no=${emp.empno}"><img src="images/edit.jpg" width="30" height="30"></a></td>
					<td><a href="emp_delete?no=${emp.empno}" onclick="return confirm('Are you sure to delete the records?')"><img src="images/delete.png" width="30" height="30"></a></td>
				</tr>
			</c:forEach>
		</table>	
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center">EMPLOYEE NOT FOUND.......!!!</h1>
	</c:otherwise>
</c:choose>
<br><br>
	<h2 style="color: green; text-align: center"><b>${resultMsg}</b></h2>
<br>
<center>
	<a href="emp_add"><img src="images/add.png" width="120" height="120"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="./"><img src="images/home.webp" width="120" height="120"></a>
</center>