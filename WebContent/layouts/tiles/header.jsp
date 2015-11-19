<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="<c:url value='/'/>">Skelbimai / Home</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<li><sec:authorize access="hasRole('ROLE_ADMIN')">
					<a href="${pageContext.request.contextPath}/admin">Admin page</a>
				</sec:authorize></li>
			<li><a href="${pageContext.request.contextPath}/recipes">Receptai</a></li>
			<li><a href="${pageContext.request.contextPath}/fuelcalc">Fuel Calculator</a></li>
		</ul>

		<ul class="nav navbar-nav pull-right">
			<li><sec:authorize access="isAuthenticated()">
					<a href="<c:url value="/messages"/>" onmouseover="getMessages()"> Messages (<SPAN id="numberMessages">0</SPAN>)
					</a>
				</sec:authorize></li>
			<li><sec:authorize access="isAuthenticated()">
					<a href="<c:url value="/userprofile"/>"> Logged in as: <STRONG><SPAN id="loggedInUser"></SPAN></STRONG>
					</a>
				</sec:authorize></li>
			<li><sec:authorize access="!isAuthenticated()">
					<a href="<c:url value='/login'/>"> Login</a>
				</sec:authorize></li>
			<li><sec:authorize access="isAuthenticated()">
					<a href="<c:url value='/j_spring_security_logout '/>"> Logout</a>
				</sec:authorize></li>
		</ul>
	</div>

</nav>
