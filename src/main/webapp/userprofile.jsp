<%@page import="com.HandleIT.DevObj"%>
<%@page import="com.servletpkg.DevConn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Developers</title>
</head>
<body>

	<%
		if (!(DevConn.soughtDevs.isEmpty())) {
			for (int i = 0; i < DevConn.soughtDevs.size(); i++) {
				DevObj devForTable = new DevObj();
				devForTable = DevConn.soughtDevs.get(i);
	%>
	<table>
		<tr>
			<td><%=devForTable.getFirstName()%></td>
			<td><%=devForTable.getEmailAddress()%></td>
			<td><%=devForTable.getLocation()%></td>
			<td><%=devForTable.getProfileUrl()%></td>
			<td><%=devForTable.getProjects()%></td>
			<td><%=devForTable.getSkills()%></td>
			<%
				}
			%>
		
	</table>
	<%
		}
	%>
</body>
</html>