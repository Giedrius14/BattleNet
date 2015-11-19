<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>



Recipes
<a href="${pageContext.request.contextPath}/fuelcalc" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning">
<i class="glyphicon glyphicon-edit"></i></a> 

<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">Patiekalas: ${recipeName}  created by: createdBy</h3>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-3 col-sm-3 " align="right">
							<img alt="User Pic" src="http://static2.businessinsider.com/image/51f03f966bb3f73c7700000b/19-fast-food-hacks-that-will-change-the-way-you-order.jpg" class="img-circle img-responsive">
						</div>
						<div class=" col-lg-3 col-sm-2 ">
							<!--<table data-url="data1.json" data-height="299" data-click-to-select="true">
							    <thead>
							        <tr>
							            <th data-field="state" data-checkbox="true"></th>
							            <th data-field="id" data-align="right">Item ID</th>
							            <th data-field="name" data-align="center">Item Name</th>
							            <th data-field="price" data-align="">Kiekis</th>
							            <th data-field="name" data-align="center">Item Name</th>
							        </tr>
							    </thead>
							</table>
							  -->
						</div>	
					</div>
					<div class="well">Gaminimo eiga: ${description}</div>
				</div>
				<div class="panel-footer">
					<a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
					<span class="pull-right"> <a href="edit.html" data-original-title="Edit this user" data-toggle="tooltip" type="button"
						class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a> 
						<a data-original-title="Remove this user" data-toggle="tooltip" type="button"
						class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
					</span>
				</div>
			</div>
		</div>
	</div>
</div>
<table class="table table-striped table-hover">
	<tr>
		<th class="col-sm-1" rowspan="2">id</th>
		<th class="col-sm-1" rowspan="2">Pavadinimas</th>
		<th class="col-sm-2" rowspan="2">Gaminimo eiga</th>
		<th class="col-sm-2" colspan="4">Igridientai</th>
		<th class="col-sm-2" rowspan="2">Kieno receptas:</th>
	</tr>
	<tr>
		<th class="col-sm-1" >Nr</th>
		<th class="col-sm-1">Pavadinimas</th>
		<th class="col-sm-2">Kiekis</th>
		<th class="col-sm-2">Vienetai</th>
	</tr>
	<c:forEach var="recipe" items="${recipes}">
		<tr>
			<td><c:out value="${recipe.id}"></c:out></td>
			<td><c:out value="${recipe.name}"></c:out></td>
			<td><c:out value="${recipe.description}"></c:out></td>
			<c:forEach var="ingredients" items="${recipe.ingredients}">
			<td><c:out value="${ingredients.id}"></c:out></td>
			<td><c:out value="${ingredients.name}"></c:out></td>
			<td><c:out value="${ingredients.amount}"></c:out></td>
			<td><c:out value="${ingredients.units}"></c:out></td>
			</c:forEach>
			<td><c:out value="${recipe.user.username}"></c:out></td>
		</tr>
	</c:forEach>
</table>

SUkurimas

<div class="form" id="replyBox">
	<sf:form class="form-horizontal" method="post" id="recipes" action="${pageContext.request.contextPath}/createrecipe">
		<p>
			<label for="name">Name: </label>
			<input  name="name" id="name" name="name"></input>
		</p>
		<p>
			<label for="ingredients">id: </label> <input name="ingredients[0].id" id="ingredients"></input>
		</p>
		<p>
			<label for="ingredients_name">Pavadinimas: </label> <input name="ingredients[0].name" id="ingredients_name"></input>
		</p>
		<p>
			<label for="ingredients_amount">Kiekis: </label> <input name="ingredients[0].amount" id="ingredients_amount"></input>
		</p>
		<p>
			<label for="ingredients_units">Vienetai: </label> <input name="ingredients[0].units" id="ingredients_units"></input>
		</p>  
		<p>
			<label for="description">description: </label> <input name="description" id="description"></input>
		</p>
		<p>
			<button type="submit" name="create" value="Create" class="btn btn-default">Create</button>
	</sf:form>
</div>