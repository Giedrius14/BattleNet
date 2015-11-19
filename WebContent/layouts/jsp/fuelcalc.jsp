<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>



<form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/calculate" >
	<div class="container">

	<div class="col-sm-6" style="background-color:lavender;">
		
	    <label for="FuelCalculator" class="col-sm-10 control-label">Fuel Calculator</label>
	  
	
		<label for="distance" class="col-sm-5 control-label">Distance:</label>
		<div class="col-sm-5">
			<input name="distance" type="text" class="form-control" value="${distance}" placeholder="Kilometres"/>
		</div>
		<label for="litersFuel" class="col-sm-5 control-label">Liters of fuel:</label>
		<div class="col-sm-5">
			<input name="litersFuel" type="text" class="form-control" value="${fuel}" placeholder="Litres"/>
		</div>
		<label for="sum" class="col-sm-8 control-label">Usage:   ${calculate} L/100km</label>

		<div class="col-sm-4">
				<button type="submit" value="Submit" onsubmit="Submit"
					class="btn btn-default">Submit</button>
			</div>
	
		</div>
		</div>
</form>
