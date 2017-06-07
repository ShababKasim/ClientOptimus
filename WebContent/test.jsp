<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

    <script src="script/jquery-1.10.2.min.js"></script>
   
   	<script>


	getAgvData();
	function getAgvData(){
		 $.ajax({
             type: 'Post',
             data:{
                 anchor : 3,
                 panchor: 3,
                 xco : 1,
                 yco : 11000,
                 type : 1,
                 operation : "Update"
             },
             url: 'NodeServlet',
             success: function(responseJson){
                 $('#val').append(responseJson);
             }
         });
	}

   	</script>
   
   
</head>
<body>
<span id="val"></span>

</body>
</html>