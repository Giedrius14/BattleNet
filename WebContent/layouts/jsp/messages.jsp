<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
messages

<div id="messages" class="form">

	<table id="message" class="table table-striped">
		<tr>
			<th class="col-sm-1">id</th>
			<th class="col-sm-2">subject</th>
			<th class="col-sm-2">content</th>
			<th class="col-sm-2">name</th>
			<th class="col-sm-2">email</th>
			<th class="col-sm-2"></th>
		</tr>
	</table>
</div>

<div class="form" hidden="true" id="replyBox">
	<form class="form-horizontal" method="post" id="new_message" action="/messages">
		<p>
			<label for="name">Name: </label>
			<output  name="name" id="name"></output>
		</p>
		<p>
			<label for="email">Email: </label>
			<output name="email" id="email"></output>
		</p>
		<p>
			<label for="body">Message</label>
			<textarea rows="6" name="body" id="replyMessage" cols="35"></textarea>
		</p>
		<p>
			 <button type="button" onclick="replyMSG(replyMessage)" class="btn btn-default">Send</button>
			 <button type="button" onclick="cancelMSG(replyBox)" class="btn btn-default">Cancel</button>	
	</form>
</div>
<div id="dialog-confirm" hidden="true" >Are you sure you want to delete this?</div>

<script type="text/javascript">
	getJSON();
</script>