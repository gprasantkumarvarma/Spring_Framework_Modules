<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<script>
$.getJSON("http://localhost:9090/spring-crm-rest/api/customers",function(data){
	var iteams= [];
	$.each(data,function(key,val){
		iteams.push("<tr>");
		iteams.push("<td id=''"+key+"''>"+val.id+"</td>");
		iteams.push("<td id=''"+key+"''>"+val.firstName+"</td>");
		iteams.push("<td id=''"+key+"''>"+val.lastName+"</td>");
		iteams.push("<td id=''"+key+"''>"+val.email+"</td>");
		iteams.push("</tr>");
		
	})
	$('<tbody/>',{html: iteams.join("")}).appendTo("table");
	
})
</script>
<body>


<div class="container">
  <h2>Basic Table</h2>
  <p>The .table class adds basic styling (light padding and horizontal dividers) to a table:</p>            
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody></tbody>
  </table>
</div>

</body>
</html>
