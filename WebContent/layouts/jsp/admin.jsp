<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js"  -->
<!-- 
<html ng-app="helloApp">
<body ng-controller="CompanyCtrl">
<script >
var helloApp = angular.module("helloApp", []);
helloApp.controller("HttpController", [ '$scope', '$http',
	function($scope, $http) {
		$http({
			method : 'GET',
			url : '/admin'
		}).success(function(data, status, headers, config) {
		    alert( "ok");
			$scope.profiles = data;
		}).error(function(data, status, headers, config) {
			alert( "failure");
		});
} ]);


/*
var helloApp = angular.module("helloApp", []);
helloApp.controller("CompanyCtrl", function($scope) {
$scope.companies = [
                    { 'name':'Infosys Technologies',
                    	'employees': 125000,
                    	'headoffice': 'Bangalore'},
                    	{ 'name':'Cognizant Technologies',
	                    	'employees': 100000,
	                    	'headoffice': 'Bangalore'},
	                    	{ 'name':'Wipro',
		                    	'employees': 115000,
		                    	'headoffice': 'Bangalore'},
		                    	{ 'name':'Tata Consultancy Services (TCS)',
			                    	'employees': 150000,
			                    	'headoffice': 'Bangalore'},
			                    	{ 'name':'HCL Technologies',
				                    	'employees': 90000,
				                    	'headoffice': 'Noida'},
                    ];
$scope.addRow = function(){		
	$scope.companies.push({ 'name':$scope.name, 'employees': $scope.employees, 'headoffice':$scope.headoffice });
	$scope.name='';
	$scope.employees='';
	$scope.headoffice='';
};
});*/
</script>

-->
	<H3>Admin only</H3>

	<table class="table table-striped" style="background-color:white">
		<thead style="background-color:#D2EAF6">
			<th class="col-sm-2">Username</th>
			<th class="col-sm-1">Email</th>
			<th class="col-sm-1">Authority</th>
			<th class="col-sm-1">Enabled</th>
		</thead>
		<c:forEach var="users" items="${user}">
			<tr>
				<td><c:out value="${users.username}"></c:out></td>
				<td><c:out value="${users.email}"></c:out></td>
				<td><c:out value="${users.authority}"></c:out></td>
				<td><c:out value="${users.enabled}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	
<!-- 
	Angular table
	<table class="table table-striped" style="background-color:white">
	<tr>
		<th>Name
		</th>
		<th>Employees
		</th>
		<th>Head Office
		</th>
	</tr>
	<tr ng-repeat="company in companies">
		<td>{{company.name}}
		</td>
		<td>{{company.employees}}
		</td>
		<td>{{company.headoffice}}
		</td>
	</tr>
</table>
 -->