<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<html>
	<body bgcolor="burgundy">
		<h1 style="color: white; text-align: center"><b><u>REGISTER NEW CUSTOMER</u></b></h1><br><br>
		
		<frm:form modelAttribute="cust" >
			<table border="1" align="center" bgcolor="gray" style="color:black; text-align: center">
				<tr>
					<td><b>Customer No::</b></td>
					<td><frm:input path="cno"/></td>
				</tr>
				<tr>
					<td><b>Customer Name ::</b></td>
					<td><frm:input path="cname"/></td>
				</tr>
				<tr>
					<td><b>Customer BillAmount ::</b></td>
					<td><frm:input path="billAmt"/></td>
				</tr>
				<tr>
					<td><b>Customer DOB ::</b></td>
					<td><frm:input path="dob" type="date"/></td>
				</tr>
				<tr>
					<td><b>Customer DOJ ::</b></td>
					<td><frm:input path="doj" type="date"/></td>
				</tr>
				<tr>
					<td><b>Customer DOP(Purchase) ::</b></td>
					<td><frm:input path="dop" type="datetime-local"/></td>
				</tr>
				<tr>
					<td><b>Customer TOP(Time of Purchase) ::</b></td>
					<td><frm:input path="top" type="time"/></td>
				</tr>
				
				<tr>
					<td><b><input type="submit" value="Register"></b></td>
					<td><b><input type="reset" value="Reset"></b></td>
				</tr>
			</table>
		</frm:form>
		<br> <br>
		<center>
			<h2><a href="./" style="color: white"><b>HOME</b></a></h2>
		</center>
	</body>
</html>