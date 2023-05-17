<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>
	<h1 style="color: red; text-align: center"><b>Some Internal Problem....Inconvenience is Regretted!!!!!</b></h1>
	<hr>
	<table border="1" align="center" bgcolor="pink" style="font-weight: bold;">
		<tr>
			<td>Status</td>
			<td>${status}</td>
		</tr>
		<tr>
			<td>Timestamp</td>
			<td>${timestamp}</td>
		</tr>
		<tr>
			<td>Message</td>
			<td>${message}</td>
		</tr>
		<tr>
			<td>Type</td>
			<td>${type}</td>
		</tr>
		<tr>
			<td>Path</td>
			<td>${path}</td>
		</tr>
		<tr>
			<td>Trace</td>
			<td>${trace}</td>
		</tr>
	</table>
</body>
</html>