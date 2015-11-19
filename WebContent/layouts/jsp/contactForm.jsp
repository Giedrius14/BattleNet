<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!--
<sf:form method="post" commandName="message">
	
	<input name="_flowExecutionKey" value="${flowExecutionKey}" type="hidden" />
	<input name="_eventId" value="send" type="hidden" />
	
	<table class="form">
		<tr>
			<td class="label">Your name:</td>
			<td><sf:input onfocus="focuss(this)" path="name" value="${fromUser.name}" type="text" /><br />
				<div class="error">
					<sf:errors path="name" cssClass="error"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Your email:</td>
			<td><sf:input onfocus="focuss(this)" path="email" value="${fromUser.email}" type="text" /><br />
				<div class="error">
					<sf:errors path="email" cssClass="error"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Subject:</td>
			<td><sf:input onfocus="focuss(this)" path="subject" type="text" /><br />
				<div class="error">
					<sf:errors path="subject" cssClass="error"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Your message:</td>
			<td><sf:textarea onfocus="focuss(this)" path="content" type="text" /><br />
				<div class="error">
					<sf:errors path="content" cssClass="error"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td></td>
			<td><input value="Submit" type="submit" /></td>
		</tr>
	</table>
</sf:form>
-->
<sf:form class="form-horizontal" role="form" method="post" id="messageForm" commandName="message">
		<input name="_flowExecutionKey" value="${flowExecutionKey}" type="hidden" />
	<input name="_eventId" value="send" type="hidden" />
	<div class="form-group">
	
		<label for="name" class="col-sm-2 control-label">Your name:</label>
		<div class="col-sm-4">
			<sf:input value="${fromUser.name}" name="name" id="name" path="name" type="text" class="form-control" />
			<sf:errors cssClass="alert alert-danger pull-left" path="name" />
		</div>
		
		<label for="email" class="col-sm-2 control-label">Your email:</label>
		<div class="col-sm-4">
			<sf:input value="${fromUser.email}" name="email" id="email" path="email" type="text" class="form-control" />
			<br/>
			<sf:errors cssClass="alert alert-danger pull-left" path="email" />
		</div>
		
		<label for="subject" class="col-sm-2 control-label">Subject:</label>
		<div class="col-sm-4">
			<sf:input name="subject" id="subject" path="subject" type="text" class="form-control" />
			<sf:errors cssClass="alert alert-danger pull-left" path="subject" />
		</div>
		
		<label for="content" class="col-sm-2 control-label">Message:</label>
		<div class="col-sm-4">
			<sf:textarea name="content" id="content" path="content" type="text" class="form-control" />
			<sf:errors cssClass="alert alert-danger pull-left" path="content" />
		</div>


			<div class="col-sm-10">
				<button type="submit" value="Submit" onsubmit="Submit"
					class="btn btn-default">Submit</button>
			</div>
	
		</div>
</sf:form>
