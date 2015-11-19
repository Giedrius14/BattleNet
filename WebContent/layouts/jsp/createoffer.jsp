<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


	<sf:form class="form" method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">
	<sf:input type="hidden" name="id" path="id"/>	

			<h3> Offer:</h3>
				
			<sf:textarea class="form-control" path="text" name="text" rows="10" cols="10" />
				<br/> 
			<sf:errors path="text" cssClass="error"></sf:errors>
			
			<button type="submit" onsubmit="Create" class="btn btn-default">Create</button>		
	
			<c:if test="${offer.id !=0}">
				<button type="submit" name="delete" value="Delete" class="btn btn-default">Delete</button>
			</c:if>
	</sf:form>
	
<!--
		<sf:form method="post" action="${pageContext.request.contextPath}/docreate"
		commandName="offer">
	<sf:input type="hidden" name="id" path="id"/>	
		<table class="form">	
			<tr>
				<td>Offer:</td>
				<td><sf:textarea onfocus="focuss(this);" class="imputtext"
						path="text" name="text" rows="10" cols="10" /><br/> <sf:errors
						path="text" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="Create" type="submit" /></td>
			</tr>
			
			<c:if test="${offer.id !=0}">
			<tr>
				<td></td>
				<td><input name="delete" value="Delete" type="submit" /></td>
			</tr>
			</c:if>
			
		</table>
	</sf:form>
	-->