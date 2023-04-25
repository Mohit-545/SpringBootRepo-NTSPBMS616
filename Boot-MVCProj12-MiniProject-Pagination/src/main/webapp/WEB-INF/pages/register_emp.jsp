<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<link rel = "styleshee" type="text/css" href = css/style.css>
<script language="Javascript" src="js/validation.js">
</script>

<h1 style="color: purple; text-align: center"><b><u>REGISTER NEW EMPLOYEE</u></b></h1><br><br>

<frm:form modelAttribute="emp" onsubmit=" return doValidation(this)">
	<table border="1" align="center" bgcolor="violet" style="color:white; text-align: center">
		<tr>
			<td><b>Employee Name ::</b></td>
			<td><frm:input path="ename"/><frm:errors path="ename"/><span id = "enameErr"/></td>
		</tr>
		<tr>
			<td><b>Employee Designation ::</b></td>
			<td><frm:input path="job"/><frm:errors path="job"/><span id = "jobErr"/></td>
		</tr>
		<tr>
			<td><b>Employee Salary ::</b></td>
			<td><frm:input path="sal"/><frm:errors path="sal"/><span id = "salErr"/></td>
		</tr>
		<tr>
			<td><b>Employee Department ::</b></td>
			<td><frm:select path="deptno">
						<frm:options items="${deptNoInfo}"/>
					</frm:select><span id = "deptnoErr"/>
			</td>
		</tr>
		<tr>
			<td><b><input type="submit" value="Register"></b></td>
			<td><b><input type="reset" value="Reset"></b></td>
		</tr>
	</table>
<frm:hidden path="vflag"/>
</frm:form>
<br> <br>
<center>
	<a href="./"><img src="images/home.webp" width="120" height="120"></a>
</center>