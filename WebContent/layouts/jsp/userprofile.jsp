<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<H3>User profile</H3>

<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">Name: ${userName}</h3>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-3 col-lg-3 " align="center">
							<img alt="User Pic" src="http://us.123rf.com/450wm/kritchanut/kritchanut1401/kritchanut140100056/25251052-businessman-avatar-with-question-mark-on-his-head.jpg" class="img-circle img-responsive">
						<!-- src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png" -->
						</div>
						<div class=" col-md-9 col-lg-9 ">
							<table class="table table-user-information">
								<tbody>
									<tr>
										<td>Department:</td>
										<td>Programming</td>
									</tr>
									<tr>
										<td>Hire date:</td>
										<td>06/23/2013</td>
									</tr>
									<tr>
										<td>Date of Birth</td>
										<td>01/13/1991</td>
									</tr>

									<tr>
									<tr>
										<td>Gender</td>
										<td>Male</td>
									</tr>
									<tr>
										<td>Home Address</td>
										<td>Kaunas,Lithuania</td>
									</tr>
									<tr>
										<td>Email</td>
										<td><a href="mailto:info@support.com">email</a></td>
									</tr>
									<td>Phone Number</td>
									<td>
									555-4567-890(Mobile)
									</td>
									</tr>
								</tbody>
							</table>
							<a href="#" class="btn btn-primary">My Sales Performance</a> <a href="#" class="btn btn-primary">Team Sales Performance</a>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
					<span class="pull-right"> <a href="edit.html" data-original-title="Edit this user" data-toggle="tooltip" type="button"
						class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a> <a data-original-title="Remove this user" data-toggle="tooltip" type="button"
						class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
					</span>
				</div>
			</div>
		</div>
	</div>
</div>