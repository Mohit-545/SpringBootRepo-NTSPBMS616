<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color: purple; text-align: center"><b><u>REGISTER NEW JOB SEEKER</u></b></h1><br><br>

<frm:form modelAttribute="js" enctype="multipart/form-data">
	<table border="1" align="center" bgcolor="violet" style="color:white; text-align: center">
		<tr>
			<td><b>Job Seeker Name ::</b></td>
			<td><frm:input path="jsdName"/></td>
		</tr>
		<tr>
			<td><b>Job Seeker Address ::</b></td>
			<td><frm:input path="jsdAddrs"/></td>
		</tr>
		<tr>
			<td><b>Job Seeker resume ::</b></td>
			<td><frm:input type="file" path="resume"/></td>
		</tr>
		<tr>
			<td><b>Job Seeker Photo ::</b></td>
			<td><frm:input type="file" path="photo"/></td>
		</tr>
		<tr>
			<td><b><input type="submit" value="Register"></b></td>
			<td><b><input type="reset" value="Reset"></b></td>
		</tr>
	</table>
</frm:form>
<br> <br>
<center>
	<h2><a href="./" style="color: purple; text-decoration: none;">HOME</a></h2>
</center>