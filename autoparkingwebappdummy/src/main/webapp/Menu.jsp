<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

	<div>
		<form id="menuId" action="">
			<h2>select your requirement</h2>
			<br>
			<input type="radio" name="menu" value="PARKING" />PARKING <br>
			<input type="radio" name="menu" value="UNPARKING" />UNPARKING <br>
			<h2>Enter your vehicle number</h2>
			<input type="text" id="vehicleNumber" /><br>
			<button type="submit" value="login">Login</button>
		</form>
		<script>
        $('#menuId').on('submit',process);
        function process(){
          
            console.log("DONE POST");
            $.post("Menu", {menu:$("input[name='menu']:checked").val(),vehicleNumber:$("#vehicleNumber").val()},function(data, status){
                console.log("DONE PO");
                $.get("DisplayServlet", function(data, status){
                	console.log(data);
                    $('#parkingdisplay').empty();
                    for( i=0; i<data.length; i++){
                    $('#parkingdisplay').append(
                            "<tr>" 
                            +"<td>"+data[i].slotNumber+"</td>"
                            +"<td>"+data[i].vehicleId+"</td>"                   
                            + "</tr>"
                    );
                    }
                });
            });
            
            return false;
        }
        </script>

	</div>
	<div>
		<table id="parkingdisplay">
			<tr>
				<td>Vehicle number</td>
				<td>Slot number</td>
			</tr>

		</table>
	</div>
</body>
</html>