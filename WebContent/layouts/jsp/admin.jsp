<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	Admin only
	
	<table class="table table-striped">
		<tr>
			<td class="col-sm-2">Username</td>
			<td class="col-sm-1">Email</td>
			<td class="col-sm-1">Authority</td>
			<td class="col-sm-1">Enabled</td>
		</tr>
		<c:forEach var="users" items="${user}">
			<tr>
				<td><c:out value="${users.username}"></c:out></td>
				<td><c:out value="${users.email}"></c:out></td>
				<td><c:out value="${users.authority}"></c:out></td>
				<td><c:out value="${users.enabled}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	
