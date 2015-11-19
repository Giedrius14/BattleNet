<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" role="form" name='f'
	action="${pageContext.request.contextPath}/offers/j_spring_security_check"
	method='POST'>
	<div class="form-group">
		<label for="username" class="col-sm-2 control-label">Username</label>
		<div class="col-sm-3">
			<input type="text" name='j_username' class="form-control"
				id="username" placeholder="Username">
		</div>
	</div>
	<div class="form-group">
		<label for="Password" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-3">
			<input type="password" name='j_password' class="form-control"
				id="Password" placeholder="Password">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-2">
			<div class="checkbox">
				<label> <input type="checkbox" name='_spring_security_remember_me'> Remember me
				</label>
			</div>
		</div>
	</div> 
	<div class="form-group">
		<div class="col-sm-offset-1 col-sm-4">
			<button type="submit" type="submit" onsubmit="Login" class="btn btn-default">Sign in</button>
			
			<button type="button" class="btn btn-default" onclick="window.location.href='${pageContext.request.contextPath}/createacc'">
			Create new account</button>
		</div>
	</div>
</form>