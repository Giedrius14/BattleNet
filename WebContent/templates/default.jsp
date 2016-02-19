<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/static/css/main.css" />" rel="stylesheet">
<!-- <link href="<c:url value="/static/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/static/js/jquery-ui-1.11.4/jquery-ui.min.css"/>" rel="stylesheet">
 -->
<!-- BootStrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- jQuery library -->
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

<script src="<c:url value="/static/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/static/js/main.js" />"></script>
<script src="<c:url value="/static/js/jquery-1.11.2.min.js" />"></script>
<script src="<c:url value="/static/js/jquery-2.1.4.js" />"></script>
<script src="<c:url value="/static/js/jquery-ui-1.11.4/jquery-ui.min.js" />"></script>
<!-- Angular -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<title><tiles:insertAttribute name="title"></tiles:insertAttribute>
</title>
</head>
<!-- <body background="http://previews.123rf.com/images/seregam/seregam1210/seregam121000065/15585520-background-for-cooking-recipes-and-spices-on-wooden-table-Stock-Photo.jpg"
style="background-position:center; background-repeat: no-repeat;   background-size: 100%;">
<body  background="http://www.journeymancook.com/images/bg-img1.jpg"
style="background-position:center; background-repeat: no-repeat;   background-size: cover;">
 -->
 
<body  background="http://previews.123rf.com/images/karandaev/karandaev1403/karandaev140300403/26876245-Fresh-ingredients-for-cooking-pasta-tomato-cucumber-mushroom-and-spices-over-wooden-table-background-Stock-Photo.jpg"
style=" background-repeat: no-repeat;   background-size: cover;">
<div class="col-md-offset-2 col-md-8"  style="background-color: rgba(255, 255, 255, 0.8);">
<div class="header">
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
</div>

<div class="content">
	<tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>

<div class="footer">
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</div>
</body>
</html>