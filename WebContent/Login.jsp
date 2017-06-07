<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='shortcut icon' href='images/Agv.png' >
	<link rel='icon' href='images/Agv.png'>	
    <link type="text/css" rel="stylesheet" href="styles/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="styles/animate.css">
    <link type="text/css" rel="stylesheet" href="styles/all.css">
    <link type="text/css" rel="stylesheet" href="styles/main.css">
    <link type="text/css" rel="stylesheet" href="styles/style-responsive.css">
	
	
	<script type="text/javascript" src="script/jquery-1.10.2.min.js"></script>
	<script>
		$(document).ready(function(){
			
			<% int val = 1;
			if(request.getAttribute("status") != null){
					val = (Integer) request.getAttribute("status");}  %>
			
			$("#mes").hide();
			
			var status = <%= val%>;
			if(status === 0){
				$("#mes").show();
			}
			
		});
			
		
	</script>
	
	

</head>
<body style="background: url('images/2.jpg') center center fixed;">
    
    
    
	<div class="col-lg-12 col-md-12 col-sm-12 ">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="row">
				<br><br><br><br>
				<br><br><br><br>
				<br><br><br><br>
			</div>
			<div class="panel">
				<div class="panel-body">
					<h1 class="text-center">
						Login
					</h1><hr>
						<span id="mes" class="help-block text-center bg-danger"><strong>Unsername</strong> or <strong>Password</strong> is Incorrect!</span>
						<form method="post" action="Login"> 
							<input type="hidden" name="action" value="login" />
							<h4>Username : </h4>
							<div class="input-group">
						      <span class="input-group-addon"><i class="fa fa-user"></i></span>
						      <input id="username" type="text" class="form-control" name="username" required="required">
						    </div>
						    <h4>Password : </h4>
							<div class="input-group">
						      <span class="input-group-addon"><i class="fa fa-key"></i></span>
						      <input id="password" type="password" class="form-control" name="password" required="required">
						    </div>
						    <hr>
							<button id="submit" type="submit" class="btn btn-success pull-right">Login</button>
						</form>
									
				</div>
			</div>
		</div>
	</div> 
   
</body>
</html>
