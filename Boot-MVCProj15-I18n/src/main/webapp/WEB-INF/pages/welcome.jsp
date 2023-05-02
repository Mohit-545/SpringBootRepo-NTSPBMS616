<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="sp" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<body>
	<h1 style="color: purple; text-align: center"><b><u><sp:message code="home.title"/></u></b></h1><br><br>
	
	<center>
		<h2><a href="register" style="color: purple; text-align: center"><sp:message code="home.link"/></a></h2>
	</center>
	<br><br>
	
	<p align="center">
		<a href="?lang=fr_FR">French</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="?lang=de_DE">German</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="?lang=hi_IN">Hindi</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="?lang=guj_IN">Gujrati</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="?lang=en_US">English</a> 
	</p>
	<hr> 
	<p align="center">
		<h1><b>Current Active Locale :: ${pageContext.response.locale}</b></h1>
		<fmt:setLocale value="${pageContext.response.locale}"/>
	
		<jsp:useBean id="dt" class="java.util.Date"/>	
		
		<fmt:formatDate var="fdt" value="${dt}" type="date" dateStyle="FULL"/>
		<h2><b>Formatted Date :: ${fdt}</b></h2>
		
		<fmt:formatDate var="ftime" value="${dt}" type="time" dateStyle="FULL"/>
		<h2><b>Formatted Time :: ${ftime}</b></h2>
	
		<fmt:formatNumber var="fnum" value="100000000" type="number"/>
		<h2><b>Formatted Number :: ${fnum}</b></h2>
	
		<fmt:formatNumber var="fcur" value="5000000" type="currency"/>
		<h2><b>Formatted Number :: ${fcur}</b></h2>

		<fmt:formatNumber var="fperc" value="0.953" type="percent"/>
		<h2><b>Formatted Number :: ${fperc}</b></h2>
	</p>
	<hr>
</body>
</html>