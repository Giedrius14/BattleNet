<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<script>
$(document).ready(function(){
    $("#startCreate").click(function(){ $( "#createRecipe" ).dialog( "open" );});
									    $( "#createRecipe" ).dialog({autoOpen: false,width: 800, height: "auto" ,modal: true, autoResize:true,
										      show: { effect: "blind", duration: 500 },
										      hide: {effect: "explode", duration: 500}
										    });		
	var rowIndex=0;					    
    $("#add_row").click(function(){
		rowIndex++;
		         $('#ingredientsList').append(        
		         '<tr id="ingredientsListRow" ><td><input id="ingredients_name" name="ingredients['+ rowIndex+'].name" type="text" class="col-sm-12"></td>'+
	                '<td><input id="ingredients_amount" name="ingredients['+ rowIndex+'].amount" type="text" class="col-sm-12"></td>'+
	                '<td><input id="ingredients_units" name="ingredients['+ rowIndex+'].units" type="text" class="col-sm-12"></td></tr>'
	                )
    });
});
/*
 $(function(){
    
    $("table tr").click(function(){
        var value=$(this).closest('tr').children('td:first').text();
        $.ajax({
        url: "/offers/openrecipes",
		type: 'GET',
		data: JSON.stringify({"id": value}),
		success: post,
		error: error,
		contentType: 'application/json',
		dataType:'json'  
			});
    	});
    }); 
 */

 $(function(){
     
     $("#tableRecipes tr").click(function(){
         var value=$(this).closest('tr').children('td:first').text();
         $.ajax({
     	type: 'POST',
        url: "/offers/openrecipes",
        data: JSON.stringify({"id": value}),
 		success: post,
 		error: error,
 		contentType: 'application/json',
 		dataType:'json'  
 			});
     	});
     }); 

function post(data){
    
    $("#openRecipe").dialog({
	    autoOpen : true,
	    width : 800,
	    height : "auto",
	    modal : true,
	    autoResize : true,
	    show : {effect : "blind",duration : 500},
	    hide : {effect : "fade",duration : 500},
	    success: populate(data)
	});

    function populate(result){
		$("#title").html("Recepe: "+result.name +" made by: "+ result.user.name);
		$("#making").html("Description: "+result.description);	
	

		    $.each( result.ingredients, function( key, value ) {
			  $.each( value, function( key, value ) {
				$("#ingredients").append(key +":"+ value+" |");
				});
			  $("#ingredients").append("<br/>");
			});
		
		}
    }
</script>



<h4 style="display: inline-block;">Sukurti recepta:</h4>
<a id="startCreate" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-success"> <i class="glyphicon glyphicon-edit"></i></a>


<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-lg-offset-3 toppad">
			<div id="openRecipe" hidden="true" class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title" id="title" >Pavadinimas:   </h3>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-3 col-sm-3 " align="right">
							<img alt="User Pic" src="http://static2.businessinsider.com/image/51f03f966bb3f73c7700000b/19-fast-food-hacks-that-will-change-the-way-you-order.jpg" class="img-circle img-responsive">
						</div>
						<div id="ingredients" class=" col-lg-8 col-sm-6 ">
						</div>	
					</div>
					<div class="well" id="making">Gaminimo eiga:</div>
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

<table id="tableRecipes" class="table table-hover" style="background-color:white">
	<tr style="background-color:#D2EAF6">
		<th class="col-xs-1" rowspan="1">id</th>
		<th class="col-sm-6" rowspan="1">Pavadinimas</th>
		<th class="col-sm-2" rowspan="1">Kieno receptas:</th> 
	</tr>
	<c:forEach var="recipe" items="${recipes}">
		<tr>
			<td><c:out value="${recipe.recipeId}"></c:out></td>
			<td><c:out value="${recipe.name}"></c:out></td>
			<td><c:out value="${recipe.user.username}"></c:out>
		<!--	<a href="${pageContext.request.contextPath}/createrecipe" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-xs btn-warning">
			<i class="glyphicon glyphicon-edit"></i></a>   -->
			
			</td>
		</tr>
	</c:forEach>
</table>



<div id ="createRecipe" class="container" hidden="true">
<sf:form class="form" method="post" action="${pageContext.request.contextPath}/createrecipe" commandName="recipes">
    <div class="row">
        <div class="col-xs-12">
			<p><label for="name">Name: </label> <input name="name" id="name" name="name" class="form-control custom-control"></input></p>
		</div>
    </div>
    <div class="row">
        <div class="col-md-4">
	        <p>
				<label for="description">description: </label> <br>
				<textarea class="form-control custom-control" rows="2" name="description" id="description"></textarea>
			</p>
        </div>
        <div class="col-md-7">
        	<table id="ingredientsList" class="table table-striped">
			<thead>
				<tr>
					<th>Pavadinimas</th>
					<th>Kiekis</th>
					<th>Vienetai</th>
				</tr>
			</thead>
			<tbody>
				<tr id="ingredientsListRow">
					<td><input id="ingredients_name" name="ingredients[0].name" type="text" class="col-sm-12"></td>
					<td><input id="ingredients_amount" name="ingredients[0].amount" type="text" class="col-sm-12"></td>
					<td><input id="ingredients_units" name="ingredients[0].units" type="text" class="col-sm-12"></td>
				</tr>
			</tbody>
		</table>
        </div>
        <div class="col-md-1">
        	<a id="add_row" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-success"> <i
			class="glyphicon glyphicon-plus"></i></a>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
			<p>
				<button type="submit" name="create" value="Create" class="btn btn-default" onclick="$('#callbackrequest').submit()">Create</button>
			</p>
		</div>
    </div>
    </sf:form>
</div>