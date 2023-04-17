<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color: purple; text-align: center"><b><u>REGISTER NEW EMPLOYEE</u></b></h1><br><br>

<frm:form modelAttribute="emp">
	<table border="1" align="center" bgcolor="violet" style="color:white; text-align: center">
		<tr>
			<td><b>Employee Name ::</b></td>
			<td><frm:input path="ename"/></td>
		</tr>
		<tr>
			<td><b>Employee Designation ::</b></td>
			<td><frm:input path="job"/></td>
		</tr>
		<tr>
			<td><b>Employee Salary ::</b></td>
			<td><frm:input path="sal"/></td>
		</tr>
		<tr>
			<td><b><input type="submit" value="Register"></b></td>
			<td><b><input type="reset" value="Reset"></b></td>
		</tr>
	</table>
</frm:form>