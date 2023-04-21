<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<link rel = "styleshee" type="text/css" href = css/style.css>

<h1 style="color: purple; text-align: center"><b><u>UPDATE EXISTING EMPLOYEE FORM</u></b></h1><br><br>

<frm:form modelAttribute="emp">
	<table border="1" align="center" bgcolor="violet" style="color:white; text-align: center">
		<tr>
			<td><b>Employee No ::</b></td>
			<td><frm:input path="empno" readonly="true"/></td>
		</tr>
		<tr>
			<td><b>Employee Name ::</b></td>
			<td><frm:input path="ename"/><frm:errors path="ename"/></td>
		</tr>
		<tr>
			<td><b>Employee Designation ::</b></td>
			<td><frm:input path="job"/><frm:errors path="job"/></td>
		</tr>
		<tr>
			<td><b>Employee Salary ::</b></td>
			<td><frm:input path="sal"/><frm:errors path="sal"/></td>
		</tr>
		<tr>
			<td><b>Employee Department ::</b></td>
			<td><frm:select path="deptno">
						<frm:options items="${deptNoInfo}"/>
					</frm:select>
			</td>
		</tr>
		<tr>
			<td><b><input type="submit" value="Update"></b></td>
			<td><b><input type="reset" value="Reset"></b></td>
		</tr>
	</table>
</frm:form>