<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color: purple; text-align: center"><b><u><sp:message code="cust.registration.title" /></u></b></h1><br><br>

<frm:form modelAttribute="cust" >
	<table border="1" align="center" bgcolor="violet" style="color:white; text-align: center">
		<tr>
			<td><b><sp:message code="cust.registration.name"/></b></td>
			<td><frm:input path="cname"/></td>
		</tr>
		<tr>
			<td><b><sp:message code="cust.registration.addrs"/></b></td>
			<td><frm:input path="caddrs"/></td>
		</tr>
		<tr>
			<td><b><sp:message code="cust.registration.billAmt"/></b></td>
			<td><frm:input path="billAmt"/></td>
		</tr>
		<tr>
			<td colspan="2 "><b><input type="submit" value="<sp:message code="cust.btn.register"/>"/></b></td>
		</tr>
	</table>
</frm:form>
<br> <br>
<p align="center">
		<a href="?lang=fr_FR">French</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="?lang=de_DE">German</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="?lang=hi_IN">Hindi</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="?lang=guj_IN">Gujrati</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="?lang=en_US">English</a> 
	</p>
<br> <br>
<center>
	<a href="./">HOME</a>
</center>