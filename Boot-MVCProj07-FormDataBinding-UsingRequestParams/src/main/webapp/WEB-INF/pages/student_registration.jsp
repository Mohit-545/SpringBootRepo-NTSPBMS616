<%@taglib uri = "http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:red; text-align: center">Student's Registration Form</h1>
<br>

<frm:form modelAttribute="st">
	<table border="0" align="center" bgcolor="maroon" style="color:white; text-align: center">
		<tr>
			<td>Student No ::</td>
			<td><frm:input path="sno"/></td>
		</tr>
		<tr>
			<td>Student Name ::</td>
			<td><frm:input path="sname"/></td>
		</tr>
		<tr>
			<td>Student Address ::</td>
			<td><frm:input path="address"/></td>
		</tr>
		<tr>
			<td>Student Average ::</td>
			<td><frm:input path="avg"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="register"></td>
		</tr>
	</table>
</frm:form>