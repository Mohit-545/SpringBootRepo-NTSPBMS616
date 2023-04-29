<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <link rel="stylesheet"
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" /> -->
			
<div class="container">			

<c:choose>
	<c:when test="${!empty empData.getContent()}">
		<h1 style="color: purple; text-align: center"><b><u>All EMPLOYEE DATA</u></b></h1>
		<table border="1" align="center", bgcolor="maroon" style="color: white; text-align: center">
			<tr> <th>EmpNo</th> <th>EmpName</th> <th>Designation</th> <th>Salary</th> <th>Department</th> <th>Edit</th> <th>Delete</th> </tr>
			<c:forEach var="emp" items="${empData.getContent()}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.sal}</td>
					<td>${emp.deptno}</td>
					<td><a href="emp_edit?no=${emp.empno}"><img src="images/edit.jpg" width="30" height="30"></a></td>
					<td><a href="emp_delete?no=${emp.empno}" onclick="return confirm('Are you sure to delete the records?')"><img src="images/delete.png" width="30" height="30"></a></td>
				</tr>
			</c:forEach>
		</table>	
		<p style="text-align:center">
			<c:if test="${!empData.isFirst()}">
				<a href="page_report?page=0"><b>first</b></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if> 
			
			<c:if test="${empData.hasPrevious()}">
				<a href="page_report?page=${empData.getNumber()-1}"><b>previous</b></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>

			<c:forEach var="i" begin="1" end="${empData.getTotalPages()}" step="1">
					<b>[<a href="page_report?page=${i-1}">${i}</a>]</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</c:forEach>

			<c:if test="${empData.hasNext()}">
				<a href="page_report?page=${empData.getNumber()+1}"><b>next</b></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${!empData.isLast()}">
				<a href="page_report?page=${empData.getTotalPages()-1}"><b>Last</b></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>

		</p>
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
</div>