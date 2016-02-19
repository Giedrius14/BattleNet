function focuss(x) {
	x.style.background = "#ddeeff";
}
function upperCase() {

    var x = document.getElementById("fname");

    x.value = x.value.toUpperCase();

}

function validatePass() {
  var password1 = $("#password").val();
  var password2 = $("#confirmPassword").val();

    if(password1 == password2) {
       $("#passwordError").text("Password's match") 
       .removeClass("alert alert-danger pull-left")
       .addClass("alert alert-success pull-left");
    }
    else {   	
        $("#passwordError").text("Password's dont match !")
        .addClass("alert alert-danger pull-left");
    } 
}

/*
function checkPasswordMatch() {
	var password =document.getElementById('NewPassword').valueOf();
	var confirmPassword =document.getElementById('ConfirmPassword').valueOf();
//	var password = $("#NewPassword").val();
//	var confirmPassword = $("#ConfirmPassword").val();

	if (password != confirmPassword){
		alert("do not match");
	//	$("div#CheckPasswordMatch").html("Passwords do not match!");
	}else{
		alert("match");
	//	$("div#CheckPasswordMatch").html("Passwords match.");
		}
}

$(document).ready(function() {
	$("#ConfirmPassword").keyup(checkPasswordMatch);
});
*/
/*
//test .......JSON.......
function load(){
	var text = '{ "employees" : [' +
	'{ "firstName":"John" , "lastName":"Doe" },' +
	'{ "firstName":"Anna" , "lastName":"Smith" },' +
	'{ "firstName":"Peter" , "lastName":"Jones" } ]}';
	var obj = JSON.parse(text);
	document.getElementById("numberMessages").innerHTML =
		obj.employees[1].firstName + " " + obj.employees[1].lastName; 
}
*/	
/*	$(document).ready(function(){		// veikia tik i JSP
		alert("Ready");
	});
	*/
/*function deleteMSG(result){
//alert($("#replyMessage").val());
var name= $("#name").val();
var email= $("#email").val();
var text= $("#replyMessage").val();

$.ajax({
	type: 'POST',
	url: "/offers/sendmessage",
	data: JSON.stringify({"text": text, "name": name, "email": email}),
	success: msgSent,
	error: error,
	contentType: 'application/json',
	dataType:'json'
});
}*/
function getMessages(){
    		type: 'GET',
		$.ajax({url: "/offers/getmessages",
		dataType: 'json',
		contentType: 'application/json',
		asnyc: false,
		success: updateMessageLink});
	}
function updateMessageLink(data) {
		$("#numberMessages").text(data.number);
		$("#loggedInUser").text(data.messages[0].username);
}
	


function success(){
	alert("success");
}
function successData(){
	alert("success" + data);
}
function error(e){
	alert("error");
	console.log("ERROR: ", e);
	display(e);
}
function cancelMSG(div){
	$("#replyMessage").val("")
	$( "#new_message" ).dialog( "close" );
}
function msgSent(){
	alert("Message has been sent");
	$( "#new_message" ).dialog( "close" );
}

function replyMSG(box){
//	alert($("#replyMessage").val());
	var name= $("#name").val();
	var email= $("#email").val();
	var text= $("#replyMessage").val();
	
	$.ajax({
		type: 'POST',
		url: "/offers/sendmessage",
		data: JSON.stringify({"text": text, "name": name, "email": email}),
		success: msgSent,
		error: error,
		contentType: 'application/json',
		dataType:'json'
	});
}

function getJSON(){	
			type: 'POST',
		$.ajax({url: "/offers/getmessages",
			dataType: 'json',
			asnyc: false,
			success: toTable});
		function toTable(result){
            $.each(result.messages, function test22(i, result){  
            	var button = $("<button type=\"button\" class=\"btn btn-default\">Reply</button>");
            	var button2 = $("<button type=\"button\" class=\"btn btn-default\">Delete</button>");
            	button2.click(function() {
            		$("#dialog-confirm").dialog({
            	        resizable: false,
            	        modal: true,
            	        title: "",
            	        height: 200,
            	        width: 300,
            	        buttons: {
            	            "Yes": function () {
            	            	var id=result.id;
                	    		$.ajax({
                	    			type: 'POST',
                	    			url: "/offers/deletemsg",
                	    			data: JSON.stringify({"id": id}),
                	    			contentType: 'application/json',
                	    			dataType:'json' ,
                	    			success: location.reload() 
                	    		});
            	                $(this).dialog('close');
            	                callback(true);
            	            },
            	            "No": function () {
            	                $(this).dialog('close');
            	                callback(false);
            	            }
            	        }
            	    });
            	  });
            	button.click(function() {  
    					$("#name").val(result.name);
    					$("#email").val(result.email);
    					$( "#new_message" ).dialog( "open" );
    				});
    				   $( "#new_message" ).dialog({
    					      autoOpen: false,
    					      modal: true,
    					      show: { effect: "blind", duration: 500 },
    					      hide: { effect: "explode", duration: 500 }
    					    });
            	var tr=$('<tr/>');
            	var td
            	for (i in result) {
            		td= $('<td/>');		
            		if(i==="username"){
            	    	  td.append(button).append(button2);//    button.appendTo(td);    appentTo   ideti i tapcia Cell
            		 }else{ 
            		   td.append(result[i]);
            		 }
            	    tr.append(td);
            	}       
            	 $("#message").append(tr);
            });
        };
}