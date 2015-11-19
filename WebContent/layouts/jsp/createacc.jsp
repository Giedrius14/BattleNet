<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form class="form-horizontal" role="form" method="post" id="CreateUser" action="${pageContext.request.contextPath}/acccreated" commandName="user">
	<div class="form-group">
		<label for="userName" class="col-sm-2 control-label">UserName:</label>
		<div class="col-sm-3">
			<sf:input type="text" class="form-control" name="userName" id="userName" path="username" />
			<a> <sf:errors cssClass="alert alert-danger pull-left" path="username" />
			</a>
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name:</label>
		<div class="col-sm-3">
			<sf:input type="text" class="form-control" name="name" id="name" path="name" />
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-3">
			<sf:input type="text" class="form-control" name="email" id="email" path="email" />
			<a> <sf:errors cssClass="alert alert-danger pull-left" path="email" />
			</a>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-3">
			<sf:input type="text" class="form-control" name="password" id="password" path="password" onkeyup="validatePass()" />
			<a> <sf:errors cssClass="alert alert-danger pull-left" path="password" />
			</a>
		</div>
	</div>
	<div class="form-group">
		<label for="confirmPassword" class="col-sm-2 control-label">Confirm Password:</label>
		<div class="col-sm-3">
			<input type="text" class="form-control" name="confirmPassword" id="confirmPassword" onkeyup="validatePass()" /> <a id="passwordError"></a>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-5">
			<button type="submit" value="Create" onsubmit="Create" class="btn btn-default">Create</button>
		</div>
	</div>
</sf:form>